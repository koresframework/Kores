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
package com.github.jonathanxd.codeapi.util.conversion

import com.github.jonathanxd.codeapi.base.FieldDeclaration
import com.github.jonathanxd.codeapi.base.MethodDeclaration
import com.github.jonathanxd.codeapi.base.TypeDeclaration
import com.github.jonathanxd.codeapi.util.`is`
import com.github.jonathanxd.codeapi.util.codeType
import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * Searches [methodDeclaration] in this [Class].
 */
fun <T : Any> Class<T>.find(methodDeclaration: MethodDeclaration): Method? {
    val filter = filter@ { it: Method ->
        val name = it.name
        val returnType = it.returnType.codeType
        val parameterTypes = it.parameterTypes.map { it.codeType }

        return@filter name == methodDeclaration.name
                && returnType.`is`(methodDeclaration.returnType)
                && parameterTypes.isEqual(methodDeclaration.parameters)
    }

    return this.declaredMethods.first(filter) ?: this.methods.first(filter)

}

/**
 * Searches [fieldDeclaration] in this [Class].
 */
fun <T : Any> Class<T>.find(fieldDeclaration: FieldDeclaration): Field? {
    val filter = filter@ { it: Field ->
        val name = it.name
        val type = it.type.codeType

        return@filter name == fieldDeclaration.name
                && type.`is`(fieldDeclaration.type)
    }

    return this.declaredFields.first(filter) ?: this.fields.first(filter)

}

/**
 * Searches the [typeDeclaration] in this [Class].
 */
fun <T : Any> Class<T>.find(typeDeclaration: TypeDeclaration): Class<*>? {
    val filter = filter@ { it: Class<*> ->
        val type = it.codeType

        return@filter type.`is`(typeDeclaration)
    }

    return this.declaredClasses.first(filter) ?: this.classes.first(filter)

}