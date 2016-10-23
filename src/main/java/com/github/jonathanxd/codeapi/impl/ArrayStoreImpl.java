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
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

/**
 * Created by jonathan on 11/05/16.
 */
@GenerateTo(ArrayStore.class)
public class ArrayStoreImpl extends ArrayLoadImpl implements ArrayStore {

    private final CodePart value;

    public ArrayStoreImpl(CodePart index, CodePart target, CodeType valueType, CodePart value) {
        super(index, target, valueType);
        this.value = value;
    }

    @Override
    public CodePart getValueToStore() {
        return this.value;
    }

    @Override
    public ArrayStoreImpl setValueToStore(CodePart valueToStore) {
        return new ArrayStoreImpl(this.getIndex(), this.getTarget().orElse(null), this.getValueType(), valueToStore);
    }

    @Override
    public ArrayStoreImpl setValue(CodePart value) {
        return this.setValueToStore(value);
    }

    @Override
    public ArrayStoreImpl setIndex(CodePart index) {
        return new ArrayStoreImpl(index, this.getTarget().orElse(null), this.getValueType(), this.getValueToStore());
    }

    @Override
    public ArrayStoreImpl setValueType(CodeType type) {
        return new ArrayStoreImpl(this.getIndex(), this.getTarget().orElse(null), type, this.getValueToStore());
    }

    @Override
    public ArrayStoreImpl setTarget(CodePart target) {
        return new ArrayStoreImpl(this.getIndex(), target, this.getValueType(), this.getValueToStore());
    }

    @Override
    public ArrayStoreImpl setType(CodeType codeType) {
        return this.setValueType(codeType);
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("valueType", this.getValueType())
                .addOptional("target", this.getTarget())
                .add("index", this.getIndex())
                .add("value", this.getValueToStore())
                .toString();
    }
}
