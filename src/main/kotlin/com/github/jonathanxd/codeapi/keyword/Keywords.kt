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
package com.github.jonathanxd.codeapi.keyword

import com.github.jonathanxd.codeapi.annotation.GenerateTo

/**
 * [Keywords][Keyword] constant
 */
object Keywords {

    @JvmField
    val ABSTRACT: Keyword = SimpleKeyword("abstract")

    @JvmField
    val ASSERT: Keyword = SimpleKeyword("assert")

    @JvmField
    val BOOLEAN: Keyword = SimpleKeyword("boolean")

    @JvmField
    val BREAK: Keyword = SimpleKeyword("break")

    @JvmField
    val BYTE: Keyword = SimpleKeyword("byte")

    @JvmField
    val CASE: Keyword = SimpleKeyword("case")

    @JvmField
    val CATCH: Keyword = SimpleKeyword("catch")

    @JvmField
    val CHAR: Keyword = SimpleKeyword("char")

    @JvmField
    val CLASS: Keyword = SimpleKeyword("class")

    @JvmField
    val CONTINUE: Keyword = SimpleKeyword("continue")

    @JvmField
    val DEFAULT: Keyword = SimpleKeyword("default")

    @JvmField
    val DO: Keyword = SimpleKeyword("do")

    @JvmField
    val DOUBLE: Keyword = SimpleKeyword("double")

    @JvmField
    val ELSE: Keyword = SimpleKeyword("else")

    @JvmField
    val ENUM: Keyword = SimpleKeyword("enum")

    @JvmField
    val EXTENDS: Keyword = SimpleKeyword("extends")

    @JvmField
    val FINAL: Keyword = SimpleKeyword("final")

    @JvmField
    val FINALLY: Keyword = SimpleKeyword("finally")

    @JvmField
    val FLOAT: Keyword = SimpleKeyword("float")

    @JvmField
    val FOR: Keyword = SimpleKeyword("for")

    @JvmField
    val IF: Keyword = SimpleKeyword("if")

    @JvmField
    val IMPLEMENTS: Keyword = SimpleKeyword("implements")

    @JvmField
    val IMPORT: Keyword = SimpleKeyword("import")

    @JvmField
    val INSTANCEOF: Keyword = SimpleKeyword("instanceof")

    @JvmField
    val INT: Keyword = SimpleKeyword("int")

    @JvmField
    val INTERFACE: Keyword = SimpleKeyword("interface")

    @JvmField
    val LONG: Keyword = SimpleKeyword("long")

    @JvmField
    val NATIVE: Keyword = SimpleKeyword("native")

    @JvmField
    val NEW: Keyword = SimpleKeyword("new")

    @JvmField
    val PACKAGE: Keyword = SimpleKeyword("package")

    @JvmField
    val PRIVATE: Keyword = SimpleKeyword("private")

    @JvmField
    val PROTECTED: Keyword = SimpleKeyword("protected")

    @JvmField
    val PUBLIC: Keyword = SimpleKeyword("public")

    @JvmField
    val RETURN: Keyword = SimpleKeyword("return")

    @JvmField
    val SHORT: Keyword = SimpleKeyword("short")

    @JvmField
    val STATIC: Keyword = SimpleKeyword("static")

    @JvmField
    val STRICTFP: Keyword = SimpleKeyword("strictfp")

    @JvmField
    val SUPER: Keyword = SimpleKeyword("super")

    @JvmField
    val SWITCH: Keyword = SimpleKeyword("switch")

    @JvmField
    val SYNCHRONIZED: Keyword = SimpleKeyword("synchronized")

    @JvmField
    val THIS: Keyword = SimpleKeyword("this")

    @JvmField
    val THROW: Keyword = SimpleKeyword("throw")

    @JvmField
    val THROWS: Keyword = SimpleKeyword("throws")

    @JvmField
    val TRANSIENT: Keyword = SimpleKeyword("transient")

    @JvmField
    val TRY: Keyword = SimpleKeyword("try")

    @JvmField
    val VOID: Keyword = SimpleKeyword("void")

    @JvmField
    val VOLATILE: Keyword = SimpleKeyword("volatile")

    @JvmField
    val WHILE: Keyword = SimpleKeyword("while")

    @GenerateTo(Keyword::class)
    private class SimpleKeyword(name: String) : Keyword(name)
}
