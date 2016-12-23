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
package com.github.jonathanxd.codeapi.util.source;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.inspect.SourceInspect;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.MultiBodied;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.iutils.container.primitivecontainers.BooleanContainer;
import com.github.jonathanxd.iutils.function.consumer.TriConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by jonathan on 25/07/16.
 */

/**
 * Utility for mutable CodeSources
 */
public class CodeSourceUtil {

    /**
     * Insert element {@code toInsert} in {@code source} after element determined by {@code
     * predicate} or at end of source if not found.
     *
     * @param predicate Predicate to determine element
     * @param toInsert  Element to insert after element determined by {@code predicate}
     * @param source    Source to find element and insert element {@code toInsert}
     * @return {@code source}
     */
    public static MutableCodeSource insertAfterOrEnd(Predicate<CodePart> predicate, CodeSource toInsert, CodeSource source) {

        BooleanContainer any = BooleanContainer.of(false);

        MutableCodeSource result = CodeSourceUtil.insertAfter(codePart -> {
            if (predicate.test(codePart)) {
                any.toTrue();
                return true;
            }

            return false;
        }, toInsert, source);

        if (!any.get()) {
            result.add(toInsert);
        }

        return result;
    }

    /**
     * Insert element {@code toInsert} in {@code source} before element determined by {@code
     * predicate} or at end of source if not found.
     *
     * @param predicate Predicate to determine element
     * @param toInsert  Element to insert after element determined by {@code predicate}
     * @param source    Source to find element and insert element {@code toInsert}
     * @return {@code source}
     */
    public static MutableCodeSource insertBeforeOrEnd(Predicate<CodePart> predicate, CodeSource toInsert, CodeSource source) {

        BooleanContainer any = BooleanContainer.of(false);

        MutableCodeSource result = CodeSourceUtil.insertBefore(codePart -> {
            if (predicate.test(codePart)) {
                any.toTrue();
                return true;
            }

            return false;
        }, toInsert, source);

        if (!any.get()) {
            result.add(toInsert);
        }

        return result;
    }


    /**
     * Insert element {@code toInsert} in {@code source} after element determined by {@code
     * predicate}
     *
     * @param predicate Predicate to determine element
     * @param toInsert  Element to insert after element determined by {@code predicate}
     * @param source    Source to find element and insert element {@code toInsert}
     * @return {@code source}
     */
    public static MutableCodeSource insertAfter(Predicate<CodePart> predicate, CodeSource toInsert, CodeSource source) {

        BooleanContainer any = BooleanContainer.of(false);

        return CodeSourceUtil.visit(source, (part, location, codeParts) -> {
            if (any.get())
                return;

            if (location == Location.AFTER) {
                if (predicate.test(part)) {
                    codeParts.addAll(toInsert);
                    any.set(true);
                }
            }
        });
    }


    /**
     * Insert element {@code toInsert} in {@code source} before element determined by {@code
     * predicate}
     *
     * @param predicate Predicate to determine element
     * @param toInsert  Element to insert before element determined by {@code predicate}
     * @param source    Source to find element and insert element {@code toInsert}
     * @return {@code source}
     */
    public static MutableCodeSource insertBefore(Predicate<CodePart> predicate, CodeSource toInsert, CodeSource source) {

        BooleanContainer any = BooleanContainer.of(false);

        return CodeSourceUtil.visit(source, (part, location, codeParts) -> {
            if (any.get())
                return;

            if (location == Location.BEFORE) {
                if (predicate.test(part)) {
                    codeParts.addAll(toInsert);
                    any.set(true);
                }
            }
        });
    }


    /**
     * Visit Code Source elements.
     *
     * This method create a new {@link CodeSource} and add all elements from {@code codeSource}
     * before and after visits each {@link CodePart} of {@code codeSource}.
     *
     * When visiting process finish, it will clear {@code codeSource} and add all elements from new
     * {@link CodeSource}
     *
     * @param codeSource Code Source to visit
     * @param consumer   Consumer
     * @return Result source.
     */
    public static MutableCodeSource visit(CodeSource codeSource, TriConsumer<CodePart, Location, MutableCodeSource> consumer) {

        MutableCodeSource returnSource = new MutableCodeSource();

        for (CodePart codePart : codeSource) {
            CodeSourceUtil.consumeIfExists(codePart, codePart0 -> consumer.accept(codePart0, Location.BEFORE, returnSource));
            returnSource.add(codePart);
            CodeSourceUtil.consumeIfExists(codePart, codePart0 -> consumer.accept(codePart0, Location.AFTER, returnSource));
        }

        return returnSource;

    }


    private static void consumeIfExists(CodePart part, Consumer<CodePart> sourceConsumer) {
        if (part instanceof MultiBodied) {
            ((MultiBodied) part).getBodies().forEach(codeParts -> {
                for (CodePart codePart : codeParts) {
                    CodeSourceUtil.consumeIfExists(codePart, sourceConsumer);
                }
            });
        } else if (part instanceof Bodied) {
            ((Bodied) part).getBody().ifPresent(codeParts -> {
                for (CodePart codePart : codeParts) {
                    CodeSourceUtil.consumeIfExists(codePart, sourceConsumer);
                }
            });
        } else {
            sourceConsumer.accept(part);
        }
    }

    /**
     * Find an element in a code source. (Highly recommended to use {@link
     * com.github.jonathanxd.codeapi.inspect.SourceInspect} instead of this.
     *
     * @param codeSource Code Source.
     * @param predicate  Predicate.
     * @param function   Mapper.
     * @param <U>        Mapped return type.
     * @return List of mapped parts.
     */
    public static <U> List<U> find(CodeSource codeSource, Predicate<CodePart> predicate, Function<CodePart, U> function) {
        List<U> list = new ArrayList<>();

        for (CodePart codePart : codeSource) {
            if (codePart instanceof CodeSource) {
                list.addAll(CodeSourceUtil.find((CodeSource) codePart, predicate, function));
            } else {
                if (predicate.test(codePart)) {
                    list.add(function.apply(codePart));
                }
            }
        }

        return list;
    }


    /**
     * Gets a new name of a inner class.
     *
     * @param name            Base name.
     * @param typeDeclaration Declaration.
     * @return A new unique name.
     */
    public static String getNewInnerName(String name, TypeDeclaration typeDeclaration) {
        List<TypeDeclaration> inspect = SourceInspect.find(codePart -> codePart instanceof TypeDeclaration)
                .includeSource(true)
                .include(bodied -> bodied instanceof CodeSource)
                .mapTo(codePart -> (TypeDeclaration) codePart)
                .inspect(typeDeclaration.getBody().orElse(CodeSource.empty()));

        while (CodeSourceUtil.contains(name, inspect))
            name += "$1";

        return name;
    }

    /**
     * Gets a new name.
     *
     * @param name   Base name.
     * @param nameds Elements (to find conflicts).
     * @return A new unique name.
     */
    public static String getNewName(String name, List<? extends Named> nameds) {
        while (CodeSourceUtil.contains(name, nameds))
            name += "$1";

        return name;
    }

    /**
     * Gets a new field name.
     *
     * @param name   Base name.
     * @param source Source (to find conflicts).
     * @return A new unique name.
     */
    public static String getNewFieldName(String name, CodeSource source) {
        List<CodeField> inspect = SourceInspect.find(codePart -> codePart instanceof CodeField)
                .includeSource(true)
                .include(bodied -> bodied instanceof CodeSource)
                .mapTo(codePart -> (CodeField) codePart)
                .inspect(source);

        while (CodeSourceUtil.contains(name, inspect))
            name += "$1";

        return name;
    }

    /**
     * Gets a new method name.
     *
     * @param name   Base name.
     * @param source Source (to find conflicts)
     * @return A new unique name.
     */
    public static String getNewMethodName(String name, CodeSource source) {
        List<CodeMethod> inspect = SourceInspect.find(codePart -> codePart instanceof CodeMethod)
                .includeSource(true)
                .include(bodied -> bodied instanceof CodeSource)
                .mapTo(codePart -> (CodeMethod) codePart)
                .inspect(source);

        while (CodeSourceUtil.contains(name, inspect))
            name += "$1";

        return name;
    }

    /**
     * Check if any element on list has the specified {@code name}.
     *
     * @param name          Name.
     * @param namedElements Elements.
     * @return True if any element on list has the specified {@code name}.
     */
    public static boolean contains(String name, List<? extends Named> namedElements) {
        for (Named named : namedElements) {
            if (named.getName().equals(name))
                return true;
        }

        return false;
    }
}
