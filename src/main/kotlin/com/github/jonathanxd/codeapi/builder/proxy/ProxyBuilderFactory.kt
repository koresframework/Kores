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
package com.github.jonathanxd.codeapi.builder.proxy

import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.TypeDeclaration
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.util.`is`
import com.github.jonathanxd.codeapi.util.codeType
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy
import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.KProperty1
import kotlin.reflect.full.*
import kotlin.reflect.jvm.javaType
import kotlin.reflect.jvm.jvmErasure
import kotlin.reflect.jvm.kotlinFunction

private val propertyCache = mutableMapOf<KClass<*>, List<PropertyInfo>>()

@Suppress("UNCHECKED_CAST")
fun <T : Any, B: Any> create(builder: KClass<T>, implementation: KClass<*>, defaults: B?): T {
    cachePropertyInfo(implementation)

    val constructor = implementation.primaryConstructor!!

    val properties = propertyCache[implementation]!!/*implementation.primaryConstructor!!.valueParameters.map {
        PropertyInfo(it.name!!, it.type.javaType.codeType)
    }*/

    val values = mutableMapOf<KParameter, Any?>()

    if(defaults != null) {
        val defaultsClass = defaults::class
        val defaultClassProperties = defaultsClass.memberProperties

        properties.forEach { prop ->
            val name = if(defaults is TypeDeclaration && prop.name == "qualifiedName") "specifiedName" else prop.name

            val find = defaultClassProperties.find { it.name == name }!! as KProperty1<B, Any?>

            values.put(prop.parameter, find.get(defaults)!!)

        }
    } else {
        properties.forEach { prop ->

            val value: Any? = when(prop.type.javaSpecName) {
                List::class.codeType.javaSpecName -> emptyList<Any>()
                Set::class.codeType.javaSpecName -> emptySet<Any>()
                CodeSource::class.codeType.javaSpecName -> CodeSource.empty()
                Comments::class.codeType.javaSpecName -> Comments.Absent
                Type::class.codeType.javaSpecName,
                CodeType::class.codeType.javaSpecName -> if(prop.name == "superClass") Types.OBJECT else null
                else -> null
            }


            values.put(prop.parameter, value)
        }
    }

    return Proxy.newProxyInstance(builder::class.java.classLoader, arrayOf(builder.java), InvocationHandler { proxy, method, args ->
        if(method.name.startsWith("with")) {
            val name = method.name.substring("with".length).decapitalize()

            if(!properties.any { it.name == name })
                return@InvocationHandler proxy
                //throw IllegalStateException("Property with name $name is not present in constructor $implementation of builder $builder.")

            val kparam = values.keys.find { it.name == name }!!

            if(!kparam.type.jvmErasure.java.isAssignableFrom(method.parameterTypes[0])) {
                val javaBuilder = builder.java

                val defaultImpl = javaBuilder.classes.find { it.name == "DefaultImpls" }

                if(defaultImpl != null)
                    return@InvocationHandler defaultImpl.getDeclaredMethod(method.name, javaBuilder, method.parameterTypes[0]).invoke(null, proxy, args[0])
                else
                    throw NoSuchMethodException("Cannot find right implementation of $method for implementation $implementation of builder $builder")
            }


            values[kparam] = args[0]


            return@InvocationHandler proxy

        }

        if(method.name.startsWith("get")) {
            val name = method.name.substring("get".length).decapitalize()

            if(!properties.any { it.name == name })
                throw IllegalStateException("Property with name $name is not present in constructor $implementation of builder $builder.")


            return@InvocationHandler values.keys.find { it.name == name }
        }

        if(method.name == "build") {
            return@InvocationHandler constructor.callBy(values)
        }

        throw NoSuchMethodException("Cannot find right implementation of $method for implementation $implementation of builder $builder")
    }) as T
}

private fun cachePropertyInfo(implementation: KClass<*>) {
    if (propertyCache.containsKey(implementation))
        return

    val primary = implementation.primaryConstructor!!

    val parameters = primary.valueParameters

    propertyCache.put(implementation, parameters.map {
        PropertyInfo(it.name!!, it.type.javaType.codeType, it)
    })

}

private data class PropertyInfo(val name: String, val type: CodeType, val parameter: KParameter)