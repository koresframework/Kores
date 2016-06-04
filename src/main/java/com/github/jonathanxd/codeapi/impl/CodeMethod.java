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
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.abs.AbstractBodiedParam;
import com.github.jonathanxd.codeapi.annotation.Store;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.Parameterizable;
import com.github.jonathanxd.codeapi.interfaces.Returnable;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.CodeModifier;
import com.github.jonathanxd.codeapi.util.CodeParameter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by jonathan on 07/05/16.
 */
public class CodeMethod<T extends CodeMethod<T>> extends AbstractBodiedParam<T> implements CodeElement, Returnable<T>, Bodied<T>, Parameterizable<T>, Named<T>, Modifierable<T> {
    private final String name;
    @Store(CodeModifier.class)
    private final Collection<CodeModifier> modifiers;
    private final CodeType returnType;

    public CodeMethod(String name, Collection<CodeModifier> modifiers, Collection<CodeParameter> parameters, CodeType returnType, CodeSource body) {
        super(parameters, body);
        this.name = name;
        this.modifiers = modifiers == null ? Collections.emptyList() : Collections.unmodifiableCollection(modifiers);
        this.returnType = returnType;
    }

    public Optional<CodeType> getReturnType() {
        return Optional.ofNullable(returnType);
    }

    public T setReturnType(CodeType returnType) {
        return newInstance(getName(), getModifiers(), getParameters(), returnType, getBody().orElse(null));
    }

    @Override
    public T removeReturnType() {
        return newInstance(getName(), getModifiers(), getParameters(), null, getBody().orElse(null));
    }

    public String getName() {
        return name;
    }

    @Override
    public T addModifier(CodeModifier modifier) {
        return newInstance(getName(), new ArrayList<CodeModifier>(getModifiers()){{
            add(modifier);
        }}, getParameters(), getReturnType().orElse(null), getBody().orElse(null));
    }

    @Override
    public boolean isExpression() {
        return true;
    }

    @Override
    public Collection<CodeModifier> getModifiers() {
        return modifiers;
    }

    @Override
    public T clearModifiers() {
        //return newInstance(getName(), getModifiers(), getParameters(), getReturnType().orElse(null), getBody().orElse(null));
        return newInstance(getName(), Collections.emptyList(), getParameters(), getReturnType().orElse(null), getBody().orElse(null));
    }

    @SuppressWarnings("unchecked")
    @Override
    protected T newInstance(Collection<CodeParameter> parameters, CodeSource body) {
        return (T) new CodeMethod<>(getName(), getModifiers(), parameters, getReturnType().orElse(null), body);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected T newInstance(CodeSource body) {
        return (T) new CodeMethod<>(getName(), getModifiers(), getParameters(), getReturnType().orElse(null), body);
    }

    @SuppressWarnings("unchecked")
    protected T newInstance(String name, Collection<CodeModifier> modifiers, Collection<CodeParameter> parameters, CodeType returnType, CodeSource body) {
        return (T) new CodeMethod<>(name, modifiers, parameters, returnType, body);
    }
}
