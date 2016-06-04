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
package com.github.jonathanxd.codeapi.helper;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.abs.AbstractStorage;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.annotation.Store;
import com.github.jonathanxd.codeapi.interfaces.Bodiable;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 11/05/16.
 */
@GenerateTo(TryBlock.class)
public class TryCatchBlock extends AbstractStorage implements TryBlock<TryCatchBlock> {

    @Store(CodeSource.class)
    private final List<CodeSource> bodies;
    // TODO: Change, do it like If-Else
    private final Collection<CatchBlock> catchBlocks = new ArrayList<>();
    private final Bodiable finallyBlock;
    private final CodePart expression;

    public TryCatchBlock(List<CodeSource> bodies) {
        this(null, null, bodies, null);
    }

    public TryCatchBlock(CodePart expression, List<CodeSource> bodies) {
        this(expression, null, bodies, null);
    }

    public TryCatchBlock(CodePart expression, Collection<CatchBlock> catchBlocks, List<CodeSource> bodies) {
        this(expression, catchBlocks, bodies, null);
    }

    public TryCatchBlock(CodePart expression, Collection<CatchBlock> catchBlocks, List<CodeSource> bodies, Bodiable finallyBlock) {
        this.expression = expression;
        this.bodies = Collections.unmodifiableList(bodies);

        if (catchBlocks != null)
            this.catchBlocks.addAll(catchBlocks);

        this.finallyBlock = finallyBlock;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<CatchBlock> getCatchBlocks() {
        return catchBlocks;
    }

    @Override
    public Optional<Bodiable> getFinallyBlock() {
        return Optional.ofNullable(finallyBlock);
    }

    @Override
    public TryCatchBlock addBody(CodeSource body) {
        return new TryCatchBlock(expression, catchBlocks, new ArrayList<CodeSource>(bodies){{
            add(body);
        }}, finallyBlock);
    }

    @Override
    public Collection<CodeSource> getBodies() {
        return this.bodies;
    }

    @Override
    public TryCatchBlock clearBodies() {
        return new TryCatchBlock(expression, catchBlocks, Collections.emptyList(), finallyBlock);
    }

    @Override
    public Optional<CodePart> getExpression() {
        return Optional.ofNullable(expression);
    }

    @Override
    public TryCatchBlock setExpression(CodePart expression) {
        return new TryCatchBlock(expression, catchBlocks, bodies, finallyBlock);
    }

    @Override
    public TryCatchBlock clearExpression() {
        return new TryCatchBlock(null, catchBlocks, bodies, finallyBlock);
    }
}
