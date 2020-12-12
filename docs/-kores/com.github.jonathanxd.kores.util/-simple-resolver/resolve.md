//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](../index.md)/[SimpleResolver](index.md)/[resolve](resolve.md)



# resolve  
[jvm]  
Content  
open override fun [resolve](resolve.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), isInterface: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  
More info  


Resolves type with name to a [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html). If isInterface is true, and resolved type is cached as non-interface, then the type should be replaced with one that is marked as interface.

  



