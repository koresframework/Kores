//[Kores](../../index.md)/[com.github.jonathanxd.kores.operator](../index.md)/[Operator](index.md)



# Operator  
 [jvm] sealed class [Operator](index.md) : [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), [Named](../../com.github.jonathanxd.kores.base/-named/index.md)

Operator.



Example of operators: Increment, Decrement, Less_than, etc...

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.operator/Operator.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.operator/Operator.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Named.Builder](../../com.github.jonathanxd.kores.base/-named/-builder/index.md)<[Operator](index.md), [Operator.Builder](-builder/index.md)>   <br><br><br>
| <a name="com.github.jonathanxd.kores.operator/Operator.Conditional///PointingToDeclaration/"></a>[Conditional](-conditional/index.md)| <a name="com.github.jonathanxd.kores.operator/Operator.Conditional///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Conditional](-conditional/index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Operator](index.md)  <br>More info  <br>Conditional operator  <br><br><br>
| <a name="com.github.jonathanxd.kores.operator/Operator.Math///PointingToDeclaration/"></a>[Math](-math/index.md)| <a name="com.github.jonathanxd.kores.operator/Operator.Math///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Math](-math/index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Operator](index.md)  <br>More info  <br>Mathematical operator  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.operator/Operator/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.operator/Operator/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [Operator.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.operator/Operator/toString/#/PointingToDeclaration/"></a>[toString](to-string.md)| <a name="com.github.jonathanxd.kores.operator/Operator/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.operator/Operator/name/#/PointingToDeclaration/"></a>[name](name.md)| <a name="com.github.jonathanxd.kores.operator/Operator/name/#/PointingToDeclaration/"></a> [jvm] open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)Name   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.operator/Operator.Math///PointingToDeclaration/"></a>[Operator](-math/index.md)
| <a name="com.github.jonathanxd.kores.operator/Operator.Conditional///PointingToDeclaration/"></a>[Operator](-conditional/index.md)

