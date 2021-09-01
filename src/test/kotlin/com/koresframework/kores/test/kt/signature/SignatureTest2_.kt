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