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
package com.github.jonathanxd.codeapi.common;

/**
 * Type of the method.
 *
 * Factory methods automatically determine the method type.
 *
 * Method types:
 *
 * - Dynamic method: A dynamic invocation of a JVM Method.
 *
 * - Dynamic constructor: A dynamic invocation of a Instance constructor.
 *
 * - Method: A normal invocation of a method.
 *
 * - Constructor: A normal invocation of a constructor, but is not related to super class
 * initialization.
 *
 * - Super Constructor: A invocation of a Super class constructor, this method type couldn't be used
 * to create a new instance of a class, the ASM and JVM will throw errors if you try to create a
 * instance using this.
 */
public enum MethodType {
    /**
     * Dynamic method
     */
    DYNAMIC_METHOD,

    /**
     * Dynamic constructor
     */
    DYNAMIC_CONSTRUCTOR,

    /**
     * Method
     */
    METHOD(DYNAMIC_METHOD),

    /**
     * Constructor
     */
    CONSTRUCTOR(DYNAMIC_CONSTRUCTOR),

    /**
     * Super constructor
     */
    SUPER_CONSTRUCTOR;

    /**
     * Dynamic type corresponding to current {@link MethodType}
     */
    private final MethodType dynamic;

    MethodType() {
        this.dynamic = null;
    }

    MethodType(MethodType dynamic) {
        this.dynamic = dynamic;
    }

    /**
     * Gets the corresponding dynamic type.
     *
     * @return Corresponding dynamic type.
     */
    public MethodType toDynamic() {
        return this.dynamic != null ? this.dynamic : this;
    }

    public boolean isConstructor() {
        return this == CONSTRUCTOR || this == SUPER_CONSTRUCTOR;
    }
}
