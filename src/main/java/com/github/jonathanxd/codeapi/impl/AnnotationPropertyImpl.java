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

import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.AnnotationProperty;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@GenerateTo(AnnotationProperty.class)
public class AnnotationPropertyImpl implements AnnotationProperty {

    private final List<Annotation> annotationList;
    private final CodeType type;
    private final String name;
    private final Object value;

    public AnnotationPropertyImpl(List<Annotation> annotationList, CodeType codeType, String name, Object value) {
        this.annotationList = annotationList == null ? Collections.emptyList() : Collections.unmodifiableList(annotationList);
        type = codeType;
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public AnnotationPropertyImpl setName(String name) {
        return new AnnotationPropertyImpl(this.getAnnotations(), this.getRequiredType(), name, this.getValue().orElse(null));
    }

    @Override
    public Optional<Object> getValue() {
        return Optional.ofNullable(this.value);
    }

    @Override
    public AnnotationPropertyImpl setValue(Object value) {
        return new AnnotationPropertyImpl(this.getAnnotations(), this.getRequiredType(), this.getName(), value);
    }

    @Override
    public Optional<CodeType> getType() {
        return Optional.of(this.type);
    }

    @Override
    public AnnotationPropertyImpl setType(CodeType codeType) {
        return new AnnotationPropertyImpl(this.getAnnotations(), codeType, this.getName(), this.getValue().orElse(null));
    }

    @Override
    public AnnotationProperty setAnnotations(List<Annotation> annotations) {
        return new AnnotationPropertyImpl(annotations, this.getRequiredType(), this.getName(), this.getValue().orElse(null));
    }

    @Override
    public List<Annotation> getAnnotations() {
        return this.annotationList;
    }
}
