[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [LocalCode](.)

# LocalCode

`data class LocalCode : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)

A local code (or local method). This code may be inlined or declared as method of current
type or translated to a lambda (for [InvokeDynamic.LambdaLocalCode](../-invoke-dynamic/-lambda-local-code/index.md)).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<LocalCode, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-inner-types-holder/-builder/index.md)`<LocalCode, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LocalCode(declaringType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`, declaration: `[`MethodDeclaration`](../-method-declaration/index.md)`, innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>)`<br>Local code execution constructor, this constructor resolves [invokeType](invoke-type.md) based on [declaration](-init-.md#com.github.jonathanxd.codeapi.base.LocalCode$<init>(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.base.MethodDeclaration, kotlin.collections.List((com.github.jonathanxd.codeapi.base.TypeDeclaration)))/declaration) and
[declaringType](-init-.md#com.github.jonathanxd.codeapi.base.LocalCode$<init>(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.base.MethodDeclaration, kotlin.collections.List((com.github.jonathanxd.codeapi.base.TypeDeclaration)))/declaringType).`LocalCode(declaringType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, invokeType: `[`InvokeType`](../-invoke-type/index.md)`, declaration: `[`MethodDeclaration`](../-method-declaration/index.md)`, innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>)`<br>A local code (or local method). This code may be inlined or declared as method of current
type or translated to a lambda (for [InvokeDynamic.LambdaLocalCode](../-invoke-dynamic/-lambda-local-code/index.md)). |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `val body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)<br>Method body |
| [declaration](declaration.md) | `val declaration: `[`MethodDeclaration`](../-method-declaration/index.md)<br>Method declaration of the code. |
| [declaringType](declaring-type.md) | `val declaringType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Declaring type of [declaration](declaration.md) ([Alias](../../com.github.jonathanxd.codeapi.util/-alias/index.md) is supported) |
| [description](description.md) | `val description: `[`TypeSpec`](../-type-spec/index.md)<br>Method description |
| [innerTypes](inner-types.md) | `val innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>`<br>Inner types |
| [invokeType](invoke-type.md) | `val invokeType: `[`InvokeType`](../-invoke-type/index.md)<br>Invocation type (static, virtual or interface) this depends on where [declaration](declaration.md)
is declared and which are the modifiers, if [declaration](declaration.md) is a instance method and declared in
an interface, this must be [InvokeType.INVOKE_INTERFACE](../-invoke-type/-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md), if [declaration](declaration.md) is `static`, this must be
[InvokeType.INVOKE_STATIC](../-invoke-type/-i-n-v-o-k-e_-s-t-a-t-i-c.md) does not matter if is declared in an interface or a class, if is not `static`
and is declared in a `class`, this must be [InvokeType.INVOKE_VIRTUAL](../-invoke-type/-i-n-v-o-k-e_-v-i-r-t-u-a-l.md). Read [InvokeType](../-invoke-type/index.md) for more information. |
| [parameters](parameters.md) | `val parameters: List<`[`CodeParameter`](../-code-parameter/index.md)`>`<br>Parameters |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [createInvocation](create-invocation.md) | `fun createInvocation(arguments: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Creates a invocation of this LocalCode with [arguments](create-invocation.md#com.github.jonathanxd.codeapi.base.LocalCode$createInvocation(kotlin.collections.List((com.github.jonathanxd.codeapi.CodePart)))/arguments). |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
