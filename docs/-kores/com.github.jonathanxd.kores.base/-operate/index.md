//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Operate](index.md)



# Operate  
 [jvm] data class [Operate](index.md)(**target**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **operation**: [Operator.Math](../../com.github.jonathanxd.kores.operator/-operator/-math/index.md), **value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [ValueHolder](../-value-holder/index.md), [Typed](../-typed/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Operate a value and return result of operation.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Operate/Operate/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.operator.Operator.Math#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[Operate](-operate.md)| <a name="com.github.jonathanxd.kores.base/Operate/Operate/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.operator.Operator.Math#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a> [jvm] fun [Operate](-operate.md)(target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), operation: [Operator.Math](../../com.github.jonathanxd.kores.operator/-operator/-math/index.md), value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Operate.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/Operate.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [ValueHolder.Builder](../-value-holder/-builder/index.md)<[Operate](index.md), [Operate.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[Operate](index.md), [Operate.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Operate/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/Operate/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [Operate.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Operate/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/Operate/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Operate/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/Operate/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Operator.Math](../../com.github.jonathanxd.kores.operator/-operator/-math/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Operate/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/Operate/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Operate/copy/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.operator.Operator.Math#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/Operate/copy/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.operator.Operator.Math#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), operation: [Operator.Math](../../com.github.jonathanxd.kores.operator/-operator/-math/index.md), value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [Operate](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Operate/hasSecondArg/#/PointingToDeclaration/"></a>[hasSecondArg](has-second-arg.md)| <a name="com.github.jonathanxd.kores.base/Operate/hasSecondArg/#/PointingToDeclaration/"></a> [jvm] val [hasSecondArg](has-second-arg.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)   <br>
| <a name="com.github.jonathanxd.kores.base/Operate/operation/#/PointingToDeclaration/"></a>[operation](operation.md)| <a name="com.github.jonathanxd.kores.base/Operate/operation/#/PointingToDeclaration/"></a> [jvm] val [operation](operation.md): [Operator.Math](../../com.github.jonathanxd.kores.operator/-operator/-math/index.md)Operation.   <br>
| <a name="com.github.jonathanxd.kores.base/Operate/target/#/PointingToDeclaration/"></a>[target](target.md)| <a name="com.github.jonathanxd.kores.base/Operate/target/#/PointingToDeclaration/"></a> [jvm] val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Target part to operate.   <br>
| <a name="com.github.jonathanxd.kores.base/Operate/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/Operate/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>
| <a name="com.github.jonathanxd.kores.base/Operate/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="com.github.jonathanxd.kores.base/Operate/value/#/PointingToDeclaration/"></a> [jvm] open override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Second argument of the operation, may be [KoresNothing](../../com.github.jonathanxd.kores.common/index.md#%5Bcom.github.jonathanxd.kores.common%2FKoresNothing%2F%2F%2FPointingToDeclaration%2F%5D%2FClasslikes%2F-427383591).   <br>

