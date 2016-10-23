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
package com.github.jonathanxd.codeapi.gen.value;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.annotation.Default;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.gen.Appender;
import com.github.jonathanxd.codeapi.gen.CodeGenerator;
import com.github.jonathanxd.codeapi.util.ClassUtil;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.containers.primitivecontainers.IntContainer;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Generator of {@link T} from a {@link CodeSource} (source of {@link CodePart}).
 *
 * @param <T> Output type
 * @param <C> Generator type
 */
public abstract class AbstractGenerator<T, C extends AbstractGenerator<T, C>> implements CodeGenerator<T> {

    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger("AbstractGenerator");

    /**
     * Help generics.
     *
     * Cast types and call {@link Value#apply(Object, Object, Appender, CodeSourceData, MapData)}.
     *
     * @param value          Value.
     * @param target         Target Code Part.
     * @param instance       Instance of {@link AbstractGenerator}.
     * @param appender       {@link T} appender.
     * @param codeSourceData Data of the source.
     * @param processingData Data of the processing environment.
     * @param <T>            Type of {@code target} part.
     * @param <C>            Type of {@link AbstractGenerator}.
     */
    @SuppressWarnings("unchecked")
    public static <T, C> void helpApply(Value<?, T, C> value, Object target, Object instance, Appender<T> appender, CodeSourceData codeSourceData, MapData processingData) {
        value.apply((T) target, (C) instance, appender, codeSourceData, processingData);
    }

    /**
     * Help generics.
     *
     * Cast types and call {@link ValueGenerator#gen(Object, Object, Parent, CodeSourceData, MapData)}.
     *
     * @param generator      Generator
     * @param target         Target code part
     * @param instance       Instance of {@link AbstractGenerator}
     * @param parents        Parent generators (bug tracing)
     * @param codeSourceData Data of the source.
     * @param processingData Data of the processing environment.
     * @param <E>            Type of {@code target} part.
     * @param <T>            {@link ValueGenerator} output type.
     * @param <C>            Type of {@link AbstractGenerator}.
     */
    @SuppressWarnings("unchecked")
    private static <E, T, C> List<Value<?, T, C>> help(ValueGenerator<E, T, C> generator, Object target, Object instance, Parent<ValueGenerator<?, T, C>> parents, CodeSourceData codeSourceData, MapData processingData) {
        return generator.gen((E) target, (C) instance, parents, codeSourceData, processingData);
    }

    @SuppressWarnings("UnnecessaryQualifiedReference")
    @Override
    public synchronized T gen(CodeSource source, MapData processingData, Object additional) {

        if(processingData == null)
            processingData = new MapData();

        Appender<T> appender = createAppender();

        Object instance = this;

        IntContainer index = new IntContainer(-1);

        CodeSourceData data = new CodeSourceData(source, index);


        for (int i = 0; i < source.size(); i++) {
            CodePart part = source.get(i);

            index.set(i);

            List<Value<?, T, C>> call = generateTo(part.getClass() /*as Class<? extends CodePart>*/, part, null, data, processingData);

            if (call != null && !call.isEmpty()) {
                for (Value<?, T, C> value : call) {
                    AbstractGenerator.helpApply(value, part, instance, appender, data, processingData);
                }
            } else {
                throw new IllegalStateException("Cannot find generator for '" + part.getClass().getCanonicalName() + "'");
            }
        }

        return appender.get();
    }

    /**
     * Create a appender.
     *
     * @return Appender
     */
    public abstract Appender<T> createAppender();

    /**
     * Generate {@link Value}s from a {@link CodePart}.
     *
     * @param generatorTargetClass Generator target class (this parameter is used to determine which
     *                             {@link ValueGenerator} to use to process {@code target}).
     * @param target               Target part to generate the {@link Value}s
     * @param parents              Parent {@link ValueGenerator}s
     * @param codeSourceData       Data of the source.
     * @param processingData       Data of the processing environment.
     * @return Values generated by generators.
     */
    @SuppressWarnings("unchecked")
    List<Value<?, T, C>> generateTo(Class<?> generatorTargetClass, Object target, Parent<ValueGenerator<?, T, C>> parents, CodeSourceData codeSourceData, MapData processingData) {
        Map<Class<?>, ValueGenerator<?, T, C>> registry = getRegistry();

        EntryComparator entryComparator = new EntryComparator(generatorTargetClass);

        final Class<?> targetClass;

        GenerateTo generateTo = generatorTargetClass.getDeclaredAnnotation(GenerateTo.class);

        if (generateTo != null && generateTo.value() != Default.class) {
            targetClass = generateTo.value();
        } else {
            targetClass = generatorTargetClass;
        }

        Map.Entry<Class<?>, ValueGenerator<?, T, C>> filterEntry = registry.entrySet().stream().filter((entry) -> entry.getKey() == targetClass).sorted(entryComparator).findFirst().orElse(null);

        if (filterEntry == null) {
            for (Class<?> aClass : ClassUtil.getAllSubclasses(generatorTargetClass)) {
                if (registry.containsKey(aClass)) {
                    filterEntry = new AbstractMap.SimpleEntry<>(aClass, registry.get(aClass));
                    break;
                }
            }
        }

        ValueGenerator<?, T, C> get = filterEntry != null ? filterEntry.getValue() : null;

        if (get != null) {

            if (filterEntry.getKey() != targetClass)
                logger.warning("Processor of '" + targetClass.getCanonicalName() + "' isn't registered, using generic generator: '" + filterEntry.getKey() + "'!");
            try {
                return new ArrayList<>(AbstractGenerator.help(get, target, this, Parent.create(get, target, parents), codeSourceData, processingData));
            } catch (Throwable t) {
                throw new RuntimeException("Cannot parse! See parents: '" + parents + "'. ", t);
            }
        }

        throw new IllegalStateException("Cannot find generator for '" + generatorTargetClass.getCanonicalName() + "' while processing '" + target.getClass().getCanonicalName() + "'. Parents = " + parents);
    }

    /**
     * Gets the registry of the Generators
     *
     * @return Registry of the generators.
     */
    protected abstract Map<Class<?>, ValueGenerator<?, T, C>> getRegistry();

    private class EntryComparator implements Comparator<Map.Entry<Class<?>, ValueGenerator<?, T, C>>> {

        private final Class<?> currentClass;
        private final List<Class<?>> allSubClasses = new ArrayList<>();

        EntryComparator(Class<?> currentClass) {
            this.currentClass = currentClass;
            allSubClasses.addAll(ClassUtil.getAllSubclasses(currentClass));
        }

        @Override
        public int compare(Map.Entry<Class<?>, ValueGenerator<?, T, C>> o1, Map.Entry<Class<?>, ValueGenerator<?, T, C>> o2) {
            for (Class<?> allSubClass : allSubClasses) {
                if (allSubClass == o1.getKey()) {
                    return 1;
                }
                if (allSubClass == o2.getKey()) {
                    return -1;
                }
            }

            return o1.getKey() == currentClass ? 1 : o2.getKey() == currentClass ? -1 : 0;
        }
    }
}
