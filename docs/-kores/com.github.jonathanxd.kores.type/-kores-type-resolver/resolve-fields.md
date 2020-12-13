//[Kores](../../index.md)/[com.github.jonathanxd.kores.type](../index.md)/[KoresTypeResolver](index.md)/[resolveFields](resolve-fields.md)



# resolveFields  
[jvm]  
Content  
open fun [resolveFields](resolve-fields.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../com.github.jonathanxd.kores.base/-field-declaration/index.md)>>  
More info  


Resolves or create a list of all [FieldDeclaration](../../com.github.jonathanxd.kores.base/-field-declaration/index.md) present in type.



The default implementation delegates the call to [resolveTypeDeclaration](resolve-type-declaration.md) and extract property value.

  



