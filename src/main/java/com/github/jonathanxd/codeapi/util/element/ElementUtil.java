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
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.MethodInvocation;
import com.github.jonathanxd.codeapi.base.MethodSpecification;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.VariableAccess;
import com.github.jonathanxd.codeapi.base.VariableDeclaration;
import com.github.jonathanxd.codeapi.base.impl.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.base.impl.MethodSpecificationImpl;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.MethodTypeSpec;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.util.TypeUtil;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class ElementUtil {

    /**
     * Returns true if method matches the specification without checking the invocation target or
     * declaring type.
     *
     * @param methodDeclaration Method declaration.
     * @param specification     Method Specification.
     * @return Returns true if method matches the specification without checking the invocation
     * target or declaring type.
     */
    public static boolean equal(MethodDeclaration methodDeclaration, MethodSpecification specification) {
        if (methodDeclaration.getName().equals(specification.getMethodName())) {
            TypeSpec methodDescription = specification.getDescription();

            List<CodeParameter> parameters = methodDeclaration.getParameters();

            List<CodeType> codeTypes = TypeUtil.toTypes(parameters);

            if (TypeUtil.equals(codeTypes, methodDescription.getParameterTypes())) {
                return methodDeclaration.getReturnType().is(methodDescription.getReturnType());
            }

        }

        return false;
    }

    public static boolean equal(FieldDeclaration fieldDeclaration, FieldAccess access) {
        return access.getName().equals(fieldDeclaration.getName())
                && access.getType().is(fieldDeclaration.getType());
    }

    public static boolean equal(VariableDeclaration fieldDeclaration, VariableAccess access) {
        return access.getName().equals(fieldDeclaration.getName())
                && access.getVariableType().is(fieldDeclaration.getType());
    }

    public static MethodInvocation invoke(MethodDeclaration methodDeclaration, CodePart target, List<CodeArgument> arguments, TypeDeclaration type) {
        boolean isConstructor = methodDeclaration.getName().equals("<init>");
        boolean isStatic = methodDeclaration.getModifiers().contains(CodeModifier.STATIC);

        InvokeType invokeType = isStatic ? InvokeType.INVOKE_STATIC :
                (isConstructor
                        ? InvokeType.INVOKE_SPECIAL
                        : (type.isInterface()
                        ? InvokeType.INVOKE_INTERFACE
                        : InvokeType.INVOKE_VIRTUAL));


        TypeSpec typeSpec = new TypeSpec(methodDeclaration.getReturnType(), TypeUtil.toTypes(methodDeclaration.getParameters()));

        MethodSpecificationImpl methodSpecification = new MethodSpecificationImpl(
                isConstructor ? MethodType.CONSTRUCTOR : MethodType.METHOD,
                methodDeclaration.getName(),
                typeSpec);

        return new MethodInvocationImpl(type, arguments, methodSpecification, invokeType, null, isConstructor ? type : target);
    }

    public static MethodTypeSpec getMethodSpec(Method method) {
        return new MethodTypeSpec(CodeAPI.getJavaType(method.getDeclaringClass()), method.getName(),
                new TypeSpec(CodeAPI.getJavaType(method.getReturnType()), CodeAPI.getJavaTypeList(method.getParameterTypes())));
    }

    public static MethodTypeSpec getMethodSpec(TypeDeclaration typeDeclaration, MethodDeclaration methodDeclaration) {
        return new MethodTypeSpec(
                typeDeclaration,
                methodDeclaration.getName(),
                new TypeSpec(methodDeclaration.getReturnType(), methodDeclaration.getParameters().stream().map(CodeParameter::getType).collect(Collectors.toList()))
        );
    }
}
