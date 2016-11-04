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

import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.gen.visit.VoidVisitor;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.AnnotationProperty;
import com.github.jonathanxd.codeapi.util.gen.AnnotationUtil;
import com.github.jonathanxd.codeapi.util.gen.CodeTypeUtil;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.Optional;

public class AnnotationPropertyVisitor implements VoidVisitor<AnnotationProperty, BytecodeClass, Object>, Opcodes {
    @Override
    public void voidVisit(AnnotationProperty property, MapData extraData, VisitorGenerator<BytecodeClass> visitorGenerator, Object additional) {

        ClassWriter cw = Util.find(TypeVisitor.CLASS_WRITER_REPRESENTATION, extraData, additional);

        int asmModifiers = Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT;

        String type = CodeTypeUtil.codeTypeToFullAsm(property.getType().orElseThrow(NullPointerException::new));

        String name = property.getName();

        org.objectweb.asm.MethodVisitor mv = cw.visitMethod(asmModifiers, name, "()" + type, null, null);

        Optional<Object> valueOpt = property.getValue();

        if (valueOpt.isPresent()) {
            Object value = valueOpt.get();

            org.objectweb.asm.AnnotationVisitor annotationVisitor = mv.visitAnnotationDefault();

            AnnotationUtil.visitAnnotationValue(annotationVisitor, null, value);

            annotationVisitor.visitEnd();
        }

        MVData mvData = new MVData(mv, new ArrayList<>());

        visitorGenerator.generateTo(Annotable.class, property, extraData, null, mvData);

        mv.visitEnd();
    }
}
