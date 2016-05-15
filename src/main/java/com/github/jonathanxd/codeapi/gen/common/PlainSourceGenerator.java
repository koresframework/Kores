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
package com.github.jonathanxd.codeapi.gen.common;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.gen.AbstractGenerator;
import com.github.jonathanxd.codeapi.gen.Appender;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.common.source.ArgumenterizableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.BodiableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.BodiedSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.CatchBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.CodeParameterSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.CodeSourceSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.DoWhileBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ElseBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ExpressionSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.FieldSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ForBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.GroupableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.HelperVASourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.IfBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ImplementerSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.InterfaceSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.KeywordSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.LiteralSourceGenerator;
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
import com.github.jonathanxd.codeapi.gen.common.source.SimpleWhileBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.StaticBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.TryBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.VariableAccessSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.WhileBlockSourceGenerator;
import com.github.jonathanxd.codeapi.helper.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.helper.SimpleVariableAccess;
import com.github.jonathanxd.codeapi.helper.TryCatchBlock;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.interfaces.Argumenterizable;
import com.github.jonathanxd.codeapi.interfaces.Bodiable;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.DoWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.Expression;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.Groupable;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.Implementer;
import com.github.jonathanxd.codeapi.interfaces.LocalizedAt;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.Parameterizable;
import com.github.jonathanxd.codeapi.interfaces.Returnable;
import com.github.jonathanxd.codeapi.interfaces.SimpleWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.StaticBlock;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.WhileBlock;
import com.github.jonathanxd.codeapi.keywords.Keyword;
import com.github.jonathanxd.codeapi.literals.Literal;
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
        register(Implementer.class, ImplementerSourceGenerator.INSTANCE);
        register(Modifierable.class, ModifierSourceGenerator.INSTANCE);
        register(Named.class, NamedSourceGenerator.INSTANCE);
        register(Keyword.class, KeywordSourceGenerator.INSTANCE);
        register(CodeInterface.class, InterfaceSourceGenerator.INSTANCE);
        register(Bodiable.class, BodiableSourceGenerator.INSTANCE);
        register(CodeField.class, FieldSourceGenerator.INSTANCE);
        register(CodeMethod.class, MethodSourceGenerator.INSTANCE);
        register(Returnable.class, ReturnableSourceGenerator.INSTANCE);
        register(CodeType.class, CodeTypeSourceGenerator.INSTANCE);
        register(Parameterizable.class, ParameterizableSourceGenerator.INSTANCE);
        register(CodeParameter.class, CodeParameterSourceGenerator.INSTANCE);
        register(Expression.class, ExpressionSourceGenerator.INSTANCE);
        register(TryBlock.class, TryBlockSourceGenerator.INSTANCE);
        register(CatchBlock.class, CatchBlockSourceGenerator.INSTANCE);
        register(Literal.class, LiteralSourceGenerator.INSTANCE);
        register(Bodied.class, BodiedSourceGenerator.INSTANCE);
        register(IfBlock.class, IfBlockSourceGenerator.INSTANCE);
        register(ElseBlock.class, ElseBlockSourceGenerator.INSTANCE);
        register(Groupable.class, GroupableSourceGenerator.INSTANCE);
        register(CodeSource.class, CodeSourceSourceGenerator.INSTANCE);
        register(StaticBlock.class, StaticBlockSourceGenerator.INSTANCE);
        register(ForBlock.class, ForBlockSourceGenerator.INSTANCE);

        // While & Do
        register(DoWhileBlock.class, DoWhileBlockSourceGenerator.INSTANCE);
        register(WhileBlock.class, WhileBlockSourceGenerator.INSTANCE);
        register(SimpleWhileBlock.class, SimpleWhileBlockSourceGenerator.INSTANCE);

        // Method body
        register(MethodSpecification.class, MethodSpecificationSourceGenerator.INSTANCE);
        register(Argumenterizable.class, ArgumenterizableSourceGenerator.INSTANCE);
        register(LocalizedAt.class, LocalizedAtSourceGenerator.INSTANCE);
        register(VariableAccess.class, VariableAccessSourceGenerator.INSTANCE);
        register(MethodInvocation.class, MethodInvocationSourceGenerator.INSTANCE);

        // Helper
        register(SimpleVariableAccess.class, HelperVASourceGenerator.INSTANCE);
        register(MethodInvocationImpl.class, HelperMISourceGenerator.INSTANCE);
    }

    public static PlainSourceGenerator singletonInstance() {
        return INSTANCE;
    }

    private static <T> void register(Class<T> tClass, Generator<? extends T, String, PlainSourceGenerator> generator) {
        registry.put(tClass, generator);
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
