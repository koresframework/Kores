//[Kores](../../index.md)/[com.github.jonathanxd.kores.type](../index.md)/[KoresType](index.md)/[isAssignableFrom](is-assignable-from.md)



# isAssignableFrom  
[jvm]  
Content  
open fun [isAssignableFrom](is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if this type is assignable from [type](type.md) (using default resolver of [type](type.md)).

  


[jvm]  
Content  
open fun [isAssignableFrom](is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if this type is assignable from [type](type.md) (using resolver provided by resolverProvider).

  



