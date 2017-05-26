[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Executable](index.md) / [toInvocation](.)

# toInvocation

`fun `[`Executable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Executable.html)`.toInvocation(invokeType: `[`InvokeType`](../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`?, target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, arguments: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Create [MethodInvocation](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md) from [Executable](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Executable.html)

### Parameters

`invokeType` - Type of invocation, if null, CodeAPI will try to infer the invocation type.

`target` - Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../../com.github.jonathanxd.codeapi/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)).

`arguments` - Arguments to pass to method.