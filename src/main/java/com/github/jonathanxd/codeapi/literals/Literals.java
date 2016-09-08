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
package com.github.jonathanxd.codeapi.literals;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.types.CodeType;

/**
 * {@link Literal Literals} constants.
 */
public final class Literals {

    // NullLiteral
    public static final Literal NULL = new SimpleLiteral("null", Helper.nullType());
    // BooleanLiteral
    public static final Literal TRUE = new BoolLiteral("true");
    public static final Literal FALSE = new BoolLiteral("false");

    public static boolean isPrimitive(CodePart codePart1, CodePart codePart2) {
        return codePart1 instanceof Literal && codePart2 instanceof Literal && isPrimitive((Literal) codePart1, (Literal) codePart2);
    }

    /**
     * Return true if {@code literal1} and {@code literal2} is primitive
     *
     * @param literal1 Literal 1
     * @param literal2 Literal 2
     * @return True if {@code literal1} and {@code literal2} is primitive
     */
    public static boolean isPrimitive(Literal literal1, Literal literal2) {
        return (literal1 instanceof IntLiteral
                || literal1 instanceof FloatLiteral
                || literal1 instanceof DoubleLiteral
                || literal1 instanceof CharLiteral
                || literal1 instanceof LongLiteral
                || literal1 instanceof BoolLiteral
                || literal1 instanceof ShortLiteral
                || literal1 instanceof ByteLiteral)
                &&
                (literal2 instanceof IntLiteral
                        || literal2 instanceof FloatLiteral
                        || literal2 instanceof DoubleLiteral
                        || literal2 instanceof CharLiteral
                        || literal2 instanceof LongLiteral
                        || literal2 instanceof BoolLiteral
                        || literal2 instanceof ShortLiteral
                        || literal2 instanceof ByteLiteral);
    }

    public static boolean isPrimitive(Literal literal) {
        return literal instanceof IntLiteral
                || literal instanceof FloatLiteral
                || literal instanceof DoubleLiteral
                || literal instanceof CharLiteral
                || literal instanceof LongLiteral
                || literal instanceof BoolLiteral
                || literal instanceof ByteLiteral
                || literal instanceof ShortLiteral;
    }

    // Numeric Literals

    // ByteLiteral
    public static Literal BYTE(byte b) {
        return new ByteLiteral(String.valueOf(b));
    }

    // ShortLiteral
    public static Literal SHORT(short s) {
        return new ShortLiteral(String.valueOf(s));
    }

    // IntegerLiteral
    public static Literal INT(int i) {
        return new IntLiteral(String.valueOf(i));
    }

    // BooleanLiteral
    public static Literal BOOLEAN(boolean b) {
        if (b) return TRUE;
        else return FALSE;
    }

    // LongLiteral
    public static Literal LONG(long i) {
        return new LongLiteral(String.valueOf(i));
    }

    // FloatLiteral
    public static Literal FLOAT(float f) {
        return new FloatLiteral(String.valueOf(f));
    }

    // DoubleLiteral
    public static Literal DOUBLE(double d) {
        return new DoubleLiteral(String.valueOf(d));
    }

    // CharLiteral
    public static Literal CHAR(char c) {
        return new CharLiteral(String.valueOf(c));
    }

    // StringLiteral

    public static Literal STRING(String s) {
        return new QuotedStringLiteral(s);
    }

    // QuotedStringLiteral (") STRING (")
    public static Literal QUOTED_STRING(String s) {
        return new QuotedStringLiteral(s);
    }

    // Array
    public static Literal ARRAY(Literal other, CodeType array) {
        return new SimpleLiteral(other.getName(), array);
    }

    // Class Literal
    public static Literal CLASS(Class<?> aClass) {
        return CLASS(Helper.getJavaType(aClass));
    }

    public static Literal CLASS(CodeType aClass) {
        return new ClassLiteral(aClass);
    }

    @GenerateTo(Literal.class)
    private final static class SimpleLiteral extends Literal {
        SimpleLiteral(String name, CodeType dataType) {
            super(name, dataType);
        }

    }

    @GenerateTo(Literal.class)
    public final static class ClassLiteral extends Literal {
        private static final CodeType TYPE = Helper.getJavaType(Integer.TYPE);

        public final CodeType type;

        ClassLiteral(CodeType codeType) {
            super(codeType.getCanonicalName(), TYPE);
            this.type = codeType;
        }

    }

    @GenerateTo(Literal.class)
    public static final class ByteLiteral extends Literal {

        private static final CodeType TYPE = Helper.getJavaType(Integer.TYPE);

        ByteLiteral(String name) {
            super(name, TYPE);
        }

    }

    @GenerateTo(Literal.class)
    public static final class ShortLiteral extends Literal {

        private static final CodeType TYPE = Helper.getJavaType(Integer.TYPE);

        ShortLiteral(String name) {
            super(name, TYPE);
        }

    }

    @GenerateTo(Literal.class)
    public static final class IntLiteral extends Literal {

        private static final CodeType TYPE = Helper.getJavaType(Integer.TYPE);

        IntLiteral(String name) {
            super(name, TYPE);
        }

    }

    @GenerateTo(Literal.class)
    public static final class BoolLiteral extends Literal {

        private static final CodeType TYPE = Helper.getJavaType(Boolean.TYPE);

        BoolLiteral(String name) {
            super(name, TYPE);
        }

    }

    @GenerateTo(Literal.class)
    public static final class LongLiteral extends Literal {

        private static final CodeType TYPE = Helper.getJavaType(Long.TYPE);

        LongLiteral(String name) {
            super(name, TYPE);
        }

    }


    @GenerateTo(Literal.class)
    public static final class FloatLiteral extends Literal {

        private static final CodeType TYPE = Helper.getJavaType(Float.TYPE);

        FloatLiteral(String name) {
            super(name, TYPE);
        }

    }

    @GenerateTo(Literal.class)
    public static final class DoubleLiteral extends Literal {

        private static final CodeType TYPE = Helper.getJavaType(Double.TYPE);

        DoubleLiteral(String name) {
            super(name, TYPE);
        }

    }

    @GenerateTo(Literal.class)
    public static final class CharLiteral extends Literal {

        private static final CodeType TYPE = Helper.getJavaType(Character.TYPE);

        CharLiteral(String name) {
            super(name, TYPE);
        }

    }

    @GenerateTo(Literal.class)
    public static final class StringLiteral extends Literal {

        private static final CodeType TYPE = Helper.getJavaType(String.class);

        StringLiteral(String name) {
            super(name, TYPE);
        }

    }

    @GenerateTo(Literal.class)
    public static final class QuotedStringLiteral extends Literal {

        private static final CodeType TYPE = Helper.getJavaType(String.class);

        QuotedStringLiteral(String name) {
            super('"' + name + '"', TYPE);
        }

    }
}
