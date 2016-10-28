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
import com.github.jonathanxd.codeapi.abs.AbstractBodiedParam;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.GenericTypeUtil;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 07/05/16.
 */
@GenerateTo(MethodDeclaration.class)
public class CodeMethod extends AbstractBodiedParam implements MethodDeclaration {
    private final String name;
    private final Collection<CodeModifier> modifiers;
    private final GenericSignature<GenericType> signature;
    private final List<Annotation> annotations;
    private final CodeType returnType;

    public CodeMethod(String name, Collection<CodeModifier> modifiers, List<CodeParameter> parameters, CodeType returnType, CodeSource body) {
        this(name, modifiers, parameters, returnType, null, body);
    }

    public CodeMethod(String name, Collection<CodeModifier> modifiers, List<CodeParameter> parameters, CodeType returnType, GenericSignature<GenericType> signature, CodeSource body) {
        this(name, modifiers, parameters, returnType, signature, Collections.emptyList(), body);
    }

    public CodeMethod(String name, Collection<CodeModifier> modifiers, List<CodeParameter> parameters, CodeType returnType, GenericSignature<GenericType> signature, List<Annotation> annotations, CodeSource body) {
        super(parameters, body);
        this.name = name;
        this.modifiers = modifiers == null ? Collections.emptyList() : Collections.unmodifiableCollection(modifiers);
        this.signature = signature != null ? signature : GenericSignature.empty();
        this.returnType = returnType;
        this.annotations = annotations == null ? Collections.emptyList() : Collections.unmodifiableList(annotations);
    }

    @Override
    public Optional<CodeType> getReturnType() {
        return Optional.ofNullable(returnType);
    }

    @Override
    public CodeMethod setReturnType(CodeType returnType) {
        return new CodeMethod(this.getName(), this.getModifiers(), this.getParameters(), returnType, this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CodeMethod setName(String name) {
        return new CodeMethod(name, this.getModifiers(), this.getParameters(), this.getReturnType().orElse(null), this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
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
    public CodeMethod setModifiers(Collection<CodeModifier> modifiers) {
        return new CodeMethod(this.getName(), modifiers, this.getParameters(), this.getReturnType().orElse(null), this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public GenericSignature<GenericType> getGenericSignature() {
        return this.signature;
    }

    @Override
    public CodeMethod setGenericSignature(GenericSignature<GenericType> genericSignature) {
        return new CodeMethod(this.getName(), this.getModifiers(), this.getParameters(), this.getReturnType().orElse(null), genericSignature, this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override
    public CodeMethod setAnnotations(List<Annotation> annotations) {
        return new CodeMethod(this.getName(), this.getModifiers(), this.getParameters(), this.getReturnType().orElse(null), this.getGenericSignature(), annotations, this.getBody().orElse(null));
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("modifiers", this.getModifiers())
                .addMapped("genericSignature", this.getGenericSignature(), GenericSignature::isNotEmpty, GenericTypeUtil::toSourceString)
                .add("returnType", this.getReturnType().orElse(PredefinedTypes.OBJECT))
                .add("name", this.getName())
                .add("parameters", this.getParameters())
                .toString();
    }

    @Override
    public CodeMethod setBody(CodeSource body) {
        return new CodeMethod(this.getName(), this.getModifiers(), this.getParameters(), this.getReturnType().orElse(null), this.getGenericSignature(), this.getAnnotations(), body);
    }

    @Override
    public CodeMethod setParameters(List<CodeParameter> codeParameters) {
        return new CodeMethod(this.getName(), this.getModifiers(), codeParameters, this.getReturnType().orElse(null), this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }
}
