//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[TryStatementBase](index.md)



# TryStatementBase  
 [jvm] interface [TryStatementBase](index.md) : [BodyHolder](../-body-holder/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Try-catch-finally statement

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TryStatementBase.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/TryStatementBase.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [TryStatementBase](index.md), [S](-builder/index.md) : [TryStatementBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [BodyHolder.Builder](../-body-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TryStatementBase/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/TryStatementBase/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [TryStatementBase.Builder](-builder/index.md)<[TryStatementBase](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TryStatementBase/body/#/PointingToDeclaration/"></a>[body](index.md#%5Bcom.github.jonathanxd.kores.base%2FTryStatementBase%2Fbody%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-427383591)| <a name="com.github.jonathanxd.kores.base/TryStatementBase/body/#/PointingToDeclaration/"></a> [jvm] abstract val [body](index.md#%5Bcom.github.jonathanxd.kores.base%2FTryStatementBase%2Fbody%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-427383591): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)Body.   <br>
| <a name="com.github.jonathanxd.kores.base/TryStatementBase/catchStatements/#/PointingToDeclaration/"></a>[catchStatements](catch-statements.md)| <a name="com.github.jonathanxd.kores.base/TryStatementBase/catchStatements/#/PointingToDeclaration/"></a> [jvm] abstract val [catchStatements](catch-statements.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)>Exception handler statements   <br>
| <a name="com.github.jonathanxd.kores.base/TryStatementBase/finallyStatement/#/PointingToDeclaration/"></a>[finallyStatement](finally-statement.md)| <a name="com.github.jonathanxd.kores.base/TryStatementBase/finallyStatement/#/PointingToDeclaration/"></a> [jvm] abstract val [finallyStatement](finally-statement.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)Finally block statement   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/TryStatement///PointingToDeclaration/"></a>[TryStatement](../-try-statement/index.md)
| <a name="com.github.jonathanxd.kores.base/TryWithResources///PointingToDeclaration/"></a>[TryWithResources](../-try-with-resources/index.md)

