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
import com.github.jonathanxd.codeapi.abs.AbstractValuableModifierable;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
@GenerateTo(FieldDeclaration.class)
public class CodeField extends AbstractValuableModifierable implements FieldDeclaration {
    private final String name;
    private final CodeType type;
    private final List<Annotation> annotations;

    public CodeField(String name, CodeType type, Collection<CodeModifier> modifiers) {
        this(name, type, null, modifiers);
    }

    public CodeField(String name, CodeType type) {
        this(name, type, null, null);
    }

    public CodeField(String name, CodeType type, CodePart value, Collection<CodeModifier> modifiers) {
        this(name, type, value, modifiers, Collections.emptyList());
    }

    public CodeField(String name, CodeType type, CodePart value) {
        this(name, type, value, Collections.emptyList());
    }

    public CodeField(String name, CodeType type, CodePart value, Collection<CodeModifier> modifiers, List<Annotation> annotations) {
        super(modifiers, value);
        this.name = name;
        this.type = type;
        this.annotations = annotations == null ? Collections.emptyList() : Collections.unmodifiableList(annotations);
    }

    public Optional<CodeType> getType() {
        return java.util.Optional.ofNullable(type);
    }

    @Override
    public CodeType getLocalization() {
        return this.type;
    }

    @Override
    public CodePart getAt() {
        return Helper.accessLocal();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override
    public CodeType getVariableType() {
        return this.type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("at", this.getAt())
                .add("modifiers", this.getModifiers())
                .add("type", this.getVariableType().getCanonicalName())
                .add("name", this.getName())
                .addOptional("value", this.getValue())
                .toString();
    }
}
