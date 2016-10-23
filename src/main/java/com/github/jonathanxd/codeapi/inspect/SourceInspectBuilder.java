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
package com.github.jonathanxd.codeapi.inspect;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.builder.CodeInterfaceBuilder;
import com.github.jonathanxd.codeapi.interfaces.Bodied;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by jonathan on 21/08/16.
 */
public class SourceInspectBuilder<R> {

    /**
     * Predicate to test {@link CodePart}
     */
    private Predicate<CodePart> partPredicate;

    /**
     * Predicate to test {@link Bodied} elements. If test returns true, inspect elements inside the
     * {@link Bodied}.
     */
    private Predicate<Bodied> subFindPredicate;

    /**
     * True to inspect {@link CodeSource}, and not only sub elements.
     */
    private boolean inspectCodeSource = true;

    /**
     * {@link CodePart} mapper.
     */
    @SuppressWarnings("unchecked")
    private Function<CodePart, R> mapper = codePart -> (R) codePart;

    private SourceInspectBuilder() {
    }

    /**
     * Create the {@link CodeInterfaceBuilder}.
     *
     * @param <R> Type of resulting elements.
     * @return {@link CodeInterfaceBuilder}.
     */
    static <R> SourceInspectBuilder<R> builder() {
        return new SourceInspectBuilder<>();
    }

    /**
     * Find the elements that predicate accept.
     *
     * @param codePartPredicate Predicate to test elements.
     * @return {@code this}
     */
    public SourceInspectBuilder<R> find(Predicate<CodePart> codePartPredicate) {
        this.partPredicate = codePartPredicate;

        return this;
    }

    /**
     * Inspect elements inside specific {@link Bodied} elements.
     *
     * @param predicate Predicate to test {@link Bodied}s to be analyzed.
     * @return {@code this}
     */
    public SourceInspectBuilder<R> inside(Predicate<Bodied> predicate) {
        this.subFindPredicate = predicate;
        this.inspectCodeSource = false;
        return this;
    }

    /**
     * Include elements inside {@link Bodied}.
     *
     * @param predicate Predicate to test {@link Bodied}s to include in inspection.
     * @return {@code this}
     */
    public SourceInspectBuilder<R> include(Predicate<Bodied> predicate) {
        this.subFindPredicate = predicate;

        return this;
    }

    /**
     * Set to include code source inspection.
     *
     * If set to true, {@link SourceInspect} will inspect code source instead of inspect only sub
     * elements.
     *
     * @param inspectCodeSource If set to true, {@link SourceInspect} will inspect code source
     *                          instead of inspect only sub elements.
     * @return {@code this}
     */
    public SourceInspectBuilder<R> includeSource(boolean inspectCodeSource) {
        this.inspectCodeSource = inspectCodeSource;
        return this;
    }

    /**
     * Map the accepted elements to another type.
     *
     * @param mapper Mapper function
     * @param <V>    Type of resulting elements.
     * @return {@code this}
     */
    @SuppressWarnings("unchecked")
    public <V> SourceInspectBuilder<V> mapTo(Function<CodePart, V> mapper) {
        this.mapper = (Function<CodePart, R>) mapper;

        return (SourceInspectBuilder<V>) this;
    }

    /**
     * Inspect the {@link CodeSource}.
     *
     * @param codeSource Source to inspect.
     * @return List with accepted elements.
     */
    public List<R> inspect(CodeSource codeSource) {
        SourceInspect<R> build = this.build();

        return build.inspect(codeSource);
    }

    /**
     * Build the {@link SourceInspect}.
     *
     * @return {@link SourceInspect}.
     */
    public SourceInspect<R> build() {
        return new SourceInspect<>(this.partPredicate, this.inspectCodeSource, this.subFindPredicate, this.mapper);
    }
}
