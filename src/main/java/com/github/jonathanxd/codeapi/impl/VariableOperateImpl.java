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
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.Optional;

/**
 * Created by jonathan on 10/05/16.
 */
//
@GenerateTo(VariableOperate.class)
public class VariableOperateImpl extends VariableDeclarationImpl implements CodePart, VariableOperate {

    private final Operator operation;

    public VariableOperateImpl(CodeType localization, String name, CodeType variableType, Operator operation, CodePart value) {
        super(localization, name, variableType, value);
        this.operation = operation;
    }

    public VariableOperateImpl(CodeType localization, CodePart at, String name, CodeType variableType, Operator operation, CodePart value) {
        super(localization, at, name, variableType, value);
        this.operation = operation;
    }

    @Override
    public Optional<Operator> getOperation() {
        return Optional.ofNullable(operation);
    }

    @Override
    public VariableOperateImpl setOperation(Operator operation) {
        return new VariableOperateImpl(this.getLocalization().orElse(null), this.getTarget().orElse(null), this.getName(), this.getVariableType(), operation, this.getValue().orElse(null));
    }

    @Override
    public VariableOperateImpl setValue(CodePart value) {
        return new VariableOperateImpl(this.getLocalization().orElse(null), this.getTarget().orElse(null), this.getName(), this.getVariableType(), this.getOperation().orElse(null), value);
    }

    @Override
    public VariableOperateImpl setLocalization(CodeType localization) {
        return new VariableOperateImpl(localization, this.getTarget().orElse(null), this.getName(), this.getVariableType(), this.getOperation().orElse(null), this.getValue().orElse(null));
    }

    @Override
    public VariableOperateImpl setTarget(CodePart at) {
        return new VariableOperateImpl(this.getLocalization().orElse(null), at, this.getName(), this.getVariableType(), this.getOperation().orElse(null), this.getValue().orElse(null));
    }

    @Override
    public VariableOperateImpl setName(String name) {
        return new VariableOperateImpl(this.getLocalization().orElse(null), this.getTarget().orElse(null), name, this.getVariableType(), this.getOperation().orElse(null), this.getValue().orElse(null));
    }

    @Override
    public VariableOperateImpl setVariableType(CodeType type) {
        return new VariableOperateImpl(this.getLocalization().orElse(null), this.getTarget().orElse(null), this.getName(), type, this.getOperation().orElse(null), this.getValue().orElse(null));
    }

    @Override
    public VariableOperateImpl setType(CodeType codeType) {
        return this.setVariableType(codeType);
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("localization", this.getLocalization())
                .add("at", this.getTarget())
                .add("type", this.getVariableType())
                .add("name", this.getName())
                .addOptional("operation", this.getOperation())
                .addOptional("value", this.getValue())
                .toString();
    }
}
