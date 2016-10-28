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

import com.github.jonathanxd.codeapi.gen.value.CodeSourceData;
import com.github.jonathanxd.codeapi.gen.value.PlainValue;
import com.github.jonathanxd.codeapi.gen.value.TargetValue;
import com.github.jonathanxd.codeapi.gen.value.Value;
import com.github.jonathanxd.codeapi.gen.value.ValueGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Generifiable;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.Parameterizable;
import com.github.jonathanxd.codeapi.interfaces.Returnable;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
public class MethodSourceGenerator implements ValueGenerator<MethodDeclaration, String, PlainSourceGenerator> {

    public static final MethodSourceGenerator INSTANCE = new MethodSourceGenerator();

    private MethodSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(MethodDeclaration codeMethod, PlainSourceGenerator plainSourceGenerator, Parent<ValueGenerator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {
        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        values.addAll(
                Arrays.asList(
                        TargetValue.create(Annotable.class, codeMethod, parents),
                        TargetValue.create(Modifierable.class, codeMethod, parents),
                        TargetValue.create(Generifiable.class, codeMethod, parents)
                ));

        if (!(codeMethod instanceof ConstructorDeclaration)) {
            values.add(TargetValue.create(Returnable.class, codeMethod, parents));
        }

        if (codeMethod instanceof ConstructorDeclaration) {

            String name = codeMethod.getName();

            Optional<Parent<ValueGenerator<?, String, PlainSourceGenerator>>> generatorParent = parents.find(CodeClass.class);

            if (generatorParent.isPresent()) {
                Parent<ValueGenerator<?, String, PlainSourceGenerator>> generatorParent1 = generatorParent.get();
                CodeClass target = (CodeClass) generatorParent1.getTarget();

                name = target.getSimpleName();
            }

            values.add(PlainValue.create(name));
        } else {
            values.add(TargetValue.create(Named.class, codeMethod, parents));
        }

        values.addAll(Arrays.asList(
                TargetValue.create(Parameterizable.class, codeMethod, parents),
                TargetValue.create(Bodied.class, codeMethod, parents)
        ));

        return values;

    }

}
