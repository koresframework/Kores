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

import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * Created by jonathan on 03/06/16.
 */
public class FieldVisitor implements Visitor<FieldDeclaration, BytecodeClass, Object>, Opcodes {

    public static final FieldVisitor INSTANCE = new FieldVisitor();

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public BytecodeClass[] visit(FieldDeclaration codeField,
                        MapData extraData,
                        VisitorGenerator<BytecodeClass> visitorGenerator,
                        Object additional) {

        if (additional == null) {

            if (codeField.getValue().isPresent()) { // Only initialize for fields with default value.
                // This fields will be inspected.
            }
        } else {
            if (additional instanceof MVData) {

                visitorGenerator.generateTo(VariableDeclaration.class, codeField, extraData, null, additional);

                return new BytecodeClass[0];
            } else {
                //throw new RuntimeException("Cannot handle additional: " + additional.getClass().getCanonicalName());
            }
        }

        int asm = Common.modifierToAsm(codeField.getModifiers());

        ClassWriter required = Util.find(TypeVisitor.CLASS_WRITER_REPRESENTATION, extraData, additional);/*extraData.getRequired(TypeVisitor.CLASS_WRITER_REPRESENTATION);*/

        String signature = null;

        CodeType type = codeField.getType().orElseThrow(NullPointerException::new);

        if (type instanceof GenericType) {
            signature = Common.toAsm(type);
        }

        org.objectweb.asm.FieldVisitor fieldVisitor = required.visitField(asm, codeField.getName(), Common.codeTypeToFullAsm(type), signature, null);

        visitorGenerator.generateTo(Annotable.class, codeField, extraData, null, fieldVisitor);

        return new BytecodeClass[0];
    }
}
