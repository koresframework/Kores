//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Alias](index.md)



# Alias  
 [jvm] sealed class [Alias](index.md) : [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Type alias. They are only supported in specific contexts, which depends on the generator.



This commonly is used when you want to invoke methods, access fields, etc... of current class, super class or super interface, but you don't have access to this information.



#  In Java  


Type alias does not exists in Java language (because you always have access to this information), but would be something like: this.class, super.class.

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Alias.INTERFACE///PointingToDeclaration/"></a>[INTERFACE](-i-n-t-e-r-f-a-c-e/index.md)| <a name="com.github.jonathanxd.kores.base/Alias.INTERFACE///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [INTERFACE](-i-n-t-e-r-f-a-c-e/index.md)(**n**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [Alias](index.md), [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)  <br>More info  <br>Interface extension localization.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Alias.SUPER///PointingToDeclaration/"></a>[SUPER](-s-u-p-e-r/index.md)| <a name="com.github.jonathanxd.kores.base/Alias.SUPER///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [SUPER](-s-u-p-e-r/index.md) : [Alias](index.md), [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)  <br>More info  <br>Super class localization**Must be manually handled.**  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Alias.THIS///PointingToDeclaration/"></a>[THIS](-t-h-i-s/index.md)| <a name="com.github.jonathanxd.kores.base/Alias.THIS///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [THIS](-t-h-i-s/index.md) : [Alias](index.md), [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)  <br>More info  <br>Current class localization.  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores/KoresPart/builder/#/PointingToDeclaration/"></a>[builder](../../com.github.jonathanxd.kores/-kores-part/builder.md)| <a name="com.github.jonathanxd.kores/KoresPart/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [builder](../../com.github.jonathanxd.kores/-kores-part/builder.md)(): [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Alias/resolve/#com.github.jonathanxd.kores.base.TypeDeclaration/PointingToDeclaration/"></a>[resolve](resolve.md)| <a name="com.github.jonathanxd.kores.base/Alias/resolve/#com.github.jonathanxd.kores.base.TypeDeclaration/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [resolve](resolve.md)(declaration: [TypeDeclaration](../-type-declaration/index.md)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br>More info  <br>Called with current type declaration (the class that contains the alias) to resolve the real type.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/Alias.THIS///PointingToDeclaration/"></a>[Alias](-t-h-i-s/index.md)
| <a name="com.github.jonathanxd.kores.base/Alias.SUPER///PointingToDeclaration/"></a>[Alias](-s-u-p-e-r/index.md)
| <a name="com.github.jonathanxd.kores.base/Alias.INTERFACE///PointingToDeclaration/"></a>[Alias](-i-n-t-e-r-f-a-c-e/index.md)

