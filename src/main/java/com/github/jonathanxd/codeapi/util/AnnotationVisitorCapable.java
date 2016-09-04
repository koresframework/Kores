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
package com.github.jonathanxd.codeapi.util;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.TypePath;

/**
 * Created by jonathan on 03/09/16.
 */
public interface AnnotationVisitorCapable {
    AnnotationVisitor visitAnnotation(String desc, boolean visible);


    AnnotationVisitor visitTypeAnnotation(int typeRef,
                                                 TypePath typePath, String desc, boolean visible);

    AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible);

    class ClassWriterVisitorCapable implements AnnotationVisitorCapable {
        private final ClassWriter classWriter;

        public ClassWriterVisitorCapable(ClassWriter classWriter) {
            this.classWriter = classWriter;
        }

        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            return this.classWriter.visitAnnotation(desc, visible);
        }

        @Override
        public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
            return this.classWriter.visitTypeAnnotation(typeRef, typePath, desc, visible);
        }

        @Override
        public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
            throw new UnsupportedOperationException("Classes doesn't have parameter annotations!");
        }
    }

    class MethodVisitorCapable implements AnnotationVisitorCapable {
        private final MethodVisitor methodVisitor;

        public MethodVisitorCapable(MethodVisitor methodVisitor) {
            this.methodVisitor = methodVisitor;
        }

        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            return this.methodVisitor.visitAnnotation(desc, visible);

        }

        @Override
        public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
            return this.methodVisitor.visitTypeAnnotation(typeRef, typePath, desc, visible);
        }

        @Override
        public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
            return this.methodVisitor.visitParameterAnnotation(parameter, desc, visible);
        }
    }

    class FieldVisitorCapable implements AnnotationVisitorCapable {
        private final FieldVisitor fieldVisitor;

        public FieldVisitorCapable(FieldVisitor fieldVisitor) {
            this.fieldVisitor = fieldVisitor;
        }

        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            return this.fieldVisitor.visitAnnotation(desc, visible);

        }

        @Override
        public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
            return this.fieldVisitor.visitTypeAnnotation(typeRef, typePath, desc, visible);
        }

        @Override
        public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
            throw new UnsupportedOperationException("Fields doesn't have parameter annotations!");
        }
    }
}
