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
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.VariableStore;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.iutils.containers.ImmutableContainer;
import com.github.jonathanxd.iutils.iterator.Navigator;
import com.github.jonathanxd.iutils.object.GenericRepresentation;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class FieldVisitor implements Visitor<CodeField, Byte, Object>, Opcodes {

    public static final FieldVisitor INSTANCE = new FieldVisitor();

    public static final ImmutableContainer<GenericRepresentation<CodeField>> FIELDS_TO_ASSIGN = ImmutableContainer.of(GenericRepresentation.aEnd(CodeField.class));
    public static final ImmutableContainer<GenericRepresentation<CodeField>> STATIC_FIELDS_TO_ASSIGN = ImmutableContainer.of(GenericRepresentation.aEnd(CodeField.class));

    @Override
    public Byte[] visit(CodeField codeField,
                        Data extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        Object additional) {

        if (additional == null) {

            if (codeField.getValue().isPresent()) { // Only initialize for fields with default value.

                if (codeField.getModifiers().contains(CodeModifier.STATIC)) {
                    // STATIC FIELDS INITIALIZES
                    extraData.registerData(STATIC_FIELDS_TO_ASSIGN, codeField);
                } else {
                    extraData.registerData(FIELDS_TO_ASSIGN, codeField);
                }
            }
        } else {
            if (additional instanceof MVData) {

                visitorGenerator.generateTo(VariableStore.class, codeField, extraData, navigator, null, additional);

                return new Byte[0];
            } else {
                throw new RuntimeException("Cannot handle additional: " + additional.getClass().getCanonicalName());
            }
        }

        int asm = Common.modifierToAsm(codeField.getModifiers());

        ClassWriter required = extraData.getRequired(InterfaceVisitor.CLASS_WRITER_REPRESENTATION);

        String signature = null;

        CodeType type = codeField.getType().orElseThrow(NullPointerException::new);

        if(type instanceof GenericType) {
            signature = Common.toAsm(type);
        }

        required.visitField(asm, codeField.getName(), Common.codeTypeToFullAsm(type), signature, null).visitEnd();

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r,
                         CodeField codeField,
                         Data extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         Object additional) {
    }
}
