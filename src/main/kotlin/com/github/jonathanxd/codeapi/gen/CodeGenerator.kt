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
package com.github.jonathanxd.codeapi.gen

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.common.Data
import com.github.jonathanxd.codeapi.sugar.SugarSyntax
import com.github.jonathanxd.iutils.option.Options

/**
 * Represents a source generator that output element of type [OUT]
 *
 * @param OUT Output element type.
 */
interface CodeGenerator<out OUT> : PartProcessor {

    /**
     * Generate object of type [OUT] from [CodeSource].
     *
     * @param source Source of parts.
     * @return Generated object.
     */
    fun gen(source: CodeSource): OUT {
        return this.gen(source, Data(), null)
    }

    /**
     * Generate object of type [OUT] from [CodePart].
     *
     * @param part Part to generate.
     * @return Generated object.
     */
    fun gen(part: CodePart): OUT {
        return this.gen(CodeSource.fromVarArgs(part), Data(), null)
    }

    /**
     * Generate object of type [OUT] from [CodePart].
     *
     * @param part       Part to generate.
     * @param data       MapData instance to be used to store information.
     * @param additional Additional object
     * @return Generated object.
     */
    fun gen(part: CodePart, data: Data, additional: Any?): OUT {
        return this.gen(CodeSource.fromVarArgs(part), data, additional)
    }

    /**
     * Generate object of type [OUT] from [CodeSource].
     *
     * @param source Source of parts.
     * @param data       MapData instance to be used to store information.
     * @param additional Additional object
     * @return Generated object.
     */
    fun gen(source: CodeSource, data: Data, additional: Any?): OUT

    /**
     * Register a sugar syntax. The generation of [T] will be delegated into [Sugar Syntax Generator][SugarSyntax.createGenerator].
     *
     * @param type        Type
     * @param sugarSyntax Sugar syntax.
     * @param <T>         Type of supported input part.
     * @param <R>         Type of output part.
     * @return Old [SugarSyntax] registered to `type`.
     */
    fun <T : CodePart, R : CodePart> registerSugarSyntax(type: Class<T>, sugarSyntax: SugarSyntax<T, R>): SugarSyntax<*, *>?

    /**
     * Gets the [Options] instance.
     *
     * @return [Options] instance.
     */
    val options: Options
}
