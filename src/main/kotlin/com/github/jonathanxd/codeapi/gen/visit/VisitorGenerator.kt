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
package com.github.jonathanxd.codeapi.gen.visit

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.common.Data
import com.github.jonathanxd.codeapi.exception.ProcessingException
import com.github.jonathanxd.codeapi.gen.ArrayAppender
import com.github.jonathanxd.codeapi.gen.CodeGenerator
import com.github.jonathanxd.codeapi.sugar.SugarSyntax
import com.github.jonathanxd.codeapi.util.gento.GenToUtil
import java.util.*
import java.util.function.Consumer

/**
 * A visit based generator.
 */
abstract class VisitorGenerator<T> : CodeGenerator<Array<out T>> {

    private val visitors = HashMap<Class<*>, Visitor<*, T, *>>()

    /**
     * Empty array used by [VoidVisitor].
     */
    abstract val emptyArray: Array<out T>

    /**
     * Add a visitor.
     *
     * @param cClass    Type of part.
     * @param ctVisitor Visitor.
     * @param C         Type of part.
     */
    fun <C : CodePart> addVisitor(cClass: Class<C>, ctVisitor: Visitor<C, T, *>) {
        this.visitors.put(cClass, ctVisitor)
    }

    /**
     * Add a visitor.
     *
     * @param cClass    Type of part.
     * @param ctVisitor Visitor.
     * @param C         Type of part.
     */
    fun <C : CodePart> addSuperVisitor(cClass: Class<C>, ctVisitor: Visitor<C, T, *>) {
        this.visitors.put(cClass, ctVisitor)
    }

    /**
     * Added a unchecked visitor.
     *
     * @param cClass    Type of part.
     * @param ctVisitor Visitor.
     */
    fun addUncheckedVisitor(cClass: Class<*>, ctVisitor: Visitor<*, T, *>) {
        this.visitors.put(cClass, ctVisitor)
    }

    /**
     * Create data.
     *
     * @return Data.
     */
    protected abstract fun makeData(): Data

    override fun <V : CodePart, R : CodePart> registerSugarSyntax(type: Class<V>, sugarSyntax: SugarSyntax<V, R>): SugarSyntax<*, *>? {

        var syntax: SugarSyntax<*, *>? = null

        if (this.visitors.containsKey(type)) {
            val tVisitor = this.visitors[type]

            if (tVisitor is SugarSyntaxVisitor<*, *, *>) {
                syntax = tVisitor.sugarSyntax
            }

        }

        this.addVisitor(type, SugarSyntaxVisitor<V, R, T>(sugarSyntax))

        return syntax
    }

    override fun gen(source: CodeSource): Array<out T> {

        val extraData = makeData()

        return this.gen(source, extraData, null)
    }

    override fun gen(source: CodeSource, data: Data, additional: Any?): Array<out T> {

        val appender = createAppender()

        data.registerData(APPENDER_REPRESENTATION, appender)

        data.registerData(VISITOR_REPRESENTATION, this)

        this.generateTo(CodeSource::class.java, source, data, Consumer<Array<out T>> { appender.add(it) }, additional)

        data.unregisterData(APPENDER_REPRESENTATION, appender)

        data.unregisterData(VISITOR_REPRESENTATION, this)


        return appender.get()
    }

    /**
     * Create appender.
     *
     * @return Appender.
     */
    abstract fun createAppender(): ArrayAppender<T>

    /**
     * Visit part.
     *
     * @param partClass  Type of visitor part.
     * @param codePart   Part.
     * @param extraData  Data.
     * @param additional Additional object.
     * @return Result objects.
     */
    open fun <C : CodePart> generateTo(partClass: Class<out C>, codePart: C, extraData: Data, additional: Any?): Array<out T> {
        return this.generateTo(partClass, codePart, extraData, null, additional)
    }

    /**
     * Visit part.
     *
     * @param partClass  Type of visitor part.
     * @param codePart   Part.
     * @param extraData  Data.
     * @param consumer   Consumer
     * @param additional Additional object.
     * @return Result objects.
     */
    open fun <C : CodePart> generateTo(partClass: Class<out C>, codePart: C, extraData: Data, consumer: Consumer<Array<out T>>?, additional: Any?): Array<out T> {
        try {
            val tVisitor = get(partClass)

            if (!partClass.isInstance(codePart)) {
                throw ClassCastException("Required type of visitor '${tVisitor.javaClass.canonicalName}' is ${partClass.canonicalName}, but provided codePart '$codePart' is of type '${codePart.javaClass.canonicalName}'.")
            }

            val visit = visit(tVisitor, codePart, extraData, additional)

            consumer?.accept(visit)

            endVisit(tVisitor, visit, codePart, extraData, additional)

            return visit

        } catch (t: Throwable) {

            if (t is ProcessingException)
                throw t

            throw ProcessingException("Error while processing type: '$partClass', Part: '$codePart'.", t)
        }

    }

    @Suppress("UNCHECKED_CAST")
    private fun <L : CodePart, D> visit(visitor: Visitor<L, T, D>, value: Any, extraData: Data, additional: Any?): Array<out T> {
        return visitor.visit(value as L, extraData, this, additional as D)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <L : CodePart, D> endVisit(visitor: Visitor<L, T, D>, results: Array<out T>, value: Any, extraData: Data, additional: Any?) {
        visitor.endVisit(results, value as L, extraData, this, additional as D)
    }

    private operator fun get(cl: Class<*>): Visitor<*, T, *> {
        return GenToUtil.get(cl, this.visitors)
    }

    companion object {

        @JvmField
        val APPENDER_REPRESENTATION = "APPENDER"

        @JvmField
        val VISITOR_REPRESENTATION = "VISITOR"
    }

}
