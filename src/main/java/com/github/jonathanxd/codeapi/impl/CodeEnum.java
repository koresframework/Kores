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
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.EnumDeclaration;
import com.github.jonathanxd.codeapi.interfaces.EnumEntry;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@GenerateTo(EnumDeclaration.class)
public class CodeEnum implements EnumDeclaration {

    private final String qualifiedName;
    private final String name;
    private final CodeSource body;
    private final List<Annotation> annotations;
    private final Collection<CodeModifier> modifiers;
    private final List<CodeType> implementations;
    private final GenericSignature<GenericType> genericSignature;
    private final List<EnumEntry> entries;

    public CodeEnum(String qualifiedName,
                    CodeSource body,
                    List<Annotation> annotations,
                    Collection<CodeModifier> modifiers,
                    List<CodeType> implementations,
                    GenericSignature<GenericType> genericSignature,
                    List<EnumEntry> entries) {
        this.qualifiedName = qualifiedName;
        this.name = qualifiedName.substring(qualifiedName.lastIndexOf('.') + 1, qualifiedName.length());
        this.body = body;
        this.annotations = annotations == null ? Collections.emptyList() : Collections.unmodifiableList(annotations);
        this.modifiers = modifiers == null ? Collections.emptyList() : Collections.unmodifiableCollection(modifiers);
        this.implementations = implementations == null ? Collections.emptyList() : Collections.unmodifiableList(implementations);
        this.genericSignature = genericSignature == null ? GenericSignature.empty() : genericSignature;
        this.entries = entries == null ? Collections.emptyList() : Collections.unmodifiableList(entries);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public CodeEnum setName(String name) {
        String newName = (!this.getPackageName().isEmpty() ? this.getPackageName() + "." : "")+name;
        return this.setQualifiedName(newName);
    }

    @Override
    public Optional<CodeSource> getBody() {
        return Optional.ofNullable(this.body);
    }

    @Override
    public CodeEnum setBody(CodeSource body) {
        return new CodeEnum(this.getQualifiedName(), body, this.getAnnotations(), this.getModifiers(), this.getImplementations(), this.getGenericSignature(), this.getEntries());
    }

    @Override
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override
    public CodeEnum setAnnotations(List<Annotation> annotations) {
        return new CodeEnum(this.getQualifiedName(), this.getBody().orElse(null), annotations, this.getModifiers(), this.getImplementations(), this.getGenericSignature(), this.getEntries());
    }

    @Override
    public Collection<CodeModifier> getModifiers() {
        return this.modifiers;
    }

    @Override
    public CodeEnum setModifiers(Collection<CodeModifier> modifiers) {
        return new CodeEnum(this.getQualifiedName(), this.getBody().orElse(null), this.getAnnotations(), modifiers, this.getImplementations(), this.getGenericSignature(), this.getEntries());
    }

    @Override
    public List<CodeType> getImplementations() {
        return this.implementations;
    }

    @Override
    public CodeEnum setImplementations(List<CodeType> implementations) {
        return new CodeEnum(this.getQualifiedName(), this.getBody().orElse(null), this.getAnnotations(), this.getModifiers(), implementations, this.getGenericSignature(), this.getEntries());
    }

    @Override
    public GenericSignature<GenericType> getGenericSignature() {
        return this.genericSignature;
    }

    @Override
    public CodeEnum setGenericSignature(GenericSignature<GenericType> genericSignature) {
        return new CodeEnum(this.getQualifiedName(), this.getBody().orElse(null), this.getAnnotations(), this.getModifiers(), this.getImplementations(), genericSignature, this.getEntries());
    }

    @Override
    public List<EnumEntry> getEntries() {
        return this.entries;
    }

    @Override
    public CodeEnum setEntries(List<EnumEntry> entries) {
        return new CodeEnum(this.getQualifiedName(), this.getBody().orElse(null), this.getAnnotations(), this.getModifiers(), this.getImplementations(), this.getGenericSignature(), entries);
    }

    @Override
    public String getQualifiedName() {
        return this.qualifiedName;
    }

    @Override
    public CodeEnum setQualifiedName(String name) {
        return new CodeEnum(name, this.getBody().orElse(null), this.getAnnotations(), this.getModifiers(), this.getImplementations(), this.getGenericSignature(), this.getEntries());
    }

    @Override
    public String getType() {
        return this.getQualifiedName();
    }

    @Override
    public String getCanonicalName() {
        return this.getQualifiedName();
    }
}
