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
package com.github.jonathanxd.codeapi.util;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.type.Generic;
import com.github.jonathanxd.codeapi.type.GenericType;
import com.github.jonathanxd.codeapi.type.LoadedCodeType;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeVarUtil {
    public static CodeType getType(TypeVariable<?>[] typeVariables, TypeVariable<?> variable, Generic generic) {
        return TypeVarUtil.getType(typeVariables, variable.getName(), generic);
    }

    public static CodeType getType(TypeVariable<?>[] typeVariables, String variable, Generic generic) {
        for (int i = 0; i < generic.getBounds().length; i++) {
            if (i >= typeVariables.length)
                break;

            if (variable.equals(typeVariables[i].getName()))
                return generic.getBounds()[i].getType();
        }

        return null;
    }

    public static boolean isConflict(TypeVariable<?>[] typeVariables, TypeVariable<?> typeVariable) {
        for (TypeVariable<?> variable : typeVariables) {
            if (variable.getName().equals(typeVariable.getName()))
                return true;
        }

        return false;
    }

    public static CodeType toCodeType(CodeType type, TypeVariable<?>[] variables, TypeVariable<?>[] classVariables, Generic generic) {
        if (type instanceof LoadedCodeType<?> || (type instanceof Generic && ((Generic) type).isType() && ((Generic) type).getCodeType() instanceof LoadedCodeType<?>)) {

            if (type instanceof Generic) {
                return ((Generic) type).getCodeType();
            } else {
                return type;
            }
        } else {
            TypeVariable<?> variable = TypeVarUtil.toTypeVar((GenericType) type);

            if (!TypeVarUtil.isConflict(variables, variable)) {
                return TypeVarUtil.getType(classVariables, variable, generic);
            } else {
                Class<?> inferredType = com.github.jonathanxd.iutils.type.TypeUtil.from(variable);

                return inferredType == null ? Types.OBJECT : CodeAPI.getJavaType(inferredType);
            }

        }
    }

    public static CodeType toCodeType(Type type, TypeVariable<?>[] variables, TypeVariable<?>[] classVariables, Generic generic) {
        if (type instanceof Class<?>) {
            return CodeAPI.getJavaType((Class<?>) type);
        } else {
            TypeVariable<?> variable = (TypeVariable<?>) type;

            if (!TypeVarUtil.isConflict(variables, variable)) {
                return TypeVarUtil.getType(classVariables, variable, generic);
            } else {
                Class<?> inferredType = com.github.jonathanxd.iutils.type.TypeUtil.from(variable);

                return inferredType == null ? Types.OBJECT : CodeAPI.getJavaType(inferredType);
            }

        }
    }

    public static List<String> getTypeVarConflicts(TypeVariable<?>[] typeVariables, TypeVariable<?>[] otherTypeVariables) {

        List<String> conflicts = new ArrayList<>();

        for (TypeVariable<?> typeVariable : typeVariables) {
            for (TypeVariable<?> otherTypeVariable : otherTypeVariables) {
                if (typeVariable.getName().equals(otherTypeVariable.getName()))
                    conflicts.add(typeVariable.getName());
            }
        }

        return conflicts;
    }

    public static TypeVariable<?> find(TypeVariable<?>[] typeVariables, GenericType genericType) {
        GenericType.Bound<CodeType>[] bounds = genericType.getBounds();

        for (int i = 0; i < bounds.length; ++i) {
            if (i >= typeVariables.length)
                break;

            return TypeVarUtil.toTypeVar(bounds[i], typeVariables[i]);
        }

        return null;
    }

    public static TypeVariable<?>[] getTypeVariables(CodeType codeType) {
        if (codeType instanceof LoadedCodeType<?>) {
            return ((LoadedCodeType<?>) codeType).getLoadedType().getTypeParameters();
        } else if (codeType instanceof TypeDeclaration) {
            TypeDeclaration codeType1 = (TypeDeclaration) codeType;

            return TypeVarUtil.toTypeVars(codeType1.getGenericSignature());
        } else {
            return new TypeVariable[0];
        }
    }

    public static TypeVariable<?>[] fillTypeVars(TypeDeclaration declaration, GenericType generic) {
        return Arrays.stream(declaration.getGenericSignature().getTypes()).map(TypeVarUtil::toTypeVar).toArray(TypeVariable[]::new);
    }

    public static TypeVariable<?>[] fillTypeVars(Class<?> theClass, GenericType generic) {
        if (generic.isType() && generic.getCodeType().is(CodeAPI.getJavaType(theClass))) {
            return fillTypeVars(theClass.getTypeParameters(), generic);
        }

        return new TypeVariable[0];
    }

    public static TypeVariable<?>[] fillTypeVars(TypeVariable<?>[] typeParameters, GenericType generic) {
        List<TypeVariable<?>> filledTypeVars = new ArrayList<>();

        GenericType.Bound<CodeType>[] bounds = generic.getBounds();

        for (int i = 0; i < bounds.length; i++) {
            if (i >= typeParameters.length)
                break;

            TypeVariable<?> typeParameter = typeParameters[i];
            GenericType.Bound<CodeType> bound = bounds[i];

            if (bound instanceof GenericType.GenericBound<?>) {
                TypeVariable<?> typeVar = TypeVarUtil.toTypeVar(bound, typeParameter);
                filledTypeVars.add(typeVar);
            }
        }

        return filledTypeVars.stream().toArray(TypeVariable[]::new);
    }

    public static CodeType findType(TypeVariable<?>[] typeVariables, String name) {
        if (typeVariables == null)
            return null;

        for (TypeVariable<?> typeVariable : typeVariables) {
            if (typeVariable.getName().equals(name) && typeVariable.getBounds().length > 0) {

                Class<?> from = com.github.jonathanxd.iutils.type.TypeUtil.from(typeVariable.getBounds()[0]);

                if (from != null) {
                    return CodeAPI.getJavaType(from);
                }
            }


        }

        return null;
    }

    public static CodeType findType(GenericSignature signature, String name) {
        if (signature == null)
            return null;

        GenericType[] types = signature.getTypes();

        for (GenericType type : types) {
            if (!type.isType())
                if (type.getName().equals(name))
                    return type.getCodeType();
        }

        return null;
    }

    public static TypeVariable<?>[] toTypeVars(GenericSignature signature) {
        return signature == null ? new TypeVariable[0] : Arrays.stream(signature.getTypes()).map(TypeVarUtil::toTypeVar).toArray(TypeVariable[]::new);
    }

    public static TypeVariable<?> toTypeVar(GenericType generic) {
        if (generic.isType() || generic.getBounds().length == 0)
            return new GenericTypeVariable(generic.getCodeType(), null, generic.getName(), new Type[]{
                    generic.isType() ? new GenericJavaType(generic.getCodeType()) : new GenericTypeVariable(generic.getCodeType(), null, generic.getName(), new Type[0])
            });

        List<Type> typeList = new ArrayList<>();

        GenericType.Bound<CodeType>[] bounds = generic.getBounds();

        for (GenericType.Bound<CodeType> typeBound : bounds) {
            CodeType type = typeBound.getType();

            if (type instanceof GenericType) {
                typeList.add(TypeVarUtil.toTypeVar((GenericType) type));
            } else {
                typeList.add(new GenericJavaType(type));
            }


        }

        return new GenericTypeVariable(generic.getCodeType(), null, generic.getName(), typeList.stream().toArray(Type[]::new));
    }

    private static TypeVariable<?> toTypeVar(GenericType.Bound<CodeType> bound, TypeVariable<?> variable) {

        if (bound.getType() instanceof Generic) {
            Generic generic = (Generic) bound.getType();

            if (generic.isType() || generic.getBounds().length == 0)
                return new GenericTypeVariable(generic.getCodeType(), variable, new Type[]{
                        generic.isType() ? new GenericJavaType(generic.getCodeType()) : new GenericTypeVariable(generic.getCodeType(), null, generic.getName(), new Type[0])
                });

            List<Type> typeList = new ArrayList<>();

            Type[] typeVarBounds = variable.getBounds();
            GenericType.Bound<CodeType>[] bounds = generic.getBounds();

            for (int i = 0; i < bounds.length; i++) {
                if (i >= typeVarBounds.length)
                    break;

                Type typeVarBound = typeVarBounds[i];

                GenericType.Bound<CodeType> typeBound = bounds[i];

                if (typeVarBound instanceof TypeVariable) {
                    typeList.add(TypeVarUtil.toTypeVar(typeBound, (TypeVariable<?>) typeVarBound));
                } else {
                    typeList.add(TypeVarUtil.toTypeVar(typeBound, new GenericTypeVariable(typeBound.getType(), typeVarBound, new Type[0])));
                }
            }

            return new GenericTypeVariable(generic.getCodeType(), variable, generic.getType(), typeList.stream().toArray(Type[]::new));
        } else {
            return new GenericTypeVariable(bound.getType(), variable, new Type[]{new GenericJavaType(bound.getType())});
        }
    }

    private static final class GenericJavaType implements Type {
        private final CodeType type;

        private GenericJavaType(CodeType type) {
            this.type = type;
        }

        public static GenericJavaType fromBound(GenericType.Bound<CodeType> bound) {
            CodeType type;
            if (bound.getSign().equals("*")) {
                type = Types.OBJECT;
            } else {
                type = bound.getType();
            }

            return new GenericJavaType(type);
        }

        @Override
        public String getTypeName() {
            return this.type.getCanonicalName();
        }
    }

}
