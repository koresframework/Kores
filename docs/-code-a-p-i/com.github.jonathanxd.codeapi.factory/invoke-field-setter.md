[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.factory](index.md) / [invokeFieldSetter](.)

# invokeFieldSetter

`fun invokeFieldSetter(invokeType: `[`InvokeType`](../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, localization: Type, target: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, type: Type, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invoke setter of a field (`set`+`capitalize(fieldName)`) with [value](invoke-field-setter.md#com.github.jonathanxd.codeapi.factory$invokeFieldSetter(com.github.jonathanxd.codeapi.base.InvokeType, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.CodeInstruction)/value).

### Parameters

`invokeType` - Type of invocation

`localization` - Localization of setter

`target` - Target of invocation

`type` - Type of field.

`name` - Name of field.

`value` - Value to pass to setter