[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.factory](index.md) / [invokeFieldGetter](.)

# invokeFieldGetter

`fun invokeFieldGetter(invokeType: `[`InvokeType`](../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, localization: Type, target: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, type: Type, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invoke getter of a field (`get`+`capitalize(fieldName)`).

### Parameters

`invokeType` - Type of invocation

`localization` - Localization of getter

`target` - Target of invocation

`type` - Type of field.

`name` - Name of field.