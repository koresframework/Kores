[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [InvokeType](index.md) / [get](.)

# get

`fun get(codeType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?): `[`InvokeType`](index.md)

Get InvokeType corresponding to the [codeType](get.md#com.github.jonathanxd.codeapi.base.InvokeType.Companion$get(com.github.jonathanxd.codeapi.type.CodeType)/codeType). If [codeType](get.md#com.github.jonathanxd.codeapi.base.InvokeType.Companion$get(com.github.jonathanxd.codeapi.type.CodeType)/codeType) is null, [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c.md), if [CodeType.isInterface](../../com.github.jonathanxd.codeapi.type/-code-type/is-interface.md),
[INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md) else [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l.md).

### Parameters

`codeType` - Code Type

**Return**
[INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c.md) if null, [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md) if is is an interface, or is not an interface [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l.md)

