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

import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.TargetValue;
import com.github.jonathanxd.codeapi.gen.Value;
import com.github.jonathanxd.codeapi.gen.ValueImpl;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.Expression;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.StaticBlock;
import com.github.jonathanxd.codeapi.util.OptionalUtil;
import com.github.jonathanxd.codeapi.util.Parent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
public class ForBlockSourceGenerator implements Generator<ForBlock, String, PlainSourceGenerator> {

    public static final ForBlockSourceGenerator INSTANCE = new ForBlockSourceGenerator();

    private ForBlockSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(ForBlock forBlock, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents) {

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        values.add(ValueImpl.create("for"));
        values.add(ValueImpl.create("("));

        Optional<Expression> forInitOpt = forBlock.getForInit();

        forInitOpt.ifPresent(expression -> values.add(TargetValue.create(expression, parents)));

        values.add(ValueImpl.create(";"));

        Optional<Expression> forExpressionOpt = forBlock.getForExpression();

        forExpressionOpt.ifPresent(expression -> values.add(TargetValue.create(expression, parents)));

        values.add(ValueImpl.create(";"));

        Optional<Expression> forUpdateOpt = forBlock.getForUpdate();

        forUpdateOpt.ifPresent(expression -> values.add(TargetValue.create(expression, parents)));

        values.add(ValueImpl.create(")"));

        values.add(TargetValue.create(Bodied.class, forBlock, parents));

        return values;
    }
}

