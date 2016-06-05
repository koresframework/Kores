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
package com.github.jonathanxd.codeapi.gen;

import com.github.jonathanxd.codeapi.util.Parent;

import java.util.List;

/**
 * Created by jonathan on 09/05/16.
 */

// BUGS, and bugs, use TargetValue instead
class TargetClassValue<TARGET, C extends AbstractGenerator<TARGET, C>> implements Value<Class<?>, TARGET, C> {

    private final Class<?> value;
    private final Parent<Generator<?, TARGET, C>> current;

    public TargetClassValue(Class<?> value, Parent<Generator<?, TARGET, C>> current) {
        this.value = value;
        this.current = current;
    }

    @Override
    public void apply(TARGET value, C abstractGenerator, Appender<TARGET> appender, CodeSourceData codeSourceData, Data data) {
        try {
            List<Value<?, TARGET, C>> to = abstractGenerator.generateTo(this.getValue(), value, current, codeSourceData, data);
            to.forEach(d -> d.apply(value, abstractGenerator, appender, codeSourceData, data));
        }catch (Exception e) {
            throw new RuntimeException("Parents: "+current, e);
        }
    }

    public Parent<Generator<?, TARGET, C>> getParents() {
        return current;
    }

    @Override
    public Class<?> getValue() {
        return value;
    }

    public static <TARGET, C extends AbstractGenerator<TARGET, C>> Value<Class<?>, TARGET, C> create(Class<?> targetClass, Parent<Generator<?, TARGET, C>> current) {
        return new TargetClassValue<>(targetClass, current);
    }

}
