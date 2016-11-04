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
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.WhileBlock;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.util.BiMultiVal;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.List;

/**
 * Created by jonathan on 15/05/16.
 */
@GenerateTo(WhileBlock.class)
public class WhileBlockImpl extends IfBlockImpl implements WhileBlock {

    public WhileBlockImpl(BiMultiVal<CodePart, IfExpr, Operator> expression, CodeSource body) {
        super(body, expression, null);
    }

    public WhileBlockImpl(CodeSource body, List<CodePart> ifExprs) {
        super(body, ifExprs, null);
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("expressions", this.getIfExprsAndOps())
                .toString();
    }

    @Override
    public WhileBlockImpl setElseBlock(ElseBlock elseBlock) {
        return this;
    }

    @Override
    public WhileBlockImpl setBody(CodeSource body) {
        return new WhileBlockImpl(body, this.getIfExprsAndOps());
    }

    @Override
    public WhileBlockImpl setBodies(List<CodeSource> sourceList) {
        return this.setBody(CodeSource.fromCodeSourceIterable(sourceList));
    }

    @Override
    public WhileBlockImpl setIfExprsAndOps(List<CodePart> ifExprsAndOps) {
        return new WhileBlockImpl(this.getBody().orElse(null), ifExprsAndOps);
    }
}
