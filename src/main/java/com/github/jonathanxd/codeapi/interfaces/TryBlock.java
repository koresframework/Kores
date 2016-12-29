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
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 11/05/16.
 */
public interface TryBlock extends Bodied, MultiBodied, CodePart, Typed {

    List<CatchBlock> getCatchBlocks();

    TryBlock setCatchBlocks(List<CatchBlock> catchBlocks);

    Optional<CodeSource> getFinallyBlock();

    TryBlock setFinallyBlock(CodeSource finallyBlock);

    @Override
    TryBlock setBody(CodeSource body);

    /**
     * Gets the expression of try-with-resources statement.
     *
     * This method is used to generate try-with-resources source code (only source code).
     *
     * @return Optional of {@link TryWithResources#getVariable()} or empty if is not a {@link
     * TryWithResources} block.
     */
    Optional<CodePart> getExpression();

    /**
     * Sets the expression of try-with-resources statement.
     *
     * @param expression Expression.
     * @return New instance.
     */
    TryBlock setExpression(CodePart expression);

    @Override
    default List<CodeSource> getBodies() {
        List<CodeSource> sources = new ArrayList<>();

        // Add This Body
        this.getBody().ifPresent(sources::add);

        // Add Catch Blocks source

        for (CatchBlock catchBlock : this.getCatchBlocks()) {
            // Add catch body if present
            catchBlock.getBody().ifPresent(sources::add);
        }

        // Add Finally code source
        this.getFinallyBlock().ifPresent(sources::add);

        return sources;
    }

    @Override
    TryBlock setBodies(List<CodeSource> sourceList);

    @Override
    default Optional<CodeType> getType() {
        List<CatchBlock> catchBlocks = this.getCatchBlocks();

        if(catchBlocks.isEmpty() || catchBlocks.size() > 1)
            return Optional.of(PredefinedTypes.THROWABLE);

        return catchBlocks.get(0).getVariable().getType();
    }

    @Override
    default TryBlock setType(CodeType codeType) {
        return this;
    }

}
