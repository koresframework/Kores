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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 11/05/16.
 */
@GenerateTo(CatchBlock.class)
public class CatchBlockImpl implements CatchBlock {

    private final CodeSource body;
    private final List<CodeType> exceptionTypes;
    private final FieldDeclaration field;

    public CatchBlockImpl(FieldDeclaration field, List<CodeType> exceptionTypes, CodeSource body) {
        this.field = field;
        this.exceptionTypes = exceptionTypes == null ? Collections.emptyList() : Collections.unmodifiableList(exceptionTypes);
        this.body = body;
        Bodied.checkBody(this);
    }

    @Override
    public Optional<CodeSource> getBody() {
        return Optional.ofNullable(body);
    }

    @Override
    public List<CodeType> getExceptionTypes() {
        return this.exceptionTypes;
    }

    @Override
    public CatchBlockImpl setExceptionTypes(List<CodeType> typeList) {
        return null;
    }

    @Override
    public FieldDeclaration getField() {
        return this.field;
    }

    @Override
    public CatchBlockImpl setField(FieldDeclaration codeField) {
        return new CatchBlockImpl(codeField, this.getExceptionTypes(), this.getBody().orElse(null));
    }

    @Override
    public CatchBlockImpl setType(CodeType codeType) {
        return new CatchBlockImpl(this.getField().setType(codeType), this.getExceptionTypes(), this.getBody().orElse(null));
    }

    @Override
    public CatchBlockImpl setBody(CodeSource body) {
        return new CatchBlockImpl(this.getField(), this.getExceptionTypes(), body);
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("exceptionTypes", this.getExceptionTypes())
                .add("field", this.getField())
                .toString();
    }
}
