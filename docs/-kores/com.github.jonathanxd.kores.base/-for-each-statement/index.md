//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ForEachStatement](index.md)



# ForEachStatement  
 [jvm] data class [ForEachStatement](index.md)(**variable**: [VariableDeclaration](../-variable-declaration/index.md), **iterationType**: [IterationType](../-iteration-type/index.md), **iterableElement**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [BodyHolder](../-body-holder/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

For each statement.



For each statement behavior depends on [IterationType](../-iteration-type/index.md). For Source generation [iterationType](iteration-type.md) is useless, but for bytecode generation it is useful because foreach is translated to a [ForStatement](../-for-statement/index.md), and arrays requires a special treatment to access length and values.

   


## See also  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ForEachStatement///PointingToDeclaration/"></a>[com.github.jonathanxd.kores.base.IterationType](../-iteration-type/index.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement///PointingToDeclaration/"></a>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/ForEachStatement/#com.github.jonathanxd.kores.base.VariableDeclaration#com.github.jonathanxd.kores.base.IterationType#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[ForEachStatement](-for-each-statement.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/ForEachStatement/#com.github.jonathanxd.kores.base.VariableDeclaration#com.github.jonathanxd.kores.base.IterationType#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a> [jvm] fun [ForEachStatement](-for-each-statement.md)(variable: [VariableDeclaration](../-variable-declaration/index.md), iterationType: [IterationType](../-iteration-type/index.md), iterableElement: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ForEachStatement.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [BodyHolder.Builder](../-body-holder/-builder/index.md)<[ForEachStatement](index.md), [ForEachStatement.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [ForEachStatement.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [VariableDeclaration](../-variable-declaration/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [IterationType](../-iteration-type/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/component4/#/PointingToDeclaration/"></a>[component4](component4.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/component4/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component4](component4.md)(): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/copy/#com.github.jonathanxd.kores.base.VariableDeclaration#com.github.jonathanxd.kores.base.IterationType#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/copy/#com.github.jonathanxd.kores.base.VariableDeclaration#com.github.jonathanxd.kores.base.IterationType#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(variable: [VariableDeclaration](../-variable-declaration/index.md), iterationType: [IterationType](../-iteration-type/index.md), iterableElement: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)): [ForEachStatement](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/body/#/PointingToDeclaration/"></a>[body](body.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/body/#/PointingToDeclaration/"></a> [jvm] open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)Body.   <br>
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/iterableElement/#/PointingToDeclaration/"></a>[iterableElement](iterable-element.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/iterableElement/#/PointingToDeclaration/"></a> [jvm] val [iterableElement](iterable-element.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Element to iterate   <br>
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/iterationType/#/PointingToDeclaration/"></a>[iterationType](iteration-type.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/iterationType/#/PointingToDeclaration/"></a> [jvm] val [iterationType](iteration-type.md): [IterationType](../-iteration-type/index.md)Type of the iteration   <br>
| <a name="com.github.jonathanxd.kores.base/ForEachStatement/variable/#/PointingToDeclaration/"></a>[variable](variable.md)| <a name="com.github.jonathanxd.kores.base/ForEachStatement/variable/#/PointingToDeclaration/"></a> [jvm] val [variable](variable.md): [VariableDeclaration](../-variable-declaration/index.md)Variable to store each element   <br>

