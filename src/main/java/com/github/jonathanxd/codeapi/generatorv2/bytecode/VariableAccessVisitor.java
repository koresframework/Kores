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
import com.github.jonathanxd.codeapi.generatorv2.Visitor;
import com.github.jonathanxd.codeapi.generatorv2.VisitorGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.interfaces.LocalizedAt;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.iutils.iterator.Navigator;
import com.github.jonathanxd.iutils.object.GenericRepresentation;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by jonathan on 03/06/16.
 */
public class VariableAccessVisitor implements Visitor<VariableAccess<?>, Byte, MethodVisitor>, Opcodes {

    public static final VariableAccessVisitor INSTANCE = new VariableAccessVisitor();

    public static final GenericRepresentation<CodeField> FIELDS_TO_ASSIGN = GenericRepresentation.aEnd(CodeField.class);

    @Override
    public Byte[] visit(VariableAccess<?> variableAccess,
                        Data extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        MethodVisitor additional) {


        CodeInterface codeInterface = extraData.getRequired(InterfaceVisitor.CODE_INTERFACE_REPRESENTATION);
        ClassWriter required = extraData.getRequired(InterfaceVisitor.CLASS_WRITER_REPRESENTATION);

        Label l0 = new Label();
        additional.visitLabel(l0);
        if(variableAccess.getLocalization() == codeInterface) {

        }

        CodePart localization = variableAccess.getLocalization();

        final CodeType loc;

        if(localization instanceof CodeType) {
            loc = (CodeType) localization;
        }else if(localization instanceof LocalizedAt<?>) {
            loc = ((LocalizedAt<?>) localization).getType().orElseThrow(() -> new IllegalStateException("Cannot get localization of variable"));
        } else {
            throw new IllegalStateException("Cannot get localization of variable");
        }

        additional.visitVarInsn(ALOAD, 0);
        additional.visitFieldInsn(GETFIELD, Common.codeTypeToSimpleAsm(loc), variableAccess.getName(), Common.codeTypeToFullAsm(variableAccess.getVariableType()));

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r,
                         VariableAccess<?> variableAccess,
                         Data extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         MethodVisitor additional) {

    }
}
