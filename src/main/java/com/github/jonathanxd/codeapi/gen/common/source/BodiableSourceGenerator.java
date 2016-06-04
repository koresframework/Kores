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
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.gen.CodeSourceValue;
import com.github.jonathanxd.codeapi.gen.Value;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.ValueImpl;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.interfaces.Bodiable;
import com.github.jonathanxd.codeapi.util.CodeSourceData;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.util.Lambda;
import com.github.jonathanxd.codeapi.util.Parent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jonathan on 09/05/16.
 */

// * TODO: Replace: Bodiable -> Bodied, Now CodeSource is a CodePart
public class BodiableSourceGenerator implements Generator<Bodiable<?>, String, PlainSourceGenerator> {

    public static final BodiableSourceGenerator INSTANCE = new BodiableSourceGenerator();

    private BodiableSourceGenerator() {
    }

    public List<Value<?, String, PlainSourceGenerator>> gen(Bodiable<?> bodiable, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, Data data) {
        java.util.List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        Collection<CodeSource> bodies = bodiable.getBodies();

        //parents = Parent.create(this, parents);

        boolean isExpression = Lambda.testCast(bodiable, CodePart.class, CodePart::isExpression);

        if (!isExpression && bodies.isEmpty()) {
            values.add(ValueImpl.create(";"));
        }

        if(isExpression || !bodies.isEmpty()) {
            values.add(ValueImpl.create("{"));
        }

        for (CodeSource bodySource : bodies) {

            values.add(CodeSourceValue.create(bodySource, parents));

            //values.add(ValueImpl.create(plainSourceGenerator.gen(bodySource)));
        }

        if (isExpression || !bodies.isEmpty()) {
            values.add(ValueImpl.create("}"));

        }
        return values;
    }
}
