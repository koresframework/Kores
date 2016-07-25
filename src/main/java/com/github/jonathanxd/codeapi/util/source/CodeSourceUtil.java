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
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.MultiBodied;
import com.github.jonathanxd.iutils.function.consumer.TriConsumer;

import java.util.function.Consumer;
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
     * predicate}
     *
     * @param predicate Predicate to determine element
     * @param toInsert  Element to insert after element determined by {@code predicate}
     * @param source    Source to find element and insert element {@code toInsert}
     * @return {@code source}
     */
    public static CodeSource insertAfter(Predicate<CodePart> predicate, CodeSource toInsert, CodeSource source) {

        CodeSourceUtil.visit(source, (part, location, codeParts) -> {
            if (location == Location.AFTER) {
                if (predicate.test(part)) {
                    codeParts.addAll(toInsert);
                }
            }
        });

        return source;
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
    public static CodeSource insertBefore(Predicate<CodePart> predicate, CodeSource toInsert, CodeSource source) {

        CodeSourceUtil.visit(source, (part, location, codeParts) -> {
            if (location == Location.BEFORE) {
                if (predicate.test(part)) {
                    codeParts.addAll(toInsert);
                }
            }
        });

        return source;
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
     */
    public static void visit(CodeSource codeSource, TriConsumer<CodePart, Location, CodeSource> consumer) {

        CodeSource returnSource = new CodeSource();

        for (CodePart codePart : codeSource) {
            CodeSourceUtil.consumeIfExists(codePart, codePart0 -> consumer.accept(codePart0, Location.BEFORE, returnSource));
            returnSource.add(codePart);
            CodeSourceUtil.consumeIfExists(codePart, codePart0 -> consumer.accept(codePart0, Location.AFTER, returnSource));
        }

        codeSource.clear();

        codeSource.addAll(returnSource);
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

}
