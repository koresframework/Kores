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
package com.github.jonathanxd.codeapi.read.bytecode;

import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.Environment;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.iutils.description.DescriptionUtil;

import org.objectweb.asm.Opcodes;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CommonRead {

    public static Collection<CodeModifier> modifiersFromAccess(int access) {
        Set<CodeModifier> modifiers = new HashSet<>();

        if (CommonRead.is(access, Opcodes.ACC_PUBLIC)) {
            modifiers.add(CodeModifier.PUBLIC);
        } else if (CommonRead.is(access, Opcodes.ACC_PRIVATE)) {
            modifiers.add(CodeModifier.PRIVATE);
        } else if (CommonRead.is(access, Opcodes.ACC_PROTECTED)) {
            modifiers.add(CodeModifier.PROTECTED);
        } else {
            modifiers.add(CodeModifier.PACKAGE_PRIVATE);
        }

        if (CommonRead.is(access, Opcodes.ACC_ABSTRACT)) {
            modifiers.add(CodeModifier.ABSTRACT);
        }

        if (CommonRead.is(access, Opcodes.ACC_STATIC)) {
            modifiers.add(CodeModifier.STATIC);
        }

        if (CommonRead.is(access, Opcodes.ACC_FINAL)) {
            modifiers.add(CodeModifier.FINAL);
        }

        if (CommonRead.is(access, Opcodes.ACC_TRANSIENT)) {
            modifiers.add(CodeModifier.TRANSIENT);
        }

        if (CommonRead.is(access, Opcodes.ACC_VOLATILE)) {
            modifiers.add(CodeModifier.VOLATILE);
        }

        if (CommonRead.is(access, Opcodes.ACC_SYNCHRONIZED)) {
            modifiers.add(CodeModifier.SYNCHRONIZED);
        }

        if (CommonRead.is(access, Opcodes.ACC_NATIVE)) {
            modifiers.add(CodeModifier.NATIVE);
        }

        if (CommonRead.is(access, Opcodes.ACC_STRICT)) {
            modifiers.add(CodeModifier.STRICTFP);
        }

        return modifiers;
    }

    public static boolean is(int byte1_, int byte2_) {
        return (byte2_ & byte1_) != 0;
    }

    public static TypeSpec typeSpecFromDesc(Environment environment, TypeDeclaration typeDeclaration, String methodName, String desc) {
        desc = typeDeclaration.getJavaSpecName() + ":" + methodName + desc;

        String[] parameterTypes = DescriptionUtil.getParameterTypes(desc);
        String returnType = DescriptionUtil.getReturnType(desc);

        return new TypeSpec(environment.resolveUnknown(returnType),
                Arrays.stream(parameterTypes)
                        .map(environment::resolveUnknown).toArray(CodeType[]::new));
    }
}
