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

import com.github.jonathanxd.iutils.object.GenericRepresentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class Data {

    private final Map<GenericRepresentation<?>, List<Object>> map = new HashMap<>();

    public <T> int registerData(GenericRepresentation<T> genericRepresentation, T object) {

        if (!map.containsKey(genericRepresentation)) {
            map.put(genericRepresentation, new ArrayList<>());
        }

        map.get(genericRepresentation).add(object);

        return map.get(genericRepresentation).size() - 1;
    }

    public <T> void unregisterData(GenericRepresentation<T> genericRepresentation, T object) {

        if (!map.containsKey(genericRepresentation))
            return;

        map.get(genericRepresentation).remove(object);

        if (map.get(genericRepresentation).isEmpty())
            map.remove(genericRepresentation);

    }

    public <T> void unregisterAllData(GenericRepresentation<T> genericRepresentation) {
        map.remove(genericRepresentation);
    }

    @SuppressWarnings("unchecked")
    public <T> Collection<T> getAll(GenericRepresentation<T> genericRepresentation) {
        Collection<T> ts = (Collection<T>) map.get(genericRepresentation);

        if (ts == null)
            return Collections.emptyList();

        return ts;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getAllAsList(GenericRepresentation<T> genericRepresentation) {
        List<T> ts = (List<T>) map.get(genericRepresentation);

        if (ts == null)
            return Collections.emptyList();

        return ts;
    }

    @SuppressWarnings("unchecked")
    public <T> Optional<T> getOptional(GenericRepresentation<T> genericRepresentation) {
        List<Object> objectList = map.get(genericRepresentation);

        if (objectList == null) {
            return Optional.empty();
        }

        return Optional.ofNullable((T) objectList.get(objectList.size() - 1));
    }

    @SuppressWarnings("unchecked")
    public <T, U extends T> Optional<U> getOptionalCasted(GenericRepresentation<T> genericRepresentation) {

        List<Object> objectList = map.get(genericRepresentation);

        if (objectList == null) {
            return Optional.empty();
        }

        return Optional.ofNullable((U) objectList.get(objectList.size() - 1));
    }

    public <T> T getRequired(GenericRepresentation<T> genericRepresentation) {
        return this.getOptional(genericRepresentation).get();
    }

    public <T> T getRequired(GenericRepresentation<T> genericRepresentation, String message) {
        return this.getOptional(genericRepresentation).orElseThrow(() -> new IllegalStateException(message));
    }

    public <T, U extends T> U getRequiredCasted(GenericRepresentation<T> genericRepresentation) {
        return this.<T, U>getOptionalCasted(genericRepresentation).get();
    }

    public <T, U extends T> U getRequiredCasted(GenericRepresentation<T> genericRepresentation, String message) {
        return this.<T, U>getOptionalCasted(genericRepresentation).orElseThrow(() -> new IllegalStateException(message));
    }
}
