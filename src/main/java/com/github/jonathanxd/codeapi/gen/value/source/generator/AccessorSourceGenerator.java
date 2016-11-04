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
import com.github.jonathanxd.codeapi.interfaces.Access;
import com.github.jonathanxd.codeapi.interfaces.AccessLocal;
import com.github.jonathanxd.codeapi.interfaces.Accessor;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 09/05/16.
 */
public class AccessorSourceGenerator implements ValueGenerator<Accessor, String, PlainSourceGenerator> {

    public static final AccessorSourceGenerator INSTANCE = new AccessorSourceGenerator();

    private AccessorSourceGenerator() {
    }

    public static List<Value<?, String, PlainSourceGenerator>> gen(Accessor accessor, boolean separator, Parent<ValueGenerator<?, String, PlainSourceGenerator>> parents) {
        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        boolean anySeparator = false;

        CodePart target = accessor.getTarget().orElse(null);
        CodeType localization = accessor.getLocalization().orElse(null);
        boolean targetIsAccess = target != null && target instanceof Access;

        if (target != null && !targetIsAccess && target != localization) {
            values.add(CodePartValue.create(target, parents));

            if (separator) {
                values.add(PlainValue.create("."));
                anySeparator = true;
            }
        } else if (localization != null && !(target instanceof AccessLocal)) {
            values.add(TargetValue.create(CodeType.class, localization, parents));
            if (separator) {
                values.add(PlainValue.create("."));
                anySeparator = true;
            }
        }

        if (targetIsAccess && !(target instanceof AccessLocal)) {
            values.add(TargetValue.create(Access.class, target, parents));
            if (anySeparator || separator) values.add(PlainValue.create("."));
        }


        return values;
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(Accessor accessor, PlainSourceGenerator plainSourceGenerator, Parent<ValueGenerator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {

        return gen(accessor, true, parents);
    }
}
