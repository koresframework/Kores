[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ArgumentsHolder](.)

# ArgumentsHolder

`interface ArgumentsHolder : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

Hold arguments.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : ArgumentsHolder, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `abstract val arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Argument list |
| [array](array.md) | `abstract val array: Boolean`<br>Array arguments |
| [types](types.md) | `abstract val types: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Expected types of each argument |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<ArgumentsHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [AnonymousClass](../-anonymous-class/index.md) | `data class AnonymousClass : `[`TypeDeclaration`](../-type-declaration/index.md)`, `[`SuperClassHolder`](../-super-class-holder/index.md)`, ArgumentsHolder, `[`ImplementationHolder`](../-implementation-holder/index.md)<br>Anonymous class, in Bytecode, anonymous class can have implementations,
in other languages it depends on specification. (Official Java generator may comment implementations). |
| [ArrayConstructor](../-array-constructor/index.md) | `data class ArrayConstructor : ArgumentsHolder, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Constructs an array of type [arrayType](../-array-constructor/array-type.md) with dimensions [dimensions](../-array-constructor/dimensions.md). Example: |
| [EnumEntry](../-enum-entry/index.md) | `data class EnumEntry : ArgumentsHolder, `[`Named`](../-named/index.md)`, `[`ElementsHolder`](../-elements-holder/index.md)<br>Enumeration entry. |
| [LambdaLocalCodeBase](../-invoke-dynamic-base/-lambda-local-code-base/index.md) | `interface LambdaLocalCodeBase : `[`LambdaMethodRefBase`](../-invoke-dynamic-base/-lambda-method-ref-base/index.md)`, ArgumentsHolder`<br>Invocation of lambda function. |
| [MethodInvocation](../-method-invocation/index.md) | `data class MethodInvocation : `[`Accessor`](../-accessor/index.md)`, ArgumentsHolder, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Invokes a method. |
