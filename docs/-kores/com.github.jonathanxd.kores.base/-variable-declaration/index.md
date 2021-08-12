//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[VariableDeclaration](index.md)

# VariableDeclaration

[jvm]\
data class [VariableDeclaration](index.md)(**modifiers**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, **variableType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [VariableBase](../-variable-base/index.md), [ValueHolder](../-value-holder/index.md), [TypedInstruction](../-typed-instruction/index.md), [ModifiersHolder](../-modifiers-holder/index.md)

Declares a variable of type [variableType](variable-type.md) and name [name](name.md) with default value [value](value.md) (null does not mean that you declared a variable with null value, it means that you declared a variable without a default value, for null values use Literals.NULL).

## Constructors

| | |
|---|---|
| [VariableDeclaration](-variable-declaration.md) | [jvm]<br>fun [VariableDeclaration](-variable-declaration.md)(modifiers: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, variableType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [VariableBase.Builder](../-variable-base/-builder/index.md)<[VariableDeclaration](index.md), [VariableDeclaration.Builder](-builder/index.md)> , [ValueHolder.Builder](../-value-holder/-builder/index.md)<[VariableDeclaration](index.md), [VariableDeclaration.Builder](-builder/index.md)> , [ModifiersHolder.Builder](../-modifiers-holder/-builder/index.md)<[VariableDeclaration](index.md), [VariableDeclaration.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [access](../-variable-base/access.md) | [jvm]<br>open fun [access](../-variable-base/access.md)(): [VariableAccess](../-variable-access/index.md)<br>Creates access to the variable that this instance represents. |
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [VariableDeclaration.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [set](../-variable-base/set.md) | [jvm]<br>open fun [set](../-variable-base/set.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [VariableDefinition](../-variable-definition/index.md)<br>Creates a definition of the value of the variable that this instance represents. |

## Properties

| Name | Summary |
|---|---|
| [isPublic](index.md#644725464%2FProperties%2F-1216412040) | [jvm]<br>open val [isPublic](index.md#644725464%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this part is public. |
| [modifiers](modifiers.md) | [jvm]<br>open override val [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)><br>Modifiers. |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Variable name |
| [type](index.md#1071684785%2FProperties%2F-1216412040) | [jvm]<br>open override val [type](index.md#1071684785%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Value |
| [variableType](variable-type.md) | [jvm]<br>open override val [variableType](variable-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Variable type |
