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
| [value](value.md) | `abstract val value: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Value |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<ValueHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

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
| [ArrayStore](../-array-store/index.md) | `data class ArrayStore : `[`ArrayAccess`](../-array-access/index.md)`, ValueHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Stores [value](../-array-store/value-to-store.md) of type [valueType](../-array-store/value-type.md) in array [target](../-array-store/target.md) of type [arrayType](../-array-store/array-type.md) at [index](../-array-store/--index--.md). |
| [Case](../-case/index.md) | `data class Case : ValueHolder, `[`Typed`](../-typed/index.md)`, `[`BodyHolder`](../-body-holder/index.md)<br>Case statement of [SwitchStatement](../-switch-statement/index.md). |
| [FieldDeclaration](../-field-declaration/index.md) | `data class FieldDeclaration : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`FieldBase`](../-field-base/index.md)`, `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, ValueHolder, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)<br>Declaration of a field. |
| [FieldDefinition](../-field-definition/index.md) | `data class FieldDefinition : `[`Accessor`](../-accessor/index.md)`, `[`FieldBase`](../-field-base/index.md)`, ValueHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Defines the value of a field of type [type](../-field-definition/type.md), name [name](../-field-definition/name.md) in type [localization](../-field-definition/localization.md) to [value](../-field-definition/value.md), and use [target](../-field-definition/target.md) as instance to access ([Access.STATIC](../-access/-s-t-a-t-i-c.md) for static accesses). |
| [Line](../-line/index.md) | `sealed class Line : `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, ValueHolder, InstructionWrapper`<br>Base class of line mapping. Line mapping behaves differently for different generators. |
| [Operate](../-operate/index.md) | `data class Operate : ValueHolder, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Operate a value and return result of operation. |
| [Return](../-return/index.md) | `data class Return : ValueHolder, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Return value. |
| [SwitchStatement](../-switch-statement/index.md) | `data class SwitchStatement : ValueHolder, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Switch statement, this switch can switch numeric values and object values (like Enum, String or other objects). |
| [ThrowException](../-throw-exception/index.md) | `data class ThrowException : `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, ValueHolder`<br>Throws [value](../-throw-exception/value.md). |
| [VariableDeclaration](../-variable-declaration/index.md) | `data class VariableDeclaration : `[`VariableBase`](../-variable-base/index.md)`, ValueHolder, `[`Typed`](../-typed/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Declares a variable of type [variableType](../-variable-declaration/variable-type.md) and name [name](../-variable-declaration/name.md) with default value [value](../-variable-declaration/value.md) (null does not mean that you declared a variable with null value, it means that you declared a variable without a default value, for null values use `Literals.NULL`). |
| [VariableDefinition](../-variable-definition/index.md) | `data class VariableDefinition : `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, ValueHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Defines the value of variable of type [type](../-variable-definition/type.md) and name [name](../-variable-definition/name.md) to [value](../-variable-definition/value.md). |
