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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.gen.PartProcessor;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.sugar.SugarSyntax;
import com.github.jonathanxd.codeapi.util.BiMultiVal;

/**
 * Iteration type used to generate bytecode and source code iterations.
 *
 * {@link IterationType} is a {@link SugarSyntax}.
 *
 * This sugar syntax generates a {@link com.github.jonathanxd.codeapi.interfaces.ForBlock}.
 */
public interface IterationType extends PartProcessor, SugarSyntax<ForEachBlock, CodeSource> {

    @Override
    Generator getGenerator();

    /**
     * This generator creates the elements required to construct a {@link
     * com.github.jonathanxd.codeapi.interfaces.ForBlock}.
     *
     * (<pre>
     *     {@code
     *          for(createInitialization; createCondition; createUpdate) declareBody
     *     }
     * </pre>).
     */
    interface Generator extends com.github.jonathanxd.codeapi.sugar.Generator<ForEachBlock, CodeSource> {
        /**
         * Create for initialization ({@code for(initialization; condition; update) body}).
         *
         * @return For initialization
         */
        CodeSource createInitialization();

        /**
         * Create for verification ({@code for(initialization; condition; update) body}).
         *
         * @return For condition.
         */
        BiMultiVal<CodePart, IfExpr, Operator> createCondition();

        /**
         * Create for update ({@code for(initialization; condition; update) body}).
         *
         * @return For update
         */
        CodeSource createUpdate();

        /**
         * Create for body ({@code for(initialization; condition; update) body}).
         *
         * @return For body
         */
        CodeSource declareBody();

        @Override
        default CodeSource generate(ForEachBlock forEachBlock) {
            return Helper.sourceOf(Helper.createFor(
                    this.createInitialization(),
                    this.createCondition(),
                    this.createUpdate(),
                    this.declareBody()
            ));
        }
    }
}
