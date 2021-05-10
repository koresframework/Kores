//[Kores](../../index.md)/[com.github.jonathanxd.kores.literal](../index.md)/[Literal](index.md)



# Literal  
 [jvm] abstract class [Literal](index.md) : [TypedInstruction](../../com.github.jonathanxd.kores.base/-typed-instruction/index.md), [Named](../../com.github.jonathanxd.kores.base/-named/index.md)

A JVM Literal.



Example of literals: Strings, Ints, Doubles, Longs, Types, etc.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.literal/Literal/Literal/#kotlin.String#com.github.jonathanxd.kores.type.KoresType/PointingToDeclaration/"></a>[Literal](-literal.md)| <a name="com.github.jonathanxd.kores.literal/Literal/Literal/#kotlin.String#com.github.jonathanxd.kores.type.KoresType/PointingToDeclaration/"></a> [jvm] fun [Literal](-literal.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), type: [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.literal/Literal/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.literal/Literal/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.literal/Literal/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](equals.md)| <a name="com.github.jonathanxd.kores.literal/Literal/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.literal/Literal/hashCode/#/PointingToDeclaration/"></a>[hashCode](hash-code.md)| <a name="com.github.jonathanxd.kores.literal/Literal/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.literal/Literal/toString/#/PointingToDeclaration/"></a>[toString](to-string.md)| <a name="com.github.jonathanxd.kores.literal/Literal/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.literal/Literal/name/#/PointingToDeclaration/"></a>[name](name.md)| <a name="com.github.jonathanxd.kores.literal/Literal/name/#/PointingToDeclaration/"></a> [jvm] ~~open~~ ~~override~~ ~~val~~ [~~name~~](name.md)~~:~~ [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)Name   <br>
| <a name="com.github.jonathanxd.kores.literal/Literal/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.literal/Literal/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)Element type   <br>
| <a name="com.github.jonathanxd.kores.literal/Literal/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="com.github.jonathanxd.kores.literal/Literal/value/#/PointingToDeclaration/"></a> [jvm] val [value](value.md): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.common/Stack///PointingToDeclaration/"></a>[Stack](../../com.github.jonathanxd.kores.common/-stack/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literals.ClassLiteral///PointingToDeclaration/"></a>[Literals](../-literals/-class-literal/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literals.ByteLiteral///PointingToDeclaration/"></a>[Literals](../-literals/-byte-literal/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literals.ShortLiteral///PointingToDeclaration/"></a>[Literals](../-literals/-short-literal/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literals.IntLiteral///PointingToDeclaration/"></a>[Literals](../-literals/-int-literal/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literals.BoolLiteral///PointingToDeclaration/"></a>[Literals](../-literals/-bool-literal/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literals.LongLiteral///PointingToDeclaration/"></a>[Literals](../-literals/-long-literal/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literals.FloatLiteral///PointingToDeclaration/"></a>[Literals](../-literals/-float-literal/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literals.DoubleLiteral///PointingToDeclaration/"></a>[Literals](../-literals/-double-literal/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literals.CharLiteral///PointingToDeclaration/"></a>[Literals](../-literals/-char-literal/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literals.StringLiteral///PointingToDeclaration/"></a>[Literals](../-literals/-string-literal/index.md)

