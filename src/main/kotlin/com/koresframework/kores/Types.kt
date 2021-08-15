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
package com.koresframework.kores

import com.koresframework.kores.type.KoresType
import com.koresframework.kores.type.JavaType
import com.koresframework.kores.type.LoadedKoresType
import com.github.jonathanxd.iutils.collection.Collections3
import com.koresframework.kores.serialization.TypeSerializer
import kotlinx.serialization.Serializable
import java.util.*
import java.util.function.Supplier

// Please keep this formatting.
object Types {

    // Java.Lang
    @JvmField val OBJECT: LoadedKoresType<Any> = PredefinedType(Any::class.java)
    @JvmField val STRING: LoadedKoresType<String> = PredefinedType(String::class.java)
    @JvmField val SYSTEM: LoadedKoresType<System> = PredefinedType(System::class.java)
    @JvmField val ENUM: LoadedKoresType<Enum<*>> = PredefinedType(Enum::class.java)
    @JvmField val ANNOTATION: LoadedKoresType<Annotation> = PredefinedType(Annotation::class.java)
    @JvmField val CLASS: LoadedKoresType<Class<*>> = PredefinedType(Class::class.java)
    @JvmField val OVERRIDE: LoadedKoresType<Override> = PredefinedType(Override::class.java)
    @JvmField val STRING_BUILDER: LoadedKoresType<StringBuilder> = PredefinedType(StringBuilder::class.java)
    @JvmField val COMPARABLE: LoadedKoresType<Comparable<*>> = PredefinedType(Comparable::class.java)

    // Exceptions
    @JvmField val THROWABLE: LoadedKoresType<Throwable> = PredefinedType(Throwable::class.java)
    @JvmField val EXCEPTION: LoadedKoresType<Exception> = PredefinedType(Exception::class.java)
    @JvmField val RUNTIME_EXCEPTION: LoadedKoresType<RuntimeException> = PredefinedType(RuntimeException::class.java)


    // Primitive
    @JvmField val BYTE: LoadedKoresType<Byte> = PredefinedType(java.lang.Byte.TYPE)
    @JvmField val SHORT: LoadedKoresType<Short> = PredefinedType(java.lang.Short.TYPE)
    @JvmField val INT: LoadedKoresType<Int> = PredefinedType(Integer.TYPE)
    @JvmField val FLOAT: LoadedKoresType<Float> = PredefinedType(java.lang.Float.TYPE)
    @JvmField val DOUBLE: LoadedKoresType<Double> = PredefinedType(java.lang.Double.TYPE)
    @JvmField val LONG: LoadedKoresType<Long> = PredefinedType(java.lang.Long.TYPE)
    @JvmField val CHAR: LoadedKoresType<Char> = PredefinedType(Character.TYPE)
    @JvmField val BOOLEAN: LoadedKoresType<Boolean> = PredefinedType(java.lang.Boolean.TYPE)
    @JvmField val VOID: LoadedKoresType<Void> = PredefinedType(Void.TYPE)

    // Primitive Wrapper Types
    @JvmField val BYTE_WRAPPER: LoadedKoresType<Byte> = PredefinedType(Byte::class.javaObjectType)
    @JvmField val SHORT_WRAPPER: LoadedKoresType<Short> = PredefinedType(Short::class.javaObjectType)
    @JvmField val INTEGER_WRAPPER: LoadedKoresType<Int> = PredefinedType(Int::class.javaObjectType)
    @JvmField val FLOAT_WRAPPER: LoadedKoresType<Float> = PredefinedType(Float::class.javaObjectType)
    @JvmField val DOUBLE_WRAPPER: LoadedKoresType<Double> = PredefinedType(Double::class.javaObjectType)
    @JvmField val LONG_WRAPPER: LoadedKoresType<Long> = PredefinedType(Long::class.javaObjectType)
    @JvmField val CHARACTER_WRAPPER: LoadedKoresType<Char> = PredefinedType(Char::class.javaObjectType)
    @JvmField val BOOLEAN_WRAPPER: LoadedKoresType<Boolean> = PredefinedType(Boolean::class.javaObjectType)

    // Java.Util
    @JvmField val ITERABLE: LoadedKoresType<Iterable<*>> = PredefinedType(Iterable::class.java)
    @JvmField val ITERATOR: LoadedKoresType<Iterator<*>> = PredefinedType(Iterator::class.java)
    @JvmField val COLLECTION: LoadedKoresType<Collection<*>> = PredefinedType(Collection::class.java)
    @JvmField val LIST: LoadedKoresType<List<*>> = PredefinedType(List::class.java)
    @JvmField val SET: LoadedKoresType<Set<*>> = PredefinedType(Set::class.java)
    @JvmField val MAP: LoadedKoresType<Map<*, *>> = PredefinedType(Map::class.java)
    @JvmField val DEQUE: LoadedKoresType<Deque<*>> = PredefinedType(Deque::class.java)
    @JvmField val COMPARATOR: LoadedKoresType<Comparator<*>> = PredefinedType(Comparator::class.java)
    @JvmField val OBJECTS: LoadedKoresType<Objects> = PredefinedType(Objects::class.java)
    @JvmField val COLLECTIONS: LoadedKoresType<Collections> = PredefinedType(Collections::class.java)

    // Java.Util.Function
    @JvmField val SUPPLIER: LoadedKoresType<Supplier<*>> = PredefinedType(Supplier::class.java)

    // Kores
    @JvmField val KORES_TYPE: LoadedKoresType<KoresType> = PredefinedType(KoresType::class.java)
    @JvmField val KORES_PART: LoadedKoresType<KoresPart> = PredefinedType(KoresPart::class.java)

    @JvmField val COLLECTIONS3: LoadedKoresType<Collections3> = PredefinedType(Collections3::class.java)

    @Serializable(with = TypeSerializer::class)
    internal class PredefinedType<T> internal constructor(tClass: Class<T>) : JavaType<T>(tClass)

}