//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[TryStatement](index.md)



# TryStatement  
 [jvm] data class [TryStatement](index.md)(**body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), **catchStatements**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)>, **finallyStatement**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [TryStatementBase](../-try-statement-base/index.md)

Try-catch-finally statement.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TryStatement/TryStatement/#com.github.jonathanxd.kores.Instructions#kotlin.collections.List[com.github.jonathanxd.kores.base.CatchStatement]#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[TryStatement](-try-statement.md)| <a name="com.github.jonathanxd.kores.base/TryStatement/TryStatement/#com.github.jonathanxd.kores.Instructions#kotlin.collections.List[com.github.jonathanxd.kores.base.CatchStatement]#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a> [jvm] fun [TryStatement](-try-statement.md)(body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), catchStatements: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)>, finallyStatement: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TryStatement.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/TryStatement.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [TryStatementBase.Builder](../-try-statement-base/-builder/index.md)<[TryStatement](index.md), [TryStatement.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TryStatement/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/TryStatement/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [TryStatement.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TryStatement/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/TryStatement/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TryStatement/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/TryStatement/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)>  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TryStatement/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/TryStatement/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TryStatement/copy/#com.github.jonathanxd.kores.Instructions#kotlin.collections.List[com.github.jonathanxd.kores.base.CatchStatement]#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/TryStatement/copy/#com.github.jonathanxd.kores.Instructions#kotlin.collections.List[com.github.jonathanxd.kores.base.CatchStatement]#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), catchStatements: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)>, finallyStatement: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)): [TryStatement](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TryStatement/body/#/PointingToDeclaration/"></a>[body](body.md)| <a name="com.github.jonathanxd.kores.base/TryStatement/body/#/PointingToDeclaration/"></a> [jvm] open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)Body of try statement   <br>
| <a name="com.github.jonathanxd.kores.base/TryStatement/catchStatements/#/PointingToDeclaration/"></a>[catchStatements](catch-statements.md)| <a name="com.github.jonathanxd.kores.base/TryStatement/catchStatements/#/PointingToDeclaration/"></a> [jvm] open override val [catchStatements](catch-statements.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)>Catch clauses/exception handlers.   <br>
| <a name="com.github.jonathanxd.kores.base/TryStatement/finallyStatement/#/PointingToDeclaration/"></a>[finallyStatement](finally-statement.md)| <a name="com.github.jonathanxd.kores.base/TryStatement/finallyStatement/#/PointingToDeclaration/"></a> [jvm] open override val [finallyStatement](finally-statement.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)Finally block (Obs: for bytecode generation, finally blocks is always inlined).   <br>

