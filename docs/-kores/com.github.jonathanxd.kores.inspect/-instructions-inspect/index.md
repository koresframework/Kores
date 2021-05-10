//[Kores](../../index.md)/[com.github.jonathanxd.kores.inspect](../index.md)/[InstructionsInspect](index.md)



# InstructionsInspect  
 [jvm] class [InstructionsInspect](index.md)<out [R](index.md)>

Utility to inspect [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md).

   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect///PointingToDeclaration/"></a>R| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect///PointingToDeclaration/"></a><br><br>Mapper type.<br><br>
  


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect.Companion///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/inspect/#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[inspect](inspect.md)| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/inspect/#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [inspect](inspect.md)(source: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[R](index.md)>  <br>More info  <br>Inspect the source and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md)).  <br><br><br>[jvm]  <br>Content  <br>fun [inspect](inspect.md)(source: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[R](index.md)>  <br>More info  <br>Inspect the source starting at index start and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md))..  <br><br><br>[jvm]  <br>Content  <br>fun [inspect](inspect.md)(source: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), inspect: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), consumer: ([R](index.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Inspect source starting at index start and call consumer function with each element (mapped with [mapper](mapper.md)) where matches [predicate](predicate.md).  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/inspectRootInstructions/#/PointingToDeclaration/"></a>[inspectRootInstructions](inspect-root-instructions.md)| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/inspectRootInstructions/#/PointingToDeclaration/"></a> [jvm] val [inspectRootInstructions](inspect-root-instructions.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)True to inspect [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md) and not only sub elements.   <br>
| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/mapper/#/PointingToDeclaration/"></a>[mapper](mapper.md)| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/mapper/#/PointingToDeclaration/"></a> [jvm] val [mapper](mapper.md): ([KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)) -> [R](index.md)Function to map processed values to another type.   <br>
| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/predicate/#/PointingToDeclaration/"></a>[predicate](predicate.md)| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/predicate/#/PointingToDeclaration/"></a> [jvm] val [predicate](predicate.md): ([KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Predicate check if elements match requirements.   <br>
| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/stopPredicate/#/PointingToDeclaration/"></a>[stopPredicate](stop-predicate.md)| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/stopPredicate/#/PointingToDeclaration/"></a> [jvm] val [stopPredicate](stop-predicate.md): ([KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Predicate to determine when the inspection should stop (true to stop, false to continue).   <br>
| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/subPredicate/#/PointingToDeclaration/"></a>[subPredicate](sub-predicate.md)| <a name="com.github.jonathanxd.kores.inspect/InstructionsInspect/subPredicate/#/PointingToDeclaration/"></a> [jvm] val [subPredicate](sub-predicate.md): ([BodyHolder](../../com.github.jonathanxd.kores.base/-body-holder/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?Predicate to check whether a [BodyHolder](../../com.github.jonathanxd.kores.base/-body-holder/index.md) should be inspected.   <br>

