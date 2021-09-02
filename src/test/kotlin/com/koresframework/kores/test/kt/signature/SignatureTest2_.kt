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
package com.koresframework.kores.test.kt.signature

import com.koresframework.kores.Types
import com.koresframework.kores.base.*
import com.koresframework.kores.exception.STUB
import com.koresframework.kores.factory.source
import com.koresframework.kores.factory.variable
import com.koresframework.kores.literal.*
import com.koresframework.kores.test.kt.LiteralTest_
import com.koresframework.kores.type.bindedDefaultResolver
import com.koresframework.kores.type.typeOf
import com.koresframework.kores.util.conversion.toLiteral
import com.koresframework.kores.util.methodClassfileGenericSignature
import com.koresframework.kores.util.methodGenericSignature
import com.koresframework.kores.util.parametersAndReturnToInferredDesc
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.lang.reflect.Type

class SignatureTest2_ {
    fun `$`(): Pair<TypeDeclaration, MethodDeclaration> {

        val genericFn = typeOf<Companion>().bindedDefaultResolver.resolveMethods().right.first()

        return typeOf<Companion>().bindedDefaultResolver.resolveTypeDeclaration().right to genericFn
    }

    @Test
    fun test() {
        val (type, method) = `$`()
        // Should be inferred type and no generic types
        // because Javac erases types in classfiles, no generic information is kept
        // only the GenericSignature holds this kind of information
        assertEquals("(Ljava/lang/reflect/Type;Ljava/lang/Object;Lcom/koresframework/kores/test/kt/signature/Magic2;Ljava/util/List;)Lcom/koresframework/kores/test/kt/signature/Magic2;", parametersAndReturnToInferredDesc(lazy { type }, method, method.parameters, method.returnType))

        //
        assertEquals("<T:Ljava/lang/Object;M::Lcom/koresframework/kores/test/kt/signature/Magic2<TT;TM;>;>(Ljava/lang/reflect/Type;TT;TM;Ljava/util/List<+TM;>;)TM;", method.methodClassfileGenericSignature())
    }

    companion object {
        fun <T, M: Magic2<T, M>> apply(type: Type, data: T, m: M, l: List<M>): M =
            STUB("apply")
    }



}

fun interface Magic2<T, M: Magic<T, M>> {
    fun apply(data: T)
}