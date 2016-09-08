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

import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.List;

/**
 * {@link Value} that holds object of type {@link V}.
 *
 * This {@link Value} process the provided {@link #val} using {@link
 * AbstractGenerator#generateTo(Class, Object, Parent, CodeSourceData, MapData)} and call applier
 * methods of the resulted {@link Value}s.
 *
 * @param <V>      Value type.
 * @param <TARGET> Output object type.
 * @param <C>      Generator type.
 */
public class TargetValue<V, TARGET, C extends AbstractGenerator<TARGET, C>> extends TargetClassValue<TARGET, C> {

    /**
     * Value.
     */
    private final V val;

    /**
     * Constructor
     *
     * @param value   Value type used to determine which {@link Generator} to be used to process
     *                {@code val}.
     * @param val     Value
     * @param parents Parent Generators (bug tracing).
     */
    TargetValue(Class<?> value, V val, Parent<Generator<?, TARGET, C>> parents) {
        super(value, parents);
        this.val = val;
    }

    /**
     * Create {@link TargetValue}.
     *
     * @param targetClass Value type used to determine which {@link Generator} to be used to process
     *                    {@code val}.
     * @param val         Value.
     * @param parents     Parent Generators (bug tracing).
     * @param <V>         Value type.
     * @param <TARGET>    Output object type.
     * @param <C>         Generator type.
     * @return {@link TargetValue}.
     */
    public static <V, TARGET, C extends AbstractGenerator<TARGET, C>> Value<Class<?>, TARGET, C> create(Class<?> targetClass, V val, Parent<Generator<?, TARGET, C>> parents) {
        return new TargetValue<Object, TARGET, C>(targetClass, val, parents);
    }

    /**
     * Create {@link TargetValue}.
     *
     * Value type is inferred automatically by the {@link AbstractGenerator}.
     *
     * Not recommended for
     * complex {@link com.github.jonathanxd.codeapi.CodePart}s
     *
     * @param val      Value.
     * @param parents  Parent Generators (bug tracing).
     * @param <V>      Value type.
     * @param <TARGET> Output object type.
     * @param <C>      Generator type.
     * @return {@link TargetValue}.
     */
    public static <V, TARGET, C extends AbstractGenerator<TARGET, C>> Value<Class<?>, TARGET, C> create(V val, Parent<Generator<?, TARGET, C>> parents) {
        if (val instanceof CodeType) {
            return create(CodeType.class, val, parents);
        }

        return new TargetValue<Object, TARGET, C>(val.getClass(), val, parents);
    }

    @Override
    public void apply(TARGET value, C abstractGenerator, Appender<TARGET> appender, CodeSourceData codeSourceData, MapData data) {

        List<Value<?, TARGET, C>> to = abstractGenerator.generateTo(this.getValue(), this.getVal(), this.getParents(), codeSourceData, data);
        to.forEach(d -> d.apply(value, abstractGenerator, appender, codeSourceData, data));
    }

    /**
     * Gets the Value.
     *
     * @return Value.
     */
    public V getVal() {
        return val;
    }
}
