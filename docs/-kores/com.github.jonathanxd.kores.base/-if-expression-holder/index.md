//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[IfExpressionHolder](index.md)



# IfExpressionHolder  
 [jvm] interface [IfExpressionHolder](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

A element that holds [IfExpressions](../-if-expr/index.md) and [Operations](../../com.github.jonathanxd.kores.operator/-operators/index.md).

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfExpressionHolder.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/IfExpressionHolder.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [IfExpressionHolder](index.md), [S](-builder/index.md) : [IfExpressionHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>
| <a name="com.github.jonathanxd.kores.base/IfExpressionHolder.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.github.jonathanxd.kores.base/IfExpressionHolder.Companion///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfExpressionHolder/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/IfExpressionHolder/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [IfExpressionHolder.Builder](-builder/index.md)<[IfExpressionHolder](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfExpressionHolder/expressions/#/PointingToDeclaration/"></a>[expressions](expressions.md)| <a name="com.github.jonathanxd.kores.base/IfExpressionHolder/expressions/#/PointingToDeclaration/"></a> [jvm] abstract val [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>If expressions and operationsExpressions can be: [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md) (both only before and/or after [Operators.OR](../../com.github.jonathanxd.kores.operator/-operators/-o-r.md) and [Operators.AND](../../com.github.jonathanxd.kores.operator/-operators/-a-n-d.md)), [Operators.AND](../../com.github.jonathanxd.kores.operator/-operators/-a-n-d.md) (only after a [IfExpr](../-if-expr/index.md)/[IfGroup](../-if-group/index.md), followed by other [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md)) and [Operators.OR](../../com.github.jonathanxd.kores.operator/-operators/-o-r.md) (only after a [IfExpr](../-if-expr/index.md)/[IfGroup](../-if-group/index.md) and followed by other [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md)).   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/ForStatement///PointingToDeclaration/"></a>[ForStatement](../-for-statement/index.md)
| <a name="com.github.jonathanxd.kores.base/IfGroup///PointingToDeclaration/"></a>[IfGroup](../-if-group/index.md)
| <a name="com.github.jonathanxd.kores.base/IfStatement///PointingToDeclaration/"></a>[IfStatement](../-if-statement/index.md)
| <a name="com.github.jonathanxd.kores.base/WhileStatement///PointingToDeclaration/"></a>[WhileStatement](../-while-statement/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.inspect//alwaysBranch/com.github.jonathanxd.kores.base.IfExpressionHolder#kotlin.Function1[com.github.jonathanxd.kores.Instruction,kotlin.Boolean]/PointingToDeclaration/"></a>[alwaysBranch](../../com.github.jonathanxd.kores.inspect/always-branch.md)| <a name="com.github.jonathanxd.kores.inspect//alwaysBranch/com.github.jonathanxd.kores.base.IfExpressionHolder#kotlin.Function1[com.github.jonathanxd.kores.Instruction,kotlin.Boolean]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [IfExpressionHolder](index.md).[alwaysBranch](../../com.github.jonathanxd.kores.inspect/always-branch.md)(matcher: ([Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>

