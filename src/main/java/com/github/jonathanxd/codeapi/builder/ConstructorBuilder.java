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
package com.github.jonathanxd.codeapi.builder;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.interfaces.Annotation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ConstructorBuilder implements Builder<CodeConstructor>,
        ModifiersBuilder<CodeConstructor, ConstructorBuilder>,
        BodyBuilder<CodeConstructor, ConstructorBuilder>,
        AnnotationsBuilder<CodeConstructor, ConstructorBuilder>,
        ParameterBuilder<CodeConstructor, ConstructorBuilder> {

    private List<Annotation> annotations = new ArrayList<>();
    private List<CodeParameter> parameterList = new ArrayList<>();
    private Collection<CodeModifier> modifiers = new ArrayList<>();
    private CodeSource body = CodeSource.empty();

    private ConstructorBuilder() {

    }

    public static ConstructorBuilder builder() {
        return new ConstructorBuilder();
    }

    @Override
    public ConstructorBuilder withParameters(List<CodeParameter> parameters) {
        this.parameterList = parameters;
        return this;
    }

    @Override
    public ConstructorBuilder withModifiers(Collection<CodeModifier> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    @Override
    public ConstructorBuilder withBody(CodeSource body) {
        this.body = body;
        return this;
    }

    @Override
    public ConstructorBuilder withAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
        return this;
    }

    @Override
    public CodeConstructor build() {
        return new CodeConstructor(this.modifiers, this.parameterList, this.annotations, this.body);
    }

}
