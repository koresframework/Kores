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
package com.github.jonathanxd.codeapi.util;

import com.github.jonathanxd.iutils.list.StaticList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jonathan on 12/05/16.
 */
public class BiMultiVal<T, U extends T, V extends T> implements Iterable<T> {

    private final StaticList<T> staticList;

    private BiMultiVal(StaticList<T> staticList) {
        this.staticList = staticList;
    }


    public static <T, U extends T, V extends T> Adder<T, U, V> create(Class<T> baseType, Class<U> cl, Class<V> cl2) {
        return new Adder<>(baseType);
    }

    public static <T, U extends T, V extends T> Adder<T, U, V> create(Adder<T, U, V> adder) {
        return new Adder<>(adder.baseType);
    }

    @Override
    public Iterator<T> iterator() {
        return staticList.iterator();
    }

    public Collection<T> toCollection() {
        List<T> list = new ArrayList<>();

        Iterator<T> iterator = iterator();

        iterator.forEachRemaining(list::add);

        return list;
    }

    public static class Adder<T, U extends T, V extends T> {

        private final Class<T> baseType;
        private final List<T> list = new ArrayList<>();

        protected Adder(Class<T> baseType) {
            this.baseType = baseType;
        }

        public BiMultiVal<T, U, V> make() {

            StaticList<T> staticListOf = StaticList.createStaticListOf(baseType, list.size());

            list.forEach(staticListOf::add);

            return new BiMultiVal<>(staticListOf);
        }

        public Adder<T, U, V> and(U u) {
            list.add(u);
            return this;
        }

        public Adder<T, U, V> or(V v) {
            list.add(v);
            return this;
        }

        public Adder<T, U, V> add1(U u) {
            list.add(u);
            return this;
        }

        public Adder<T, U, V> add2(V v) {
            list.add(v);
            return this;
        }
    }
}
