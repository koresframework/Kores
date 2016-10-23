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
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.util.AnnotationVisitorCapable;
import com.github.jonathanxd.codeapi.util.asm.ParameterVisitor;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.gen.visit.VoidVisitor;
import com.github.jonathanxd.iutils.conditions.Conditions;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class AnnotationVisitor implements VoidVisitor<Annotation, BytecodeClass, Object>, Opcodes {

    @Override
    public void voidVisit(Annotation annotation,
                        MapData extraData,
                        VisitorGenerator<BytecodeClass> visitorGenerator,
                        Object additional) {

        Optional<ClassWriter> classWriterOpt;

        AnnotationVisitorCapable annotationVisitorCapable = null;

        if (additional == null
                && (classWriterOpt = extraData.getOptional(TypeVisitor.CLASS_WRITER_REPRESENTATION)).isPresent()) {

            ClassWriter classWriter = classWriterOpt.orElseThrow(NullPointerException::new);

            annotationVisitorCapable = new AnnotationVisitorCapable.ClassWriterVisitorCapable(classWriter);
        } else if (additional instanceof MVData) {
            MVData mvData = (MVData) additional;

            MethodVisitor methodVisitor = mvData.getMethodVisitor();

            annotationVisitorCapable = new AnnotationVisitorCapable.MethodVisitorCapable(methodVisitor);
        } else if (additional instanceof org.objectweb.asm.FieldVisitor) {
            org.objectweb.asm.FieldVisitor fieldVisitor = (org.objectweb.asm.FieldVisitor) additional;

            annotationVisitorCapable = new AnnotationVisitorCapable.FieldVisitorCapable(fieldVisitor);
        } else if (additional instanceof ParameterVisitor) {
            ParameterVisitor parameterVisitor = (ParameterVisitor) additional;

            annotationVisitorCapable = new AnnotationVisitorCapable.ParameterVisitorCapable(parameterVisitor);
        }

        Conditions.checkNotNull(annotationVisitorCapable, "Cannot determine visitor!", NullPointerException::new);

        Common.visitAnnotation(annotation, annotationVisitorCapable);

    }
}
