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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.TypeResolver;
import com.github.jonathanxd.iutils.description.Description;

import java.util.ArrayList;
import java.util.List;

public class ArgumentUtil {
    public static List<CodeArgument> createArguments(Description description, List<CodePart> arguments, TypeResolver typeResolver) {
        String[] parameterTypes = description.getParameterTypes();

        if (parameterTypes.length != arguments.size())
            throw new IllegalArgumentException("Parameter types size doesn't matches arguments size.");

        List<CodeArgument> codeArgumentList = new ArrayList<>();

        for (int i = 0; i < parameterTypes.length; i++) {
            String parameterTypeStr = parameterTypes[i];
            CodeType parameterType = typeResolver.resolveUnknown(parameterTypeStr);

            CodePart codePart = arguments.get(i);

            codeArgumentList.add(new CodeArgument(codePart, parameterType));

        }

        return codeArgumentList;
    }
}
