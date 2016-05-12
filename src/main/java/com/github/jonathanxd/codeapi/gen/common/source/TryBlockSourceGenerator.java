/*
 *      ${expr} - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
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
import com.github.jonathanxd.codeapi.gen.CodePartValue;
import com.github.jonathanxd.codeapi.gen.GenValue;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.StringValue;
import com.github.jonathanxd.codeapi.gen.TargetValue;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.helper.TryCatchBlock;
import com.github.jonathanxd.codeapi.interfaces.Bodiable;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.util.Parent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jonathan on 09/05/16.
 */
public class TryBlockSourceGenerator implements Generator<TryCatchBlock, String, PlainSourceGenerator> {

    public static final TryBlockSourceGenerator INSTANCE = new TryBlockSourceGenerator();

    private TryBlockSourceGenerator() {
    }

    @Override
    public List<GenValue<?, String, PlainSourceGenerator>> gen(TryCatchBlock tryCatchBlock, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents) {

        List<GenValue<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        values.add(StringValue.create("try"));


        CodePart expression = tryCatchBlock.getExpression().orElse(null);

        if(expression != null) {
            values.add(StringValue.create("("));
            values.add(CodePartValue.create(expression, parents));
            values.add(StringValue.create(")"));
        }

        values.add(TargetValue.create(Bodiable.class, tryCatchBlock, parents));

        Collection<CatchBlock> catchBlocks = tryCatchBlock.getCatchBlocks();

        for(CatchBlock catchBlock : catchBlocks) {
            values.add(TargetValue.create(catchBlock.getClass(), catchBlock, parents));
        }

        Bodiable finallyBlock = tryCatchBlock.getFinallyBlock().orElse(null);

        if(finallyBlock != null) {
            values.add(StringValue.create("finally"));
            values.add(TargetValue.create(Bodiable.class, finallyBlock, parents));
        }

        return values;
    }

}
