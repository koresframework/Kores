//[Kores](../../../index.md)/[com.koresframework.kores](../index.md)/[KoresPart](index.md)

# KoresPart

[jvm]\
interface [KoresPart](index.md)

A KoresPart is the heart of Kores, all elements that can appear in the code must extend KoresPart.

All interfaces that have a concrete implementation and extends [KoresPart](index.md) must provide a builder method that return a builder instance with defined default values.

## Types

| Name | Summary |
|---|---|
| [SelfBuilder](-self-builder/index.md) | [jvm]<br>class [SelfBuilder](-self-builder/index.md)(**self**: [KoresPart](index.md)) : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[KoresPart](index.md), [KoresPart.SelfBuilder](-self-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open fun [builder](builder.md)(): [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[KoresPart](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Inheritors

| Name |
|---|
| [Instruction](../-instruction/index.md) |
| [Instructions](../-instructions/index.md) |
| [KoresElement](../-kores-element/index.md) |
| [Annotable](../../com.koresframework.kores.base/-annotable/index.md) |
| [ArgumentsHolder](../../com.koresframework.kores.base/-arguments-holder/index.md) |
| [ArrayAccess](../../com.koresframework.kores.base/-array-access/index.md) |
| [BodyHolder](../../com.koresframework.kores.base/-body-holder/index.md) |
| [Concat](../../com.koresframework.kores.base/-concat/index.md) |
| [ConstructorsHolder](../../com.koresframework.kores.base/-constructors-holder/index.md) |
| [ControlFlow](../../com.koresframework.kores.base/-control-flow/index.md) |
| [EntryHolder](../../com.koresframework.kores.base/-entry-holder/index.md) |
| [GenericSignatureHolder](../../com.koresframework.kores.base/-generic-signature-holder/index.md) |
| [IfExpr](../../com.koresframework.kores.base/-if-expr/index.md) |
| [IfExpressionHolder](../../com.koresframework.kores.base/-if-expression-holder/index.md) |
| [IfGroup](../../com.koresframework.kores.base/-if-group/index.md) |
| [ImplementationHolder](../../com.koresframework.kores.base/-implementation-holder/index.md) |
| [InnerTypesHolder](../../com.koresframework.kores.base/-inner-types-holder/index.md) |
| [KoresModifier](../../com.koresframework.kores.base/-kores-modifier/index.md) |
| [LocalCode](../../com.koresframework.kores.base/-local-code/index.md) |
| [ModifiersHolder](../../com.koresframework.kores.base/-modifiers-holder/index.md) |
| [Named](../../com.koresframework.kores.base/-named/index.md) |
| [New](../../com.koresframework.kores.base/-new/index.md) |
| [ParametersHolder](../../com.koresframework.kores.base/-parameters-holder/index.md) |
| [ReturnTypeHolder](../../com.koresframework.kores.base/-return-type-holder/index.md) |
| [SuperClassHolder](../../com.koresframework.kores.base/-super-class-holder/index.md) |
| [ThrowsHolder](../../com.koresframework.kores.base/-throws-holder/index.md) |
| [Typed](../../com.koresframework.kores.base/-typed/index.md) |
| [ValueHolder](../../com.koresframework.kores.base/-value-holder/index.md) |
| [Comment](../../com.koresframework.kores.base.comment/-comment/index.md) |
| [CommentHolder](../../com.koresframework.kores.base.comment/-comment-holder/index.md) |
| [Comments](../../com.koresframework.kores.base.comment/-comments/index.md) |
| [KoresType](../../com.koresframework.kores.type/-kores-type/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [isPrimitive](../is-primitive.md) | [jvm]<br>val [KoresPart](index.md).[isPrimitive](../is-primitive.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [KoresPart](index.md) is primitive |
| [type](../type.md) | [jvm]<br>val [KoresPart](index.md).[type](../type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [KoresPart](index.md) |
| [typeOrNull](../type-or-null.md) | [jvm]<br>val [KoresPart](index.md).[typeOrNull](../type-or-null.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?<br>Gets the type of [KoresPart](index.md) or null if receiver is not a [Typed](../../com.koresframework.kores.base/-typed/index.md) instance. |
