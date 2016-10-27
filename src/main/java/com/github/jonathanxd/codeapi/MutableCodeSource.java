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
package com.github.jonathanxd.codeapi;

import com.github.jonathanxd.codeapi.util.IterableUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A mutable {@link CodeSource} backing to a {@link ArrayList}.
 */
public class MutableCodeSource extends CodeSource {

    private final BackingArrayList backingList;

    public MutableCodeSource() {
        super();
        this.backingList = new BackingArrayList();
    }

    public MutableCodeSource(Iterable<? extends CodePart> iterable) {
        super();
        this.backingList = new BackingArrayList(iterable);
    }

    public MutableCodeSource(CodePart[] a) {
        super();

        this.backingList = new BackingArrayList(a);
    }

    @Override
    public int size() {
        return this.backingList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.backingList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.backingList.contains(o);
    }

    @Override
    public Iterator<CodePart> iterator() {
        return this.backingList.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.backingList.toArray();
    }

    @SuppressWarnings("SuspiciousToArrayCall")
    @Override
    public <T> T[] toArray(T[] a) {
        return this.backingList.toArray(a);
    }

    public boolean add(CodePart codePart) {
        return this.backingList.add(codePart);
    }

    public boolean remove(Object o) {
        return this.backingList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.backingList.containsAll(c);
    }

    public boolean addAll(Collection<? extends CodePart> c) {
        return this.backingList.addAll(c);
    }

    public boolean addAll(Iterable<? extends CodePart> c) {
        boolean any = false;

        for (CodePart part : c) {
            any |= this.add(part);
        }

        return any;
    }

    public boolean addAll(int index, Collection<? extends CodePart> c) {
        return this.backingList.addAll(index, c);
    }

    public boolean addAll(int index, Iterable<? extends CodePart> c) {
        return this.addAll(index, IterableUtil.stream(c).collect(Collectors.toList()));
    }

    public boolean removeAll(Collection<?> c) {
        return this.backingList.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return this.backingList.retainAll(c);
    }

    public void clear() {
        this.backingList.clear();
    }

    @Override
    public CodePart get(int index) {
        return this.backingList.get(index);
    }

    public CodePart set(int index, CodePart element) {
        return this.backingList.set(index, element);
    }

    public void add(int index, CodePart element) {
        this.backingList.add(index, element);
    }

    public CodePart remove(int index) {
        return this.backingList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.backingList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.backingList.lastIndexOf(o);
    }

    @Override
    public ListIterator<CodePart> listIterator() {
        return this.backingList.listIterator();
    }

    @Override
    public ListIterator<CodePart> listIterator(int index) {
        return this.backingList.listIterator(index);
    }

    public List<CodePart> subList(int fromIndex, int toIndex) {
        return this.backingList.subList(fromIndex, toIndex);
    }

    protected void removeRange(int fromIndex, int toIndex) {
        this.backingList.removeRange(fromIndex, toIndex);
    }

    public boolean removeIf(Predicate<? super CodePart> filter) {
        return this.backingList.removeIf(filter);
    }

    public void replaceAll(UnaryOperator<CodePart> operator) {
        this.backingList.replaceAll(operator);
    }

    public void sort(Comparator<? super CodePart> c) {
        this.backingList.sort(c);
    }

    public void trimToSize() {
        this.backingList.trimToSize();
    }

    public void ensureCapacity(int minCapacity) {
        this.backingList.ensureCapacity(minCapacity);
    }

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override
    public Object clone() {
        return this.backingList.clone();
    }

    @Override
    public void forEach(Consumer<? super CodePart> action) {
        this.backingList.forEach(action);
    }

    @Override
    public Spliterator<CodePart> spliterator() {
        return this.backingList.spliterator();
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object o) {
        return this.backingList.equals(o);
    }

    @Override
    public int hashCode() {
        return this.backingList.hashCode();
    }

    @Override
    public String toString() {
        return this.backingList.toString();
    }

    @Override
    public Stream<CodePart> stream() {
        return this.backingList.stream();
    }

    @Override
    public Stream<CodePart> parallelStream() {
        return this.backingList.parallelStream();
    }

    @Override
    public CodeSource toImmutable() {
        return new CodeSource(this.stream().toArray(CodePart[]::new));
    }

    @Override
    public MutableCodeSource toMutable() {
        return new MutableCodeSource(this);
    }



    /**
     * Exposes {@link #removeRange(int, int)}
     */
    private static final class BackingArrayList extends ArrayList<CodePart> {
        public BackingArrayList() {
            super();
        }

        public BackingArrayList(Iterable<? extends CodePart> c) {
            super();

            if (c != null)
                for (CodePart part : c) {
                    this.add(part);
                }

        }

        public BackingArrayList(CodePart[] a) {
            if (a != null)
                for (CodePart part : a) {
                    this.add(part);
                }
        }

        @Override
        public void removeRange(int fromIndex, int toIndex) {
            super.removeRange(fromIndex, toIndex);
        }
    }
}
