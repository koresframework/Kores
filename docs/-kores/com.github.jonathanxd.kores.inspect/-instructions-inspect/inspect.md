//[Kores](../../index.md)/[com.github.jonathanxd.kores.inspect](../index.md)/[InstructionsInspect](index.md)/[inspect](inspect.md)



# inspect  
[jvm]  
Content  
fun [inspect](inspect.md)(source: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[R](index.md)>  
More info  


Inspect the source and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md)).

  


[jvm]  
Content  
fun [inspect](inspect.md)(source: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[R](index.md)>  
More info  


Inspect the source starting at index start and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md))..



#### Throws  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/inspect/#com.github.jonathanxd.kores.Instructions#kotlin.Int/PointingToDeclaration/"></a>[kotlin.IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html)| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/inspect/#com.github.jonathanxd.kores.Instructions#kotlin.Int/PointingToDeclaration/"></a><br><br>If start index exceeds the source size.<br><br>
  


[jvm]  
Content  
fun [inspect](inspect.md)(source: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), inspect: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), consumer: ([R](index.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Inspect source starting at index start and call consumer function with each element (mapped with [mapper](mapper.md)) where matches [predicate](predicate.md).



#### Return  


False if inspection stopped before ending as result of [stopPredicate](stop-predicate.md) returning true for an element.

  



