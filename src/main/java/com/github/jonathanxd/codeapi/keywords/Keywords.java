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
package com.github.jonathanxd.codeapi.keywords;

import com.github.jonathanxd.codeapi.annotation.GenerateTo;

/**
 * Created by jonathan on 07/05/16.
 */
public class Keywords {
    public static final Keyword ABSTRACT = new SimpleKeyword("abstract");
    public static final Keyword ASSERT = new SimpleKeyword("assert");
    public static final Keyword BOOLEAN = new SimpleKeyword("boolean");
    public static final Keyword BREAK = new SimpleKeyword("break");
    public static final Keyword BYTE = new SimpleKeyword("byte");
    public static final Keyword CASE = new SimpleKeyword("case");
    public static final Keyword CATCH = new SimpleKeyword("catch");
    public static final Keyword CHAR = new SimpleKeyword("char");
    public static final Keyword CLASS = new SimpleKeyword("class");
    public static final Keyword CONTINUE = new SimpleKeyword("continue");
    public static final Keyword DEFAULT = new SimpleKeyword("default");
    public static final Keyword DO = new SimpleKeyword("do");
    public static final Keyword DOUBLE = new SimpleKeyword("double");
    public static final Keyword ELSE = new SimpleKeyword("else");
    public static final Keyword ENUM = new SimpleKeyword("enum");
    public static final Keyword EXTENDS = new SimpleKeyword("extends");
    public static final Keyword FINAL = new SimpleKeyword("final");
    public static final Keyword FINALLY = new SimpleKeyword("finally");
    public static final Keyword FLOAT = new SimpleKeyword("float");
    public static final Keyword FOR = new SimpleKeyword("for");
    public static final Keyword IF = new SimpleKeyword("if");
    public static final Keyword IMPLEMENTS = new SimpleKeyword("implements");
    public static final Keyword IMPORT = new SimpleKeyword("import");
    public static final Keyword INSTANCEOF = new SimpleKeyword("instanceof");
    public static final Keyword INT = new SimpleKeyword("int");
    public static final Keyword INTERFACE = new SimpleKeyword("interface");
    public static final Keyword LONG = new SimpleKeyword("long");
    public static final Keyword NATIVE = new SimpleKeyword("native");
    public static final Keyword NEW = new SimpleKeyword("new");
    public static final Keyword PACKAGE = new SimpleKeyword("package");
    public static final Keyword PRIVATE = new SimpleKeyword("private");
    public static final Keyword PROTECTED = new SimpleKeyword("protected");
    public static final Keyword PUBLIC = new SimpleKeyword("public");
    public static final Keyword RETURN = new SimpleKeyword("return");
    public static final Keyword SHORT = new SimpleKeyword("short");
    public static final Keyword STATIC = new SimpleKeyword("static");
    public static final Keyword STRICTFP = new SimpleKeyword("strictfp");
    public static final Keyword SUPER = new SimpleKeyword("super");
    public static final Keyword SWITCH = new SimpleKeyword("switch");
    public static final Keyword SYNCHRONIZED = new SimpleKeyword("synchronized");
    public static final Keyword THIS = new SimpleKeyword("this");
    public static final Keyword THROW = new SimpleKeyword("throw");
    public static final Keyword THROWS = new SimpleKeyword("throws");
    public static final Keyword TRANSIENT = new SimpleKeyword("transient");
    public static final Keyword TRY = new SimpleKeyword("try");
    public static final Keyword VOID = new SimpleKeyword("void");
    public static final Keyword VOLATILE = new SimpleKeyword("volatile");
    public static final Keyword WHILE = new SimpleKeyword("while");

    @GenerateTo(Keyword.class)
    private final static class SimpleKeyword extends Keyword {
        public SimpleKeyword(String name) {
            super(name);
        }
    }
}
