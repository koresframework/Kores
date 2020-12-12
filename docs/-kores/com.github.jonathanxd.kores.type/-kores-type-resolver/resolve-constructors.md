//[Kores](../../index.md)/[com.github.jonathanxd.kores.type](../index.md)/[KoresTypeResolver](index.md)/[resolveConstructors](resolve-constructors.md)



# resolveConstructors  
[jvm]  
Content  
open fun [resolveConstructors](resolve-constructors.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ConstructorDeclaration](../../com.github.jonathanxd.kores.base/-constructor-declaration/index.md)>>  
More info  


Resolves or create a list of all [ConstructorDeclaration](../../com.github.jonathanxd.kores.base/-constructor-declaration/index.md) present in type.



The default implementation delegates the call to [resolveTypeDeclaration](resolve-type-declaration.md) and extract property value.

  



