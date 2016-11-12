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

import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;

import java.util.Collection;
import java.util.StringJoiner;

public class GenericUtil {

    public static String genericTypesToAsmString(TypeDeclaration typeDeclaration, CodeType superClass, Collection<CodeType> implementations, boolean superClassIsGeneric, boolean anyInterfaceIsGeneric) {
        GenericType[] types = typeDeclaration.getGenericSignature().getTypes();

        String genericRepresentation = null;

        if (types.length > 0) {
            genericRepresentation = GenericUtil.genericTypesToAsmString(types);
        }

        if (types.length > 0 || superClassIsGeneric || anyInterfaceIsGeneric) {

            if (genericRepresentation == null)
                genericRepresentation = "";

            genericRepresentation += CodeTypeUtil.toAsm(superClass);
        }

        if (types.length > 0 || anyInterfaceIsGeneric) {
            StringBuilder sb = new StringBuilder();

            implementations.forEach(codeType -> sb.append(CodeTypeUtil.toAsm(codeType)));

            genericRepresentation += sb.toString();
        }

        return genericRepresentation;
    }

    public static String genericSignatureToAsmString(GenericSignature<? extends GenericType> signature) {
        GenericType[] types = signature.getTypes();

        if(types.length == 1 && types[0].isType())
            return GenericUtil.genericTypeToAsmString(types[0]);
        else
            return GenericUtil.genericTypesToAsmString(types);
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

        return name + (!generic.isType() ? ":" : "") + (gen2 ? ":" : "") + boundToMain(generic.isWildcard(), generic.bounds());

    }

    public static String bounds(boolean isWildcard, GenericType.Bound<CodeType>[] bounds) {

        StringBuilder sb = new StringBuilder();

        for (GenericType.Bound<CodeType> bound : bounds) {

            CodeType boundType = bound.getType();

            if (boundType instanceof GenericType && !((GenericType) boundType).isType()) {
                sb.append(isWildcard ? bound.sign() : "").append(CodeTypeUtil.toAsm(boundType));
            } else {
                sb.append(isWildcard ? bound.sign() : "").append(CodeTypeUtil.toAsm(boundType));
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
                sb.append(isWildcard ? bound.sign() : "").append(CodeTypeUtil.toAsm(boundType)).append(!isLast ? ":" : "");
            } else {
                sb.append(isWildcard ? bound.sign() : "").append(CodeTypeUtil.toAsm(boundType)).append(!isLast ? ":" : "");
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

            codeMethod.getParameters().stream().map(parameter -> CodeTypeUtil.toAsm(parameter.getRequiredType())).forEach(signatureBuilder::append);

            signatureBuilder.append(')');
        }

        if (generateGenerics) {
            signatureBuilder.append(CodeTypeUtil.toAsm(returnType));
        }

        return signatureBuilder.length() > 0 ? signatureBuilder.toString() : null;

    }


}
