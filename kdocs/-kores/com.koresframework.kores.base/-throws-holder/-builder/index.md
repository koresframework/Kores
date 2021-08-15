//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[ThrowsHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [ThrowsHolder](../index.md), [S](index.md) : [ThrowsHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.koresframework.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [throwsClause](throws-clause.md) | [jvm]<br>open fun [throwsClause](throws-clause.md)(vararg values: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>abstract fun [throwsClause](throws-clause.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>): [S](index.md)<br>See [ThrowsHolder.throwsClause](../throws-clause.md) |

## Inheritors

| Name |
|---|
| [MethodDeclarationBase](../../-method-declaration-base/-builder/index.md) |
