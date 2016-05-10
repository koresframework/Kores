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
package com.github.jonathanxd.codeapi.impl;

import com.github.jonathanxd.codeapi.CodeElement;
import com.github.jonathanxd.codeapi.abs.AbstractBodiableParam;
import com.github.jonathanxd.codeapi.annotation.Store;
import com.github.jonathanxd.codeapi.interfaces.Bodiable;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.Parameterizable;
import com.github.jonathanxd.codeapi.interfaces.Returnable;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.CodeModifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by jonathan on 07/05/16.
 */
public class CodeMethod extends AbstractBodiableParam implements CodeElement, Returnable, Bodiable, Parameterizable, Named, Modifierable {
    private final String name;
    private CodeType returnType;
    @Store(CodeModifier.class)
    private final Collection<CodeModifier> modifiers = new ArrayList<>();

    public CodeMethod(String name) {
        this.name = name;
    }

    public Optional<CodeType> getReturnType() {
        return Optional.ofNullable(returnType);
    }

    public void setReturnType(CodeType returnType) {
        this.returnType = returnType;
    }

    @Override
    public void removeReturnType() {
        this.returnType = null;
    }

    public String getName() {
        return name;
    }

    @Override
    public void addModifier(CodeModifier modifier) {
        modifiers.add(modifier);
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
    public void clearModifiers() {
        modifiers.clear();
    }

}
