/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CodeSource implements Iterable<CodePart>, CodePart {

    private static final CodePart[] EMPTY = new CodePart[0];
    private static final CodeSource EMPTY_CODE_SOURCE = new CodeSource(EMPTY);

    private final CodePart[] parts;

    protected CodeSource() {
        this(EMPTY);
    }

    protected CodeSource(CodePart[] parts) {
        this.parts = parts.length > 0 || parts == EMPTY ? parts.clone() : EMPTY;
    }

    protected CodeSource(Iterable<? extends CodePart> iterable) {
        this(iterable == null ? EMPTY : IterableUtil.stream(iterable).toArray(CodePart[]::new));
    }

    public static CodeSource empty() {
        return CodeSource.EMPTY_CODE_SOURCE;
    }

    public static CodeSource fromArray(CodePart[] parts) {
        return new CodeSource(parts);
    }

    public static CodeSource fromVarArgs(CodePart... parts) {
        return new CodeSource(parts);
    }

    public static CodeSource fromIterable(Iterable<? extends CodePart> iterable) {
        return new CodeSource(iterable);
    }

    public static CodeSource fromGenericIterable(Iterable<?> iterable) {
        return new CodeSource(IterableUtil.stream(iterable).toArray(CodePart[]::new));
    }

    public static CodeSource fromCodeSourceIterable(Iterable<? extends CodeSource> iterable) {
        return new CodeSource(IterableUtil.stream(iterable).flatMap(CodeSource::stream).toArray(CodePart[]::new));
    }

    public int size() {
        return this.parts.length;
    }

    public boolean isEmpty() {
        return this.size() <= 0;
    }

    public boolean contains(Object o) {
        for (CodePart part : this.parts) {
            if (equals(part, o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<CodePart> iterator() {
        return new Iterat();
    }

    public Object[] toArray() {
        return this.parts.clone();
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {

        Class<? extends T[]> type = (Class<? extends T[]>) a.getClass();

        return Arrays.copyOf(this.parts, this.parts.length, type);
    }

/*
    @Override
    public boolean add(CodePart codePart) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Immutable list");
    }
*/

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o))
                return false;
        }

        return true;
    }

/*
    @Override
    public boolean addAll(Collection<? extends CodePart> c) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public boolean addAll(int index, Collection<? extends CodePart> c) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Immutable list");
    }
*/

    public CodePart get(int index) {
        if (index >= this.parts.length)
            throw new IndexOutOfBoundsException("Index: " + index + ". Size: " + this.parts.length + ".");

        return this.parts[index];
    }

/*
    @Override
    public CodePart set(int index, CodePart element) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public void add(int index, CodePart element) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public CodePart remove(int index) {
        throw new UnsupportedOperationException("Immutable list");
    }
*/

    public int indexOf(Object o) {

        for (int i = 0; i < this.parts.length; i++) {
            if (equals(this.parts[i], o))
                return i;
        }

        return -1;
    }

    public int lastIndexOf(Object o) {

        for (int i = this.parts.length - 1; i >= 0; i--) {
            if (equals(this.parts[i], o))
                return i;
        }

        return -1;
    }

    private boolean equals(Object a, Object b) {
        return (a == null && b == null) || a == b || (a != null && b != null && a.equals(b));
    }

    @Override
    public Spliterator<CodePart> spliterator() {
        return Spliterators.spliterator(this.parts.clone(), Spliterator.ORDERED);
    }

    public ListIterator<CodePart> listIterator() {
        return this.listIterator(0);
    }

    public ListIterator<CodePart> listIterator(int index) {
        return new ListIterat(index);
    }

    public CodeSource subSource(int fromIndex, int toIndex) {
        return new CodeSource(Arrays.copyOfRange(this.parts, fromIndex, toIndex));
    }

/*
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public boolean removeIf(Predicate<? super CodePart> filter) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public void replaceAll(UnaryOperator<CodePart> operator) {
        throw new UnsupportedOperationException("Immutable list");
    }

    @Override
    public void sort(Comparator<? super CodePart> c) {
        throw new UnsupportedOperationException("Immutable list");
    }
*/

    @Override
    public void forEach(Consumer<? super CodePart> action) {
        for (CodePart part : this.parts) {
            action.accept(part);
        }
    }

    public Stream<CodePart> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    public Stream<CodePart> parallelStream() {
        return StreamSupport.stream(this.spliterator(), true);
    }

    public CodeSource toImmutable() {
        return new CodeSource(this.stream().toArray(CodePart[]::new));
    }

    public MutableCodeSource toMutable() {
        return new MutableCodeSource(this);
    }

    private final class Iterat implements Iterator<CodePart> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < CodeSource.this.size();
        }

        @Override
        public CodePart next() {
            if (!this.hasNext())
                throw new NoSuchElementException();

            return CodeSource.this.get(this.index++);
        }
    }

    private final class ListIterat implements ListIterator<CodePart> {

        private int index = 0;

        ListIterat(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return this.index < CodeSource.this.size();
        }

        @Override
        public CodePart next() {
            if (!this.hasNext())
                throw new NoSuchElementException();

            return CodeSource.this.get(this.index++);
        }

        @Override
        public boolean hasPrevious() {
            return this.index - 1 >= 0;
        }

        @Override
        public CodePart previous() {

            if (!this.hasPrevious())
                throw new NoSuchElementException();

            return CodeSource.this.get(--this.index);
        }

        @Override
        public int nextIndex() {
            return this.index;
        }

        @Override
        public int previousIndex() {
            return this.index - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Immutable list");
        }

        @Override
        public void set(CodePart codePart) {
            throw new UnsupportedOperationException("Immutable list");
        }

        @Override
        public void add(CodePart codePart) {
            throw new UnsupportedOperationException("Immutable list");
        }
    }
}