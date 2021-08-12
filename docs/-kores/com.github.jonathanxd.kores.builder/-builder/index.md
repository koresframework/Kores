//[Kores](../../../index.md)/[com.github.jonathanxd.kores.builder](../index.md)/[Builder](index.md)

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
| [KoresPart](../../com.github.jonathanxd.kores/-kores-part/-self-builder/index.md) |
| [Accessor](../../com.github.jonathanxd.kores.base/-accessor/-builder/index.md) |
| [Annotable](../../com.github.jonathanxd.kores.base/-annotable/-builder/index.md) |
| [ArgumentsHolder](../../com.github.jonathanxd.kores.base/-arguments-holder/-builder/index.md) |
| [ArrayAccess](../../com.github.jonathanxd.kores.base/-array-access/-builder/index.md) |
| [BodyHolder](../../com.github.jonathanxd.kores.base/-body-holder/-builder/index.md) |
| [ConstructorsHolder](../../com.github.jonathanxd.kores.base/-constructors-holder/-builder/index.md) |
| [ControlFlow](../../com.github.jonathanxd.kores.base/-control-flow/-builder/index.md) |
| [EntryHolder](../../com.github.jonathanxd.kores.base/-entry-holder/-builder/index.md) |
| [GenericSignatureHolder](../../com.github.jonathanxd.kores.base/-generic-signature-holder/-builder/index.md) |
| [IfExpr](../../com.github.jonathanxd.kores.base/-if-expr/-builder/index.md) |
| [IfExpressionHolder](../../com.github.jonathanxd.kores.base/-if-expression-holder/-builder/index.md) |
| [ImplementationHolder](../../com.github.jonathanxd.kores.base/-implementation-holder/-builder/index.md) |
| [InnerTypesHolder](../../com.github.jonathanxd.kores.base/-inner-types-holder/-builder/index.md) |
| [LocalCode](../../com.github.jonathanxd.kores.base/-local-code/-builder/index.md) |
| [ModifiersHolder](../../com.github.jonathanxd.kores.base/-modifiers-holder/-builder/index.md) |
| [Named](../../com.github.jonathanxd.kores.base/-named/-builder/index.md) |
| [New](../../com.github.jonathanxd.kores.base/-new/-builder/index.md) |
| [ParametersHolder](../../com.github.jonathanxd.kores.base/-parameters-holder/-builder/index.md) |
| [ReturnTypeHolder](../../com.github.jonathanxd.kores.base/-return-type-holder/-builder/index.md) |
| [SuperClassHolder](../../com.github.jonathanxd.kores.base/-super-class-holder/-builder/index.md) |
| [ThrowsHolder](../../com.github.jonathanxd.kores.base/-throws-holder/-builder/index.md) |
| [Typed](../../com.github.jonathanxd.kores.base/-typed/-builder/index.md) |
| [ValueHolder](../../com.github.jonathanxd.kores.base/-value-holder/-builder/index.md) |
| [Code](../../com.github.jonathanxd.kores.base.comment/-code/-builder/index.md) |
| [CommentHolder](../../com.github.jonathanxd.kores.base.comment/-comment-holder/-builder/index.md) |
| [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/-builder/index.md) |
| [Link](../../com.github.jonathanxd.kores.base.comment/-link/-builder/index.md) |
| [Plain](../../com.github.jonathanxd.kores.base.comment/-plain/-builder/index.md) |
| [AnnotatedKoresType](../../com.github.jonathanxd.kores.type/-annotated-kores-type/-builder/index.md) |
| [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/-builder/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [self](../self.md) | [jvm]<br>inline fun <[T](../self.md), [S](../self.md) : [Builder](index.md)<[T](../self.md), [S](../self.md)>> [Builder](index.md)<[T](../self.md), [S](../self.md)>.[self](../self.md)(): [S](../self.md)<br>Cast from [Builder](index.md) of [T](../self.md) of implicit type [S](../self.md). |
