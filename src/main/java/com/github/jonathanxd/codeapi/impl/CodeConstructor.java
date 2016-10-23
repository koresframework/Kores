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
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.GenericTypeUtil;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 07/05/16.
 */
@GenerateTo(MethodDeclaration.class)
public class CodeConstructor extends CodeMethod implements ConstructorDeclaration {

    public CodeConstructor(CodeType declaringClass, Collection<CodeModifier> modifiers, List<CodeParameter> parameters, CodeSource body) {
        super(declaringClass.getSimpleName(), modifiers, parameters, Helper.getJavaType(Void.TYPE), body);
    }

    public CodeConstructor(CodeType declaringClass, Collection<CodeModifier> modifiers, List<CodeParameter> parameters, List<Annotation> annotations, CodeSource body) {
        super(declaringClass.getSimpleName(), modifiers, parameters, Helper.getJavaType(Void.TYPE), GenericSignature.empty(), annotations, body);
    }

    public CodeConstructor(Collection<CodeModifier> modifiers, List<CodeParameter> parameters, CodeSource body) {
        super("<init>", modifiers, parameters, Helper.getJavaType(Void.TYPE), body);
    }

    public CodeConstructor(Collection<CodeModifier> modifiers, List<CodeParameter> parameters, List<Annotation> annotations, CodeSource body) {
        super("<init>", modifiers, parameters, Helper.getJavaType(Void.TYPE), GenericSignature.empty(), annotations, body);
    }

    /**
     * Constructor return type is always declaring class type
     *
     * Constructor return type is immutable
     */
    @Override
    public Optional<CodeType> getReturnType() {
        return Optional.of(PredefinedTypes.VOID);
    }

    @Override
    public CodeConstructor setName(String name) {
        return this;
    }

    @Override
    public CodeConstructor setBody(CodeSource body) {
        return new CodeConstructor(this.getModifiers(), this.getParameters(), this.getAnnotations(), body);
    }

    @Override
    public CodeConstructor setAnnotations(List<Annotation> annotations) {
        return new CodeConstructor(this.getModifiers(), this.getParameters(), annotations, this.getBody().orElse(null));
    }

    @Override
    public CodeConstructor setReturnType(CodeType returnType) {
        return this;
    }

    @Override
    public CodeConstructor setParameters(List<CodeParameter> codeParameters) {
        return new CodeConstructor(this.getModifiers(), codeParameters, this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public CodeConstructor setModifiers(Collection<CodeModifier> modifiers) {
        return new CodeConstructor(modifiers, this.getParameters(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public CodeConstructor setGenericSignature(GenericSignature<GenericType> genericSignature) {
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("modifiers", this.getModifiers())
                .addMapped("genericSignature", this.getGenericSignature(), GenericSignature::isNotEmpty, GenericTypeUtil::toSourceString)
                .add("name", this.getName())
                .add("parameters", this.getParameters())
                .toString();
    }
}