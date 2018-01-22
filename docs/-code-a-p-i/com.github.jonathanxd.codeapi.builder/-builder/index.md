[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.builder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T, S : Builder<T, S>>`

Builder pattern.

### Parameters

`T` - Type of element to build.

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [build](../build.md) | `fun <T, S : Builder<T, S>> S.build(func: S.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): T`<br>Build the object of type [T](#). |
| [self](../self.md) | `fun <T, S : Builder<T, S>> Builder<T, S>.self(): S`<br>Cast from Builder of [T](#) of implicit type [S](#). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../com.github.jonathanxd.codeapi.base/-accessor/-builder/index.md) | `interface Builder<out T : `[`Accessor`](../../com.github.jonathanxd.codeapi.base/-accessor/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-accessor/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-annotable/-builder/index.md) | `interface Builder<out T : `[`Annotable`](../../com.github.jonathanxd.codeapi.base/-annotable/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-annotable/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-arguments-holder/-builder/index.md) | `interface Builder<out T : `[`ArgumentsHolder`](../../com.github.jonathanxd.codeapi.base/-arguments-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-arguments-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-array-access/-builder/index.md) | `interface Builder<out T : `[`ArrayAccess`](../../com.github.jonathanxd.codeapi.base/-array-access/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-array-access/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-body-holder/-builder/index.md) | `interface Builder<out T : `[`BodyHolder`](../../com.github.jonathanxd.codeapi.base/-body-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-body-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-constructors-holder/-builder/index.md) | `interface Builder<out T : `[`ConstructorsHolder`](../../com.github.jonathanxd.codeapi.base/-constructors-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-constructors-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-control-flow/-builder/index.md) | `class Builder : Builder<`[`ControlFlow`](../../com.github.jonathanxd.codeapi.base/-control-flow/index.md)`, `[`Builder`](../../com.github.jonathanxd.codeapi.base/-control-flow/-builder/index.md)`>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-entry-holder/-builder/index.md) | `interface Builder<out T : `[`EntryHolder`](../../com.github.jonathanxd.codeapi.base/-entry-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-entry-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-generic-signature-holder/-builder/index.md) | `interface Builder<out T : `[`GenericSignatureHolder`](../../com.github.jonathanxd.codeapi.base/-generic-signature-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-generic-signature-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-if-expr/-builder/index.md) | `class Builder : Builder<`[`IfExpr`](../../com.github.jonathanxd.codeapi.base/-if-expr/index.md)`, `[`Builder`](../../com.github.jonathanxd.codeapi.base/-if-expr/-builder/index.md)`>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-if-expression-holder/-builder/index.md) | `interface Builder<out T : `[`IfExpressionHolder`](../../com.github.jonathanxd.codeapi.base/-if-expression-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-if-expression-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-implementation-holder/-builder/index.md) | `interface Builder<out T : `[`ImplementationHolder`](../../com.github.jonathanxd.codeapi.base/-implementation-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-implementation-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-inner-types-holder/-builder/index.md) | `interface Builder<out T : `[`InnerTypesHolder`](../../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-inner-types-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-local-code/-builder/index.md) | `class Builder : Builder<`[`LocalCode`](../../com.github.jonathanxd.codeapi.base/-local-code/index.md)`, `[`Builder`](../../com.github.jonathanxd.codeapi.base/-local-code/-builder/index.md)`>, `[`Builder`](../../com.github.jonathanxd.codeapi.base/-inner-types-holder/-builder/index.md)`<`[`LocalCode`](../../com.github.jonathanxd.codeapi.base/-local-code/index.md)`, `[`Builder`](../../com.github.jonathanxd.codeapi.base/-local-code/-builder/index.md)`>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-modifiers-holder/-builder/index.md) | `interface Builder<out T : `[`ModifiersHolder`](../../com.github.jonathanxd.codeapi.base/-modifiers-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-modifiers-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-named/-builder/index.md) | `interface Builder<out T : `[`Named`](../../com.github.jonathanxd.codeapi.base/-named/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-named/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-new/-builder/index.md) | `class Builder : Builder<`[`New`](../../com.github.jonathanxd.codeapi.base/-new/index.md)`, `[`Builder`](../../com.github.jonathanxd.codeapi.base/-new/-builder/index.md)`>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-parameters-holder/-builder/index.md) | `interface Builder<out T : `[`ParametersHolder`](../../com.github.jonathanxd.codeapi.base/-parameters-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-parameters-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-return-type-holder/-builder/index.md) | `interface Builder<out T : `[`ReturnTypeHolder`](../../com.github.jonathanxd.codeapi.base/-return-type-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-return-type-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-super-class-holder/-builder/index.md) | `interface Builder<out T : `[`SuperClassHolder`](../../com.github.jonathanxd.codeapi.base/-super-class-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-super-class-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-throws-holder/-builder/index.md) | `interface Builder<out T : `[`ThrowsHolder`](../../com.github.jonathanxd.codeapi.base/-throws-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-throws-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-typed/-builder/index.md) | `interface Builder<out T : `[`Typed`](../../com.github.jonathanxd.codeapi.base/-typed/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-typed/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base/-value-holder/-builder/index.md) | `interface Builder<out T : `[`ValueHolder`](../../com.github.jonathanxd.codeapi.base/-value-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-value-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base.comment/-code/-builder/index.md) | `class Builder : Builder<`[`Code`](../../com.github.jonathanxd.codeapi.base.comment/-code/index.md)`, `[`Builder`](../../com.github.jonathanxd.codeapi.base.comment/-code/-builder/index.md)`>` |
| [Builder](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md) | `interface Builder<out T : `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.base.comment/-comments/-builder/index.md) | `class Builder : Builder<`[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`, `[`Builder`](../../com.github.jonathanxd.codeapi.base.comment/-comments/-builder/index.md)`>` |
| [Builder](../../com.github.jonathanxd.codeapi.base.comment/-link/-builder/index.md) | `class Builder : Builder<`[`Link`](../../com.github.jonathanxd.codeapi.base.comment/-link/index.md)`, `[`Builder`](../../com.github.jonathanxd.codeapi.base.comment/-link/-builder/index.md)`>` |
| [Builder](../../com.github.jonathanxd.codeapi.base.comment/-plain/-builder/index.md) | `class Builder : Builder<`[`Plain`](../../com.github.jonathanxd.codeapi.base.comment/-plain/index.md)`, `[`Builder`](../../com.github.jonathanxd.codeapi.base.comment/-plain/-builder/index.md)`>` |
| [Builder](../../com.github.jonathanxd.codeapi.type/-annotated-code-type/-builder/index.md) | `interface Builder<out T : `[`AnnotatedCodeType`](../../com.github.jonathanxd.codeapi.type/-annotated-code-type/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.type/-annotated-code-type/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../com.github.jonathanxd.codeapi.type/-generic-type/-builder/index.md) | `interface Builder<out T : `[`GenericType`](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`, S : `[`Builder`](../../com.github.jonathanxd.codeapi.type/-generic-type/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [SelfBuilder](../../com.github.jonathanxd.codeapi/-code-part/-self-builder/index.md) | `class SelfBuilder : Builder<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`SelfBuilder`](../../com.github.jonathanxd.codeapi/-code-part/-self-builder/index.md)`>` |
