//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ArrayAccess](index.md)



# ArrayAccess  
 [jvm] interface [ArrayAccess](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

Access to an array.

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayAccess.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/ArrayAccess.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ArrayAccess](index.md), [S](-builder/index.md) : [ArrayAccess.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayAccess/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/ArrayAccess/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [ArrayAccess.Builder](-builder/index.md)<[ArrayAccess](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayAccess/arrayType/#/PointingToDeclaration/"></a>[arrayType](array-type.md)| <a name="com.github.jonathanxd.kores.base/ArrayAccess/arrayType/#/PointingToDeclaration/"></a> [jvm] abstract val [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Array type   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayAccess/target/#/PointingToDeclaration/"></a>[target](target.md)| <a name="com.github.jonathanxd.kores.base/ArrayAccess/target/#/PointingToDeclaration/"></a> [jvm] abstract val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Target array to access   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/ArrayLength///PointingToDeclaration/"></a>[ArrayLength](../-array-length/index.md)
| <a name="com.github.jonathanxd.kores.base/ArrayLoad///PointingToDeclaration/"></a>[ArrayLoad](../-array-load/index.md)
| <a name="com.github.jonathanxd.kores.base/ArrayStore///PointingToDeclaration/"></a>[ArrayStore](../-array-store/index.md)

