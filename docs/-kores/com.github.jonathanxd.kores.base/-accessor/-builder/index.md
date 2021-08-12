//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[Accessor](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [Accessor](../index.md), [S](index.md) : [Accessor.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [localization](localization.md) | [jvm]<br>abstract fun [localization](localization.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See [Accessor.localization](../localization.md) |
| [target](target.md) | [jvm]<br>abstract fun [target](target.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [S](index.md)<br>See [Accessor.target](../target.md) |

## Inheritors

| Name |
|---|
| [FieldAccess](../../-field-access/-builder/index.md) |
| [FieldDefinition](../../-field-definition/-builder/index.md) |
| [MethodInvocation](../../-method-invocation/-builder/index.md) |
