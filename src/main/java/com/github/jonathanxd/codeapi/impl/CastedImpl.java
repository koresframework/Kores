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
import com.github.jonathanxd.codeapi.interfaces.Casted;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.Optional;

/**
 * Created by jonathan on 11/05/16.
 */
@GenerateTo(Casted.class)
public class CastedImpl implements Casted {

    private final CodeType originalType;
    private final CodeType type;
    private final CodePart castedPart;

    public CastedImpl(CodeType originalType, CodeType type, CodePart castedPart) {
        this.originalType = originalType;
        this.type = type;
        this.castedPart = castedPart;
    }

    @Override
    public Optional<CodePart> getCastedPart() {
        return Optional.ofNullable(this.castedPart);
    }

    @Override
    public CastedImpl setCastedPart(CodePart part) {
        return new CastedImpl(this.getOriginalType(), this.getType().orElse(null), part);
    }

    @Override
    public Optional<CodeType> getType() {
        return Optional.ofNullable(this.type);
    }

    @Override
    public CastedImpl setType(CodeType codeType) {
        return new CastedImpl(this.getOriginalType(), codeType, this.getCastedPart().orElse(null));
    }

    @Override
    public CodeType getOriginalType() {
        return this.originalType;
    }

    @Override
    public CastedImpl setOriginalType(CodeType codeType) {
        return new CastedImpl(codeType, this.getType().orElse(null), this.getCastedPart().orElse(null));
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("originalType", this.getOriginalType())
                .addOptional("targetType", this.getType())
                .add("casted", this.getCastedPart())
                .toString();
    }
}