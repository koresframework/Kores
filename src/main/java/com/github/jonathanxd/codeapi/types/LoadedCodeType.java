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
package com.github.jonathanxd.codeapi.types;

import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.iutils.object.Primitive;

/**
 * A {@link CodeTypeArray} that are loaded by JVM.
 *
 * @param <T> Type of the Class.
 */
public interface LoadedCodeType<T> extends CodeType {

    /**
     * Gets the loaded class.
     *
     * @return Loaded class.
     */
    Class<T> getLoadedType();

    @Override
    default boolean isArray() {
        return getLoadedType().isArray();
    }

    @Override
    default boolean isVirtual() {
        return false;
    }

    @Override
    default CodeType getWrapperType() {
        Class<?> box = Primitive.box(getLoadedType());

        if (box != null) {
            return Helper.getJavaType(box);
        }

        return null;
    }

    @Override
    default CodeType getPrimitiveType() {
        Class<?> unbox = Primitive.unbox(getLoadedType());

        if (unbox != null) {
            return Helper.getJavaType(unbox);
        }

        return null;
    }

    default LoadedArrayCodeType<T> toLoadedArray(Class<T> array, int dimensions) {
        return new LoadedArrayCodeType<>(array, this, dimensions);
    }
}
