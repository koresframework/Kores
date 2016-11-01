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
import com.github.jonathanxd.codeapi.CodeElement;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InnerType;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.common.MemberInfo;
import com.github.jonathanxd.codeapi.common.MemberInfos;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl;
import com.github.jonathanxd.codeapi.inspect.SourceInspect;
import com.github.jonathanxd.codeapi.interfaces.AccessSuper;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.ClassDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.EnumDeclaration;
import com.github.jonathanxd.codeapi.interfaces.EnumEntry;
import com.github.jonathanxd.codeapi.interfaces.EnumValue;
import com.github.jonathanxd.codeapi.interfaces.Extender;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.AnnotationVisitorCapable;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.codeapi.util.source.CodeArgumentUtil;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.optional.Require;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
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
import java.util.TreeSet;
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

    public static int innerModifierToAsm(TypeDeclaration typeDeclaration) {
        return (!typeDeclaration.isInterface() ? Opcodes.ACC_SUPER : 0) +
                Common.modifierToAsm(typeDeclaration.getModifiers(), typeDeclaration.getClassType().isInterface());
    }

    public static int modifierToAsm(TypeDeclaration typeDeclaration) {
        Collection<CodeModifier> modifiers = new ArrayList<>(typeDeclaration.getModifiers());

        if (modifiers.contains(CodeModifier.STATIC))
            modifiers.remove(CodeModifier.STATIC);

        return (!typeDeclaration.isInterface() ? Opcodes.ACC_SUPER : 0) +
                Common.modifierToAsm(modifiers, typeDeclaration.getClassType().isInterface());
    }

    public static int modifierToAsm(Collection<CodeModifier> codeModifiers) {
        return CodeModifier.toAsmAccess(codeModifiers);
    }

    public static int modifierToAsm(Collection<CodeModifier> codeModifiers, boolean isInterface) {
        return (isInterface ? Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE : 0) + CodeModifier.toAsmAccess(codeModifiers);
    }

    public static String getClassName(TypeDeclaration class_) {
        return Common.codeTypeToSimpleAsm(class_);
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

    public static String getNewInnerName(String name, TypeDeclaration typeDeclaration) {
        List<TypeDeclaration> inspect = SourceInspect.find(codePart -> codePart instanceof TypeDeclaration)
                .includeSource(true)
                .include(bodied -> bodied instanceof CodeSource)
                .mapTo(codePart -> (TypeDeclaration) codePart)
                .inspect(typeDeclaration.getBody().orElse(CodeSource.empty()));

        while (Common.contains(name, inspect))
            name += "$1";

        return name;
    }

    public static String getNewName(String name, List<? extends Named> nameds) {
        while (Common.contains(name, nameds))
            name += "$1";

        return name;
    }

    public static String getNewName(String name, CodeSource source) {
        List<CodeField> inspect = SourceInspect.find(codePart -> codePart instanceof CodeField)
                .includeSource(true)
                .include(bodied -> bodied instanceof CodeSource)
                .mapTo(codePart -> (CodeField) codePart)
                .inspect(source);

        while (Common.contains(name, inspect))
            name += "$1";

        return name;
    }

    public static String getNewMethodName(String name, CodeSource source) {
        List<CodeMethod> inspect = SourceInspect.find(codePart -> codePart instanceof CodeMethod)
                .includeSource(true)
                .include(bodied -> bodied instanceof CodeSource)
                .mapTo(codePart -> (CodeMethod) codePart)
                .inspect(source);

        while (Common.contains(name, inspect))
            name += "$1";

        return name;
    }

    public static boolean contains(String name, List<? extends Named> codeFields) {
        for (Named named : codeFields) {
            if (named.getName().equals(name))
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
                if (!genericType.isType()) {
                    return fixResult("T" + name + ";"/*(genericType.isType() ? ";" : "")*/);
                } else {
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
        boolean any = methodInvocation.getSpec().getMethodType() == MethodType.SUPER_CONSTRUCTOR;

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

                if (searchResult.found)
                    return searchResult;

            }

            if (codePart instanceof CodeSource) { // Another CodeSource is part of the Enclosing Source
                SearchResult searchResult = searchForInitTo(typeDeclaration, ((CodeSource) codePart), includeChild, targetAccessPredicate, true);

                if (searchResult.found)
                    return searchResult;
            }

            if (codePart instanceof MethodInvocation) {
                MethodInvocation mi = (MethodInvocation) codePart;

                if (mi.getSpec().getMethodType() == MethodType.SUPER_CONSTRUCTOR
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

        if (validate)
            searchResult = Common.validateConstructor(searchResult);

        return searchResult.found;
    }

    public static boolean searchForSuper(TypeDeclaration typeDeclaration, CodeSource codeParts, boolean validate) {
        SearchResult searchResult = Common.searchForInitTo(typeDeclaration, codeParts, !validate, codePart -> codePart instanceof AccessSuper, false);

        if (validate)
            searchResult = Common.validateConstructor(searchResult);

        return searchResult.found;
    }

    public static SearchResult validateConstructor(SearchResult searchResult) {
        if (searchResult.foundOnSub)
            throw new IllegalArgumentException("Don't invoke super() or this() inside a Bodied Element.");

        return searchResult;
    }

    public static Collection<CodeModifier> getEnumModifiers(EnumDeclaration enumDeclaration) {
        Collection<CodeModifier> modifiers = new TreeSet<>(enumDeclaration.getModifiers());

        modifiers.add(CodeModifier.ENUM);

        if (enumDeclaration.getEntries().stream().anyMatch(Bodied::hasBody)) {
            modifiers.add(CodeModifier.ABSTRACT);
        } else {
            modifiers.add(CodeModifier.FINAL);
        }

        return modifiers;
    }

    public static CodeSource generateEnumClassSource(EnumDeclaration enumDeclaration) {
        List<FieldDeclaration> fields = new ArrayList<>();
        List<EnumEntry> entries = enumDeclaration.getEntries();
        List<TypeDeclaration> innerClasses = new ArrayList<>();

        MutableCodeSource codeSource = new MutableCodeSource();

        for (int i = 0; i < entries.size(); i++) {
            EnumEntry enumEntry = entries.get(i);
            CodePart value;

            if (enumEntry.hasBody()) {

                TypeDeclaration typeDeclaration = Common.genEnumInnerClass(enumDeclaration, enumEntry);

                innerClasses.add(typeDeclaration);

                value = Common.callConstructor(typeDeclaration, enumEntry, i);
            } else {
                value = Common.callConstructor(enumDeclaration, enumEntry, i);
            }

            fields.add(CodeAPI.field(Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL | CodeModifier.Internal.ENUM, enumDeclaration, enumEntry.getName(),
                    value));
        }

        codeSource.addAll(fields);

        String valuesFieldName = Common.getNewName("$VALUES", codeSource);

        int fieldSize = fields.size();

        CodeType arrayType = enumDeclaration.toArray(1);

        CodeArgument[] arrayArguments = fields.stream()
                .map(fieldDeclaration -> CodeAPI.argument(CodeAPI.accessStaticField(fieldDeclaration.getVariableType(), fieldDeclaration.getName()), fieldDeclaration.getVariableType()))
                .toArray(CodeArgument[]::new);

        CodeField valuesField = CodeAPI.field(Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL | CodeModifier.Internal.SYNTHETIC, arrayType, valuesFieldName,
                CodeAPI.arrayConstruct(enumDeclaration, new CodePart[]{Literals.INT(fieldSize)}, arrayArguments));

        codeSource.add(valuesField);

        MutableCodeSource source = enumDeclaration.getBody().map(MutableCodeSource::new).orElse(new MutableCodeSource());

        // Gen methods
        fixConstructor(enumDeclaration, source);

        codeSource.addAll(source);

        // Enum.values() method.
        codeSource.add(CodeAPI.methodBuilder()
                .withModifiers(Modifier.PUBLIC | Modifier.STATIC)
                .withName("values")
                .withReturnType(arrayType)
                .withBody(CodeAPI.sourceOfParts(
                        CodeAPI.returnValue(arrayType, CodeAPI.cast(PredefinedTypes.OBJECT, arrayType, CodeAPI.invokeVirtual(arrayType, CodeAPI.accessStaticField(valuesField.getVariableType(), valuesField.getName()),
                                "clone", CodeAPI.typeSpec(PredefinedTypes.OBJECT))))

                ))
                .build());

        // Enum.valueOf(String) method.
        codeSource.add(CodeAPI.methodBuilder()
                .withModifiers(Modifier.PUBLIC | Modifier.STATIC)
                .withName("valueOf")
                .withParameters(CodeAPI.parameter(PredefinedTypes.STRING, "name"))
                .withReturnType(enumDeclaration)
                .withBody(CodeAPI.sourceOfParts(
                        CodeAPI.returnValue(PredefinedTypes.ENUM, CodeAPI.cast(PredefinedTypes.ENUM, enumDeclaration,
                                CodeAPI.invokeStatic(PredefinedTypes.ENUM, "valueOf", CodeAPI.typeSpec(
                                        PredefinedTypes.ENUM,
                                        PredefinedTypes.CLASS,
                                        PredefinedTypes.STRING),
                                        CodeAPI.argument(Literals.CLASS(enumDeclaration)),
                                        CodeAPI.argument(CodeAPI.accessLocalVariable(PredefinedTypes.STRING, "name")))))

                ))
                .build());

        for (TypeDeclaration innerClass : innerClasses) {
            codeSource.add(innerClass);
        }

        return codeSource;
    }

    private static CodePart callConstructor(TypeDeclaration location, EnumEntry enumEntry, int ordinal) {
        Optional<TypeSpec> constructorSpecOpt = enumEntry.getConstructorSpec();

        List<CodeArgument> arguments = new ArrayList<>();

        arguments.add(CodeAPI.argument(Literals.STRING(enumEntry.getName())));
        arguments.add(CodeAPI.argument(Literals.INT(ordinal)));

        TypeSpec spec = new TypeSpec(PredefinedTypes.VOID, PredefinedTypes.STRING, PredefinedTypes.INT);

        if (constructorSpecOpt.isPresent()) {
            TypeSpec typeSpec = constructorSpecOpt.get();

            List<CodeType> parameterTypes = new ArrayList<>(spec.getParameterTypes());

            parameterTypes.addAll(typeSpec.getParameterTypes());

            spec = spec.setParameterTypes(parameterTypes);

            arguments.addAll(enumEntry.getArguments());
        }

        return CodeAPI.invokeConstructor(location, spec, arguments);
    }

    private static void fixConstructor(EnumDeclaration enumDeclaration, MutableCodeSource originalSource) {
        List<ConstructorDeclaration> inspect = SourceInspect.find(codePart -> codePart instanceof ConstructorDeclaration)
                .include(bodied -> bodied instanceof CodeSource)
                .includeSource(true)
                .mapTo(codePart -> (ConstructorDeclaration) codePart)
                .inspect(originalSource);

        if (inspect.isEmpty()) {
            originalSource.add(CodeAPI.constructor(Modifier.PROTECTED | CodeModifier.Internal.SYNTHETIC, CodeAPI.parameters(CodeAPI.parameter(PredefinedTypes.STRING, "name"),
                    CodeAPI.parameter(PredefinedTypes.INT, "ordinal")),
                    ctr -> CodeAPI.sourceOfParts(
                            CodeAPI.invokeSuperConstructor(CodeAPI.constructorTypeSpec(PredefinedTypes.STRING, PredefinedTypes.INT),
                                    CodeAPI.argument(CodeAPI.accessLocalVariable(PredefinedTypes.STRING, "name")),
                                    CodeAPI.argument(CodeAPI.accessLocalVariable(PredefinedTypes.INT, "ordinal")))
                    )));
            // generate
        } else {
            // modify
            for (ConstructorDeclaration constructorDeclaration : inspect) {
                List<CodeParameter> parameters = new ArrayList<>(constructorDeclaration.getParameters());

                String name = Common.getNewName("$name", parameters);
                String ordinal = Common.getNewName("$ordinal", parameters);

                parameters.addAll(0, Arrays.asList(
                        CodeAPI.parameter(PredefinedTypes.STRING, name),
                        CodeAPI.parameter(PredefinedTypes.INT, ordinal)));

                MutableCodeSource source = constructorDeclaration.getBody().map(MutableCodeSource::new).orElse(new MutableCodeSource());

                source.add(0, Helper.invokeSuperInit(PredefinedTypes.ENUM,
                        CodeAPI.argument(CodeAPI.accessLocalVariable(PredefinedTypes.STRING, name), PredefinedTypes.STRING),
                        CodeAPI.argument(CodeAPI.accessLocalVariable(PredefinedTypes.INT, ordinal), PredefinedTypes.INT)));

                originalSource.remove(constructorDeclaration);

                originalSource.add(constructorDeclaration.setBody(source).setParameters(parameters));
            }
        }
    }

    private static TypeDeclaration genEnumInnerClass(EnumDeclaration enumDeclaration, EnumEntry enumEntry) {
        Optional<TypeSpec> typeSpecOpt = enumEntry.getConstructorSpec();

        List<CodeParameter> baseParameters = Common.getEnumBaseParameters("$name", "$ordinal");
        CodeArgument[] arguments;

        if (typeSpecOpt.isPresent()) {
            TypeSpec typeSpec = typeSpecOpt.get();

            List<CodeType> parameterTypes = typeSpec.getParameterTypes();

            for (int i = 0; i < parameterTypes.size(); i++) {
                baseParameters.add(CodeAPI.parameter(parameterTypes.get(i), "$" + i));
            }
        }

        arguments = CodeArgumentUtil.argumentsFromParameters(baseParameters).stream().toArray(CodeArgument[]::new);
        TypeSpec constructorSpec = CodeAPI.constructorTypeSpec(
                baseParameters.stream()
                        .map(CodeParameter::getRequiredType)
                        .toArray(CodeType[]::new)
        );

        String enumEntryName = Common.getNewInnerName(enumEntry.getName() + "$Inner", enumDeclaration);

        MutableCodeSource body = enumEntry.getBody().orElseThrow(NullPointerException::new).toMutable();

        body.add(CodeAPI.constructorBuilder()
                .withParameters(baseParameters)
                .withBody(CodeAPI.sourceOfParts(
                        CodeAPI.invokeSuperConstructor(constructorSpec, arguments)
                ))
                .build());

        return CodeAPI.aClassBuilder()
                .withOuterClass(enumDeclaration)
                .withModifiers(Modifier.STATIC | CodeModifier.Internal.ENUM)
                .withQualifiedName(enumEntryName)
                .withSuperClass(enumDeclaration)
                .withBody(body)
                .build();
    }

    private static List<CodeParameter> getEnumBaseParameters(String name, String ordinal) {
        return new ArrayList<>(Arrays.asList(
                CodeAPI.parameter(PredefinedTypes.STRING, name),
                CodeAPI.parameter(PredefinedTypes.INT, ordinal)));
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

    public static void genOuterAccessor(TypeDeclaration outer,
                                        InnerType inner,
                                        MemberInfo memberInfo,
                                        MapData extraData,
                                        VisitorGenerator<BytecodeClass> visitorGenerator) {

        if (!memberInfo.hasAccessibleMember()) {
            CodeElement memberInstance = memberInfo.getMemberInstance();

            MethodDeclaration gen = generatePackagePrivateAccess(outer, memberInstance);

            if(inner == null) {
                visitorGenerator.generateTo(MethodDeclaration.class, gen, Objects.requireNonNull(extraData.getParent()), null);
            } else {
                MutableCodeSource source = outer.getBody().orElse(CodeSource.empty()).toMutable();

                source.add(gen);

                inner.setAdaptedDeclaration(outer.setBody(source));
            }

            memberInfo.setAccessibleMember(gen);
        }
    }

    private static MethodDeclaration generatePackagePrivateAccess(TypeDeclaration outer, CodePart element) {

        if (!(element instanceof Modifierable) || !(element instanceof Typed))
            throw new IllegalArgumentException("Element doesn't match requirements: extends Modifierable & Typed.");


        CodeType type = ((Typed) element).getType().orElseThrow(NullPointerException::new);
        boolean isStatic = ((Modifierable) element).getModifiers().contains(CodeModifier.STATIC);

        Collection<CodeModifier> modifiers = CodeModifier.newModifierSet();

        modifiers.add(CodeModifier.SYNTHETIC);
        if (isStatic) modifiers.add(CodeModifier.STATIC);

        CodePart invk;
        List<CodeParameter> parameters = new ArrayList<>();

        if (element instanceof FieldDeclaration) {
            FieldDeclaration fieldDeclaration = (FieldDeclaration) element;

            if (!isStatic) {
                invk = CodeAPI.accessField(outer, CodeAPI.accessThis(), fieldDeclaration.getVariableType(), fieldDeclaration.getName());
            } else {
                invk = CodeAPI.accessStaticField(outer, fieldDeclaration.getVariableType(), fieldDeclaration.getName());
            }
        } else if (element instanceof MethodDeclaration) {
            MethodDeclaration methodDeclaration = (MethodDeclaration) element;

            parameters.addAll(methodDeclaration.getParameters());

            boolean isConstructor = methodDeclaration.getName().equals("<init>");

            InvokeType invokeType = isStatic ? InvokeType.INVOKE_STATIC :
                    (isConstructor
                            ? InvokeType.INVOKE_SPECIAL
                            : (outer.isInterface()
                            ? InvokeType.INVOKE_INTERFACE
                            : InvokeType.INVOKE_VIRTUAL));

            invk = Helper.invoke(invokeType, outer, isConstructor || isStatic ? outer : CodeAPI.accessThis(),
                    new MethodSpecImpl(methodDeclaration.getName(), methodDeclaration.getReturnType().orElse(PredefinedTypes.VOID),
                            CodeArgumentUtil.argumentsFromParameters(parameters)));
        } else {
            throw new IllegalArgumentException("Cannot process: " + element + "!");
        }

        return CodeAPI.methodBuilder()
                .withName(getNewMethodName("access$000", outer.getBody().orElse(CodeSource.empty())))
                .withModifiers(modifiers)
                .withParameters(parameters)
                .withReturnType(type)
                .withBody(CodeAPI.sourceOfParts(
                        CodeAPI.returnValue(type, invk)
                ))
                .build();
    }

    private static MemberInfo find(MemberInfos infos, CodePart element) {
        if (element instanceof VariableAccess) {
            return infos.find((VariableAccess) element);
        } else if (element instanceof MethodInvocation) {
            return infos.find(((MethodInvocation) element).getSpec());
        }

        throw new IllegalStateException("Invalid part: " + element + ", the part must be a VariableAccess or a MethodInvocation.");
    }

    static final class SearchResult {
        public static final SearchResult FALSE = new SearchResult(false, false);
        public final boolean found;
        public final boolean foundOnSub;

        private SearchResult(boolean found, boolean foundOnSub) {
            this.found = found;
            this.foundOnSub = foundOnSub;
        }
    }
}
