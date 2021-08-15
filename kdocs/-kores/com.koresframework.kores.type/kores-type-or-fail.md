//[Kores](../../index.md)/[com.koresframework.kores.type](index.md)/[koresTypeOrFail](kores-type-or-fail.md)

# koresTypeOrFail

[jvm]\
val [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[koresTypeOrFail](kores-type-or-fail.md): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)<[KoresType](-kores-type/index.md)>

Tries to resolve the KoresType of the current type.

Kores is only able to resolve types of the following kinds:

<ul><li>[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)</li><li>[ParameterizedType](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/ParameterizedType.html) (with [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html))</li><li>[TypeDeclaration](../com.koresframework.kores.base/-type-declaration/index.md)</li><li>[GenericType](-generic-type/index.md)</li><li>[KoresType](-kores-type/index.md) subtypes like [TypeDeclaration](../com.koresframework.kores.base/-type-declaration/index.md)</li></ul>
