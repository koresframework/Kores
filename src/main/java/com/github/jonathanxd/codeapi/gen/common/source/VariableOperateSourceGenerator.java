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
package com.github.jonathanxd.codeapi.gen.common.source;

import com.github.jonathanxd.codeapi.gen.CodePartValue;
import com.github.jonathanxd.codeapi.gen.CodeSourceData;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.TargetValue;
import com.github.jonathanxd.codeapi.gen.Value;
import com.github.jonathanxd.codeapi.gen.ValueImpl;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.interfaces.AccessLocal;
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.codeapi.util.Parent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 09/05/16.
 */
public class VariableOperateSourceGenerator implements Generator<VariableOperate, String, PlainSourceGenerator> {

    public static final VariableOperateSourceGenerator INSTANCE = new VariableOperateSourceGenerator();

    private VariableOperateSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(VariableOperate operate, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        if (operate.getLocalization() != null && !(operate.getLocalization() instanceof AccessLocal)) {
            values.add(CodePartValue.create(operate.getLocalization(), parents));
            values.add(ValueImpl.create("."));
        }

        values.add(ValueImpl.create(operate.getName()));

        operate.getOperation().ifPresent(operator -> {
            values.add(TargetValue.create(operator.getClass(), operator, parents));
            operate.getValue().ifPresent(codePart -> {
                values.add(ValueImpl.create("="));
                values.add(TargetValue.create(codePart.getClass(), codePart, parents));
            });
        });


        Parent<Generator<?, String, PlainSourceGenerator>> parent = parents.getParent();

        if (parent != null && BodiedSourceGenerator.class.isAssignableFrom(parent.getCurrent().getClass())) {
            values.add(ValueImpl.create(";"));
        }

        return values;
    }
}
