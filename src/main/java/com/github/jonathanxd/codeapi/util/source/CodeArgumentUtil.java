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
 * Utilities.
 */
public class CodeArgumentUtil {

    /**
     * Create a checked argument array. This method will use value of {@code passed} parameters and
     * types of {@code expected} parameters.
     *
     * @param expected Expected parameters.
     * @param passed   Provided parameters
     * @return Array with checked arguments.
     */
    public static CodeArgument[] createChecked(CodeArgument[] expected, CodeArgument[] passed) {

        CodeArgument[] newArguments = new CodeArgument[passed.length];

        for (int i = 0; i < newArguments.length; i++) {
            CodeType type = expected[i].getType().orElse(null);

            newArguments[i] = new CodeArgument(Require.require(passed[i].getValue()), type != null, type);
        }

        return newArguments;

    }

    /**
     * Convert from {@link Parameter} to {@link CodeParameter}.
     *
     * @param parameters Parameters.
     * @return Converted parameters.
     */
    public static CodeParameter[] fromJavaParameters(Parameter[] parameters) {
        return Arrays.stream(parameters).map(CodeArgumentUtil::lambda$from$javaParameter$to$codeParameter).toArray(CodeParameter[]::new);
    }

    /**
     * Convert from {@link Parameter} to {@link CodeParameter}.
     *
     * @param parameter Parameter.
     * @return Converted parameter.
     */
    private static CodeParameter lambda$from$javaParameter$to$codeParameter(Parameter parameter) {
        return new CodeParameter(parameter.getName(), Helper.getJavaType(parameter.getType()));
    }

    /**
     * Convert from {@link CodeParameter} to {@link CodeArgument}.
     *
     * Parameters will be converted to local access of variables.
     *
     * @param parameters Parameters.
     * @return Converted arguments.
     */
    public static CodeArgument[] argumentsFromParameters(CodeParameter[] parameters) {
        return Arrays.stream(parameters).map(CodeArgumentUtil::lambda$from$parameter$to$argument).toArray(CodeArgument[]::new);
    }

    /**
     * Convert from {@link CodeParameter} to {@link CodeArgument}.
     *
     * Parameter will be converted to local access of variables.
     *
     * @param parameter Parameter.
     * @return Converted argument.
     */
    private static CodeArgument lambda$from$parameter$to$argument(CodeParameter parameter) {
        return new CodeArgument(Helper.accessLocalVariable(parameter.getName(), parameter.getRequiredType()), parameter.getRequiredType());
    }


    /**
     * Convert from {@link Parameter} to {@link CodeArgument}.
     *
     * Parameters will be converted to local access of variables.
     *
     * @param parameters Parameters.
     * @return Converted arguments.
     */
    public static CodeArgument[] argumentsFromJavaParameters(Parameter[] parameters) {
        return Arrays.stream(parameters).map(CodeArgumentUtil::lambda$from$javaParameter$to$argument).toArray(CodeArgument[]::new);
    }

    /**
     * Convert from {@link Parameter} to {@link CodeArgument}.
     *
     * Parameter will be converted to local access of variables.
     *
     * @param parameter Parameter.
     * @return Converted argument.
     */
    private static CodeArgument lambda$from$javaParameter$to$argument(Parameter parameter) {
        return new CodeArgument(Helper.accessLocalVariable(parameter.getName(), Helper.getJavaType(parameter.getType())), true, Helper.getJavaType(parameter.getType()));
    }

}
