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
package com.github.jonathanxd.codeapi.util.source;

import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.iutils.optional.Require;

import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * Created by jonathan on 21/08/16.
 */
public class CodeArgumentUtil {

    public static CodeArgument[] createChecked(CodeArgument[] expected, CodeArgument[] passed) {

        CodeArgument[] newArguments = new CodeArgument[passed.length];

        for (int i = 0; i < newArguments.length; i++) {
            CodeType type = expected[i].getType().orElse(null);

            newArguments[i] = new CodeArgument(Require.require(passed[i].getValue()), type != null, type);
        }

        return newArguments;

    }

    public static CodeParameter[] fromJavaParameters(Parameter[] parameters) {
        return Arrays.stream(parameters).map(CodeArgumentUtil::lambda$from$javaParameter$to$codeParameter).toArray(CodeParameter[]::new);
    }

    private static CodeParameter lambda$from$javaParameter$to$codeParameter(Parameter parameter) {
        return new CodeParameter(parameter.getName(), Helper.getJavaType(parameter.getType()));
    }

    public static CodeArgument[] argumentsFromParameters(CodeParameter[] parameters) {
        return Arrays.stream(parameters).map(CodeArgumentUtil::lambda$from$parameter$to$argument).toArray(CodeArgument[]::new);
    }

    private static CodeArgument lambda$from$parameter$to$argument(CodeParameter parameter) {
        return new CodeArgument(Helper.accessLocalVariable(parameter.getName(), parameter.getRequiredType()), parameter.getRequiredType());
    }

    public static CodeArgument[] argumentsFromJavaParameters(Parameter[] parameters) {
        return Arrays.stream(parameters).map(CodeArgumentUtil::lambda$from$javaParameter$to$argument).toArray(CodeArgument[]::new);
    }

    private static CodeArgument lambda$from$javaParameter$to$argument(Parameter parameter) {
        return new CodeArgument(Helper.accessLocalVariable(parameter.getName(), Helper.getJavaType(parameter.getType())), true, Helper.getJavaType(parameter.getType()));
    }

}
