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
package com.github.jonathanxd.codeapi.visitgenerator;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.interfaces.Access;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.Argumenterizable;
import com.github.jonathanxd.codeapi.interfaces.ArrayAccess;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.ArrayLength;
import com.github.jonathanxd.codeapi.interfaces.ArrayLoad;
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.interfaces.Casted;
import com.github.jonathanxd.codeapi.interfaces.ClassDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.DoWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.Expression;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.PackageDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Return;
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
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.AccessVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.AnnotableVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.AnnotationVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ArgumenterizabeVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ArrayAccessVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ArrayConstructVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ArrayLengthVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ArrayLoadVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ArrayStoreVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.CastedVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.CodeMethodVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.CodeSourceVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ConstructorVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.DoWhileVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ExpressionVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.FieldVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ForEachVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ForIVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.IfBlockVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.InstructionCodePart;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.LiteralVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.MethodFragmentVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.MethodInvocationVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.OperateVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.PackageVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ReturnVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.StaticBlockVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.StoreVariableVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.TagLineVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.ThrowExceptionVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.TryBlockVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.TryWithResourcesVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.TypeVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.VariableAccessVisitor;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.WhileVisitor;
import com.github.jonathanxd.iutils.arrays.JwArray;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.object.AbstractTypeInfo;
import com.github.jonathanxd.iutils.object.TypeInfo;
import com.github.jonathanxd.iutils.option.Options;

import java.util.function.Function;

/**
 * Created by jonathan on 03/06/16.
 */
public class BytecodeGenerator extends VisitorGenerator<Byte> {

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
        addVisitor(Expression.class, new ExpressionVisitor());
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
    public Appender<Byte> createAppender() {
        return new ByteAppender();
    }

    @Override
    public Options getOptions() {
        return this.options;
    }

    private static class ByteAppender extends Appender<Byte> {

        JwArray<Byte> byteArrays = new JwArray<>();

        ByteAppender() {

        }

        @Override
        public void add(Byte elem) {
            byteArrays.add(elem);
        }

        @Override
        public Byte[] get() {
            return byteArrays.toGenericArray(Byte[].class);
        }
    }
}
