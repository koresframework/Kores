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
package com.github.jonathanxd.codeapi.gen;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.util.ClassUtil;
import com.github.jonathanxd.codeapi.util.Parent;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 07/05/16.
 */
public abstract class AbstractGenerator<T, C extends AbstractGenerator<T, C>> implements CodeGenerator<T> {

    static final Logger logger = Logger.getLogger("AbstractGenerator");

    @SuppressWarnings("unchecked")
    public static <T, C> void helpApply(Value<?, T, C> value, Object target, Object instance, Appender<T> appender) {
        value.apply((T) target, (C) instance, appender);
    }

    @SuppressWarnings("unchecked")
    private static <E, T, C> List<Value<?, T, C>> help(Generator<E, T, C> generator, Object target, Object instance, Parent<Generator<?, T, C>> parents) {
        return generator.gen((E) target, (C) instance, parents);
    }

    @SuppressWarnings("UnnecessaryQualifiedReference")
    @Override
    public synchronized T gen(CodeSource source) {

        Appender<T> appender = createAppender();

        Object instance = this;

        source.forEach((part) -> {
            List<Value<?, T, C>> call = generateTo(part.getClass() /*as Class<? extends CodePart>*/, part, null);

            if (call != null && !call.isEmpty()) {
                for (Value<?, T, C> value : call) {
                    AbstractGenerator.helpApply(value, part, instance, appender);
                }
            } else {
                throw new IllegalStateException("Cannot find generator for '"+part.getClass().getCanonicalName()+"'");
            }
        });

        return appender.get();
    }

    public abstract Appender<T> createAppender();

    @SuppressWarnings("unchecked")
    List<Value<?, T, C>> generateTo(Class<?> generatorTargetClass, Object target, Parent<Generator<?, T, C>> parents) {
        Map<Class<?>, Generator<?, T, C>> registry = getRegistry();

        EntryComparator entryComparator = new EntryComparator(generatorTargetClass);


        Map.Entry<Class<?>, Generator<?, T, C>> filterEntry = registry.entrySet().stream().filter((entry) -> entry.getKey() == generatorTargetClass).sorted(entryComparator).findFirst().orElse(null);

        if(filterEntry == null) {
            for (Class<?> aClass : ClassUtil.getAllSubclasses(generatorTargetClass)) {
                if(registry.containsKey(aClass)) {
                    filterEntry = new AbstractMap.SimpleEntry<>(aClass, registry.get(aClass));
                    break;
                }
            }
        }

        Generator<?, T, C> get = filterEntry != null ? filterEntry.getValue() : null;

        if (get != null) {

            if(filterEntry.getKey() != generatorTargetClass && !(target instanceof GenericGenerator))
                logger.warning("Processor of '"+generatorTargetClass.getCanonicalName()+"' isn't registered, using generic generator: '"+filterEntry.getKey()+"'!");
            try{
                return new ArrayList<>(AbstractGenerator.help(get, target, this, Parent.create(get, target, parents)));
            }catch (Throwable t) {
                throw new RuntimeException("Cannot parse! See parents: '"+parents+"'. ", t);
            }
        }

        throw new IllegalStateException("Cannot find generator for '"+generatorTargetClass.getCanonicalName()+"' while processing '"+target.getClass().getCanonicalName()+"'. Parents = "+parents);
    }

    @Deprecated
    Collection<Generator<?, T, C>> getFor(CodePart current) {

        Class<?> currentClass = current.getClass();

        EntryComparator entryComparator = new EntryComparator(currentClass);

        return getRegistry().entrySet().stream().filter(entry -> entry.getKey().isAssignableFrom(currentClass)).sorted(entryComparator).map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public abstract Map<Class<?>, Generator<?, T, C>> getRegistry();


    private class EntryComparator implements Comparator<Map.Entry<Class<?>, Generator<?, T, C>>> {

        private final Class<?> currentClass;
        private final List<Class<?>> allSubClasses = new ArrayList<>();

        EntryComparator(Class<?> currentClass) {
            this.currentClass = currentClass;
            allSubClasses.addAll(ClassUtil.getAllSubclasses(currentClass));
        }

        @Override
        public int compare(Map.Entry<Class<?>, Generator<?, T, C>> o1, Map.Entry<Class<?>, Generator<?, T, C>> o2) {
            //LEGACY return Integer.compare(o1.getCurrent().priority(), o2.getCurrent().priority());
            for (Class<?> allSubClass : allSubClasses) {
                if(allSubClass == o1.getKey()) {
                    return 1;
                }
                if(allSubClass == o2.getKey()) {
                    return -1;
                }
            }

            return o1.getKey() == currentClass ? 1 : o2.getKey() == currentClass ? -1 : 0;
        }
    }
}
