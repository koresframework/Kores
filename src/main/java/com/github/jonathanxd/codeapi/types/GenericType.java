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

/**
 * Created by jonathan on 04/07/16.
 */
public interface GenericType extends CodeType {

    String name();

    Bound<CodeType>[] bounds();

    default boolean isWildcard() {
        return name().equals("*");
    }

    boolean isType();

    @Override
    GenericType toArray(int dimensions);

    abstract class Bound<T extends CodeType> {
        private final T type;

        public Bound(T type) {
            this.type = type;
        }

        public T getType() {
            return type;
        }

        public abstract String sign();
    }

    abstract class WildcardBound<T extends CodeType> extends Bound<T> {

        public WildcardBound(T type) {
            super(type);
        }
    }

    final class GenericBound<T extends CodeType> extends Bound<T> {

        public GenericBound(T type) {
            super(type);
        }

        @Override
        public String sign() {
            return "";
        }
    }

    final class Extends<T extends CodeType> extends WildcardBound<T> {
        public Extends(T type) {
            super(type);
        }

        @Override
        public String sign() {
            return "+";
        }
    }

    final class Super<T extends CodeType> extends WildcardBound<T> {
        public Super(T type) {
            super(type);
        }

        @Override
        public String sign() {
            return "-";
        }
    }

    // Annotations

}


/*

 List<T> = Generic.type(List_Type).of("T")

 Generic.type("T").extends(String_Type).and(Generic.type(List_Type).of("T"));

 Generic.type("T").of("T")

 Generic.wildcard().extends(String_Type);

 Generic.wildcard().super(String_Type);


 **/