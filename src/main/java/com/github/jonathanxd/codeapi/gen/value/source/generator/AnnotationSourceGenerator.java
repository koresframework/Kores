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
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.EnumValue;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.ArrayUtility;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jonathan on 09/05/16.
 */
public class AnnotationSourceGenerator implements ValueGenerator<Annotation, String, PlainSourceGenerator> {

    public static final AnnotationSourceGenerator INSTANCE = new AnnotationSourceGenerator();

    private AnnotationSourceGenerator() {
    }

    public static void addType(Object value, List<Value<?, String, PlainSourceGenerator>> values, Parent<ValueGenerator<?, String, PlainSourceGenerator>> parents) {
        if (value instanceof CodeType) {
            values.add(TargetValue.create(CodeType.class, value, parents));
        } else if (value instanceof EnumValue) {
            values.add(TargetValue.create(EnumValue.class, value, parents));
        } else if (value instanceof Annotation) {
            values.add(TargetValue.create(Annotation.class, value, parents));
        } else if (value.getClass().isArray()) {
            Object[] valuesObj = ArrayUtility.toObjectArray(value);

            values.add(PlainValue.create("{"));

            for (int i = 0; i < valuesObj.length; i++) {
                Object o = valuesObj[i];

                AnnotationSourceGenerator.addType(o, values, parents);

                if (i + 1 < valuesObj.length) {
                    values.add(PlainValue.create(","));
                }
            }

            values.add(PlainValue.create("}"));
        } else if (value instanceof String) {
            values.add(PlainValue.create("\"" + String.valueOf(value) + "\""));
        } else {
            values.add(PlainValue.create(value.toString()));
        }
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(Annotation annotation, PlainSourceGenerator plainSourceGenerator, Parent<ValueGenerator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {
        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();


        values.add(PlainValue.create("@"));
        values.add(TargetValue.create(CodeType.class, annotation.getType().orElseThrow(NullPointerException::new), parents));

        Map<String, Object> valuesMap = annotation.getValues();

        values.add(PlainValue.create("("));

        if (valuesMap.size() == 1 && valuesMap.containsKey("value")) {
            Object value = valuesMap.get("value");

            AnnotationSourceGenerator.addType(value, values, parents);
        } else {

            valuesMap.forEach((key, value) -> {
                values.add(PlainValue.create(key));
                values.add(PlainValue.create("="));

                AnnotationSourceGenerator.addType(value, values, parents);
            });
        }

        values.add(PlainValue.create(")"));
        values.add(PlainValue.create("\n"));

        return values;
    }
}
