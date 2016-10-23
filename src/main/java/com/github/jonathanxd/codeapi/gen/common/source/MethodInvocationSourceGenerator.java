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
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.gen.CodePartValue;
import com.github.jonathanxd.codeapi.gen.CodeSourceData;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.TargetValue;
import com.github.jonathanxd.codeapi.gen.Value;
import com.github.jonathanxd.codeapi.gen.PlainValue;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.interfaces.Accessor;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.Parameterizable;
import com.github.jonathanxd.codeapi.keywords.Keywords;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Parent;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.github.jonathanxd.codeapi.common.InvokeDynamic.LambdaFragment;
import static com.github.jonathanxd.codeapi.common.InvokeDynamic.isInvokeDynamicLambda;

/**
 * Created by jonathan on 09/05/16.
 */
public class MethodInvocationSourceGenerator implements Generator<MethodInvocation, String, PlainSourceGenerator> {

    public static final MethodInvocationSourceGenerator INSTANCE = new MethodInvocationSourceGenerator();

    private MethodInvocationSourceGenerator() {
    }

    @Override
    public List<Value<?, String, PlainSourceGenerator>> gen(MethodInvocation methodInvocationImpl, PlainSourceGenerator plainSourceGenerator, Parent<Generator<?, String, PlainSourceGenerator>> parents, CodeSourceData codeSourceData, MapData data) {

        List<Value<?, String, PlainSourceGenerator>> values = new ArrayList<>();

        Optional<InvokeDynamic> invokeDynamicOpt = methodInvocationImpl.getInvokeDynamic();

        CodePart target = methodInvocationImpl.getTarget().orElse(null);
        MethodSpecification spec = methodInvocationImpl.getSpec();
        InvokeType invokeType = methodInvocationImpl.getInvokeType();

        CodeType localization = methodInvocationImpl.getLocalization().orElse(null);

        final String METHOD_SEPARATOR;

        if (invokeDynamicOpt.isPresent()) {

            InvokeDynamic invokeDynamic = invokeDynamicOpt.get();

            if (invokeDynamic instanceof LambdaFragment) {

                LambdaFragment fragmentDynamic = (LambdaFragment) invokeDynamic;
                MethodFragment methodFragment = fragmentDynamic.getMethodFragment();

                MethodDeclaration method = methodFragment.getMethod();

                Optional<CodeSource> bodyOpt = method.getBody();

                values.add(TargetValue.create(Parameterizable.class, method, parents));

                if (bodyOpt.isPresent()) {
                    values.add(PlainValue.create("->"));

                    values.add(TargetValue.create(Bodied.class, method, parents));
                } else {
                    values.add(PlainValue.create("-> {};"));
                }

                return values;

            } else if (isInvokeDynamicLambda(invokeDynamic)) {
                if (spec.getArguments().isEmpty()) {
                    METHOD_SEPARATOR = "::";
                } else {
                    values.add(PlainValue.create("() ->"));
                    METHOD_SEPARATOR = ".";
                }
            } else {
                throw new UnsupportedOperationException("Cannot generate source for dynamic method invocation, SourceGenerator only supports Lambda InvokeDynamic");
            }
        } else {
            METHOD_SEPARATOR = ".";
        }

        // Is method reference
        boolean isRef = METHOD_SEPARATOR.equals("::");
        boolean isCtr = spec.getMethodName().equals("<init>");


        MethodInvocation mi = methodInvocationImpl;

        if(isCtr && !isRef) {
            values.add(TargetValue.create(Keywords.NEW, parents));
            mi = mi.setTarget(null);
        }

        values.addAll(AccessorSourceGenerator.gen(mi, !isRef && !isCtr, parents));

        if(isRef) {
            values.add(PlainValue.create(METHOD_SEPARATOR));
        }

        if(isCtr && isRef) {
            values.add(TargetValue.create(Keywords.NEW, parents));
        }

        values.add(TargetValue.create(MethodSpecification.class, spec, parents));


        if (Util.isBody(parents)) {
            values.add(PlainValue.create(";"));
        } else {
            debug();
        }

        return values;
    }


    private void debug() {
    }
}
