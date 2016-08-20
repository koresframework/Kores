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
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.InterfaceDeclaration;
import com.github.jonathanxd.codeapi.interfaces.StaticBlock;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.iterator.Navigator;
import com.github.jonathanxd.iutils.object.TypeInfo;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class StaticBlockVisitor implements Visitor<StaticBlock, Byte, Object>, Opcodes {

    public static final StaticBlockVisitor INSTANCE = new StaticBlockVisitor();

    public static final TypeInfo<StaticBlock> STATIC_BLOCKS =
            TypeInfo.a(StaticBlock.class).setUnique(true).build();

    public static void generate(MapData extraData, Navigator<CodePart> navigator, VisitorGenerator<?> visitorGenerator, ClassWriter cw, InterfaceDeclaration codeInterface) {

        MethodVisitor mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);

        MVData mvData = new MVData(mv, new ArrayList<>());

        mv.visitCode();

        // Variable Initialize

        Collection<FieldDeclaration> all = extraData.getAll(FieldVisitor.STATIC_FIELDS_TO_ASSIGN);

        for (FieldDeclaration codeField : all) {

            Optional<CodePart> valueOpt = codeField.getValue();

            if (valueOpt.isPresent()) {

                CodePart value = valueOpt.get();

                Label labeln = new Label();

                mv.visitLabel(labeln);

                visitorGenerator.generateTo(value.getClass(), value, extraData, navigator, null, mvData);

                mv.visitFieldInsn(PUTSTATIC, Common.codeTypeToSimpleAsm(codeInterface), codeField.getName(), Common.codeTypeToFullAsm(codeField.getType().get()));
            }
        }


        // Static Blocks

        Collection<StaticBlock> staticBlocks = extraData.getAll(STATIC_BLOCKS);

        for (StaticBlock staticBlock : staticBlocks) {
            staticBlock.getBody().ifPresent(codeSource -> visitorGenerator.generateTo(CodeSource.class, codeSource, extraData, navigator, null, mvData));
        }


        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    @Override
    public Byte[] visit(StaticBlock staticBlock, MapData extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, Object additional) {

        extraData.registerData(STATIC_BLOCKS, staticBlock);

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r, StaticBlock staticBlock, MapData extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, Object additional) {

    }

}
