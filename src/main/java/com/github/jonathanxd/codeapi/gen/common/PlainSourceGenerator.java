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
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.gen.AbstractGenerator;
import com.github.jonathanxd.codeapi.gen.Appender;
import com.github.jonathanxd.codeapi.gen.Generator;
import com.github.jonathanxd.codeapi.gen.common.source.AccessSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.AnnotableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.AnnotationSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ArgumenterizableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ArrayConstructorSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ArrayLengthSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ArrayLoadSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ArrayStoreSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.BodiedSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.CastedPartSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.CatchBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ClassTypeSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.CodeParameterSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.CodeSourceSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.CodeTypeSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.DoWhileBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ElseBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.EnumValueSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ExpressionSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ExtenderSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.FieldSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ForBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ForEachSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.GenericSignatureSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.GenericTypeSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.GenerifiableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.GroupableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.HelperMISourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.HelperVASourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.IfBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.IfExpressionableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ImplementerSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.KeywordSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.LiteralSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.LocalizedAtSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.MethodInvocationSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.MethodSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.MethodSpecificationSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ModifierSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.NamedSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.PackageDeclarationSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ParameterizableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ReturnSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ReturnableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.SimpleWhileBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.StaticBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.TagLineSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.ThrowExceptionGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.TryBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.TypeSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.VariableAccessSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.VariableOperateSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.VariableStoreSourceGenerator;
import com.github.jonathanxd.codeapi.gen.common.source.WhileBlockSourceGenerator;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.helper.SimpleVariableAccess;
import com.github.jonathanxd.codeapi.interfaces.Access;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.Argumenterizable;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.ArrayLength;
import com.github.jonathanxd.codeapi.interfaces.ArrayLoad;
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.Casted;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.DoWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.EnumValue;
import com.github.jonathanxd.codeapi.interfaces.Expression;
import com.github.jonathanxd.codeapi.interfaces.Extender;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.interfaces.Generifiable;
import com.github.jonathanxd.codeapi.interfaces.Groupable;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpressionable;
import com.github.jonathanxd.codeapi.interfaces.Implementer;
import com.github.jonathanxd.codeapi.interfaces.LocalizedAt;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.PackageDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Parameterizable;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.interfaces.Returnable;
import com.github.jonathanxd.codeapi.interfaces.SimpleWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.StaticBlock;
import com.github.jonathanxd.codeapi.interfaces.TagLine;
import com.github.jonathanxd.codeapi.interfaces.ThrowException;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.interfaces.TryWithResources;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;
import com.github.jonathanxd.codeapi.interfaces.WhileBlock;
import com.github.jonathanxd.codeapi.keywords.Keyword;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.options.CodeOptions;
import com.github.jonathanxd.codeapi.types.ClassType;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.Ident;
import com.github.jonathanxd.codeapi.util.MultiString;
import com.github.jonathanxd.iutils.option.Options;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathan on 09/05/16.
 */
public class PlainSourceGenerator extends AbstractGenerator<String, PlainSourceGenerator> {

    @Deprecated
    public static final PlainSourceGenerator INSTANCE = new PlainSourceGenerator();

    private final Map<Class<?>, Generator<?, String, PlainSourceGenerator>> registry = new HashMap<>();
    private final Options options = new Options();


    public PlainSourceGenerator() {
        this.options.set(CodeOptions.INLINE_FINALLY, false);

        register(Implementer.class, ImplementerSourceGenerator.INSTANCE);
        register(Modifierable.class, ModifierSourceGenerator.INSTANCE);
        register(Named.class, NamedSourceGenerator.INSTANCE);
        register(Keyword.class, KeywordSourceGenerator.INSTANCE);
        register(TypeDeclaration.class, TypeSourceGenerator.INSTANCE);
        register(FieldDeclaration.class, FieldSourceGenerator.INSTANCE);
        register(MethodDeclaration.class, MethodSourceGenerator.INSTANCE);
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
        register(Access.class, AccessSourceGenerator.INSTANCE);
        //register(CodeClass.class, ClassSourceGenerator.INSTANCE);
        register(Extender.class, ExtenderSourceGenerator.INSTANCE);
        register(PackageDeclaration.class, PackageDeclarationSourceGenerator.INSTANCE);
        register(ThrowException.class, ThrowExceptionGenerator.INSTANCE);
        register(Return.class, ReturnSourceGenerator.INSTANCE);
        register(IfExpressionable.class, IfExpressionableSourceGenerator.INSTANCE);
        register(VariableDeclaration.class, VariableStoreSourceGenerator.INSTANCE);
        register(ArrayConstructor.class, ArrayConstructorSourceGenerator.INSTANCE);
        register(ArrayLoad.class, ArrayLoadSourceGenerator.INSTANCE);
        register(ArrayStore.class, ArrayStoreSourceGenerator.INSTANCE);
        register(ArrayLength.class, ArrayLengthSourceGenerator.INSTANCE);
        register(TagLine.class, TagLineSourceGenerator.INSTANCE);
        register(VariableOperate.class, VariableOperateSourceGenerator.INSTANCE);
        register(ClassType.class, ClassTypeSourceGenerator.INSTANCE);

        // While & Do
        register(DoWhileBlock.class, DoWhileBlockSourceGenerator.INSTANCE);
        register(WhileBlock.class, WhileBlockSourceGenerator.INSTANCE);
        register(SimpleWhileBlock.class, SimpleWhileBlockSourceGenerator.INSTANCE);
        register(ForEachBlock.class, ForEachSourceGenerator.INSTANCE);

        // Method body
        register(MethodSpecification.class, MethodSpecificationSourceGenerator.INSTANCE);
        register(Argumenterizable.class, ArgumenterizableSourceGenerator.INSTANCE);
        register(LocalizedAt.class, LocalizedAtSourceGenerator.INSTANCE);
        register(VariableAccess.class, VariableAccessSourceGenerator.INSTANCE);
        register(MethodInvocation.class, MethodInvocationSourceGenerator.INSTANCE);

        // Helper
        register(SimpleVariableAccess.class, HelperVASourceGenerator.INSTANCE);
        register(MethodInvocationImpl.class, HelperMISourceGenerator.INSTANCE);

        // Cast
        register(Casted.class, CastedPartSourceGenerator.INSTANCE);

        // Generics
        register(Generifiable.class, GenerifiableSourceGenerator.INSTANCE);
        register(GenericSignature.class, GenericSignatureSourceGenerator.INSTANCE);
        register(GenericType.class, GenericTypeSourceGenerator.INSTANCE);

        // Annotation
        register(Annotable.class, AnnotableSourceGenerator.INSTANCE);
        register(Annotation.class, AnnotationSourceGenerator.INSTANCE);
        register(EnumValue.class, EnumValueSourceGenerator.INSTANCE);

        // Try-with-resources
        registerSuper(TryWithResources.class, TryBlockSourceGenerator.INSTANCE);
    }

    @SuppressWarnings("deprecation")
    @Deprecated
    public static PlainSourceGenerator singletonInstance() {
        return INSTANCE;
    }

    private <T> void register(Class<T> tClass, Generator<? extends T, String, PlainSourceGenerator> generator) {
        registry.put(tClass, generator);
    }

    private <T> void registerSuper(Class<T> tClass, Generator<? super T, String, PlainSourceGenerator> generator) {
        registry.put(tClass, generator);
    }

    @Override
    public Options getOptions() {
        return this.options;
    }

    @Override
    public Appender<String> createAppender() {
        return new MultiStringAppender(" ");
    }

    @Override
    public java.util.Map<Class<?>, Generator<?, String, PlainSourceGenerator>> getRegistry() {
        return registry;
    }

    private static final class MultiStringAppender extends Appender<String> {
        private final Ident indentation = new Ident(4);
        private final MultiString multiString;
        private boolean isAnnotation = false;

        MultiStringAppender(String delimiter) {
            this.multiString = new MultiString(delimiter, s -> indentation.getIdentString() + s);
        }

        @Override
        public void add(String elem) {

            boolean endsWithSemi = elem.endsWith(";");
            boolean endsWithOpenBr = elem.endsWith("{");
            boolean endsWithCloseBr = elem.endsWith("}");

            if (endsWithCloseBr) {
                elem = elem.substring(0, elem.length() - 1);
            }

            if(!elem.equals("\n"))
                this.multiString.add(elem);

            if(elem.equals("@"))
                this.isAnnotation = true;

            if(elem.equals("\n") && this.isAnnotation) {
                this.isAnnotation = false;
            }

            if (endsWithSemi
                    || endsWithOpenBr
                    || endsWithCloseBr
                    || elem.equals("\n")) {
                if(!this.isAnnotation) {
                    this.multiString.newLine();
                }
            }

            if (endsWithOpenBr) {
                if(!this.isAnnotation) {
                    this.indentation.addIdent();
                }
            }

            if (endsWithCloseBr) {
                if(!this.isAnnotation) {
                    this.indentation.removeIdent();
                    this.multiString.add("}");
                    this.multiString.newLine();
                    this.multiString.newLine();
                } else {
                    this.multiString.add("}");
                }
            }
        }

        @Override
        public String get() {
            return this.multiString.toString();
        }
    }
}
