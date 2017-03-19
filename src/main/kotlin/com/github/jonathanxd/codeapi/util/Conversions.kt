/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
 *      Copyright (c) contributors
 *
 *
 *      Permission is hereby granted, free of charge, to any person obtaining a copy
 *      of this software and associated documentation files (the "Software"), to deal
 *      in the Software without restriction, including without limitation the rights
 *      to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *      copies of the Software, and to permit persons to whom the Software is
 *      furnished to do so, subject to the following conditions:
 *
 *      The above copyright notice and this permission notice shall be included in
 *      all copies or substantial portions of the Software.
 *
 *      THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *      IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *      FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *      AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *      LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *      OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *      THE SOFTWARE.
 */
package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.Defaults
import com.github.jonathanxd.codeapi.base.FieldAccess
import com.github.jonathanxd.codeapi.base.MethodInvocation
import com.github.jonathanxd.codeapi.builder.FieldAccessBuilder
import com.github.jonathanxd.codeapi.builder.build
import com.github.jonathanxd.codeapi.common.*
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.lang.reflect.Parameter
import javax.lang.model.element.ElementKind
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.lang.model.util.Elements


// For more Conversions use CodeAPI-Conversions
// we will migrate all conversion to this sub-module (excluding TypeElement and TypeMirror to CodeType conversion).

/**
 * Convert parameter list to a list of access to these parameters.
 */
val List<CodeParameter>.access: List<CodePart>
    get() = this.map { CodeAPI.accessLocalVariable(it.type, it.name) }

/**
 * Convert Java parameter list to CodeAPI parameter list.
 */
val List<Parameter>.codeParameters: List<CodeParameter>
    get() = this.map { CodeParameter(it.type.codeType, it.name) }

/**
 * Create [MethodInvocation] from [MethodTypeSpec]
 *
 * @param invokeType Type of invocation.
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun MethodTypeSpec.toInvocation(invokeType: InvokeType, target: CodePart, arguments: List<CodePart>): MethodInvocation =
        CodeAPI.invoke(invokeType, this.localization, target, this.methodName, this.typeSpec, arguments)


/**
 * Create [MethodInvocation] from [MethodInvokeSpec]
 *
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun MethodInvokeSpec.toInvocation(target: CodePart, arguments: List<CodePart>): MethodInvocation =
        CodeAPI.invoke(this.invokeType, this.methodTypeSpec.localization, target, this.methodTypeSpec.methodName, this.methodTypeSpec.typeSpec, arguments)

/**
 * Create [MethodInvocation] from [Method]
 *
 * @param invokeType Type of invocation, if null, CodeAPI will try to infer the invocation type.
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun Method.toInvocation(invokeType: InvokeType?, target: CodePart, arguments: List<CodePart>): MethodInvocation =
        CodeAPI.invoke(invokeType ?: this.invokeType, this.declaringClass.codeType, target, this.name, TypeSpec(this.returnType.codeType, this.parameterTypes.map { it.codeType }), arguments)

/**
 * Create [ExecutableElement] from [Method]
 *
 * @param invokeType Type of invocation, if null, CodeAPI will try to infer the invocation type.
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun ExecutableElement.toInvocation(invokeType: InvokeType?, target: CodePart, arguments: List<CodePart>, elements: Elements): MethodInvocation =
        CodeAPI.invoke(invokeType ?: this.invokeType, (this.enclosingElement as TypeElement).getCodeType(elements), target, this.simpleName.toString(), TypeSpec(this.returnType.getCodeType(elements), this.parameters.map { it.asType().getCodeType(elements) }), arguments)


/**
 * Create [FieldAccess] from [Field].
 *
 * @param target Target of the field access, null (or static access) for static access.
 */
fun Field.toAccess(target: CodePart?): FieldAccess =
        FieldAccessBuilder.builder()
                .build {
                    this.localization = this@toAccess.declaringClass.codeType
                    this.target = target ?: CodeAPI.accessStatic()
                    this.type = this@toAccess.type.codeType
                    this.name = this@toAccess.name
                }

/**
 * Create [FieldAccess] from [VariableElement].
 *
 * @param target Target of the field access, null (or static access) for static access.
 */
fun VariableElement.toAccess(target: CodePart?, elements: Elements): FieldAccess =
        FieldAccessBuilder.builder()
                .build {
                    this.localization = (this@toAccess.enclosingElement as TypeElement).getCodeType(elements)
                    this.target = target ?: CodeAPI.accessStatic()
                    this.type = this@toAccess.asType().getCodeType(elements)
                    this.name = this@toAccess.simpleName.toString()
                }


/**
 * Gets the invocation type of the [Method].
 */
val Method.invokeType: InvokeType
    get() = if (Modifier.isStatic(this.modifiers)) InvokeType.INVOKE_STATIC else if (this.declaringClass.isInterface) InvokeType.INVOKE_INTERFACE else InvokeType.INVOKE_VIRTUAL

/**
 * Gets the invocation type of the [Method].
 */
val ExecutableElement.invokeType: InvokeType
    get() = if (this.modifiers.contains(javax.lang.model.element.Modifier.STATIC)) InvokeType.INVOKE_STATIC else if (this.enclosingElement.kind == ElementKind.INTERFACE) InvokeType.INVOKE_INTERFACE else InvokeType.INVOKE_VIRTUAL