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
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Collection;
import java.util.List;

/**
 * Created by jonathan on 04/06/16.
 */
public final class CodeConstructorBuilder {
    private CodeType declaringClass;
    private CodeSource body;
    private Collection<CodeModifier> modifiers;
    private List<CodeParameter> parameters;

    private CodeConstructorBuilder() {
    }

    public static CodeConstructorBuilder builder() {
        return new CodeConstructorBuilder();
    }

    public CodeConstructorBuilder withDeclaringClass(CodeType declaringClass) {
        this.declaringClass = declaringClass;
        return this;
    }

    public CodeConstructorBuilder withBody(CodeSource body) {
        this.body = body;
        return this;
    }

    public CodeConstructorBuilder withModifiers(Collection<CodeModifier> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public CodeConstructorBuilder withParameters(List<CodeParameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    public CodeConstructor build() {
        return new CodeConstructor(declaringClass, modifiers, parameters, body);
    }
}
