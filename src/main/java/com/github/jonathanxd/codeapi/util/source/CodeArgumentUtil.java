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
package com.github.jonathanxd.codeapi.util.source;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.util.CodePartUtil;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public static CodePart[] createChecked(CodePart[] expected, CodePart[] passed) {

        CodePart[] newArguments = new CodePart[passed.length];

        for (int i = 0; i < newArguments.length; i++) {
            CodeType type = CodePartUtil.getType(expected[i]);

            CodePart part = passed[i];

            part = CodeAPI.cast(CodePartUtil.getType(passed[i]), type, part);

            newArguments[i] = part;
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
        return Arrays.stream(parameters).map(CodeArgumentUtil::fromJavaArgument).toArray(CodeParameter[]::new);
    }

    /**
     * Convert from {@link Parameter} to {@link CodeParameter}.
     *
     * @param parameter Parameter.
     * @return Converted parameter.
     */
    public static CodeParameter fromJavaArgument(Parameter parameter) {
        return new CodeParameter(CodeAPI.getJavaType(parameter.getType()), parameter.getName());
    }

    /**
     * Convert from {@link CodeParameter} to {@code argument}.
     *
     * Parameters will be converted to local access of variables.
     *
     * @param parameters Parameters.
     * @return Converted arguments.
     */
    public static List<CodePart> argumentsFromParameters(List<CodeParameter> parameters) {
        return parameters.stream().map(CodeArgumentUtil::fromParameters).collect(Collectors.toList());
    }

    /**
     * Convert from {@link CodeParameter} to {@code arguments}.
     *
     * Parameters will be converted to local access of variables.
     *
     * @param parameters Parameters.
     * @return Converted arguments.
     */
    public static CodePart[] argumentsFromParameters(CodeParameter[] parameters) {
        return Arrays.stream(parameters).map(CodeArgumentUtil::fromParameters).toArray(CodePart[]::new);
    }

    /**
     * Convert from {@link CodeParameter} to {@code argument}.
     *
     * Parameter will be converted to local access of variables.
     *
     * @param parameter Parameter.
     * @return Converted argument.
     */
    public static CodePart fromParameters(CodeParameter parameter) {
        return CodeAPI.accessLocalVariable(parameter.getType(), parameter.getName());
    }


    /**
     * Convert from {@link Parameter} to {@code argument}.
     *
     * Parameters will be converted to local access of variables.
     *
     * @param parameters Parameters.
     * @return Converted arguments.
     */
    public static CodePart[] argumentsFromJavaParameters(Parameter[] parameters) {
        return Arrays.stream(parameters).map(CodeArgumentUtil::fromJavaParameter).toArray(CodePart[]::new);
    }

    /**
     * Convert from {@link Parameter} to {@code argument}.
     *
     * Parameter will be converted to local access of variables.
     *
     * @param parameter Parameter.
     * @return Converted argument.
     */
    public static CodePart fromJavaParameter(Parameter parameter) {
        return CodeAPI.accessLocalVariable(parameter.getType(), parameter.getName());
    }

}
