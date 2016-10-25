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
package com.github.jonathanxd.codeapi.common;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.gen.PartProcessor;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.Case;
import com.github.jonathanxd.codeapi.interfaces.Switch;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.sugar.Generator;
import com.github.jonathanxd.codeapi.sugar.SugarSyntax;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Transformation applier, this Switch object must be transformed into an INT.
 */
public interface SwitchType extends PartProcessor, SugarSyntax<Switch, Switch> {

    default boolean isUnique() {
        return false;
    }

    @Override
    SwitchGenerator getGenerator();

    /**
     * This generator will not be called if the {@link SwitchType} is {@link SwitchTypes#NUMERIC}.
     *
     */
    abstract class SwitchGenerator implements Generator<Switch, Switch> {

        /**
         * Translate switch to integer.
         *
         * @param aSwitch Switch
         * @return Translated switch.
         */
        public Switch translateSwitch(Switch aSwitch) {
            return aSwitch;
        }

        /**
         * Translate case to integer.
         *
         * @param aCase Case.
         * @return Translated case.
         */
        public Case translateCase(Case aCase, Switch aSwitch) {
            return aCase;
        }

        @Override
        public Switch generate(Switch aSwitch) {
            List<Case> caseList = aSwitch.getCases().stream().map(
                    aCase -> aCase.isDefault() ? aCase : this.checkType(this.translateCase(aCase, aSwitch))
            ).collect(Collectors.toList());

            return this.checkType(this.translateSwitch(aSwitch).setSwitchType(SwitchTypes.NUMERIC).setCases(caseList));
        }

        private <R extends Typed> R checkType(R typed) {
            if(!Objects.requireNonNull(typed.getType().orElse(null), "Type cannot be null").is(PredefinedTypes.INT)) {
                throw new IllegalArgumentException("Translated switch is not a numeric switch!");
            }

            return typed;
        }
    }
}
