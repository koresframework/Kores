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
package com.github.jonathanxd.codeapi.util.gento;

import com.github.jonathanxd.codeapi.annotation.GenerateTo;

import java.util.Map;
import java.util.Objects;

public class GenToUtil {

    /**
     * Tries to determine the {@link Class} linked to {@link V} reading {@link GenerateTo}
     * annotations.
     *
     * @param cl  Current Class
     * @param map Map
     * @param <V> value type.
     * @return Found value linked to determined class.
     * @throws IllegalStateException if a value cannot be found.
     * @throws NullPointerException  if a value cannot be found.
     */
    @SuppressWarnings("unchecked")
    public static <V> V get(Class<?> cl, Map<Class<?>, V> map) {
        if (map.containsKey(cl)) {
            return map.get(cl);
        } else {
            GenerateTo generateTo = cl.getDeclaredAnnotation(GenerateTo.class);

            if (generateTo == null)
                generateTo = cl.getAnnotation(GenerateTo.class);

            if (generateTo != null) {
                return Objects.requireNonNull(map.get(generateTo.value()), "Cannot get value for class: '" + generateTo.value().getCanonicalName() + "'");
            } else {
                if (cl.isSynthetic()) {
                    Class<?>[] interfaces = cl.getInterfaces();
                    Class<?> i = interfaces.length > 0 ? interfaces[0] : cl.getSuperclass();

                    return Objects.requireNonNull(map.get(i), "Cannot get value for class: '" + i.getCanonicalName() + "'");
                }

                throw new IllegalStateException("Cannot get value for class: '" + cl.getCanonicalName() + "'");
            }
        }
    }

}
