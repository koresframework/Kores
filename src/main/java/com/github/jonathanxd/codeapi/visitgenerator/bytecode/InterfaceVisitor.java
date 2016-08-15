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
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.interfaces.ClassDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.InterfaceDeclaration;
import com.github.jonathanxd.codeapi.types.ClassType;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.arrays.PrimitiveArrayConverter;
import com.github.jonathanxd.iutils.iterator.Navigator;
import com.github.jonathanxd.iutils.object.GenericRepresentation;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;

/**
 * Created by jonathan on 03/06/16.
 */
public class InterfaceVisitor implements Visitor<InterfaceDeclaration, Byte, Object>, Opcodes {

    public static final InterfaceVisitor INSTANCE = new InterfaceVisitor();

    public static final GenericRepresentation<InterfaceDeclaration> CODE_INTERFACE_REPRESENTATION =
            GenericRepresentation.a(InterfaceDeclaration.class).setUnique(true).build();

    public static final GenericRepresentation<ClassWriter> CLASS_WRITER_REPRESENTATION =
            GenericRepresentation.a(ClassWriter.class).setUnique(true).build();

    @Override
    public Byte[] visit(InterfaceDeclaration codeInterface,
                        MapData extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        Object additional) {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        String sourceFile = codeInterface.getSimpleName() + ".cai"; //CodeAPI Instructions

        Optional<Function<InterfaceDeclaration, String>> optional = extraData.getOptional(BytecodeGenerator.SOURCE_FILE_FUNCTION);

        if (optional.isPresent()) {
            sourceFile = optional.get().apply(codeInterface);
        }

        cw.visitSource(sourceFile, null);

        extraData.registerData(CODE_INTERFACE_REPRESENTATION, codeInterface);
        extraData.registerData(CLASS_WRITER_REPRESENTATION, cw);


        Collection<CodeModifier> interfaceModifiers = new ArrayList<>(codeInterface.getModifiers());

        if (codeInterface.getClassType() == ClassType.INTERFACE) {
            if (!interfaceModifiers.contains(CodeModifier.ABSTRACT)) {
                interfaceModifiers.add(CodeModifier.ABSTRACT);
            }
        }

        int modifiers = Common.modifierToAsm(interfaceModifiers, codeInterface.getClassType() == ClassType.INTERFACE);

        String className = Common.getClassName(codeInterface, extraData);

        Collection<CodeType> implementations = codeInterface.getImplementations();

        String[] impls = implementations.stream().map(Common::codeTypeToSimpleAsm).toArray(String[]::new);

        CodeType superClass = Common.getSuperClass(codeInterface);

        GenericType[] types = codeInterface.getGenericSignature().getTypes();

        String genericRepresentation = null;

        if (types.length > 0) {
            genericRepresentation = Common.genericTypesToAsmString(types);

            genericRepresentation += Common.toAsm(superClass);

            StringBuilder sb = new StringBuilder();

            implementations.forEach(codeType -> sb.append(Common.toAsm(codeType)));

            genericRepresentation += sb.toString();
        }

        cw.visit(52, modifiers, className, genericRepresentation, Common.codeTypeToSimpleAsm(superClass), impls);

        Optional<CodeSource> bodyOpt = codeInterface.getBody();
        if (bodyOpt.isPresent()) {
            CodeSource body = bodyOpt.get();
            visitorGenerator.generateTo(CodeSource.class, body, extraData, navigator, null, null);

            boolean constructor = body.stream().filter(c -> c instanceof ConstructorDeclaration).findAny().isPresent();

            if (!constructor && codeInterface instanceof ClassDeclaration) { // Interfaces has no super call.
                ConstructorDeclaration codeConstructor = new CodeConstructor(codeInterface, Collections.singleton(CodeModifier.PUBLIC), Collections.emptyList(), null);
                visitorGenerator.generateTo(ConstructorDeclaration.class, codeConstructor, extraData, navigator, null, null);
            }

        }

        StaticBlockVisitor.generate(extraData, navigator, visitorGenerator, cw, codeInterface);

        cw.visitEnd();

        return PrimitiveArrayConverter.fromPrimitive(cw.toByteArray());
    }

    @Override
    public void endVisit(Byte[] r,
                         InterfaceDeclaration codeInterface,
                         MapData extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         Object additional) {
        extraData.unregisterData(CODE_INTERFACE_REPRESENTATION, codeInterface);
        extraData.unregisterAllData(FieldVisitor.FIELDS_TO_ASSIGN);
    }
}
