//[Kores](../../../index.md)/[com.github.jonathanxd.kores.type](../../index.md)/[KoresTypeResolver](../index.md)/[CommonResolver](index.md)/[isAssignableFrom](is-assignable-from.md)



# isAssignableFrom  
[jvm]  
Content  
open override fun [isAssignableFrom](is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)>  
More info  


Checks if type is assignable from using resolvers provided by resolverProvider



#### Return  


True if type is assignable from from.

  



