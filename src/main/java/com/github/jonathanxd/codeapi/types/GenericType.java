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

import java.util.Objects;

/**
 * Generic type.
 */
public interface GenericType extends CodeType {

    /**
     * Name of the generic type.
     *
     * @return Name of the generic type.
     */
    String name();

    /**
     * Bounds of the generic type.
     *
     * @return Bounds of the generic type.
     */
    Bound<CodeType>[] bounds();

    /**
     * Returns true if this is a Type generic type, false if is a Type Variable generic type.
     *
     * @return True if this is a Type generic type, false if is a Type Variable generic type.
     */
    boolean isType();

    /**
     * Returns true if this is a wildcard generic type.
     *
     * @return True if this is a wildcard generic type.
     */
    default boolean isWildcard() {
        return name().equals("*");
    }

    @Override
    GenericType toArray(int dimensions);

    /**
     * Generic type bounds.
     *
     * @param <T> Type of bound.
     */
    abstract class Bound<T extends CodeType> {
        /**
         * {@link CodeType} of bound.
         */
        private final T type;

        /**
         * Constructor
         *
         * @param type {@link CodeType} of bound.
         */
        public Bound(T type) {
            this.type = type;
        }

        /**
         * Gets the bound {@link CodeType type}.
         *
         * @return Bound {@link CodeType type}.
         */
        public T getType() {
            return type;
        }

        /**
         * Symbol of this bound.
         *
         * @return Symbol of this bound.
         */
        public abstract String sign();

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Bound) {
                Bound bound = (Bound) obj;

                if (this.sign().equals(bound.sign()) && this.getType().equals(bound.getType())) {
                    return true;
                }
            }

            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, sign());
        }
    }

    /**
     * Bound to wildcard.
     *
     * @param <T> Type of CodeType
     */
    abstract class WildcardBound<T extends CodeType> extends Bound<T> {

        public WildcardBound(T type) {
            super(type);
        }
    }

    /**
     * Bound to type.
     *
     * @param <T> Type of CodeType
     */
    final class GenericBound<T extends CodeType> extends Bound<T> {

        public GenericBound(T type) {
            super(type);
        }

        @Override
        public String sign() {
            return "";
        }
    }

    /**
     * Bound to extends.
     *
     * @param <T> Type of CodeType
     */
    final class Extends<T extends CodeType> extends WildcardBound<T> {
        public Extends(T type) {
            super(type);
        }

        @Override
        public String sign() {
            return "+";
        }
    }

    /**
     * Bound to super type.
     *
     * @param <T> Type of CodeType
     */
    final class Super<T extends CodeType> extends WildcardBound<T> {
        public Super(T type) {
            super(type);
        }

        @Override
        public String sign() {
            return "-";
        }
    }

}