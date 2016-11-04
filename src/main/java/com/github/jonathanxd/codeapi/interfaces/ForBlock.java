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

import java.util.List;
import java.util.Optional;

/**
 * A for block statement.
 *
 * <pre>
 *     {@code
 *          for(init; expression; update) body
 *     }
 * </pre>
 */
public interface ForBlock extends Bodied, IfBlock {

    /**
     * Gets the for initialization.
     *
     * @return For initialization.
     */
    Optional<CodePart> getForInit();

    /**
     * Sets the for initialization.
     *
     * @param init For initialization.
     * @return new instance.
     */
    ForBlock setForInit(CodePart init);

    /**
     * Gets the for expression.
     *
     * @return For expression,
     */
    List<CodePart> getForExpression();

    /**
     * Sets the for expression.
     *
     * @param expression For expression,
     * @return new instance.
     */
    ForBlock setForExpression(List<CodePart> expression);

    /**
     * Gets the for update.
     *
     * @return For update.
     */
    Optional<CodePart> getForUpdate();

    /**
     * Sets the for update.
     *
     * @param update For update.
     * @return new instance.
     */
    ForBlock setForUpdate(CodePart update);

    @Override
    default List<CodePart> getIfExprsAndOps() {
        return this.getForExpression();
    }

    @Override
    ForBlock setIfExprsAndOps(List<CodePart> ifExprsAndOps);

    @Override
    default Optional<ElseBlock> getElseBlock() {
        return Optional.empty();
    }

    @Override
    ForBlock setElseBlock(ElseBlock elseBlock);

    @Override
    ForBlock setBody(CodeSource body);

    @Override
    ForBlock setBodies(List<CodeSource> sourceList);
}
