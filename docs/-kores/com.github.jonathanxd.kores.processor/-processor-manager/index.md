//[Kores](../../index.md)/[com.github.jonathanxd.kores.processor](../index.md)/[ProcessorManager](index.md)



# ProcessorManager  
 [jvm] interface [ProcessorManager](index.md)<out [R](index.md)>

ProcessorManager manages all processors required to transform [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) into [R](index.md).



Supported types depends on implementation.

   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/createData/#/PointingToDeclaration/"></a>[createData](create-data.md)| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/createData/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [createData](create-data.md)(): TypedData  <br>More info  <br>Creates TypedData object.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/process/#kotlin.Any/PointingToDeclaration/"></a>[process](process.md)| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/process/#kotlin.Any/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [process](process.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [R](index.md)  <br>open fun <[T](process.md)> [process](process.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](process.md)>, part: [T](process.md)): [R](index.md)  <br>More info  <br>Process part and returns a value of type [R](index.md).  <br><br><br>[jvm]  <br>Content  <br>open fun [process](process.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), data: TypedData): [R](index.md)  <br>More info  <br>Process part with data and returns a value of type [R](index.md).  <br><br><br>[jvm]  <br>Content  <br>abstract fun <[T](process.md)> [process](process.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [T](process.md)>, part: [T](process.md), data: TypedData): [R](index.md)  <br>More info  <br>Process part of type type with data and returns a value of type [R](index.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/registerProcessor/#com.github.jonathanxd.kores.processor.Processor[TypeParam(bounds=[kotlin.Any?])]#java.lang.Class[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[registerProcessor](register-processor.md)| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/registerProcessor/#com.github.jonathanxd.kores.processor.Processor[TypeParam(bounds=[kotlin.Any?])]#java.lang.Class[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun <[T](register-processor.md)> [registerProcessor](register-processor.md)(processor: [Processor](../-processor/index.md)<[T](register-processor.md)>, type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](register-processor.md)>)  <br>More info  <br>Registers processor of [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md) of type: type.  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/registerSugarSyntaxProcessor/#com.github.jonathanxd.kores.sugar.SugarSyntaxProcessor[TypeParam(bounds=[kotlin.Any?])]#java.lang.Class[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[registerSugarSyntaxProcessor](register-sugar-syntax-processor.md)| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/registerSugarSyntaxProcessor/#com.github.jonathanxd.kores.sugar.SugarSyntaxProcessor[TypeParam(bounds=[kotlin.Any?])]#java.lang.Class[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun <[T](register-sugar-syntax-processor.md)> [registerSugarSyntaxProcessor](register-sugar-syntax-processor.md)(sugarSyntaxProcessor: [SugarSyntaxProcessor](../../com.github.jonathanxd.kores.sugar/-sugar-syntax-processor/index.md)<[T](register-sugar-syntax-processor.md)>, type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](register-sugar-syntax-processor.md)>)  <br>More info  <br>Registers a sugarSyntaxProcessor of [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md) of type: type.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/options/#/PointingToDeclaration/"></a>[options](options.md)| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/options/#/PointingToDeclaration/"></a> [jvm] abstract val [options](options.md): OptionsOptions of generator   <br>
| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/validatorManager/#/PointingToDeclaration/"></a>[validatorManager](validator-manager.md)| <a name="com.github.jonathanxd.kores.processor/ProcessorManager/validatorManager/#/PointingToDeclaration/"></a> [jvm] abstract val [validatorManager](validator-manager.md): [ValidatorManager](../-validator-manager/index.md)Validator.   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.processor/AbstractProcessorManager///PointingToDeclaration/"></a>[AbstractProcessorManager](../-abstract-processor-manager/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor//processAs/com.github.jonathanxd.kores.processor.ProcessorManager[*]#TypeParam(bounds=[kotlin.Any?])#com.github.jonathanxd.iutils.data.TypedData/PointingToDeclaration/"></a>[processAs](../process-as.md)| <a name="com.github.jonathanxd.kores.processor//processAs/com.github.jonathanxd.kores.processor.ProcessorManager[*]#TypeParam(bounds=[kotlin.Any?])#com.github.jonathanxd.iutils.data.TypedData/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>inline fun <[T](../process-as.md)> [ProcessorManager](index.md)<*>.[processAs](../process-as.md)(part: [T](../process-as.md), data: TypedData): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?  <br>More info  <br>Process part as of reified type [T](../process-as.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor//registerProcessor/com.github.jonathanxd.kores.processor.ProcessorManager[TypeParam(bounds=[kotlin.Any?])]#com.github.jonathanxd.kores.processor.Processor[TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[registerProcessor](../register-processor.md)| <a name="com.github.jonathanxd.kores.processor//registerProcessor/com.github.jonathanxd.kores.processor.ProcessorManager[TypeParam(bounds=[kotlin.Any?])]#com.github.jonathanxd.kores.processor.Processor[TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>inline fun <[R](../register-processor.md), [T](../register-processor.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [ProcessorManager](index.md)<[R](../register-processor.md)>.[registerProcessor](../register-processor.md)(processor: [Processor](../-processor/index.md)<[T](../register-processor.md)>)  <br>More info  <br>Registers processor of [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) of type: [T](../register-processor.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor//registerSugarSyntaxProcessor/com.github.jonathanxd.kores.processor.ProcessorManager[TypeParam(bounds=[kotlin.Any?])]#com.github.jonathanxd.kores.sugar.SugarSyntaxProcessor[TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[registerSugarSyntaxProcessor](../register-sugar-syntax-processor.md)| <a name="com.github.jonathanxd.kores.processor//registerSugarSyntaxProcessor/com.github.jonathanxd.kores.processor.ProcessorManager[TypeParam(bounds=[kotlin.Any?])]#com.github.jonathanxd.kores.sugar.SugarSyntaxProcessor[TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>inline fun <[R](../register-sugar-syntax-processor.md), [T](../register-sugar-syntax-processor.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [ProcessorManager](index.md)<[R](../register-sugar-syntax-processor.md)>.[registerSugarSyntaxProcessor](../register-sugar-syntax-processor.md)(sugarSyntaxProcessor: [SugarSyntaxProcessor](../../com.github.jonathanxd.kores.sugar/-sugar-syntax-processor/index.md)<[T](../register-sugar-syntax-processor.md)>)  <br>More info  <br>Registers a sugarSyntaxProcessor of [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) of type: [T](../register-sugar-syntax-processor.md).  <br><br><br>

