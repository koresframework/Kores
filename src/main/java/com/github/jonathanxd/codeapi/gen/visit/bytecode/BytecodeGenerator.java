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
package com.github.jonathanxd.codeapi.gen.visit.bytecode;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.gen.ArrayAppender;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ArrayAccessVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ArrayLengthVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ArrayStoreVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.CodeMethodVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.CodeSourceVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ForEachVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.IfBlockVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.InstructionCodePart;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.MethodFragmentVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.OperateVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.PackageVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.StaticBlockVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.SwitchVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.TagLineVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.TryBlockVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.TypeVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.VariableAccessVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.WhileVisitor;
import com.github.jonathanxd.codeapi.interfaces.Access;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.Argumenterizable;
import com.github.jonathanxd.codeapi.interfaces.ArrayAccess;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.ArrayLength;
import com.github.jonathanxd.codeapi.interfaces.ArrayLoad;
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.interfaces.Break;
import com.github.jonathanxd.codeapi.interfaces.Casted;
import com.github.jonathanxd.codeapi.interfaces.ClassDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Continue;
import com.github.jonathanxd.codeapi.interfaces.DoWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.InstanceOf;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.PackageDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.interfaces.StaticBlock;
import com.github.jonathanxd.codeapi.interfaces.Switch;
import com.github.jonathanxd.codeapi.interfaces.TagLine;
import com.github.jonathanxd.codeapi.interfaces.ThrowException;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.interfaces.TryWithResources;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;
import com.github.jonathanxd.codeapi.interfaces.WhileBlock;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.AccessVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.AnnotableVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.AnnotationVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ArgumenterizabeVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ArrayConstructVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ArrayLoadVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.BreakVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.CastedVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ConstructorVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ContinueVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.DoWhileVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.FieldVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ForIVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.IfExprVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.InstanceOfVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.LiteralVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.MethodInvocationVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ReturnVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.StoreVariableVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.ThrowExceptionVisitor;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.TryWithResourcesVisitor;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.type.AbstractTypeInfo;
import com.github.jonathanxd.iutils.type.TypeInfo;
import com.github.jonathanxd.iutils.option.Options;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by jonathan on 03/06/16.
 */
public class BytecodeGenerator extends VisitorGenerator<BytecodeClass> {

    public static final TypeInfo<Function<TypeDeclaration, String>> SOURCE_FILE_FUNCTION =
            new AbstractTypeInfo<Function<TypeDeclaration, String>>(true) {
            };
    private final Options options = new Options();
    private final Function<TypeDeclaration, String> sourceFile;

    public BytecodeGenerator(Function<TypeDeclaration, String> sourceFile) {
        this.sourceFile = sourceFile;

        addVisitor(PackageDeclaration.class, new PackageVisitor());
        addVisitor(TypeDeclaration.class, new TypeVisitor());
        addUncheckedVisitor(ClassDeclaration.class, new TypeVisitor());
        addVisitor(FieldDeclaration.class, new FieldVisitor());
        addVisitor(CodeSource.class, new CodeSourceVisitor());
        addVisitor(ConstructorDeclaration.class, new ConstructorVisitor());
        addVisitor(Literal.class, new LiteralVisitor());
        addVisitor(MethodInvocation.class, new MethodInvocationVisitor());
        addVisitor(VariableAccess.class, new VariableAccessVisitor());
        addVisitor(Argumenterizable.class, new ArgumenterizabeVisitor());
        addVisitor(MethodDeclaration.class, new CodeMethodVisitor());
        addVisitor(Access.class, new AccessVisitor());
        addVisitor(TryBlock.class, new TryBlockVisitor());
        addVisitor(IfBlock.class, new IfBlockVisitor());
        addVisitor(Return.class, new ReturnVisitor());
        addVisitor(VariableDeclaration.class, new StoreVariableVisitor());
        addVisitor(ThrowException.class, new ThrowExceptionVisitor());
        addVisitor(Casted.class, new CastedVisitor());
        addVisitor(VariableOperate.class, new OperateVisitor());
        addVisitor(InstructionCodePart.class, new InstructionCodePart.InstructionCodePartVisitor());
        addVisitor(WhileBlock.class, new WhileVisitor());
        addVisitor(DoWhileBlock.class, new DoWhileVisitor());
        addVisitor(ForBlock.class, new ForIVisitor());
        addVisitor(StaticBlock.class, new StaticBlockVisitor());
        addVisitor(ArrayConstructor.class, new ArrayConstructVisitor());
        addVisitor(ArrayStore.class, new ArrayStoreVisitor());
        addVisitor(ArrayLoad.class, new ArrayLoadVisitor());
        addVisitor(ArrayAccess.class, new ArrayAccessVisitor());
        addVisitor(ArrayLength.class, new ArrayLengthVisitor());
        addVisitor(TagLine.class, new TagLineVisitor());
        addVisitor(ForEachBlock.class, new ForEachVisitor());
        addVisitor(MethodFragment.class, new MethodFragmentVisitor());
        addVisitor(Annotable.class, new AnnotableVisitor());
        addVisitor(Annotation.class, new AnnotationVisitor());
        addVisitor(TryWithResources.class, new TryWithResourcesVisitor());
        addVisitor(InstanceOf.class, new InstanceOfVisitor());
        addVisitor(IfExpr.class, new IfExprVisitor()); /* Sugar Syntax to a IfBlock */
        addVisitor(Break.class, new BreakVisitor());
        addVisitor(Continue.class, new ContinueVisitor());
        addVisitor(Switch.class, new SwitchVisitor());
    }

    public BytecodeGenerator() {
        this(null);
    }

    @Override
    protected MapData makeData() {
        MapData data = new MapData();

        data.registerData(SOURCE_FILE_FUNCTION, sourceFile);

        return data;
    }

    @Override
    public ArrayAppender<BytecodeClass> createAppender() {
        return new ByteAppender();
    }

    @Override
    public Options getOptions() {
        return this.options;
    }

    private static class ByteAppender extends ArrayAppender<BytecodeClass> {

        private final List<BytecodeClass> bytecodeClassList = new ArrayList<>();

        ByteAppender() {

        }

        @Override
        public void add(BytecodeClass[] elem) {
            if(elem == null)
                return;

            for (BytecodeClass bytecodeClass : elem) {
                bytecodeClassList.add(bytecodeClass);
            }

        }

        @Override
        public BytecodeClass[] get() {
            return this.bytecodeClassList.stream().toArray(BytecodeClass[]::new);
        }
    }
}
