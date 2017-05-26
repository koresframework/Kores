[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ValueHolder](.)

# ValueHolder

`interface ValueHolder : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

Value holder part

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : ValueHolder, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [value](value.md) | `abstract val value: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?`<br>Value |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<ValueHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [ArrayStore](../-array-store/index.md) | `data class ArrayStore : `[`ArrayAccess`](../-array-access/index.md)`, ValueHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Stores [value](../-array-store/value-to-store.md) of type [valueType](../-array-store/value-type.md) in array [target](../-array-store/target.md) of type [arrayType](../-array-store/array-type.md) at [index](../-array-store/--index--.md). |
| [Case](../-case/index.md) | `data class Case : ValueHolder, `[`Typed`](../-typed/index.md)`, `[`BodyHolder`](../-body-holder/index.md)<br>Case statement of [SwitchStatement](../-switch-statement/index.md). |
| [FieldDeclaration](../-field-declaration/index.md) | `data class FieldDeclaration : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`FieldBase`](../-field-base/index.md)`, `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, ValueHolder, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)<br>Declaration of a field. |
| [FieldDefinition](../-field-definition/index.md) | `data class FieldDefinition : `[`Accessor`](../-accessor/index.md)`, `[`FieldBase`](../-field-base/index.md)`, ValueHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Defines the value of a field of type [type](../-field-definition/type.md), name [name](../-field-definition/name.md) in type [localization](../-field-definition/localization.md) to [value](../-field-definition/value.md), and use [target](../-field-definition/target.md) as instance to access
([Access.Type.STATIC](#) for static accesses). |
| [Operate](../-operate/index.md) | `data class Operate : ValueHolder, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Operate a value and return result of operation. |
| [Return](../-return/index.md) | `data class Return : ValueHolder, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Return value. |
| [SwitchStatement](../-switch-statement/index.md) | `data class SwitchStatement : ValueHolder, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Switch statement, this switch can switch numeric values and object values (like Enum, String or other
objects). |
| [VariableDeclaration](../-variable-declaration/index.md) | `data class VariableDeclaration : `[`VariableBase`](../-variable-base/index.md)`, ValueHolder, `[`Typed`](../-typed/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Declares a variable of type [variableType](../-variable-declaration/variable-type.md) and name [name](../-variable-declaration/name.md) with default value [value](../-variable-declaration/value.md) (null does not
mean that you declared a variable with null value, it means that you declared a variable without a default value,
for null values use `Literals.NULL`). |
| [VariableDefinition](../-variable-definition/index.md) | `data class VariableDefinition : `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, ValueHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Defines the value of variable of type [type](../-variable-definition/type.md) and name [name](../-variable-definition/name.md) to [value](../-variable-definition/value.md). |
