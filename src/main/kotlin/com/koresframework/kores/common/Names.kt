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
package com.koresframework.kores.common

import com.koresframework.kores.Instructions
import com.koresframework.kores.base.FieldDeclaration
import com.koresframework.kores.base.MethodDeclarationBase
import com.koresframework.kores.base.Named
import com.koresframework.kores.base.TypeDeclaration
import com.koresframework.kores.inspect.InstructionsInspect

/**
 * Class constructor JVM Name
 */
const val CLASS_CONSTRUCTOR = "<clinit>"

/**
 * Instance constructor JVM Name
 */
const val CONSTRUCTOR = "<init>"

/**
 * Gets a new name for inner class, this function always try to return a name that is not in
 * use by other class in [typeDeclaration].
 */
fun getNewInnerName(name: String, typeDeclaration: TypeDeclaration): String {
    val inspect = typeDeclaration.innerTypes

    var count = 0

    if (!contains(name, inspect))
        return name

    while (contains("name$count", inspect))
        ++count

    return "$name$count"
}

/**
 * Gets a new unique from a base [name]. This function always return a name that is not in [Named Element List][nameds].
 */
fun getNewName(name: String, nameds: List<Named>): String {
    @Suppress("NAME_SHADOWING")
    var count = 0

    if (!contains(name, nameds))
        return name

    while (contains("name$count", nameds))
        ++count

    return "$name$count"
}

/**
 * Gets a new unique field name based on [name] and check if the name is not already in use by other
 * [FieldDeclaration] in [source].
 */
fun getNewFieldName(name: String, source: Instructions): String {
    val inspect = InstructionsInspect.builder { codePart -> codePart is FieldDeclaration }
        .includeRoot(true)
        .include { bodied -> bodied is Instructions }
        .mapTo { codePart -> codePart as FieldDeclaration }
        .inspect(source)

    var count = 0

    if (!contains(name, inspect))
        return name

    while (contains("name$count", inspect))
        ++count

    return "$name$count"
}

/**
 * Gets a new unique method name based on [name] and check if the name is not already in use by other
 * [MethodDeclarationBase] in [source].
 */
fun getNewMethodName(name: String, source: Instructions): String {
    @Suppress("NAME_SHADOWING")
    var name = name
    val inspect = InstructionsInspect.builder { codePart -> codePart is MethodDeclarationBase }
        .includeRoot(true)
        .include { bodied -> bodied is Instructions }
        .mapTo { codePart -> codePart as MethodDeclarationBase }
        .inspect(source)

    var count = 0

    if (!contains(name, inspect))
        return name

    while (contains("name$count", inspect))
        ++count

    return "$name$count"
}

/**
 * Gets a new unique from a base [name]. This function always return a name that is not in [Named Element List][nameds].
 */
fun getNewNames(name: String, amount: Int, nameds: List<Named>): List<String> {
    val names = nameds.map { it.name }.toMutableList()
    val nameList = mutableListOf<String>()

    @Suppress("NAME_SHADOWING")
    var name = name
    var count = 0
    while (true) {
        if (!names.contains(name)) {
            nameList.add(name)
            names.add(name)
        }

        if (nameList.size == amount)
            return nameList

        name += "$count"
        count++
    }
}

/**
 * Gets a new unique from a base [name]. This function always return a name that is not in [Named Element List][nameds].
 */
fun getNewNamesBaseOnNameList(name: String, amount: Int, nameList: List<String>): List<String> {
    val names = nameList.toMutableList()
    val currentNameList = mutableListOf<String>()

    @Suppress("NAME_SHADOWING")
    var name = name
    var count = 0
    while (true) {
        if (!names.contains(name)) {
            currentNameList.add(name)
            names.add(name)
        }

        if (currentNameList.size == amount)
            return currentNameList

        name += "$count"
        count++
    }
}

/**
 * Gets a new unique from a base [name]. This function always return a name that is not in [Named Element List][nameds].
 */
fun getNewNameBasedOnNameList(name: String, nameList: List<String>): String {
    val names = nameList.toMutableList()

    if (!names.contains(name))
        return name

    var count = 0
    while (names.contains("$name$count")) {
        count++
    }

    return "$name$count"
}

/**
 * Checks if any [namedElements] has the name [name].
 */
fun contains(name: String, namedElements: List<Named>): Boolean =
    namedElements.any { it.name == name }
