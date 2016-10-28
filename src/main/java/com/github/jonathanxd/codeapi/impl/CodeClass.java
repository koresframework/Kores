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
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.ClassDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Extender;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.ClassType;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.GenericTypeUtil;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
@GenerateTo(TypeDeclaration.class)
public class CodeClass extends CodeInterface implements Extender, ClassDeclaration {

    private final CodeType superType;
    private final CodeType outerClass;

    public CodeClass(CodeType outerClass, String qualifiedName,
                     Collection<CodeModifier> modifiers,
                     CodeType superType,
                     List<CodeType> implementations,
                     GenericSignature<GenericType> signature,
                     List<Annotation> annotations,
                     CodeSource body) {

        super(outerClass, modifiers, implementations, signature, annotations, body, qualifiedName);
        this.outerClass = outerClass;
        this.superType = superType;
    }

    public CodeClass(String qualifiedName, Collection<CodeModifier> modifiers, CodeType superType, List<CodeType> implementations, GenericSignature<GenericType> signature, CodeSource body, CodeType outerClass) {
        super(outerClass, modifiers, implementations, signature, body, qualifiedName);
        this.superType = superType;
        this.outerClass = outerClass;
    }

    public CodeClass(CodeType outerClass, String qualifiedName, Collection<CodeModifier> modifiers, CodeType superType, List<CodeType> implementations, CodeSource body) {
        super(outerClass, qualifiedName, modifiers, implementations, body);
        this.outerClass = outerClass;
        this.superType = superType;
    }

    public CodeClass(String qualifiedName, CodeType superType, List<CodeType> implementations, CodeSource body, CodeType outerClass) {
        this(outerClass, qualifiedName, null, superType, implementations, body);
    }

    public CodeClass(String qualifiedName, Collection<CodeModifier> modifiers, CodeType superType, CodeSource body, CodeType outerClass) {
        this(outerClass, qualifiedName, modifiers, superType, null, body);
    }

    @Override
    public String getCanonicalName() {
        return this.getQualifiedName();
    }

    @Override
    public Optional<CodeType> getSuperType() {
        return Optional.ofNullable(this.superType);
    }

    @Override
    public CodeClass setSuperType(CodeType superType) {
        return new CodeClass(outerClass, this.getQualifiedName(), this.getModifiers(), superType, this.getImplementations(), this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public boolean isExpression() {
        return true;
    }

    @Override
    public ClassType getClassType() {
        return ClassType.CLASS;
    }

    @Override
    public CodeClass setName(String name) {
        String newName = (!this.getPackageName().isEmpty() ? this.getPackageName() + "." : "")+name;
        return this.setQualifiedName(newName);
    }

    @Override
    public CodeClass setQualifiedName(String name) {
        return new CodeClass(this.getOuterClass().orElse(null), name, this.getModifiers(), this.getSuperType().orElse(null), this.getImplementations(), this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public CodeClass setBody(CodeSource body) {
        return new CodeClass(this.getOuterClass().orElse(null), this.getQualifiedName(), this.getModifiers(), this.getSuperType().orElse(null), this.getImplementations(), this.getGenericSignature(), this.getAnnotations(), body);
    }

    @Override
    public CodeClass setAnnotations(List<Annotation> annotations) {
        return new CodeClass(this.getOuterClass().orElse(null), this.getQualifiedName(), this.getModifiers(), this.getSuperType().orElse(null), this.getImplementations(), this.getGenericSignature(), annotations, this.getBody().orElse(null));
    }

    @Override
    public CodeClass setModifiers(Collection<CodeModifier> modifiers) {
        return new CodeClass(this.getOuterClass().orElse(null), this.getQualifiedName(), modifiers, this.getSuperType().orElse(null), this.getImplementations(), this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public CodeClass setImplementations(List<CodeType> implementations) {
        return new CodeClass(this.getOuterClass().orElse(null), this.getQualifiedName(), this.getModifiers(), this.getSuperType().orElse(null), implementations, this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public CodeClass setGenericSignature(GenericSignature<GenericType> genericSignature) {
        return new CodeClass(this.getOuterClass().orElse(null), this.getQualifiedName(), this.getModifiers(), this.getSuperType().orElse(null), this.getImplementations(), genericSignature, this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public Optional<CodeType> getOuterClass() {
        return Optional.ofNullable(this.outerClass);
    }

    @Override
    public CodeClass setOuterClass(CodeType outerClass) {
        return new CodeClass(outerClass, this.getQualifiedName(), this.getModifiers(), this.getSuperType().orElse(null), this.getImplementations(), this.getGenericSignature(), this.getAnnotations(), this.getBody().orElse(null));
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("modifiers", this.getModifiers())
                .add("qualifiedName", this.getQualifiedName())
                .addMapped("genericSignature", this.getGenericSignature(), GenericSignature::isNotEmpty, GenericTypeUtil::toSourceString)
                .add("extends", this.getSuperType().orElse(PredefinedTypes.OBJECT))
                .add("implementations", this.getImplementations())
                .toString();
    }
}
