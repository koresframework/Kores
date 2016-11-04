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

import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.util.Variable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParameterUtil {
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
}
