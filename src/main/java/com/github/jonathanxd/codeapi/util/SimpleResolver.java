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
import com.github.jonathanxd.codeapi.Types;
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
        if (name.equals(Types.BYTE.getJavaSpecName())) {
            return Types.BYTE;
        } else if (name.equals(Types.SHORT.getJavaSpecName())) {
            return Types.SHORT;
        } else if (name.equals(Types.INT.getJavaSpecName())) {
            return Types.INT;
        } else if (name.equals(Types.FLOAT.getJavaSpecName())) {
            return Types.FLOAT;
        } else if (name.equals(Types.DOUBLE.getJavaSpecName())) {
            return Types.DOUBLE;
        } else if (name.equals(Types.LONG.getJavaSpecName())) {
            return Types.LONG;
        } else if (name.equals(Types.CHAR.getJavaSpecName())) {
            return Types.CHAR;
        } else if (name.equals(Types.STRING.getJavaSpecName())) {
            return Types.STRING;
        } else if (name.equals(Types.BOOLEAN.getJavaSpecName())) {
            return Types.BOOLEAN;
        } else if (name.equals(Types.VOID.getJavaSpecName())) {
            return Types.VOID;
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
