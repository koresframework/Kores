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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.ClassDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Implementer;
import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.ClassType;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.arrays.PrimitiveArrayConverter;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.object.TypeInfo;

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
public class TypeVisitor implements Visitor<TypeDeclaration, Byte, Object>, Opcodes {

    public static final TypeVisitor INSTANCE = new TypeVisitor();

    public static final TypeInfo<TypeDeclaration> CODE_TYPE_REPRESENTATION =
            TypeInfo.a(TypeDeclaration.class).setUnique(true).build();

    public static final TypeInfo<ClassWriter> CLASS_WRITER_REPRESENTATION =
            TypeInfo.a(ClassWriter.class).setUnique(true).build();

    @Override
    public Byte[] visit(TypeDeclaration typeDeclaration,
                        MapData extraData,
                        VisitorGenerator<Byte> visitorGenerator,
                        Object additional) {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        String sourceFile = typeDeclaration.getSimpleName() + ".cai"; //CodeAPI Instructions

        Optional<Function<TypeDeclaration, String>> optional = extraData.getOptional(BytecodeGenerator.SOURCE_FILE_FUNCTION);

        if (optional.isPresent()) {
            sourceFile = optional.get().apply(typeDeclaration);
        }

        cw.visitSource(sourceFile, null);

        extraData.registerData(CODE_TYPE_REPRESENTATION, typeDeclaration);
        extraData.registerData(CLASS_WRITER_REPRESENTATION, cw);


        Collection<CodeModifier> interfaceModifiers = new ArrayList<>(typeDeclaration.getModifiers());

        if (typeDeclaration.getClassType() == ClassType.INTERFACE) {
            if (!interfaceModifiers.contains(CodeModifier.ABSTRACT)) {
                interfaceModifiers.add(CodeModifier.ABSTRACT);
            }
        }

        int modifiers = Common.modifierToAsm(interfaceModifiers, typeDeclaration.getClassType() == ClassType.INTERFACE);

        String className = Common.getClassName(typeDeclaration, extraData);

        Collection<CodeType> implementations = Collections.emptyList();

        if (typeDeclaration instanceof Implementer) {
            implementations = ((Implementer) typeDeclaration).getImplementations();
        }

        String[] impls = implementations.stream().map(Common::codeTypeToSimpleAsm).toArray(String[]::new);

        CodeType superClass = Common.getSuperClass(typeDeclaration);

        GenericType[] types = typeDeclaration.getGenericSignature().getTypes();

        String genericRepresentation = null;

        if (types.length > 0) {
            genericRepresentation = Common.genericTypesToAsmString(types);

            genericRepresentation += Common.toAsm(superClass);

            StringBuilder sb = new StringBuilder();

            implementations.forEach(codeType -> sb.append(Common.toAsm(codeType)));

            genericRepresentation += sb.toString();
        }

        cw.visit(52, modifiers, className, genericRepresentation, Common.codeTypeToSimpleAsm(superClass), impls);

        // Visit Annotations
        visitorGenerator.generateTo(Annotable.class, typeDeclaration, extraData, null, null);

        Optional<CodeSource> bodyOpt = typeDeclaration.getBody();
        if (bodyOpt.isPresent()) {
            CodeSource body = bodyOpt.get();

            if (body.size() > 0) {
                visitorGenerator.generateTo(CodeSource.class, body, extraData, null, null);
            }

            boolean constructor = body.stream().filter(c -> c instanceof ConstructorDeclaration).findAny().isPresent();

            if (!constructor && typeDeclaration instanceof ClassDeclaration) { // Interfaces has no super call.
                ConstructorDeclaration codeConstructor = new CodeConstructor(typeDeclaration, Collections.singleton(CodeModifier.PUBLIC), Collections.emptyList(), null);
                visitorGenerator.generateTo(ConstructorDeclaration.class, codeConstructor, extraData, null, null);
            }

        }

        MethodFragmentVisitor.visitFragmentsGeneration(visitorGenerator, extraData);


        StaticBlockVisitor.generate(extraData, visitorGenerator, cw, typeDeclaration);

        cw.visitEnd();

        return PrimitiveArrayConverter.fromPrimitive(cw.toByteArray());
    }

    @Override
    public void endVisit(Byte[] r,
                         TypeDeclaration codeInterface,
                         MapData extraData,
                         VisitorGenerator<Byte> visitorGenerator,
                         Object additional) {
        extraData.unregisterData(CODE_TYPE_REPRESENTATION, codeInterface);

        Optional<ClassWriter> optional = extraData.getOptional(CLASS_WRITER_REPRESENTATION);

        if (optional.isPresent()) {
            extraData.unregisterData(CLASS_WRITER_REPRESENTATION, optional.get());
        }
    }
}
