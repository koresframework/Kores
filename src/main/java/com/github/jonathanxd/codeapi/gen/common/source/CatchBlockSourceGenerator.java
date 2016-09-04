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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.gen.CodeSourceData;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.TargetValue;
import com.github.jonathanxd.codeapi.gen.Value;
import com.github.jonathanxd.codeapi.gen.ValueImpl;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by jonathan on 09/05/16.
 */
public class CatchBlockSourceGenerator implements Generator<CatchBlock, String, PlainSourceGenerator> {

    public static final CatchBlockSourceGenerator INSTANCE = new CatchBlockSourceGenerator();

    private static int CATCH_VAR_COUNT = 0;

    private static int getAndIncrementCatchVar() {
        int i = CATCH_VAR_COUNT;

        ++CATCH_VAR_COUNT;

        return i;
    }

    private CatchBlockSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(CatchBlock catchBlock, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        values.add(ValueImpl.create("catch"));

        List<CodeType> parameters = catchBlock.getExceptionTypes();

        StringJoiner sj = new StringJoiner(" | ");

        if (!parameters.isEmpty()) {

            for (CodeType parameter : parameters) {
                String append = parameter.getCanonicalName();

                sj.add(append);
            }
        }

        String catchName = "internal__catch$"+getAndIncrementCatchVar();

        values.add(ValueImpl.create("(" + sj.toString() + " " + catchName + ")"));

        CodeSource codeSource = catchBlock.getBody().orElse(new CodeSource());

        CodeSource source2 = new CodeSource();

        CodeField field = catchBlock.getField();

        if(!field.getValue().isPresent()) {
            field = new CodeField(field.getName(), field.getVariableType(), Helper.accessLocalVariable(catchName, Throwable.class), field.getModifiers(), field.getAnnotations());
        }

        source2.add(field);

        source2.addAll(codeSource);

        values.add(TargetValue.create(CodeSource.class, source2, parents));

        return values;
    }

}
