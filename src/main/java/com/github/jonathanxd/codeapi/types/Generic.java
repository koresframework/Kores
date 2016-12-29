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
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.util.GenericTypeUtil;
import com.github.jonathanxd.iutils.array.ArrayUtils;

import java.util.Arrays;
import java.util.Objects;


/**
 * A generic type.
 *
 * Examples:
 *
 * A generic type T that extends String:
 *
 * <pre>
 *     {@code
 *
 *     Generic.type("T").extends$(PredefinedTypes.STRING);
 *
 *     }
 * </pre>
 *
 * A generic type T that extends V:
 *
 * <pre>
 *     {@code
 *
 *     Generic.type("T").extends$("V");
 *
 *     }
 * </pre>
 *
 * A List of Type T:
 *
 * <pre>
 *     {@code
 *
 *     Generic.type(Helper.getJavaType(List.class)).of("T")
 *
 *     }
 * </pre>
 */
@GenerateTo(GenericType.class)
public class Generic implements GenericType {

    /**
     * Name of the generic type.
     */
    private final String name;

    /**
     * Defined type.
     */
    private final CodeType definedCodeType;

    /**
     * Type.
     */
    private final CodeType codeType;

    /**
     * Generic bounds.
     */
    private final Bound<CodeType>[] bounds;

    /**
     * Is a type.
     */
    private final boolean isType;

    /**
     * Create a generic type from a name (ex: T, E, R).
     *
     * @param name Name.
     */
    private Generic(String name) {
        this(name, null, null);
    }

    /**
     * Create a generic type from a type.
     *
     * @param type Type.
     */
    private Generic(CodeType type) {
        this(null, type, null);
    }

    /**
     * Create a generic type.
     *
     * @param name     Name
     * @param codeType Type
     * @param bounds   Generic Bounds.
     */
    @SuppressWarnings("unchecked")
    private Generic(String name, CodeType codeType, Bound<CodeType>[] bounds) {

        if (bounds == null) {
            bounds = new Bound[0];
        }

        this.isType = codeType != null;

        if (name != null) {
            this.name = name;
        } else {
            if (codeType == null) {
                throw new NullPointerException("codeType is null and name is null");
            }

            String specName = codeType.getJavaSpecName();

            specName = specName.substring(0, specName.length() - 1);

            this.name = specName;
        }

        if (codeType != null) {
            this.codeType = codeType;
            this.definedCodeType = codeType;
        } else {
            if (bounds.length == 0) {
                this.definedCodeType = null;
                this.codeType = PredefinedTypes.OBJECT;
            } else {
                this.codeType = bounds[0].getType();
                this.definedCodeType = this.codeType;
            }
        }

        this.bounds = bounds;
    }


    /**
     * Create a generic type from a name (ex: T, E, R).
     *
     * @param s Name.
     * @return Generic of name.
     */
    @SuppressWarnings("unchecked")
    public static Generic type(String s) {
        return new Generic(s, null, new Bound[0]);
    }

    /**
     * Create a generic type from a type.
     *
     * @param type Type.
     * @return Generic of type.
     */
    @SuppressWarnings("unchecked")
    public static Generic type(CodeType type) {
        return new Generic(null, type, new Bound[0]);
    }

    /**
     * Create a generic wildcard (? in Java Language, * in JVM).
     *
     * @return Generic wildcard.
     */
    @SuppressWarnings("unchecked")
    public static Generic wildcard() {
        return new Generic("*", null, new Bound[0]);
    }

    /**
     * Add a name bound.
     *
     * @param s Name.
     * @return New instance of generic type.
     */
    public Generic of(String s) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new GenericBound<>(new Generic(s))));
    }

    /**
     * Add name bounds.
     *
     * @param ss Names.
     * @return New instance of generic type.
     */
    @SuppressWarnings("unchecked")
    public Generic of(String... ss) {
        Bound<CodeType>[] bounds = Arrays.stream(ss).map(s -> new GenericBound<>(new Generic(s))).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    /**
     * Add a type bound.
     *
     * @param type Type.
     * @return New instance of generic type.
     */
    public Generic of(CodeType type) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new GenericBound<>(type)));
    }

    /**
     * Add type bounds.
     *
     * @param types Types.
     * @return New instance of generic type.
     */
    @SuppressWarnings("unchecked")
    public Generic of(CodeType... types) {
        Bound<CodeType>[] bounds = Arrays.stream(types).map(GenericBound::new).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    /**
     * Generic type that extends type variable {@code s}.
     *
     * @param s Type name.
     * @return New instance of generic type.
     */
    public Generic extends$(String s) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new Extends<>(new Generic(s))));
    }

    /**
     * Generic type that extends type variables {@code ss}.
     *
     * @param ss Types names.
     * @return New instance of generic type.
     */
    @SuppressWarnings("unchecked")
    public Generic extends$(String... ss) {
        Bound<CodeType>[] bounds = Arrays.stream(ss).map(s -> new Extends<>(new Generic(s))).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    /**
     * Generic type that extends type {@code type}.
     *
     * @param type Type.
     * @return New instance of generic type.
     */
    public Generic extends$(CodeType type) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new Extends<>(type)));
    }


    /**
     * Generic type that extends types {@code types}.
     *
     * @param types Types.
     * @return New instance of generic type.
     */
    @SuppressWarnings("unchecked")
    public Generic extends$(CodeType... types) {
        Bound<CodeType>[] bounds = Arrays.stream(types).map(Extends::new).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    /**
     * Generic type that have a super type variable {@code s}.
     *
     * @param s Type variable.
     * @return New instance of generic type.
     */
    public Generic super$(String s) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new Super<>(new Generic(s))));
    }

    /**
     * Generic type that have a super type variables {@code ss}.
     *
     * @param ss Type variables.
     * @return New instance of generic type.
     */
    @SuppressWarnings("unchecked")
    public Generic super$(String... ss) {
        Bound<CodeType>[] bounds = Arrays.stream(ss).map(s -> new Super<>(new Generic(s))).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    /**
     * Generic type that have a super type {@code type}.
     *
     * @param type Type.
     * @return New instance of generic type.
     */
    public Generic super$(CodeType type) {
        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addToArray(this.bounds, new Super<>(type)));
    }

    /**
     * Generic type that have a super types {@code types}.
     *
     * @param types Types.
     * @return New instance of generic type.
     */
    @SuppressWarnings("unchecked")
    public Generic super$(CodeType... types) {
        Bound<CodeType>[] bounds = Arrays.stream(types).map(Super::new).toArray(Bound[]::new);

        return new Generic(this.name(), this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds));
    }

    /**
     * Gets the type.
     *
     * @return Type.
     */
    @Override
    public CodeType getCodeType() {
        return this.codeType;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Bound<CodeType>[] bounds() {
        return this.bounds.clone();
    }

    @Override
    public boolean isType() {
        return !this.isWildcard() && this.isType;
    }

    @Override
    public String getType() {
        return this.codeType != null ? this.codeType.getType() : this.name();
    }

    @Override
    public String getCanonicalName() {
        return this.codeType != null ? this.codeType.getCanonicalName() : this.name();
    }

    @Override
    public String getPackageName() {
        return this.codeType != null ? this.codeType.getPackageName() : "";
    }

    @Override
    public String getSimpleName() {
        return this.codeType != null ? this.codeType.getSimpleName() : this.name();
    }

    @Override
    public String getJavaSpecName() {
        return this.codeType != null ? this.codeType.getJavaSpecName() : name();
    }

    @Override
    public boolean isPrimitive() {
        return this.codeType != null && this.codeType.isPrimitive();
    }

    @Override
    public boolean isInterface() {
        return this.codeType != null && this.codeType.isInterface();
    }

    @Override
    public boolean isVirtual() {
        return this.codeType == null || this.codeType.isVirtual();
    }

    @Override
    public int compareTo(CodeType other) {
        return this.codeType != null ? this.codeType.compareTo(other) : -1;
    }

    @Override
    public boolean isArray() {
        return this.codeType != null && this.codeType.isArray();
    }

    @Override
    public GenericType toArray(int dimensions) {
        return new Generic(this.name(), this.getCodeType().toArray(dimensions), this.bounds());
    }

    /**
     * Only determine the Wrapper type if:
     *
     * <pre>
     *     {@code
     *      isCodeType && bounds.isEmpty
     *     }
     * </pre>
     *
     * Because
     *
     * <pre>
     *     {@code
     *      int<T> is invalid.
     *     }
     * </pre>
     */
    @Override
    public CodeType getWrapperType() {

        if (this.codeType != null && bounds.length == 0)
            return this.codeType.getWrapperType();

        return null;
    }

    /**
     * Only determine the Primitive type if:
     *
     * <pre>
     *     {@code
     *      isCodeType && bounds.isEmpty
     *     }
     * </pre>
     *
     * Because
     *
     * <pre>
     *     {@code
     *      Integer<T> is invalid
     *      List<T> has no primitive types because List is not a wrapper type.
     *     }
     * </pre>
     */
    @Override
    public CodeType getPrimitiveType() {
        if (this.codeType != null && bounds.length == 0)
            return this.codeType.getPrimitiveType();

        return null;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof GenericType) {
            GenericType genericType = (GenericType) obj;

            if (this.isWildcard() == genericType.isWildcard()
                    && this.isType() == genericType.isType()
                    && this.name().equals(genericType.name())
                    && Arrays.deepEquals(this.bounds(), genericType.bounds())) {
                return true;
            }

        }

        return super.equals(obj);
    }


    @Override
    public int hashCode() {

        if(this.isType() && this.bounds().length == 0)
            return CodeType.hash(this);

        int result = Objects.hash(this.name(), this.isType(), this.isWildcard());

        result = 31 * result + Arrays.deepHashCode(this.bounds());

        return result;
    }

    @Override
    public String toString() {
        return GenericTypeUtil.toSourceString(this);
    }
}
