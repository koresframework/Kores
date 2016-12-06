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

import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.read.bytecode.CommonRead;

import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ModifierUtil {

    public static int CLASS = 0;
    public static int FIELD = 1;
    public static int METHOD = 2;
    public static int PARAMETER = 3;

    public static int modifiersToAsm(TypeDeclaration typeDeclaration) {
        Collection<CodeModifier> modifiers = new ArrayList<>(typeDeclaration.getModifiers());

        if (modifiers.contains(CodeModifier.STATIC))
            modifiers.remove(CodeModifier.STATIC);

        return (!typeDeclaration.isInterface() ? Opcodes.ACC_SUPER : 0) +
                ModifierUtil.modifiersToAsm(modifiers, typeDeclaration.getClassType().isInterface());
    }

    public static int modifiersToAsm(Collection<CodeModifier> codeModifiers) {
        return CodeModifier.toAsmAccess(codeModifiers);
    }

    public static int modifiersToAsm(Collection<CodeModifier> codeModifiers, boolean isInterface) {
        return (isInterface ? Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE : 0) + CodeModifier.toAsmAccess(codeModifiers);
    }

    public static int innerModifiersToAsm(TypeDeclaration typeDeclaration) {
        return (!typeDeclaration.isInterface() ? Opcodes.ACC_SUPER : 0) +
                ModifierUtil.modifiersToAsm(typeDeclaration.getModifiers(), typeDeclaration.getClassType().isInterface());
    }


    public static Collection<CodeModifier> fromAccess(int elementType, int access) {
        Set<CodeModifier> modifiers = new HashSet<>();

        if(elementType == CLASS || elementType == FIELD || elementType == METHOD) {

            if (CommonRead.is(access, Opcodes.ACC_PUBLIC)) {
                modifiers.add(CodeModifier.PUBLIC);
            } else if (CommonRead.is(access, Opcodes.ACC_PRIVATE)) {
                modifiers.add(CodeModifier.PRIVATE);
            } else if (CommonRead.is(access, Opcodes.ACC_PROTECTED)) {
                modifiers.add(CodeModifier.PROTECTED);
            } else {
                modifiers.add(CodeModifier.PACKAGE_PRIVATE);
            }

        }

        if(elementType == FIELD) {
            if (CommonRead.is(access, Opcodes.ACC_VOLATILE)) {
                modifiers.add(CodeModifier.VOLATILE);
            }

            if (CommonRead.is(access, Opcodes.ACC_TRANSIENT)) {
                modifiers.add(CodeModifier.TRANSIENT);
            }

        }

        if(elementType == METHOD) {
            if (CommonRead.is(access, Opcodes.ACC_SYNCHRONIZED)) {
                modifiers.add(CodeModifier.SYNCHRONIZED);
            }

            if (CommonRead.is(access, Opcodes.ACC_BRIDGE)) {
                modifiers.add(CodeModifier.BRIDGE);
            }

            if (CommonRead.is(access, Opcodes.ACC_VARARGS)) {
                modifiers.add(CodeModifier.VARARGS);
            }

            if (CommonRead.is(access, Opcodes.ACC_NATIVE)) {
                modifiers.add(CodeModifier.NATIVE);
            }

            if (CommonRead.is(access, Opcodes.ACC_STRICT)) {
                modifiers.add(CodeModifier.STRICTFP);
            }

        }

        if (elementType == PARAMETER) {
            if (CommonRead.is(access, Opcodes.ACC_MANDATED)) {
                modifiers.add(CodeModifier.MANDATED);
            }
        }

        if(elementType == CLASS || elementType == METHOD) {
            if (CommonRead.is(access, Opcodes.ACC_ABSTRACT)) {
                modifiers.add(CodeModifier.ABSTRACT);
            }
        }

        if(elementType == FIELD || elementType == METHOD) {
            if (CommonRead.is(access, Opcodes.ACC_STATIC)) {
                modifiers.add(CodeModifier.STATIC);
            }
        }

        if(elementType == CLASS || elementType == FIELD || elementType == METHOD || elementType == PARAMETER) {
            if (CommonRead.is(access, Opcodes.ACC_FINAL)) {
                modifiers.add(CodeModifier.FINAL);
            }

            if(CommonRead.is(access, Opcodes.ACC_SYNTHETIC)) {
                modifiers.add(CodeModifier.SYNTHETIC);
            }
        }

        return modifiers;
    }

    public static boolean isClassOrMethod(int elementType) {
        return elementType == CLASS || elementType == METHOD;
    }

    public static boolean isClassOrField(int elementType) {
        return elementType == CLASS || elementType == FIELD;
    }

    public static boolean isClassFieldOrMethod(int elementType) {
        return elementType == CLASS || elementType == FIELD || elementType == METHOD;
    }

    public static boolean isClassFieldMethodOrParameter(int elementType) {
        return elementType == CLASS || elementType == METHOD || elementType == FIELD || elementType == PARAMETER;
    }


}
