//[Kores](../index.md)/[com.github.jonathanxd.kores.type](index.md)/[getType](get-type.md)



# getType  
[jvm]  
Content  
fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[getType](get-type.md)(isParameterized: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [KoresType](-kores-type/index.md)  
More info  


Gets the [KoresType](-kores-type/index.md) from a [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html). This method only works for Java Reflection Types and [KoresType](-kores-type/index.md).

  


[jvm]  
Content  
fun [KoresType](-kores-type/index.md).[getType](get-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [KoresType](-kores-type/index.md)?  
fun [KoresType](-kores-type/index.md).[getType](get-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), inside: [KoresType](-kores-type/index.md)): [KoresType](-kores-type/index.md)?  
fun [GenericType](-generic-type/index.md).[getType](get-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [KoresType](-kores-type/index.md)?  
fun [GenericType](-generic-type/index.md).[getType](get-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), inside: [KoresType](-kores-type/index.md)): [KoresType](-kores-type/index.md)?  



