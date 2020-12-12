//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[VariableBase](index.md)



# VariableBase  
 [jvm] interface [VariableBase](index.md) : [Named](../-named/index.md), [Typed](../-typed/index.md)

Base variable manipulation.

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/VariableBase.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/VariableBase.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [VariableBase](index.md), [S](-builder/index.md) : [VariableBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Named.Builder](../-named/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/VariableBase/access/#/PointingToDeclaration/"></a>[access](access.md)| <a name="com.github.jonathanxd.kores.base/VariableBase/access/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [access](access.md)(): [VariableAccess](../-variable-access/index.md)  <br>More info  <br>Creates access to the variable that this instance represents.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/VariableBase/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/VariableBase/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [VariableBase.Builder](-builder/index.md)<[VariableBase](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/VariableBase/set/#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[set](set.md)| <a name="com.github.jonathanxd.kores.base/VariableBase/set/#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [set](set.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [VariableDefinition](../-variable-definition/index.md)  <br>More info  <br>Creates a definition of the value of the variable that this instance represents.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/VariableBase/name/#/PointingToDeclaration/"></a>[name](name.md)| <a name="com.github.jonathanxd.kores.base/VariableBase/name/#/PointingToDeclaration/"></a> [jvm] abstract override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)Variable name   <br>
| <a name="com.github.jonathanxd.kores.base/VariableBase/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/VariableBase/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>
| <a name="com.github.jonathanxd.kores.base/VariableBase/variableType/#/PointingToDeclaration/"></a>[variableType](variable-type.md)| <a name="com.github.jonathanxd.kores.base/VariableBase/variableType/#/PointingToDeclaration/"></a> [jvm] abstract val [variableType](variable-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Variable type   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/VariableAccess///PointingToDeclaration/"></a>[VariableAccess](../-variable-access/index.md)
| <a name="com.github.jonathanxd.kores.base/VariableDeclaration///PointingToDeclaration/"></a>[VariableDeclaration](../-variable-declaration/index.md)
| <a name="com.github.jonathanxd.kores.common/VariableRef///PointingToDeclaration/"></a>[VariableRef](../../com.github.jonathanxd.kores.common/-variable-ref/index.md)

