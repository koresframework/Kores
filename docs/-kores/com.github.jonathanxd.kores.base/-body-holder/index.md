//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[BodyHolder](index.md)



# BodyHolder  
 [jvm] interface [BodyHolder](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

Holds a body. Example: method declarations, type declarations, static block, constructors...

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/BodyHolder.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/BodyHolder.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [BodyHolder](index.md), [S](-builder/index.md) : [BodyHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>
| <a name="com.github.jonathanxd.kores.base/BodyHolder.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.github.jonathanxd.kores.base/BodyHolder.Companion///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/BodyHolder/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/BodyHolder/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [BodyHolder.Builder](-builder/index.md)<[BodyHolder](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/BodyHolder/body/#/PointingToDeclaration/"></a>[body](body.md)| <a name="com.github.jonathanxd.kores.base/BodyHolder/body/#/PointingToDeclaration/"></a> [jvm] abstract val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)Body.   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/Case///PointingToDeclaration/"></a>[Case](../-case/index.md)
| <a name="com.github.jonathanxd.kores.base/CatchStatement///PointingToDeclaration/"></a>[CatchStatement](../-catch-statement/index.md)
| <a name="com.github.jonathanxd.kores.base/ForEachStatement///PointingToDeclaration/"></a>[ForEachStatement](../-for-each-statement/index.md)
| <a name="com.github.jonathanxd.kores.base/ForStatement///PointingToDeclaration/"></a>[ForStatement](../-for-statement/index.md)
| <a name="com.github.jonathanxd.kores.base/IfStatement///PointingToDeclaration/"></a>[IfStatement](../-if-statement/index.md)
| <a name="com.github.jonathanxd.kores.base/Label///PointingToDeclaration/"></a>[Label](../-label/index.md)
| <a name="com.github.jonathanxd.kores.base/MethodDeclarationBase///PointingToDeclaration/"></a>[MethodDeclarationBase](../-method-declaration-base/index.md)
| <a name="com.github.jonathanxd.kores.base/Synchronized///PointingToDeclaration/"></a>[Synchronized](../-synchronized/index.md)
| <a name="com.github.jonathanxd.kores.base/TryStatementBase///PointingToDeclaration/"></a>[TryStatementBase](../-try-statement-base/index.md)
| <a name="com.github.jonathanxd.kores.base/WhileStatement///PointingToDeclaration/"></a>[WhileStatement](../-while-statement/index.md)

