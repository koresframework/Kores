[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.factory](index.md) / [invokeFieldGetter](.)

# invokeFieldGetter

`fun invokeFieldGetter(invokeType: `[`InvokeType`](../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, target: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invoke getter of a field (`get`+`capitalize(fieldName)`).

### Parameters

`invokeType` - Type of invocation

`localization` - Localization of getter

`target` - Target of invocation

`type` - Type of field.

`name` - Name of field.