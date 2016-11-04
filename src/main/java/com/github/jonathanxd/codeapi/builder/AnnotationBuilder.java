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
package com.github.jonathanxd.codeapi.builder;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.impl.CodeAnnotation;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.AnnotationProperty;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AnnotationBuilder implements Builder<CodeAnnotation>,
        BodyBuilder<CodeAnnotation, AnnotationBuilder>,
        ModifiersBuilder<CodeAnnotation, AnnotationBuilder>,
        GenericSignatureBuilder<CodeAnnotation, AnnotationBuilder>,
        AnnotationsBuilder<CodeAnnotation, AnnotationBuilder> {

    private CodeType outerClass;
    private Collection<CodeModifier> modifiers = new ArrayList<>();
    private List<Annotation> annotations = new ArrayList<>();
    private String qualifiedName;
    private GenericSignature<GenericType> genericSignature;
    private List<AnnotationProperty> properties = new ArrayList<>();
    private CodeSource body = CodeSource.empty();

    private AnnotationBuilder() {

    }

    /**
     * Create new enum builder.
     *
     * @return New enum builder
     */
    public static AnnotationBuilder builder() {
        return new AnnotationBuilder();
    }

    /**
     * Sets the outer class.
     *
     * @param outerClass Outer class.
     * @return This.
     */
    public AnnotationBuilder withOuterClass(CodeType outerClass) {
        this.outerClass = outerClass;
        return this;
    }

    /**
     * Sets properties.
     *
     * @param properties Properties.
     * @return This.
     */
    public AnnotationBuilder withProperties(List<AnnotationProperty> properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Sets properties.
     *
     * @param properties Properties.
     * @return This.
     */
    public AnnotationBuilder withProperties(AnnotationProperty... properties) {
        return this.withProperties(Arrays.asList(properties));
    }

    /**
     * Set enum qualified name.
     *
     * @param qualifiedName Qualified name.
     * @return This.
     */
    public AnnotationBuilder withQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
        return this;
    }

    @Override
    public AnnotationBuilder withAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
        return this;
    }

    @Override
    public AnnotationBuilder withGenericSignature(GenericSignature<GenericType> genericSignature) {
        this.genericSignature = genericSignature;
        return this;
    }

    @Override
    public AnnotationBuilder withModifiers(Collection<CodeModifier> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    @Override
    public AnnotationBuilder withBody(CodeSource body) {
        this.body = body;
        return this;
    }


    @Override
    public CodeAnnotation build() {
        return new CodeAnnotation(outerClass, this.body, this.annotations, this.modifiers, this.genericSignature, this.properties, this.qualifiedName);
    }

}
