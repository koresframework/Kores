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
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.util.BiMultiVal;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 15/05/16.
 */
@GenerateTo(ForBlock.class)
public class ForBlockImpl extends IfBlockImpl implements ForBlock {

    private final CodePart forInit;
    private final CodePart forUpdate;

    public ForBlockImpl(CodePart forInit, BiMultiVal<CodePart, IfExpr, Operator> forExpression, CodePart forUpdate, CodeSource body) {
        super(body, forExpression, null);
        this.forInit = forInit;
        this.forUpdate = forUpdate;
        Bodied.checkBody(this);
    }

    public ForBlockImpl(CodePart forInit, List<CodePart> forExpression, CodePart forUpdate, CodeSource body) {
        super(body, forExpression, null);
        this.forInit = forInit;
        this.forUpdate = forUpdate;
        Bodied.checkBody(this);
    }

    @Override
    public Optional<CodePart> getForInit() {
        return Optional.ofNullable(this.forInit);
    }

    @Override
    public ForBlockImpl setForInit(CodePart init) {
        return new ForBlockImpl(init, this.getForExpression(), this.getForUpdate().orElse(null), this.getBody().orElse(null));
    }

    @Override
    public List<CodePart> getForExpression() {
        return super.getIfExprsAndOps();
    }

    @Override
    public ForBlockImpl setForExpression(List<CodePart> expression) {
        return new ForBlockImpl(this.getForInit().orElse(null), expression, this.getForUpdate().orElse(null), this.getBody().orElse(null));
    }

    @Override
    public Optional<CodePart> getForUpdate() {
        return Optional.ofNullable(this.forUpdate);
    }

    @Override
    public ForBlockImpl setForUpdate(CodePart update) {
        return new ForBlockImpl(this.getForInit().orElse(null), this.getForExpression(), update, this.getBody().orElse(null));
    }

    @Override
    public ForBlockImpl setElseBlock(ElseBlock elseBlock) {
        return this;
    }

    @Override
    public ForBlockImpl setBody(CodeSource body) {
        return new ForBlockImpl(this.getForInit().orElse(null), this.getForExpression(), this.getForUpdate().orElse(null), body);
    }

    @Override
    public ForBlockImpl setBodies(List<CodeSource> sourceList) {
        return this.setBody(new CodeSource(sourceList));
    }

    @Override
    public ForBlockImpl setIfExprsAndOps(List<CodePart> ifExprsAndOps) {
        return new ForBlockImpl(this.getForInit().orElse(null), ifExprsAndOps, this.getForUpdate().orElse(null), this.getBody().orElse(null));
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .addOptional("init", this.getForInit())
                .add("expressions", this.getIfExprsAndOps())
                .addOptional("update", this.getForUpdate())
                .toString();
    }

}
