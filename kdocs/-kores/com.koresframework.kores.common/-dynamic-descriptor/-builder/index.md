//[Kores](../../../../index.md)/[com.koresframework.kores.common](../../index.md)/[DynamicDescriptor](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [DynamicDescriptor](../index.md), [S](index.md) : [DynamicDescriptor.Builder](index.md)<[T](index.md), [S](index.md)>> : [Typed.Builder](../../../com.koresframework.kores.base/-typed/-builder/index.md)<[T](index.md), [S](index.md)> , [Named.Builder](../../../com.koresframework.kores.base/-named/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [name](../../../com.koresframework.kores.base/-named/-builder/name.md) | [jvm]<br>abstract fun [name](../../../com.koresframework.kores.base/-named/-builder/name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [S](index.md) |
| [type](../../../com.koresframework.kores.base/-typed/-builder/type.md) | [jvm]<br>abstract fun [type](../../../com.koresframework.kores.base/-typed/-builder/type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [DynamicMethodSpec](../../-dynamic-method-spec/-builder/index.md) |
| [DynamicTypeSpec](../../-dynamic-type-spec/-builder/index.md) |
