//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[CatchStatement](index.md)



# CatchStatement  
 [jvm] data class [CatchStatement](index.md)(**exceptionTypes**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>, **variable**: [VariableDeclaration](../-variable-declaration/index.md), **body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [BodyHolder](../-body-holder/index.md), [Typed](../-typed/index.md)

Catch statement of a try block. Catch [exceptionTypes](exception-types.md) and store caught exception in [variable](variable.md).

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/CatchStatement/CatchStatement/#kotlin.collections.List[java.lang.reflect.Type]#com.github.jonathanxd.kores.base.VariableDeclaration#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[CatchStatement](-catch-statement.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement/CatchStatement/#kotlin.collections.List[java.lang.reflect.Type]#com.github.jonathanxd.kores.base.VariableDeclaration#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a> [jvm] fun [CatchStatement](-catch-statement.md)(exceptionTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>, variable: [VariableDeclaration](../-variable-declaration/index.md), body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/CatchStatement.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [BodyHolder.Builder](../-body-holder/-builder/index.md)<[CatchStatement](index.md), [CatchStatement.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[CatchStatement](index.md), [CatchStatement.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/CatchStatement/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [CatchStatement.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/CatchStatement/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/CatchStatement/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [VariableDeclaration](../-variable-declaration/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/CatchStatement/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/CatchStatement/copy/#kotlin.collections.List[java.lang.reflect.Type]#com.github.jonathanxd.kores.base.VariableDeclaration#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement/copy/#kotlin.collections.List[java.lang.reflect.Type]#com.github.jonathanxd.kores.base.VariableDeclaration#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(exceptionTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>, variable: [VariableDeclaration](../-variable-declaration/index.md), body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)): [CatchStatement](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/CatchStatement/body/#/PointingToDeclaration/"></a>[body](body.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement/body/#/PointingToDeclaration/"></a> [jvm] open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)Body of exception handler.   <br>
| <a name="com.github.jonathanxd.kores.base/CatchStatement/exceptionTypes/#/PointingToDeclaration/"></a>[exceptionTypes](exception-types.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement/exceptionTypes/#/PointingToDeclaration/"></a> [jvm] val [exceptionTypes](exception-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>Exception types to catch.   <br>
| <a name="com.github.jonathanxd.kores.base/CatchStatement/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>
| <a name="com.github.jonathanxd.kores.base/CatchStatement/variable/#/PointingToDeclaration/"></a>[variable](variable.md)| <a name="com.github.jonathanxd.kores.base/CatchStatement/variable/#/PointingToDeclaration/"></a> [jvm] val [variable](variable.md): [VariableDeclaration](../-variable-declaration/index.md)Variable to store exception.   <br>

