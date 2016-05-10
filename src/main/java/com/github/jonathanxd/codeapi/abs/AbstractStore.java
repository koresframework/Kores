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
package com.github.jonathanxd.codeapi.abs;

import com.github.jonathanxd.codeapi.annotation.Default;
import com.github.jonathanxd.codeapi.annotation.Store;
import com.github.jonathanxd.codeapi.storage.Storage;
import com.github.jonathanxd.codeapi.storage.StorageKey;
import com.github.jonathanxd.codeapi.util.ClassUtil;
import com.github.jonathanxd.iutils.object.GenericRepresentation;
import com.github.jonathanxd.iutils.object.TypeUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
public abstract class AbstractStore implements Storage {

    private Map<StorageKey<?>, Collection<?>> store = null;

    public AbstractStore() {

    }

    public final void init() {
        if(store != null)
            throw new RuntimeException("Already initialized!");

        store = new HashMap<>();
        try {
            Class<?> current = this.getClass();
            Collection<Field> allFields = ClassUtil.getAllFields(current, false);

            for (Field field : allFields) {

                if(Modifier.isStatic(field.getModifiers()))
                    continue;

                Store store = field.getDeclaredAnnotation(Store.class);

                Class<?>[] types;

                if (store != null) {
                    types = store.value();
                    String id = store.id();

                    if(id.trim().isEmpty()) {
                        id = field.getName().toUpperCase();
                    }

                    if (types.length == 1 && types[0] == Default.class) {
                        GenericRepresentation<?> genericRepresentation = TypeUtil.toReference(field.getGenericType());

                        if(genericRepresentation.getRelated().length > 0) {
                            types = new Class[]{genericRepresentation.getRelated()[0].getAClass()};
                        } else {
                            types = new Class[]{field.getType()};
                        }
                    }

                    field.setAccessible(true);

                    Object o = field.get(this);

                    Objects.requireNonNull(o, "Illegal field '"+field+"'");

                    for (Class<?> type : types) {

                        StorageKey<?> key = new InternalStorageKey(id, type);

                        if (this.store.containsKey(key)) {
                            throw new RuntimeException("Storage already defined!");
                        }
                        this.store.put(key, (Collection<?>) o);
                    }

                }

            }
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<Collection<T>> getStore(StorageKey<? extends T> elementType) {

        if(store == null) {
            init();
        }

        Objects.requireNonNull(store, "Not initialized! at "+this.getClass());
        return !store.containsKey(elementType) ? Optional.empty() : Optional.of((Collection<T>) store.get(elementType));
    }

    private static final class InternalStorageKey extends StorageKey {

        protected InternalStorageKey(String id, Class<?> type) {
            super(id, type);
        }
    }
}
