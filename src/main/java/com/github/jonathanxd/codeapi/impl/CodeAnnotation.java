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
import com.github.jonathanxd.codeapi.interfaces.AnnotationDeclaration;
import com.github.jonathanxd.codeapi.interfaces.AnnotationProperty;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.gen.CodeTypeUtil;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@GenerateTo(AnnotationDeclaration.class)
public class CodeAnnotation implements AnnotationDeclaration {

    private final CodeType outerClass;
    private final String qualifiedName;
    private final String name;
    private final CodeSource body;
    private final List<Annotation> annotations;
    private final Collection<CodeModifier> modifiers;
    private final GenericSignature<GenericType> genericSignature;
    private final List<AnnotationProperty> properties;

    public CodeAnnotation(CodeType outerClass, CodeSource body, List<Annotation> annotations, Collection<CodeModifier> modifiers, GenericSignature<GenericType> genericSignature, List<AnnotationProperty> properties, String qualifiedName) {
        this.outerClass = outerClass;
        this.qualifiedName = CodeTypeUtil.resolveRealQualified(qualifiedName, outerClass);
        this.name = qualifiedName.substring(qualifiedName.lastIndexOf('.') + 1, qualifiedName.length());
        this.body = body;
        this.annotations = annotations == null ? Collections.emptyList() : Collections.unmodifiableList(annotations);
        this.modifiers = modifiers == null ? Collections.emptyList() : Collections.unmodifiableCollection(modifiers);
        this.genericSignature = genericSignature == null ? GenericSignature.empty() : genericSignature;
        this.properties = properties == null ? Collections.emptyList() : Collections.unmodifiableList(properties);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public CodeAnnotation setName(String name) {
        String newName = (!this.getPackageName().isEmpty() ? this.getPackageName() + "." : "") + name;
        return this.setQualifiedName(newName);
    }

    @Override
    public Optional<CodeSource> getBody() {
        return Optional.ofNullable(this.body);
    }

    @Override
    public CodeAnnotation setBody(CodeSource body) {
        return new CodeAnnotation(this.getOuterClass().orElse(null), body, this.getAnnotations(), this.getModifiers(), this.getGenericSignature(), this.getProperties(), this.getQualifiedName());
    }

    @Override
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override
    public CodeAnnotation setAnnotations(List<Annotation> annotations) {
        return new CodeAnnotation(this.getOuterClass().orElse(null), this.getBody().orElse(null), annotations, this.getModifiers(), this.getGenericSignature(), this.getProperties(), this.getQualifiedName());
    }

    @Override
    public Collection<CodeModifier> getModifiers() {
        return this.modifiers;
    }

    @Override
    public CodeAnnotation setModifiers(Collection<CodeModifier> modifiers) {
        return new CodeAnnotation(this.getOuterClass().orElse(null), this.getBody().orElse(null), this.getAnnotations(), modifiers, this.getGenericSignature(), this.getProperties(), this.getQualifiedName());
    }

    @Override
    public GenericSignature<GenericType> getGenericSignature() {
        return this.genericSignature;
    }

    @Override
    public CodeAnnotation setGenericSignature(GenericSignature<GenericType> genericSignature) {
        return new CodeAnnotation(this.getOuterClass().orElse(null), this.getBody().orElse(null), this.getAnnotations(), this.getModifiers(), genericSignature, this.getProperties(), this.getQualifiedName());
    }

    @Override
    public List<AnnotationProperty> getProperties() {
        return this.properties;
    }

    @Override
    public CodeAnnotation setProperties(List<AnnotationProperty> properties) {
        return new CodeAnnotation(this.getOuterClass().orElse(null), this.getBody().orElse(null), this.getAnnotations(), this.getModifiers(), this.getGenericSignature(), properties, this.getQualifiedName());
    }

    @Override
    public String getQualifiedName() {
        return this.qualifiedName;
    }

    @Override
    public CodeAnnotation setQualifiedName(String name) {
        return new CodeAnnotation(this.getOuterClass().orElse(null), this.getBody().orElse(null), this.getAnnotations(), this.getModifiers(), this.getGenericSignature(), this.getProperties(), name);
    }

    @Override
    public String getType() {
        return this.getQualifiedName();
    }

    @Override
    public String getCanonicalName() {
        return this.getQualifiedName();
    }

    @Override
    public Optional<CodeType> getOuterClass() {
        return Optional.ofNullable(this.outerClass);
    }

    @Override
    public CodeAnnotation setOuterClass(CodeType outeClass) {
        return new CodeAnnotation(outerClass, this.getBody().orElse(null), this.getAnnotations(), this.getModifiers(), this.getGenericSignature(), this.getProperties(), this.getName());
    }

}
