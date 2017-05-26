[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [LocalCode](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`LocalCode(declaringType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`, declaration: `[`MethodDeclaration`](../-method-declaration/index.md)`, innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>)`

Local code execution constructor, this constructor resolves [invokeType](invoke-type.md) based on [declaration](-init-.md#com.github.jonathanxd.codeapi.base.LocalCode$<init>(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.base.MethodDeclaration, kotlin.collections.List((com.github.jonathanxd.codeapi.base.TypeDeclaration)))/declaration) and
[declaringType](-init-.md#com.github.jonathanxd.codeapi.base.LocalCode$<init>(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.base.MethodDeclaration, kotlin.collections.List((com.github.jonathanxd.codeapi.base.TypeDeclaration)))/declaringType).

`LocalCode(declaringType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, invokeType: `[`InvokeType`](../-invoke-type/index.md)`, declaration: `[`MethodDeclaration`](../-method-declaration/index.md)`, innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>)`

A local code (or local method). This code may be inlined or declared as method of current
type or translated to a lambda (for [InvokeDynamic.LambdaLocalCode](../-invoke-dynamic/-lambda-local-code/index.md)).

