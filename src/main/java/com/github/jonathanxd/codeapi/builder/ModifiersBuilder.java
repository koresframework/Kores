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
package com.github.jonathanxd.codeapi.builder;

import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.util.ArrayToList;

import java.util.Collection;

public interface ModifiersBuilder<T, R extends ModifiersBuilder<T, R>> {
    /**
     * Set modifiers.
     *
     * @param modifiers Code Modifiers
     * @return This.
     */
    R withModifiers(Collection<CodeModifier> modifiers);

    /**
     * Set modifiers.
     *
     * @param modifiers Modifiers.
     * @return This.
     */
    default R withModifiers(CodeModifier... modifiers) {
        return this.withModifiers(ArrayToList.toList(modifiers));
    }

    /**
     * Set modifiers
     *
     * @param modifiers Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                  java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                  {@link java.lang.reflect.Modifier#PROTECTED}, 0 to package-private, etc...
     *                  visibility).
     * @return This.
     */
    default R withModifiers(int modifiers) {
        return this.withModifiers(CodeModifier.extractModifiers(modifiers));
    }
}
