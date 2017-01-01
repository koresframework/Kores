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
package com.github.jonathanxd.codeapi.gen;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.sugar.SugarSyntax;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.option.Options;

/**
 * Represents a source generator that output element of type {@link OUT}
 *
 * @param <OUT> Output element type.
 */
public interface CodeGenerator<OUT> {

    /**
     * Generate object of type {@link OUT} from {@link CodeSource}.
     *
     * @param source Source of parts.
     * @return Generated object.
     */
    default OUT gen(CodeSource source) {
        return this.gen(source, new MapData(), null);
    }

    /**
     * Generate object of type {@link OUT} from {@link CodePart}.
     *
     * @param part Part to generate.
     * @return Generated object.
     */
    default OUT gen(CodePart part) {
        return this.gen(CodeAPI.sourceOfParts(part), new MapData(), null);
    }

    /**
     * Generate object of type {@link OUT} from {@link CodePart}.
     *
     * @param part       Part to generate.
     * @param data       MapData instance to be used to store information.
     * @param additional Additional object
     * @return Generated object.
     */
    default OUT gen(CodePart part, MapData data, Object additional) {
        return this.gen(CodeAPI.sourceOfParts(part), data, additional);
    }

    /**
     * Generate object of type {@link OUT} from {@link CodeSource}.
     *
     * @param source Source of parts.
     * @param data       MapData instance to be used to store information.
     * @param additional Additional object
     * @return Generated object.
     */
    OUT gen(CodeSource source, MapData data, Object additional);

    /**
     * Register a sugar syntax. The generation of {@link T} will be delegated into {@link
     * SugarSyntax#getGenerator() sugar.Generator}.
     *
     * @param type        Type
     * @param sugarSyntax Sugar syntax.
     * @param <T>         Type of supported input part.
     * @param <R>         Type of output part.
     * @return Old {@link SugarSyntax} registered to {@code type}.
     */
    <T extends CodePart, R extends CodePart> SugarSyntax<?, ?> registerSugarSyntax(Class<T> type, SugarSyntax<T, R> sugarSyntax);

    /**
     * Gets the {@link Options} instance.
     *
     * @return {@link Options} instance.
     */
    Options getOptions();
}
