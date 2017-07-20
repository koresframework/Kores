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
| [createInvocation](create-invocation.md) | `fun createInvocation(arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Creates a invocation of this LocalCode with [arguments](create-invocation.md#com.github.jonathanxd.codeapi.base.LocalCode$createInvocation(kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/arguments). |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [safeForComparison](../../com.github.jonathanxd.codeapi.util/safe-for-comparison.md) | `val `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.safeForComparison: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Gets comparison safe version of a [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [invoke](../../com.github.jonathanxd.codeapi.factory/invoke.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invoke(invokeType: `[`InvokeType`](../-invoke-type/index.md)`, localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [invokeIntToString](../../com.github.jonathanxd.codeapi.helper/invoke-int-to-string.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeIntToString(): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes `String.valueOf(int)` on receiver. |
| [invokeInterface](../../com.github.jonathanxd.codeapi.factory/invoke-interface.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeInterface(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [invokeToString](../../com.github.jonathanxd.codeapi.helper/invoke-to-string.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeToString(): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes `Any.toString` on receiver. |
| [invokeVirtual](../../com.github.jonathanxd.codeapi.factory/invoke-virtual.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeVirtual(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [unwrap](../../com.github.jonathanxd.codeapi.util/unwrap.md) | `tailrec fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.unwrap(): `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Unwraps [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) if is a [InstructionWrapper](#) or return receiver if not. |
