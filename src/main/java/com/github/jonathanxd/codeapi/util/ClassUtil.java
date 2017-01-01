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
package com.github.jonathanxd.codeapi.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Internal undocumented.
 */
public class ClassUtil {


    private static List<Class<?>> getAllInterfaces(Class<?> base) {

        List<Class<?>> classes = new ArrayList<>();

        Class<?>[] interfaces = base.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            classes.add(anInterface);

            classes.addAll(getAllInterfaces(anInterface));
        }

        return classes;
    }

    public static Collection<Class<?>> getAllSubclasses(Class<?> base) {

        Set<Class<?>> classes = new LinkedHashSet<>();

        Class<?> superClass = base.getSuperclass();

        Collection<Runnable> nextActions = new ArrayList<>();

        if (superClass != null && superClass != Object.class) {
            classes.add(superClass);
            nextActions.add(() -> classes.addAll(getAllSubclasses(superClass)));
        }

        Class<?>[] interfaces = base.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            classes.add(anInterface);

            nextActions.add(() -> classes.addAll(getAllInterfaces(anInterface)));
        }

        nextActions.forEach(Runnable::run);

        return classes;
    }

}
