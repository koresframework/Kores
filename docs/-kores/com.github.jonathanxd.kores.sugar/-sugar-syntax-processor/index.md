//[Kores](../../index.md)/[com.github.jonathanxd.kores.sugar](../index.md)/[SugarSyntaxProcessor](index.md)



# SugarSyntaxProcessor  
 [jvm] abstract class [SugarSyntaxProcessor](index.md)<in [T](index.md)> : [Processor](../../com.github.jonathanxd.kores.processor/-processor/index.md)<[T](index.md)> 

Sugar syntax processor. Kores provides a way to register a sugar syntax processor, a sugar syntax processor transforms a value of type [T](index.md) into a [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md).

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.sugar/SugarSyntaxProcessor/SugarSyntaxProcessor/#/PointingToDeclaration/"></a>[SugarSyntaxProcessor](-sugar-syntax-processor.md)| <a name="com.github.jonathanxd.kores.sugar/SugarSyntaxProcessor/SugarSyntaxProcessor/#/PointingToDeclaration/"></a> [jvm] fun [SugarSyntaxProcessor](-sugar-syntax-processor.md)()   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/Processor/endProcess/#TypeParam(bounds=[kotlin.Any?])#com.github.jonathanxd.iutils.data.TypedData#com.github.jonathanxd.kores.processor.ProcessorManager[*]/PointingToDeclaration/"></a>[endProcess](../../com.github.jonathanxd.kores.processor/-processor/end-process.md)| <a name="com.github.jonathanxd.kores.processor/Processor/endProcess/#TypeParam(bounds=[kotlin.Any?])#com.github.jonathanxd.iutils.data.TypedData#com.github.jonathanxd.kores.processor.ProcessorManager[*]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [endProcess](../../com.github.jonathanxd.kores.processor/-processor/end-process.md)(part: [T](index.md), data: TypedData, processorManager: [ProcessorManager](../../com.github.jonathanxd.kores.processor/-processor-manager/index.md)<*>)  <br>More info  <br>Called when the process to part finishes.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.sugar/SugarSyntaxProcessor/process/#TypeParam(bounds=[kotlin.Any?])#com.github.jonathanxd.kores.processor.ProcessorManager[*]/PointingToDeclaration/"></a>[process](process.md)| <a name="com.github.jonathanxd.kores.sugar/SugarSyntaxProcessor/process/#TypeParam(bounds=[kotlin.Any?])#com.github.jonathanxd.kores.processor.ProcessorManager[*]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [process](process.md)(t: [T](index.md), codeProcessor: [ProcessorManager](../../com.github.jonathanxd.kores.processor/-processor-manager/index.md)<*>): [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)  <br>More info  <br>Process t and transforms in [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md).  <br><br><br>[jvm]  <br>Content  <br>open override fun [process](process.md)(part: [T](index.md), data: TypedData, processorManager: [ProcessorManager](../../com.github.jonathanxd.kores.processor/-processor-manager/index.md)<*>)  <br>More info  <br>Process the part.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>

