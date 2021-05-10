//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[TryStatementBase](../index.md)/[Builder](index.md)



# Builder  
 [jvm] interface [Builder](index.md)<out [T](index.md) : [TryStatementBase](../index.md), [S](index.md) : [TryStatementBase.Builder](index.md)<[T](index.md), [S](index.md)>> : [BodyHolder.Builder](../../-body-holder/-builder/index.md)<[T](index.md), [S](index.md)>    


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/BodyHolder.Builder/body/#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[body](../../-body-holder/-builder/body.md)| <a name="com.github.jonathanxd.kores.base/BodyHolder.Builder/body/#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [body](../../-body-holder/-builder/body.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [S](index.md)  <br>More info  <br>See T.  <br><br><br>
| <a name="com.github.jonathanxd.kores.builder/Builder/build/#/PointingToDeclaration/"></a>[build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)| <a name="com.github.jonathanxd.kores.builder/Builder/build/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)  <br>More info  <br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TryStatementBase.Builder/catchStatements/#kotlin.Array[com.github.jonathanxd.kores.base.CatchStatement]/PointingToDeclaration/"></a>[catchStatements](catch-statements.md)| <a name="com.github.jonathanxd.kores.base/TryStatementBase.Builder/catchStatements/#kotlin.Array[com.github.jonathanxd.kores.base.CatchStatement]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [catchStatements](catch-statements.md)(vararg values: [CatchStatement](../../-catch-statement/index.md)): [S](index.md)  <br>abstract fun [catchStatements](catch-statements.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../../-catch-statement/index.md)>): [S](index.md)  <br>More info  <br>See [TryStatementBase.catchStatements](../catch-statements.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TryStatementBase.Builder/finallyStatement/#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[finallyStatement](finally-statement.md)| <a name="com.github.jonathanxd.kores.base/TryStatementBase.Builder/finallyStatement/#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [finallyStatement](finally-statement.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [S](index.md)  <br>More info  <br>See [TryStatementBase.finallyStatement](../finally-statement.md)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/TryStatement.Builder///PointingToDeclaration/"></a>[TryStatement](../../-try-statement/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/TryWithResources.Builder///PointingToDeclaration/"></a>[TryWithResources](../../-try-with-resources/-builder/index.md)

