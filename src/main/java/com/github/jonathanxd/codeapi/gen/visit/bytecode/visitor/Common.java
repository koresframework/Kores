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
package com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.inspect.SourceInspect;
import com.github.jonathanxd.codeapi.interfaces.AccessSuper;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.ClassDeclaration;
import com.github.jonathanxd.codeapi.interfaces.EnumValue;
import com.github.jonathanxd.codeapi.interfaces.Extender;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.ClassType;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.AnnotationVisitorCapable;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.option.Options;
import com.github.jonathanxd.iutils.optional.Require;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 03/06/16.
 */
public class Common {

    private static final MethodHandles.Lookup lookup = MethodHandles.lookup();
    private static final Random random = new Random();

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

    public static int fromType(CodeType codeType) {
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
            default: {
                mv.visitTypeInsn(Opcodes.ANEWARRAY, Common.codeTypeToSimpleArray(arrayType, dimensions));
                break;
            }
        }
    }

    public static void runForInt(int num, MethodVisitor mv) {
        if (num == -1) {
            mv.visitInsn(Opcodes.ICONST_M1);
        } else if (num == 0) {
            mv.visitInsn(Opcodes.ICONST_0);
        } else if (num == 1) {
            mv.visitInsn(Opcodes.ICONST_1);
        } else if (num == 2) {
            mv.visitInsn(Opcodes.ICONST_2);
        } else if (num == 3) {
            mv.visitInsn(Opcodes.ICONST_3);
        } else if (num == 4) {
            mv.visitInsn(Opcodes.ICONST_4);
        } else if (num == 5) {
            mv.visitInsn(Opcodes.ICONST_5);
        } else if (num > Byte.MIN_VALUE && num < Byte.MAX_VALUE) {
            mv.visitIntInsn(Opcodes.BIPUSH, num);
        } else if (num > Short.MIN_VALUE && num < Short.MAX_VALUE) {
            mv.visitIntInsn(Opcodes.SIPUSH, num);
        } else {
            mv.visitLdcInsn(num);
        }
    }

    public static void runForLong(long num, MethodVisitor mv) {
        if (num == 0) {
            mv.visitInsn(Opcodes.LCONST_0);
        } else if (num == 1) {
            mv.visitInsn(Opcodes.LCONST_1);
        } else {
            mv.visitLdcInsn(num);
        }
    }

    public static void runForDouble(double num, MethodVisitor mv) {
        if (num == 0) {
            mv.visitInsn(Opcodes.DCONST_0);
        } else if (num == 1) {
            mv.visitInsn(Opcodes.DCONST_1);
        } else {
            mv.visitLdcInsn(num);
        }
    }

    public static void runForFloat(float num, MethodVisitor mv) {
        if (num == 0) {
            mv.visitInsn(Opcodes.FCONST_0);
        } else if (num == 1) {
            mv.visitInsn(Opcodes.FCONST_1);
        } else if (num == 2) {
            mv.visitInsn(Opcodes.FCONST_2);
        } else {
            mv.visitLdcInsn(num);
        }
    }

    public static void runForBoolean(boolean num, MethodVisitor mv) {

        // True -> 1
        if (num) {
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

        } else if (num instanceof Literals.QuotedStringLiteral) {

            mv.visitLdcInsn(name.substring(1, name.length() - 1));

        } else if (num instanceof Literals.ShortLiteral) {

            Common.runForInt(Integer.parseInt(name), mv);

        } else if (num instanceof Literals.IntLiteral) {

            Common.runForInt(Integer.parseInt(name), mv);

        } else if (num instanceof Literals.LongLiteral) {

            Common.runForLong(Long.parseLong(name), mv);

        } else if (num instanceof Literals.DoubleLiteral) {

            Common.runForDouble(Double.parseDouble(name), mv);

        } else if (num instanceof Literals.CharLiteral || num instanceof Literals.ByteLiteral) {

            mv.visitIntInsn(Opcodes.BIPUSH, name.charAt(0));

        } else if (num instanceof Literals.FloatLiteral) {

            Common.runForFloat(Float.parseFloat(name), mv);

        } else if (num instanceof Literals.ClassLiteral) {

            Type type = Type.getType((((Literals.ClassLiteral) num).type).getJavaSpecName());

            mv.visitLdcInsn(type);
        }
    }

    public static int opcodeForInt(int num) {

        if (num == 0) {
            return Opcodes.ICONST_0;
        } else if (num == 1) {
            return Opcodes.ICONST_1;
        } else if (num == 2) {
            return Opcodes.ICONST_2;
        } else if (num == 3) {
            return Opcodes.ICONST_3;
        } else if (num == 4) {
            return Opcodes.ICONST_4;
        } else if (num == 5) {
            return Opcodes.ICONST_5;
        } else if (num > Byte.MIN_VALUE && num < Byte.MAX_VALUE) {
            return Opcodes.BIPUSH;
        } else if (num > Short.MIN_VALUE && num < Short.MAX_VALUE) {
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
        } else {
            throw new RuntimeException("Cannot determine type of part '" + codePart + "'!");
        }

    }

    public static CodeType getType(CodePart codePart) {
        if (codePart instanceof Literal) {
            return ((Literal) codePart).getType().orElseThrow(NullPointerException::new);
        } else if (codePart instanceof Typed) {
            Typed typed = (Typed) codePart;

            return typed.getType().orElseThrow(() -> new RuntimeException("Cannot determine type of '" + codePart + "'"));
        } else {
            throw new RuntimeException("Cannot determine type of part '" + codePart + "'!");
        }

    }

    public static int modifierToAsm(TypeDeclaration typeDeclaration) {
        return Common.modifierToAsm(typeDeclaration.getModifiers(), typeDeclaration.getClassType() == ClassType.INTERFACE);
    }

    public static int modifierToAsm(Collection<CodeModifier> codeModifiers) {
        return CodeModifier.toAsmAccess(codeModifiers);
    }

    public static int modifierToAsm(Collection<CodeModifier> codeModifiers, boolean isInterface) {
        return (isInterface ? Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE : 0) + CodeModifier.toAsmAccess(codeModifiers);
    }

    public static String getClassName(TypeDeclaration class_, MapData data) {
        return class_.getType().replace('.', '/');
    }

    public static String getClassName(TypeDeclaration class_, String package_) {
        String className = class_.getJavaSpecName();

        if (package_ != null) {
            className = package_.replace('.', '/') + '/' + className;
        }

        return className;
    }

    public static int invertIfNeEqOpcode(int opcode) {
        return opcode == Opcodes.IFNE ? Opcodes.IFEQ : Opcodes.IFNE;
    }

    public static int getIfNeEqOpcode(boolean value) {
        return value ? Opcodes.IFNE : Opcodes.IFEQ;
    }

    public static boolean isBoolean(CodePart part) {
        return part instanceof Literals.BoolLiteral;
    }

    public static boolean getBooleanValue(CodePart part) {
        return ((Literals.BoolLiteral) part).getValue();
    }

    public static TypeSpec specFromLegacy(CodeType returnType, Collection<CodeArgument> arguments) {
        return new TypeSpec(returnType != null ? returnType : PredefinedTypes.VOID, arguments != null ?
                arguments.stream().map(t -> Require.require(t.getType())).collect(Collectors.toList())
                : Collections.emptyList());
    }

    public static TypeSpec specFromLegacy(CodeType returnType, CodeArgument[] arguments) {
        return new TypeSpec(returnType != null ? returnType : PredefinedTypes.VOID, arguments != null ?
                Arrays.stream(arguments).map(t -> Require.require(t.getType())).collect(Collectors.toList())
                : Collections.emptyList());
    }

    public static String typeSpecToAsm(TypeSpec typeSpec) {
        String s = codeTypeToFullAsm(Objects.requireNonNull(typeSpec.getReturnType(), "Null return type in Spec '" + typeSpec + "'"));

        return "(" +
                codeTypesToFullAsm(Objects.requireNonNull(typeSpec.getParameterTypes(), "Null method spec '" + typeSpec + "' arguments!").stream().toArray(CodeType[]::new))
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
        return "(" + codeTypesToFullAsm(typeSpec.getParameterTypes().stream().toArray(CodeType[]::new)) + ")"
                + codeTypeToFullAsm(typeSpec.getReturnType());
    }

    public static String fullSpecToSimpleAsm(TypeSpec typeSpec) {
        return "(" + codeTypesToSimpleAsm(typeSpec.getParameterTypes().stream().toArray(CodeType[]::new)) + ")"
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

        return parameters.stream().map(d -> new Variable(d.getName(), d.getRequiredType(), null, null)).collect(Collectors.toList());
    }

    public static void parametersToVars(Collection<CodeParameter> parameters, Collection<Variable> target) {
        if (parameters.isEmpty())
            return;

        parameters.stream().map(d -> new Variable(d.getName(), d.getRequiredType(), null, null)).forEach(target::add);
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

    public static CodeType getSuperClass(TypeDeclaration codeInterface) {

        if (codeInterface instanceof ClassDeclaration) {

            return ((ClassDeclaration) codeInterface)
                    .getSuperType()
                    .orElse(Helper.getJavaType(Object.class));
        }

        return Helper.getJavaType(Object.class);
    }


    // ** Generics ** \\

    public static String parametersToAsm(Collection<CodeParameter> codeParameters) {
        return codeTypesToFullAsm(codeParameters.stream().map(CodeParameter::getRequiredType).toArray(CodeType[]::new));
    }

    public static String argumentsToAsm(Collection<CodeArgument> codeArguments) {
        return codeTypesToFullAsm(codeArguments.stream().map(CodeArgument::getRequiredType).toArray(CodeType[]::new));
    }

    public static String genericTypesToAsmString(TypeDeclaration typeDeclaration, CodeType superClass, Collection<CodeType> implementations, boolean superClassIsGeneric, boolean anyInterfaceIsGeneric) {
        GenericType[] types = typeDeclaration.getGenericSignature().getTypes();

        String genericRepresentation = null;

        if (types.length > 0) {
            genericRepresentation = Common.genericTypesToAsmString(types);
        }

        if (types.length > 0 || superClassIsGeneric || anyInterfaceIsGeneric) {

            if (genericRepresentation == null)
                genericRepresentation = "";

            genericRepresentation += Common.toAsm(superClass);
        }

        if (types.length > 0 || anyInterfaceIsGeneric) {
            StringBuilder sb = new StringBuilder();

            implementations.forEach(codeType -> sb.append(Common.toAsm(codeType)));

            genericRepresentation += sb.toString();
        }

        return genericRepresentation;
    }

    public static String getNewName(String name, CodeSource source) {
        List<CodeField> inspect = SourceInspect.find(codePart -> codePart instanceof CodeField)
                .includeSource(true)
                .include(bodied -> bodied instanceof CodeSource)
                .mapTo(codePart -> (CodeField) codePart)
                .inspect(source);

        while(Common.contains(name, inspect))
            name += "$1";

        return name;
    }

    public static boolean contains(String name, List<CodeField> codeFields) {
        for (CodeField codeField : codeFields) {
            if(codeField.getName().equals(name))
                return true;
        }

        return false;
    }

    public static String genericTypesToAsmString(GenericType[] generics) {
        StringJoiner sj = new StringJoiner(";");

        for (GenericType generic : generics) {
            sj.add(genericTypeToAsmString_plain(generic));
        }

        return "<" + fixResult(sj.toString()) + ">";
    }

    public static String genericTypeToAsmString(GenericType generic) {
        return "<" + fixResult(genericTypeToAsmString_plain(generic)) + ">";

    }

    public static String fixResult(String str) {
        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();

        boolean ign = false;

        for (char aChar : chars) {
            if (aChar == ';') {
                if (!ign) {
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
        if (generic.bounds().length != 0) {
            GenericType.Bound<CodeType> codeTypeBound = generic.bounds()[0];

            CodeType type = codeTypeBound.getType();

            if (type instanceof GenericType) {
                gen2 = ((GenericType) type).bounds().length > 0;
            }
        }

        return name + ":" + (gen2 ? ":" : "") + boundToMain(generic.isWildcard(), generic.bounds());

    }

    public static String toAsm(CodeType codeType) {
        if (codeType instanceof GenericType) {

            GenericType genericType = (GenericType) codeType;

            String name = genericType.name();

            GenericType.Bound<CodeType>[] bounds = genericType.bounds();

            if (bounds.length == 0) {
                if(!genericType.isType()) {
                    return fixResult("T" + name + ";"/*(genericType.isType() ? ";" : "")*/);
                }else {
                    return name + ";";
                }
            } else {
                return fixResult(!genericType.isWildcard()
                        ? (name + "<" + bounds(genericType.isWildcard(), bounds) + ">;")
                        : bounds(genericType.isWildcard(), bounds) + ";");
            }

        } else {
            return fixResult(codeTypeToFullAsm(codeType));
        }
    }

    public static String bounds(boolean isWildcard, GenericType.Bound<CodeType>[] bounds) {

        StringBuilder sb = new StringBuilder();

        for (GenericType.Bound<CodeType> bound : bounds) {

            CodeType boundType = bound.getType();

            if (boundType instanceof GenericType && !((GenericType) boundType).isType()) {
                sb.append(isWildcard ? bound.sign() : "").append(toAsm(boundType));
            } else {
                sb.append(isWildcard ? bound.sign() : "").append(toAsm(boundType));
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

            if (boundType instanceof GenericType && !((GenericType) boundType).isType()) {
                sb.append(isWildcard ? bound.sign() : "").append(toAsm(boundType)).append(!isLast ? ":" : "");
            } else {
                sb.append(isWildcard ? bound.sign() : "").append(toAsm(boundType)).append(!isLast ? ":" : "");
            }
        }

        return sb.toString();
    }

    public static String generateToBound(CodeType codeType) {
        if (codeType instanceof GenericType) {
            return genericTypeToAsmString((GenericType) codeType);
        } else {
            return codeType.getJavaSpecName();
        }
    }

    //"<T::Ljava/lang/CharSequence;>(Ljava/util/List<TT;>;Ljava/lang/String;)TT;
    public static String methodGenericSignature(MethodDeclaration codeMethod) {

        CodeType returnType = codeMethod.getReturnType().orElse(PredefinedTypes.VOID);

        StringBuilder signatureBuilder = new StringBuilder();

        GenericSignature<GenericType> methodSignature = codeMethod.getGenericSignature();


        boolean generateGenerics =
                methodSignature.isNotEmpty()
                        || codeMethod.getParameters().stream().anyMatch(parameter -> parameter.getRequiredType() instanceof GenericType)
                        || returnType instanceof GenericType;


        if (generateGenerics && methodSignature.isNotEmpty()) {
            signatureBuilder.append(genericTypesToAsmString(methodSignature.getTypes()));
        }

        if (generateGenerics) {
            signatureBuilder.append('(');

            codeMethod.getParameters().stream().map(parameter -> toAsm(parameter.getRequiredType())).forEach(signatureBuilder::append);

            signatureBuilder.append(')');
        }

        if (generateGenerics) {
            signatureBuilder.append(toAsm(returnType));
        }

        return signatureBuilder.length() > 0 ? signatureBuilder.toString() : null;

    }

    public static void convertToPrimitive(CodeType from, CodeType to, MethodVisitor mv) {
        int opcode = -1;

        if (from.isPrimitive() && to.isPrimitive()) {
            char fromTypeChar = Character.toUpperCase(from.getType().charAt(0));
            char toTypeChar = Character.toUpperCase(to.getType().charAt(0));

            System.out.println("from = " + fromTypeChar + " -> " + toTypeChar);

            try {
                MethodHandle staticGetter = lookup.findStaticGetter(Opcodes.class, fromTypeChar + "2" + toTypeChar, Integer.TYPE);
                opcode = (int) staticGetter.invoke();
            } catch (Throwable throwable) {
                if (throwable instanceof NoSuchFieldException) {
                    Common.convertToPrimitive(from, PredefinedTypes.INT, mv);
                    Common.convertToPrimitive(PredefinedTypes.INT, to, mv);
                    return;
                }
            }


        }
        if (opcode != -1)
            mv.visitInsn(opcode);
        else
            throw new IllegalArgumentException("Cannot cast '" + from + "' to '" + to + "'!");
    }

    public static void visitLambdaInvocation(InvokeDynamic.LambdaMethodReference lambdaDynamic,
                                             InvokeType invokeType,
                                             CodeType localization,
                                             MethodSpecification spec,
                                             MethodVisitor mv) {

        FullMethodSpec methodSpec = lambdaDynamic.getMethodSpec();
        TypeSpec expectedTypes = lambdaDynamic.getExpectedTypes();

        Handle metafactory = new Handle(Opcodes.H_INVOKESTATIC,
                "java/lang/invoke/LambdaMetafactory",
                "metafactory",
                "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
                false);

        Object[] objects = {
                Type.getType(Common.fullSpecToFullAsm(methodSpec)),
                new Handle(/*Opcodes.H_INVOKEINTERFACE*/ InvokeType.toAsm_H(invokeType),
                        Common.codeTypeToSimpleAsm(localization),
                        spec.getMethodName(),
                        Common.typeSpecToAsm(spec.getMethodDescription()),
                        invokeType == InvokeType.INVOKE_INTERFACE),

                Type.getType(Common.fullSpecToFullAsm(expectedTypes))
        };

        String local = "("
                + (invokeType != InvokeType.INVOKE_STATIC ? Common.codeTypeToFullAsm(localization) : "")
                + ")" + Common.codeTypeToFullAsm(methodSpec.getLocalization());

        mv.visitInvokeDynamicInsn(methodSpec.getMethodName(), local, metafactory, objects);


    }

    public static void visitBootstrapInvocation(InvokeDynamic.Bootstrap bootstrap, MethodSpecification spec, MethodVisitor mv) {
        Handle handle = Common.toHandle(bootstrap);

        mv.visitInvokeDynamicInsn(spec.getMethodName(), Common.typeSpecToAsm(spec.getMethodDescription()), handle, bootstrap.toAsmArguments());
    }

    public static Handle toHandle(InvokeDynamic.Bootstrap bootstrap) {
        FullMethodSpec bootstrapMethodSpec = bootstrap.getMethodSpec();
        InvokeType btpInvokeType = bootstrap.getInvokeType();

        String methodName = bootstrapMethodSpec.getMethodName();
        CodeType bsmLocalization = bootstrapMethodSpec.getLocalization();

        return new Handle(InvokeType.toAsm_H(btpInvokeType),
                Common.codeTypeToSimpleAsm(bsmLocalization),
                methodName,
                Common.fullSpecToFullAsm(bootstrapMethodSpec),
                btpInvokeType.isInterface());
    }


    public static void visitAnnotation(Annotation annotation, AnnotationVisitorCapable annotationVisitorCapable) {
        String annotationTypeAsm = Common.codeTypeToFullAsm(annotation.getType().orElseThrow(NullPointerException::new));
        org.objectweb.asm.AnnotationVisitor annotationVisitor = annotationVisitorCapable.visitAnnotation(annotationTypeAsm, annotation.isVisible());

        Map<String, Object> values = annotation.getValues();

        for (Map.Entry<String, Object> stringObjectEntry : values.entrySet()) {
            Common.visitAnnotationValue(annotationVisitor, stringObjectEntry.getKey(), stringObjectEntry.getValue());
        }

        annotationVisitor.visitEnd();
    }

    public static void visitAnnotationValue(org.objectweb.asm.AnnotationVisitor annotationVisitor, String key, Object value) {

        if (value.getClass().isArray()) {
            Object[] values = (Object[]) value;

            if (Arrays.stream(values).filter(o -> o instanceof Annotation || o instanceof EnumValue).findAny().isPresent()) {
                AnnotationVisitor annotationVisitor1 = annotationVisitor.visitArray(key);

                for (Object o : values) {
                    Common.visitAnnotationValue(annotationVisitor1, "", o);
                }

                annotationVisitor1.visitEnd();

                return;
            }
        }

        if (value instanceof EnumValue) {
            EnumValue enumValue = (EnumValue) value;
            annotationVisitor.visitEnum(enumValue.getName(), Common.codeTypeToFullAsm(enumValue.getEnumType()), enumValue.getEnumValue());

            return;
        }

        if (value instanceof Annotation) {
            Annotation annotation = (Annotation) value;
            String asmType = Common.codeTypeToFullAsm(annotation.getType().orElseThrow(NullPointerException::new));

            AnnotationVisitor visitor2 = annotationVisitor.visitAnnotation(key, asmType);

            for (Map.Entry<String, Object> stringObjectEntry : annotation.getValues().entrySet()) {
                Common.visitAnnotationValue(visitor2, stringObjectEntry.getKey(), stringObjectEntry.getValue());
            }

            visitor2.visitEnd();
        }

        if (value instanceof CodeType) {
            value = Type.getType(Common.codeTypeToFullAsm(((CodeType) value)));
        }

        annotationVisitor.visit(key, value);
    }




    //////////////////////////////////////////////////
    //              Find Super or This              //
    //////////////////////////////////////////////////

    public static boolean isInitForThat(TypeDeclaration typeDeclaration, MethodInvocation methodInvocation) {
        boolean any = ((typeDeclaration instanceof Extender) && ((Extender) typeDeclaration).getSuperType().filter(c -> methodInvocation.getLocalization().orElse(null).compareTo(c) == 0).isPresent());

        boolean accept = (methodInvocation.getTarget().orElse(null) instanceof AccessThis || methodInvocation.getTarget().orElse(null) instanceof AccessSuper);

        return any
                && accept
                && methodInvocation.getInvokeType().equals(InvokeType.INVOKE_SPECIAL)

                && methodInvocation.getSpec().getMethodName().equals("<init>");

    }

    public static SearchResult searchForInitTo(TypeDeclaration typeDeclaration, CodeSource codeParts, Predicate<CodePart> targetAccessPredicate) {
        return Common.searchForInitTo(typeDeclaration, codeParts, true, targetAccessPredicate, false);
    }

    public static SearchResult searchForInitTo(TypeDeclaration typeDeclaration, CodeSource codeParts, boolean includeChild, Predicate<CodePart> targetAccessPredicate, boolean isSub) {
        if (codeParts == null)
            return SearchResult.FALSE;

        for (CodePart codePart : codeParts) {
            if ((codePart instanceof Bodied && includeChild)) {
                SearchResult searchResult = searchForInitTo(typeDeclaration, ((Bodied) codePart).getBody().orElse(null), includeChild, targetAccessPredicate, true);

                if(searchResult.found)
                    return searchResult;

            }

            if(codePart instanceof CodeSource) { // Another CodeSource is part of the Enclosing Source
                SearchResult searchResult = searchForInitTo(typeDeclaration, ((CodeSource) codePart), includeChild, targetAccessPredicate, true);

                if(searchResult.found)
                    return searchResult;
            }

            if (codePart instanceof MethodInvocation) {
                MethodInvocation mi = (MethodInvocation) codePart;

                boolean any = ((typeDeclaration instanceof Extender) && ((Extender) typeDeclaration).getSuperType().filter(c -> mi.getLocalization().orElse(null).compareTo(c) == 0).isPresent());

                if (any
                        && targetAccessPredicate.test(mi.getTarget().orElse(null))
                        && mi.getInvokeType().equals(InvokeType.INVOKE_SPECIAL)

                        && mi.getSpec().getMethodName().equals("<init>")) {
                    return new SearchResult(true, isSub);
                }
            }

        }

        return SearchResult.FALSE;
    }

    public static boolean searchInitThis(TypeDeclaration typeDeclaration, CodeSource codeParts, boolean validate) {
        SearchResult searchResult = Common.searchForInitTo(typeDeclaration, codeParts, !validate, codePart -> codePart instanceof AccessThis, false);

        if(validate)
            searchResult = Common.validateConstructor(searchResult);

        return searchResult.found;
    }

    public static boolean searchForSuper(TypeDeclaration typeDeclaration, CodeSource codeParts, boolean validate) {
        SearchResult searchResult = Common.searchForInitTo(typeDeclaration, codeParts, !validate, codePart -> codePart instanceof AccessSuper, false);

        if(validate)
            searchResult = Common.validateConstructor(searchResult);

        return searchResult.found;
    }

    public static SearchResult validateConstructor(SearchResult searchResult) {
        if(searchResult.foundOnSub)
            throw new IllegalArgumentException("Don't invoke super() or this() inside a Bodied Element.");

        return searchResult;
    }

    static final class SearchResult {
        public final boolean found;
        public final boolean foundOnSub;

        public static final SearchResult FALSE = new SearchResult(false, false);

        private SearchResult(boolean found, boolean foundOnSub) {
            this.found = found;
            this.foundOnSub = foundOnSub;
        }
    }


    public static void declareFinalFields(VisitorGenerator<?> visitorGenerator, CodeSource methodBody, TypeDeclaration typeDeclaration, MethodVisitor mv, MapData extraData, MVData mvData, boolean validate) {

        if (Common.searchInitThis(typeDeclaration, methodBody, validate)) {
            return;
        }

        /**
         * Declare variables
         */
        Collection<FieldDeclaration> all = CodeSourceUtil.find(
                typeDeclaration.getBody().orElseThrow(NullPointerException::new),
                codePart ->
                        codePart instanceof CodeField
                                && !((CodeField) codePart).getModifiers().contains(CodeModifier.STATIC)
                                && ((CodeField) codePart).getValue().isPresent(),
                codePart -> (CodeField) codePart);


        Label label = new Label();
        mv.visitLabel(label);

        for (FieldDeclaration codeField : all) {

            Optional<CodePart> valueOpt = codeField.getValue();

            if (valueOpt.isPresent()) {
                CodePart value = valueOpt.get();
                // No visitor overhead.
                mv.visitVarInsn(Opcodes.ALOAD, 0);

                visitorGenerator.generateTo(value.getClass(), value, extraData, null, mvData);

                // No visitor overhead.
                mv.visitFieldInsn(Opcodes.PUTFIELD, Common.codeTypeToSimpleAsm(typeDeclaration), codeField.getName(), Common.codeTypeToFullAsm(codeField.getType().get()));
            }

        }
    }


    public static void generateSuperInvoke(TypeDeclaration typeDeclaration, MethodVisitor mv) {
        mv.visitVarInsn(Opcodes.ALOAD, 0);

        CodeType superType = ((Extender) typeDeclaration).getSuperType().orElse(null);

        if (superType == null) {
            // No visitor overhead.
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        } else {
            // No visitor overhead.
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, Common.codeTypeToSimpleAsm(superType), "<init>", "()V", false);
        }
    }

    public static CodeSource finalFieldsToSource(CodeSource classSource) {
        MutableCodeSource codeSource = new MutableCodeSource();

        /**
         * Declare variables
         */
        Collection<FieldDeclaration> all = CodeSourceUtil.find(
                classSource,
                codePart ->
                        codePart instanceof CodeField
                                && !((CodeField) codePart).getModifiers().contains(CodeModifier.STATIC)
                                && ((CodeField) codePart).getValue().isPresent(),
                codePart -> (CodeField) codePart);

        for (FieldDeclaration codeField : all) {

            CodeType type = codeField.getVariableType();
            String name = codeField.getName();
            Optional<CodePart> value = codeField.getValue();

            if (value.isPresent()) {
                codeSource.add(Helper.setThisVariable(name, type, value.get()));
            }
        }

        return codeSource;
    }
}
