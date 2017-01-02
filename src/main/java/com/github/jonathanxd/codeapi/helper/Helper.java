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
package com.github.jonathanxd.codeapi.helper;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.base.Named;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.LoadedCodeType;
import com.github.jonathanxd.iutils.map.WeakValueHashMap;

import org.objectweb.asm.Type;

import java.util.Arrays;

/**
 * Helper class (not backward compatible, this class may change constantly).
 *
 * If you want a stable factory use: {@link com.github.jonathanxd.codeapi.CodeAPI}.
 *
 * This class is not documented.
 */
public final class Helper {

    private final static WeakValueHashMap<Class<?>, CodeType> CODE_TYPES_CACHE = new WeakValueHashMap<>();
    private static final None NONE = new None();


    @SuppressWarnings("unchecked")
    public static <T> LoadedCodeType<T> getJavaType(Class<T> aClass) {

        if (aClass.isArray())
            return getJavaType0(aClass);

        if (CODE_TYPES_CACHE.containsKey(aClass)) {
            CodeType codeType = CODE_TYPES_CACHE.get(aClass);

            if (codeType != null && codeType instanceof LoadedCodeType)
                return (LoadedCodeType<T>) codeType;
        }

        JavaType<T> javaType = new JavaType<>(aClass);

        CODE_TYPES_CACHE.put(aClass, javaType);

        return javaType;

    }

    @SuppressWarnings("unchecked")
    private static <T> LoadedCodeType<T> getJavaType0(Class<T> aClass) {

        if (CODE_TYPES_CACHE.containsKey(aClass)) {
            CodeType codeType = CODE_TYPES_CACHE.get(aClass);

            if (codeType != null && codeType instanceof LoadedCodeType)
                return (LoadedCodeType<T>) codeType;
        }

        LoadedCodeType<T> type = new JavaType<>(aClass);

        if (aClass.isArray()) {
            Class<?> component = aClass;

            int dimensions = 0;

            do {
                ++dimensions;
            } while ((component = component.getComponentType()).isArray());

            type = new JavaType<>((Class<T>) component).toLoadedArray(aClass, dimensions);
        }

        CODE_TYPES_CACHE.put(aClass, type);

        return type;

    }

    public static CodeType getJavaArrayType(Class<?> aClass) {
        return Helper.getJavaType0(aClass);
    }

    public static CodeType[] getJavaArrayTypes(Class<?>[] classes) {
        return Arrays.stream(classes).map(Helper::getJavaArrayType).toArray(CodeType[]::new);
    }

    @SuppressWarnings("unchecked")
    public static LoadedCodeType<?>[] getJavaTypes(Class<?>[] aClass) {
        return Arrays.stream(aClass).map(Helper::getJavaType).toArray(LoadedCodeType[]::new);

    }

    @GenerateTo(CodeType.class)
    final private static class JavaType<T> implements LoadedCodeType<T> {
        private final Class<T> type;

        private JavaType(Class<T> type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == null)
                return false;

            if (obj instanceof Class) {
                return this.type.equals(obj);
            }

            if (obj instanceof LoadedCodeType) {
                return this.type.equals(((LoadedCodeType) obj).getLoadedType());
            }

            if (obj instanceof CodeType) {
                return this.getJavaSpecName().equals(((CodeType) obj).getJavaSpecName());
            }

            return CodeType.eq(this, obj);
        }

        @Override
        public String getJavaSpecName() {
            return Type.getDescriptor(type);
        }

        @Override
        public String getType() {
            return Type.getType(type).getClassName();
        }

        @Override
        public String getCanonicalName() {
            return this.type.getCanonicalName();
        }

        @Override
        public int hashCode() {
            return CodeType.hash(this);
        }

        @Override
        public boolean isInterface() {
            return type.isInterface();
        }

        @Override
        public boolean isPrimitive() {
            return type.isPrimitive();
        }

        @Override
        public Class<T> getLoadedType() {
            return this.type;
        }

        @Override
        public boolean isVirtual() {
            return false;
        }

        @Override
        public String toString() {
            return this.getJavaSpecName();
        }

        @Override
        public boolean isExpression() {
            return false;
        }
    }

    final private static class None implements CodePart, Named {

        @Override
        public String getName() {
            throw new IllegalStateException("Empty element");
        }

        @Override
        public boolean isExpression() {
            throw new IllegalStateException("Empty element");
        }
    }

}
