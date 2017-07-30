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
package com.github.jonathanxd.codeapi.util.conversion

import com.github.jonathanxd.codeapi.*
import com.github.jonathanxd.codeapi.base.*
import com.github.jonathanxd.codeapi.base.Annotation
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.common.MethodInvokeSpec
import com.github.jonathanxd.codeapi.common.MethodTypeSpec
import com.github.jonathanxd.codeapi.factory.*
import com.github.jonathanxd.codeapi.literal.Literal
import com.github.jonathanxd.codeapi.literal.Literals
import com.github.jonathanxd.codeapi.util.codeType
import com.github.jonathanxd.codeapi.util.fromJavaModifiers
import com.github.jonathanxd.codeapi.util.getCodeType
import java.lang.reflect.*
import javax.lang.model.element.ElementKind
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.lang.model.util.Elements
import kotlin.reflect.KParameter
import kotlin.reflect.jvm.jvmErasure


/**
 * Convert parameter list to a list of access to these parameters.
 */
val List<CodeParameter>.access: List<CodeInstruction>
    get() = this.map { it.access }

/**
 * Convert Java parameter list to CodeAPI parameter list.
 */
val List<Parameter>.codeParameters: List<CodeParameter>
    get() = this.map { it.codeParameter }

/**
 * Convert parameter to access to the parameter.
 */
val Parameter.codeParameter: CodeParameter
    get() = CodeParameter(emptyList(), fromJavaModifiers(this.modifiers), this.type.codeType, this.name)

/**
 * Convert [CodeParameter] to variable access
 */
val CodeParameter.access: CodeInstruction
    get() = accessVariable(this.type, this.name)

/**
 * Gets the invocation type of the [Method].
 */
val Executable.invokeType: InvokeType
    get() = if (Modifier.isStatic(this.modifiers))
        InvokeType.INVOKE_STATIC
    else if (this.declaringClass.isInterface)
        InvokeType.INVOKE_INTERFACE
    else if (this is Constructor<*> || this.name == "<init>")
        InvokeType.INVOKE_SPECIAL
    else
        InvokeType.INVOKE_VIRTUAL

/**
 * Gets the [TypeSpec] of the [Executable].
 */
val Executable.typeSpec: TypeSpec
    get() = TypeSpec((this as? Method)?.returnType ?: Types.VOID, this.parameterTypes.toList())

/**
 * Gets the [MethodTypeSpec] of the [Executable].
 */
val Executable.methodTypeSpec: MethodTypeSpec
    get() = MethodTypeSpec(this.declaringClass, this.name, this.typeSpec)

/**
 * Gets the [MethodInvokeSpec] of the [Method].
 */
val Executable.methodInvokeSpec: MethodInvokeSpec
    get() = MethodInvokeSpec(this.invokeType, this.methodTypeSpec)

/**
 * Gets the invocation type of the [ExecutableElement].
 */
val ExecutableElement.invokeType: InvokeType
    get() = if (this.modifiers.contains(javax.lang.model.element.Modifier.STATIC))
        InvokeType.INVOKE_STATIC
    else if (this.enclosingElement.kind == ElementKind.INTERFACE)
        InvokeType.INVOKE_INTERFACE
    else if (this.kind == ElementKind.CONSTRUCTOR)
        InvokeType.INVOKE_SPECIAL
    else
        InvokeType.INVOKE_VIRTUAL


/**
 * Create [MethodInvocation] from [MethodTypeSpec]
 *
 * @param invokeType Type of invocation.
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun MethodTypeSpec.toInvocation(invokeType: InvokeType, target: CodeInstruction, arguments: List<CodeInstruction>): MethodInvocation =
        invoke(invokeType, this.localization, target, this.methodName, this.typeSpec, arguments)


/**
 * Create [MethodInvocation] from [MethodInvokeSpec]
 *
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun MethodInvokeSpec.toInvocation(target: CodeInstruction, arguments: List<CodeInstruction>): MethodInvocation =
        invoke(this.invokeType, this.methodTypeSpec.localization, target, this.methodTypeSpec.methodName, this.methodTypeSpec.typeSpec, arguments)

/**
 * Create [MethodInvocation] from [Executable]
 *
 * @param invokeType Type of invocation, if null, CodeAPI will try to infer the invocation type.
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun Executable.toInvocation(invokeType: InvokeType?, target: CodeInstruction, arguments: List<CodeInstruction>): MethodInvocation =
        com.github.jonathanxd.codeapi.factory.invoke(invokeType ?: this.invokeType, this.declaringClass.codeType, target, this.name, this.typeSpec, arguments)

/**
 * Gets [TypeSpec] of receiver [ExecutableElement]
 */
fun ExecutableElement.getTypeSpec(elements: Elements): TypeSpec =
        TypeSpec(returnType = this.returnType.getCodeType(elements),
                parameterTypes = this.parameters.map { it.asType().getCodeType(elements) })

/**
 * Gets [MethodTypeSpec] of receiver [ExecutableElement]
 */
fun ExecutableElement.getMethodTypeSpec(elements: Elements): MethodTypeSpec =
        MethodTypeSpec(localization = (this.enclosingElement as TypeElement).getCodeType(elements),
                typeSpec = this.getTypeSpec(elements),
                methodName = this.simpleName.toString())

/**
 * Gets [MethodInvokeSpec] of receiver [ExecutableElement]
 */
fun ExecutableElement.getMethodInvokeSpec(elements: Elements): MethodInvokeSpec =
        MethodInvokeSpec(invokeType = this.invokeType,
                methodTypeSpec = this.getMethodTypeSpec(elements))

/**
 * Create [ExecutableElement] from [Method]
 *
 * @param invokeType Type of invocation, if null, CodeAPI will try to infer the invocation type.
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun ExecutableElement.toInvocation(invokeType: InvokeType?, target: CodeInstruction, arguments: List<CodeInstruction>, elements: Elements): MethodInvocation =
        MethodInvocation(invokeType = invokeType ?: this.invokeType,
                target = target,
                spec = this.getMethodTypeSpec(elements),
                arguments = arguments
        )


/**
 * Create [FieldAccess] from [Field].
 *
 * @param target Target of the field access, null (or static access) for static access.
 */
fun Field.toAccess(target: CodeInstruction?): FieldAccess =
        FieldAccess.Builder.builder()
                .localization(this.declaringClass.codeType)
                .target(target ?: accessStatic())
                .name(this.name)
                .build()

/**
 * Create [FieldAccess] from [VariableElement].
 *
 * @param target Target of the field access, null (or static access) for static access.
 */
fun VariableElement.toAccess(target: CodeInstruction?, elements: Elements): FieldAccess =
        FieldAccess.Builder.builder()
                .localization((this.enclosingElement as TypeElement).getCodeType(elements))
                .target(target ?: accessStatic())
                .type(this.asType().getCodeType(elements))
                .name(this.simpleName.toString())
                .build()


/**
 * Creates an [ClassDeclaration] from receiver [Class].
 */
@Suppress("UNCHECKED_CAST")
fun <T : Any> Class<T>.toClassDeclaration(): ClassDeclaration =
        ClassDeclaration.Builder.builder()
                .modifiers(fromJavaModifiers(this.modifiers))
                .qualifiedName(this.canonicalName)
                .superClass(this.superclass)
                .implementations(this.interfaces.toList())
                .build()

/**
 * Creates an [InterfaceDeclaration] from receiver [Class].
 */
fun <T : Any> Class<T>.toInterfaceDeclaration(): InterfaceDeclaration =
        InterfaceDeclaration.Builder.builder()
                .modifiers(fromJavaModifiers(this.modifiers))
                .qualifiedName(this.canonicalName)
                .implementations(this.interfaces.toList())
                .build()


/**
 * Creates an [AnnotationDeclaration] from receiver [Class].
 */
fun <T : Any> Class<T>.toAnnotationDeclaration(): AnnotationDeclaration =
        AnnotationDeclaration.Builder.builder()
                .modifiers(fromJavaModifiers(this.modifiers))
                .qualifiedName(this.canonicalName)
                .properties(this.declaredMethods.map {
                    AnnotationProperty(Comments.Absent, emptyList(), it.returnType.codeType, it.name, it.defaultValue)
                })
                .build()


/**
 * Creates enum declaration from receiver [Class] using parameter name provider: [nameProvider].
 */
@JvmOverloads
fun <T : Any> Class<T>.toEnumDeclaration(nameProvider: (method: Method, index: Int, parameter: Parameter) -> String = { m, i, _ -> m.parameterNames[i] }): EnumDeclaration {

    val abstractMethods = this.methods.filter { Modifier.isAbstract(it.modifiers) }

    val enumEntries = this.declaredFields
            .filter { it.isEnumConstant }
            .map {
                EnumEntry.Builder.builder().name(it.name).let {
                    if (abstractMethods.isNotEmpty())
                        it.methods(abstractMethods.map { it.toMethodDeclaration { index, parameter -> nameProvider(it, index, parameter) } })
                    else it
                }.build()

            }

    return EnumDeclaration.Builder.builder()
            .modifiers(fromJavaModifiers(this.modifiers))
            .qualifiedName(this.canonicalName)
            .implementations(this.interfaces.map { it.codeType })
            .entries(enumEntries)
            .build()
}

/**
 * Creates a [EnumDeclaration] from receiver [Enum] class.
 */
fun <T : Enum<T>> Class<T>.toDeclaration() =
        this.toEnumDeclaration()

/**
 * Creates a [AnnotationDeclaration] from receiver [Annotation] class.
 */
fun Class<Annotation>.toDeclaration() =
        this.toAnnotationDeclaration()

/**
 * Creates a [ClassDeclaration] from receiver [Class] class.
 */
fun <T : Any> Class<T>.toDeclaration() =
        when {
            this.isInterface -> this.toInterfaceDeclaration()
            this.isEnum -> this.toEnumDeclaration()
            this.isAnnotation -> this.toAnnotationDeclaration()
            else -> this.toClassDeclaration()
        }


/**
 * Convert this [Class] structure to [TypeDeclaration]s (first element is the
 * input class, other elements is inner-classes).
 *
 * @param includeFields True to include fields.
 * @param includeMethods True to include methods.
 * @param includeSubClasses True to include sub classes.
 * @return [TypeDeclaration] structure from [Class].
 */
@JvmOverloads
fun <T : Any> Class<T>.toStructure(includeFields: Boolean = true, includeMethods: Boolean = true, includeSubClasses: Boolean = true): List<TypeDeclaration> {
    val list = mutableListOf<TypeDeclaration>()

    val declaration: TypeDeclaration = this.toDeclaration()

    val declarationBuilder = declaration.builder()

    if (includeSubClasses) {
        for (declaredClass in this.declaredClasses) {
            val extracted = declaredClass.toStructure(
                    includeFields = includeFields,
                    includeMethods = includeMethods,
                    includeSubClasses = includeSubClasses
            )

            list += extracted.first().builder().outerClass(declaration).build()

            if (extracted.size > 1)
                list += extracted.subList(1, extracted.size)
        }
    }

    if (includeFields) {
        declarationBuilder.fields(this.fields.map { it.toFieldDeclaration() })
    }

    if (includeMethods) {
        declarationBuilder.methods(this.declaredMethods.filter { isValidImpl(it) }.map { it.toMethodDeclaration() })
    }

    list.add(0, declarationBuilder.build())

    return list
}


/**
 * Makes the declaration [T] extend the [Class] overriding all public/protected methods
 * and invoking the super method.
 *
 * @param klass Class to extend
 * @return The declaration extending the [klass] and overriding all public/protected methods.
 */
@Suppress("UNCHECKED_CAST")
fun <T : TypeDeclaration> T.extend(klass: Class<*>): T {
    //val body = this.body.toMutable()

    val builder = this.builder()
    val type = klass.codeType

    builder.methods(this.methods + klass.methods.filter { it.isAccessibleFrom(this, true) && isValidImpl(it) }
            .map { it.toMethodDeclaration(type) })

    var declaration = builder.build()

    if (klass.isInterface) {
        val implementer = declaration as ImplementationHolder
        declaration = implementer.builder().implementations(implementer.implementations + type).build() as TypeDeclaration
    } else {
        val extender = declaration as SuperClassHolder
        declaration = extender.builder().superClass(type).build() as TypeDeclaration
    }

    return declaration as T
}

// Fields

/**
 * Convert this [Field] structure to [FieldDeclaration].
 *
 * @return [FieldDeclaration] structure from [Field].
 */
fun Field.toFieldDeclaration(): FieldDeclaration =
        FieldDeclaration.Builder.builder()
                .modifiers(fromJavaModifiers(this.modifiers))
                .type(this.type.codeType)
                .name(this.name)
                .build()

/**
 * Create access to this [Field].
 *
 * @param target Target
 * @return [VariableAccess] to this [Field]
 */
fun Field.createAccess(target: CodeInstruction?): FieldAccess =
        accessField(
                this.declaringClass.codeType,
                target ?: Defaults.ACCESS_STATIC,
                this.type.codeType,
                this.name
        )

/**
 * Create static access to this [Field].
 *
 * @return **Static** [VariableAccess] to this [Field].
 */
fun Field.createStaticAccess(): FieldAccess =
        this.createAccess(null)

// Method

/**
 * Convert this [Method] to [MethodDeclaration].
 *
 * @param nameProvider Provider of parameter names.
 * @return [MethodDeclaration].
 */
@JvmOverloads
fun Method.toMethodDeclaration(nameProvider: (index: Int, parameter: Parameter) -> String = { i, _ -> this.parameterNames[i] }): MethodDeclaration =
        MethodDeclaration.Builder.builder()
                .modifiers(fixModifiers(this.modifiers))
                .name(this.name)
                .returnType(this.returnType.codeType)
                .parameters(this.parameters.let {
                    it.mapIndexed { i, parameter ->
                        parameter(type = parameter.type, name = nameProvider(i, parameter))
                    }
                })
                .body(MutableCodeSource.create())
                .build()

/**
 * Convert this [Method] structure to [MethodDeclaration] structure invoking the super class method.
 *
 * @param superClass super class to invoke
 * @param nameProvider Provider of parameter names.
 * @return [MethodDeclaration] structure from [Method] invoking super class method.
 */
@JvmOverloads
fun Method.toMethodDeclaration(superClass: Type, nameProvider: (index: Int, parameter: Parameter) -> String = { i, _ -> this.parameterNames[i] }): MethodDeclaration =
        this.toMethodDeclaration(nameProvider).builder().body(
                MutableCodeSource.create(
                        listOf(returnValue(this.returnType,
                                com.github.jonathanxd.codeapi.factory.invoke(
                                        InvokeType.INVOKE_SPECIAL,
                                        superClass,
                                        Defaults.ACCESS_THIS,
                                        this.name,
                                        typeSpec(this.returnType, this.parameterTypes.toList()),
                                        this.codeParameters.map { it.toVariableAccess() }
                                )))
                )
        ).build()


// Constructor

/**
 * Convert this [Method] to [MethodDeclaration].
 *
 * @param nameProvider Provider of parameter names.
 * @return [MethodDeclaration].
 */
@JvmOverloads
fun <T : Any> Constructor<T>.toConstructorDeclaration(nameProvider: (index: Int, parameter: Parameter) -> String = { i, _ -> this.parameterNames[i] }): ConstructorDeclaration =
        ConstructorDeclaration.Builder.builder()
                .modifiers(fixModifiers(this.modifiers))
                .parameters(this.parameters.let {
                    it.mapIndexed { i, parameter ->
                        parameter(type = parameter.type, name = nameProvider(i, parameter))
                    }
                })
                .body(MutableCodeSource.create())
                .build()

/**
 * Convert this [Constructor] structure to [ConstructorDeclaration] structure calling super constructor with [arguments].
 *
 * @param arguments Arguments to pass to super constructor.
 * @param nameProvider Provider of parameter names.
 * @return [ConstructorDeclaration] structure from [Constructor] calling super constructor with [arguments].
 */
@JvmOverloads
fun <T : Any> Constructor<T>.toConstructorDeclaration(arguments: List<CodeInstruction>, nameProvider: (index: Int, parameter: Parameter) -> String = { i, _ -> this.parameterNames[i] }): ConstructorDeclaration =
        this.toConstructorDeclaration(nameProvider).builder().body(
                MutableCodeSource.create(
                        listOf(
                                invokeSuperConstructor(
                                        this.typeSpec,
                                        arguments
                                )
                        )
                )
        ).build()


// Parameters And Arguments
fun KParameter.toCodeParameter(): CodeParameter = parameter(type = this.type.jvmErasure.codeType, name = this.name ?: "parameter_$index")

fun Parameter.toCodeParameter(): CodeParameter = parameter(type = this.type.codeType, name = this.name)

fun KParameter.toVariableAccess() = accessVariable(this.type.jvmErasure.codeType, this.name ?: "parameter_$index")

fun Parameter.toVariableAccess() = accessVariable(this.type.codeType, this.name)

fun CodeParameter.toVariableAccess()= accessVariable(this.type, this.name)

// Any

/**
 * Convert this value to a literal
 */
fun Any.toLiteral(): Literal? {
    return when (this) {
        is Byte -> Literals.BYTE(this)
        is Short -> Literals.SHORT(this)
        is Int -> Literals.INT(this)
        is Boolean -> Literals.BOOLEAN(this)
        is Long -> Literals.LONG(this)
        is Float -> Literals.FLOAT(this)
        is Double -> Literals.DOUBLE(this)
        is Char -> Literals.CHAR(this)
        is String -> Literals.STRING(this)
        is Class<*> -> Literals.CLASS(this)
        else -> null
    }
}