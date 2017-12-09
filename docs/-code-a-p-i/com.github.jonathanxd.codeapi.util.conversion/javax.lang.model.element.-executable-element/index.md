[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [javax.lang.model.element.ExecutableElement](.)

### Extensions for javax.lang.model.element.ExecutableElement

| Name | Summary |
|---|---|
| [getConstructorDeclaration](get-constructor-declaration.md) | `fun ExecutableElement.getConstructorDeclaration(elements: Elements): `[`ConstructorDeclaration`](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) |
| [getMethodDeclaration](get-method-declaration.md) | `fun ExecutableElement.getMethodDeclaration(elements: Elements): `[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) |
| [getMethodInvokeSpec](get-method-invoke-spec.md) | `fun ExecutableElement.getMethodInvokeSpec(elements: Elements): `[`MethodInvokeSpec`](../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Gets [MethodInvokeSpec](../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md) of receiver [ExecutableElement](#) |
| [getMethodTypeSpec](get-method-type-spec.md) | `fun ExecutableElement.getMethodTypeSpec(elements: Elements): `[`MethodTypeSpec`](../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Gets [MethodTypeSpec](../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md) of receiver [ExecutableElement](#) |
| [getTypeSpec](get-type-spec.md) | `fun ExecutableElement.getTypeSpec(elements: Elements): `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)<br>Gets [TypeSpec](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md) of receiver [ExecutableElement](#) |
| [invokeType](invoke-type.md) | `val ExecutableElement.invokeType: `[`InvokeType`](../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)<br>Gets the invocation type of the [ExecutableElement](#). |
| [toInvocation](to-invocation.md) | `fun ExecutableElement.toInvocation(invokeType: `[`InvokeType`](../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`?, target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>, elements: Elements): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Create [ExecutableElement](#) from [Method](#) |
