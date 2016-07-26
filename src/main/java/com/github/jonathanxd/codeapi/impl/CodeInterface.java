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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.abs.AbstractBodied;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.interfaces.InterfaceDeclaration;
import com.github.jonathanxd.codeapi.types.ClassType;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by jonathan on 09/05/16.
 */
@GenerateTo(InterfaceDeclaration.class)
public class CodeInterface extends AbstractBodied implements InterfaceDeclaration {

    private final String name;
    private final String qualifiedName;
    private final Collection<CodeType> implementations;
    private final Collection<CodeModifier> modifiers;
    private final GenericSignature<GenericType> signature;

    public CodeInterface(String qualifiedName, Collection<CodeModifier> modifiers, Collection<CodeType> implementations, CodeSource body) {
        this(qualifiedName, modifiers, implementations, GenericSignature.empty(), body);
    }

    public CodeInterface(String qualifiedName, Collection<CodeModifier> modifiers, Collection<CodeType> implementations, GenericSignature<GenericType> signature, CodeSource body) {
        super(body);
        this.qualifiedName = qualifiedName;
        this.name = qualifiedName.substring(qualifiedName.lastIndexOf('.') + 1, qualifiedName.length());
        this.modifiers = modifiers == null ? Collections.emptyList() : Collections.unmodifiableCollection(modifiers);
        this.implementations = implementations == null ? Collections.emptyList() : Collections.unmodifiableCollection(implementations);
        this.signature = signature != null ? signature : GenericSignature.empty();
    }

    @Override
    public String getCanonicalName() {
        return this.getQualifiedName();
    }

    @Override
    public String getType() {
        return this.qualifiedName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<CodeType> getImplementations() {
        return implementations;
    }

    @Override
    public Collection<CodeModifier> getModifiers() {
        return modifiers;
    }

    @Override
    public String getQualifiedName() {
        return qualifiedName;
    }

    @Override
    public GenericSignature<GenericType> getGenericSignature() {
        return this.signature;
    }

    @Override
    public boolean isExpression() {
        return true;
    }

    @Override
    public boolean isInterface() {
        return this.getClassType() == ClassType.INTERFACE;
    }

}
