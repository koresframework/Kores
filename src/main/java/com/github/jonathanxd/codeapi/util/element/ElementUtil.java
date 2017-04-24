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
package com.github.jonathanxd.codeapi.util.element;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.base.FieldAccess;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.MethodDeclarationBase;
import com.github.jonathanxd.codeapi.base.MethodInvocation;
import com.github.jonathanxd.codeapi.base.MethodInvocationBase;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.VariableAccess;
import com.github.jonathanxd.codeapi.base.VariableDeclaration;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodTypeSpec;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.util.Identity;
import com.github.jonathanxd.codeapi.util.TypeUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class ElementUtil {

    /**
     * Returns true if method matches the specification without checking the invocation target or
     * declaring type.
     *
     * @param methodDeclarationBase Method declaration.
     * @param specification     Method Specification.
     * @return Returns true if method matches the specification without checking the invocation
     * target or declaring type.
     */
    public static boolean equal(MethodDeclarationBase methodDeclarationBase, MethodTypeSpec specification) {
        if (methodDeclarationBase.getName().equals(specification.getMethodName())) {
            TypeSpec methodDescription = specification.getTypeSpec();

            List<CodeParameter> parameters = methodDeclarationBase.getParameters();

            List<Type> codeTypes = TypeUtil.toTypes(parameters);

            if (TypeUtil.equals(codeTypes, methodDescription.getParameterTypes())) {
                return Identity.is(methodDeclarationBase.getReturnType(), methodDescription.getReturnType());
            }

        }

        return false;
    }

    public static boolean equal(FieldDeclaration fieldDeclaration, FieldAccess access) {
        return access.getName().equals(fieldDeclaration.getName())
                && Identity.is(access.getType(), fieldDeclaration.getType());
    }

    public static boolean equal(VariableDeclaration fieldDeclaration, VariableAccess access) {
        return access.getName().equals(fieldDeclaration.getName())
                && Identity.is(access.getVariableType(), fieldDeclaration.getType());
    }

    public static MethodInvocationBase invoke(MethodDeclarationBase methodDeclarationBase, CodePart target, List<CodePart> arguments, TypeDeclaration type) {
        boolean isConstructor = methodDeclarationBase.getName().equals("<init>");
        boolean isStatic = methodDeclarationBase.getModifiers().contains(CodeModifier.STATIC);

        InvokeType invokeType = isStatic ? InvokeType.INVOKE_STATIC :
                (isConstructor
                        ? InvokeType.INVOKE_SPECIAL
                        : (type.isInterface()
                        ? InvokeType.INVOKE_INTERFACE
                        : InvokeType.INVOKE_VIRTUAL));


        TypeSpec typeSpec = new TypeSpec(methodDeclarationBase.getReturnType(), TypeUtil.toTypes(methodDeclarationBase.getParameters()));

        MethodTypeSpec methodSpecification = new MethodTypeSpec(
                type,
                methodDeclarationBase.getName(),
                typeSpec);

        return new MethodInvocation(arguments, methodSpecification, invokeType, isConstructor ? type : target);
    }

    public static MethodTypeSpec getMethodSpec(Method method) {
        return new MethodTypeSpec(CodeAPI.getJavaType(method.getDeclaringClass()), method.getName(),
                new TypeSpec(CodeAPI.getJavaType(method.getReturnType()), CodeAPI.getJavaTypeList(method.getParameterTypes())));
    }

    public static MethodTypeSpec getMethodSpec(TypeDeclaration typeDeclaration, MethodDeclarationBase methodDeclarationBase) {
        return new MethodTypeSpec(
                typeDeclaration,
                methodDeclarationBase.getName(),
                new TypeSpec(methodDeclarationBase.getReturnType(), methodDeclarationBase.getParameters().stream().map(CodeParameter::getType).collect(Collectors.toList()))
        );
    }
}
