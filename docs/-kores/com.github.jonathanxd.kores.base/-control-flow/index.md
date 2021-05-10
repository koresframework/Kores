//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ControlFlow](index.md)



# ControlFlow  
 [jvm] data class [ControlFlow](index.md)(**type**: [ControlFlow.Type](-type/index.md), **at**: [Label](../-label/index.md)?) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Control the flow of a statement.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ControlFlow/ControlFlow/#com.github.jonathanxd.kores.base.ControlFlow.Type#com.github.jonathanxd.kores.base.Label?/PointingToDeclaration/"></a>[ControlFlow](-control-flow.md)| <a name="com.github.jonathanxd.kores.base/ControlFlow/ControlFlow/#com.github.jonathanxd.kores.base.ControlFlow.Type#com.github.jonathanxd.kores.base.Label?/PointingToDeclaration/"></a> [jvm] fun [ControlFlow](-control-flow.md)(type: [ControlFlow.Type](-type/index.md), at: [Label](../-label/index.md)?)   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ControlFlow.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/ControlFlow.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[ControlFlow](index.md), [ControlFlow.Builder](-builder/index.md)>   <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ControlFlow.Type///PointingToDeclaration/"></a>[Type](-type/index.md)| <a name="com.github.jonathanxd.kores.base/ControlFlow.Type///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>enum [Type](-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[ControlFlow.Type](-type/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ControlFlow/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/ControlFlow/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [ControlFlow.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ControlFlow/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/ControlFlow/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [ControlFlow.Type](-type/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ControlFlow/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/ControlFlow/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Label](../-label/index.md)?  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ControlFlow/copy/#com.github.jonathanxd.kores.base.ControlFlow.Type#com.github.jonathanxd.kores.base.Label?/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/ControlFlow/copy/#com.github.jonathanxd.kores.base.ControlFlow.Type#com.github.jonathanxd.kores.base.Label?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(type: [ControlFlow.Type](-type/index.md), at: [Label](../-label/index.md)?): [ControlFlow](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ControlFlow/at/#/PointingToDeclaration/"></a>[at](at.md)| <a name="com.github.jonathanxd.kores.base/ControlFlow/at/#/PointingToDeclaration/"></a> [jvm] val [at](at.md): [Label](../-label/index.md)?Label to control flow (Note: [Type.CONTINUE](-type/-c-o-n-t-i-n-u-e/index.md) goes to Start of label and [Type.BREAK](-type/-b-r-e-a-k/index.md) goes to end of label).   <br>
| <a name="com.github.jonathanxd.kores.base/ControlFlow/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/ControlFlow/type/#/PointingToDeclaration/"></a> [jvm] val [type](type.md): [ControlFlow.Type](-type/index.md)Type of the flow control   <br>

