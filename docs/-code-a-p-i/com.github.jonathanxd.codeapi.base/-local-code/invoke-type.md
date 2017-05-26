[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [LocalCode](index.md) / [invokeType](.)

# invokeType

`val invokeType: `[`InvokeType`](../-invoke-type/index.md)

Invocation type (static, virtual or interface) this depends on where [declaration](declaration.md)
is declared and which are the modifiers, if [declaration](declaration.md) is a instance method and declared in
an interface, this must be [InvokeType.INVOKE_INTERFACE](../-invoke-type/-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md), if [declaration](declaration.md) is `static`, this must be
[InvokeType.INVOKE_STATIC](../-invoke-type/-i-n-v-o-k-e_-s-t-a-t-i-c.md) does not matter if is declared in an interface or a class, if is not `static`
and is declared in a `class`, this must be [InvokeType.INVOKE_VIRTUAL](../-invoke-type/-i-n-v-o-k-e_-v-i-r-t-u-a-l.md). Read [InvokeType](../-invoke-type/index.md) for more information.

### Property

`invokeType` - Invocation type (static, virtual or interface) this depends on where [declaration](declaration.md)
is declared and which are the modifiers, if [declaration](declaration.md) is a instance method and declared in
an interface, this must be [InvokeType.INVOKE_INTERFACE](../-invoke-type/-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md), if [declaration](declaration.md) is `static`, this must be
[InvokeType.INVOKE_STATIC](../-invoke-type/-i-n-v-o-k-e_-s-t-a-t-i-c.md) does not matter if is declared in an interface or a class, if is not `static`
and is declared in a `class`, this must be [InvokeType.INVOKE_VIRTUAL](../-invoke-type/-i-n-v-o-k-e_-v-i-r-t-u-a-l.md). Read [InvokeType](../-invoke-type/index.md) for more information.