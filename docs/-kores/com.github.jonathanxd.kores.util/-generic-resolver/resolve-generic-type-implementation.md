//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](../index.md)/[GenericResolver](index.md)/[resolveGenericTypeImplementation](resolve-generic-type-implementation.md)



# resolveGenericTypeImplementation  
[jvm]  
Content  
abstract fun [resolveGenericTypeImplementation](resolve-generic-type-implementation.md)(superType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), implemented: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>): [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)  
More info  


Resolves [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md) of implemented type, which was implemented in superType. This generic type should be the implemented belong with type parameters provided by superType.

  



