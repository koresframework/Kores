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
package com.github.jonathanxd.codeapi.gen.value.source;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.gen.Appender;
import com.github.jonathanxd.codeapi.gen.value.AbstractGenerator;
import com.github.jonathanxd.codeapi.gen.value.PlainValue;
import com.github.jonathanxd.codeapi.gen.value.ValueGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.AccessSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.AccessorSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.AnnotableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.AnnotationPropertySourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.AnnotationSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.AnnotationTypeSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ArgumenterizableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ArrayConstructorSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ArrayLengthSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ArrayLoadSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ArrayStoreSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.BodiedSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.BreakSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.CaseSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.CastedPartSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.CatchBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ClassTypeSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.CodeParameterSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.CodeSourceSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.CodeTypeSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ConcatSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ContinueSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.DoWhileBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ElseBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.EntryHolderSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.EntrySourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.EnumSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.EnumValueSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ExtenderSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.FieldSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ForBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ForEachSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.GenericSignatureSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.GenericTypeSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.GenerifiableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.HelperMISourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.HelperVASourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.IfBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.IfExprSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.IfExpressionableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ImplementerSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.InstanceOfSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.KeywordSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.LiteralSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.MethodInvocationSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.MethodSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.MethodSpecificationSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ModifierSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.NamedSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.OperateSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.PackageDeclarationSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ParameterizableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ReturnSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ReturnableSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.SimpleWhileBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.StaticBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.SugarSyntaxGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.SwitchSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.TagLineSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.ThrowExceptionGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.TryBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.TypeSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.VariableAccessSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.VariableOperateSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.VariableStoreSourceGenerator;
import com.github.jonathanxd.codeapi.gen.value.source.generator.WhileBlockSourceGenerator;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.InstructionCodePart;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.impl.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.impl.VariableAccessImpl;
import com.github.jonathanxd.codeapi.interfaces.Access;
import com.github.jonathanxd.codeapi.interfaces.Accessor;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.AnnotationDeclaration;
import com.github.jonathanxd.codeapi.interfaces.AnnotationProperty;
import com.github.jonathanxd.codeapi.interfaces.Argumenterizable;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.ArrayLength;
import com.github.jonathanxd.codeapi.interfaces.ArrayLoad;
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.Break;
import com.github.jonathanxd.codeapi.interfaces.Case;
import com.github.jonathanxd.codeapi.interfaces.Casted;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.Concat;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Continue;
import com.github.jonathanxd.codeapi.interfaces.DoWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.EntryHolder;
import com.github.jonathanxd.codeapi.interfaces.EnumDeclaration;
import com.github.jonathanxd.codeapi.interfaces.EnumEntry;
import com.github.jonathanxd.codeapi.interfaces.EnumValue;
import com.github.jonathanxd.codeapi.interfaces.Extender;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.interfaces.Generifiable;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.IfExpressionable;
import com.github.jonathanxd.codeapi.interfaces.Implementer;
import com.github.jonathanxd.codeapi.interfaces.InstanceOf;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.Operate;
import com.github.jonathanxd.codeapi.interfaces.PackageDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Parameterizable;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.interfaces.Returnable;
import com.github.jonathanxd.codeapi.interfaces.SimpleWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.StaticBlock;
import com.github.jonathanxd.codeapi.interfaces.Switch;
import com.github.jonathanxd.codeapi.interfaces.TagLine;
import com.github.jonathanxd.codeapi.interfaces.ThrowException;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.interfaces.TryWithResources;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.codeapi.interfaces.WhileBlock;
import com.github.jonathanxd.codeapi.keywords.Keyword;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.options.CodeOptions;
import com.github.jonathanxd.codeapi.sugar.SugarSyntax;
import com.github.jonathanxd.codeapi.types.ClassType;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.Ident;
import com.github.jonathanxd.codeapi.util.MultiString;
import com.github.jonathanxd.iutils.option.Options;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathan on 09/05/16.
 */
public class PlainSourceGenerator extends AbstractGenerator<String, PlainSourceGenerator> {

    @Deprecated
    public static final PlainSourceGenerator INSTANCE = new PlainSourceGenerator();

    private final Map<Class<?>, ValueGenerator<?, String, PlainSourceGenerator>> registry = new HashMap<>();
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
        register(TryBlock.class, TryBlockSourceGenerator.INSTANCE);
        register(CatchBlock.class, CatchBlockSourceGenerator.INSTANCE);
        register(Literal.class, LiteralSourceGenerator.INSTANCE);
        register(Bodied.class, BodiedSourceGenerator.INSTANCE);
        register(IfBlock.class, IfBlockSourceGenerator.INSTANCE);
        register(ElseBlock.class, ElseBlockSourceGenerator.INSTANCE);
        register(CodeSource.class, CodeSourceSourceGenerator.INSTANCE);
        register(StaticBlock.class, StaticBlockSourceGenerator.INSTANCE);
        register(ForBlock.class, ForBlockSourceGenerator.INSTANCE);
        register(Access.class, AccessSourceGenerator.INSTANCE);
        registerSuper(ConstructorDeclaration.class, MethodSourceGenerator.INSTANCE);
        register(Extender.class, ExtenderSourceGenerator.INSTANCE);
        register(PackageDeclaration.class, PackageDeclarationSourceGenerator.INSTANCE);
        register(ThrowException.class, ThrowExceptionGenerator.INSTANCE);
        register(Return.class, ReturnSourceGenerator.INSTANCE);
        register(IfExpressionable.class, IfExpressionableSourceGenerator.INSTANCE);
        register(IfExpr.class, IfExprSourceGenerator.INSTANCE);
        register(VariableDeclaration.class, VariableStoreSourceGenerator.INSTANCE);
        register(ArrayConstructor.class, ArrayConstructorSourceGenerator.INSTANCE);
        register(ArrayLoad.class, ArrayLoadSourceGenerator.INSTANCE);
        register(ArrayStore.class, ArrayStoreSourceGenerator.INSTANCE);
        register(ArrayLength.class, ArrayLengthSourceGenerator.INSTANCE);
        register(TagLine.class, TagLineSourceGenerator.INSTANCE);
        register(Operate.class, OperateSourceGenerator.INSTANCE);
        register(VariableOperate.class, VariableOperateSourceGenerator.INSTANCE);
        register(ClassType.class, ClassTypeSourceGenerator.INSTANCE);
        register(Accessor.class, AccessorSourceGenerator.INSTANCE);

        // While & Do
        register(DoWhileBlock.class, DoWhileBlockSourceGenerator.INSTANCE);
        register(WhileBlock.class, WhileBlockSourceGenerator.INSTANCE);
        register(SimpleWhileBlock.class, SimpleWhileBlockSourceGenerator.INSTANCE);
        register(ForEachBlock.class, ForEachSourceGenerator.INSTANCE);

        // Method body
        register(MethodSpecification.class, MethodSpecificationSourceGenerator.INSTANCE);
        register(Argumenterizable.class, ArgumenterizableSourceGenerator.INSTANCE);
        register(VariableAccess.class, VariableAccessSourceGenerator.INSTANCE);
        register(MethodInvocation.class, MethodInvocationSourceGenerator.INSTANCE);

        // Helper
        register(VariableAccessImpl.class, HelperVASourceGenerator.INSTANCE);
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

        // Instance Of
        register(InstanceOf.class, InstanceOfSourceGenerator.INSTANCE);

        // Control flow.
        register(Break.class, BreakSourceGenerator.INSTANCE);
        register(Continue.class, ContinueSourceGenerator.INSTANCE);

        // Switch & Case
        register(Switch.class, SwitchSourceGenerator.INSTANCE);
        register(Case.class, CaseSourceGenerator.INSTANCE);

        // Enum & Enum Entries
        register(EnumDeclaration.class, EnumSourceGenerator.INSTANCE);
        register(EntryHolder.class, EntryHolderSourceGenerator.INSTANCE);
        register(EnumEntry.class, EntrySourceGenerator.INSTANCE);

        // Annotation & Annotation Property
        register(AnnotationDeclaration.class, AnnotationTypeSourceGenerator.INSTANCE);
        register(AnnotationProperty.class, AnnotationPropertySourceGenerator.INSTANCE);

        // Concat
        register(Concat.class, ConcatSourceGenerator.INSTANCE);

        // Instruction
        register(InstructionCodePart.class, (instructionCodePart, plainSourceGenerator, parents, codeSourceData, data) ->
                Collections.singletonList(PlainValue.create("// InstructionCodePart[" + instructionCodePart + "];"))
        );
    }

    @SuppressWarnings("deprecation")
    @Deprecated
    public static PlainSourceGenerator singletonInstance() {
        return INSTANCE;
    }

    private <T> void register(Class<T> tClass, ValueGenerator<? extends T, String, PlainSourceGenerator> generator) {
        registry.put(tClass, generator);
    }

    private <T> void registerSuper(Class<T> tClass, ValueGenerator<? super T, String, PlainSourceGenerator> generator) {
        registry.put(tClass, generator);
    }

    @Override
    public <T extends CodePart, E extends CodePart> SugarSyntax<?, ?> registerSugarSyntax(Class<T> type, SugarSyntax<T, E> sugarSyntax) {

        SugarSyntax<?, ?> syntax = null;

        if (this.getRegistry().containsKey(type)) {
            ValueGenerator<?, String, PlainSourceGenerator> generator = this.getRegistry().get(type);

            if (generator instanceof SugarSyntaxGenerator<?, ?>)
                syntax = ((SugarSyntaxGenerator<?, ?>) generator).getSugarSyntax();
        }

        this.getRegistry().put(type, new SugarSyntaxGenerator<>(sugarSyntax));

        return syntax;
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
    public java.util.Map<Class<?>, ValueGenerator<?, String, PlainSourceGenerator>> getRegistry() {
        return this.registry;
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

            if(elem.isEmpty())
                return;

            boolean endsWithSemi = elem.endsWith(";");
            boolean endsWithOpenBr = elem.endsWith("{");
            boolean endsWithCloseBr = elem.endsWith("}");

            if (endsWithCloseBr) {
                elem = elem.substring(0, elem.length() - 1);
            }

            if (!elem.equals("\n"))
                this.multiString.add(elem);

            if (elem.equals("@"))
                this.isAnnotation = true;

            if (elem.equals("\n") && this.isAnnotation) {
                this.isAnnotation = false;
            }

            if (endsWithSemi
                    || endsWithOpenBr
                    || endsWithCloseBr
                    || elem.equals("\n")) {
                if (!this.isAnnotation) {
                    this.multiString.newLine();
                }
            }

            if (endsWithOpenBr) {
                if (!this.isAnnotation) {
                    this.indentation.addIdent();
                }
            }

            if (endsWithCloseBr) {
                if (!this.isAnnotation) {
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
