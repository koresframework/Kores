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
import com.github.jonathanxd.codeapi.helper.TryCatchBlock;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.interfaces.TryWithResources;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jonathan on 03/06/16.
 */
public class TryWithResourcesVisitor implements Visitor<TryWithResources, Byte, MVData>, Opcodes {

    private int TRY_WITH_RESOURCES_VARIABLES = 0;

    private int getAndIncrementTryWithRes() {
        int i = TRY_WITH_RESOURCES_VARIABLES;

        ++TRY_WITH_RESOURCES_VARIABLES;

        return i;
    }

    @Override
    public Byte[] visit(TryWithResources tryWithResources,
                        MapData extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        MVData mvData) {


        VariableDeclaration variable = tryWithResources.getVariable();

        // Generate try-catch initialize field
        visitorGenerator.generateTo(CodeField.class, variable, extraData, navigator, null, mvData);

        int num = this.getAndIncrementTryWithRes();

        String throwableFieldName = "$throwable#" + num;

        // Generate exception field
        CodeField throwableField = new CodeField(
                throwableFieldName,
                PredefinedTypes.THROWABLE,
                Literals.NULL);

        visitorGenerator.generateTo(CodeField.class, throwableField, extraData, navigator, null, mvData);

        // Generate try block
        String catch_ = "$catch#" + num;
        CatchBlock catchBlock = Helper.catchBlock(Collections.singletonList(PredefinedTypes.THROWABLE),
                catch_,
                Helper.sourceOf(
                        Helper.setLocalVariable(throwableFieldName, PredefinedTypes.THROWABLE, Helper.accessLocalVariable(catch_, PredefinedTypes.THROWABLE)),
                        Helper.throwException(Helper.accessLocalVariable(catch_, PredefinedTypes.THROWABLE))));

        String catch2_name = "$catch_2#" + num;

        //AutoCloseable#close();
        MethodInvocation closeInvocation = CodeAPI.invokeInterface(
                AutoCloseable.class,
                Helper.accessLocalVariable(variable),
                "close",
                new TypeSpec(PredefinedTypes.VOID));

        //Throwable#addSuppressed(Throwable)
        MethodInvocation addSuppressedInvocation = CodeAPI.invokeVirtual(PredefinedTypes.THROWABLE,
                Helper.accessLocalVariable(throwableField),
                "addSuppressed",
                new TypeSpec(PredefinedTypes.VOID, PredefinedTypes.THROWABLE),
                CodeAPI.argument(Helper.accessLocalVariable(catch2_name)));

        TryBlock surroundedCloseInvocation = Helper.surround(Helper.sourceOf(closeInvocation),
                Collections.singletonList(
                        Helper.catchBlock(Collections.singletonList(PredefinedTypes.THROWABLE),
                                catch2_name,
                                Helper.sourceOf(
                                        addSuppressedInvocation
                                )
                        )
                )
        );

        List<CatchBlock> catchBlocks = new ArrayList<>();

        catchBlocks.add(catchBlock);
        catchBlocks.addAll(tryWithResources.getCatchBlocks());

        TryBlock tryCatchBlock = Helper.surround(tryWithResources.getRequiredBody(), catchBlocks,
                Helper.sourceOf(
                        Helper.ifExpression(Helper.createIfVal()
                                        .add1(Helper.checkNotNull(Helper.accessLocalVariable(variable)))
                                        .make(),
                                Helper.sourceOf(
                                        Helper.ifExpression(Helper.createIfVal()
                                                        .add1(Helper.checkNotNull(Helper.accessLocalVariable(throwableField))).make(),
                                                Helper.sourceOf(
                                                        surroundedCloseInvocation
                                                ),
                                                Helper.elseExpression(Helper.sourceOf(
                                                        closeInvocation
                                                )))
                                )),
                        tryWithResources.getFinallyBlock().orElse(new CodeSource())
                ));

        visitorGenerator.generateTo(TryCatchBlock.class, tryCatchBlock, extraData, navigator, null, mvData);

        //additional.visitVarInsn(ALOAD, 0);

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r,
                         TryWithResources tryWithResources,
                         MapData extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         MVData mvData) {

    }
}
