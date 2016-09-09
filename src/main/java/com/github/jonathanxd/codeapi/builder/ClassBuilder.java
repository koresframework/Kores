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
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.ArrayToList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * {@link CodeClass} builder.
 */
public final class ClassBuilder implements Builder<CodeClass> {

    private Collection<CodeModifier> modifiers = new ArrayList<>();
    private List<Annotation> annotations = new ArrayList<>();
    private String qualifiedName;
    private GenericSignature<GenericType> genericSignature;
    private CodeType superClass = PredefinedTypes.OBJECT;
    private List<CodeType> implementations = new ArrayList<>();
    private CodeSource body = new CodeSource();

    private ClassBuilder() {

    }

    /**
     * Create builder instance.
     *
     * @return Builder instance.
     */
    public static ClassBuilder builder() {
        return new ClassBuilder();
    }

    /**
     * Set modifiers.
     *
     * @param modifiers Code Modifiers
     * @return This.
     */
    public ClassBuilder withModifiers(Collection<CodeModifier> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    /**
     * Set modifiers.
     *
     * @param modifiers Modifiers.
     * @return This.
     */
    public ClassBuilder withModifiers(CodeModifier... modifiers) {
        this.modifiers = ArrayToList.toList(modifiers);
        return this;
    }

    /**
     * Set modifiers
     *
     * @param modifiers Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                  java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                  {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                  visibility).
     * @return This.
     */
    public ClassBuilder withModifiers(int modifiers) {
        this.modifiers = CodeModifier.extractModifiers(modifiers);
        return this;
    }

    /**
     * Set annotations.
     *
     * @param annotations Annotations.
     * @return This.
     */
    public ClassBuilder withAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
        return this;
    }

    /**
     * Set annotations.
     *
     * @param annotations Annotations.
     * @return This.
     */
    public ClassBuilder withAnnotations(Annotation... annotations) {
        this.annotations = ArrayToList.toList(annotations);
        return this;
    }

    /**
     * Set interface qualified name.
     *
     * @param qualifiedName Qualified name.
     * @return This.
     */
    public ClassBuilder withQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
        return this;
    }

    /**
     * Set generic signature.
     *
     * @param genericSignature Generic signature.
     * @return This.
     */
    public ClassBuilder withGenericSignature(GenericSignature<GenericType> genericSignature) {
        this.genericSignature = genericSignature;
        return this;
    }

    /**
     * Set the super class.
     *
     * @param superClass Super class.
     * @return This.
     */
    public ClassBuilder withSuperClass(CodeType superClass) {
        this.superClass = superClass;
        return this;
    }

    /**
     * Set the super class.
     *
     * @param superClass Super class.
     * @return This.
     */
    public ClassBuilder withSuperClass(Class<?> superClass) {
        this.superClass = Helper.getJavaType(superClass);
        return this;
    }

    /**
     * Set implementations of this interface.
     *
     * @param implementations Implementations.
     * @return This.
     */
    public ClassBuilder withImplementations(CodeType... implementations) {
        this.implementations = ArrayToList.toList(implementations);
        return this;
    }

    /**
     * Set implementations of this interface.
     *
     * @param implementations Implementations.
     * @return This.
     */
    public ClassBuilder withImplementations(Class<?>... implementations) {
        this.implementations = ArrayToList.toList(Helper.getJavaTypes(implementations));
        return this;
    }

    /**
     * Set body of this interface.
     *
     * @param body Body.
     * @return This.
     */
    public ClassBuilder withBody(CodeSource body) {
        this.body = body;
        return this;
    }

    @Override
    public CodeClass build() {
        return new CodeClass(this.qualifiedName, this.modifiers, this.superClass, this.implementations, this.genericSignature, this.annotations, this.body);
    }
}
