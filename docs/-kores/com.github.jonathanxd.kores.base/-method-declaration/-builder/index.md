//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[MethodDeclaration](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [MethodDeclarationBase.Builder](../../-method-declaration-base/-builder/index.md)<[MethodDeclaration](../index.md), [MethodDeclaration.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [MethodDeclaration](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | [jvm]<br>open fun [annotations](../../-annotable/-builder/annotations.md)(vararg values: [Annotation](../../-annotation/index.md)): [MethodDeclaration.Builder](index.md)<br>open override fun [annotations](annotations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)>): [MethodDeclaration.Builder](index.md)<br>See T. |
| [body](body.md) | [jvm]<br>open override fun [body](body.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [MethodDeclaration.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [MethodDeclaration](../index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [comments](comments.md) | [jvm]<br>open override fun [comments](comments.md)(value: [Comments](../../../com.github.jonathanxd.kores.base.comment/-comments/index.md)): [MethodDeclaration.Builder](index.md)<br>See [CommentHolder.comments](../../../com.github.jonathanxd.kores.base.comment/-comment-holder/comments.md) |
| [genericSignature](generic-signature.md) | [jvm]<br>open override fun [genericSignature](generic-signature.md)(value: [GenericSignature](../../../com.github.jonathanxd.kores.generic/-generic-signature/index.md)): [MethodDeclaration.Builder](index.md)<br>See T. |
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | [jvm]<br>open fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(vararg values: [TypeDeclaration](../../-type-declaration/index.md)): [MethodDeclaration.Builder](index.md)<br>open override fun [innerTypes](inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)>): [MethodDeclaration.Builder](index.md)<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [modifiers](modifiers.md) | [jvm]<br>open override fun [modifiers](modifiers.md)(value: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)>): [MethodDeclaration.Builder](index.md)<br>open fun [modifiers](../../-modifiers-holder/-builder/modifiers.md)(vararg values: [KoresModifier](../../-kores-modifier/index.md)): [MethodDeclaration.Builder](index.md)<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodDeclaration.Builder](index.md) |
| [parameters](parameters.md) | [jvm]<br>open override fun [parameters](parameters.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../../-kores-parameter/index.md)>): [MethodDeclaration.Builder](index.md)<br>open fun [parameters](../../-parameters-holder/-builder/parameters.md)(vararg values: [KoresParameter](../../-kores-parameter/index.md)): [MethodDeclaration.Builder](index.md)<br>See T. |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | [jvm]<br>open fun [publicModifier](../../-modifiers-holder/-builder/public-modifier.md)(): [MethodDeclaration.Builder](index.md)<br>Sets modifiers to [KoresModifier.PUBLIC](../../-kores-modifier/-p-u-b-l-i-c/index.md). |
| [returnType](return-type.md) | [jvm]<br>open override fun [returnType](return-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodDeclaration.Builder](index.md)<br>See T. |
| [throwsClause](throws-clause.md) | [jvm]<br>open override fun [throwsClause](throws-clause.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>): [MethodDeclaration.Builder](index.md)<br>open fun [throwsClause](../../-throws-holder/-builder/throws-clause.md)(vararg values: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodDeclaration.Builder](index.md)<br>See [ThrowsHolder.throwsClause](../../-throws-holder/throws-clause.md) |
| [type](../../-method-declaration-base/-builder/type.md) | [jvm]<br>open override fun [type](../../-method-declaration-base/-builder/type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodDeclaration.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>var [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)> |
| [body](body.md) | [jvm]<br>var [body](body.md): [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md) |
| [comments](comments.md) | [jvm]<br>var [comments](comments.md): [Comments](../../../com.github.jonathanxd.kores.base.comment/-comments/index.md) |
| [genericSignature](generic-signature.md) | [jvm]<br>var [genericSignature](generic-signature.md): [GenericSignature](../../../com.github.jonathanxd.kores.generic/-generic-signature/index.md) |
| [innerTypes](inner-types.md) | [jvm]<br>var [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)> |
| [modifiers](modifiers.md) | [jvm]<br>var [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)> |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [parameters](parameters.md) | [jvm]<br>var [parameters](parameters.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../../-kores-parameter/index.md)> |
| [returnType](return-type.md) | [jvm]<br>var [returnType](return-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [throws](throws.md) | [jvm]<br>var [throws](throws.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> |

## Extensions

| Name | Summary |
|---|---|
| [parameters1](../../../com.github.jonathanxd.kores.util/parameters1.md) | [jvm]<br>inline fun <[P1](../../../com.github.jonathanxd.kores.util/parameters1.md)> [MethodDeclaration.Builder](index.md).[parameters1](../../../com.github.jonathanxd.kores.util/parameters1.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodDeclaration.Builder](index.md) |
| [parameters2](../../../com.github.jonathanxd.kores.util/parameters2.md) | [jvm]<br>inline fun <[P1](../../../com.github.jonathanxd.kores.util/parameters2.md), [P2](../../../com.github.jonathanxd.kores.util/parameters2.md)> [MethodDeclaration.Builder](index.md).[parameters2](../../../com.github.jonathanxd.kores.util/parameters2.md)(name1: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name2: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodDeclaration.Builder](index.md) |
| [parameters3](../../../com.github.jonathanxd.kores.util/parameters3.md) | [jvm]<br>inline fun <[P1](../../../com.github.jonathanxd.kores.util/parameters3.md), [P2](../../../com.github.jonathanxd.kores.util/parameters3.md), [P3](../../../com.github.jonathanxd.kores.util/parameters3.md)> [MethodDeclaration.Builder](index.md).[parameters3](../../../com.github.jonathanxd.kores.util/parameters3.md)(name1: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name2: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name3: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodDeclaration.Builder](index.md) |
| [parameters4](../../../com.github.jonathanxd.kores.util/parameters4.md) | [jvm]<br>inline fun <[P1](../../../com.github.jonathanxd.kores.util/parameters4.md), [P2](../../../com.github.jonathanxd.kores.util/parameters4.md), [P3](../../../com.github.jonathanxd.kores.util/parameters4.md), [P4](../../../com.github.jonathanxd.kores.util/parameters4.md)> [MethodDeclaration.Builder](index.md).[parameters4](../../../com.github.jonathanxd.kores.util/parameters4.md)(name1: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name2: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name3: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name4: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodDeclaration.Builder](index.md) |
| [parameters5](../../../com.github.jonathanxd.kores.util/parameters5.md) | [jvm]<br>inline fun <[P1](../../../com.github.jonathanxd.kores.util/parameters5.md), [P2](../../../com.github.jonathanxd.kores.util/parameters5.md), [P3](../../../com.github.jonathanxd.kores.util/parameters5.md), [P4](../../../com.github.jonathanxd.kores.util/parameters5.md), [P5](../../../com.github.jonathanxd.kores.util/parameters5.md)> [MethodDeclaration.Builder](index.md).[parameters5](../../../com.github.jonathanxd.kores.util/parameters5.md)(name1: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name2: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name3: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name4: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), name5: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodDeclaration.Builder](index.md) |
| [parametersVararg](../../../com.github.jonathanxd.kores.util/parameters-vararg.md) | [jvm]<br>fun [MethodDeclaration.Builder](index.md).[parametersVararg](../../../com.github.jonathanxd.kores.util/parameters-vararg.md)(vararg parameters: [KoresParameter](../../-kores-parameter/index.md)): [MethodDeclaration.Builder](index.md) |
| [returnType](../../../com.github.jonathanxd.kores.util/return-type.md) | [jvm]<br>inline fun <[R](../../../com.github.jonathanxd.kores.util/return-type.md)> [MethodDeclaration.Builder](index.md).[returnType](../../../com.github.jonathanxd.kores.util/return-type.md)(): [MethodDeclaration.Builder](index.md) |
