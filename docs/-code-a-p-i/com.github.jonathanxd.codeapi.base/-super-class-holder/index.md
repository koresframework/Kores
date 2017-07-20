[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [SuperClassHolder](.)

# SuperClassHolder

`interface SuperClassHolder : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

Super class holder

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : SuperClassHolder, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [superClass](super-class.md) | `abstract val superClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Super type |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<SuperClassHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

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
| [AnonymousClass](../-anonymous-class/index.md) | `data class AnonymousClass : `[`TypeDeclaration`](../-type-declaration/index.md)`, SuperClassHolder, `[`ArgumentsHolder`](../-arguments-holder/index.md)`, `[`ImplementationHolder`](../-implementation-holder/index.md)<br>Anonymous class, in Bytecode, anonymous class can have implementations,
in other languages it depends on specification. (Official Java generator may comment implementations). |
| [ClassDeclaration](../-class-declaration/index.md) | `data class ClassDeclaration : `[`TypeDeclaration`](../-type-declaration/index.md)`, SuperClassHolder, `[`ImplementationHolder`](../-implementation-holder/index.md)<br>Declaration of a class. |
