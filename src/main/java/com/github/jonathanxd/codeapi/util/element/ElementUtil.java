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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.TypeUtil;

import java.lang.reflect.Method;
import java.util.List;

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
            TypeSpec methodDescription = specification.getMethodDescription();

            List<CodeParameter> parameters = methodDeclaration.getParameters();

            List<CodeType> codeTypes = TypeUtil.toTypes(parameters);

            if (TypeUtil.equals(codeTypes, methodDescription.getParameterTypes())) {
                return methodDeclaration.getReturnType().orElseThrow(NullPointerException::new).is(methodDescription.getReturnType());
            }

        }

        return false;
    }

    public static boolean equal(FieldDeclaration fieldDeclaration, VariableAccess access) {
        return access.getName().equals(fieldDeclaration.getName())
                && access.getVariableType().is(fieldDeclaration.getVariableType())
                && access.getLocalization().orElse(null) != null;
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


        TypeSpec typeSpec = new TypeSpec(methodDeclaration.getReturnType().orElse(PredefinedTypes.VOID), TypeUtil.toTypes(methodDeclaration.getParameters()));

        return Helper.invoke(invokeType, type, isConstructor ? type : target,
                new MethodSpecImpl(
                        methodDeclaration.getName(),
                        typeSpec,
                        arguments,
                        isConstructor ? MethodType.CONSTRUCTOR : MethodType.METHOD));
    }

    public static FullMethodSpec getMethodSpec(Method method) {
        return new FullMethodSpec(method.getDeclaringClass(), method.getReturnType(), method.getName(), method.getParameterTypes());
    }

    public static FullMethodSpec getMethodSpec(TypeDeclaration typeDeclaration, MethodDeclaration methodDeclaration) {
        return new FullMethodSpec(
                typeDeclaration,
                methodDeclaration.getReturnType().orElse(PredefinedTypes.VOID),
                methodDeclaration.getName(),
                methodDeclaration.getParameters().stream().map(CodeParameter::getRequiredType).toArray(CodeType[]::new)
        );
    }
}
