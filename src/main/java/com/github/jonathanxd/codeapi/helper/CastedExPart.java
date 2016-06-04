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
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.interfaces.Casted;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Optional;

/**
 * Created by jonathan on 11/05/16.
 */
@GenerateTo(Casted.class)
public class CastedExPart implements Casted<CastedExPart> {

    private final CodeType type;
    private final CodePart castedPart;

    public CastedExPart() {
        this(null, null);
    }

    public CastedExPart(CodeType type) {
        this(type, null);
    }

    public CastedExPart(CodePart castedPart) {
        this(null, castedPart);
    }

    public CastedExPart(CodeType type, CodePart castedPart) {
        this.type = type;
        this.castedPart = castedPart;
    }

    @Override
    public CastedExPart setCastedPart(CodePart castedPart) {
        return new CastedExPart(type, castedPart);
    }

    @Override
    public Optional<CodePart> getCastedPart() {
        return Optional.ofNullable(this.castedPart);
    }

    @Override
    public CastedExPart removeCastedPart() {
        return new CastedExPart(type, castedPart);
    }

    @Override
    public CastedExPart setType(CodeType type) {
        return new CastedExPart(type, castedPart);
    }

    @Override
    public Optional<CodeType> getType() {
        return Optional.ofNullable(this.type);
    }

    @Override
    public CastedExPart removeType() {
        return new CastedExPart(null, castedPart);
    }
}
