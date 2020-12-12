//[Kores](../index.md)/[com.github.jonathanxd.kores](index.md)/[insertAfterOrEnd](insert-after-or-end.md)



# insertAfterOrEnd  
[jvm]  
Content  
fun [Instructions](-instructions/index.md).[insertAfterOrEnd](insert-after-or-end.md)(predicate: ([Instruction](-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), toInsert: [Instructions](-instructions/index.md)): [MutableInstructions](-mutable-instructions/index.md)  
More info  


Insert element toInsert in source after element determined by predicate or at end of source if not found.



#### Return  


source



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores//insertAfterOrEnd/com.github.jonathanxd.kores.Instructions#kotlin.Function1[com.github.jonathanxd.kores.Instruction,kotlin.Boolean]#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>predicate| <a name="com.github.jonathanxd.kores//insertAfterOrEnd/com.github.jonathanxd.kores.Instructions#kotlin.Function1[com.github.jonathanxd.kores.Instruction,kotlin.Boolean]#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a><br><br>Predicate to determine element<br><br>
| <a name="com.github.jonathanxd.kores//insertAfterOrEnd/com.github.jonathanxd.kores.Instructions#kotlin.Function1[com.github.jonathanxd.kores.Instruction,kotlin.Boolean]#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>toInsert| <a name="com.github.jonathanxd.kores//insertAfterOrEnd/com.github.jonathanxd.kores.Instructions#kotlin.Function1[com.github.jonathanxd.kores.Instruction,kotlin.Boolean]#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a><br><br>Element to insert after element determined by predicate<br><br>
  
  



