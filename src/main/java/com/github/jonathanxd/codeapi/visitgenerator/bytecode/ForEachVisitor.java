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
package com.github.jonathanxd.codeapi.visitgenerator.bytecode;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.interfaces.Expression;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.VariableStore;
import com.github.jonathanxd.codeapi.interfaces.WhileBlock;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.BiMultiVal;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.Opcodes;

import java.util.Iterator;
import java.util.List;

/**
 * Created by jonathan on 03/06/16.
 */
public class ForEachVisitor implements Visitor<ForEachBlock, Byte, MVData>, Opcodes {

    public static final ForEachVisitor INSTANCE = new ForEachVisitor();

    private int iterFields = 0;

    @Override
    public Byte[] visit(ForEachBlock forEachBlock, Data extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, MVData additional) {

        CodeField field = forEachBlock.getField();

        Expression iterableElement = forEachBlock.getIterableElement();

        String fieldName = "iter$"+(++iterFields);

        final CodeType iterType = Helper.getJavaType(Iterator.class);

        CodeField iterableField =
                new HiddenField(fieldName, iterType,
                        CodeAPI.invokeInterface(Iterable.class, iterableElement, "iterator",
                        new TypeSpec(Helper.getJavaType(Iterator.class))));

        visitorGenerator.generateTo(CodeField.class, iterableField, extraData, navigator, null, additional);

        // Iterator.hasNext()Z
        MethodInvocation hasNext = CodeAPI.invokeInterface(Iterator.class,
                CodeAPI.accessLocalVariable(iterType, fieldName), "hasNext", new TypeSpec(PredefinedTypes.BOOLEAN));

        // Iterator.next()Ljava/lang/Object;
        MethodInvocation next = CodeAPI.invokeInterface(Iterator.class,
                CodeAPI.accessLocalVariable(iterType, fieldName), "next", new TypeSpec(PredefinedTypes.OBJECT));


        // #Type Field_Name = (#Type) Iterator.next()Ljava/lang/Object;
        CodeField forEachField = new CodeField(field.getName(), field.getVariableType(),
                Helper.cast(PredefinedTypes.OBJECT, field.getVariableType(), next));


        CodeSource codeSource = new CodeSource();

        codeSource.add(forEachField);

        forEachBlock.getBody().ifPresent(codeSource::addAll);

        WhileBlock aWhile = Helper.createWhile(BiMultiVal.create(CodePart.class, IfExpr.class, Operator.class).
                add1(Helper.check(hasNext, Operators.EQUAL_TO, Literals.TRUE)).make(), codeSource);

        visitorGenerator.generateTo(aWhile.getClass(), aWhile, extraData, navigator, null, additional);

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r, ForEachBlock forEachBlock, Data extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, MVData additional) {

    }
}
