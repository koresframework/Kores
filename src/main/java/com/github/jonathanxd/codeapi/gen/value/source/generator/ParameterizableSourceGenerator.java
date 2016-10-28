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
package com.github.jonathanxd.codeapi.gen.value.source.generator;

import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.gen.value.CodeSourceData;
import com.github.jonathanxd.codeapi.gen.value.PlainValue;
import com.github.jonathanxd.codeapi.gen.value.TargetValue;
import com.github.jonathanxd.codeapi.gen.value.Value;
import com.github.jonathanxd.codeapi.gen.value.ValueGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.Parameterizable;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jonathan on 09/05/16.
 */
public class ParameterizableSourceGenerator implements ValueGenerator<Parameterizable, String, PlainSourceGenerator> {

    public static final ParameterizableSourceGenerator INSTANCE = new ParameterizableSourceGenerator();

    private ParameterizableSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(Parameterizable parameterizable, PlainSourceGenerator plainSourceGenerator, Parent<ValueGenerator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        values.add(PlainValue.create("("));

        Collection<CodeParameter> parameters = parameterizable.getParameters();

        Iterator<CodeParameter> iterator = parameters.iterator();

        while (iterator.hasNext()) {
            CodeParameter next = iterator.next();

            values.add(TargetValue.create(Annotable.class, next, parents));
            values.add(TargetValue.create(CodeParameter.class, next, parents));

            if (iterator.hasNext())
                values.add(PlainValue.create(", "));

        }

        values.add(PlainValue.create(")"));

        return values;
    }
}
