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

import com.github.jonathanxd.codeapi.annotation.GenerateTo;

/**
 * A {@link CodeTypeArray} that are loaded by JVM.
 *
 * @param <T> Type of the Class.
 */
@GenerateTo(CodeType.class)
class LoadedArrayCodeType<T> extends CodeTypeArray implements LoadedCodeType<T> {
    /**
     * Loaded type.
     */
    private final Class<T> loadedType;

    /**
     * Create a {@link LoadedArrayCodeType} from a type and component.
     *
     * @param loadedType Loaded Type
     * @param component  Component
     * @param dimensions Dimensions.
     */
    LoadedArrayCodeType(Class<T> loadedType, LoadedCodeType<?> component, int dimensions) {
        super(component, dimensions);
        this.loadedType = loadedType;
    }

    @Override
    public boolean equals(Object obj) {
        return CodeType.eq(this, obj);
    }

    @Override
    public int hashCode() {
        return CodeType.hash(this);
    }

    @Override
    public Class<T> getLoadedType() {
        return this.loadedType;
    }
}
