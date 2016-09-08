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
package com.github.jonathanxd.codeapi.interfaces;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;

import java.util.Optional;

/**
 * Base class of all elements that support bodies.
 */
public interface Bodied extends CodePart {

    /**
     * Gets the body.
     * @return Body.
     */
    Optional<CodeSource> getBody();

    /**
     * Gets the body.
     * @return Body.
     */
    default CodeSource getRequiredBody() {
        return this.getBody().orElse(new CodeSource());
    }

    /**
     * Returns true if has body defined.
     * @return True if has body defined.
     */
    default boolean hasBody() {
        return this.getBody().isPresent();
    }

    /**
     * Check if the body is not recursive.
     *
     * Recommended to call this method in the constructor.
     *
     * @param bodied Body to check.
     * @throws IllegalStateException If the body is recursive.
     */
    static void checkBody(Bodied bodied) {
        Optional<CodeSource> bodyOpt = bodied.getBody();

        if(bodyOpt.isPresent()) {
            if(bodyOpt.get().contains(bodied)) {
                throw new IllegalStateException("You have putted "+bodied+" instance inside your own body, it may cause StackOverFlow Exception.");
            }
        }
    }
}
