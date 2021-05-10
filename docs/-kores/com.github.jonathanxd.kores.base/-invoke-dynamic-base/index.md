//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[InvokeDynamicBase](index.md)



# InvokeDynamicBase  
 [jvm] interface [InvokeDynamicBase](index.md) : [TypedInstruction](../-typed-instruction/index.md)

A dynamic invocation of a method.



Note: this class does not extends [MethodInvocation](../-method-invocation/index.md) because it is not a normal invocation.

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [InvokeDynamicBase](index.md), [S](-builder/index.md) : [InvokeDynamicBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Typed.Builder](../-typed/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaLocalCodeBase///PointingToDeclaration/"></a>[LambdaLocalCodeBase](-lambda-local-code-base/index.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaLocalCodeBase///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [LambdaLocalCodeBase](-lambda-local-code-base/index.md) : [InvokeDynamicBase.LambdaMethodRefBase](-lambda-method-ref-base/index.md), [ArgumentsHolder](../-arguments-holder/index.md)  <br>More info  <br>Invocation of lambda function.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase///PointingToDeclaration/"></a>[LambdaMethodRefBase](-lambda-method-ref-base/index.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [LambdaMethodRefBase](-lambda-method-ref-base/index.md) : [InvokeDynamicBase](index.md), [ArgumentsHolder](../-arguments-holder/index.md)  <br>More info  <br>Dynamic invocation of lambda method reference.  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [InvokeDynamicBase.Builder](-builder/index.md)<[InvokeDynamicBase](index.md), *>  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase/bootstrap/#/PointingToDeclaration/"></a>[bootstrap](bootstrap.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase/bootstrap/#/PointingToDeclaration/"></a> [jvm] abstract val [bootstrap](bootstrap.md): [MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)Bootstrap method invocation specification.   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase/bootstrapArgs/#/PointingToDeclaration/"></a>[bootstrapArgs](bootstrap-args.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase/bootstrapArgs/#/PointingToDeclaration/"></a> [jvm] abstract val [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md) or [MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md).   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase/dynamicMethod/#/PointingToDeclaration/"></a>[dynamicMethod](dynamic-method.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase/dynamicMethod/#/PointingToDeclaration/"></a> [jvm] abstract val [dynamicMethod](dynamic-method.md): [DynamicMethodSpec](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)Specification of dynamic method.   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Return type of dynamic invocation   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase///PointingToDeclaration/"></a>[InvokeDynamicBase](-lambda-method-ref-base/index.md)
| <a name="com.github.jonathanxd.kores.base/InvokeDynamic///PointingToDeclaration/"></a>[InvokeDynamic](../-invoke-dynamic/index.md)

