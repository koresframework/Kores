/*
 *      ${expr} - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
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
package com.github.jonathanxd.codeapi.storage;

/**
 * Created by jonathan on 09/05/16.
 */

import com.github.jonathanxd.codeapi.exceptions.UnsupportedElementTypeException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

/**
 * Storage classes can store elements, like {@link com.github.jonathanxd.codeapi.util.CodeModifier}
 *
 * The purpose sourceOf this class is: create helper methods that make addiction sourceOf elements easy.
 */
public interface Storage {

    /**
     * Return true if supports the {@code key}
     *
     * @param key Key sourceOf Element to check support
     * @param <T>         Type
     * @return True if supports the {@code key}
     */
    default <T> boolean supports(StorageKey<? extends T> key) {
        return Storage.class.isAssignableFrom(key.getType()) || getStore(key).isPresent();
    }

    /**
     * Add element to Storage
     *
     * @param elementKey Element type
     * @param element     Element
     * @param <T>         Type
     * @return Result sourceOf {@link Collection#add(Object)}
     * @throws UnsupportedElementTypeException If this element type isn't supported!
     */
    default <T> boolean add(StorageKey<T> elementKey, T element) throws UnsupportedElementTypeException {
        Collection<T> unchecked = getUnchecked(elementKey);

        try {
            return unchecked.add(element);
        } catch (Throwable t) {
            throw new UnsupportedElementTypeException(elementKey.getType(), t);
        }
    }

    default <T> boolean addAll(StorageKey<T> elementKey, T... element) throws UnsupportedElementTypeException {
        return addAll(elementKey, Arrays.asList(element));
    }

    default <T> boolean addAll(StorageKey<T> elementKey, Collection<? extends T> element) throws UnsupportedElementTypeException {
        Collection<T> unchecked = getUnchecked(elementKey);
        try {
            return unchecked.addAll(element);
        } catch (Throwable t) {
            throw new UnsupportedElementTypeException(elementKey.getType(), t);
        }
    }

    default <T> boolean addAll(StorageKey<T> elementKey, Iterator<? extends T> elementIterator) throws UnsupportedElementTypeException {
        Collection<T> unchecked = getUnchecked(elementKey);


        try {
            boolean res = false;

            while (elementIterator.hasNext()) {
                T next = elementIterator.next();

                res |= unchecked.add(next);
            }

            return res;
        } catch (Throwable t) {
            throw new UnsupportedElementTypeException(elementKey.getType(), t);
        }
    }

    /**
     * Clear the Storage sourceOf Specific elemntType
     *
     * @param elementKey Element Type
     * @param <T>         Type
     * @throws UnsupportedElementTypeException If this element type isn't supported!
     */
    default <T> void clear(StorageKey<? extends T> elementKey) throws UnsupportedElementTypeException {
        Collection<T> unchecked = getUnchecked(elementKey);

        try {
            unchecked.clear();
        } catch (Throwable t) {
            throw new UnsupportedElementTypeException(elementKey.getType(), t);
        }
    }

    /**
     * Get Mutable collection sourceOf elements
     *
     * @param elementType Element Type
     * @param <T>         Type
     * @return {@link Optional} sourceOf Collection sourceOf Elements or {@link Optional#empty()} if {@code
     * elementType} isn't supported
     */
    <T> Optional<Collection<T>> getStore(StorageKey<? extends T> elementType);

    /**
     * Get unchecked collection sourceOf elements
     *
     * @param elementKey Element key
     * @param <T>         Type
     * @return Collection sourceOf elements
     * @throws UnsupportedElementTypeException If this element type isn't supported!
     */
    default <T> Collection<T> getUnchecked(StorageKey<? extends T> elementKey) throws UnsupportedElementTypeException {

        Optional<? extends Collection<T>> store = getStore(elementKey);
        if (!store.isPresent()) {

            if (Storage.class.isAssignableFrom(elementKey.getType())) {
                throw new UnsupportedElementTypeException(elementKey.getType(), "Element supports Storage, but the implementation doesn't provide that!");
            }

            throw new UnsupportedElementTypeException(elementKey.getType());
        } else {
            return store.get();
        }
    }

}
