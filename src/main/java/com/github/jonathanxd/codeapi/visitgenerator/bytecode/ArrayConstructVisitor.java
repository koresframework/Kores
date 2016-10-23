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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.codeapi.visitgenerator.VoidVisitor;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.List;

/**
 * Created by jonathan on 03/06/16.
 */
public class ArrayConstructVisitor implements VoidVisitor<ArrayConstructor, BytecodeClass, MVData>, Opcodes {

    public static final ArrayConstructVisitor INSTANCE = new ArrayConstructVisitor();

    @Override
    public void voidVisit(ArrayConstructor arrayConstructor, MapData extraData, VisitorGenerator<BytecodeClass> visitorGenerator, MVData mvData) {

        MethodVisitor mv = mvData.getMethodVisitor();

        List<CodeArgument> arguments = arrayConstructor.getArguments();

        boolean initialize = !arguments.isEmpty();
        CodePart[] dimensions = arrayConstructor.getDimensions();
        boolean multi = dimensions.length > 1;


        if (multi && !initialize) {
            for (CodePart i : dimensions) {
                visitorGenerator.generateTo(i.getClass(), i, extraData, null, mvData);
            }
            //throw new TODOException("Multi-dimensional arrays not implemented yet!");
            mv.visitMultiANewArrayInsn(Common.codeTypeToArray(arrayConstructor.getArrayType(), dimensions.length), dimensions.length);
        } else {
            CodePart dimensionX = dimensions.length != 0 ? dimensions[0] : Literals.INT(0);

            visitorGenerator.generateTo(dimensionX.getClass(), dimensionX, extraData, null, mvData);

            //Common.codeTypeToSimpleAsm(arrayConstructor.getArrayType()

            Common.runForArrayStore(arrayConstructor.getArrayType(), dimensions.length, mv); // ANEWARRAY, ANEWARRAY T_INT, etc...

            //mv.visitTypeInsn(ANEWARRAY, Common.codeTypeToSimpleArray(arrayConstructor.getArrayType(), dimensions.length));
        }

        if (initialize) {
            // Initialize

            for (ArrayStore arrayStore : arrayConstructor.getArrayValues()) {
                mv.visitInsn(DUP);
                visitorGenerator.generateTo(ArrayStore.class, arrayStore, extraData, null, mvData);
            }


        }
    }

}
