//[Kores](../index.md)/[com.github.jonathanxd.kores.util](index.md)/[inferBoundsType](infer-bounds-type.md)



# inferBoundsType  
[jvm]  
Content  
fun [inferBoundsType](infer-bounds-type.md)(bounds: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [GenericType.Bound](../com.github.jonathanxd.kores.type/-generic-type/-bound/index.md)>, parameterizedType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), startingType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), koresTypeResolver: [KoresTypeResolver](../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>, genericResolver: [GenericResolver](-generic-resolver/index.md), filter: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = { true }): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[GenericType.Bound](../com.github.jonathanxd.kores.type/-generic-type/-bound/index.md)>  
More info  


Calls [inferType](infer-type.md) against bounds types.

  



