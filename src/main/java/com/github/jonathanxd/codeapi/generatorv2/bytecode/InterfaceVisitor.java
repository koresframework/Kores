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
import com.github.jonathanxd.codeapi.generatorv2.Visitor;
import com.github.jonathanxd.codeapi.generatorv2.VisitorGenerator;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.CodeModifier;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.iutils.arrays.Arrays;
import com.github.jonathanxd.iutils.iterator.Navigator;
import com.github.jonathanxd.iutils.object.GenericRepresentation;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.Collections;
import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class InterfaceVisitor implements Visitor<CodeInterface<?>, Byte, Object>, Opcodes {

    public static final InterfaceVisitor INSTANCE = new InterfaceVisitor();

    public static final GenericRepresentation<CodeInterface> CODE_INTERFACE_REPRESENTATION = GenericRepresentation.aEnd(CodeInterface.class);

    public static final GenericRepresentation<ClassWriter> CLASS_WRITER_REPRESENTATION = GenericRepresentation.aEnd(ClassWriter.class);

    @Override
    public Byte[] visit(CodeInterface<?> codeInterface,
                        Data extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        Object additional) {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        extraData.registerData(CODE_INTERFACE_REPRESENTATION, codeInterface);
        extraData.registerData(CLASS_WRITER_REPRESENTATION, cw);


        int modifiers = Common.modifierToAsm(codeInterface);


        String className = Common.getClassName(codeInterface, extraData);

        String[] impls = codeInterface.getImplementations().stream().map(Common::codeTypeToSimpleAsm).toArray(String[]::new);

        CodeType superClass = Common.getSuperClass(codeInterface);


        cw.visit(52, modifiers, className, null, Common.codeTypeToSimpleAsm(superClass), impls);

        Optional<CodeSource> bodyOpt = codeInterface.getBody();
        if(bodyOpt.isPresent()) {
            CodeSource body = bodyOpt.get();
            visitorGenerator.generateTo(CodeSource.class, body, extraData, navigator, null, null);

            boolean constructor = body.stream().filter(c -> c instanceof CodeConstructor).findAny().isPresent();

            if(!constructor) {
                CodeConstructor codeConstructor = new CodeConstructor(codeInterface, Collections.singleton(CodeModifier.PUBLIC), Collections.emptyList(), null);
                visitorGenerator.generateTo(CodeConstructor.class, codeConstructor, extraData, navigator, null, null);
            }
        }



        cw.visitEnd();

        return Arrays.PrimitiveArray.fromPrimitive(cw.toByteArray());
    }

    @Override
    public void endVisit(Byte[] r,
                         CodeInterface<?> codeInterface,
                         Data extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         Object additional) {
        extraData.unregisterData(CODE_INTERFACE_REPRESENTATION, codeInterface);
    }
}
