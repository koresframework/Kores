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
package com.github.jonathanxd.codeapi.abs;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.annotation.Store;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.Valuable;
import com.github.jonathanxd.codeapi.util.CodeModifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
public abstract class AbstractValuableModifierable<T extends AbstractValuableModifierable<T>> extends AbstractStorage implements Valuable<T>, Modifierable<T> {

    @Store(CodeModifier.class)
    private final Collection<CodeModifier> modifiers;
    private final CodePart value;

    protected AbstractValuableModifierable(Collection<CodeModifier> modifiers, CodePart value) {
        this.modifiers = modifiers;
        this.value = value;
    }

    @Override
    public T addModifier(CodeModifier modifier) {
        //return newInstance(modifiers, value);
        return newInstance(new ArrayList<CodeModifier>(modifiers){{
            add(modifier);
        }}, value);

    }

    @Override
    public Collection<CodeModifier> getModifiers() {
        return modifiers;
    }

    @Override
    public T clearModifiers() {
        return newInstance(Collections.emptyList(), value);
    }

    @Override
    public Optional<CodePart> getValue() {
        return Optional.ofNullable(this.value);
    }

    @Override
    public T setValue(CodePart value) {
        return newInstance(modifiers, value);
    }

    @Override
    public T removeValue() {
        return newInstance(modifiers, null);
    }

    protected abstract T newInstance(Collection<CodeModifier> modifiers, CodePart value);

}
