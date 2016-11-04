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

import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.interfaces.EnumValue;
import com.github.jonathanxd.codeapi.types.CodeType;

/**
 * Created by jonathan on 03/09/16.
 */
@GenerateTo(EnumValue.class)
public class EnumValueImpl implements EnumValue {

    private final CodeType enumType;
    private final String entry;
    private final int ordinal;

    public EnumValueImpl(CodeType enumType, String entry) {
        this(enumType, entry, -1);
    }

    public EnumValueImpl(CodeType enumType, String entry, int ordinal) {
        this.enumType = enumType;
        this.entry = entry;
        this.ordinal = ordinal;
    }

    @Override
    public EnumValueImpl setName(String name) {
        return this.setEnumValue(name);
    }

    @Override
    public EnumValueImpl setType(CodeType codeType) {
        return this.setEnumType(codeType);
    }

    @Override
    public CodeType getEnumType() {
        return this.enumType;
    }

    @Override
    public EnumValueImpl setEnumType(CodeType codeType) {
        return new EnumValueImpl(codeType, this.getEnumValue(), this.getOrdinal());
    }

    @Override
    public String getEnumValue() {
        return this.entry;
    }

    @Override
    public EnumValueImpl setEnumValue(String entry) {
        return new EnumValueImpl(this.getEnumType(), entry, this.getOrdinal());
    }

    @Override
    public int getOrdinal() {
        return this.ordinal;
    }

    @Override
    public EnumValue setOrdinal(int ordinal) {
        return new EnumValueImpl(this.getEnumType(), this.getEnumValue(), ordinal);
    }
}
