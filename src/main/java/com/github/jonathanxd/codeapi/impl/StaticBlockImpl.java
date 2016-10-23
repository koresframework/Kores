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
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.StaticBlock;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.Collection;
import java.util.List;

/**
 * Created by jonathan on 15/05/16.
 */
@GenerateTo(StaticBlock.class)
public class StaticBlockImpl extends CodeMethod implements StaticBlock {

    public StaticBlockImpl(CodeSource body) {
        super(StaticBlock.Constants.NAME, StaticBlock.Constants.MODIFIERS, StaticBlock.Constants.PARAMETERS, StaticBlock.Constants.RETURN_TYPE, body);
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .toString();
    }

    @Override
    public StaticBlockImpl setName(String name) {
        return this;
    }

    @Override
    public StaticBlockImpl setAnnotations(List<Annotation> annotations) {
        return this;
    }

    @Override
    public StaticBlockImpl setReturnType(CodeType returnType) {
        return this;
    }

    @Override
    public StaticBlockImpl setParameters(List<CodeParameter> codeParameters) {
        return this;
    }

    @Override
    public StaticBlockImpl setModifiers(Collection<CodeModifier> modifiers) {
        return this;
    }

    @Override
    public StaticBlockImpl setGenericSignature(GenericSignature<GenericType> genericSignature) {
        return this;
    }

    @Override
    public StaticBlockImpl setBody(CodeSource body) {
        return new StaticBlockImpl(body);
    }
}
