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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.gen.Appender;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.List;

/**
 * {@link Value} that holds {@link CodeSource}.
 *
 * This value call generator of each element in provided {@link #source}.
 *
 * @param <TARGET> Result Object type.
 * @param <C>      Generator type.
 */
public class CodeSourceValue<TARGET, C extends AbstractGenerator<TARGET, C>> implements Value<CodeSource, TARGET, C> {

    /**
     * Code source
     */
    private final CodeSource source;

    /**
     * Parent generators (bug tracing).
     */
    private final Parent<ValueGenerator<?, TARGET, C>> current;

    /**
     * Constructor
     *
     * @param source  Code Source
     * @param current Parent generators (bug tracing).
     */
    public CodeSourceValue(CodeSource source, Parent<ValueGenerator<?, TARGET, C>> current) {
        this.source = source;
        this.current = current;
    }

    /**
     * Create the value
     *
     * @param source   Code Source
     * @param current  Parent generators (bug tracing).
     * @param <TARGET> Result Object type.
     * @param <C>      Generator type.
     * @return {@link CodeSourceValue}
     */
    public static <TARGET, C extends AbstractGenerator<TARGET, C>> Value<CodeSource, TARGET, C> create(CodeSource source, Parent<ValueGenerator<?, TARGET, C>> current) {
        return new CodeSourceValue<>(source, current);
    }

    @Override
    public void apply(TARGET value, C abstractGenerator, Appender<TARGET> appender, CodeSourceData codeSourceData, MapData data) {

        source.forEach((part) -> {
            List<Value<?, TARGET, C>> call = abstractGenerator.generateTo(part.getClass() /*as Class<? extends CodePart>*/, part, current, codeSourceData, data);

            if (call != null && !call.isEmpty()) {
                for (Value<?, TARGET, C> genValue : call) {
                    AbstractGenerator.helpApply(genValue, part, abstractGenerator, appender, codeSourceData, data);
                }
            } else {
                throw new IllegalStateException("Cannot find generator for '" + part.getClass().getCanonicalName() + "'");
            }
        });
    }

    /**
     * Gets the Parent generators (bug tracing).
     *
     * @return Parent generators (bug tracing).
     */
    public Parent<ValueGenerator<?, TARGET, C>> getParents() {
        return this.current;
    }

    @Override
    public CodeSource getValue() {
        return source;
    }

}
