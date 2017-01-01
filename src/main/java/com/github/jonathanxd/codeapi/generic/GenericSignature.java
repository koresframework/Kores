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
package com.github.jonathanxd.codeapi.generic;

import com.github.jonathanxd.codeapi.types.GenericType;

import java.util.Arrays;

/**
 * Hold information about generic signatures.
 */
public class GenericSignature {

    /**
     * Empty generic signature.
     */
    private static final GenericSignature EMPTY = new GenericSignature(new GenericType[0]);

    /**
     * Generic types.
     */
    private final GenericType[] types;

    /**
     * Create new generic signature.
     *
     * @param types Generic Types.
     */
    public GenericSignature(GenericType[] types) {
        this.types = types;
    }

    /**
     * Create generic signature.
     *
     * @param types Generic Types.
     * @return New {@link GenericSignature} holding {@link GenericType GenericTypes}
     */
    public static GenericSignature create(GenericType... types) {
        return new GenericSignature(types);
    }

    /**
     * Empty generic signature.
     *
     * @return Empty {@link GenericSignature}.
     */
    @SuppressWarnings("unchecked")
    public static GenericSignature empty() {
        return EMPTY;
    }

    /**
     * Gets the generic types (copy of types array).
     *
     * @return Generic types.
     */
    public GenericType[] getTypes() {
        return this.types.clone();
    }

    /**
     * Returns true if this generic signature is empty (no types).
     *
     * @return true if this generic signature is empty (no types).
     */
    public boolean isEmpty() {
        return this == EMPTY || types.length == 0;
    }

    /**
     * Returns true if this generic signature is not empty.
     *
     * @return true if this generic signature is not empty.
     */
    public boolean isNotEmpty() {
        return !this.isEmpty();
    }

    @Override
    public String toString() {
        return "GenericSignature["+ Arrays.toString(this.getTypes())+"]";
    }
}
