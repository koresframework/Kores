[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [AnnotationProperty](.)

# AnnotationProperty

`data class AnnotationProperty : `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`ReturnTypeHolder`](../-return-type-holder/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)

Annotation property, this is part of [AnnotationDeclaration](../-annotation-declaration/index.md).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-named/-builder/index.md)`<AnnotationProperty, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-typed/-builder/index.md)`<AnnotationProperty, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-annotable/-builder/index.md)`<AnnotationProperty, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-return-type-holder/-builder/index.md)`<AnnotationProperty, `[`Builder`](-builder/index.md)`>, `[`Builder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<AnnotationProperty, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AnnotationProperty(comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`, annotations: List<`[`Annotation`](../-annotation/index.md)`>, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, defaultValue: Any?)`<br>Annotation property, this is part of [AnnotationDeclaration](../-annotation-declaration/index.md). |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `val annotations: List<`[`Annotation`](../-annotation/index.md)`>`<br>Annotations |
| [comments](comments.md) | `val comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)<br>All comments inside this holder. |
| [defaultValue](default-value.md) | `val defaultValue: Any?`<br>Annotation default value, must be: [Byte](#), [Boolean](#), [Char](#), [Short](#),
[Int](#), [Long](#), [Float](#), [Double](#), [String](#), [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html),
OBJECT, ARRAY, [EnumValue](../-enum-value/index.md) or other [Annotation](../-annotation/index.md). |
| [name](name.md) | `val name: String`<br>Name |
| [returnType](return-type.md) | `val returnType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Type of return |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
