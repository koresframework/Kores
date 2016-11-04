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
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.interfaces.ArrayLoad;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.Optional;

/**
 * Created by jonathan on 11/05/16.
 */
@GenerateTo(ArrayLoad.class)
public class ArrayLoadImpl implements ArrayLoad {

    private final CodePart index;
    private final CodePart target;
    private final CodeType valueType;

    public ArrayLoadImpl(CodePart index, CodePart target, CodeType valueType) {
        this.index = index;
        this.target = target;
        this.valueType = valueType;
    }

    @Override
    public CodePart getIndex() {
        return this.index;
    }

    @Override
    public ArrayLoadImpl setIndex(CodePart index) {
        return new ArrayLoadImpl(index, this.getTarget().orElse(null), this.getValueType());
    }

    @Override
    public CodeType getValueType() {
        return valueType;
    }

    @Override
    public ArrayLoadImpl setValueType(CodeType type) {
        return new ArrayLoadImpl(this.getIndex(), this.getTarget().orElse(null), type);
    }

    @Override
    public ArrayLoad setType(CodeType codeType) {
        return this.setValueType(codeType);
    }

    @Override
    public Optional<CodePart> getTarget() {
        return Optional.ofNullable(this.target);
    }

    @Override
    public ArrayLoadImpl setTarget(CodePart target) {
        return new ArrayLoadImpl(this.getIndex(), target, this.getValueType());
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("valueType", this.getValueType())
                .addOptional("target", this.getTarget())
                .add("index", this.getIndex())
                .toString();
    }
}