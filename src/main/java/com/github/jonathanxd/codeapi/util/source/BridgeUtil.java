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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.base.ImplementationHolder;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.SuperClassHolder;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.inspect.SourceInspect;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.Generic;
import com.github.jonathanxd.codeapi.types.LoadedCodeType;
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
        FullMethodSpec bridgeMethod = BridgeUtil.findMethodToBridge(typeDeclaration, methodDeclaration);

        return Optional.empty();//bridgeMethod == null ? Optional.empty() : Optional.of(Helper.bridgeMethod(methodDeclaration, bridgeMethod));
    }

    public static FullMethodSpec findMethodToBridge(TypeDeclaration typeDeclaration, MethodDeclaration methodDeclaration) {
        FullMethodSpec methodSpec = ElementUtil.getMethodSpec(typeDeclaration, methodDeclaration);

        FullMethodSpec found = BridgeUtil.find(typeDeclaration, methodSpec);

        if (found != null && found.compareTo(methodSpec) == 0)
            return null;

        return found;
    }

    private static FullMethodSpec find(TypeDeclaration typeDeclaration, FullMethodSpec methodSpec) {
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
            FullMethodSpec in = BridgeUtil.findIn(type, methodSpec);

            if (in != null)
                return in;
        }

        return null;
    }

    private static FullMethodSpec findIn(Generic generic, FullMethodSpec methodSpec) {

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

    private static FullMethodSpec findIn(Class<?> theClass, Generic generic, FullMethodSpec methodSpec) {
        TypeVariable<?>[] typeParameters = theClass.getTypeParameters();

        for (Method method : theClass.getDeclaredMethods()) {

            if (!methodSpec.getMethodName().equals(method.getName()))
                continue;

            FullMethodSpec spec = new FullMethodSpec(method.getDeclaringClass(), method.getReturnType(), method.getName(), method.getParameterTypes());

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

            FullMethodSpec fullMethodSpec = new FullMethodSpec(Helper.getJavaType(method.getDeclaringClass()), inferredReturnType, method.getName(), inferredParametersTypes);

            if (fullMethodSpec.compareTo(methodSpec) == 0) {
                return fixGenerics(spec, null, typeParameters, null);
            }
        }

        return null;
    }

    private static FullMethodSpec findIn(TypeDeclaration theClass, Generic generic, FullMethodSpec methodSpec) {
        GenericSignature genericSignature = theClass.getGenericSignature();

        TypeVariable<?>[] typeParameters = TypeVarUtil.toTypeVars(genericSignature);

        List<MethodDeclaration> inspect = SourceInspect.find(codePart -> codePart instanceof MethodDeclaration)
                .include(bodied -> bodied instanceof CodeSource)
                .mapTo(codePart -> (MethodDeclaration) codePart)
                .inspect(theClass.getBody());

        for (MethodDeclaration method : inspect) {

            if (!methodSpec.getMethodName().equals(method.getName()))
                continue;

            CodeType[] parameterTypes = method.getParameters().stream().map(CodeParameter::getType).toArray(CodeType[]::new);

            FullMethodSpec spec = new FullMethodSpec(theClass, method.getReturnType(), method.getName(), parameterTypes);

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

            FullMethodSpec fullMethodSpec = new FullMethodSpec(theClass, inferredReturnType, method.getName(), inferredParametersTypes);

            if (fullMethodSpec.compareTo(methodSpec) == 0) {
                return fixGenerics(spec, genericSignature, null, method);
            }
        }

        return null;
    }

    private static FullMethodSpec fixGenerics(FullMethodSpec spec, GenericSignature genericSignature, TypeVariable<?>[] typeVariables, Object method) {
        CodeType returnType = spec.getReturnType();

        if (returnType instanceof Generic) {
            Generic generic0 = (Generic) returnType;
            if (generic0.isType())
                spec = spec.setReturnType(generic0.getCodeType());
            else
                spec = spec.setReturnType(Objects.requireNonNull(
                        genericSignature != null
                                ? TypeVarUtil.findType(genericSignature, generic0.name())
                                : TypeVarUtil.findType(typeVariables, generic0.name()),
                        "Cannot infer correct return type of method '" + method + "'!")

                );


        }

        spec = spec.setParameterTypes(spec.getParameterTypes().stream().map(codeType -> {
            if (codeType instanceof Generic) {
                Generic generic0 = (Generic) codeType;
                if (generic0.isType())
                    return generic0.getCodeType();
                else
                    return Objects.requireNonNull(genericSignature != null
                            ? TypeVarUtil.findType(genericSignature, generic0.name())
                            : TypeVarUtil.findType(typeVariables, generic0.name()), "Cannot infer correct parameter type of ParameterType '" + codeType + "' of method '" + method + "'!");
            }

            return codeType;
        }).collect(Collectors.toList()));

        return spec;
    }

    private static TypeVariable<?> find(String name, TypeVariable<?>[] typeVariables) {
        for (TypeVariable<?> typeVariable : typeVariables) {
            if (typeVariable.getName().equals(name))
                return typeVariable;
        }

        return null;
    }
}
