/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
@file:JvmName("ClassUtil")

package com.koresframework.kores.util

import java.util.*

private fun getAllInterfaces(base: Class<*>): List<Class<*>> {

    val classes = ArrayList<Class<*>>()

    val interfaces = base.interfaces

    for (anInterface in interfaces) {
        classes.add(anInterface)

        classes.addAll(getAllInterfaces(anInterface))
    }

    return classes
}

/**
 * Internal undocumented.
 */
fun getAllSubclasses(base: Class<*>): Collection<Class<*>> {

    val classes = LinkedHashSet<Class<*>>()

    val superClass = base.superclass

    val nextActions = ArrayList<() -> Unit>()

    if (superClass != null && superClass != Any::class.java) {
        classes.add(superClass)
        nextActions.add { classes.addAll(getAllSubclasses(superClass)) }
    }

    val interfaces = base.interfaces

    for (anInterface in interfaces) {
        classes.add(anInterface)

        nextActions.add { classes.addAll(getAllInterfaces(anInterface)) }
    }

    nextActions.forEach { it() }

    return classes
}

@Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
val Class<*>.isKotlin
    get() = this.declaredAnnotations.any {
        (it as java.lang.annotation.Annotation).annotationType()
            .canonicalName.startsWith("kotlin.Metadata")
    }
