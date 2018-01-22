[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Named](.)

# Named

`interface Named : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

A element that have a name.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : Named, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `abstract val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<Named, *>`<br>This builder may or may not accept null values, it depends on implementation. |

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
| [AnnotationProperty](../-annotation-property/index.md) | `data class AnnotationProperty : Named, `[`Typed`](../-typed/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`ReturnTypeHolder`](../-return-type-holder/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)<br>Annotation property, this is part of [AnnotationDeclaration](../-annotation-declaration/index.md). |
| [CodeParameter](../-code-parameter/index.md) | `data class CodeParameter : `[`Typed`](../-typed/index.md)`, Named, `[`Annotable`](../-annotable/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)<br>Parameter part. |
| [DynamicMethodSpec](../../com.github.jonathanxd.codeapi.common/-dynamic-method-spec/index.md) | `data class DynamicMethodSpec : `[`Typed`](../-typed/index.md)`, Named, `[`ArgumentsHolder`](../-arguments-holder/index.md) |
| [EnumEntry](../-enum-entry/index.md) | `data class EnumEntry : `[`Annotable`](../-annotable/index.md)`, `[`ArgumentsHolder`](../-arguments-holder/index.md)`, Named, `[`ElementsHolder`](../-elements-holder/index.md)<br>Enumeration entry. |
| [EnumValue](../-enum-value/index.md) | `data class EnumValue : Named, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Enum value. |
| [FieldAccess](../-field-access/index.md) | `data class FieldAccess : `[`Accessor`](../-accessor/index.md)`, `[`Typed`](../-typed/index.md)`, Named, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Access a field of type [type](../-field-access/type.md), name [name](../-field-access/name.md) in type [localization](../-field-access/localization.md) using [target](../-field-access/target.md) as instance (Use a [Access.Type.STATIC](#) to static accesses). |
| [FieldBase](../-field-base/index.md) | `interface FieldBase : Named, `[`Typed`](../-typed/index.md)<br>Base field (access and definition common class) |
| [FieldDeclaration](../-field-declaration/index.md) | `data class FieldDeclaration : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`FieldBase`](../-field-base/index.md)`, Named, `[`Typed`](../-typed/index.md)`, `[`ValueHolder`](../-value-holder/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)<br>Declaration of a field. |
| [Label](../-label/index.md) | `data class Label : `[`BodyHolder`](../-body-holder/index.md)`, Named, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Label. |
| [Literal](../../com.github.jonathanxd.codeapi.literal/-literal/index.md) | `abstract class Literal : `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, Named, `[`Typed`](../-typed/index.md)<br>A JVM Literal. |
| [MethodDeclarationBase](../-method-declaration-base/index.md) | `interface MethodDeclarationBase : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`ReturnTypeHolder`](../-return-type-holder/index.md)`, `[`ParametersHolder`](../-parameters-holder/index.md)`, `[`GenericSignatureHolder`](../-generic-signature-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, Named, `[`Typed`](../-typed/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`BodyHolder`](../-body-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)`, `[`ThrowsHolder`](../-throws-holder/index.md)<br>Method declaration |
| [ModuleDeclaration](../-module-declaration/index.md) | `data class ModuleDeclaration : Named, `[`ModifiersHolder`](../-modifiers-holder/index.md)<br>Declaration of a module. |
| [ModuleReference](../-module-reference/index.md) | `data class ModuleReference : Named`<br>Reference to a module or a package. |
| [Operator](../../com.github.jonathanxd.codeapi.operator/-operator/index.md) | `sealed class Operator : `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, Named`<br>Operator. |
| [QualifiedNamed](../-qualified-named/index.md) | `interface QualifiedNamed : Named`<br>A part that have a qualified name. |
| [VariableBase](../-variable-base/index.md) | `interface VariableBase : Named, `[`Typed`](../-typed/index.md)<br>Base variable manipulation. |
| [VariableDefinition](../-variable-definition/index.md) | `data class VariableDefinition : Named, `[`Typed`](../-typed/index.md)`, `[`ValueHolder`](../-value-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Defines the value of variable of type [type](../-variable-definition/type.md) and name [name](../-variable-definition/name.md) to [value](../-variable-definition/value.md). |
