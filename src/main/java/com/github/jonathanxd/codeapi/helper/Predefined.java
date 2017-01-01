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
package com.github.jonathanxd.codeapi.helper;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by jonathan on 06/06/16.
 */
public final class Predefined {

    Predefined() {
    }

    public static MethodInvocation toString(CodePart part) {
        return CodeAPI.invokeVirtual(Object.class, part, "toString", new TypeSpec(PredefinedTypes.STRING));
    }

    public static MethodInvocation intToString(CodePart part) {
        return CodeAPI.invokeStatic(String.class, "valueOf", new TypeSpec(PredefinedTypes.STRING, PredefinedTypes.INT),
                CodeAPI.argument(part));
    }

    public static MethodInvocation invokePrintln(CodeArgument... arguments) {
        return Helper.invoke(InvokeType.INVOKE_VIRTUAL, PrintStream.class,
                Helper.accessStaticVariable(System.class, "out", PrintStream.class),
                new MethodSpecImpl("println", PredefinedTypes.VOID, Arrays.asList(arguments)));
    }

    public static MethodInvocation invokePrintlnStr(CodePart part) {
        return CodeAPI.invokeVirtual(
                PrintStream.class,
                CodeAPI.accessStaticField(System.class, PrintStream.class, "out"),
                "println",
                CodeAPI.typeSpec(PredefinedTypes.VOID, PredefinedTypes.STRING),
                CodeAPI.argument(part));
    }
}
