[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Typed](.)

# Typed

`interface Typed : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

A element that can have a type.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : Typed, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [type](type.md) | `abstract val type: Type`<br>Element type |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<Typed, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a Typed instance. |

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
| [Annotation](../-annotation/index.md) | `data class Annotation : Typed`<br>An annotation, an annotation is composed by a pair of property name and property value. |
| [AnnotationProperty](../-annotation-property/index.md) | `data class AnnotationProperty : `[`Named`](../-named/index.md)`, Typed, `[`Annotable`](../-annotable/index.md)`, `[`ReturnTypeHolder`](../-return-type-holder/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)<br>Annotation property, this is part of [AnnotationDeclaration](../-annotation-declaration/index.md). |
| [ArrayConstructor](../-array-constructor/index.md) | `data class ArrayConstructor : `[`ArgumentsHolder`](../-arguments-holder/index.md)`, Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Constructs an array of type [arrayType](../-array-constructor/array-type.md) with dimensions [dimensions](../-array-constructor/dimensions.md). Example: |
| [ArrayLength](../-array-length/index.md) | `data class ArrayLength : `[`ArrayAccess`](../-array-access/index.md)`, Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Access length of array [target](../-array-length/target.md) of type [arrayType](../-array-length/array-type.md). |
| [ArrayLoad](../-array-load/index.md) | `data class ArrayLoad : `[`ArrayAccess`](../-array-access/index.md)`, Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Loads a value of type [valueType](../-array-load/value-type.md) at [index](../-array-load/--index--.md) from array [target](../-array-load/target.md) of type [arrayType](../-array-load/array-type.md). |
| [Case](../-case/index.md) | `data class Case : `[`ValueHolder`](../-value-holder/index.md)`, Typed, `[`BodyHolder`](../-body-holder/index.md)<br>Case statement of [SwitchStatement](../-switch-statement/index.md). |
| [Cast](../-cast/index.md) | `data class Cast : Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Value cast. Cast [castedPart](../-cast/casted-part.md) of type [originalType](../-cast/original-type.md) (null if unknown) to [targetType](../-cast/target-type.md). Official BytecodeGenerator uses the [originalType](../-cast/original-type.md) to auto-box and auto-unbox the value. |
| [CatchStatement](../-catch-statement/index.md) | `data class CatchStatement : `[`BodyHolder`](../-body-holder/index.md)`, Typed`<br>Catch statement of a try block. Catch [exceptionTypes](../-catch-statement/exception-types.md) and store caught exception in [variable](../-catch-statement/variable.md). |
| [CodeParameter](../-code-parameter/index.md) | `data class CodeParameter : Typed, `[`Named`](../-named/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)<br>Parameter part. |
| [Concat](../-concat/index.md) | `data class Concat : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>String concatenation. The result depends on generator, in official BytecodeGenerator a [StringBuilder](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-string-builder/index.html) will be used to concat values (in a future patch it will be changed to use Java 9 dynamic concatenation), in official JavaSourceGenerator this will be translated into string concatenation. |
| [EnumValue](../-enum-value/index.md) | `data class EnumValue : `[`Named`](../-named/index.md)`, Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Enum value. |
| [FieldAccess](../-field-access/index.md) | `data class FieldAccess : `[`Accessor`](../-accessor/index.md)`, Typed, `[`Named`](../-named/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Access a field of type [type](../-field-access/type.md), name [name](../-field-access/name.md) in type [localization](../-field-access/localization.md) using [target](../-field-access/target.md) as instance (Use a [Access.Type.STATIC](#) to static accesses). |
| [FieldBase](../-field-base/index.md) | `interface FieldBase : `[`Named`](../-named/index.md)`, Typed`<br>Base field (access and definition common class) |
| [FieldDeclaration](../-field-declaration/index.md) | `data class FieldDeclaration : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`FieldBase`](../-field-base/index.md)`, `[`Named`](../-named/index.md)`, Typed, `[`ValueHolder`](../-value-holder/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)<br>Declaration of a field. |
| [InstanceOfCheck](../-instance-of-check/index.md) | `data class InstanceOfCheck : Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Checks if [part](../-instance-of-check/part.md) is `instanceof` [checkType](../-instance-of-check/check-type.md). |
| [InvokeDynamicBase](../-invoke-dynamic-base/index.md) | `interface InvokeDynamicBase : Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>A dynamic invocation of a method. |
| [Literal](../../com.github.jonathanxd.codeapi.literal/-literal/index.md) | `abstract class Literal : `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, `[`Named`](../-named/index.md)`, Typed`<br>A JVM Literal. |
| [MethodDeclarationBase](../-method-declaration-base/index.md) | `interface MethodDeclarationBase : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`ReturnTypeHolder`](../-return-type-holder/index.md)`, `[`ParametersHolder`](../-parameters-holder/index.md)`, `[`GenericSignatureHolder`](../-generic-signature-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`Named`](../-named/index.md)`, Typed, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`BodyHolder`](../-body-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)`, `[`ThrowsHolder`](../-throws-holder/index.md)<br>Method declaration |
| [MethodInvocation](../-method-invocation/index.md) | `data class MethodInvocation : `[`Accessor`](../-accessor/index.md)`, `[`ArgumentsHolder`](../-arguments-holder/index.md)`, Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Invokes a method. |
| [MethodInvokeSpec](../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md) | `data class MethodInvokeSpec : Typed, `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<`[`MethodInvokeSpec`](../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`>` |
| [MethodTypeSpec](../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md) | `data class MethodTypeSpec : Typed, `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<`[`MethodTypeSpec`](../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`>` |
| [Nothing](../../com.github.jonathanxd.codeapi.common/-nothing/index.md) | `object Nothing : `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, Typed`<br>Nothing for values (some parts may not support nothing as value). |
| [Operate](../-operate/index.md) | `data class Operate : `[`ValueHolder`](../-value-holder/index.md)`, Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Operate a value and return result of operation. |
| [Return](../-return/index.md) | `data class Return : `[`ValueHolder`](../-value-holder/index.md)`, Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Return value. |
| [SwitchStatement](../-switch-statement/index.md) | `data class SwitchStatement : `[`ValueHolder`](../-value-holder/index.md)`, Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Switch statement, this switch can switch numeric values and object values (like Enum, String or other objects). |
| [TryStatementBase](../-try-statement-base/index.md) | `interface TryStatementBase : `[`BodyHolder`](../-body-holder/index.md)`, Typed, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Try-catch-finally statement |
| [TypeSpec](../-type-spec/index.md) | `data class TypeSpec : Typed, `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<`[`TypeSpec`](../-type-spec/index.md)`>`<br>Type Signature representation. |
| [TypedLine](../-line/-typed-line/index.md) | `data class TypedLine : `[`Line`](../-line/index.md)`, Typed`<br>A [Line](../-line/index.md) which extends Typed. |
| [VariableBase](../-variable-base/index.md) | `interface VariableBase : `[`Named`](../-named/index.md)`, Typed`<br>Base variable manipulation. |
| [VariableDeclaration](../-variable-declaration/index.md) | `data class VariableDeclaration : `[`VariableBase`](../-variable-base/index.md)`, `[`ValueHolder`](../-value-holder/index.md)`, Typed, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Declares a variable of type [variableType](../-variable-declaration/variable-type.md) and name [name](../-variable-declaration/name.md) with default value [value](../-variable-declaration/value.md) (null does not mean that you declared a variable with null value, it means that you declared a variable without a default value, for null values use `Literals.NULL`). |
| [VariableDefinition](../-variable-definition/index.md) | `data class VariableDefinition : `[`Named`](../-named/index.md)`, Typed, `[`ValueHolder`](../-value-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Defines the value of variable of type [type](../-variable-definition/type.md) and name [name](../-variable-definition/name.md) to [value](../-variable-definition/value.md). |
| [Void](../../com.github.jonathanxd.codeapi.common/-void/index.md) | `object Void : `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, Typed`<br>Void instance for void returns and void values. |
