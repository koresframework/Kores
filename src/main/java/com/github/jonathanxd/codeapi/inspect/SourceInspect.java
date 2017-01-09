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
package com.github.jonathanxd.codeapi.inspect;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.base.BodyHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Utility to inspect the {@link CodeSource}.
 *
 * @param <R> Mapper type.
 */
public class SourceInspect<R> {

    /**
     * Part predicate.
     */
    private final Predicate<CodePart> predicate;

    /**
     * True to inspect the {@link CodeSource} and not only sub elements.
     */
    private final boolean inspectCodeSource;

    /**
     * Predicate to test {@link BodyHolder} element. If predicate test returns true, inspect the {@link
     * BodyHolder} source.
     */
    private final Predicate<BodyHolder> subPredicate;

    /**
     * Mapper to convert {@link CodePart}s to {@link R}.
     */
    private final Function<CodePart, R> mapper;

    SourceInspect(Predicate<CodePart> predicate, boolean inspectCodeSource, Predicate<BodyHolder> subPredicate, Function<CodePart, R> mapper) {
        this.predicate = predicate;
        this.inspectCodeSource = inspectCodeSource;
        this.subPredicate = subPredicate;
        this.mapper = mapper;
    }

    /**
     * Find an element.
     *
     * @param codePartPredicate Predicate to test {@link CodePart}s.
     * @return Inspection builder.
     */
    public static SourceInspectBuilder<CodePart> find(Predicate<CodePart> codePartPredicate) {
        return SourceInspectBuilder.<CodePart>builder().find(codePartPredicate);
    }


    /**
     * Inspect the CodeSource.
     *
     * @param source Code source to inspect,
     * @return List of elements that are accepted by {@link #predicate}.
     */
    public List<R> inspect(CodeSource source) {

        List<R> list = new ArrayList<>();

        this.inspect(source, this.inspectCodeSource, list);

        return list;
    }

    /**
     * Inspect code source.
     *
     * @param source  Code source.
     * @param inspect Inspect current element.
     * @param list    Current list to add elements.
     */
    private void inspect(CodeSource source, boolean inspect, List<R> list) {

        for (CodePart codePart : source) {
            // Deep inspection
            if (codePart instanceof BodyHolder) {
                if (this.subPredicate != null && this.subPredicate.test((BodyHolder) codePart)) {
                    CodeSource body = ((BodyHolder) codePart).getBody();

                    if (body != null)
                        this.inspect(body, true, list);
                }
            }
            if (inspect) {
                if (this.predicate.test(codePart)) {
                    list.add(this.mapper.apply(codePart));
                }
            }
        }
    }
}
