//[Kores](../index.md)/[com.github.jonathanxd.kores.inspect](index.md)/[removeRedundantNot](remove-redundant-not.md)



# removeRedundantNot  
[jvm]  
Content  
fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>.[removeRedundantNot](remove-redundant-not.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>  
fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[removeRedundantNot](remove-redundant-not.md)(): [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)  
More info  


Removes redundant not check.

  


[jvm]  
Content  
fun [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md).[removeRedundantNot](remove-redundant-not.md)(): [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md)  
More info  


Removes redundant not check. Example if (!(!a)) is simplified to if (a)

  



