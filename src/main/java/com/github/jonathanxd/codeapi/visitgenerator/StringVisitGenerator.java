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
package com.github.jonathanxd.codeapi.visitgenerator;

import com.github.jonathanxd.codeapi.Options;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.StringJoiner;

/**
 * Created by jonathan on 03/06/16.
 */
public class StringVisitGenerator extends VisitorGenerator<String> {

    private final Options options = new Options();

    @Override
    protected MapData makeData() {
        return new MapData();
    }

    @Override
    public Appender<String> createAppender() {
        return new JoinerAppender(" ");
    }

    private static final class JoinerAppender extends Appender<String> {
        private final StringJoiner join;

        JoinerAppender(String delimiter) {
            join = new StringJoiner(delimiter);
        }

        @Override
        public void add(String elem) {
            this.join.add(elem);
        }

        @Override
        public String[] get() {
            return new String[]{this.join.toString()};
        }
    }

    @Override
    public Options getOptions() {
        return options;
    }
}
