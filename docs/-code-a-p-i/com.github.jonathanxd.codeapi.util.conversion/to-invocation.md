[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util.conversion](index.md) / [toInvocation](.)

# toInvocation

`fun `[`MethodTypeSpec`](../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`.toInvocation(invokeType: `[`InvokeType`](../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, target: `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, arguments: List<`[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`>): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Create [MethodInvocation](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md) from [MethodTypeSpec](../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)

### Parameters

`invokeType` - Type of invocation.

`target` - Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../com.github.jonathanxd.codeapi/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)).

`arguments` - Arguments to pass to method.

`fun `[`MethodInvokeSpec`](../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`.toInvocation(target: `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, arguments: List<`[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`>): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Create [MethodInvocation](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md) from [MethodInvokeSpec](../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)

### Parameters

`target` - Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../com.github.jonathanxd.codeapi/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)).

`arguments` - Arguments to pass to method.