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
package com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.gen.visit.VoidVisitor;
import com.github.jonathanxd.codeapi.interfaces.Argumenterizable;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.optional.Require;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

/**
 * Created by jonathan on 03/06/16.
 */
public class ArgumenterizabeVisitor implements VoidVisitor<Argumenterizable, BytecodeClass, MVData>, Opcodes {

    @Override
    public void voidVisit(Argumenterizable argumenterizable,
                          MapData extraData,
                          VisitorGenerator<BytecodeClass> visitorGenerator,
                          MVData mvData) {

        MethodVisitor additional = mvData.getMethodVisitor();

        List<CodeArgument> arguments = argumenterizable.getArguments();

        if (!argumenterizable.isArray()) {

            for (CodeArgument argument : arguments) {
                CodePart value = Require.require(argument.getValue());

                visitorGenerator.generateTo(value.getClass(), value, extraData, null, mvData);

                if (argument.isCasted()) {
                    additional.visitTypeInsn(CHECKCAST, Common.codeTypeToSimpleAsm(Require.require(argument.getType())));
                }
            }
        } else {
            for (int i = 0; i < arguments.size(); i++) {

                Common.runForInt(i, additional); // Visit index

                CodeArgument argument = arguments.get(i);

                CodePart value = Require.require(argument.getValue());

                visitorGenerator.generateTo(value.getClass(), value, extraData, null, mvData);

                if (argument.isCasted()) {
                    additional.visitTypeInsn(CHECKCAST, Common.codeTypeToSimpleAsm(Require.require(argument.getType())));
                }
            }
        }
    }

}
