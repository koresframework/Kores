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
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.gen.value.CodePartValue;
import com.github.jonathanxd.codeapi.gen.value.CodeSourceData;
import com.github.jonathanxd.codeapi.gen.value.PlainValue;
import com.github.jonathanxd.codeapi.gen.value.TargetValue;
import com.github.jonathanxd.codeapi.gen.value.Value;
import com.github.jonathanxd.codeapi.gen.value.ValueGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.impl.CatchBlockImpl;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.options.CodeOptions;
import com.github.jonathanxd.codeapi.transformer.TryCatchInliner;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
public class TryBlockSourceGenerator implements ValueGenerator<TryBlock, String, PlainSourceGenerator> {

    public static final TryBlockSourceGenerator INSTANCE = new TryBlockSourceGenerator();

    private TryBlockSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(TryBlock tryBlock, PlainSourceGenerator plainSourceGenerator, Parent<ValueGenerator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {

        final boolean isInline = plainSourceGenerator.getOptions().getOrElse(CodeOptions.INLINE_FINALLY, Boolean.FALSE);

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();


        values.add(PlainValue.create("try"));


        CodePart expression = tryBlock.getExpression().orElse(null);

        if (expression != null) {
            values.add(PlainValue.create("("));
            values.add(CodePartValue.create(expression, parents));
            values.add(PlainValue.create(")"));
        }


        Optional<CodeSource> finallyBlockOpt = tryBlock.getFinallyBlock();
        Optional<CodeSource> bodyOpt = tryBlock.getBody();

        if (!isInline || !TryCatchInliner.inlineSource(bodyOpt, finallyBlockOpt, values, parents)) {
            values.add(TargetValue.create(Bodied.class, tryBlock, parents));
        }

        Collection<CatchBlock> catchBlocks = tryBlock.getCatchBlocks();

        for (CatchBlock catchBlock : catchBlocks) {
            Optional<CodeSource> catchBodyOpt = catchBlock.getBody();

            if (isInline && catchBodyOpt.isPresent() && finallyBlockOpt.isPresent()) {
                CodeSource codeSource = catchBodyOpt.get();
                CodeSource finallyBlockSource = finallyBlockOpt.get();

                CodeSource modified = TryCatchInliner.insertInlineSecure(codeSource, finallyBlockSource);

                catchBlock = new CatchBlockImpl(catchBlock.getField(), catchBlock.getExceptionTypes(), modified);
            }

            values.add(TargetValue.create(catchBlock.getClass(), catchBlock, parents));
        }

        CodeSource finallyBlock = finallyBlockOpt.orElse(null);

        if (finallyBlock != null && !isInline) {
            values.add(PlainValue.create("finally"));
            values.add(TargetValue.create(CodeSource.class, finallyBlock, parents));
        }

        return values;
    }

}
