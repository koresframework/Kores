//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[IfStatement](index.md)



# IfStatement  
 [jvm] data class [IfStatement](index.md)(**expressions**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, **body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), **elseStatement**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [IfExpressionHolder](../-if-expression-holder/index.md), [BodyHolder](../-body-holder/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

If statement.

   


## See also  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfStatement///PointingToDeclaration/"></a>[com.github.jonathanxd.kores.base.IfExpr](../-if-expr/index.md)| <a name="com.github.jonathanxd.kores.base/IfStatement///PointingToDeclaration/"></a>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfStatement/IfStatement/#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#com.github.jonathanxd.kores.Instructions#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[IfStatement](-if-statement.md)| <a name="com.github.jonathanxd.kores.base/IfStatement/IfStatement/#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#com.github.jonathanxd.kores.Instructions#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a> [jvm] fun [IfStatement](-if-statement.md)(expressions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), elseStatement: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfStatement.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/IfStatement.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [IfExpressionHolder.Builder](../-if-expression-holder/-builder/index.md)<[IfStatement](index.md), [IfStatement.Builder](-builder/index.md)> , [BodyHolder.Builder](../-body-holder/-builder/index.md)<[IfStatement](index.md), [IfStatement.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfStatement/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/IfStatement/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [IfStatement.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/IfStatement/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/IfStatement/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/IfStatement/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/IfStatement/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/IfStatement/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/IfStatement/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/IfStatement/copy/#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#com.github.jonathanxd.kores.Instructions#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/IfStatement/copy/#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#com.github.jonathanxd.kores.Instructions#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(expressions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), elseStatement: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)): [IfStatement](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfStatement/body/#/PointingToDeclaration/"></a>[body](body.md)| <a name="com.github.jonathanxd.kores.base/IfStatement/body/#/PointingToDeclaration/"></a> [jvm] open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)Body.   <br>
| <a name="com.github.jonathanxd.kores.base/IfStatement/elseStatement/#/PointingToDeclaration/"></a>[elseStatement](else-statement.md)| <a name="com.github.jonathanxd.kores.base/IfStatement/elseStatement/#/PointingToDeclaration/"></a> [jvm] val [elseStatement](else-statement.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)Else statement   <br>
| <a name="com.github.jonathanxd.kores.base/IfStatement/expressions/#/PointingToDeclaration/"></a>[expressions](expressions.md)| <a name="com.github.jonathanxd.kores.base/IfStatement/expressions/#/PointingToDeclaration/"></a> [jvm] open override val [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>If expressions and operationsExpressions can be: [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md) (both only before and/or after Operators.   <br>

