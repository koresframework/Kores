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

import com.github.jonathanxd.codeapi.CodeElement;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.abs.AbstractValuableModifierable;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.CodeModifier;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
public class CodeField extends AbstractValuableModifierable<CodeField> implements CodeElement, Named<CodeField>, Typed<CodeField> {
    private final String name;
    private final CodeType type;

    public CodeField(String name, CodeType type, Collection<CodeModifier> modifiers) {
        this(name, type, modifiers, null);
    }

    public CodeField(String name, CodeType type, Collection<CodeModifier> modifiers, CodePart value) {
        super(modifiers, value);
        this.name = name;
        this.type = type;
    }

    public Optional<CodeType> getType() {
        return java.util.Optional.ofNullable(type);
    }

    @Override
    public CodeField setType(CodeType type) {
        return new CodeField(name, type, getModifiers(), getValue().orElse(null));
    }

    @Override
    public CodeField removeType() {
        return new CodeField(name, null, getModifiers(), getValue().orElse(null));

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected CodeField newInstance(Collection<CodeModifier> modifiers, CodePart value) {
        return new CodeField(name, type, modifiers, value);
    }
}
