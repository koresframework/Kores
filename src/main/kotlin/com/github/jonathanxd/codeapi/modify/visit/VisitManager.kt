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
package com.github.jonathanxd.codeapi.modify.visit

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.common.Data
import com.github.jonathanxd.codeapi.util.gento.GenToUtil
import java.util.*

/**
 * Manager of visitor of part [T].
 *
 * The implementation must care about [register] methods, these methods put values in [partVisitorMap],
 * that isn't accessible from the implementation, if you want to control the register behavior
 * override these methods.
 *
 * The [getVisitor] method is always called to find a registered visitor, the default implementation
 * tries to determine the visitor calling [GenToUtil.get] method with [CodePart class][CodePart] and [visitors] as argument.
 */
open class VisitManager<T : CodePart> {

    private val partVisitorMap = HashMap<Class<*>, PartVisitor<*>>()
    val visitors = Collections.unmodifiableMap(this.partVisitorMap)

    open fun <U : CodePart> register(type: Class<U>, visitor: PartVisitor<U>) {
        this.partVisitorMap.put(type, visitor)
    }

    open fun <U : CodePart> registerSuper(type: Class<U>, visitor: PartVisitor<in U>) {
        this.partVisitorMap.put(type, visitor)
    }

    open fun registerGeneric(type: Class<*>, visitor: PartVisitor<*>) {
        this.partVisitorMap.put(type, visitor)
    }

    @Suppress("UNCHECKED_CAST")
    fun <U : CodePart> visit(part: U, data: Data): U {
        return this.getVisitor<CodePart>(part::class.java).visit(part, data, this) as U
    }

    @Suppress("UNCHECKED_CAST")
    fun <U : CodePart> visit(type: Class<U>, part: U, data: Data): U {
        return this.getVisitor<CodePart>(type).visit(part, data, this) as U
    }

    @Suppress("UNCHECKED_CAST")
    fun visit(part: T): T {
        val aClass = part::class.java

        val data = Data()

        val visitor = this.getVisitor<CodePart>(aClass)

        return visitor.visit(part, data, this) as T
    }

    @Suppress("UNCHECKED_CAST", "DEPRECATION") // May be removed in the future, at any time.
    protected open fun <U : CodePart> getVisitor(type: Class<*>): PartVisitor<U> {
        return GenToUtil.get(type, this.visitors) as PartVisitor<U>
    }
}
