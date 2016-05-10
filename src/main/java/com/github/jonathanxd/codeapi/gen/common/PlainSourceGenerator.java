/*
 *      ${expr} - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
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
package com.github.jonathanxd.codeapi.gen.common;

import com.github.jonathanxd.codeapi.gen.AbstractGenerator;
import com.github.jonathanxd.codeapi.gen.Appender;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.common.source.ArgumenterizableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.BodiableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.CodeParameterSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.HelperVASourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ImplementerSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.InterfaceSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.KeywordSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.LocalizedAtSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.MethodInvocationSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.HelperMISourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.MethodSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.MethodSpecificationSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ModifierSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.NamedSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ParameterizableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ReturnableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.CodeTypeSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.VariableAccessSourceGenerator;
import com.github.jonathanxd.codeapi.helper.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.helper.SimpleVariableAccess;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.interfaces.Argumenterizable;
import com.github.jonathanxd.codeapi.interfaces.Bodiable;
import com.github.jonathanxd.codeapi.interfaces.Implementer;
import com.github.jonathanxd.codeapi.interfaces.LocalizedAt;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.Parameterizable;
import com.github.jonathanxd.codeapi.interfaces.Returnable;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.keywords.Keyword;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.CodeParameter;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by jonathan on 09/05/16.
 */
public class PlainSourceGenerator extends AbstractGenerator<String, PlainSourceGenerator> {

    public static final PlainSourceGenerator INSTANCE = new PlainSourceGenerator();
    private static final Map<Class<?>, Generator<?, String, PlainSourceGenerator>> registry = new HashMap<>();

    static {
        registry.put(Implementer.class, ImplementerSourceGenerator.INSTANCE);
        registry.put(Modifierable.class, ModifierSourceGenerator.INSTANCE);
        registry.put(Named.class, NamedSourceGenerator.INSTANCE);
        registry.put(Keyword.class, KeywordSourceGenerator.INSTANCE);
        registry.put(CodeInterface.class, InterfaceSourceGenerator.INSTANCE);
        registry.put(Bodiable.class, BodiableSourceGenerator.INSTANCE);
        registry.put(CodeMethod.class, MethodSourceGenerator.INSTANCE);
        registry.put(Returnable.class, ReturnableSourceGenerator.INSTANCE);
        registry.put(CodeType.class, CodeTypeSourceGenerator.INSTANCE);
        registry.put(Parameterizable.class, ParameterizableSourceGenerator.INSTANCE);
        registry.put(CodeParameter.class, CodeParameterSourceGenerator.INSTANCE);

        // Method body
        registry.put(MethodSpecification.class, MethodSpecificationSourceGenerator.INSTANCE);
        registry.put(Argumenterizable.class, ArgumenterizableSourceGenerator.INSTANCE);
        registry.put(LocalizedAt.class, LocalizedAtSourceGenerator.INSTANCE);
        registry.put(VariableAccess.class, VariableAccessSourceGenerator.INSTANCE);
        registry.put(MethodInvocation.class, MethodInvocationSourceGenerator.INSTANCE);

        // Helper
        registry.put(SimpleVariableAccess.class, HelperVASourceGenerator.INSTANCE);
        registry.put(MethodInvocationImpl.class, HelperMISourceGenerator.INSTANCE);
    }

    public static PlainSourceGenerator singletonInstance() {
        return INSTANCE;
    }

    @Override
    public Appender<String> createAppender() {
        return new JoinerAppender(" ");
    }

    @Override
    public java.util.Map<Class<?>, Generator<?, String, PlainSourceGenerator>> getRegistry() {
        return registry;
    }

    private static final class JoinerAppender extends Appender<String> {
        private final StringJoiner join;

        JoinerAppender(String delimiter) {
            join = new StringJoiner(delimiter);
        }

        @Override
        public void add(String elem) {
            this.join.add(elem);
        }

        @Override
        public String get() {
            return this.join.toString();
        }
    }
}
