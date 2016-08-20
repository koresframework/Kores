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
package com.github.jonathanxd.codeapi.read.bytecode.asm;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.helper.SimpleStaticBlock;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.read.bytecode.CommonRead;
import com.github.jonathanxd.codeapi.types.CodeType;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 19/08/16.
 */
public class BytecodeClassVisitor extends ClassVisitor {

    private final CodeSource codeSource;
    private CodeInterface codeInterface;

    public BytecodeClassVisitor(int api, CodeSource codeSource) {
        super(api);
        this.codeSource = codeSource;
    }

    public BytecodeClassVisitor(int api, ClassVisitor cv, CodeSource codeSource) {
        super(api, cv);
        this.codeSource = codeSource;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        Collection<CodeModifier> codeModifiers = CommonRead.modifiersFromAccess(access);

        boolean isInterface = (access & Opcodes.ACC_INTERFACE) != 0;

        CodeType codeType = CommonRead.toCodeType(name, isInterface);

        CodeType superClass = CommonRead.toCodeType(superName, false);

        List<CodeType> interfacesTypes = Arrays.stream(interfaces).map(itfStr -> CommonRead.toCodeType(itfStr, true)).collect(Collectors.toList());
        // TODO: Generics

        if (isInterface) {
            codeInterface = new CodeInterface(codeType.getCanonicalName(), codeModifiers, interfacesTypes, new CodeSource());
        } else {
            codeInterface = new CodeClass(codeType.getCanonicalName(), codeModifiers, superClass, interfacesTypes, new CodeSource());
        }

        codeSource.add(codeInterface);

        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public void visitSource(String source, String debug) {
        super.visitSource(source, debug);
    }

    @Override
    public void visitOuterClass(String owner, String name, String desc) {
        super.visitOuterClass(owner, name, desc);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return super.visitAnnotation(desc, visible);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return super.visitTypeAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public void visitAttribute(Attribute attr) {
        System.out.println(attr);
        super.visitAttribute(attr);
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        super.visitInnerClass(name, outerName, innerName, access);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {

        Collection<CodeModifier> codeModifiers = CommonRead.modifiersFromAccess(access);

        CodeType type = CommonRead.toCodeType(desc, false);

        CodePart valuePart = null;

        if (value != null) {
            valuePart = CommonRead.toLiteral(value);
        }

        CodeField codeField = new CodeField(name, type, valuePart, codeModifiers);


        codeInterface.getBody().orElseThrow(IllegalStateException::new).add(codeField);

        return new BytecodeFieldVisitor(Opcodes.ASM5, codeField);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        Collection<CodeModifier> codeModifiers = CommonRead.modifiersFromAccess(access);

        List<CodeParameter> codeParameters = new ArrayList<>();
        TypeSpec typeSpec = CommonRead.typeSpecFromDesc(codeInterface, name, desc);

        int a = 0;

        for (CodeType type : typeSpec.getParameterSpec()) {
            codeParameters.add(new CodeParameter("param" + (a++), type));
        }

        CodeMethod method;

        if (name.equals("<init>")) {
            method = new CodeConstructor(codeInterface, codeModifiers, codeParameters, new CodeSource());
        } else if (name.equals("<clinit>")) {
            method = new SimpleStaticBlock(new CodeSource());
        } else {
            method = new CodeMethod(name, codeModifiers, codeParameters, typeSpec.getReturnType(), new CodeSource());
        }

        codeInterface.getBody().orElseThrow(IllegalStateException::new).add(method);

        return new BytecodeMethodVisitor(codeInterface, method, Opcodes.ASM5);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }
}
