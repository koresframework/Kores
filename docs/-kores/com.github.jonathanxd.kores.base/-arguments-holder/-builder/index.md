//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[ArgumentsHolder](../index.md)/[Builder](index.md)



# Builder  
 [jvm] interface [Builder](index.md)<out [T](index.md) : [ArgumentsHolder](../index.md), [S](index.md) : [ArgumentsHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>    


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArgumentsHolder.Builder/arguments/#kotlin.Array[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>[arguments](arguments.md)| <a name="com.github.jonathanxd.kores.base/ArgumentsHolder.Builder/arguments/#kotlin.Array[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [arguments](arguments.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [S](index.md)  <br>abstract fun [arguments](arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [S](index.md)  <br>More info  <br>See T.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArgumentsHolder.Builder/array/#kotlin.Boolean/PointingToDeclaration/"></a>[array](array.md)| <a name="com.github.jonathanxd.kores.base/ArgumentsHolder.Builder/array/#kotlin.Boolean/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [array](array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [S](index.md)  <br>More info  <br>See T.  <br><br><br>
| <a name="com.github.jonathanxd.kores.builder/Builder/build/#/PointingToDeclaration/"></a>[build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)| <a name="com.github.jonathanxd.kores.builder/Builder/build/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)  <br>More info  <br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md).  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/AnonymousClass.Builder///PointingToDeclaration/"></a>[AnonymousClass](../../-anonymous-class/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor.Builder///PointingToDeclaration/"></a>[ArrayConstructor](../../-array-constructor/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/EnumEntry.Builder///PointingToDeclaration/"></a>[EnumEntry](../../-enum-entry/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase.Builder///PointingToDeclaration/"></a>[InvokeDynamicBase.LambdaMethodRefBase](../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaLocalCodeBase.Builder///PointingToDeclaration/"></a>[InvokeDynamicBase.LambdaLocalCodeBase](../../-invoke-dynamic-base/-lambda-local-code-base/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/MethodInvocation.Builder///PointingToDeclaration/"></a>[MethodInvocation](../../-method-invocation/-builder/index.md)
| <a name="com.github.jonathanxd.kores.common/DynamicMethodSpec.Builder///PointingToDeclaration/"></a>[DynamicMethodSpec](../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/-builder/index.md)

