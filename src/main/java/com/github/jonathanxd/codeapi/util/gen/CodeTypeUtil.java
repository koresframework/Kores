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

import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.Util;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class CodeTypeUtil {
    private static final MethodHandles.Lookup lookup = MethodHandles.lookup();

    public static String resolveRealQualified(String qualifiedName, CodeType outer) {

        if (outer != null) {
            String packageName = outer.getPackageName();

            if (!packageName.isEmpty() && !qualifiedName.startsWith(packageName)) {
                // Prevent duplication of the name
                return Util.getRealNameStr(qualifiedName, outer);
            }
        }

        return qualifiedName;
    }

    public static String codeTypeToSimpleAsm(CodeType type) {
        return type.isPrimitive()
                ? primitiveCodeTypeToAsm(type)
                : !type.isArray()
                ? type.getType().replace('.', '/')
                : codeTypeToFullAsm(type);
    }

    public static String codeTypeToFullAsm(CodeType type) {
        return type.isPrimitive()
                ? primitiveCodeTypeToAsm(type)
                : type.getJavaSpecName();//"L" + type.getType().replace('.', '/') + ";";
    }

    public static String primitiveCodeTypeToAsm(CodeType type) {
        return type.getJavaSpecName();
    }

    public static String codeTypeToArray(CodeType codeType, int dimensions) {
        String name = codeTypeToFullAsm(codeType);

        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < dimensions; ++x)
            sb.append("[");

        return sb.toString() + name;
    }

    public static String codeTypeToSimpleArray(CodeType codeType, int dimensions) {
        if (dimensions <= 1) {
            return codeTypeToSimpleAsm(codeType);
        }

        String name = codeTypeToFullAsm(codeType);

        StringBuilder sb = new StringBuilder();

        for (int x = 1; x < dimensions; ++x)
            sb.append("[");

        return sb.toString() + name;
    }

    public static String codeTypesToSimpleAsm(CodeType[] type) {

        StringBuilder sb = new StringBuilder();

        for (CodeType codeType : type) {
            sb.append(codeTypeToSimpleAsm(codeType));
        }

        return sb.toString();
    }

    public static String codeTypesToFullAsm(CodeType[] type) {
        StringBuilder sb = new StringBuilder();

        for (CodeType codeType : type) {
            sb.append(codeTypeToFullAsm(Objects.requireNonNull(codeType, "Null type in array '" + Arrays.toString(type) + "'!")));
        }

        return sb.toString();
    }

    public static String fullSpecToFullAsm(TypeSpec typeSpec) {
        return "(" + CodeTypeUtil.codeTypesToFullAsm(typeSpec.getParameterTypes().stream().toArray(CodeType[]::new)) + ")"
                + CodeTypeUtil.codeTypeToFullAsm(typeSpec.getReturnType());
    }

    public static String fullSpecToSimpleAsm(TypeSpec typeSpec) {
        return "(" + CodeTypeUtil.codeTypesToSimpleAsm(typeSpec.getParameterTypes().stream().toArray(CodeType[]::new)) + ")"
                + CodeTypeUtil.codeTypeToSimpleAsm(typeSpec.getReturnType());
    }

    public static String toAsm(CodeType codeType) {
        if (codeType instanceof GenericType) {

            GenericType genericType = (GenericType) codeType;

            String name = genericType.name();

            GenericType.Bound<CodeType>[] bounds = genericType.bounds();

            if (bounds.length == 0) {
                if (!genericType.isType()) {
                    return GenericUtil.fixResult("T" + name + ";");
                } else {
                    return name + ";";
                }
            } else {
                return GenericUtil.fixResult(!genericType.isWildcard()
                        ? (name + "<" + GenericUtil.bounds(genericType.isWildcard(), bounds) + ">;")
                        : GenericUtil.bounds(genericType.isWildcard(), bounds) + ";");
            }

        } else {
            return GenericUtil.fixResult(codeTypeToFullAsm(codeType));
        }
    }

    public static String parametersToAsm(Collection<CodeParameter> codeParameters) {
        return codeTypesToFullAsm(codeParameters.stream().map(CodeParameter::getRequiredType).toArray(CodeType[]::new));
    }

    public static int arrayOpcodeFromType(CodeType codeType) {
        switch (codeType.getType()) {
            case "int":
                return Opcodes.T_INT;
            case "boolean":
                return Opcodes.T_BOOLEAN;
            case "byte":
                return Opcodes.T_BYTE;
            case "char":
                return Opcodes.T_CHAR;
            case "double":
                return Opcodes.T_DOUBLE;
            case "float":
                return Opcodes.T_FLOAT;
            case "short":
                return Opcodes.T_SHORT;
            case "long":
                return Opcodes.T_LONG;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public static int getOpcodeForType(CodeType type, int opcode) {
        Type asmType = Type.getType(type.getJavaSpecName());

        return asmType.getOpcode(opcode);
    }

    public static void convertToPrimitive(CodeType from, CodeType to, MethodVisitor mv) {
        int opcode = -1;

        if (from.isPrimitive() && to.isPrimitive()) {
            char fromTypeChar = Character.toUpperCase(from.getType().charAt(0));
            char toTypeChar = Character.toUpperCase(to.getType().charAt(0));

            try {
                MethodHandle staticGetter = lookup.findStaticGetter(Opcodes.class, fromTypeChar + "2" + toTypeChar, Integer.TYPE);
                opcode = (int) staticGetter.invoke();
            } catch (Throwable throwable) {
                if (throwable instanceof NoSuchFieldException) {
                    CodeTypeUtil.convertToPrimitive(from, PredefinedTypes.INT, mv);
                    CodeTypeUtil.convertToPrimitive(PredefinedTypes.INT, to, mv);
                    return;
                }
            }


        }
        if (opcode != -1)
            mv.visitInsn(opcode);
        else
            throw new IllegalArgumentException("Cannot cast '" + from + "' to '" + to + "'!");
    }

}
