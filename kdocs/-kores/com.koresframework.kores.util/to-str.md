//[Kores](../../index.md)/[com.koresframework.kores.util](index.md)/[toStr](to-str.md)

# toStr

[jvm]\
fun [GenericType](../com.koresframework.kores.type/-generic-type/index.md).[toStr](to-str.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Default to string conversion for [GenericType](../com.koresframework.kores.type/-generic-type/index.md).

This method convert [GenericType](../com.koresframework.kores.type/-generic-type/index.md) to a Java Source representation of the [GenericType](../com.koresframework.kores.type/-generic-type/index.md), see the algorithm of translation [here](to-source-string.md).

[jvm]\
fun [KoresType](../com.koresframework.kores.type/-kores-type/index.md).[toStr](to-str.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Default to string conversion for [KoresType](../com.koresframework.kores.type/-kores-type/index.md).

This methods generates a string with the simple name of current class and the [Type Identification](../com.koresframework.kores.type/-kores-type/identification.md).
