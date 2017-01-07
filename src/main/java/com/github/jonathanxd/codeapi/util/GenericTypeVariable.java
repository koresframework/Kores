/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.util;

import com.github.jonathanxd.codeapi.type.CodeType;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class GenericTypeVariable implements TypeVariable<GenericDeclaration> {

    private final CodeType type;
    private final TypeVariable<? extends GenericDeclaration> wrapped;
    private final String name;
    private final Type wrappedType;
    private final Type[] bounds;

    private GenericTypeVariable(CodeType type, TypeVariable<? extends GenericDeclaration> wrapped, Type wrappedType, String name, Type[] bounds) {
        this.type = type;
        this.wrapped = wrapped;
        this.wrappedType = wrappedType;
        this.name = name != null ? name : (type != null ? type.getCanonicalName() : (wrapped != null ? wrapped.getName() : wrappedType.getTypeName()));
        this.bounds = bounds;
    }


    public GenericTypeVariable(CodeType type, TypeVariable<? extends GenericDeclaration> wrapped, Type[] bounds) {
        this(type, wrapped, null, null, bounds);
    }

    public GenericTypeVariable(CodeType type, TypeVariable<? extends GenericDeclaration> wrapped, String name, Type[] bounds) {
        this(type, wrapped, null, name, bounds);
    }

    public GenericTypeVariable(CodeType type, Type wrappedType, Type[] bounds) {
        this(type, null, wrappedType, null, bounds);
    }

    public CodeType getType() {
        return this.type;
    }

    @Override
    public Type[] getBounds() {
        return this.bounds;
    }

    @Override
    public GenericDeclaration getGenericDeclaration() {
        return this.wrapped != null ? this.wrapped.getGenericDeclaration() : null;
    }

    @Override
    public String getName() {
        return this.name != null ? this.name : (this.type != null ? this.type.getCanonicalName() : (this.wrapped != null ? this.wrapped.getName() : this.wrappedType.getTypeName()));
    }

    @Override
    public AnnotatedType[] getAnnotatedBounds() {
        return this.wrapped != null ? this.wrapped.getAnnotatedBounds() : new AnnotatedType[0];
    }

    @Override
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        return this.wrapped != null ? this.wrapped.getAnnotation(annotationClass) : null;
    }

    @Override
    public Annotation[] getAnnotations() {
        return this.wrapped != null ? this.wrapped.getAnnotations() : new Annotation[0];
    }

    @Override
    public Annotation[] getDeclaredAnnotations() {
        return this.wrapped != null ? this.wrapped.getDeclaredAnnotations() : new Annotation[0];
    }
}
