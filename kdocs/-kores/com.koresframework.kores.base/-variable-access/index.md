//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[VariableAccess](index.md)

# VariableAccess

[jvm]\
data class [VariableAccess](index.md)(**variableType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [VariableBase](../-variable-base/index.md), [TypedInstruction](../-typed-instruction/index.md)

Access to a variable in local scope.

## Constructors

| | |
|---|---|
| [VariableAccess](-variable-access.md) | [jvm]<br>fun [VariableAccess](-variable-access.md)(variableType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [VariableBase.Builder](../-variable-base/-builder/index.md)<[VariableAccess](index.md), [VariableAccess.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [access](../-variable-base/access.md) | [jvm]<br>open fun [access](../-variable-base/access.md)(): [VariableAccess](index.md)<br>Creates access to the variable that this instance represents. |
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [VariableAccess.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [set](../-variable-base/set.md) | [jvm]<br>open fun [set](../-variable-base/set.md)(value: [Instruction](../../com.koresframework.kores/-instruction/index.md)): [VariableDefinition](../-variable-definition/index.md)<br>Creates a definition of the value of the variable that this instance represents. |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Variable name |
| [type](index.md#-1178420031%2FProperties%2F-1216412040) | [jvm]<br>open override val [type](index.md#-1178420031%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [variableType](variable-type.md) | [jvm]<br>open override val [variableType](variable-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Variable type |
