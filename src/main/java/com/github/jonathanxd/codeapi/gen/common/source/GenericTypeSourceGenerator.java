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

import com.github.jonathanxd.codeapi.gen.CodeSourceData;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.TargetValue;
import com.github.jonathanxd.codeapi.gen.Value;
import com.github.jonathanxd.codeapi.gen.ValueImpl;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.util.Parent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 09/05/16.
 */
public class GenericTypeSourceGenerator implements Generator<GenericType, String, PlainSourceGenerator> {

    public static final GenericTypeSourceGenerator INSTANCE = new GenericTypeSourceGenerator();

    private GenericTypeSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(GenericType genericType, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, Data data) {

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        if(genericType.isType()) {
            values.add(TargetValue.create(CodeType.class, genericType, parents));
        } else {
            if(!genericType.isWildcard()) {
                values.add(ValueImpl.create(genericType.name()));
            } else {
                values.add(ValueImpl.create("?"));
            }
        }


        GenericType.Bound<CodeType>[] bounds = genericType.bounds();

        if(bounds.length != 0) {

            for (int i = 0; i < bounds.length; i++) {

                boolean hasNext = i + 1 < bounds.length;

                GenericType.Bound<CodeType> bound = bounds[i];

                boolean extendsOrSuper = bound.sign().equals("+") ||  bound.sign().equals("-");

                if(bound.sign().equals("+")) {
                    values.add(ValueImpl.create("extends"));
                } else if (bound.sign().equals("-")) {
                    values.add(ValueImpl.create("super"));
                } else {
                    values.add(ValueImpl.create("<"));
                }

                CodeType type = bound.getType();

                values.add(TargetValue.create(type.getClass(), type, parents));

                if(!extendsOrSuper) {
                    values.add(ValueImpl.create(">"));
                }

                if(hasNext) {
                    values.add(ValueImpl.create("&"));
                }
            }

        }

        return values;
    }
}
