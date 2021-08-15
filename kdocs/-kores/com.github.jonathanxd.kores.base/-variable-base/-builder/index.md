//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[VariableBase](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [VariableBase](../index.md), [S](index.md) : [VariableBase.Builder](index.md)<[T](index.md), [S](index.md)>> : [Named.Builder](../../-named/-builder/index.md)<[T](index.md), [S](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [base](base.md) | [jvm]<br>open fun [base](base.md)(fieldRef: [FieldRef](../../../com.github.jonathanxd.kores.common/-field-ref/index.md)): [S](index.md)<br>Base this builder on [fieldRef](base.md) (only name and [type](type.md)).<br>[jvm]<br>open fun [base](base.md)(variableRef: [VariableRef](../../../com.github.jonathanxd.kores.common/-variable-ref/index.md)): [S](index.md)<br>Base this builder on [variableRef](base.md). |
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [name](../../-named/-builder/name.md) | [jvm]<br>abstract fun [name](../../-named/-builder/name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [S](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See T. |
| [variableType](variable-type.md) | [jvm]<br>abstract fun [variableType](variable-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See [VariableBase.variableType](../variable-type.md) |

## Inheritors

| Name |
|---|
| [VariableAccess](../../-variable-access/-builder/index.md) |
| [VariableDeclaration](../../-variable-declaration/-builder/index.md) |
| [VariableRef](../../../com.github.jonathanxd.kores.common/-variable-ref/-builder/index.md) |
