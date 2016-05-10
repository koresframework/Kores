/*
 *      ${expr} - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
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
package com.github.jonathanxd.codeapi.util.strbuilder;

/**
 * Created by jonathan on 09/04/16.
 */

import com.github.jonathanxd.codeapi.util.ClassUtil;
import com.github.jonathanxd.codeapi.util.CodeParameter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

/**
 * Helper methods
 */
public class StrBuilder {

    public static String newField(String modifiers, String type, String name, String value) {
        return modifiers + " " + type + " " + name + (value != null ? (" = " + value) : "");
    }

    public static String newClass(String package_, String className, String extension, String[] implementations, boolean close) {

        StringBuilder sb = new StringBuilder();

        if (package_ != null) {
            sb.append("package ").append(package_).append(';');
            sb.append('\n');
        }

        if (className != null) {
            sb.append("public class ").append(className);
        }

        if (extension != null) {
            sb.append(' ').append("extends ").append(extension);
        }

        if (implementations != null) {
            for (String implementation : implementations) {
                sb.append(' ').append("implements ").append(implementation);
            }
        }

        sb.append(' ').append('{').append('\n');

        return close ? sb.append('}').append('\n').toString() : sb.toString();
    }

    public static String newMethod(String modifiers, String methodName, String[][] parameters, String returnType, String body) {
        StringBuilder sb = new StringBuilder();

        sb.append(modifiers).append(" ");

        if (returnType != null)
            sb.append(returnType);
        else
            sb.append("void");

        sb.append(' ').append(methodName).append(' ');

        sb.append('(');

        if (parameters != null) {
            StringJoiner sj = new StringJoiner(", ");

            for (String[] parameter : parameters) {
                sj.add(parameter[0] + " " + parameter[1]);
            }

            sb.append(sj.toString());
        }

        sb.append(')').append(' ').append('{').append('\n');

        sb.append(body);

        sb.append('\n').append('}');

        return sb.toString();
    }

    /**
     * @param parameters String[][] = {{"TYPE", "NAME"}, {"TYPE", "NAME"}}
     */
    @SuppressWarnings("Duplicates")
    @Deprecated
    public static String newMethod(String methodName, String[][] parameters, String returnType, String body) {
        StringBuilder sb = new StringBuilder();

        sb.append("public ");

        if (returnType != null)
            sb.append(returnType);
        else
            sb.append("void");

        sb.append(' ').append(methodName).append(' ');

        sb.append('(');

        if (parameters != null) {
            StringJoiner sj = new StringJoiner(", ");

            for (String[] parameter : parameters) {
                sj.add(parameter[0] + " " + parameter[1]);
            }

            sb.append(sj.toString());
        }

        sb.append(')').append(' ').append('{').append('\n');

        sb.append(body);

        sb.append('\n').append('}');

        return sb.toString();
    }

    public static String methodGet(Method m) {
        StringBuilder sb = new StringBuilder();
        Class<?> declaringClass = m.getDeclaringClass();


        sb.append(declaringClass.getCanonicalName()).append('.').append("class").append('.').append("getDeclaredMethod")
                .append('(');

        StringJoiner sj = new StringJoiner(", ");
        sj.add("\"" + m.getName() + "\"");


        String[] strings = ClassUtil.toCanonicalString(m.getParameterTypes());

        for (String string : strings) {
            sj.add(string.concat(".class"));
        }

        sb.append(sj.toString()).append(')');

        return sb.toString();

    }

    public static String appendReturn(Class<?> castType, String target) {
        return appendReturn("(" + castType.getCanonicalName() + ") " + target);
    }

    public static String appendReturn(String target) {
        return "return ".concat(target);
    }

    //callDefault("this", WRAPPER, METHOD, PARAMETERS);

    @SuppressWarnings("Duplicates")
    public static String callDefault(String local, String expr, Method m, CodeParameter[] parameters) {
        StringBuilder sb = new StringBuilder();

        if (local != null) {
            sb.append(local).append('.');
        }

        sb.append(expr).append('.').append(m.getName());

        sb.append('(');

        StringJoiner sj = new StringJoiner(", ");

        Parameter[] mParameters = m.getParameters();

        for (int i = 0; i < mParameters.length; i++) {
            Parameter param = mParameters[i];

            sj.add("(" + param.getType().getCanonicalName() + ") " + parameters[i].getName());
        }

        sb.append(sj.toString());
        sb.append(')').append(';');

        return sb.toString();
    }

    public static String callDefault(String local, String expr, String method, CodeParameter[] parameters) {
        StringBuilder sb = new StringBuilder();

        if (local != null) {
            sb.append(local).append('.');
        }

        sb.append(expr).append('.').append(method);

        sb.append('(');

        StringJoiner sj = new StringJoiner(", ");

        for (CodeParameter parameter : parameters) {
            sj.add("(" + parameter.getType().getType() + ") " + parameter.getName());
        }

        sb.append(sj.toString());
        sb.append(')').append(';');

        return sb.toString();
    }

}
