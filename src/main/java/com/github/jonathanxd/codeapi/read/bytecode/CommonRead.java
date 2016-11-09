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
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.read.Environment;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.Generic;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.GenericTypeUtil;
import com.github.jonathanxd.codeapi.util.description.DescriptionUtil;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.Common;

import org.objectweb.asm.Opcodes;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

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

    public static CodeType toCodeType(Environment environment, String typeStr, boolean isInterface) {
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

        //String simpleName = typeStr.contains(".") ? typeStr.substring(typeStr.lastIndexOf('.') + 1, typeStr.length()) : typeStr;

        return environment.getType(typeStr, isInterface);
    }

    public static boolean is(int byte1_, int byte2_) {
        return (byte2_ & byte1_) != 0;
    }


    public static GenericSignature<GenericType> genericSigFromString(Environment environment, String str) {
        if (str == null || str.isEmpty()) {
            return GenericSignature.empty();
        } else {

            StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);

            Function<String, CodeType> func = s -> CommonRead.toCodeType(environment, s, false);

            if(str.startsWith("<")) {
                return parse(stringCharacterIterator, func);
            } else {
                return GenericSignature.create(parseTypeOrVar(stringCharacterIterator, func));
            }

        }
    }

    public static GenericSignature<GenericType> parse(CharacterIterator signature, Function<String, CodeType> typeResolver) {
        StringBuilder stringBuilder = new StringBuilder();

        while(signature.current() != ':') {
            if(signature.current() == CharacterIterator.DONE) {
                return GenericSignature.empty();
            }
            if(signature.current() != '<') {
                stringBuilder.append(signature.current());
            }

            signature.next();
        }

        signature.next();

        Generic x = Generic.type(stringBuilder.toString());

        Generic generic = parseTypeOrVar(signature, typeResolver);
        return GenericSignature.create(x.extends$(generic));
    }

    public static Generic parseTypeOrVar(CharacterIterator signature, Function<String, CodeType> typeResolver) {
        if(signature.current() == ':') {
            signature.next();
        }

        if(signature.current() == CharacterIterator.DONE) {
            return null;
        }

        return parseNameType(signature, typeResolver);
    }

    public static Generic parseNameType(CharacterIterator signature, Function<String, CodeType> typeResolver) {
        char current = signature.current();

        if(current == 'L') {
            return parseJavaClass(signature,  typeResolver);
        }else if(current == 'T') {
            return parseVar(signature);
        }

        return null;
    }

    public static Generic parseJavaClass(CharacterIterator signature, Function<String, CodeType> typeResolver) {
        StringBuilder sb = new StringBuilder();

        signature.next();

        if(signature.current() == CharacterIterator.DONE) {
            return null;
        }

        Generic generic = null;

        while (signature.current() != ';' && signature.current() != '>' && signature.current() != CharacterIterator.DONE) {

            if(signature.current() == '<') {
                String name = sb.toString();

                generic = Generic.type(typeResolver.apply(name));

                signature.next();

                do {
                    Generic bound = parseTypeOrVar(signature, typeResolver);
                    generic = generic.of(bound);
                }while (signature.current() != '>');

            }

            sb.append(signature.current());

            signature.next();
        }

        if(signature.current() == CharacterIterator.DONE)
            return null;
        signature.next();

        if(generic != null) {
            return generic;
        } else {
            return Generic.type(typeResolver.apply(sb.toString()));
        }
    }

    public static Generic parseVar(CharacterIterator signature) {
        StringBuilder sb = new StringBuilder();

        signature.next();
        while (signature.current() != ';' && signature.current() != '>' && signature.current() != CharacterIterator.DONE) {
            sb.append(signature.current());
            signature.next();
        }

        if(signature.current() == CharacterIterator.DONE) {
            return null;
        }

        if(signature.current() == ';') {
            signature.next();
        }

        return Generic.type(sb.toString());
    }

    public static GenericSignature<GenericType> parseSignature(String generic) {
        char[] chars = generic.toCharArray();

        StringBuilder sb = new StringBuilder();
        int ct = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if(c == '<' && ct == 0) {
                ++ct;
            }else if(c == '>') {
                sb.append(c);
                if(ct == 1) {
                    String s = sb.toString();
                    sb.setLength(0);

                    GenericType genericType = parseType(s);

                    return GenericSignature.create(genericType);
                }
                --ct;
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb);

        return GenericSignature.create(parseType(generic));
    }

    public static Generic parseType(String generic) {
        char[] chars = generic.toCharArray();

        String name = null;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if(c == ':') {
                if(stringBuilder.length() > 0) {
                    name = stringBuilder.toString();
                    stringBuilder.setLength(0);
                }
            } else {
                stringBuilder.append(c);
            }

        }

        if(name == null) {
            String s = stringBuilder.toString();
            for (char c : s.toCharArray()) {
                if(c == 'L') {

                }
            }
        }

        Generic type = Generic.type(name);

        Generic type1 = parseType(stringBuilder.toString());

        if(type1 != null) {
            type = type.of(type1);
        }

        return type;
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


    public static TypeSpec typeSpecFromDesc(Environment environment, TypeDeclaration typeDeclaration, String methodName, String desc) {
        desc = typeDeclaration.getJavaSpecName() + ":" + methodName + desc;

        String[] parameterTypes = DescriptionUtil.getParameterTypes(desc);
        String returnType = DescriptionUtil.getReturnType(desc);

        return new TypeSpec(CommonRead.toCodeType(environment, returnType, false),
                Arrays.stream(parameterTypes)
                        .map(s -> CommonRead.toCodeType(environment, s, false)).toArray(CodeType[]::new));
    }
}
