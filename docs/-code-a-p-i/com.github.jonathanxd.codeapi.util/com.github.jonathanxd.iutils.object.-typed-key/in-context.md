[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [com.github.jonathanxd.iutils.object.TypedKey](index.md) / [inContext](.)

# inContext

`inline fun <T> TypedKey<T>.inContext(data: TypedData, value: T, context: () -> Unit): Unit`

This value only lives in the [context](in-context.md#com.github.jonathanxd.codeapi.util$inContext(com.github.jonathanxd.iutils.object.TypedKey((com.github.jonathanxd.codeapi.util.inContext.T)), com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.util.inContext.T, kotlin.Function0((kotlin.Unit)))/context), when the call of [context](in-context.md#com.github.jonathanxd.codeapi.util$inContext(com.github.jonathanxd.iutils.object.TypedKey((com.github.jonathanxd.codeapi.util.inContext.T)), com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.util.inContext.T, kotlin.Function0((kotlin.Unit)))/context) finishes the key value is removed.

Does not works with threads.

