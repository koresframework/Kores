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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.FullInvokeSpec;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.description.Description;
import com.github.jonathanxd.codeapi.util.description.DescriptionUtil;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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

    public static CodeType toCodeType(String typeStr) {
        return CommonRead.toCodeType(typeStr, false, UNKNOWN);
    }

    public static CodeType toCodeType(String typeStr, boolean isInterface, Predicate<CodeType> predicate) {
        if (typeStr.equals(PredefinedTypes.BYTE.getJavaSpecName())) {
            return PredefinedTypes.BYTE;
        } else if (typeStr.equals(PredefinedTypes.SHORT.getJavaSpecName())) {
            return PredefinedTypes.SHORT;
        } else if (typeStr.equals(PredefinedTypes.INT.getJavaSpecName())) {
            return PredefinedTypes.INT;
        } else if (typeStr.equals(PredefinedTypes.FLOAT.getJavaSpecName())) {
            return PredefinedTypes.FLOAT;
        } else if (typeStr.equals(PredefinedTypes.DOUBLE.getJavaSpecName())) {
            return PredefinedTypes.DOUBLE;
        } else if (typeStr.equals(PredefinedTypes.LONG.getJavaSpecName())) {
            return PredefinedTypes.LONG;
        } else if (typeStr.equals(PredefinedTypes.CHAR.getJavaSpecName())) {
            return PredefinedTypes.CHAR;
        } else if (typeStr.equals(PredefinedTypes.STRING.getJavaSpecName())) {
            return PredefinedTypes.STRING;
        } else if (typeStr.equals(PredefinedTypes.BOOLEAN.getJavaSpecName())) {
            return PredefinedTypes.BOOLEAN;
        } else if (typeStr.equals(PredefinedTypes.VOID.getJavaSpecName())) {
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

    public static List<CodeArgument> createArguments(Description description, List<CodePart> arguments) {
        String[] parameterTypes = description.getParameterTypes();

        if (parameterTypes.length != arguments.size())
            throw new IllegalArgumentException("Parameter types size doesn't matches arguments size.");

        List<CodeArgument> codeArgumentList = new ArrayList<>();

        for (int i = 0; i < parameterTypes.length; i++) {
            String parameterTypeStr = parameterTypes[i];
            CodeType parameterType = CommonRead.toCodeType(parameterTypeStr);

            CodePart codePart = arguments.get(i);

            codeArgumentList.add(new CodeArgument(codePart, parameterType));

        }

        return codeArgumentList;
    }

    public static TypeSpec typeSpecFromDescriptor(String desc) {
        String[] parameterTypes = DescriptionUtil.getParameterTypes(desc);

        String returnType = DescriptionUtil.getReturnType(desc);

        return new TypeSpec(CommonRead.toCodeType(returnType), Arrays.stream(parameterTypes).map(CommonRead::toCodeType).toArray(CodeType[]::new));
    }

    public static FullInvokeSpec specFromHandle(Handle handle) {
        InvokeType invokeType = InvokeType.fromAsm_H(handle.getTag());

        CodeType owner = CommonRead.toCodeType(handle.getOwner());
        String desc = owner.getJavaSpecName() + ":" + handle.getName() + handle.getDesc();

        Description description = DescriptionUtil.parseDescription(desc);

        return new FullInvokeSpec(invokeType,
                owner,
                CommonRead.toCodeType(description.getReturnType()),
                handle.getName(),
                Arrays.stream(description.getParameterTypes()).map(CommonRead::toCodeType).toArray(CodeType[]::new));
    }

    public static InvokeDynamic fromHandle(Handle handle, Object... args) {
        InvokeType invokeType = InvokeType.fromAsm_H(handle.getTag());
        FullInvokeSpec fullMethodSpec = CommonRead.specFromHandle(handle);

        return InvokeDynamic.invokeDynamicBootstrap(invokeType, fullMethodSpec, bsmArgsFromAsm(args));
    }

    public static Object[] bsmArgsFromAsm(Object... asmArgs) {
        if (asmArgs == null || asmArgs.length == 0)
            return new Object[0];

        List<Object> codeAPIArgsList = new ArrayList<>();

        for (Object asmArg : asmArgs) {
            if (asmArg instanceof Integer
                    || asmArg instanceof Float
                    || asmArg instanceof Long
                    || asmArg instanceof Double
                    || asmArg instanceof String) {
                codeAPIArgsList.add(asmArg);
            } else if (asmArg instanceof Type) {

                Type type = (Type) asmArg;

                String className = type.getClassName();

                if(className != null) {
                    // Class
                    codeAPIArgsList.add(CommonRead.toCodeType(className));
                } else {
                    codeAPIArgsList.add(CommonRead.typeSpecFromDescriptor(type.getDescriptor()));
                }


            } else if (asmArg instanceof Handle) {
                codeAPIArgsList.add(CommonRead.specFromHandle((Handle) asmArg));
            } else {
                throw new IllegalArgumentException("Unsupported ASM BSM Argument: " + asmArg);
            }
        }

        return codeAPIArgsList.stream().toArray(Object[]::new);
    }

    public static CodeType typeFromOpcode(int insn) {

        if(insn == Opcodes.BIPUSH) {
            return PredefinedTypes.BYTE;
        }

        if(insn == Opcodes.SIPUSH) {
            return PredefinedTypes.SHORT;
        }

        Optional<CodeType> constant = CommonRead.getConstant(insn);

        // Constants
        if(constant.isPresent()) {
            return constant.get();
        }

        Optional<CodeType> store = CommonRead.getStore(insn);

        // Store var
        if(store.isPresent()) {
            return store.get();
        }

        Optional<CodeType> load = CommonRead.getLoad(insn);

        // Load var
        if(load.isPresent()) {
            return load.get();
        }

        Optional<CodeType> aReturn = CommonRead.getReturn(insn);

        // Return var
        if(aReturn.isPresent()) {
            return aReturn.get();
        }


        if(insn == Opcodes.DUP || insn == Opcodes.POP) {
            return PredefinedTypes.OBJECT;
        }

        throw new RuntimeException("Cannot determine type o insn: "+insn);
    }

    public static Literal constantToLiteral(int opcode) {

        if(opcode >= Opcodes.ICONST_M1 && opcode <= Opcodes.ICONST_5) {
            int number = opcode - (Opcodes.ICONST_M1 - 1); // (2 - 3) = -1, -1 = ICONST_M1

            return Literals.INT(number);

        } else if(opcode >= Opcodes.LCONST_0 && opcode <= Opcodes.LCONST_1) {
            int number = opcode - Opcodes.LCONST_0; // (2 - 3) = -1, -1 = ICONST_M1

            return Literals.LONG(number);
        } else if(opcode >= Opcodes.FCONST_0 && opcode <= Opcodes.FCONST_2) {
            int number = opcode - Opcodes.FCONST_0; // (2 - 3) = -1, -1 = ICONST_M1

            return Literals.FLOAT(number);
        } else if(opcode >= Opcodes.DCONST_0 && opcode <= Opcodes.DCONST_1) {
            int number = opcode - Opcodes.DCONST_0; // (2 - 3) = -1, -1 = ICONST_M1

            return Literals.DOUBLE(number);
        } else if(opcode == Opcodes.ACONST_NULL) {
            return Literals.NULL;
        }

        throw new IllegalArgumentException("Cannot convert opcode '"+opcode+"' to literal");
    }

    public static Literal intInsnToLiteral(int opcode, int num) {

        if(opcode == Opcodes.BIPUSH) {
            return Literals.BYTE((byte) num);

        } else if(opcode == Opcodes.SIPUSH) {
            return Literals.SHORT((short) num);
        }

        throw new IllegalArgumentException("Cannot convert opcode '"+opcode+"' to literal");
    }

    public static Optional<CodeType> getConstant(int opcode) {

        CodeType codeType = null;

        // Constants
        if(opcode >= Opcodes.ICONST_M1 && opcode <= Opcodes.ICONST_5) {
            codeType = PredefinedTypes.INT;
        } else if(opcode >= Opcodes.LCONST_0 && opcode <= Opcodes.LCONST_1) {
            codeType = PredefinedTypes.LONG;
        } else if(opcode >= Opcodes.FCONST_0 && opcode <= Opcodes.FCONST_2) {
            codeType = PredefinedTypes.FLOAT;
        } else if(opcode >= Opcodes.DCONST_0 && opcode <= Opcodes.DCONST_1) {
            codeType = PredefinedTypes.DOUBLE;
        } else if(opcode == Opcodes.ACONST_NULL) {
            codeType = PredefinedTypes.OBJECT;
        }

        return Optional.ofNullable(codeType);
    }

    public static Optional<CodeType> getStore(int opcode) {

        CodeType codeType = null;

        // Store var
        if(opcode == Opcodes.ISTORE) {
            codeType = PredefinedTypes.INT;
        } else if(opcode == Opcodes.LSTORE) {
            codeType = PredefinedTypes.LONG;
        } else if(opcode == Opcodes.FSTORE) {
            codeType = PredefinedTypes.FLOAT;
        } else if(opcode == Opcodes.DSTORE) {
            codeType = PredefinedTypes.DOUBLE;
        } else if(opcode == Opcodes.ASTORE) {
            codeType = PredefinedTypes.OBJECT;
        }

        return Optional.ofNullable(codeType);
    }

    public static Optional<CodeType> getLoad(int opcode) {

        CodeType codeType = null;

        // Load var
        if(opcode == Opcodes.ILOAD) {
            codeType = PredefinedTypes.INT;
        } else if(opcode == Opcodes.LLOAD) {
            codeType = PredefinedTypes.LONG;
        } else if(opcode == Opcodes.FLOAD) {
            codeType = PredefinedTypes.FLOAT;
        } else if(opcode == Opcodes.DLOAD) {
            codeType = PredefinedTypes.DOUBLE;
        } else if(opcode == Opcodes.ALOAD) {
            codeType = PredefinedTypes.OBJECT;
        }

        return Optional.ofNullable(codeType);
    }

    public static Optional<CodeType> getReturn(int opcode) {

        CodeType codeType = null;

        // Return var
        if(opcode == Opcodes.IRETURN) {
            codeType = PredefinedTypes.INT;
        } else if(opcode == Opcodes.LRETURN) {
            codeType = PredefinedTypes.LONG;
        } else if(opcode == Opcodes.FRETURN) {
            codeType = PredefinedTypes.FLOAT;
        } else if(opcode == Opcodes.DRETURN) {
            codeType = PredefinedTypes.DOUBLE;
        } else if(opcode == Opcodes.ARETURN) {
            codeType = PredefinedTypes.OBJECT;
        } else if(opcode == Opcodes.RETURN) {
            codeType = PredefinedTypes.VOID;
        }

        return Optional.ofNullable(codeType);
    }

    public static boolean isConstant(int opcode) {
        return CommonRead.getConstant(opcode).isPresent();
    }

    public static boolean isStore(int opcode) {
        return CommonRead.getStore(opcode).isPresent();
    }

    public static boolean isLoad(int opcode) {
        return CommonRead.getLoad(opcode).isPresent();
    }

    public static boolean isReturn(int opcode) {
        return CommonRead.getReturn(opcode).isPresent();
    }

    public static boolean isVoidReturn(int opcode) {
        Optional<CodeType> aReturn = CommonRead.getReturn(opcode);
        return aReturn.isPresent() && aReturn.get().is(PredefinedTypes.VOID);
    }
}
