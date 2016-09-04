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
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jonathan on 09/05/16.
 */
public class FieldSourceGenerator implements Generator<FieldDeclaration, String, PlainSourceGenerator> {

    public static final FieldSourceGenerator INSTANCE = new FieldSourceGenerator();

    private FieldSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(FieldDeclaration codeField, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>(Arrays.asList(
                TargetValue.create(Annotable.class, codeField, parents),
                TargetValue.create(Modifierable.class, codeField, parents)
        ));

        codeField.getType().ifPresent(type -> values.add(TargetValue.create(type.getClass(), type, parents)));

        values.add(ValueImpl.create(codeField.getName()));

        codeField.getValue().ifPresent(value -> values.addAll(Arrays.asList(ValueImpl.create("="), TargetValue.create(value.getClass(), value, parents))));

        Parent<Generator<?, String, PlainSourceGenerator>> generatorParent1 = parents.find(generatorParent -> {
            if (MethodInvocation.class.isAssignableFrom(generatorParent.getCurrent().getClass())) {
                return true;
            }

            if (TypeDeclaration.class.isAssignableFrom(generatorParent.getCurrent().getClass())) {
                return true;
            }

            return false;
        }).orElse(null);

        if (generatorParent1 != null && TypeDeclaration.class.isAssignableFrom(generatorParent1.getCurrent().getClass())) {
            values.add(ValueImpl.create(";"));
        } else {

            if (Util.isBody(parents)) {
                values.add(ValueImpl.create(";"));
            }
        }


        return values;
    }

}
