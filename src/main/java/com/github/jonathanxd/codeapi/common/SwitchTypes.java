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
package com.github.jonathanxd.codeapi.common;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.SwitchType.SwitchGenerator;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.Case;
import com.github.jonathanxd.codeapi.interfaces.EnumValue;
import com.github.jonathanxd.codeapi.interfaces.Switch;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.interfaces.Valuable;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.LoadedCodeType;

public final class SwitchTypes {

    public static final SwitchType NUMERIC = new NumericSwitch();

    public static final SwitchType OBJECT = ObjectSwitchGenerator::new;

    public static final SwitchType STRING = OBJECT;

    public static final SwitchType ENUM = new EnumSwitch();

    /**
     * Try to resolve CodePart at runtime.
     */
    @SuppressWarnings("unchecked")
    private static int resolve(CodePart p, Switch aSwitch) {

        CodeType type = aSwitch.getType().orElseThrow(NullPointerException::new);

        if (p instanceof Literal) {
            Literal l = (Literal) p;

            if (p instanceof Literals.CharLiteral)
                return l.getName().charAt(0);

            if (p instanceof Literals.ByteLiteral || p instanceof Literals.ShortLiteral || p instanceof Literals.IntLiteral)
                return Integer.parseInt(l.getName());

        }

        if (p instanceof Literals.QuotedStringLiteral) {
            return ((Literals.QuotedStringLiteral) p).getOriginal().hashCode();
        }

        try {
            if (p instanceof EnumValue) {
                EnumValue enumValue = (EnumValue) p;
                int ordinal = enumValue.getOrdinal();

                if (ordinal > -1) {
                    return ordinal;
                }

                String name = enumValue.getName();

                if (type instanceof LoadedCodeType<?>)
                    return Enum.valueOf(((LoadedCodeType) type).getLoadedType(), name).ordinal();
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot resolve enum ordinal value, please use CodeAPI.enumValue(NAME, ORDINAL) to switch enum values that isn't available at runtime!", e);
        }


        throw new RuntimeException("Cannot resolve the numeric value of '" + p + "', a new SwitchType must be implemented to resolve this!");
    }

    private static class EnumSwitch implements SwitchType {

        @Override
        public boolean isUnique() {
            return true;
        }

        @Override
        public SwitchGenerator getGenerator() {
            return new EnumSwitchGenerator();
        }
    }

    private static class EnumSwitchGenerator extends SwitchGenerator {

        @Override
        public Switch translateSwitch(Switch aSwitch) {
            return this.translate(aSwitch);
        }

        @Override
        public Case translateCase(Case aCase, Switch aSwitch) {
            if (aCase.isDefault())
                return aCase;

            return aCase.setValue(Literals.INT(resolve(aCase.getValue().orElseThrow(NullPointerException::new), aSwitch)));
        }

        @SuppressWarnings("unchecked")
        private <T extends Valuable> T translate(T t) {
            return (T) t.setValue(CodeAPI.invokeVirtual(Enum.class, t.getValue().orElse(null), "ordinal", CodeAPI.typeSpec(PredefinedTypes.INT)));
        }

    }

    private static class NumericSwitch implements SwitchType {

        @Override
        public boolean isUnique() {
            return true;
        }

        @Override
        public SwitchGenerator getGenerator() {
            return new NumericSwitchGenerator();
        }
    }

    private static class NumericSwitchGenerator extends SwitchGenerator {

        private static CodePart autoUnboxing(CodePart part, CodeType type) {
            if (!type.isPrimitive()) {
                return CodeAPI.cast(type, PredefinedTypes.INT, part);
            }

            return part;
        }

        private static boolean isAcceptable(CodeType type) {
            return type != null && (
                    type.is(PredefinedTypes.CHAR)
                            || type.is(PredefinedTypes.BYTE)
                            || type.is(PredefinedTypes.SHORT)
                            || type.is(PredefinedTypes.INT)
                            || (!type.isPrimitive() && isAcceptable(type.getPrimitiveType())));
        }

        @Override
        public Switch generate(Switch aSwitch) {
            Typed part = (Typed) aSwitch.getValue().orElseThrow(NullPointerException::new);
            CodeType type = part.getType().orElseThrow(NullPointerException::new);

            if (isAcceptable(type)) {
                return aSwitch.setValue(autoUnboxing(part, type));
            }


            throw new IllegalArgumentException("Cannot switch part '" + part + "' of type: '" + type + "'. The part is not numeric.");
        }
    }

    private static class ObjectSwitchGenerator extends SwitchGenerator {

        @Override
        public Switch translateSwitch(Switch aSwitch) {
            return this.translate(aSwitch);
        }

        @Override
        public Case translateCase(Case aCase, Switch aSwitch) {

            if (aCase.isDefault())
                return aCase;

            if (aCase.getType().orElseThrow(NullPointerException::new).is(PredefinedTypes.INT))
                return aCase;

            return aCase.setValue(Literals.INT(resolve(aCase.getValue().orElseThrow(NullPointerException::new), aSwitch)));
        }


        @SuppressWarnings("unchecked")
        private <T extends Valuable> T translate(T t) {
            return (T) t.setValue(CodeAPI.invokeVirtual(Object.class,
                    t.getValue().orElse(null),
                    "hashCode", CodeAPI.typeSpec(PredefinedTypes.INT)));
        }
    }
}