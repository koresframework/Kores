//[Kores](../../index.md)/[com.koresframework.kores.util](index.md)/[descriptor](descriptor.md)

# descriptor

[jvm]\
val [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[descriptor](descriptor.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Converts this type to type descriptor.

A type descriptor is formatted as:

<ul><li>TYPE_JAVA_SPEC (specified by [KoresType.javaSpecName](../com.koresframework.kores.type/-kores-type/java-spec-name.md)) when receiver [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) is not a [GenericType](../com.koresframework.kores.type/-generic-type/index.md)</li><li>TYPE_NAME when receiver is a [GenericType](../com.koresframework.kores.type/-generic-type/index.md), does not have bounds and is a wildcard (and not a type).</li><li>(T)(TYPE_NAME); when receiver is a [GenericType](../com.koresframework.kores.type/-generic-type/index.md), does not have bounds and is neither a wildcard nor a type.</li><li>TYPE_NAME; when receiver is a [GenericType](../com.koresframework.kores.type/-generic-type/index.md), and is a type.</li><li>TYPE_NAME<BOUNDS>; when receiver is a [GenericType](../com.koresframework.kores.type/-generic-type/index.md), have bounds and the receiver is not a wildcard.</li></ul>

Note: () is only used to make the format more readable and will not be generated in descriptors.
