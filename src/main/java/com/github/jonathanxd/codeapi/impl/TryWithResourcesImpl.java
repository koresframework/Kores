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
package com.github.jonathanxd.codeapi.impl;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.helper.TryCatchBlock;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.TryWithResources;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;

import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 04/09/16.
 */
@GenerateTo(TryWithResources.class)
public class TryWithResourcesImpl extends TryCatchBlock implements TryWithResources {

    private final VariableDeclaration variable;

    public TryWithResourcesImpl(VariableDeclaration variable, CodeSource body) {
        super(body);
        this.variable = variable;
    }

    public TryWithResourcesImpl(VariableDeclaration variable, CatchBlock catchBlock, CodeSource body) {
        super(catchBlock, body);
        this.variable = variable;
    }

    public TryWithResourcesImpl(VariableDeclaration variable, List<CatchBlock> catchBlocks, CodeSource body) {
        super(catchBlocks, body);
        this.variable = variable;
    }

    public TryWithResourcesImpl(VariableDeclaration variable, CatchBlock catchBlock, CodeSource body, CodeSource finallyBlock) {
        super(catchBlock, body, finallyBlock);
        this.variable = variable;
    }

    public TryWithResourcesImpl(VariableDeclaration variable, List<CatchBlock> catchBlocks, CodeSource body, CodeSource finallyBlock) {
        super(catchBlocks, body, finallyBlock);
        this.variable = variable;
    }

    @Override
    public VariableDeclaration getVariable() {
        return this.variable;
    }

    @Override
    public Optional<CodePart> getExpression() {
        return TryWithResources.super.getExpression();
    }
}
