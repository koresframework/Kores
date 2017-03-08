/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.util;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.type.Generic;
import com.github.jonathanxd.codeapi.type.GenericType;
import com.github.jonathanxd.codeapi.type.PlainCodeType;
import com.github.jonathanxd.iutils.condition.Conditions;
import com.github.jonathanxd.iutils.type.TypeInfo;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility of generic types.
 */
public class GenericTypeUtil {

    private static final Pattern TYPE_VAR_REGEX = Pattern.compile("(([A-Za-z0-9_?]*) (extends|super) ).*");

    /**
     * Convert generic signature to string.
     *
     * @param genericSignature Generic signature.
     * @return Generic signature string.
     */
    public static String toSourceString(GenericSignature genericSignature) {
        StringBuilder sb = new StringBuilder();

        GenericType[] types = genericSignature.getTypes();

        for (int i = 0; i < types.length; i++) {
            boolean hasNext = i + 1 < types.length;

            GenericType genericType = types[i];

            sb.append(GenericTypeUtil.toSourceString(genericType));

            if (hasNext)
                sb.append(",");
        }

        return sb.toString();
    }

    /**
     * Convert generic type to string.
     *
     * @param genericType Generic type.
     * @return Generic type string.
     */
    public static String toSourceString(GenericType genericType) {

        StringBuilder sb = new StringBuilder();

        if (genericType.isType()) {
            sb.append(genericType.getCanonicalName());
        } else {
            if (!genericType.isWildcard()) {
                sb.append(genericType.getName());
            } else {
                sb.append("?");
            }
        }


        GenericType.Bound[] bounds = genericType.getBounds();

        if (bounds.length != 0) {

            for (int i = 0; i < bounds.length; i++) {

                boolean hasNext = i + 1 < bounds.length;

                GenericType.Bound bound = bounds[i];

                boolean extendsOrSuper = bound.getSign().equals("+") || bound.getSign().equals("-");

                if (bound.getSign().equals("+")) {
                    sb.append(" extends ");
                } else if (bound.getSign().equals("-")) {
                    sb.append(" super ");
                } else {
                    if (i == 0) {
                        sb.append("<");
                    }
                }

                CodeType type = bound.getType();

                if (type instanceof GenericType) {
                    sb.append(toSourceString((GenericType) type));
                } else {
                    sb.append(type.getCanonicalName());
                }

                if (!extendsOrSuper && !hasNext) {
                    sb.append(">");
                }

                if (hasNext && extendsOrSuper) {
                    sb.append(" &");
                } else if (hasNext) {
                    sb.append(", ");
                }
            }

        }

        return sb.toString();
    }

    /**
     * Parse {@link String generic source string} and construct {@link GenericType}.
     *
     * @param sourceString Source string.
     * @return Construct a {@link GenericType} from {@code generic source string};
     */
    public static GenericType fromSourceString(String sourceString) {
        return GenericTypeUtil.fromSourceString(sourceString, s -> {
            try {
                return CodeAPI.getJavaType(TypeInfo.resolveClass(s));
            } catch (Exception e) {
                return new PlainCodeType(s, false);
            }
        });
    }

    /**
     * Parse {@link String generic source string} and construct {@link GenericType}.
     *
     * @param sourceString Source string.
     * @param typeResolver Resolves {@link CodeType} from {@link String string type}.
     * @return Construct a {@link GenericType} from {@code generic source string};
     */
    public static GenericType fromSourceString(String sourceString, Function<String, CodeType> typeResolver) {
        return GenericTypeUtil.fromSourceString(sourceString, CodeTypeResolver.Companion.fromJavaFunction(typeResolver));
    }

    /**
     * Parse {@link String generic source string} and construct {@link GenericType}.
     *
     * @param sourceString Source string.
     * @param typeResolver Resolves {@link CodeType} from {@link String string type}.
     * @return Construct a {@link GenericType} from {@code generic source string};
     */
    public static GenericType fromSourceString(String sourceString, CodeTypeResolver typeResolver) {
        if (sourceString.contains("<")) {
            Conditions.require(sourceString.endsWith(">"), "The input generic string: '" + sourceString + "' MUST end with '>'.");

            String type = GenericTypeUtil.extractType(sourceString);
            String generic = GenericTypeUtil.extractGeneric(sourceString);

            CodeType apply = typeResolver.invoke(type);

            Generic genericType = Generic.type(apply);

            return GenericTypeUtil.fromSourceString(genericType, generic, typeResolver);
        }

        return Generic.type(typeResolver.invoke(sourceString));
    }

    private static Generic fromSourceString(Generic generic, String sourceString, CodeTypeResolver typeResolver) {

        String[] types;

        if (StringsKt.containsBefore(sourceString, ",", "<"))
            types = sourceString.split(",");
        else
            types = new String[]{sourceString};

        for (String type_ : types) {
            type_ = type_.trim(); // Remove unnecessary space.
            boolean containsTag = type_.contains("<");

            String genericStr = containsTag ? GenericTypeUtil.extractGeneric(type_) : null;
            type_ = containsTag ? GenericTypeUtil.extractType(type_) : type_;

            Matcher matcher = TYPE_VAR_REGEX.matcher(type_);

            if(matcher.matches()) {
                type_ = type_.substring(matcher.group(1).length());

                String varName = matcher.group(2);
                boolean isWildcard = varName.equals("?");

                boolean isExtends = matcher.group(3).equals("extends");

                Generic base = isWildcard ? Generic.wildcard() : Generic.type(varName);

                CodeType codeType = genericStr == null ? typeResolver.invoke(type_) : GenericTypeUtil.fromSourceString(type_ + "<" + genericStr + ">", typeResolver);

                if (isExtends) {
                    generic = generic.of(base.extends$(codeType));
                } else /* if(isSuper) */{
                    generic = generic.of(base.super$(codeType));
                }

            } else {

                if(type_.equals("?")) {
                    generic = generic.of(Generic.wildcard());
                } else {
                    CodeType codeType = genericStr == null ? typeResolver.invoke(type_) : GenericTypeUtil.fromSourceString(type_ + "<" + genericStr + ">", typeResolver);

                    generic = generic.of(codeType);
                }
            }

        }


        return generic;

    }

    private static String extractType(String str) {
        return str.substring(0, str.indexOf("<"));
    }

    private static String extractGeneric(String str) {
        return str.substring(str.indexOf("<") + 1, str.lastIndexOf(">"));
    }

}
