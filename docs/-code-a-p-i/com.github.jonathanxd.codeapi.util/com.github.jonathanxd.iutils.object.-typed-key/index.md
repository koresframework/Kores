[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [com.github.jonathanxd.iutils.object.TypedKey](.)

### Extensions for com.github.jonathanxd.iutils.object.TypedKey

| Name | Summary |
|---|---|
| [add](add.md) | `fun <T> TypedKey<MutableList<T>>.add(data: TypedData, value: T): Unit`<br>Adds [value](add.md#com.github.jonathanxd.codeapi.util$add(com.github.jonathanxd.iutils.object.TypedKey((kotlin.collections.MutableList((com.github.jonathanxd.codeapi.util.add.T)))), com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.util.add.T)/value) to list associated to this key |
| [inContext](in-context.md) | `fun <T> TypedKey<T>.inContext(data: TypedData, value: T, context: () -> Unit): Unit`<br>This value only lives in the [context](in-context.md#com.github.jonathanxd.codeapi.util$inContext(com.github.jonathanxd.iutils.object.TypedKey((com.github.jonathanxd.codeapi.util.inContext.T)), com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.util.inContext.T, kotlin.Function0((kotlin.Unit)))/context), when the call of [context](in-context.md#com.github.jonathanxd.codeapi.util$inContext(com.github.jonathanxd.iutils.object.TypedKey((com.github.jonathanxd.codeapi.util.inContext.T)), com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.util.inContext.T, kotlin.Function0((kotlin.Unit)))/context) finishes the key value is removed. |
| [require](require.md) | `fun <T> TypedKey<T>.require(data: TypedData): T`<br>Requires [data](require.md#com.github.jonathanxd.codeapi.util$require(com.github.jonathanxd.iutils.object.TypedKey((com.github.jonathanxd.codeapi.util.require.T)), com.github.jonathanxd.iutils.data.TypedData)/data) to have any value associated to this key. |
