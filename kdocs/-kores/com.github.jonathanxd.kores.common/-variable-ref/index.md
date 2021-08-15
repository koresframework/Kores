//[Kores](../../../index.md)/[com.github.jonathanxd.kores.common](../index.md)/[VariableRef](index.md)

# VariableRef

[jvm]\
data class [VariableRef](index.md)(**variableType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [VariableBase](../../com.github.jonathanxd.kores.base/-variable-base/index.md)

Reference to a Variable.

## Constructors

| | |
|---|---|
| [VariableRef](-variable-ref.md) | [jvm]<br>fun [VariableRef](-variable-ref.md)(variableType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [VariableBase.Builder](../../com.github.jonathanxd.kores.base/-variable-base/-builder/index.md)<[VariableRef](index.md), [VariableRef.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [access](../../com.github.jonathanxd.kores.base/-variable-base/access.md) | [jvm]<br>open fun [access](../../com.github.jonathanxd.kores.base/-variable-base/access.md)(): [VariableAccess](../../com.github.jonathanxd.kores.base/-variable-access/index.md)<br>Creates access to the variable that this instance represents. |
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [VariableRef.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [set](../../com.github.jonathanxd.kores.base/-variable-base/set.md) | [jvm]<br>open fun [set](../../com.github.jonathanxd.kores.base/-variable-base/set.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [VariableDefinition](../../com.github.jonathanxd.kores.base/-variable-definition/index.md)<br>Creates a definition of the value of the variable that this instance represents. |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Variable name |
| [type](index.md#-1016919964%2FProperties%2F-1216412040) | [jvm]<br>open override val [type](index.md#-1016919964%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [variableType](variable-type.md) | [jvm]<br>open override val [variableType](variable-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Variable type |
