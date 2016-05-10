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
package com.github.jonathanxd.codeapi.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by jonathan on 22/04/16.
 */
public class ClassUtil {
    public static Class<?>[] allLoaded(String[] strings) {
        List<Class<?>> classList = new ArrayList<>();

        for (String string : strings) {
            try {
                classList.add(Class.forName(string));
            } catch (ClassNotFoundException e) {

            }
        }

        return classList.toArray(new Class<?>[classList.size()]);
    }

    public static boolean anyInherit(Class<?> cl, Class<?>[] otherClasses) {
        for (Class<?> otherClass : otherClasses) {
            if (otherClass.isAssignableFrom(cl)) {
                return true;
            }
        }

        return false;
    }

    public static void consumeMethods(Consumer<Method> consumer, Class<?>[] interfaces, Class<?> superClass) {
        for (Class<?> interface_ : interfaces) {
            for (Method m : interface_.getMethods()) {
                consumer.accept(m);
            }
        }

        if (superClass != null) {
            for (Method m : superClass.getMethods()) {
                consumer.accept(m);
            }
        }
    }

    public static String[] toString(Class<?>[] classes) {
        String[] strings = new String[classes.length];

        for (int i = 0; i < classes.length; i++) {
            strings[i] = classes[i].getName();
        }

        return strings;
    }

    public static String[] toCanonicalString(Class<?>[] classes) {
        String[] strings = new String[classes.length];

        for (int i = 0; i < classes.length; i++) {
            strings[i] = classes[i].getCanonicalName();
        }

        return strings;
    }

    @SuppressWarnings("Duplicates")
    public static boolean allOk(Class<?>[] interfacesClass, Class<?>[] expecteds) {
        if (expecteds == null)
            return true;

        List<Class<?>> interfaceClassList = new ArrayList<>(Arrays.asList(interfacesClass));

        for (Class<?> expected : expecteds) {

            Class<?> impl = expected;
            if (interfaceClassList.contains(expected) || (impl = getImplement(expected, interfaceClassList)) != null) {
                interfaceClassList.remove(impl);
            } else {
                return false;
            }
        }

        if (interfaceClassList.size() > 0) {
            return false;
        }

        return interfaceClassList.size() <= 0;
    }

    @SuppressWarnings("Duplicates")
    public static void check(Class<?>[] interfacesClass, Class<?>[] templates, Class<?> superClass) {
        if (templates == null)
            return;

        List<Class<?>> interfaceClassList = new ArrayList<>(Arrays.asList(interfacesClass));

        if (superClass != null)
            interfaceClassList.add(superClass);

        interfaceClassList.removeIf(c -> c == Object.class);

        for (Class<?> template : templates) {
            Class<?> impl = template;
            if (interfaceClassList.contains(template) || (impl = getImplement(template, interfaceClassList)) != null) {
                interfaceClassList.remove(impl);
            } else {
                throw new RuntimeException("Implementation missing. Class " + template + " doesn't implements any class in interface list: '" + interfaceClassList + "'");
            }
        }

        if (interfaceClassList.size() > 0) {
            throw new RuntimeException("Implementation missing. Classes: " + interfaceClassList);
        }

    }

    public static boolean isLoaded(String clasz) {
        return isLoaded(clasz, null);
    }

    public static boolean isLoaded(String clasz, ClassLoader classLoader) {
        try {
            if (classLoader == null)
                Class.forName(clasz);
            else
                classLoader.loadClass(clasz);

            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static Class<?> getImplement(Class<?> aClass, Collection<Class<?>> classCollection) {
        for (Class<?> c : classCollection) {
            if (c.isAssignableFrom(aClass)) {
                return c;
            }
        }

        return null;
    }

    public static boolean isVoidReturn(Method m) {
        return m.getReturnType() == Void.TYPE || m.getReturnType() == void.class;
    }

    public static void deepGetInherits(Class<?> theClass, Consumer<Class<?>> consumer, boolean includeInterfaces) {
        Class<?> superClass = theClass.getSuperclass();

        if(superClass != null && superClass != Object.class) {
            consumer.accept(superClass);
            deepGetInherits(superClass, consumer, includeInterfaces);
        }

        if(includeInterfaces) {
            for (Class<?> aClass : theClass.getInterfaces()) {
                consumer.accept(aClass);
                deepGetInherits(aClass, consumer, includeInterfaces);
            }
        }
    }


    public static Collection<Field> getAllFields(Class<?> aClass, boolean includeInterfaces) {
        Collection<Field> fieldCollection = new ArrayList<>();

        for (Field field : aClass.getDeclaredFields()) {
            fieldCollection.add(field);
        }

        deepGetInherits(aClass, aClass1 -> {
            for (Field field : aClass1.getDeclaredFields()) {
                fieldCollection.add(field);
            }
        }, includeInterfaces);

        return fieldCollection;
    }
}
