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
package com.github.jonathanxd.codeapi.util.gen;

import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.EnumValue;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.AnnotationVisitorCapable;
import com.github.jonathanxd.codeapi.util.ArrayUtility;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Type;

import java.util.Arrays;
import java.util.Map;

public class AnnotationUtil {
    public static void visitAnnotation(Annotation annotation, AnnotationVisitorCapable annotationVisitorCapable) {
        String annotationTypeAsm = CodeTypeUtil.codeTypeToFullAsm(annotation.getType().orElseThrow(NullPointerException::new));
        org.objectweb.asm.AnnotationVisitor annotationVisitor = annotationVisitorCapable.visitAnnotation(annotationTypeAsm, annotation.isVisible());

        Map<String, Object> values = annotation.getValues();

        for (Map.Entry<String, Object> stringObjectEntry : values.entrySet()) {
            AnnotationUtil.visitAnnotationValue(annotationVisitor, stringObjectEntry.getKey(), stringObjectEntry.getValue());
        }

        annotationVisitor.visitEnd();
    }

    public static void visitAnnotationValue(org.objectweb.asm.AnnotationVisitor annotationVisitor, String key, Object value) {

        if (value.getClass().isArray()) {
            Object[] values = ArrayUtility.toObjectArray(value);

            AnnotationVisitor annotationVisitor1 = annotationVisitor.visitArray(key);

            for (Object o : values) {
                AnnotationUtil.visitAnnotationValue(annotationVisitor1, "", o);
            }

            annotationVisitor1.visitEnd();

            return;
        }

        if (value instanceof EnumValue) {
            EnumValue enumValue = (EnumValue) value;
            annotationVisitor.visitEnum(enumValue.getName(), CodeTypeUtil.codeTypeToFullAsm(enumValue.getEnumType()), enumValue.getEnumValue());

            return;
        }

        if (value instanceof Annotation) {
            Annotation annotation = (Annotation) value;
            String asmType = CodeTypeUtil.codeTypeToFullAsm(annotation.getType().orElseThrow(NullPointerException::new));

            AnnotationVisitor visitor2 = annotationVisitor.visitAnnotation(key, asmType);

            for (Map.Entry<String, Object> stringObjectEntry : annotation.getValues().entrySet()) {
                AnnotationUtil.visitAnnotationValue(visitor2, stringObjectEntry.getKey(), stringObjectEntry.getValue());
            }

            visitor2.visitEnd();
        }

        if (value instanceof CodeType) {
            value = Type.getType(CodeTypeUtil.codeTypeToFullAsm(((CodeType) value)));
        }

        annotationVisitor.visit(key, value);
    }
}
