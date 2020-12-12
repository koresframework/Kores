//[Kores](../index.md)/[com.github.jonathanxd.kores](index.md)/[visit](visit.md)



# visit  
[jvm]  
Content  
fun [Instructions](-instructions/index.md).[visit](visit.md)(consumer: ([Instruction](-instruction/index.md), [Location](-location/index.md), [MutableInstructions](-mutable-instructions/index.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [MutableInstructions](-mutable-instructions/index.md)  
More info  


Visit Code Source elements.



This method create a new [Instructions](-instructions/index.md) and add all elements from codeSource before and after visits each [KoresPart](-kores-part/index.md) of codeSource.



When visiting process finish, it will clear codeSource and add all elements from new [Instructions](-instructions/index.md)



#### Return  


Result source.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores//visit/com.github.jonathanxd.kores.Instructions#kotlin.Function3[com.github.jonathanxd.kores.Instruction,com.github.jonathanxd.kores.Location,com.github.jonathanxd.kores.MutableInstructions,kotlin.Unit]/PointingToDeclaration/"></a>consumer| <a name="com.github.jonathanxd.kores//visit/com.github.jonathanxd.kores.Instructions#kotlin.Function3[com.github.jonathanxd.kores.Instruction,com.github.jonathanxd.kores.Location,com.github.jonathanxd.kores.MutableInstructions,kotlin.Unit]/PointingToDeclaration/"></a><br><br>Consumer<br><br>
  
  



