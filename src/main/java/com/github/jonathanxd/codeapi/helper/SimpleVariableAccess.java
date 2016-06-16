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
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Optional;

/**
 * Created by jonathan on 10/05/16.
 */
//
@GenerateTo(VariableAccess.class)
public class SimpleVariableAccess implements CodePart, VariableAccess {
    private final CodeType localization;
    private final CodePart at;
    private final String name;
    private final CodeType variableType;

    public SimpleVariableAccess(CodeType localization, String name, CodeType variableType) {
        this(localization, null, name, variableType);
    }

    public SimpleVariableAccess(CodeType localization, CodePart at, String name, CodeType variableType) {
        this.localization = localization;
        this.at = at;
        this.name = name;
        this.variableType = variableType;
    }

    @Override
    public CodeType getLocalization() {
        return localization;
    }

    @Override
    public CodePart getAt() {
        return at;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CodeType getVariableType() {
        return variableType;
    }

    @Override
    public Optional<CodeType> getType() {
        return Optional.ofNullable(variableType);
    }
}
