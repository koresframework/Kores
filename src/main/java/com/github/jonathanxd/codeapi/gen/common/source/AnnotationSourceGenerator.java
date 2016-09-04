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
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.EnumValue;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jonathan on 09/05/16.
 */
public class AnnotationSourceGenerator implements Generator<Annotation, String, PlainSourceGenerator> {

    public static final AnnotationSourceGenerator INSTANCE = new AnnotationSourceGenerator();

    private AnnotationSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(Annotation annotation, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {
        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();


        values.add(ValueImpl.create("@"));
        values.add(TargetValue.create(CodeType.class, annotation.getType().orElseThrow(NullPointerException::new), parents));

        Map<String, Object> valuesMap = annotation.getValues();

        values.add(ValueImpl.create("("));

        if(valuesMap.size() == 1 && valuesMap.containsKey("value")) {
            Object value = valuesMap.get("value");

            this.addType(value, values, parents);
        } else {

            valuesMap.forEach((key, value) -> {
                values.add(ValueImpl.create(key));
                values.add(ValueImpl.create("="));

               this.addType(value, values, parents);
            });
        }

        values.add(ValueImpl.create(")"));
        values.add(ValueImpl.create("\n"));

        return values;
    }

    private void addType(Object value, List<Value<?, String, PlainSourceGenerator>> values, Parent<Generator<?, String, PlainSourceGenerator>> parents) {
        if (value instanceof CodeType) {
            values.add(TargetValue.create(CodeType.class, value, parents));
        } else if (value instanceof EnumValue) {
            values.add(TargetValue.create(EnumValue.class, value, parents));
        } else if (value instanceof Annotation) {
            values.add(TargetValue.create(Annotation.class, value, parents));
        } else if (value.getClass().isArray()) {
            Object[] valuesObj = (Object[]) value;

            values.add(ValueImpl.create("{"));

            for (int i = 0; i < valuesObj.length; i++) {
                Object o = valuesObj[i];

                this.addType(o, values, parents);

                if(i + 1 < valuesObj.length) {
                    values.add(ValueImpl.create(","));
                }
            }

            values.add(ValueImpl.create("}"));
        } else {
            values.add(ValueImpl.create(value.toString()));
        }
    }
}
