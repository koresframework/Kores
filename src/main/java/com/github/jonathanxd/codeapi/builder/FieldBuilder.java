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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class FieldBuilder implements Builder<CodeField>,
        ModifiersBuilder<CodeField, FieldBuilder>,
        AnnotationsBuilder<CodeField, FieldBuilder>,
        NameBuilder<CodeField, FieldBuilder> {

    private List<Annotation> annotations = new ArrayList<>();
    private CodeType type = PredefinedTypes.VOID;
    private String name;
    private Collection<CodeModifier> modifiers = new ArrayList<>();
    private CodePart value = null;

    private FieldBuilder() {

    }

    public static FieldBuilder builder() {
        return new FieldBuilder();
    }

    /**
     * Set the type.
     *
     * @param type Type.
     * @return This.
     */
    public FieldBuilder withType(CodeType type) {
        this.type = type;
        return this;
    }

    /**
     * Set the type.
     *
     * @param type Type.
     * @return This.
     */
    public FieldBuilder withType(Class<?> type) {
        return this.withType(Helper.getJavaType(type));
    }

    @Override
    public FieldBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public FieldBuilder withModifiers(Collection<CodeModifier> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    @Override
    public FieldBuilder withAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
        return this;
    }

    @Override
    public CodeField build() {
        return new CodeField(this.name, this.type, this.value, this.modifiers, this.annotations);
    }

}
