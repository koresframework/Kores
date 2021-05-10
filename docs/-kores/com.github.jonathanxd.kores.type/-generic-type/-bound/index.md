//[Kores](../../../index.md)/[com.github.jonathanxd.kores.type](../../index.md)/[GenericType](../index.md)/[Bound](index.md)



# Bound  
 [jvm] abstract class [Bound](index.md)(**type**: [KoresType](../../-kores-type/index.md))

Generic type bounds.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.type/GenericType.Bound/Bound/#com.github.jonathanxd.kores.type.KoresType/PointingToDeclaration/"></a>[Bound](-bound.md)| <a name="com.github.jonathanxd.kores.type/GenericType.Bound/Bound/#com.github.jonathanxd.kores.type.KoresType/PointingToDeclaration/"></a> [jvm] fun [Bound](-bound.md)(type: [KoresType](../../-kores-type/index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.type/GenericType.Bound/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](equals.md)| <a name="com.github.jonathanxd.kores.type/GenericType.Bound/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.type/GenericType.Bound/hashCode/#/PointingToDeclaration/"></a>[hashCode](hash-code.md)| <a name="com.github.jonathanxd.kores.type/GenericType.Bound/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.type/GenericType.Bound/sign/#/PointingToDeclaration/"></a>[sign](sign.md)| <a name="com.github.jonathanxd.kores.type/GenericType.Bound/sign/#/PointingToDeclaration/"></a> [jvm] abstract val [sign](sign.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)Symbol of this bound.   <br>
| <a name="com.github.jonathanxd.kores.type/GenericType.Bound/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.type/GenericType.Bound/type/#/PointingToDeclaration/"></a> [jvm] val [type](type.md): [KoresType](../../-kores-type/index.md)   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.type/GenericType.WildcardBound///PointingToDeclaration/"></a>[GenericType](../-wildcard-bound/index.md)
| <a name="com.github.jonathanxd.kores.type/GenericType.GenericBound///PointingToDeclaration/"></a>[GenericType](../-generic-bound/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util//toComponentString/com.github.jonathanxd.kores.type.GenericType.Bound#/PointingToDeclaration/"></a>[toComponentString](../../../com.github.jonathanxd.kores.util/to-component-string.md)| <a name="com.github.jonathanxd.kores.util//toComponentString/com.github.jonathanxd.kores.type.GenericType.Bound#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [GenericType.Bound](index.md).[toComponentString](../../../com.github.jonathanxd.kores.util/to-component-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br>More info  <br>Creates a string representation of components of [GenericType.Bound](index.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toInstruction/com.github.jonathanxd.kores.type.GenericType.Bound#/PointingToDeclaration/"></a>[toInstruction](../../../com.github.jonathanxd.kores.util.conversion/to-instruction.md)| <a name="com.github.jonathanxd.kores.util.conversion//toInstruction/com.github.jonathanxd.kores.type.GenericType.Bound#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [GenericType.Bound](index.md).[toInstruction](../../../com.github.jonathanxd.kores.util.conversion/to-instruction.md)(): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)  <br>More info  <br>Creates [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) from [bound representation](index.md).  <br><br><br>

