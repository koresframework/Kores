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
package com.github.jonathanxd.codeapi.common

import com.github.jonathanxd.codeapi.base.Case
import com.github.jonathanxd.codeapi.base.SwitchStatement
import com.github.jonathanxd.codeapi.base.Typed
import com.github.jonathanxd.codeapi.base.impl.SwitchStatementImpl
import com.github.jonathanxd.codeapi.gen.PartProcessor
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.sugar.Generator
import com.github.jonathanxd.codeapi.sugar.SugarEnvironment
import com.github.jonathanxd.codeapi.sugar.SugarSyntax
import java.util.Objects
import java.util.stream.Collectors

/**
 * Transformation applier, this Switch object must be transformed into an INT.
 */
interface SwitchType : PartProcessor, SugarSyntax<SwitchStatement, SwitchStatement> {

    val isUnique: Boolean
        get() = false

    override fun createGenerator(sugarEnvironment: SugarEnvironment): Generator<SwitchStatement, SwitchStatement> {
        return this.createGenerator()
    }

    fun createGenerator(): SwitchGenerator

    /**
     * This generator will not be called if the [SwitchType] is [SwitchTypes.NUMERIC].
     */
    abstract class SwitchGenerator : Generator<SwitchStatement, SwitchStatement> {

        /**
         * Translate switch to integer.
         *
         * @param aSwitch Switch
         * @return Translated switch.
         */
        open fun translateSwitch(aSwitch: SwitchStatement): SwitchStatement {
            return aSwitch
        }

        /**
         * Translate case to integer.
         *
         * @param aCase Case.
         * @return Translated case.
         */
        open fun translateCase(aCase: Case, aSwitch: SwitchStatement): Case {
            return aCase
        }

        override fun generate(t: SwitchStatement, processor: PartProcessor): SwitchStatement {
            val caseList = t.cases.map { aCase -> if (aCase.isDefault) aCase else this.checkType(this.translateCase(aCase, t)) }

            val translatedSwitch = this.checkType(this.translateSwitch(t))

            val switchStmt = SwitchStatementImpl(
                    value = translatedSwitch.value,
                    cases = caseList,
                    switchType = SwitchTypes.NUMERIC
            )

            return switchStmt
        }

        private fun <R : Typed> checkType(typed: R): R {
            if (!typed.type!!.`is`(Types.INT)) {
                throw IllegalArgumentException("Translated switch is not a numeric switch!")
            }

            return typed
        }
    }
}
