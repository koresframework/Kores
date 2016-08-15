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

import com.github.jonathanxd.codeapi.interfaces.InterfaceDeclaration;
import com.github.jonathanxd.codeapi.interfaces.TagLine;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jonathan on 18/06/16.
 */
public class Result<OUT> {

    private final OUT result;
    private final MapData data;

    public Result(OUT result, MapData data) {
        this.result = result;
        this.data = data;
    }

    public OUT getResult() {
        return result;
    }

    public MapData getData() {
        return data;
    }

    public TagLine<?, ?> findTagLine(InterfaceDeclaration codeInterface, StackTraceElement[] stackTraceElements) throws IllegalArgumentException {
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            if(stackTraceElement.getClassName().equals(codeInterface.getQualifiedName())) {
                return findTagLine(stackTraceElement.getLineNumber());
            }
        }

        throw new IllegalArgumentException("No tags in stack trace '"+ Arrays.toString(stackTraceElements)+"'");
    }

    public TagLine<?, ?> findTagLine(int line) throws IllegalArgumentException {
        List<TagLine<?, ?>> allAsList = getData().getAllAsList(BytecodeGenerator.LINES_REPRESENTATION);

        if(line < allAsList.size()) {
            return allAsList.get(line);
        }

        throw new IllegalArgumentException("No tags in line '"+line+"'");
    }
}
