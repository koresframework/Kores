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
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.description.DescriptionUtil;

import org.objectweb.asm.Opcodes;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static com.github.jonathanxd.codeapi.common.CodeModifier.ABSTRACT;
import static com.github.jonathanxd.codeapi.common.CodeModifier.FINAL;
import static com.github.jonathanxd.codeapi.common.CodeModifier.NATIVE;
import static com.github.jonathanxd.codeapi.common.CodeModifier.PACKAGE_PRIVATE;
import static com.github.jonathanxd.codeapi.common.CodeModifier.PRIVATE;
import static com.github.jonathanxd.codeapi.common.CodeModifier.PROTECTED;
import static com.github.jonathanxd.codeapi.common.CodeModifier.PUBLIC;
import static com.github.jonathanxd.codeapi.common.CodeModifier.STATIC;
import static com.github.jonathanxd.codeapi.common.CodeModifier.STRICTFP;
import static com.github.jonathanxd.codeapi.common.CodeModifier.SYNCHRONIZED;
import static com.github.jonathanxd.codeapi.common.CodeModifier.TRANSIENT;
import static com.github.jonathanxd.codeapi.common.CodeModifier.VOLATILE;

/**
 * Created by jonathan on 19/08/16.
 */
public class CommonRead {

    private static final Predicate<CodeType> UNKNOWN = codeType -> {
        throw new IllegalStateException("Cannot determine if '" + codeType + "' is interface.");
    };

    public static CodeType toCodeType(String typeStr, boolean isInterface) {
        return CommonRead.toCodeType(typeStr, isInterface, null);
    }

    public static CodeType toCodeType(String typeStr, boolean isInterface, Predicate<CodeType> predicate) {
        if(typeStr.equals(PredefinedTypes.BYTE.getJavaSpecName())) {
            return PredefinedTypes.BYTE;
        } else if(typeStr.equals(PredefinedTypes.SHORT.getJavaSpecName())) {
            return PredefinedTypes.SHORT;
        } else if(typeStr.equals(PredefinedTypes.INT.getJavaSpecName())) {
            return PredefinedTypes.INT;
        } else if(typeStr.equals(PredefinedTypes.FLOAT.getJavaSpecName())) {
            return PredefinedTypes.FLOAT;
        } else if(typeStr.equals(PredefinedTypes.DOUBLE.getJavaSpecName())) {
            return PredefinedTypes.DOUBLE;
        } else if(typeStr.equals(PredefinedTypes.LONG.getJavaSpecName())) {
            return PredefinedTypes.LONG;
        } else if(typeStr.equals(PredefinedTypes.CHAR.getJavaSpecName())) {
            return PredefinedTypes.CHAR;
        } else if(typeStr.equals(PredefinedTypes.STRING.getJavaSpecName())) {
            return PredefinedTypes.STRING;
        } else if(typeStr.equals(PredefinedTypes.BOOLEAN.getJavaSpecName())) {
            return PredefinedTypes.BOOLEAN;
        } else if(typeStr.equals(PredefinedTypes.VOID.getJavaSpecName())) {
            return PredefinedTypes.VOID;
        }

        typeStr = typeStr.replace('/', '.');

        if (typeStr.startsWith("L") && typeStr.endsWith(";")) {
            typeStr = typeStr.substring(1, typeStr.length() - 1);
        }

        String simpleName = typeStr.contains(".") ? typeStr.substring(typeStr.lastIndexOf('.') + 1, typeStr.length()) : typeStr;
        if (predicate == null) {
            return new BytecodeCodeType(simpleName, typeStr, isInterface);
        } else {
            return new BytecodeCodeType(simpleName, typeStr, predicate);
        }
    }

    public static boolean isLiteral(Object o) {
        return o instanceof Byte
                || o instanceof Short
                || o instanceof Integer
                || o instanceof Double
                || o instanceof Float
                || o instanceof Long
                || o instanceof String;
    }

    public static Literal toLiteral(Object o) {
        if (o instanceof Byte) {
            return Literals.BYTE((byte) o);
        } else if (o instanceof Short) {
            return Literals.SHORT((short) o);
        } else if (o instanceof Integer) {
            return Literals.INT((int) o);
        } else if (o instanceof Double) {
            return Literals.DOUBLE((double) o);
        } else if (o instanceof Float) {
            return Literals.FLOAT((float) o);
        } else if (o instanceof Long) {
            return Literals.LONG((long) o);
        } else if (o instanceof String) {
            return Literals.STRING((String) o);
        } else {
            throw new IllegalArgumentException("Cannot convert '" + o + "' to Literal.");
        }
    }

    public static Collection<CodeModifier> modifiersFromAccess(int access) {

        Set<CodeModifier> modifiers = new HashSet<>();

        if (CommonRead.is(access, Opcodes.ACC_PUBLIC)) {
            modifiers.add(PUBLIC);
        } else if (CommonRead.is(access, Opcodes.ACC_PRIVATE)) {
            modifiers.add(PRIVATE);
        } else if (CommonRead.is(access, Opcodes.ACC_PROTECTED)) {
            modifiers.add(PROTECTED);
        } else {
            modifiers.add(PACKAGE_PRIVATE);
        }

        if (CommonRead.is(access, Opcodes.ACC_ABSTRACT)) {
            modifiers.add(ABSTRACT);
        }

        if (CommonRead.is(access, Opcodes.ACC_STATIC)) {
            modifiers.add(STATIC);
        }

        if (CommonRead.is(access, Opcodes.ACC_FINAL)) {
            modifiers.add(FINAL);
        }

        if (CommonRead.is(access, Opcodes.ACC_TRANSIENT)) {
            modifiers.add(TRANSIENT);
        }

        if (CommonRead.is(access, Opcodes.ACC_VOLATILE)) {
            modifiers.add(VOLATILE);
        }

        if (CommonRead.is(access, Opcodes.ACC_SYNCHRONIZED)) {
            modifiers.add(SYNCHRONIZED);
        }

        if (CommonRead.is(access, Opcodes.ACC_NATIVE)) {
            modifiers.add(NATIVE);
        }

        if (CommonRead.is(access, Opcodes.ACC_STRICT)) {
            modifiers.add(STRICTFP);
        }

        return modifiers;
    }

    public static boolean is(int byte1_, int byte2_) {
        return (byte2_ & byte1_) != 0;
    }

    public static TypeSpec typeSpecFromDesc(CodeInterface codeInterface, String methodName, String desc) {
        desc = codeInterface.getJavaSpecName() + ":" + methodName + desc;

        String[] parameterTypes = DescriptionUtil.getParameterTypes(desc);
        String returnType = DescriptionUtil.getReturnType(desc);

        return new TypeSpec(CommonRead.toCodeType(returnType, false, UNKNOWN),
                Arrays.stream(parameterTypes)
                        .map(s -> CommonRead.toCodeType(s, false, UNKNOWN)).toArray(CodeType[]::new));
    }

}
