/*
 *      ${expr} - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
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
package com.github.jonathanxd.codeapi.decorate;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.exceptions.UnsupportedElementTypeException;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.storage.StorageKey;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.CodeModifier;
import com.github.jonathanxd.codeapi.util.CodeParameter;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by jonathan on 10/05/16.
 */
public final class DecoratedMethod extends CodeMethod {

    private final CodeMethod codeMethod;
    private final boolean isExpression;

    public DecoratedMethod(CodeMethod codeMethod, boolean isExpression) {
        super(codeMethod.getName());
        this.codeMethod = codeMethod;
        this.isExpression = isExpression;
    }

    @Override
    public Optional<CodeType> getReturnType() {
        return codeMethod.getReturnType();
    }

    @Override
    public void setReturnType(CodeType returnType) {
        codeMethod.setReturnType(returnType);
    }

    @Override
    public void removeReturnType() {
        codeMethod.removeReturnType();
    }

    @Override
    public void addModifier(CodeModifier modifier) {
        codeMethod.addModifier(modifier);
    }

    @Override
    public Collection<CodeModifier> getModifiers() {
        return codeMethod.getModifiers();
    }

    @Override
    public void clearModifiers() {
        codeMethod.clearModifiers();
    }

    @Override
    public void addParameter(CodeParameter parameter) {
        codeMethod.addParameter(parameter);
    }

    @Override
    public void clearParameters() {
        codeMethod.clearParameters();
    }

    @Override
    public Collection<CodeParameter> getParameters() {
        return codeMethod.getParameters();
    }

    @Override
    public void addBody(CodeSource body) {
        codeMethod.addBody(body);
    }

    @Override
    public Collection<CodeSource> getBodies() {
        return codeMethod.getBodies();
    }

    @Override
    public void clearBodies() {
        codeMethod.clearBodies();
    }

    @Override
    public <T> Optional<Collection<T>> getStore(StorageKey<? extends T> elementType) {
        return codeMethod.getStore(elementType);
    }

    @Override
    public <T> boolean supports(StorageKey<? extends T> key) {
        return codeMethod.supports(key);
    }

    @Override
    public <T> boolean add(StorageKey<T> elementKey, T element) throws UnsupportedElementTypeException {
        return codeMethod.add(elementKey, element);
    }

    @Override
    public <T> boolean addAll(StorageKey<T> elementKey, T... element) throws UnsupportedElementTypeException {
        return codeMethod.addAll(elementKey, element);
    }

    @Override
    public <T> boolean addAll(StorageKey<T> elementKey, Collection<? extends T> element) throws UnsupportedElementTypeException {
        return codeMethod.addAll(elementKey, element);
    }

    @Override
    public <T> void clear(StorageKey<? extends T> elementKey) throws UnsupportedElementTypeException {
        codeMethod.clear(elementKey);
    }

    @Override
    public <T> Collection<T> getUnchecked(StorageKey<? extends T> elementKey) throws UnsupportedElementTypeException {
        return codeMethod.getUnchecked(elementKey);
    }

    @Override
    public boolean isExpression() {
        return isExpression;
    }

    @Override
    public String getName() {
        return codeMethod.getName();
    }
}
