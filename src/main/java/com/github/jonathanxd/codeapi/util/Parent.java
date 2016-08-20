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

import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by jonathan on 10/05/16.
 */
public class Parent<T> {

    private final T current;
    private final Object target;
    private final Parent<T> parent;

    public Parent(T current, Object target, Parent<T> parent) {
        this.current = current;
        this.target = target;
        this.parent = parent;
    }

    public static <T> Parent<T> create(T current, Object target, Parent<T> parent) {
        return new Parent<>(current, target, parent);
    }

    public Parent<T> getParent() {
        return parent;
    }

    public T getCurrent() {
        return current;
    }

    public Object getTarget() {
        return target;
    }

    /**
     * Consume this and parents
     *
     * @param consumer Consume this and parents
     */
    public void forEach(Consumer<Parent<T>> consumer) {
        Parent<T> parent = this;

        do {
            consumer.accept(parent);
        } while ((parent = parent.getParent()) != null);
    }

    public Optional<Parent<T>> find(Class<?> valueType) {
        return find(t -> valueType.isAssignableFrom(t.getTarget().getClass()));
    }

    public Optional<Parent<T>> findEqual(Class<?> valueType) {
        return find(t -> valueType == t.getTarget().getClass());
    }

    /**
     * Find an element
     *
     * @param predicate Predicate to test elements value ({@link #getCurrent()})
     * @return Element or {@link Optional#empty} if element is not found
     */
    public Optional<Parent<T>> find(Predicate<Parent<T>> predicate) {
        Parent<T> parent = this;

        do {
            if (predicate.test(parent)) {
                return Optional.of(parent);
            }
        } while ((parent = parent.getParent()) != null);

        return Optional.empty();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");

        Parent<T> parent = this;

        do {
            sj.add(String.valueOf(parent.getCurrent()) + ". Target -> " + parent.getTarget());
        } while ((parent = parent.getParent()) != null);

        return sj.toString();
    }
}
