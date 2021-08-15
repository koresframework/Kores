//[Kores](../../index.md)/[com.koresframework.kores.util](index.md)/[fillTypeVars](fill-type-vars.md)

# fillTypeVars

[jvm]\
fun [fillTypeVars](fill-type-vars.md)(theClass: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<*>, generic: [GenericType](../com.koresframework.kores.type/-generic-type/index.md)): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>

Fill type variables of [theClass](fill-type-vars.md) using types provided by [generic](fill-type-vars.md)

[jvm]\
fun [fillTypeVars](fill-type-vars.md)(typeParameters: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>, generic: [GenericType](../com.koresframework.kores.type/-generic-type/index.md)): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>

Fill [typeParameters](fill-type-vars.md) using types provided by [generic](fill-type-vars.md).
