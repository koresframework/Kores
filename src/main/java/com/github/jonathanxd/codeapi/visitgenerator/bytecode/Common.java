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
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.util.Variable;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 03/06/16.
 */
public class Common {

    public static String codeTypeToArray(CodeType codeType, int dimensions) {
        String name = codeTypeToFullAsm(codeType);

        StringBuilder sb = new StringBuilder();

        for(int x = 0; x < dimensions; ++x)
            sb.append("[");

        return sb.toString() + name;
    }

    public static String codeTypeToSimpleArray(CodeType codeType, int dimensions) {
        if(dimensions <= 1) {
            return codeTypeToSimpleAsm(codeType);
        }

        String name = codeTypeToFullAsm(codeType);

        StringBuilder sb = new StringBuilder();

        for(int x = 1; x < dimensions; ++x)
            sb.append("[");

        return sb.toString() + name;
    }

    public static int fromType(CodeType codeType) {
        switch (codeType.getType()) {
            case "int": return Opcodes.T_INT;
            case "boolean": return Opcodes.T_BOOLEAN;
            case "byte": return Opcodes.T_BYTE;
            case "char": return Opcodes.T_CHAR;
            case "double": return Opcodes.T_DOUBLE;
            case "float": return Opcodes.T_FLOAT;
            case "short": return Opcodes.T_SHORT;
            case "long": return Opcodes.T_LONG;
            default: return Integer.MIN_VALUE;
        }
    }

    public static void runForArrayStore(CodeType arrayType, int dimensions, MethodVisitor mv) {
        //mv.visitIntInsn(NEWARRAY, T_INT);
        switch (arrayType.getType()) {
            case "int": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_INT);
                break;
            }
            case "boolean": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BOOLEAN);
                break;
            }
            case "byte": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE);
                break;
            }
            case "char": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_CHAR);
                break;
            }
            case "double": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_DOUBLE);
                break;
            }
            case "float": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_FLOAT);
                break;
            }
            case "short": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_SHORT);
                break;
            }
            case "long": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_LONG);
                break;
            }
            default:{
                mv.visitTypeInsn(Opcodes.ANEWARRAY, Common.codeTypeToSimpleArray(arrayType, dimensions));
                break;
            }
        }
    }

    public static void runForInt(int num, MethodVisitor mv) {
        if(num == -1) {
            mv.visitInsn(Opcodes.ICONST_M1);
        }else
        if(num == 0) {
            mv.visitInsn(Opcodes.ICONST_0);
        }else
        if(num == 1) {
            mv.visitInsn(Opcodes.ICONST_1);
        }else
        if(num == 2) {
            mv.visitInsn(Opcodes.ICONST_2);
        }else
        if(num == 3) {
            mv.visitInsn(Opcodes.ICONST_3);
        }else
        if(num == 4) {
            mv.visitInsn(Opcodes.ICONST_4);
        }else
        if(num == 5) {
            mv.visitInsn(Opcodes.ICONST_5);
        }else
        if(num > Byte.MIN_VALUE && num < Byte.MAX_VALUE) {
            mv.visitIntInsn(Opcodes.BIPUSH, num);
        } else if(num > Short.MIN_VALUE && num < Short.MAX_VALUE) {
            mv.visitIntInsn(Opcodes.SIPUSH, num);
        } else {
            mv.visitLdcInsn(num);
        }
    }

    public static void runForLong(long num, MethodVisitor mv) {
        if(num == 0) {
            mv.visitInsn(Opcodes.LCONST_0);
        }else
        if(num == 1) {
            mv.visitInsn(Opcodes.LCONST_1);
        } else {
            mv.visitLdcInsn(num);
        }
    }

    public static void runForDouble(double num, MethodVisitor mv) {
        if(num == 0) {
            mv.visitInsn(Opcodes.DCONST_0);
        }else
        if(num == 1) {
            mv.visitInsn(Opcodes.DCONST_1);
        } else {
            mv.visitLdcInsn(num);
        }
    }

    public static void runForFloat(float num, MethodVisitor mv) {
        if(num == 0) {
            mv.visitInsn(Opcodes.FCONST_0);
        }else
        if(num == 1) {
            mv.visitInsn(Opcodes.FCONST_1);
        } else
        if(num == 2) {
            mv.visitInsn(Opcodes.FCONST_2);
        } else {
            mv.visitLdcInsn(num);
        }
    }

    public static void runForBoolean(boolean num, MethodVisitor mv) {

        // True -> 1
        if(num) {
            mv.visitInsn(Opcodes.ICONST_1);
        } else {
            // False -> 0
            mv.visitInsn(Opcodes.ICONST_0);
        }
    }

    public static void runForLiteral(Literal num, MethodVisitor mv) {
        String name = num.getName();

        if (num == Literals.NULL) {

            mv.visitInsn(Opcodes.ACONST_NULL);

        } else if (num == Literals.TRUE) {

            mv.visitInsn(Opcodes.ICONST_1);

        } else if (num == Literals.FALSE) {

            mv.visitInsn(Opcodes.ICONST_0);

        } else if(num instanceof Literals.QuotedStringLiteral) {

            mv.visitLdcInsn(name.substring(1, name.length()-1));

        } else if (num instanceof Literals.IntLiteral) {

            Common.runForInt(Integer.parseInt(name), mv);

        } else if (num instanceof Literals.LongLiteral) {

            Common.runForLong(Long.parseLong(name), mv);

        } else if (num instanceof Literals.DoubleLiteral) {

            Common.runForDouble(Double.parseDouble(name), mv);

        } else if (num instanceof Literals.CharLiteral) {

            mv.visitIntInsn(Opcodes.BIPUSH, name.charAt(0));

        } else if (num instanceof Literals.FloatLiteral) {

            Common.runForFloat(Float.parseFloat(name), mv);

        } else if (num instanceof Literals.ClassLiteral) {

            Type type = Type.getType((((Literals.ClassLiteral) num).type).getJavaSpecName());

            mv.visitLdcInsn(type);
        }
    }

    public static int opcodeForInt(int num) {

        if(num == 0) {
            return Opcodes.ICONST_0;
        }else
        if(num == 1) {
            return Opcodes.ICONST_1;
        }else
        if(num == 2) {
            return Opcodes.ICONST_2;
        }else
        if(num == 3) {
            return Opcodes.ICONST_3;
        }else
        if(num == 4) {
            return Opcodes.ICONST_4;
        }else
        if(num == 5) {
            return Opcodes.ICONST_5;
        }else
        if(num > Byte.MIN_VALUE && num < Byte.MAX_VALUE) {
            return Opcodes.BIPUSH;
        } else if(num > Short.MIN_VALUE && num < Short.MAX_VALUE) {
            return Opcodes.SIPUSH;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static boolean isPrimitive(CodePart codePart) {
        if (codePart instanceof Literal) {
            return Literals.isPrimitive((Literal) codePart);
        } else if (codePart instanceof Typed) {
            Typed typed = (Typed) codePart;

            return typed.getType().orElseThrow(() -> new RuntimeException("Cannot determine type of '" + codePart + "'")).isPrimitive();
        }

        return false;
    }

    public static int modifierToAsm(Collection<CodeModifier> codeModifiers) {
        return CodeModifier.toAsmAccess(codeModifiers);
    }

    public static int modifierToAsm(Collection<CodeModifier> codeModifiers, boolean isInterface) {
        return (isInterface ? Opcodes.ACC_INTERFACE : 0) + CodeModifier.toAsmAccess(codeModifiers);
    }

    public static int modifierToAsm(CodeInterface codeInterface) {
        int asm = CodeModifier.toAsmAccess(codeInterface.getModifiers());

        if (!(codeInterface instanceof CodeClass)) {
            asm += Opcodes.ACC_INTERFACE;
        }

        return asm;
    }

    public static String getClassName(CodeInterface class_, Data data) {
        return class_.getType().replace('.', '/');
    }
    /*
    public static String getClassName(CodeInterface class_, Data data) {
        String className = class_.getJavaSpecName();

        Optional<PackageDeclaration<?>> optional = data.getOptionalCasted(PackageVisitor.PACKAGE_REPRESENTATION);

        if (optional.isPresent()) {
            className = optional.get().getPackage().get().replace('.', '/') + '/' + className;
        }

        return className;
    }*/

    public static String getClassName(CodeInterface class_, String package_) {
        String className = class_.getJavaSpecName();

        if (package_ != null) {
            className = package_.replace('.', '/') + '/' + className;
        }

        return className;
    }

    public static TypeSpec specFromLegacy(CodeType returnType, Collection<CodeArgument> arguments) {
        return new TypeSpec(returnType != null ? returnType : PredefinedTypes.VOID, arguments != null ?
                arguments.stream().map(CodeArgument::getType).collect(Collectors.toList())
                : Collections.emptyList());
    }

    public static String typeSpecToAsm(TypeSpec typeSpec) {
        String s = codeTypeToFullAsm(Objects.requireNonNull(typeSpec.getReturnType(), "Null return type in Spec '" + typeSpec + "'"));

        return "(" +
                codeTypesToFullAsm(Objects.requireNonNull(typeSpec.getParameterSpec(), "Null method spec '" + typeSpec + "' arguments!").stream().toArray(CodeType[]::new))
                + ")" + s;
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

    public static String fullSpecToFullAsm(TypeSpec typeSpec) {
        return "(" + codeTypesToFullAsm(typeSpec.getParameterSpec().stream().toArray(CodeType[]::new)) + ")"
                + codeTypeToFullAsm(typeSpec.getReturnType());
    }

    public static String fullSpecToSimpleAsm(TypeSpec typeSpec) {
        return "(" + codeTypesToSimpleAsm(typeSpec.getParameterSpec().stream().toArray(CodeType[]::new)) + ")"
                + codeTypeToSimpleAsm(typeSpec.getReturnType());
    }

    public static int getOpcodeForType(CodeType type, int opcode) {
        Type asmType = Type.getType(type.getJavaSpecName());

        return asmType.getOpcode(opcode);
    }

    private static String primitiveCodeTypeToAsm(CodeType type) {
        return type.getJavaSpecName();
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

    public static List<Variable> parametersToVars(Collection<CodeParameter> parameters) {
        if (parameters.isEmpty())
            return Collections.emptyList();

        return parameters.stream().map(d -> new Variable(d.getName(), d.getType(), null, null)).collect(Collectors.toList());
    }

    public static void parametersToVars(Collection<CodeParameter> parameters, Collection<Variable> target) {
        if (parameters.isEmpty())
            return;

        parameters.stream().map(d -> new Variable(d.getName(), d.getType(), null, null)).forEach(target::add);
    }

    public static Map<String, Integer> parametersToMap(Collection<CodeParameter> parameters, int startAt) {

        if (parameters.isEmpty())
            return Collections.emptyMap();

        Map<String, Integer> map = new HashMap<>();

        for (CodeParameter parameter : parameters) {
            map.put(parameter.getName(), startAt);
            ++startAt;
        }

        return map;
    }

    public static CodeType getSuperClass(CodeInterface codeInterface) {

        if (codeInterface instanceof CodeClass) {

            return ((CodeClass) codeInterface)
                    .getSuperType()
                    .orElse(Helper.getJavaType(Object.class));
        }

        return Helper.getJavaType(Object.class);
    }

    public static String parametersToAsm(Collection<CodeParameter> codeParameters) {
        return codeTypesToFullAsm(codeParameters.stream().map(CodeParameter::getType).toArray(CodeType[]::new));
    }

    public static String argumentsToAsm(Collection<CodeArgument> codeArguments) {
        return codeTypesToFullAsm(codeArguments.stream().map(CodeArgument::getType).toArray(CodeType[]::new));
    }


    // ** Generics ** \\

    public static String genericTypesToAsmString(GenericType[] generics) {
        StringJoiner sj = new StringJoiner(";");

        for (GenericType generic : generics) {
            sj.add(genericTypeToAsmString_plain(generic));
        }

        return "<"+fixResult(sj.toString())+">";
    }

    public static String genericTypeToAsmString(GenericType generic) {
        return "<" + fixResult(genericTypeToAsmString_plain(generic)) + ">";

    }

    public static String fixResult(String str) {
        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();

        boolean ign = false;

        for (char aChar : chars) {
            if(aChar == ';') {
                if(!ign) {
                    sb.append(aChar);
                }

                ign = true;
            } else {
                sb.append(aChar);
                ign = false;
            }
        }

        return sb.toString();
    }

    private static String genericTypeToAsmString_plain(GenericType generic) {
        String name = generic.name();


        boolean gen2 = false;
        if(generic.bounds().length != 0) {
            GenericType.Bound<CodeType> codeTypeBound = generic.bounds()[0];

            CodeType type = codeTypeBound.getType();

            if(type instanceof GenericType) {
                gen2 = ((GenericType) type).bounds().length > 0;
            }
        }

        return name + ":" + (gen2 ? ":" : "") + boundToMain(generic.isWildcard(), generic.bounds());

    }

    public static String toAsm(CodeType codeType) {
        if(codeType instanceof GenericType) {

            GenericType genericType = (GenericType) codeType;

            String name = genericType.name();

            GenericType.Bound<CodeType>[] bounds = genericType.bounds();

            if(bounds.length == 0) {
                return fixResult(name + (genericType.isType() ? ";" : ""));
            } else {
                return fixResult(!genericType.isWildcard()
                        ? (name + "<"+bounds(genericType.isWildcard(), bounds)+">;")
                        : bounds(genericType.isWildcard(), bounds));
            }

        } else {
            return fixResult(codeTypeToFullAsm(codeType));
        }
    }

    public static String bounds(boolean isWildcard, GenericType.Bound<CodeType>[] bounds) {

        StringBuilder sb = new StringBuilder();

        for (GenericType.Bound<CodeType> bound : bounds) {

            CodeType boundType = bound.getType();

            if(boundType instanceof GenericType && !((GenericType) boundType).isType()) {
                sb.append(isWildcard ? bound.sign() : "").append("T").append(toAsm(boundType)).append(";");
            } else {
                sb.append(isWildcard ? bound.sign() : "").append(toAsm(boundType)).append(";");
            }

        }

        return sb.toString();
    }

    private static String boundToMain(boolean isWildcard, GenericType.Bound<CodeType>[] bounds) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bounds.length; i++) {

            boolean isLast = i + 1 >= bounds.length;

            GenericType.Bound<CodeType> bound = bounds[i];

            CodeType boundType = bound.getType();

            if(boundType instanceof GenericType && !((GenericType) boundType).isType()) {
                sb.append(isWildcard ? bound.sign() : "").append("T").append(toAsm(boundType)).append(";").append(!isLast ? ":" : "");
            } else {
                sb.append(isWildcard ? bound.sign() : "").append(toAsm(boundType)).append(";").append(!isLast ? ":" : "");
            }
        }

        return sb.toString();
    }

    public static String genericTypeToAsmString0(GenericType genericType) {
        String name = genericType.name();

        GenericType.Bound<CodeType>[] bounds = genericType.bounds();

        if(bounds.length == 0) {
            return "<" + name + ":" + codeTypeToFullAsm(PredefinedTypes.OBJECT) + ">";
        } else {
            return "<" + name + ":" + generateToBounds(bounds) + ">";
        }
    }

    public static String generateToBounds(GenericType.Bound<CodeType>[] bounds) {

        StringBuilder sb = new StringBuilder();

        for (GenericType.Bound<CodeType> bound : bounds) {
            sb.append(bound.sign()).append("T").append(
                    generateToBound(bound.getType())
            ).append(';');
        }

        return sb.toString();
    }

    public static String generateToBound(CodeType codeType) {
        if(codeType instanceof GenericType) {
            return genericTypeToAsmString((GenericType) codeType);
        } else {
            return codeType.getJavaSpecName();
        }
    }



}
