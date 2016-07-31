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
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.interfaces.Expression;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.util.BiMultiVal;

import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 15/05/16.
 */
@GenerateTo(ForBlock.class)
public class SimpleForBlock extends SimpleIfBlock implements ForBlock {

    private final CodePart forInit;
    private final CodePart forUpdate;
    private final CodeSource body;

    public SimpleForBlock(CodePart forInit, BiMultiVal<CodePart, IfExpr, Operator> forExpression, CodePart forUpdate, CodeSource body) {
        super(body, forExpression, null);
        this.forInit = forInit;
        this.forUpdate = forUpdate;
        this.body = body;
    }

    @Override
    public Optional<CodeSource> getBody() {
        return Optional.ofNullable(body);
    }

    @Override
    public Optional<CodePart> getForInit() {
        return Optional.ofNullable(this.forInit);
    }

    @Override
    public List<CodePart> getForExpression() {
        return super.getIfExprsAndOps();
    }

    @Override
    public Optional<CodePart> getForUpdate() {
        return Optional.ofNullable(this.forUpdate);
    }

}
