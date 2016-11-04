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
package com.github.jonathanxd.codeapi.gen.visit;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.gen.PartProcessor;
import com.github.jonathanxd.iutils.data.MapData;

/**
 * A part visitor.
 *
 * @param <T> Type of part.
 * @param <R> Type of generator result.
 * @param <L> Additional element type.
 */
public interface Visitor<T extends CodePart, R, L> extends PartProcessor {
    /**
     * Visit a {@link CodePart} of type {@link T}.
     *
     * @param t                Part to visit.
     * @param extraData        Data.
     * @param visitorGenerator Generator.
     * @param additional       Additional element.
     * @return Result.
     */
    R[] visit(T t, MapData extraData, VisitorGenerator<R> visitorGenerator, L additional);

    /**
     * End a visit to a {@link CodePart} of type {@link T}.
     *
     * @param r                Result of {@link #visit(CodePart, MapData, VisitorGenerator, Object)}
     *                         invocation.
     * @param t                Part to visit.
     * @param extraData        Data.
     * @param visitorGenerator Generator.
     * @param additional       Additional element.
     */
    default void endVisit(R[] r, T t, MapData extraData, VisitorGenerator<R> visitorGenerator, L additional) {

    }
}