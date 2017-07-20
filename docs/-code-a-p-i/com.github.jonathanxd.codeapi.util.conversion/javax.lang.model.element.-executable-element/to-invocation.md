[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [javax.lang.model.element.ExecutableElement](index.md) / [toInvocation](.)

# toInvocation

`fun `[`ExecutableElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/ExecutableElement.html)`.toInvocation(invokeType: `[`InvokeType`](../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`?, target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>, elements: `[`Elements`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/util/Elements.html)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Create [ExecutableElement](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/ExecutableElement.html) from [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)

### Parameters

`invokeType` - Type of invocation, if null, CodeAPI will try to infer the invocation type.

`target` - Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../../com.github.jonathanxd.codeapi/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)).

`arguments` - Arguments to pass to method.