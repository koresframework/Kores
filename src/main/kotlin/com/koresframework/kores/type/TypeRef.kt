/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.type

import com.koresframework.kores.data.KoresData
import com.koresframework.kores.util.resolveQualifiedName
import com.koresframework.kores.util.resolveTypeName
import java.lang.reflect.Type

/**
 * Reference to a type, this is only intended to be used to inform outer types.
 */
data class TypeRef(
    val outerType: Type?,
    val specifiedName: String,
    override val isInterface: Boolean
) : KoresType {

    override val data: KoresData = KoresData()
    constructor(specifiedName: String) : this(null, specifiedName)
    constructor(outerType: Type?, specifiedName: String) : this(outerType, specifiedName, false)
    constructor(specifiedName: String, isInterface: Boolean) : this(
        null,
        specifiedName,
        isInterface
    )

    override val canonicalName: String = specifiedName
        get() = resolveQualifiedName(field, this.outerType)

    override val type: String = specifiedName
        get() = resolveTypeName(field, this.outerType)

}