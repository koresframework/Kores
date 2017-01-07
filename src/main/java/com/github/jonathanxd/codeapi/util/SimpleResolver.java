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
import com.github.jonathanxd.codeapi.PredefinedTypes;
import com.github.jonathanxd.codeapi.type.CodeType;

public class SimpleResolver implements TypeResolver {

    private final TypeResolver wrapped;
    private final boolean resolveLoadedClasses;

    public SimpleResolver(TypeResolver wrapped, boolean resolveLoadedClasses) {
        this.wrapped = wrapped;
        this.resolveLoadedClasses = resolveLoadedClasses;
    }

    @Override
    public CodeType resolve(String name, boolean isInterface) {
        if (name.equals(PredefinedTypes.BYTE.getJavaSpecName())) {
            return PredefinedTypes.BYTE;
        } else if (name.equals(PredefinedTypes.SHORT.getJavaSpecName())) {
            return PredefinedTypes.SHORT;
        } else if (name.equals(PredefinedTypes.INT.getJavaSpecName())) {
            return PredefinedTypes.INT;
        } else if (name.equals(PredefinedTypes.FLOAT.getJavaSpecName())) {
            return PredefinedTypes.FLOAT;
        } else if (name.equals(PredefinedTypes.DOUBLE.getJavaSpecName())) {
            return PredefinedTypes.DOUBLE;
        } else if (name.equals(PredefinedTypes.LONG.getJavaSpecName())) {
            return PredefinedTypes.LONG;
        } else if (name.equals(PredefinedTypes.CHAR.getJavaSpecName())) {
            return PredefinedTypes.CHAR;
        } else if (name.equals(PredefinedTypes.STRING.getJavaSpecName())) {
            return PredefinedTypes.STRING;
        } else if (name.equals(PredefinedTypes.BOOLEAN.getJavaSpecName())) {
            return PredefinedTypes.BOOLEAN;
        } else if (name.equals(PredefinedTypes.VOID.getJavaSpecName())) {
            return PredefinedTypes.VOID;
        }

        name = name.replace('/', '.');

        if (name.startsWith("L") && name.endsWith(";")) {
            name = name.substring(1, name.length() - 1);
        }

        if (this.resolveLoadedClasses) {
            try {
                Class<?> aClass = Class.forName(name);

                if (aClass != null)
                    return CodeAPI.getJavaType(aClass);
            } catch (Throwable t) {
            }
        }

        return this.wrapped.resolve(name, isInterface);
    }
}
