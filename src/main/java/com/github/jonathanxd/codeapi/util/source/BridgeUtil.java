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
package com.github.jonathanxd.codeapi.util.source;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.base.ImplementationHolder;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.SuperClassHolder;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.MethodTypeSpec;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.inspect.SourceInspect;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.type.Generic;
import com.github.jonathanxd.codeapi.type.LoadedCodeType;
import com.github.jonathanxd.codeapi.util.TypeVarUtil;
import com.github.jonathanxd.codeapi.util.element.ElementUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BridgeUtil {

    public static Optional<MethodDeclaration> genBridgeMethod(TypeDeclaration typeDeclaration, MethodDeclaration methodDeclaration) {
        MethodTypeSpec bridgeMethod = BridgeUtil.findMethodToBridge(typeDeclaration, methodDeclaration);

        return bridgeMethod == null ? Optional.empty() : Optional.of(CodeAPI.bridgeMethod(methodDeclaration, bridgeMethod));
    }

    public static MethodTypeSpec findMethodToBridge(TypeDeclaration typeDeclaration, MethodDeclaration methodDeclaration) {
        MethodTypeSpec methodSpec = ElementUtil.getMethodSpec(typeDeclaration, methodDeclaration);

        MethodTypeSpec found = BridgeUtil.find(typeDeclaration, methodSpec);

        if (found != null && found.compareTo(methodSpec) == 0)
            return null;

        return found;
    }

    private static MethodTypeSpec find(TypeDeclaration typeDeclaration, MethodTypeSpec methodSpec) {
        if (!(typeDeclaration instanceof SuperClassHolder) && !(typeDeclaration instanceof ImplementationHolder))
            return null;

        List<Generic> types = new ArrayList<>();

        if (typeDeclaration instanceof SuperClassHolder) {
            SuperClassHolder extender = (SuperClassHolder) typeDeclaration;

            CodeType superTypeOpt = extender.getSuperClass();

            if (superTypeOpt != null) {
                if (superTypeOpt instanceof Generic)
                    types.add((Generic) superTypeOpt);
            }
        }

        if (typeDeclaration instanceof ImplementationHolder) {
            ImplementationHolder implementer = (ImplementationHolder) typeDeclaration;

            implementer.getImplementations().stream()
                    .filter(codeType -> codeType instanceof Generic)
                    .forEach(codeType -> types.add((Generic) codeType));

        }

        for (Generic type : types) {
            MethodTypeSpec in = BridgeUtil.findIn(type, methodSpec);

            if (in != null)
                return in;
        }

        return null;
    }

    private static MethodTypeSpec findIn(Generic generic, MethodTypeSpec methodSpec) {

        if (generic.isType()) {
            CodeType codeType = generic.getCodeType();

            if (codeType instanceof LoadedCodeType<?>) {
                Class<?> loadedType = ((LoadedCodeType<?>) codeType).getLoadedType();

                return BridgeUtil.findIn(loadedType, generic, methodSpec);
            }

            if (codeType instanceof TypeDeclaration) {
                TypeDeclaration type = (TypeDeclaration) codeType;

                return BridgeUtil.findIn(type, generic, methodSpec);
            }
        }

        return null;
    }

    private static MethodTypeSpec findIn(Class<?> theClass, Generic generic, MethodTypeSpec methodSpec) {
        TypeVariable<?>[] typeParameters = theClass.getTypeParameters();

        for (Method method : theClass.getDeclaredMethods()) {

            if (!methodSpec.getMethodName().equals(method.getName()))
                continue;

            MethodTypeSpec spec = new MethodTypeSpec(
                    CodeAPI.getJavaType(method.getDeclaringClass()),
                    method.getName(),
                    new TypeSpec(CodeAPI.getJavaType(method.getReturnType()), CodeAPI.getJavaTypeList(method.getParameterTypes())));

            if (methodSpec.compareTo(spec) == 0) {
                return spec; // No problem here, CodeAPI will not duplicate methods, it will only avoid the type inference (slow part of the bridge method inference)
            }

            TypeVariable<?>[] methodParameters = method.getTypeParameters();

            CodeType inferredReturnType = TypeVarUtil.toCodeType(method.getGenericReturnType(), typeParameters, methodParameters, generic);

            List<CodeType> inferredParametersTypes = new ArrayList<>();

            Type[] genericParameterTypes = method.getGenericParameterTypes();

            for (Type genericParameterType : genericParameterTypes) {
                inferredParametersTypes.add(TypeVarUtil.toCodeType(genericParameterType, methodParameters, typeParameters, generic));
            }

            MethodTypeSpec methodTypeSpec = new MethodTypeSpec(
                    CodeAPI.getJavaType(method.getDeclaringClass()),
                    method.getName(),
                    new TypeSpec(inferredReturnType, inferredParametersTypes));

            if (methodTypeSpec.compareTo(methodSpec) == 0) {
                return fixGenerics(spec, null, typeParameters, null);
            }
        }

        return null;
    }

    private static MethodTypeSpec findIn(TypeDeclaration theClass, Generic generic, MethodTypeSpec methodSpec) {
        GenericSignature genericSignature = theClass.getGenericSignature();

        TypeVariable<?>[] typeParameters = TypeVarUtil.toTypeVars(genericSignature);

        List<MethodDeclaration> inspect = SourceInspect.find(codePart -> codePart instanceof MethodDeclaration)
                .include(bodied -> bodied instanceof CodeSource)
                .mapTo(codePart -> (MethodDeclaration) codePart)
                .inspect(theClass.getBody());

        for (MethodDeclaration method : inspect) {

            if (!methodSpec.getMethodName().equals(method.getName()))
                continue;

            List<CodeType> parameterTypes = method.getParameters().stream().map(CodeParameter::getType).collect(Collectors.toList());

            MethodTypeSpec spec = new MethodTypeSpec(theClass, method.getName(),
                    new TypeSpec(method.getReturnType(), parameterTypes));

            if (methodSpec.compareTo(spec) == 0) {
                return spec; // No problem here, CodeAPI will not duplicate methods, it will only avoid the type inference (slow part of the bridge method inference)
            }

            GenericSignature methodSignature = method.getGenericSignature();

            TypeVariable<?>[] methodParameters = TypeVarUtil.toTypeVars(methodSignature);

            CodeType inferredReturnType = TypeVarUtil.toCodeType(method.getReturnType(), typeParameters, methodParameters, generic);

            List<CodeType> inferredParametersTypes = new ArrayList<>();

            for (CodeType genericParameterType : parameterTypes) {
                inferredParametersTypes.add(TypeVarUtil.toCodeType(genericParameterType, methodParameters, typeParameters, generic));
            }

            MethodTypeSpec methodTypeSpec = new MethodTypeSpec(theClass, method.getName(), new TypeSpec(inferredReturnType, inferredParametersTypes));

            if (methodTypeSpec.compareTo(methodSpec) == 0) {
                return fixGenerics(spec, genericSignature, null, method);
            }
        }

        return null;
    }

    private static MethodTypeSpec fixGenerics(MethodTypeSpec spec, GenericSignature genericSignature, TypeVariable<?>[] typeVariables, Object method) {
        CodeType returnType = spec.getTypeSpec().getReturnType();

        CodeType newReturnType = returnType;

        if (returnType instanceof Generic) {
            Generic generic0 = (Generic) returnType;


            if (generic0.isType())
                newReturnType = generic0.getCodeType();
            else
                newReturnType = Objects.requireNonNull(
                        genericSignature != null
                                ? TypeVarUtil.findType(genericSignature, generic0.getName())
                                : TypeVarUtil.findType(typeVariables, generic0.getName()),
                        "Cannot infer correct return type of method '" + method + "'!");


        }

        List<CodeType> newParameterTypes = spec.getTypeSpec().getParameterTypes();

        newParameterTypes = newParameterTypes.stream().map(codeType -> {
            if (codeType instanceof Generic) {
                Generic generic0 = (Generic) codeType;
                if (generic0.isType())
                    return generic0.getCodeType();
                else
                    return Objects.requireNonNull(genericSignature != null
                            ? TypeVarUtil.findType(genericSignature, generic0.getName())
                            : TypeVarUtil.findType(typeVariables, generic0.getName()), "Cannot infer correct parameter type of ParameterType '" + codeType + "' of method '" + method + "'!");
            }

            return codeType;
        }).collect(Collectors.toList());

        return new MethodTypeSpec(spec.getLocalization(), spec.getMethodName(), new TypeSpec(newReturnType, newParameterTypes));
    }

    private static TypeVariable<?> find(String name, TypeVariable<?>[] typeVariables) {
        for (TypeVariable<?> typeVariable : typeVariables) {
            if (typeVariable.getName().equals(name))
                return typeVariable;
        }

        return null;
    }
}
