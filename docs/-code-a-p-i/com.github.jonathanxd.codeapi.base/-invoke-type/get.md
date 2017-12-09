[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [InvokeType](index.md) / [get](.)

# get

`@JvmStatic fun get(type: Type?): `[`InvokeType`](index.md)

Get InvokeType corresponding to the [type](get.md#com.github.jonathanxd.codeapi.base.InvokeType.Companion$get(java.lang.reflect.Type)/type). If [type](get.md#com.github.jonathanxd.codeapi.base.InvokeType.Companion$get(java.lang.reflect.Type)/type) is null, [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c.md), if [type](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-interface.md), [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md), if not, [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l.md).

### Parameters

`type` - Type

**Return**
[INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c.md) if null, [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md) if is is an interface, or is not an interface [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l.md)

