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

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.InnerType;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Implementer;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.ClassType;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.object.Pair;
import com.github.jonathanxd.iutils.type.TypeInfo;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class TypeVisitor implements Visitor<TypeDeclaration, BytecodeClass, Object>, Opcodes {

    public static final TypeVisitor INSTANCE = new TypeVisitor();

    public static final TypeInfo<TypeDeclaration> CODE_TYPE_REPRESENTATION =
            TypeInfo.a(TypeDeclaration.class).setUnique(true).build();

    public static final TypeInfo<ClassWriter> CLASS_WRITER_REPRESENTATION =
            TypeInfo.a(ClassWriter.class).setUnique(true).build();

    public static final TypeInfo<TypeDeclaration> OUTER_TYPE_REPRESENTATION =
            TypeInfo.aUnique(TypeDeclaration.class);

    public static final TypeInfo<InnerType> INNER_TYPE_REPRESENTATION =
            TypeInfo.aUnique(InnerType.class);

    public static final TypeInfo<FieldDeclaration> OUTER_FIELD_REPRESENTATION =
            TypeInfo.aUnique(FieldDeclaration.class);

    @Override
    public BytecodeClass[] visit(TypeDeclaration typeDeclaration,
                                 MapData extraData,
                                 VisitorGenerator<BytecodeClass> visitorGenerator,
                                 Object additional) {

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

        String sourceFile = extraData
                .getOptional(BytecodeGenerator.SOURCE_FILE_FUNCTION)
                .map(func -> func.apply(typeDeclaration))
                .orElse(typeDeclaration.getSimpleName() + ".cai");//CodeAPI Instructions

        cw.visitSource(sourceFile, null);

        extraData.registerData(CODE_TYPE_REPRESENTATION, typeDeclaration);
        extraData.registerData(CLASS_WRITER_REPRESENTATION, cw);

        Collection<CodeType> implementations = typeDeclaration instanceof Implementer
                ? ((Implementer) typeDeclaration).getImplementations()
                : Collections.emptyList();

        // ASM Class name
        String className = Common.getClassName(typeDeclaration, extraData);
        // ASM Class modifiers
        int modifiers = Common.modifierToAsm(typeDeclaration);
        // ASM Super Class implementation
        CodeType superClass = Common.getSuperClass(typeDeclaration);
        // ASM Implementations
        String[] asmImplementations = implementations.stream().map(Common::codeTypeToSimpleAsm).toArray(String[]::new);

        boolean superClassIsGeneric = superClass instanceof GenericType;
        boolean anyInterfaceIsGeneric = implementations.stream().anyMatch(codeType -> codeType instanceof GenericType);

        // Generic Types
        String genericRepresentation = Common.genericTypesToAsmString(typeDeclaration, superClass, implementations, superClassIsGeneric, anyInterfaceIsGeneric);
        ;

        // Visit class
        cw.visit(52, modifiers, className, genericRepresentation, Common.codeTypeToSimpleAsm(superClass), asmImplementations);

        // Visit Annotations
        visitorGenerator.generateTo(Annotable.class, typeDeclaration, extraData, null, null);

        Optional<CodeSource> bodyOpt = typeDeclaration.getBody();

        Pair<List<TypeDeclaration>, MutableCodeSource> pair = Util.grabAndRemoveInnerDecl(bodyOpt.orElse(null));

        List<TypeDeclaration> typeDeclarationList = Collections.emptyList();

        if (bodyOpt.isPresent()) {

            typeDeclarationList = pair._1();

            List<TypeDeclaration> originalDeclList = new ArrayList<>(typeDeclarationList);

            typeDeclarationList = Util.visitInner(cw, typeDeclaration, typeDeclarationList);

            typeDeclarationList = Util.fixNames(typeDeclarationList, typeDeclaration);

            for (int i = 0; i < originalDeclList.size(); i++) {
                // Register inner types.
                extraData.registerData(INNER_TYPE_REPRESENTATION, new InnerType(originalDeclList.get(i), typeDeclarationList.get(i)));
            }

            MutableCodeSource body = pair._2();

            // Create outer fields

            List<TypeDeclaration> allAsList = extraData.getAllAsList(OUTER_TYPE_REPRESENTATION);

            if (!allAsList.isEmpty()) {

                for (TypeDeclaration declaration : allAsList) {

                    if(declaration.getModifiers().contains(CodeModifier.STATIC))
                        continue;

                    String simpleName = declaration.getSimpleName();

                    String name = Character.toLowerCase(simpleName.charAt(0))+(simpleName.length() > 1 ? simpleName.substring(1) : "");

                    String newName = Common.getNewName(name + "$outer", body);

                    CodeField field = CodeAPI.field(Modifier.PRIVATE | Modifier.FINAL, declaration, newName);

                    extraData.registerData(OUTER_FIELD_REPRESENTATION, field);

                    body.add(0, field);
                }

            }


            // /Create outer fields

            if (body.size() > 0) {
                visitorGenerator.generateTo(CodeSource.class, body, extraData, null, null);
            }

            boolean constructor = body.stream().filter(c -> c instanceof ConstructorDeclaration).findAny().isPresent();

            if (!constructor && typeDeclaration.getClassType() == ClassType.CLASS) { // Interfaces has no super call.
                ConstructorDeclaration codeConstructor = new CodeConstructor(typeDeclaration, Collections.singleton(CodeModifier.PUBLIC), Collections.emptyList(), null);
                visitorGenerator.generateTo(ConstructorDeclaration.class, codeConstructor, extraData, null, null);
            }

            if (!allAsList.isEmpty()) {
            }
        }

        MethodFragmentVisitor.visitFragmentsGeneration(visitorGenerator, extraData);

        StaticBlockVisitor.generate(extraData, visitorGenerator, cw, typeDeclaration);

        List<BytecodeClass> bytecodeClassList = new ArrayList<>();
        bytecodeClassList.add(new BytecodeClass(typeDeclaration, cw.toByteArray(), (MapData) extraData.clone()));

        if (pair != null) {
            // Visit inner classes

            MapData data0 = new MapData();

            extraData.getAllAsList(OUTER_TYPE_REPRESENTATION)
                    .forEach(typeDcl -> data0.registerData(OUTER_TYPE_REPRESENTATION, typeDcl));

            data0.registerData(OUTER_TYPE_REPRESENTATION, typeDeclaration);

            for (TypeDeclaration declaration : typeDeclarationList) {
                MapData data = (MapData) data0.clone();

                BytecodeClass[] gen = visitorGenerator.gen(declaration, data, null);

                Collections.addAll(bytecodeClassList, gen);
            }
        }

        cw.visitEnd();

        return bytecodeClassList.stream().toArray(BytecodeClass[]::new);
    }

    @Override
    public void endVisit(BytecodeClass[] r,
                         TypeDeclaration codeInterface,
                         MapData extraData,
                         VisitorGenerator<BytecodeClass> visitorGenerator,
                         Object additional) {
        extraData.unregisterData(CODE_TYPE_REPRESENTATION, codeInterface);

        Optional<ClassWriter> optional = extraData.getOptional(CLASS_WRITER_REPRESENTATION);

        if (optional.isPresent()) {
            extraData.unregisterData(CLASS_WRITER_REPRESENTATION, optional.get());
        }

        extraData.unregisterData(OUTER_TYPE_REPRESENTATION, codeInterface);
        extraData.unregisterAllData(OUTER_FIELD_REPRESENTATION);
        extraData.unregisterAllData(INNER_TYPE_REPRESENTATION);
    }
}
