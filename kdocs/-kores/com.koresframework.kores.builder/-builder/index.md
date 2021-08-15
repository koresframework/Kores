//[Kores](../../../index.md)/[com.koresframework.kores.builder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md), [S](index.md) : [Builder](index.md)<[T](index.md), [S](index.md)>>

Builder pattern.

## Parameters

jvm

| | |
|---|---|
| T | Type of element to build. |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>abstract fun [build](build.md)(): [T](index.md)<br>Build the object of type [T](index.md). |

## Inheritors

| Name |
|---|
| [KoresPart](../../com.koresframework.kores/-kores-part/-self-builder/index.md) |
| [Accessor](../../com.koresframework.kores.base/-accessor/-builder/index.md) |
| [Annotable](../../com.koresframework.kores.base/-annotable/-builder/index.md) |
| [ArgumentsHolder](../../com.koresframework.kores.base/-arguments-holder/-builder/index.md) |
| [ArrayAccess](../../com.koresframework.kores.base/-array-access/-builder/index.md) |
| [BodyHolder](../../com.koresframework.kores.base/-body-holder/-builder/index.md) |
| [ConstructorsHolder](../../com.koresframework.kores.base/-constructors-holder/-builder/index.md) |
| [ControlFlow](../../com.koresframework.kores.base/-control-flow/-builder/index.md) |
| [EntryHolder](../../com.koresframework.kores.base/-entry-holder/-builder/index.md) |
| [GenericSignatureHolder](../../com.koresframework.kores.base/-generic-signature-holder/-builder/index.md) |
| [IfExpr](../../com.koresframework.kores.base/-if-expr/-builder/index.md) |
| [IfExpressionHolder](../../com.koresframework.kores.base/-if-expression-holder/-builder/index.md) |
| [ImplementationHolder](../../com.koresframework.kores.base/-implementation-holder/-builder/index.md) |
| [InnerTypesHolder](../../com.koresframework.kores.base/-inner-types-holder/-builder/index.md) |
| [LocalCode](../../com.koresframework.kores.base/-local-code/-builder/index.md) |
| [ModifiersHolder](../../com.koresframework.kores.base/-modifiers-holder/-builder/index.md) |
| [Named](../../com.koresframework.kores.base/-named/-builder/index.md) |
| [New](../../com.koresframework.kores.base/-new/-builder/index.md) |
| [ParametersHolder](../../com.koresframework.kores.base/-parameters-holder/-builder/index.md) |
| [ReturnTypeHolder](../../com.koresframework.kores.base/-return-type-holder/-builder/index.md) |
| [SuperClassHolder](../../com.koresframework.kores.base/-super-class-holder/-builder/index.md) |
| [ThrowsHolder](../../com.koresframework.kores.base/-throws-holder/-builder/index.md) |
| [Typed](../../com.koresframework.kores.base/-typed/-builder/index.md) |
| [ValueHolder](../../com.koresframework.kores.base/-value-holder/-builder/index.md) |
| [Code](../../com.koresframework.kores.base.comment/-code/-builder/index.md) |
| [CommentHolder](../../com.koresframework.kores.base.comment/-comment-holder/-builder/index.md) |
| [Comments](../../com.koresframework.kores.base.comment/-comments/-builder/index.md) |
| [Link](../../com.koresframework.kores.base.comment/-link/-builder/index.md) |
| [Plain](../../com.koresframework.kores.base.comment/-plain/-builder/index.md) |
| [AnnotatedKoresType](../../com.koresframework.kores.type/-annotated-kores-type/-builder/index.md) |
| [GenericType](../../com.koresframework.kores.type/-generic-type/-builder/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [self](../self.md) | [jvm]<br>inline fun <[T](../self.md), [S](../self.md) : [Builder](index.md)<[T](../self.md), [S](../self.md)>> [Builder](index.md)<[T](../self.md), [S](../self.md)>.[self](../self.md)(): [S](../self.md)<br>Cast from [Builder](index.md) of [T](../self.md) of implicit type [S](../self.md). |
