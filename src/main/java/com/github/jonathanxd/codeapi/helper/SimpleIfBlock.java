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
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.IfExpressionable;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.util.BiMultiVal;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 12/05/16.
 */
@GenerateTo(IfBlock.class)
public class SimpleIfBlock implements IfBlock {

    private final CodeSource body;
    private final List<CodePart> ifExprs;
    private final ElseBlock elseBlock;

    public SimpleIfBlock(CodeSource body, List<CodePart> ifExprs, ElseBlock elseBlock) {
        this.body = body;
        this.elseBlock = elseBlock;
        this.ifExprs = ifExprs == null ? Collections.emptyList() : Collections.unmodifiableList(ifExprs);
    }

    public SimpleIfBlock(CodeSource body, BiMultiVal<CodePart, IfExpr, Operator> ifExpressions, ElseBlock elseBlock) {
        this.body = body;
        this.elseBlock = elseBlock;

        Collection<CodePart> ifExprs = ifExpressions == null ? null : ifExpressions.toCollection();

        if (ifExpressions != null) {
            ifExprs.stream().forEach(IfExpressionable::check);
        }

        this.ifExprs = ifExprs == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList<>(ifExprs));
        Bodied.checkBody(this);
    }

    public static SimpleIfBlock instance(IfBlock ifBlock) {
        return new SimpleIfBlock(ifBlock.getBody().orElse(null), ifBlock.getIfExprsAndOps(), ifBlock.getElseBlock().orElse(null));
    }

    public static SimpleIfBlock instance(IfBlock ifBlock, CodeSource codeSource) {
        return new SimpleIfBlock(codeSource, ifBlock.getIfExprsAndOps(), ifBlock.getElseBlock().orElse(null));
    }

    @Override
    public Optional<CodeSource> getBody() {
        return Optional.ofNullable(body);
    }

    @Override
    public List<CodePart> getIfExprsAndOps() {
        return this.ifExprs;
    }

    @Override
    public Optional<ElseBlock> getElseBlock() {
        return Optional.ofNullable(elseBlock);
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("expressions", this.getIfExprsAndOps())
                .toString();
    }

}
