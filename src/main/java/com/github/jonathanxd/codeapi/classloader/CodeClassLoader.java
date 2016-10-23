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
package com.github.jonathanxd.codeapi.classloader;

import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;

public class CodeClassLoader extends ClassLoader {

    /**
     * Define type declaration class.
     *
     * @param typeDeclaration Type declaration.
     * @param bytes           Bytes.
     * @return Defined Class.
     */
    public Class<?> define(TypeDeclaration typeDeclaration, byte[] bytes) {
        return super.defineClass(typeDeclaration.getQualifiedName(), bytes, 0, bytes.length);
    }

    /**
     * Define {@link BytecodeClass} class.
     *
     * @param bytecodeClass Bytecode class.
     * @return Defined Class.
     */
    public Class<?> define(BytecodeClass bytecodeClass) {
        return this.define(bytecodeClass.getType(), bytecodeClass.getBytecode());
    }

    /**
     * Define {@link BytecodeClass} classes and it inner classes.
     *
     * Make sure that all elements in the {@code bytecodeClasses} is a inner type of element at
     * index 0.
     *
     * @param bytecodeClasses Bytecode class (index 0) and inner classes (1..n).
     * @return First Defined Class.
     */
    public Class<?> define(BytecodeClass[] bytecodeClasses) {
        if (bytecodeClasses.length <= 0) {
            throw new IllegalArgumentException("Empty 'bytecodeClasses' array");
        }

        BytecodeClass bytecodeClass = bytecodeClasses[0];

        Class<?> define = this.define(bytecodeClass.getType(), bytecodeClass.getBytecode());

        for (int i = 1; i < bytecodeClasses.length; i++) {
            this.define(bytecodeClasses[i]);
        }

        return define;
    }
}
