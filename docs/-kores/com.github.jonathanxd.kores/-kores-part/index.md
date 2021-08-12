//[Kores](../../../index.md)/[com.github.jonathanxd.kores](../index.md)/[KoresPart](index.md)

# KoresPart

[jvm]\
interface [KoresPart](index.md)

A KoresPart is the heart of Kores, all elements that can appear in the code must extend KoresPart.

All interfaces that have a concrete implementation and extends [KoresPart](index.md) must provide a builder method that return a builder instance with defined default values.

## Types

| Name | Summary |
|---|---|
| [SelfBuilder](-self-builder/index.md) | [jvm]<br>class [SelfBuilder](-self-builder/index.md)(**self**: [KoresPart](index.md)) : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](index.md), [KoresPart.SelfBuilder](-self-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open fun [builder](builder.md)(): [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Inheritors

| Name |
|---|
| [Instruction](../-instruction/index.md) |
| [Instructions](../-instructions/index.md) |
| [KoresElement](../-kores-element/index.md) |
| [Annotable](../../com.github.jonathanxd.kores.base/-annotable/index.md) |
| [ArgumentsHolder](../../com.github.jonathanxd.kores.base/-arguments-holder/index.md) |
| [ArrayAccess](../../com.github.jonathanxd.kores.base/-array-access/index.md) |
| [BodyHolder](../../com.github.jonathanxd.kores.base/-body-holder/index.md) |
| [Concat](../../com.github.jonathanxd.kores.base/-concat/index.md) |
| [ConstructorsHolder](../../com.github.jonathanxd.kores.base/-constructors-holder/index.md) |
| [ControlFlow](../../com.github.jonathanxd.kores.base/-control-flow/index.md) |
| [EntryHolder](../../com.github.jonathanxd.kores.base/-entry-holder/index.md) |
| [GenericSignatureHolder](../../com.github.jonathanxd.kores.base/-generic-signature-holder/index.md) |
| [IfExpr](../../com.github.jonathanxd.kores.base/-if-expr/index.md) |
| [IfExpressionHolder](../../com.github.jonathanxd.kores.base/-if-expression-holder/index.md) |
| [IfGroup](../../com.github.jonathanxd.kores.base/-if-group/index.md) |
| [ImplementationHolder](../../com.github.jonathanxd.kores.base/-implementation-holder/index.md) |
| [InnerTypesHolder](../../com.github.jonathanxd.kores.base/-inner-types-holder/index.md) |
| [KoresModifier](../../com.github.jonathanxd.kores.base/-kores-modifier/index.md) |
| [LocalCode](../../com.github.jonathanxd.kores.base/-local-code/index.md) |
| [ModifiersHolder](../../com.github.jonathanxd.kores.base/-modifiers-holder/index.md) |
| [Named](../../com.github.jonathanxd.kores.base/-named/index.md) |
| [New](../../com.github.jonathanxd.kores.base/-new/index.md) |
| [ParametersHolder](../../com.github.jonathanxd.kores.base/-parameters-holder/index.md) |
| [ReturnTypeHolder](../../com.github.jonathanxd.kores.base/-return-type-holder/index.md) |
| [SuperClassHolder](../../com.github.jonathanxd.kores.base/-super-class-holder/index.md) |
| [ThrowsHolder](../../com.github.jonathanxd.kores.base/-throws-holder/index.md) |
| [Typed](../../com.github.jonathanxd.kores.base/-typed/index.md) |
| [ValueHolder](../../com.github.jonathanxd.kores.base/-value-holder/index.md) |
| [Comment](../../com.github.jonathanxd.kores.base.comment/-comment/index.md) |
| [CommentHolder](../../com.github.jonathanxd.kores.base.comment/-comment-holder/index.md) |
| [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md) |
| [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [isPrimitive](../is-primitive.md) | [jvm]<br>val [KoresPart](index.md).[isPrimitive](../is-primitive.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [KoresPart](index.md) is primitive |
| [type](../type.md) | [jvm]<br>val [KoresPart](index.md).[type](../type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [KoresPart](index.md) |
| [typeOrNull](../type-or-null.md) | [jvm]<br>val [KoresPart](index.md).[typeOrNull](../type-or-null.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?<br>Gets the type of [KoresPart](index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.kores.base/-typed/index.md) instance. |
