[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.factory](index.md) / [invokeFieldSetter](.)

# invokeFieldSetter

`fun invokeFieldSetter(invokeType: `[`InvokeType`](../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, target: `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, value: `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invoke setter of a field (`set`+`capitalize(fieldName)`) with [value](invoke-field-setter.md#com.github.jonathanxd.codeapi.factory$invokeFieldSetter(com.github.jonathanxd.codeapi.base.InvokeType, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.CodePart)/value).

### Parameters

`invokeType` - Type of invocation

`localization` - Localization of setter

`target` - Target of invocation

`type` - Type of field.

`name` - Name of field.

`value` - Value to pass to setter