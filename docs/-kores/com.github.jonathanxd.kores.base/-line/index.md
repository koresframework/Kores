//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Line](index.md)



# Line  
 [jvm] sealed class [Line](index.md) : [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), [ValueHolder](../-value-holder/index.md), InstructionWrapper

Base class of line mapping. Line mapping behaves differently for different generators.

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Line.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/Line.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [Line](index.md), [S](-builder/index.md) : [Line.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [ValueHolder.Builder](../-value-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Line.NormalLine///PointingToDeclaration/"></a>[NormalLine](-normal-line/index.md)| <a name="com.github.jonathanxd.kores.base/Line.NormalLine///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [NormalLine](-normal-line/index.md)(**line**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [Line](index.md)  <br>More info  <br>A Line which does extends [Line](index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine///PointingToDeclaration/"></a>[TypedLine](-typed-line/index.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [TypedLine](-typed-line/index.md)(**line**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) : [Line](index.md), [Typed](../-typed/index.md)  <br>More info  <br>A [Line](index.md) which extends [Typed](../-typed/index.md).  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Line/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/Line/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [Line.Builder](-builder/index.md)<[Line](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Line/line/#/PointingToDeclaration/"></a>[line](line.md)| <a name="com.github.jonathanxd.kores.base/Line/line/#/PointingToDeclaration/"></a> [jvm] abstract val [line](line.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)Line index   <br>
| <a name="com.github.jonathanxd.kores.base/Line/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="com.github.jonathanxd.kores.base/Line/value/#/PointingToDeclaration/"></a> [jvm] abstract override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Instruction mapped to line   <br>
| <a name="com.github.jonathanxd.kores.base/Line/wrappedInstruction/#/PointingToDeclaration/"></a>[wrappedInstruction](wrapped-instruction.md)| <a name="com.github.jonathanxd.kores.base/Line/wrappedInstruction/#/PointingToDeclaration/"></a> [jvm] open override val [wrappedInstruction](wrapped-instruction.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Wrapped instruction instance.   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine///PointingToDeclaration/"></a>[Line](-typed-line/index.md)
| <a name="com.github.jonathanxd.kores.base/Line.NormalLine///PointingToDeclaration/"></a>[Line](-normal-line/index.md)

