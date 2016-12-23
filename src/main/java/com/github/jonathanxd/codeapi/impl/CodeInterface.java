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
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.InterfaceDeclaration;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.GenericTypeUtil;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;
import com.github.jonathanxd.codeapi.util.CodeTypeUtil;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
@GenerateTo(TypeDeclaration.class)
public class CodeInterface extends AbstractBodied implements InterfaceDeclaration {

    private final CodeType outerClass;
    private final String name;
    private final String qualifiedName;
    private final List<CodeType> implementations;
    private final Collection<CodeModifier> modifiers;
    private final GenericSignature<GenericType> signature;
    private final List<Annotation> annotations;

    public CodeInterface(CodeType outerClass, String qualifiedName, Collection<CodeModifier> modifiers, List<CodeType> implementations, CodeSource body) {
        this(outerClass, qualifiedName, modifiers, implementations, GenericSignature.empty(), body);
    }

    public CodeInterface(CodeType outerClass, String qualifiedName, Collection<CodeModifier> modifiers, List<CodeType> implementations, GenericSignature<GenericType> signature, CodeSource body) {
        this(outerClass, qualifiedName, modifiers, implementations, signature, Collections.emptyList(), body);
    }

    public CodeInterface(CodeType outerClass, String qualifiedName, Collection<CodeModifier> modifiers, List<CodeType> implementations, GenericSignature<GenericType> signature, List<Annotation> annotations, CodeSource body) {

        super(body);
        this.outerClass = outerClass;
        this.qualifiedName = CodeTypeUtil.resolveRealQualified(qualifiedName, outerClass);
        this.name = qualifiedName.substring(qualifiedName.lastIndexOf('.') + 1, qualifiedName.length());
        this.modifiers = modifiers == null ? Collections.emptyList() : Collections.unmodifiableCollection(modifiers);
        this.implementations = implementations == null ? Collections.emptyList() : Collections.unmodifiableList(implementations);
        this.signature = signature != null ? signature : GenericSignature.empty();
        this.annotations = annotations == null ? Collections.emptyList() : Collections.unmodifiableList(annotations);
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
        return this.name;
    }

    @Override
    public CodeInterface setName(String name) {
        String newName = (!this.getPackageName().isEmpty() ? this.getPackageName() + "." : "") + name;
        return this.setQualifiedName(newName);
    }

    @Override
    public List<CodeType> getImplementations() {
        return this.implementations;
    }

    @Override
    public CodeInterface setImplementations(List<CodeType> implementations) {
        return new CodeInterface(this.getOuterClass().orElse(null), this.getQualifiedName(), this.getModifiers(), implementations, this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public Collection<CodeModifier> getModifiers() {
        return this.modifiers;
    }

    @Override
    public CodeInterface setModifiers(Collection<CodeModifier> modifiers) {
        return new CodeInterface(this.getOuterClass().orElse(null), this.getQualifiedName(), modifiers, this.getImplementations(), this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public String getQualifiedName() {
        return this.qualifiedName;
    }

    @Override
    public CodeInterface setQualifiedName(String name) {
        return new CodeInterface(this.getOuterClass().orElse(null), name, this.getModifiers(), this.getImplementations(), this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public GenericSignature<GenericType> getGenericSignature() {
        return this.signature;
    }

    @Override
    public CodeInterface setGenericSignature(GenericSignature<GenericType> genericSignature) {
        return new CodeInterface(this.getOuterClass().orElse(null), this.getQualifiedName(), this.getModifiers(), this.getImplementations(), genericSignature, this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override
    public CodeInterface setAnnotations(List<Annotation> annotations) {
        return new CodeInterface(this.getOuterClass().orElse(null), this.getQualifiedName(), this.getModifiers(), this.getImplementations(), this.getGenericSignature(), annotations, this.getBody().orElse(null));
    }

    @Override
    public boolean isExpression() {
        return true;
    }

    @Override
    public boolean isInterface() {
        return this.getClassType().isInterface();
    }

    @Override
    public Optional<CodeType> getOuterClass() {
        return Optional.ofNullable(this.outerClass);
    }

    @Override
    public CodeInterface setOuterClass(CodeType outerClass) {
        return new CodeInterface(outerClass, this.getQualifiedName(), this.getModifiers(), this.getImplementations(), this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("modifiers", this.getModifiers())
                .add("qualifiedName", this.getQualifiedName())
                .addMapped("genericSignature", this.getGenericSignature(), GenericSignature::isNotEmpty, GenericTypeUtil::toSourceString)
                .add("extends", this.getImplementations())
                .toString();
    }

    @Override
    public CodeInterface setBody(CodeSource body) {
        return new CodeInterface(this.getOuterClass().orElse(null), this.getQualifiedName(), this.getModifiers(), this.getImplementations(), this.getGenericSignature(), this.getAnnotations(), body);
    }
}
