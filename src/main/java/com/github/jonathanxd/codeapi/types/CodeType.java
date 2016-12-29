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

import com.github.jonathanxd.codeapi.CodePart;

/**
 * A type representation, {@link CodeType} can be:
 *
 * - Java Classes.
 *
 * - CodeAPI Type Declarations.
 *
 * - Plain class name.
 */
public interface CodeType extends CodePart, Comparable<CodeType> {
    /**
     * Gets the type name.
     *
     * @return Type name.
     */
    String getType();

    /**
     * Gets the canonical name.
     *
     * @return Canonical name.
     */
    String getCanonicalName();

    /**
     * Gets the package name.
     *
     * @return Package name.
     */
    default String getPackageName() {
        String type = getType();

        if (!type.contains("."))
            return "";

        return type.substring(0, type.lastIndexOf('.'));
    }

    /**
     * Gets the simple name.
     *
     * @return Simple name.
     */
    default String getSimpleName() {
        String type = getType();

        if (isPrimitive())
            return type;

        return type.substring(type.lastIndexOf('.') + 1);
    }

    /**
     * Gets the JVM Spec class name. (ex, java.lang.String = Ljava/lang/String;)
     *
     * @return JVM Spec class name
     */
    default String getJavaSpecName() {
        return "L" + this.getType().replace('.', '/') + ";";
    }

    /**
     * Returns true if this {@link CodeType} is a primitive type.
     *
     * @return True if this {@link CodeType} is a primitive type.
     */
    default boolean isPrimitive() {
        return false;
    }

    /**
     * Returns true if this {@link CodeType} is a interface type.
     *
     * @return True if this {@link CodeType} is a interface type.
     */
    default boolean isInterface() {
        return false;
    }

    /**
     * Return true if is a {@code Virtual Type} (Virtual Types = Types that were not loaded by JVM)
     *
     * @return Return true if is a {@code Virtual Type} (Virtual Types = Types that were not loaded
     * by JVM)
     */
    default boolean isVirtual() {
        return true;
    }

    /**
     * Returns true if this {@link CodeType} is an array type.
     *
     * @return True if this {@link CodeType} is an array type.
     */
    default boolean isArray() {
        return false;
    }

    /**
     * Convert this {@link CodeType} to a {@link CodeTypeArray}.
     *
     * @param dimensions Dimension of the array.
     * @return {@link CodeTypeArray} with specified dimension.
     */
    default CodeType toArray(int dimensions) {
        if (this instanceof CodeTypeArray) {
            CodeTypeArray array = (CodeTypeArray) this;

            return new CodeTypeArray(array.getComponent(), array.getDimension() + dimensions);
        }

        return new CodeTypeArray(this, dimensions);
    }

    /**
     * Gets the wrapper type.
     *
     * @return Wrapper type if is a primitive type, otherwise return null.
     */
    default CodeType getWrapperType() {
        return null;
    }

    /**
     * Gets the primitive type.
     *
     * @return Primitive type if is a wrapper type, otherwise return null.
     */
    default CodeType getPrimitiveType() {
        return null;
    }

    /**
     * Gets the array base component.
     *
     * Example, if is a {@code String[]}, returns {@link String}, if is {@code Integer[][][]}
     * returns {@link Integer}, the Java equivalent method returns: {@code Integer[][]}.
     *
     * @return Array base component.
     */
    default CodeType getArrayBaseComponent() {
        if (this instanceof CodeTypeArray) {
            return ((CodeTypeArray) this).getComponent();
        }

        return this;
    }

    /**
     * Gets the array base component.
     *
     * Example, if is a {@code String[]}, returns {@link String}, if is {@code Integer[][][]}
     * returns {@code Integer[][]}.
     *
     * @return Array base component.
     */
    default CodeType getArrayComponent() {
        if (this instanceof CodeTypeArray) {
            CodeTypeArray array = (CodeTypeArray) this;

            if (array.getDimension() - 1 == 0) {
                return array.getComponent();
            } else {
                return array.getComponent().toArray(array.getDimension() - 1);
            }
        }

        return this;
    }

    /**
     * Returns true if this {@link CodeType} is equals to another {@link CodeType}.
     *
     * @param another Another {@link CodeType}.
     * @return True if this {@link CodeType} is equals to another {@link CodeType}.
     */
    default boolean is(CodeType another) {
        return this.compareTo(another) == 0;
    }

    @Override
    default int compareTo(CodeType other) {
        return this.getJavaSpecName().compareTo(other.getJavaSpecName());
    }

    @Override
    int hashCode();

    @Override
    boolean equals(Object obj);


    /**
     * Default hash algorithm.
     *
     * @param codeType Receiver.
     * @return Hash code.
     */
    static int hash(CodeType codeType) {
        return codeType.getJavaSpecName().hashCode();
    }

    /**
     * Default equals method.
     *
     * @param codeType Receiver.
     * @param obj Object to test.
     * @return True if this {@link CodeType} is equals to another {@link CodeType}.
     */
    static boolean eq(CodeType codeType, Object obj) {
        return obj instanceof CodeType && codeType.is((CodeType) obj);
    }
}
