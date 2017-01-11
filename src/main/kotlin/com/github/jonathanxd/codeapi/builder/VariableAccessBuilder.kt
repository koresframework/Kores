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
package com.github.jonathanxd.codeapi.builder

import com.github.jonathanxd.codeapi.base.impl.VariableAccessImpl
import com.github.jonathanxd.codeapi.base.VariableAccess

// Generated by BuilderGen
open class VariableAccessBuilder(): Builder<VariableAccess, VariableAccessBuilder>() {

    /**
     * See [VariableAccess.target]
     */
    var target: com.github.jonathanxd.codeapi.CodePart? = null

    /**
     * See [VariableAccess.name]
     */
    lateinit var name: kotlin.String

    /**
     * See [VariableAccess.localization]
     */
    var localization: com.github.jonathanxd.codeapi.type.CodeType? = null

    /**
     * See [VariableAccess.variableType]
     */
    lateinit var variableType: com.github.jonathanxd.codeapi.type.CodeType

    constructor(defaults: VariableAccess) : this() {
        this.target = defaults.target
        this.name = defaults.name
        this.localization = defaults.localization
        this.variableType = defaults.variableType
    }


    /**
     * See [VariableAccess.target]
     */
    fun withTarget(value: com.github.jonathanxd.codeapi.CodePart?): VariableAccessBuilder {
        this.target = value
        return this
    }


    /**
     * See [VariableAccess.name]
     */
    fun withName(value: kotlin.String): VariableAccessBuilder {
        this.name = value
        return this
    }


    /**
     * See [VariableAccess.localization]
     */
    fun withLocalization(value: com.github.jonathanxd.codeapi.type.CodeType?): VariableAccessBuilder {
        this.localization = value
        return this
    }


    /**
     * See [VariableAccess.variableType]
     */
    fun withVariableType(value: com.github.jonathanxd.codeapi.type.CodeType): VariableAccessBuilder {
        this.variableType = value
        return this
    }

    override fun build(): VariableAccess = VariableAccessImpl(
            target = this.target,
            name = this.name,
            localization = this.localization,
            variableType = this.variableType
    )


    companion object {
        @JvmStatic
        fun builder() = VariableAccessBuilder()
    }
}