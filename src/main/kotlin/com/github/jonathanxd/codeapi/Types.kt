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
package com.github.jonathanxd.codeapi

import com.github.jonathanxd.codeapi.annotation.GenerateTo
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.type.JavaType
import com.github.jonathanxd.codeapi.type.LoadedCodeType
import java.util.*

object Types {


    // Java.Lang
    @JvmField val OBJECT: LoadedCodeType<Any> = PredefinedType(Any::class.java)
    @JvmField val STRING: LoadedCodeType<String> = PredefinedType(String::class.java)
    @JvmField val SYSTEM: LoadedCodeType<System> = PredefinedType(System::class.java)
    @JvmField val ENUM: LoadedCodeType<Enum<*>> = PredefinedType(Enum::class.java)
    @JvmField val ANNOTATION: LoadedCodeType<Annotation> = PredefinedType(Annotation::class.java)
    @JvmField val CLASS: LoadedCodeType<Class<*>> = PredefinedType(Class::class.java)
    @JvmField val OVERRIDE: LoadedCodeType<Override> = PredefinedType(Override::class.java)
    @JvmField val STRING_BUILDER: LoadedCodeType<StringBuilder> = PredefinedType(StringBuilder::class.java)

    @JvmField val VOID: LoadedCodeType<Void> = PredefinedType(Void.TYPE)

    // Exceptions
    @JvmField val THROWABLE: LoadedCodeType<Throwable> = PredefinedType(Throwable::class.java)
    @JvmField val EXCEPTION: LoadedCodeType<Exception> = PredefinedType(Exception::class.java)
    @JvmField val RUNTIME_EXCEPTION: LoadedCodeType<RuntimeException> = PredefinedType(RuntimeException::class.java)


    // Primitive
    @JvmField val BYTE: LoadedCodeType<Byte> = PredefinedType(java.lang.Byte.TYPE)
    @JvmField val SHORT: LoadedCodeType<Short> = PredefinedType(java.lang.Short.TYPE)
    @JvmField val INT: LoadedCodeType<Int> = PredefinedType(Integer.TYPE)
    @JvmField val FLOAT: LoadedCodeType<Float> = PredefinedType(java.lang.Float.TYPE)
    @JvmField val DOUBLE: LoadedCodeType<Double> = PredefinedType(java.lang.Double.TYPE)
    @JvmField val LONG: LoadedCodeType<Long> = PredefinedType(java.lang.Long.TYPE)
    @JvmField val CHAR: LoadedCodeType<Char> = PredefinedType(Character.TYPE)
    @JvmField val BOOLEAN: LoadedCodeType<Boolean> = PredefinedType(java.lang.Boolean.TYPE)

    // Primitive Wrapper Types
    @JvmField val BYTE_WRAPPER: LoadedCodeType<Byte> = PredefinedType(Byte::class.javaObjectType)
    @JvmField val SHORT_WRAPPER: LoadedCodeType<Short> = PredefinedType(Short::class.javaObjectType)
    @JvmField val INTEGER_WRAPPER: LoadedCodeType<Int> = PredefinedType(Int::class.javaObjectType)
    @JvmField val FLOAT_WRAPPER: LoadedCodeType<Float> = PredefinedType(Float::class.javaObjectType)
    @JvmField val DOUBLE_WRAPPER: LoadedCodeType<Double> = PredefinedType(Double::class.javaObjectType)
    @JvmField val LONG_WRAPPER: LoadedCodeType<Long> = PredefinedType(Long::class.javaObjectType)
    @JvmField val CHARACTER_WRAPPER: LoadedCodeType<Char> = PredefinedType(Char::class.javaObjectType)
    @JvmField val BOOLEAN_WRAPPER: LoadedCodeType<Boolean> = PredefinedType(Boolean::class.javaObjectType)

    // Java.Util
    @JvmField val ITERABLE: LoadedCodeType<Iterable<*>> = PredefinedType(Iterable::class.java)
    @JvmField val ITERATOR: LoadedCodeType<Iterator<*>> = PredefinedType(Iterator::class.java)
    @JvmField val COLLECTION: LoadedCodeType<Collection<*>> = PredefinedType(Collection::class.java)
    @JvmField val LIST: LoadedCodeType<List<*>> = PredefinedType(List::class.java)
    @JvmField val SET: LoadedCodeType<Set<*>> = PredefinedType(Set::class.java)
    @JvmField val DEQUE: LoadedCodeType<Deque<*>> = PredefinedType(Deque::class.java)

    // CodeAPI
    @JvmField val CODE_TYPE: LoadedCodeType<CodeType> = PredefinedType(CodeType::class.java)

    @GenerateTo(CodeType::class)
    private class PredefinedType<T> internal constructor(tClass: Class<T>) : JavaType<T>(tClass)

}