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
import com.github.jonathanxd.codeapi.impl.CodeEnum;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.EnumEntry;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.ArrayToList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EnumBuilder implements Builder<CodeEnum>,
        BodyBuilder<CodeEnum, EnumBuilder>,
        ModifiersBuilder<CodeEnum, EnumBuilder>,
        GenericSignatureBuilder<CodeEnum, EnumBuilder>,
        AnnotationsBuilder<CodeEnum, EnumBuilder>,
        EnumEntriesBuilder<CodeEnum, EnumBuilder> {

    private CodeType outerClass;
    private Collection<CodeModifier> modifiers = new ArrayList<>();
    private List<Annotation> annotations = new ArrayList<>();
    private String qualifiedName;
    private GenericSignature<GenericType> genericSignature;
    private List<CodeType> implementations = new ArrayList<>();
    private List<EnumEntry> entries = new ArrayList<>();
    private CodeSource body = CodeSource.empty();

    private EnumBuilder() {

    }

    /**
     * Create new enum builder.
     *
     * @return New enum builder
     */
    public static EnumBuilder builder() {
        return new EnumBuilder();
    }

    /**
     * Sets the outer class.
     *
     * @param outerClass Outer class.
     * @return This.
     */
    public EnumBuilder withOuterClass(CodeType outerClass) {
        this.outerClass = outerClass;
        return this;
    }


    /**
     * Set enum qualified name.
     *
     * @param qualifiedName Qualified name.
     * @return This.
     */
    public EnumBuilder withQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
        return this;
    }


    /**
     * Set implementations of this enum.
     *
     * @param implementations Implementations.
     * @return This.
     */
    public EnumBuilder withImplementations(CodeType... implementations) {
        this.implementations = ArrayToList.toList(implementations);
        return this;
    }

    /**
     * Set implementations of this enum.
     *
     * @param implementations Implementations.
     * @return This.
     */
    public EnumBuilder withImplementations(Class<?>... implementations) {
        this.implementations = ArrayToList.toList(Helper.getJavaTypes(implementations));
        return this;
    }

    @Override
    public EnumBuilder withAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
        return this;
    }

    @Override
    public EnumBuilder withGenericSignature(GenericSignature<GenericType> genericSignature) {
        this.genericSignature = genericSignature;
        return this;
    }

    @Override
    public EnumBuilder withModifiers(Collection<CodeModifier> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    @Override
    public EnumBuilder withEntries(List<EnumEntry> entries) {
        this.entries = entries;
        return this;
    }

    @Override
    public EnumBuilder withBody(CodeSource body) {
        this.body = body;
        return this;
    }


    @Override
    public CodeEnum build() {
        return new CodeEnum(outerClass, this.body, this.annotations, this.modifiers, this.implementations, this.genericSignature, this.entries, this.qualifiedName);
    }

}
