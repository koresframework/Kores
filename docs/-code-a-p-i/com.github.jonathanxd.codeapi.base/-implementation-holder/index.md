[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ImplementationHolder](.)

# ImplementationHolder

`interface ImplementationHolder : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

An implementation holder

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : ImplementationHolder, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [implementations](implementations.md) | `abstract val implementations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>Implementations |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<ImplementationHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [AnonymousClass](../-anonymous-class/index.md) | `data class AnonymousClass : `[`TypeDeclaration`](../-type-declaration/index.md)`, `[`SuperClassHolder`](../-super-class-holder/index.md)`, `[`ArgumentsHolder`](../-arguments-holder/index.md)`, ImplementationHolder, `[`ConstructorsHolder`](../-constructors-holder/index.md)<br>Anonymous class, in Bytecode, anonymous class can have implementations, in other languages it depends on specification. (Official Java generator may comment implementations). |
| [ClassDeclaration](../-class-declaration/index.md) | `data class ClassDeclaration : `[`TypeDeclaration`](../-type-declaration/index.md)`, `[`SuperClassHolder`](../-super-class-holder/index.md)`, ImplementationHolder, `[`ConstructorsHolder`](../-constructors-holder/index.md)<br>Declaration of a class. |
| [EnumDeclaration](../-enum-declaration/index.md) | `data class EnumDeclaration : `[`TypeDeclaration`](../-type-declaration/index.md)`, ImplementationHolder, `[`EntryHolder`](../-entry-holder/index.md)`, `[`ConstructorsHolder`](../-constructors-holder/index.md)<br>Enum declaration. |
| [InterfaceDeclaration](../-interface-declaration/index.md) | `data class InterfaceDeclaration : `[`TypeDeclaration`](../-type-declaration/index.md)`, ImplementationHolder`<br>Interface declaration. |
