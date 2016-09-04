/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2016 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.LoadedCodeType;

import org.objectweb.asm.Type;

import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Set;

/**
 * Created by jonathan on 06/06/16.
 */
public final class PredefinedTypes {

    // Java.Lang
    public static final LoadedCodeType<Object> OBJECT = new PredefinedType<>(Object.class);
    public static final LoadedCodeType<String> STRING = new PredefinedType<>(String.class);
    public static final LoadedCodeType<System> SYSTEM = new PredefinedType<>(System.class);

    public static final LoadedCodeType<Void> VOID = new PredefinedType<>(Void.TYPE);

    // Exceptions
    public static final LoadedCodeType<Throwable> THROWABLE = new PredefinedType<>(Throwable.class);
    public static final LoadedCodeType<Exception> EXCEPTION = new PredefinedType<>(Exception.class);
    public static final LoadedCodeType<RuntimeException> RUNTIME_EXCEPTION = new PredefinedType<>(RuntimeException.class);


    // Primitive
    public static final LoadedCodeType<Byte> BYTE = new PredefinedType<>(Byte.TYPE);
    public static final LoadedCodeType<Short> SHORT = new PredefinedType<>(Short.TYPE);
    public static final LoadedCodeType<Integer> INT = new PredefinedType<>(Integer.TYPE);
    public static final LoadedCodeType<Float> FLOAT = new PredefinedType<>(Float.TYPE);
    public static final LoadedCodeType<Double> DOUBLE = new PredefinedType<>(Double.TYPE);
    public static final LoadedCodeType<Long> LONG = new PredefinedType<>(Long.TYPE);
    public static final LoadedCodeType<Character> CHAR = new PredefinedType<>(Character.TYPE);
    public static final LoadedCodeType<Boolean> BOOLEAN = new PredefinedType<>(Boolean.TYPE);

    // Primitive Type
    public static final LoadedCodeType<Byte> BYTE_TYPE = new PredefinedType<>(Byte.class);
    public static final LoadedCodeType<Short> SHORT_TYPE = new PredefinedType<>(Short.class);
    public static final LoadedCodeType<Integer> INTEGER_TYPE = new PredefinedType<>(Integer.class);
    public static final LoadedCodeType<Float> FLOAT_TYPE = new PredefinedType<>(Float.class);
    public static final LoadedCodeType<Double> DOUBLE_TYPE = new PredefinedType<>(Double.class);
    public static final LoadedCodeType<Long> LONG_TYPE = new PredefinedType<>(Long.class);
    public static final LoadedCodeType<Character> CHARACTER_TYPE = new PredefinedType<>(Character.class);
    public static final LoadedCodeType<Boolean> BOOLEAN_TYPE = new PredefinedType<>(Boolean.class);

    // Java.Util
    public static final LoadedCodeType<Collection> COLLECTION = new PredefinedType<>(Collection.class);
    public static final LoadedCodeType<List> LIST = new PredefinedType<>(List.class);
    public static final LoadedCodeType<Set> SET = new PredefinedType<>(Set.class);
    public static final LoadedCodeType<Deque> DEQUE = new PredefinedType<>(Deque.class);

    PredefinedTypes() {
    }


    @GenerateTo(CodeType.class)
    private static class PredefinedType<T> implements LoadedCodeType<T> {

        private final Class<T> tClass;

        PredefinedType(Class<T> tClass) {
            this.tClass = tClass;
        }


        @Override
        public String getType() {
            return Type.getType(this.tClass).getClassName();
        }

        @Override
        public String getCanonicalName() {
            return this.tClass.getCanonicalName();
        }

        @Override
        public String getSimpleName() {
            return this.tClass.getSimpleName();
        }

        @Override
        public String getJavaSpecName() {
            return Type.getDescriptor(this.tClass);
        }

        @Override
        public boolean isPrimitive() {
            return this.tClass.isPrimitive();
        }

        @Override
        public boolean isInterface() {
            return this.tClass.isInterface();
        }

        @Override
        public Class<T> getLoadedType() {
            return this.tClass;
        }

        @Override
        public boolean isVirtual() {
            return false;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == null)
                return false;

            if (obj instanceof Class) {
                return this.tClass.equals(obj);
            }

            if (obj instanceof LoadedCodeType) {
                return this.tClass.equals(((LoadedCodeType) obj).getLoadedType());
            }

            if (obj instanceof CodeType) {
                return this.getJavaSpecName().equals(((CodeType) obj).getJavaSpecName());
            }

            return super.equals(obj);
        }

        @Override
        public String toString() {
            return this.getJavaSpecName();
        }
    }
}