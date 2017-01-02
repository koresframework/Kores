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
package com.github.jonathanxd.codeapi.options;

import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.iutils.option.Option;

/**
 * CodeAPI generation Options constant.
 */
public class CodeOptions {
    /**
     * Inline finally blocks.
     *
     * Bytecode: If defined to false, CodeAPI will generate Goto's instructions to call finally
     * blocks (it is bad). (default: true)
     *
     * Source Code: Inline finally blocks inside try and catches. (default: false)
     *
     * Known supported generators: {@code BytecodeGenerator}, {@code PlainSourceGenerator}.
     */
    public static final Option<Boolean> INLINE_FINALLY = new Option<>();


    /**
     * Validate constructor this() invocation.
     *
     * Default: true
     *
     * Known supported generators: {@code BytecodeGenerator}.
     */
    public static final Option<Boolean> VALIDATE_THIS = new Option<>(true);

    /**
     * Validate constructor this() invocation.
     *
     * Default: true
     *
     * Known supported generators: {@code BytecodeGenerator}.
     */
    public static final Option<Boolean> VALIDATE_SUPER = new Option<>(true);

    /**
     * Automatically generation of bridge methods (beta).
     *
     * The generation of bridge methods will slow down the Generator, if you mind the performance
     * don't change this option.
     *
     * The generation of bridge methods is very limited, the {@link com.github.jonathanxd.codeapi.util.source.BridgeUtil}
     * will inspect super-classes (and super-interfaces) and find the overridden method. The {@link
     * com.github.jonathanxd.codeapi.util.source.BridgeUtil} will only inspect {@link Class Java
     * class} and {@link com.github.jonathanxd.codeapi.base.TypeDeclaration CodeAPI Type
     * Declaration}, if the super-class and/or super-interfaces is of another type, {@link
     * com.github.jonathanxd.codeapi.util.source.BridgeUtil} will ignore and bridge method will not
     * be generated.
     *
     * You can add bridge methods manually with {@code TODO}.
     *
     * Known supported generators: {@code BytecodeGenerator}.
     *
     */
    //link com.github.jonathanxd.codeapi.helper.Helper#bridgeMethod(CodeMethod, FullMethodSpec)
    public static final Option<Boolean> GENERATE_BRIDGE_METHODS = new Option<>(false);
}
