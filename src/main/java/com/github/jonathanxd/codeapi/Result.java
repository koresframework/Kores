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
package com.github.jonathanxd.codeapi;

import com.github.jonathanxd.codeapi.interfaces.QualifiedNamed;
import com.github.jonathanxd.codeapi.interfaces.TagLine;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.Arrays;
import java.util.List;

/**
 * Result of the element process.
 *
 * @param <OUT> Output result.
 */
public class Result<OUT> {

    private final OUT result;
    private final MapData data;

    public Result(OUT result, MapData data) {
        this.result = result;
        this.data = data;
    }

    /**
     * Gets the result.
     *
     * @return Result.
     */
    public OUT getResult() {
        return result;
    }

    /**
     * Gets the data.
     *
     * @return Data.
     */
    public MapData getData() {
        return data;
    }

    /**
     * Find a tag line in stacktrace.
     *
     * @param qualifiedNamed     Qualified named.
     * @param stackTraceElements Stack trace.
     * @return Tag line.
     * @throws IllegalArgumentException If cannot find tag line.
     */
    public TagLine<?, ?> findTagLine(QualifiedNamed qualifiedNamed, StackTraceElement[] stackTraceElements) throws IllegalArgumentException {
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            if (stackTraceElement.getClassName().equals(qualifiedNamed.getQualifiedName())) {
                return findTagLine(stackTraceElement.getLineNumber());
            }
        }

        throw new IllegalArgumentException("No tags in stack trace '" + Arrays.toString(stackTraceElements) + "'");
    }

    /**
     * Find a tag line linked to a line.
     *
     * @param line Line
     * @return Found Tag line.
     * @throws IllegalArgumentException If cannot find tag line.
     */
    public TagLine<?, ?> findTagLine(int line) throws IllegalArgumentException {
        List<TagLine<?, ?>> allAsList = getData().getAllAsList(BytecodeGenerator.LINES_REPRESENTATION);

        if (line < allAsList.size()) {
            return allAsList.get(line);
        }

        throw new IllegalArgumentException("No tags in line '" + line + "'");
    }
}
