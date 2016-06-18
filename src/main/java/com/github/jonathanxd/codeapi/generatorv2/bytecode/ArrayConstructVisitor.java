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
package com.github.jonathanxd.codeapi.generatorv2.bytecode;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.exceptions.TODOException;
import com.github.jonathanxd.codeapi.generatorv2.Visitor;
import com.github.jonathanxd.codeapi.generatorv2.VisitorGenerator;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.util.MVData;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class ArrayConstructVisitor implements Visitor<ArrayConstructor, Byte, MVData>, Opcodes {

    public static final ArrayConstructVisitor INSTANCE = new ArrayConstructVisitor();

    @Override
    public Byte[] visit(ArrayConstructor arrayConstructor, Data extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, MVData mvData) {

        MethodVisitor mv = mvData.getMethodVisitor();

        CodeInterface codeInterface = extraData.getRequired(InterfaceVisitor.CODE_INTERFACE_REPRESENTATION);

        List<CodeArgument> arguments = arrayConstructor.getArguments();

        boolean initialize = !arguments.isEmpty();
        int[] dimensions = arrayConstructor.getDimensions();
        boolean multi = dimensions.length > 1;

        for (int i : dimensions) {
            Common.runForInt(i, mv); // visitInsn, visitInt...
        }

        if(multi && !initialize) {
            throw new TODOException("Multi-dimensional arrays not implemented yet!");
            //mv.visitMultiANewArrayInsn(Common.codeTypeToArray(arrayConstructor.getArrayType(), dimensions.length), dimensions.length);
        } else {
            mv.visitTypeInsn(ANEWARRAY, Common.codeTypeToSimpleAsm(arrayConstructor.getArrayType()));
        }

        if(initialize) {
            // Initialize

            for (ArrayStore arrayStore : arrayConstructor.getArrayValues()) {
                mv.visitInsn(DUP);
                visitorGenerator.generateTo(ArrayStore.class, arrayStore, extraData, navigator, null, mvData);
            }


        }

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r, ArrayConstructor arrayConstructor, Data extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, MVData mvData) {

    }




}
