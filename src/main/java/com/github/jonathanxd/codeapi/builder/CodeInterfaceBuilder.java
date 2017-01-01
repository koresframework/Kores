/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.builder;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Collection;
import java.util.List;

/**
 * Created by jonathan on 04/06/16.
 */
public final class CodeInterfaceBuilder {
    private CodeType outerClass;
    private CodeSource body;
    private String qualifiedName;
    private List<CodeType> implementations;
    private Collection<CodeModifier> modifiers;

    private CodeInterfaceBuilder() {
    }

    public static CodeInterfaceBuilder builder() {
        return new CodeInterfaceBuilder();
    }

    public CodeInterfaceBuilder withOuterClass(CodeType outerClass) {
        this.outerClass = outerClass;
        return this;
    }

    public CodeInterfaceBuilder withBody(CodeSource body) {
        this.body = body;
        return this;
    }

    public CodeInterfaceBuilder withQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
        return this;
    }

    public CodeInterfaceBuilder withImplementations(List<CodeType> implementations) {
        this.implementations = implementations;
        return this;
    }

    public CodeInterfaceBuilder withModifiers(List<CodeModifier> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public CodeInterface build() {
        return new CodeInterface(outerClass, qualifiedName, modifiers, implementations, body);
    }
}
