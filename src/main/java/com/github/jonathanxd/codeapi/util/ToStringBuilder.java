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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by jonathan on 21/08/16.
 */
public class ToStringBuilder {

    private final Class<?> type;
    private final Map<String, Object> map = new HashMap<>();

    ToStringBuilder(Class<?> type) {
        this.type = type;
    }

    public static ToStringBuilder builder(Class<?> type) {
        return new ToStringBuilder(type);
    }

    public static ToStringBuilder builderOfObject(Object type) {
        return ToStringBuilder.builder(type.getClass());
    }

    public ToStringBuilder add(String key, Object value) {
        this.map.put(key, ToStringBuilder.toString(value));
        return this;
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public ToStringBuilder addOptional(String key, Optional<?> value) {
        if(value.isPresent())
            this.add(key, value.get());

        return this;
    }

    public <T> ToStringBuilder addIf(String key, T value, Predicate<T> predicate) {
        if(predicate.test(value))
            this.add(key, value);

        return this;
    }

    public <T, R> ToStringBuilder addMapped(String key, T value, Predicate<T> predicate, Function<T, R> mapper) {
        if(predicate.test(value))
            this.add(key, mapper.apply(value));

        return this;
    }

    private static String toString(Object o) {
        String oStr = o.toString();

        if(o instanceof Collection || o.getClass().isArray()) {
            oStr = "{"+oStr.substring(1, oStr.length() - 1)+"}";
        }else if(o instanceof String) {
            oStr = "\""+oStr+"\"";
        }

        return oStr;
    }

    @Override
    public String toString() {
        String s = this.map.toString();
        String str = s.substring(1, s.length()-1);

        return type.getSimpleName()+"["+str+"]";
    }
}
