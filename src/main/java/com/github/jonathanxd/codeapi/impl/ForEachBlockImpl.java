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
import com.github.jonathanxd.codeapi.common.IterationType;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;
import com.github.jonathanxd.iutils.annotation.NotNull;
import com.github.jonathanxd.iutils.condition.Conditions;

import java.util.Optional;

/**
 * Created by jonathan on 11/05/16.
 */
@GenerateTo(ForEachBlock.class)
public class ForEachBlockImpl implements ForEachBlock {

    private final FieldDeclaration field;
    private final IterationType iterationType;
    private final CodePart iterableElement;
    private final CodeSource source;

    public ForEachBlockImpl(@NotNull FieldDeclaration field, @NotNull IterationType iterationType, @NotNull CodePart iterableElement, CodeSource source) {
        Conditions.checkNotNull(field);
        Conditions.checkNotNull(iterationType);
        Conditions.checkNotNull(iterableElement);
        this.field = field;
        this.iterationType = iterationType;
        this.iterableElement = iterableElement;
        this.source = source;
        Bodied.checkBody(this);
    }

    @Override
    public FieldDeclaration getField() {
        return this.field;
    }

    @Override
    public ForEachBlockImpl setField(FieldDeclaration fieldDeclaration) {
        return new ForEachBlockImpl(fieldDeclaration, this.getIterationType(), this.getIterableElement(), this.getBody().orElse(null));
    }

    @Override
    public IterationType getIterationType() {
        return this.iterationType;
    }

    @Override
    public ForEachBlockImpl setIterationType(IterationType iterationType) {
        return new ForEachBlockImpl(this.getField(), iterationType, this.getIterableElement(), this.getBody().orElse(null));
    }

    @Override
    public CodePart getIterableElement() {
        return this.iterableElement;
    }

    @Override
    public ForEachBlockImpl setIterableElement(CodePart element) {
        return new ForEachBlockImpl(this.getField(), this.getIterationType(), element, this.getBody().orElse(null));
    }

    @Override
    public Optional<CodeSource> getBody() {
        return Optional.ofNullable(this.source);
    }

    @Override
    public ForEachBlockImpl setBody(CodeSource body) {
        return new ForEachBlockImpl(this.getField(), this.getIterationType(), this.getIterableElement(), body);
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("iterationType", this.getIterationType())
                .add("field", this.getField())
                .add("iterable", this.getIterableElement())
                .toString();
    }

}
