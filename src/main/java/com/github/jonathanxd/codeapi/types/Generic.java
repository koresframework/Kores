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
package com.github.jonathanxd.codeapi.types;

import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.exceptions.TODOException;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.iutils.arrays.ArrayUtils;

import java.util.Arrays;


/**
 * Created by jonathan on 04/07/16.
 */
@GenerateTo(GenericType.class)
public class Generic implements GenericType {

    private final String name;
    private final CodeType definedCodeType;
    private final CodeType codeType;
    private final Bound<CodeType>[] bounds;
    private final boolean isType;

    public Generic(String name) {
        this(name, null, null);
    }

    public Generic(CodeType type) {
        this(null, type, null);
    }

    public Generic(String name, CodeType codeType, Bound<CodeType>[] bounds) {

        if(bounds == null) {
            bounds = new Bound[0];
        }

        this.isType = codeType != null;

        if(name != null) {
            this.name = name;
        } else {
            String specName = codeType.getJavaSpecName();

            specName = specName.substring(0, specName.length()-1);

            this.name = specName;
        }

        if(codeType != null) {
            this.codeType = codeType;
            this.definedCodeType = codeType;
        } else {
            if(bounds.length == 0) {
                this.definedCodeType = null;
                this.codeType = PredefinedTypes.OBJECT;
            } else {
                this.codeType = bounds[0].getType();
                this.definedCodeType = this.codeType;
            }
        }

        this.bounds = bounds;
    }


    public static Generic type(String s) {
        return new Generic(s, null, new Bound[0]);
    }

    public static Generic type(CodeType type) {
        return new Generic(null, type, new Bound[0]);
    }

    public static Generic wildcard() {
        return new Generic("*", null, new Bound[0]);
    }

    public Generic of(String s) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new GenericBound<>(new Generic(s))));
    }

    @SuppressWarnings("unchecked")
    public Generic of(String... ss) {
        Bound<CodeType>[] bounds = Arrays.stream(ss).map(s -> new GenericBound<>(new Generic(s))).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    public Generic of(CodeType type) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new GenericBound<>(type)));
    }

    @SuppressWarnings("unchecked")
    public Generic of(CodeType... types) {
        Bound<CodeType>[] bounds = Arrays.stream(types).map(GenericBound::new).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    public Generic extends$(String s) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new Extends<>(new Generic(s))));
    }

    @SuppressWarnings("unchecked")
    public Generic extends$(String... ss) {
        Bound<CodeType>[] bounds = Arrays.stream(ss).map(s -> new Extends<>(new Generic(s))).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    public Generic extends$(CodeType type) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new Extends<>(type)));
    }

    @SuppressWarnings("unchecked")
    public Generic extends$(CodeType... types) {
        Bound<CodeType>[] bounds = Arrays.stream(types).map(Extends::new).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    public Generic super$(String s) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new Super<>(new Generic(s))));
    }

    @SuppressWarnings("unchecked")
    public Generic super$(String... ss) {
        Bound<CodeType>[] bounds = Arrays.stream(ss).map(s -> new Super<>(new Generic(s))).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    public Generic super$(CodeType type) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new Super<>(type)));
    }

    @SuppressWarnings("unchecked")
    public Generic super$(CodeType... types) {
        Bound<CodeType>[] bounds = Arrays.stream(types).map(Super::new).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    public CodeType getCodeType() {
        return codeType;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Bound<CodeType>[] bounds() {
        return bounds.clone();
    }

    @Override
    public boolean isType() {
        return this.isType;
    }

    @Override
    public String getType() {
        return codeType != null ? codeType.getType() : name();
    }

    @Override
    public String getCanonicalName() {
        return codeType != null ? codeType.getCanonicalName() : name();
    }

    @Override
    public String getPackageName() {
        return codeType != null ? codeType.getPackageName() : "";
    }

    @Override
    public String getSimpleName() {
        return codeType != null ? codeType.getSimpleName() : name();
    }

    @Override
    public String getJavaSpecName() {
        return codeType != null ? codeType.getJavaSpecName() : name();
    }

    @Override
    public boolean isPrimitive() {
        return codeType != null && codeType.isPrimitive();
    }

    @Override
    public boolean isInterface() {
        return codeType != null && codeType.isInterface();
    }

    @Override
    public boolean isVirtual() {
        return codeType == null || codeType.isVirtual();
    }

    @Override
    public int compareTo(CodeType other) {
        return codeType != null ? codeType.compareTo(other) : -1;
    }

    @Override
    public boolean isArray() {
        return codeType != null && codeType.isArray();
    }

    @Override
    public GenericType toArray(int dimensions) {
        return new Generic(name, codeType.toArray(dimensions), bounds);
    }

    @Override
    public CodeType getWrapperType() {
        //return codeType.getWrapperType();
        throw new TODOException();
    }

    @Override
    public CodeType getPrimitiveType() {
        //return codeType.getPrimitiveType();
        throw new TODOException();
    }
}
