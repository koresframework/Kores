[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [FieldBase](.)

# FieldBase

`interface FieldBase : `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)

Base field (access and definition common class)

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : FieldBase, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../-named/-builder/index.md)`<T, S>, `[`Builder`](../-typed/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | `abstract val localization: Type`<br>Field localization. |
| [target](target.md) | `abstract val target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Target of the access |
| [type](type.md) | `abstract val type: Type`<br>Element type |

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../-named/name.md) | `abstract val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<FieldBase, *>`<br>This builder may or may not accept null values, it depends on implementation. |

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
| [FieldDeclaration](../-field-declaration/index.md) | `data class FieldDeclaration : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, FieldBase, `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, `[`ValueHolder`](../-value-holder/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)<br>Declaration of a field. |
| [FieldDefinition](../-field-definition/index.md) | `data class FieldDefinition : `[`Accessor`](../-accessor/index.md)`, FieldBase, `[`ValueHolder`](../-value-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Defines the value of a field of type [type](../-field-definition/type.md), name [name](../-field-definition/name.md) in type [localization](../-field-definition/localization.md) to [value](../-field-definition/value.md), and use [target](../-field-definition/target.md) as instance to access ([Access.Type.STATIC](#) for static accesses). |
| [FieldRef](../../com.github.jonathanxd.codeapi.common/-field-ref/index.md) | `data class FieldRef : FieldBase`<br>Field reference, this class must never appear in CodeSource. |
