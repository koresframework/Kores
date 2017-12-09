[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Executable](index.md) / [toInvocation](.)

# toInvocation

`fun Executable.toInvocation(invokeType: `[`InvokeType`](../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`?, target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Create [MethodInvocation](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md) from [Executable](#)

### Parameters

`invokeType` - Type of invocation, if null, CodeAPI will try to infer the invocation type.

`target` - Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../../com.github.jonathanxd.codeapi/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)).

`arguments` - Arguments to pass to method.