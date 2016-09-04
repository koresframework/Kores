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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.gen.CodeSourceData;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.TargetValue;
import com.github.jonathanxd.codeapi.gen.Value;
import com.github.jonathanxd.codeapi.gen.ValueImpl;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.optional.Require;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
public class ReturnSourceGenerator implements Generator<Return, String, PlainSourceGenerator> {

    public static final ReturnSourceGenerator INSTANCE = new ReturnSourceGenerator();

    private ReturnSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(Return aReturn, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {

        Optional<CodePart> value = aReturn.getValue();

        CodeType type = Require.require(aReturn.getType(), "Return value required!");

        if (type.getType().equals("void") || type.getJavaSpecName().equals("V")) {
            return Collections.singletonList(TargetValue.create(Require.require(value, "Value required!"), parents));
        }

        if (!value.isPresent())
            return Collections.singletonList(ValueImpl.create("return"));

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>(
                Arrays.asList(ValueImpl.create("return"), TargetValue.create(value.get(), parents)));

        if (Util.isBody(parents)) {
            values.add(ValueImpl.create(";"));
        }

        return values;
    }
}
