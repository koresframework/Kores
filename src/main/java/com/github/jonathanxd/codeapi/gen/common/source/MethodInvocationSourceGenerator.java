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
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.gen.CodePartValue;
import com.github.jonathanxd.codeapi.gen.CodeSourceData;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.TargetValue;
import com.github.jonathanxd.codeapi.gen.Value;
import com.github.jonathanxd.codeapi.gen.ValueImpl;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.keywords.Keywords;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.util.Parent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 09/05/16.
 */
public class MethodInvocationSourceGenerator implements Generator<MethodInvocation, String, PlainSourceGenerator> {

    public static final MethodInvocationSourceGenerator INSTANCE = new MethodInvocationSourceGenerator();

    private MethodInvocationSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(MethodInvocation methodInvocationImpl, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, Data data) {

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        Optional<InvokeDynamic> invokeDynamicOpt = methodInvocationImpl.getInvokeDynamic();

        CodePart target = methodInvocationImpl.getTarget();
        MethodSpec spec = methodInvocationImpl.getSpec();
        InvokeType invokeType = methodInvocationImpl.getInvokeType();
        methodInvocationImpl.getSpec();

        CodeType localization = methodInvocationImpl.getLocalization();

        final String METHOD_SEPARATOR;

        if(invokeDynamicOpt.isPresent()) {

            InvokeDynamic invokeDynamic = invokeDynamicOpt.get();

            if(InvokeDynamic.isInvokeDynamicLambda(invokeDynamic)) {
                if(spec.getArguments().isEmpty()) {
                    METHOD_SEPARATOR = "::";
                } else {
                    values.add(ValueImpl.create("() ->")); // No arguments at time
                    METHOD_SEPARATOR = ".";
                }
            } else {
                throw new UnsupportedOperationException("Cannot generate source for dynamic method invocation, SourceGenerator only supports Lambda InvokeDynamic");
            }
        } else {
            METHOD_SEPARATOR = ".";
        }

        boolean isRef = METHOD_SEPARATOR.equals("::");


        boolean isCtr = spec.getMethodType() == MethodType.CONSTRUCTOR;
        if (isCtr && !isRef) {
            values.add(TargetValue.create(Keywords.NEW, parents));
        }

        if (target != null) {


            values.add(CodePartValue.create(target, parents));
            if (!isCtr && !spec.isArray()) {
                values.add(ValueImpl.create(METHOD_SEPARATOR)); //TODO: REVIEW
            }
        }

        if(localization != null && invokeType == InvokeType.INVOKE_STATIC) {
            values.add(CodePartValue.create(localization, parents));

            if (!isCtr && !spec.isArray()) {
                values.add(ValueImpl.create(METHOD_SEPARATOR));
            }
        }

        if(isCtr && isRef) {
            values.add(TargetValue.create(Keywords.NEW, parents));
        }

        values.add(TargetValue.create(MethodSpecification.class, spec, parents));

        return values;
    }
}
