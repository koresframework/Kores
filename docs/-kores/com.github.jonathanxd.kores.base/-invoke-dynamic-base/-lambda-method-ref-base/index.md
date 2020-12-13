//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[InvokeDynamicBase](../index.md)/[LambdaMethodRefBase](index.md)



# LambdaMethodRefBase  
 [jvm] interface [LambdaMethodRefBase](index.md) : [InvokeDynamicBase](../index.md), [ArgumentsHolder](../../-arguments-holder/index.md)

Dynamic invocation of lambda method reference.

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [InvokeDynamicBase.LambdaMethodRefBase](index.md), [S](-builder/index.md) : [InvokeDynamicBase.LambdaMethodRefBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [InvokeDynamicBase.Builder](../-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [ArgumentsHolder.Builder](../../-arguments-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [InvokeDynamicBase.LambdaMethodRefBase.Builder](-builder/index.md)<[InvokeDynamicBase.LambdaMethodRefBase](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/arguments/#/PointingToDeclaration/"></a>[arguments](arguments.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/arguments/#/PointingToDeclaration/"></a> [jvm] abstract override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>Arguments to pass to method ref   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/array/#/PointingToDeclaration/"></a>[array](array.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/array/#/PointingToDeclaration/"></a> [jvm] open override val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Array arguments   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/baseSam/#/PointingToDeclaration/"></a>[baseSam](base-sam.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/baseSam/#/PointingToDeclaration/"></a> [jvm] abstract val [baseSam](base-sam.md): [MethodTypeSpec](../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)Description of base SAM method, example, if the target functional interface is [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html), then the base SAM method is the [Supplier.get](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html#get--).   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/bootstrap/#/PointingToDeclaration/"></a>[bootstrap](bootstrap.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/bootstrap/#/PointingToDeclaration/"></a> [jvm] open override val [bootstrap](bootstrap.md): [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)Bootstrap method invocation specification.   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/bootstrapArgs/#/PointingToDeclaration/"></a>[bootstrapArgs](bootstrap-args.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/bootstrapArgs/#/PointingToDeclaration/"></a> [jvm] open override val [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [KoresType](../../../com.github.jonathanxd.kores.type/-kores-type/index.md) or [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md).   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/currentTypes/#/PointingToDeclaration/"></a>[currentTypes](current-types.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/currentTypes/#/PointingToDeclaration/"></a> [jvm] open val [currentTypes](current-types.md): [TypeSpec](../../-type-spec/index.md)Current types of lambda sam.   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/dynamicMethod/#/PointingToDeclaration/"></a>[dynamicMethod](dynamic-method.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/dynamicMethod/#/PointingToDeclaration/"></a> [jvm] open override val [dynamicMethod](dynamic-method.md): [DynamicMethodSpec](../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)Specification of dynamic method.   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/expectedTypes/#/PointingToDeclaration/"></a>[expectedTypes](expected-types.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/expectedTypes/#/PointingToDeclaration/"></a> [jvm] abstract val [expectedTypes](expected-types.md): [TypeSpec](../../-type-spec/index.md)Types expected by the caller of lambda SAM.   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/methodRef/#/PointingToDeclaration/"></a>[methodRef](method-ref.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/methodRef/#/PointingToDeclaration/"></a> [jvm] abstract val [methodRef](method-ref.md): [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)Method reference to invoke   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/target/#/PointingToDeclaration/"></a>[target](target.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/target/#/PointingToDeclaration/"></a> [jvm] abstract val [target](target.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)Target of method ref invocation   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Return type of dynamic invocation   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/types/#/PointingToDeclaration/"></a>[types](types.md)| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaMethodRefBase/types/#/PointingToDeclaration/"></a> [jvm] open override val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>Expected types of each argument   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase.LambdaLocalCodeBase///PointingToDeclaration/"></a>[InvokeDynamicBase](../-lambda-local-code-base/index.md)
| <a name="com.github.jonathanxd.kores.base/InvokeDynamic.LambdaMethodRef///PointingToDeclaration/"></a>[InvokeDynamic](../../-invoke-dynamic/-lambda-method-ref/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base//additionalArgumentsType/com.github.jonathanxd.kores.base.InvokeDynamicBase.LambdaMethodRefBase#/PointingToDeclaration/"></a>[additionalArgumentsType](../../additional-arguments-type.md)| <a name="com.github.jonathanxd.kores.base//additionalArgumentsType/com.github.jonathanxd.kores.base.InvokeDynamicBase.LambdaMethodRefBase#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>val [InvokeDynamicBase.LambdaMethodRefBase](index.md).[additionalArgumentsType](../../additional-arguments-type.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>  <br><br><br>

