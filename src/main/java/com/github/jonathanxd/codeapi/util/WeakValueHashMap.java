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

import com.github.jonathanxd.iutils.function.collector.BiCollectors;
import com.github.jonathanxd.iutils.function.stream.MapStream;
import com.github.jonathanxd.iutils.object.Node;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 19/05/16.
 */
public class WeakValueHashMap<K, V> extends AbstractMap<K, V> {

    private final HashMap<K, Weak<V>> map;

    private final ReferenceQueue<V> referenceQueue;

    public WeakValueHashMap() {
        map = new HashMap<>();
        referenceQueue = new ReferenceQueue<>();
    }

    private static boolean equals(Object o1, Object o2) {
        return o1 != null && o2 != null && o1.equals(o2);
    }

    @Override
    public int size() {
        this.updateMap();

        return map.size();
    }

    @Override
    public boolean isEmpty() {
        this.updateMap();

        return map.isEmpty();
    }

    @Override
    public V get(Object key) {
        this.updateMap();

        return getReferenceValue(map.get(key));
    }

    @Override
    public boolean containsKey(Object key) {
        this.updateMap();

        return map.containsKey(key);
    }

    @Override
    public V put(K key, V value) {
        this.updateMap();

        return getReferenceValue(map.put(key, create(key, value)));
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        this.updateMap();

        map.putAll(MapStream.of(m).map((o, o2) -> new Node<>(o, create(o, o2))).collect(BiCollectors.toMap()));
    }

    @Override
    public V remove(Object key) {
        this.updateMap();

        return getReferenceValue(map.remove(key));
    }

    private Weak<V> create(K key, V value) {
        this.updateMap();

        return new Weak<>(key, value, referenceQueue);
    }

    @Override
    public void clear() {
        this.updateMap();

        map.clear();
    }

    @Override
    public boolean containsValue(Object value) {

        this.updateMap();

        Optional<Node<K, Weak<V>>> first = MapStream.of(map).filter((k, vWeak) -> equals(getReferenceValue(vWeak), value)).findFirst();

        return !(!first.isPresent() || first.get().getValue() == null);
    }

    @Override
    public Set<K> keySet() {
        this.updateMap();

        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        this.updateMap();

        return map.values().stream().filter(d -> d != null).map(this::getReferenceValue).collect(Collectors.toList());
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        this.updateMap();

        return map.entrySet()
                .stream()
                .filter(e -> getReferenceValue(e.getValue()) != null)
                .map(kWeakEntry -> new AbstractMap.SimpleEntry<>(kWeakEntry.getKey(), getReferenceValue(kWeakEntry.getValue())))
                .collect(Collectors.toSet());
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        this.updateMap();

        V val = get(key);

        return val != null ? val : defaultValue;
    }

    @Override
    public V putIfAbsent(K key, V value) {

        this.updateMap();

        V val = get(key);

        if (val == null) {
            put(key, value);
            return null;
        }

        return val;
    }

    @Override
    public boolean remove(Object key, Object value) {
        this.updateMap();

        return weakRemove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        this.updateMap();

        return weakReplace(key, oldValue, newValue);
    }

    private boolean weakReplace(K key, V oldValue, V newValue) {
        this.updateMap();

        return find((k, v) -> k.equals(key) && v.equals(oldValue), (k, v) -> map.replace(k, v, create(k, newValue)));
    }

    @Override
    public V replace(K key, V value) {
        this.updateMap();

        V curValue;
        if (((curValue = get(key)) != null) || containsKey(key)) {
            curValue = put(key, value);
        }

        return curValue;
    }

    public void forEach(BiConsumer<? super K, ? super V> action) {
        this.updateMap();

        MapStream.of(map).map((k, v) -> new Node<>(k, getReferenceValue(v))).forEach(action);
    }

    @Override
    public Object clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException ignored) {}

        this.updateMap();

        WeakValueHashMap<K, V> weakValueHashMap = new WeakValueHashMap<>();
        weakValueHashMap.putAll(this);

        return weakValueHashMap;
    }

    @Override
    public boolean equals(Object o) {
        this.updateMap();

        if(o instanceof Map) {
            return map.equals(o);
        }

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        this.updateMap();

        return map.hashCode();
    }

    @Override
    public String toString() {
        this.updateMap();

        return map.toString();
    }

    private boolean find(BiPredicate<K, V> wk, BiConsumer<K, Weak<V>> consumer) {

        boolean state = false;

        Set<Entry<K, Weak<V>>> entries = map.entrySet();

        for (Entry<K, Weak<V>> entry : entries) {

            Weak<V> vWeak = entry.getValue();

            if (vWeak == null)
                continue;

            V value = getReferenceValue(vWeak);

            if (wk.test(entry.getKey(), value)) {
                consumer.accept(entry.getKey(), vWeak);
                state |= true;
            }
        }

        return state;
    }

    private boolean weakRemove(Object key, Object value) {

        Set<Entry<K, Weak<V>>> entries = map.entrySet();

        for (Entry<K, Weak<V>> entry : entries) {

            if (!entry.getKey().equals(key))
                continue;

            Weak<V> vWeak = entry.getValue();

            if (equals(getReferenceValue(vWeak), value)) {
                return map.remove(key, vWeak);
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    private void updateMap() {
        Weak<V> valueRef;
        while ((valueRef = (Weak<V>) referenceQueue.poll()) != null) {
            map.remove(valueRef.getKey());
        }
    }

    private V getReferenceValue(Weak<V> valueRef) {
        return valueRef == null ? null : valueRef.get();
    }

    private class Weak<T> extends WeakReference<T> {
        private final K key;

        public Weak(K key, T value, ReferenceQueue<? super T> q) {
            super(value, q);
            this.key = key;
        }

        public K getKey() {
            return key;
        }
    }

}
