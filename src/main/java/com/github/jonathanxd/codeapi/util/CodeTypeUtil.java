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

import com.github.jonathanxd.codeapi.type.CodeType;

import java.lang.invoke.MethodHandles;

public class CodeTypeUtil {
    private static final MethodHandles.Lookup lookup = MethodHandles.lookup();

    public static String resolveRealQualified(String qualifiedName, CodeType outer) {

        if (outer != null) {
            String packageName = outer.getPackageName();

            if (!packageName.isEmpty() && !qualifiedName.startsWith(packageName)) {
                // Prevent duplication of the name
                return CodeTypeUtil.getRealNameStr(qualifiedName, outer);
            }
        }

        return qualifiedName;
    }

    public static String getRealNameStr(String qualified, CodeType outer) {
        return outer.getCanonicalName() + "$" + qualified;
    }

    public static String codeTypeToFullAsm(CodeType type) {
        return type.isPrimitive()
                ? CodeTypeUtil.primitiveCodeTypeToAsm(type)
                : type.getJavaSpecName();//"L" + type.getType().replace('.', '/') + ";";
    }

    public static String primitiveCodeTypeToAsm(CodeType type) {
        return type.getJavaSpecName();
    }

    public static String codeTypeToArray(CodeType codeType, int dimensions) {
        String name = CodeTypeUtil.codeTypeToFullAsm(codeType);

        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < dimensions; ++x)
            sb.append('[');

        return sb.toString() + name;
    }

}
