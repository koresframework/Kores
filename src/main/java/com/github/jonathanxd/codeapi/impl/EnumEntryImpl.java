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
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.interfaces.EnumEntry;

import java.util.List;
import java.util.Optional;

@GenerateTo(EnumEntry.class)
public class EnumEntryImpl implements EnumEntry {

    private final String name;
    private final CodeSource body;
    private final TypeSpec constructorSpec;
    private final List<CodeArgument> constructorArguments;

    public EnumEntryImpl(String name, CodeSource body, TypeSpec constructorSpec, List<CodeArgument> constructorArguments) {
        this.name = name;
        this.body = body;
        this.constructorSpec = constructorSpec;
        this.constructorArguments = constructorArguments;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public EnumEntryImpl setName(String name) {
        return new EnumEntryImpl(name, this.getBody().orElse(null), this.getConstructorSpec().orElse(null), this.getArguments());
    }

    @Override
    public Optional<CodeSource> getBody() {
        return Optional.ofNullable(this.body);
    }

    @Override
    public EnumEntryImpl setBody(CodeSource body) {
        return new EnumEntryImpl(this.getName(), body, this.getConstructorSpec().orElse(null), this.getArguments());
    }

    @Override
    public Optional<TypeSpec> getConstructorSpec() {
        return Optional.ofNullable(this.constructorSpec);
    }

    @Override
    public EnumEntryImpl setConstructorSpec(TypeSpec spec) {
        return new EnumEntryImpl(this.getName(), this.getBody().orElse(null), spec, this.getArguments());
    }

    @Override
    public List<CodeArgument> getArguments() {
        return this.constructorArguments;
    }

    @Override
    public EnumEntryImpl setArguments(List<CodeArgument> arguments) {
        return new EnumEntryImpl(this.getName(), this.getBody().orElse(null), this.getConstructorSpec().orElse(null), arguments);
    }
}
