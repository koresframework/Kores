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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.gen.value.CodePartValue;
import com.github.jonathanxd.codeapi.gen.value.CodeSourceData;
import com.github.jonathanxd.codeapi.gen.value.PlainValue;
import com.github.jonathanxd.codeapi.gen.value.TargetValue;
import com.github.jonathanxd.codeapi.gen.value.Value;
import com.github.jonathanxd.codeapi.gen.value.ValueGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.interfaces.Accessor;
import com.github.jonathanxd.codeapi.interfaces.Operate;
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
public class OperateSourceGenerator implements ValueGenerator<Operate, String, PlainSourceGenerator> {

    public static final OperateSourceGenerator INSTANCE = new OperateSourceGenerator();

    private OperateSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(Operate operate, PlainSourceGenerator plainSourceGenerator, Parent<ValueGenerator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        CodePart target = operate.getTarget().orElse(null);

        values.add(CodePartValue.create(target, parents));

        OperateSourceGenerator.addOperation(values, operate, parents, false);

        if (Util.isBody(parents)) {
            values.add(PlainValue.create(";"));
        }

        return values;
    }

    static void addOperation(List<Value<?, String, PlainSourceGenerator>> values, Operate operate, Parent<ValueGenerator<?, String, PlainSourceGenerator>> parents, boolean appendEq) {
        operate.getOperation().ifPresent(operator -> {
            values.add(TargetValue.create(operator.getClass(), operator, parents));
            operate.getValue().ifPresent(codePart -> {
                if(appendEq) values.add(PlainValue.create("="));

                if(codePart instanceof Operate) {
                    values.add(PlainValue.create("("));
                }

                values.add(TargetValue.create(codePart.getClass(), codePart, parents));

                if(codePart instanceof Operate) {
                    values.add(PlainValue.create(")"));
                }
            });
        });
    }
}
