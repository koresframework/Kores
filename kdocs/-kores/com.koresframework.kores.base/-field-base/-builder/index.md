//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[FieldBase](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [FieldBase](../index.md), [S](index.md) : [FieldBase.Builder](index.md)<[T](index.md), [S](index.md)>> : [Named.Builder](../../-named/-builder/index.md)<[T](index.md), [S](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [base](base.md) | [jvm]<br>open fun [base](base.md)(fieldRef: [FieldRef](../../../com.koresframework.kores.common/-field-ref/index.md)): [S](index.md)<br>Base this builder on [fieldRef](base.md).<br>[jvm]<br>open fun [base](base.md)(variableRef: [VariableRef](../../../com.koresframework.kores.common/-variable-ref/index.md)): [S](index.md)<br>Base this builder on [variableRef](base.md). |
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [localization](localization.md) | [jvm]<br>abstract fun [localization](localization.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See T. |
| [name](../../-named/-builder/name.md) | [jvm]<br>abstract fun [name](../../-named/-builder/name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [S](index.md) |
| [target](target.md) | [jvm]<br>abstract fun [target](target.md)(value: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [S](index.md)<br>See T. |
| [type](../../-typed/-builder/type.md) | [jvm]<br>abstract fun [type](../../-typed/-builder/type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [FieldDeclaration](../../-field-declaration/-builder/index.md) |
| [FieldDefinition](../../-field-definition/-builder/index.md) |
| [FieldRef](../../../com.koresframework.kores.common/-field-ref/-builder/index.md) |
