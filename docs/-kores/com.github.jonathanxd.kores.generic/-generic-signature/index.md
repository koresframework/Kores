//[Kores](../../index.md)/[com.github.jonathanxd.kores.generic](../index.md)/[GenericSignature](index.md)



# GenericSignature  
 [jvm] class [GenericSignature](index.md)(**_types**: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)>)

Hold information about generic signatures.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.generic/GenericSignature/GenericSignature/#kotlin.Array[com.github.jonathanxd.kores.type.GenericType]/PointingToDeclaration/"></a>[GenericSignature](-generic-signature.md)| <a name="com.github.jonathanxd.kores.generic/GenericSignature/GenericSignature/#kotlin.Array[com.github.jonathanxd.kores.type.GenericType]/PointingToDeclaration/"></a> [jvm] fun [GenericSignature](-generic-signature.md)(_types: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)>)   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.generic/GenericSignature.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.github.jonathanxd.kores.generic/GenericSignature.Companion///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.generic/GenericSignature/toString/#/PointingToDeclaration/"></a>[toString](to-string.md)| <a name="com.github.jonathanxd.kores.generic/GenericSignature/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.generic/GenericSignature/isEmpty/#/PointingToDeclaration/"></a>[isEmpty](is-empty.md)| <a name="com.github.jonathanxd.kores.generic/GenericSignature/isEmpty/#/PointingToDeclaration/"></a> [jvm] val [isEmpty](is-empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Returns true if this generic signature is empty (no types).   <br>
| <a name="com.github.jonathanxd.kores.generic/GenericSignature/isNotEmpty/#/PointingToDeclaration/"></a>[isNotEmpty](is-not-empty.md)| <a name="com.github.jonathanxd.kores.generic/GenericSignature/isNotEmpty/#/PointingToDeclaration/"></a> [jvm] val [isNotEmpty](is-not-empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Returns true if this generic signature is not empty.   <br>
| <a name="com.github.jonathanxd.kores.generic/GenericSignature/types/#/PointingToDeclaration/"></a>[types](types.md)| <a name="com.github.jonathanxd.kores.generic/GenericSignature/types/#/PointingToDeclaration/"></a> [jvm] val [types](types.md): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)>   <br>


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util//genericSignatureToDescriptor/com.github.jonathanxd.kores.generic.GenericSignature#/PointingToDeclaration/"></a>[genericSignatureToDescriptor](../../com.github.jonathanxd.kores.util/generic-signature-to-descriptor.md)| <a name="com.github.jonathanxd.kores.util//genericSignatureToDescriptor/com.github.jonathanxd.kores.generic.GenericSignature#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [GenericSignature](index.md).[genericSignatureToDescriptor](../../com.github.jonathanxd.kores.util/generic-signature-to-descriptor.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br>More info  <br>Create a type descriptor from receiver signature  <br><br><br>
| <a name="com.github.jonathanxd.kores.util//toSourceString/com.github.jonathanxd.kores.generic.GenericSignature#/PointingToDeclaration/"></a>[toSourceString](../../com.github.jonathanxd.kores.util/to-source-string.md)| <a name="com.github.jonathanxd.kores.util//toSourceString/com.github.jonathanxd.kores.generic.GenericSignature#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [GenericSignature](index.md).[toSourceString](../../com.github.jonathanxd.kores.util/to-source-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br>More info  <br>Convert generic signature to string.  <br><br><br>

