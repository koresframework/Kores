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
package com.github.jonathanxd.codeapi.util.description;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 10/08/16.
 */
public class DescriptionUtil {

    public static Description parseDescription(String description) {
        return new Description(
                description,
                DescriptionUtil.getBinaryClassName(description),
                DescriptionUtil.getMethodName(description),
                DescriptionUtil.getParameterTypes(description),
                DescriptionUtil.getReturnType(description));
    }

    public static String getBinaryClassName(String desc) {
        //DescriptionUtil.checkValidDescription(desc);

        return DescriptionUtil.parseBinaryClassName(desc.substring(0, desc.indexOf(';') + 1));
    }

    public static String getMethodName(String desc) {
        //DescriptionUtil.checkValidDescription(desc);

        return desc.substring(desc.indexOf(':') + 1, desc.indexOf('('));
    }

    public static String[] getParameterTypes(String desc) {
        //DescriptionUtil.checkValidDescription(desc);

        String parameters = desc.substring(desc.indexOf('(') + 1, desc.indexOf(')'));

        return DescriptionUtil.parametersToString(parameters);
    }

    public static String getReturnType(String desc) {
        //DescriptionUtil.checkValidDescription(desc);
        return DescriptionUtil.parseBinaryClassName(desc.substring(desc.indexOf(')') + 1));
    }

    private static String[] parametersToString(String parameters) {
        // Parameter list
        List<String> parameterNames = new ArrayList<>();

        // String characters
        char[] chars = parameters.toCharArray();

        // Builder of class names
        StringBuilder stringBuilder = new StringBuilder();


        for (char aChar : chars) {
            // If char is 'L' and string builder is empty
            if (aChar == 'L' && stringBuilder.length() == 0) {
                // Append 'L' to stringBuilder
                stringBuilder.append(aChar);
            } else if (aChar == ';') { // If char is ';'
                // If builder is empty
                if (stringBuilder.length() == 0)
                    throw new RuntimeException("Invalid parameter description: '" + parameters + "'!");

                // Append character ';'
                stringBuilder.append(';');

                // Add builder text to list
                parameterNames.add(stringBuilder.toString());

                // Set content of builder to ""
                stringBuilder.setLength(0);
            } else { // If character isn't 'L' or ';'
                // If builder is not empty
                if (stringBuilder.length() != 0) {
                    // Append character to builder
                    stringBuilder.append(aChar);
                } else { // If builder is empty
                    // Add character to parameterTypes
                    parameterNames.add(String.valueOf(aChar));
                }
            }
        }

        // If Builder is empty
        if (stringBuilder.length() != 0)
            throw new RuntimeException("Invalid description. ';' expected. Description = '" + parameters + "'!");

        // Return array of parameterTypes
        return parameterNames.stream().map(DescriptionUtil::parseBinaryClassName).toArray(String[]::new);
    }

    private static void checkValidDescription(String desc) {
        if (!desc.startsWith("L")
                || desc.indexOf(';') == -1
                || desc.indexOf(':') == -1
                || desc.indexOf('(') == -1
                || desc.indexOf(')') == -1) {
            throw new IllegalArgumentException("Invalid description: '" + desc + "'. See " + Description.class.getCanonicalName() + " javadoc.");
        }
    }

    /**
     * Parse binary class name from constant class info (L[BINARY_CLASS_NAME];)
     *
     * @param name Constant class info
     * @return Binary Class Name
     */
    public static String parseBinaryClassName(String name) {
        if (name.startsWith("L") && name.endsWith(";"))
            return name.substring(1, name.indexOf(';'));

        return name;
    }

}
