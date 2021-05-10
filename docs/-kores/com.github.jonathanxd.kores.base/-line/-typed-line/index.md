//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[Line](../index.md)/[TypedLine](index.md)



# TypedLine  
 [jvm] data class [TypedLine](index.md)(**line**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **value**: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md), **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) : [Line](../index.md), [Typed](../../-typed/index.md)

A [Line](../index.md) which extends [Typed](../../-typed/index.md).

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/TypedLine/#kotlin.Int#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type/PointingToDeclaration/"></a>[TypedLine](-typed-line.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/TypedLine/#kotlin.Int#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type/PointingToDeclaration/"></a> [jvm] fun [TypedLine](-typed-line.md)(line: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Line.Builder](../-builder/index.md)<[Line.TypedLine](index.md), [Line.TypedLine.Builder](-builder/index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[Line.TypedLine](index.md), [Line.TypedLine.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [Line.TypedLine.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/copy/#kotlin.Int#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/copy/#kotlin.Int#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(line: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Line.TypedLine](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/line/#/PointingToDeclaration/"></a>[line](line.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/line/#/PointingToDeclaration/"></a> [jvm] open override val [line](line.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)Line index   <br>
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/value/#/PointingToDeclaration/"></a> [jvm] open override val [value](value.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)Instruction mapped to line   <br>
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/wrappedInstruction/#/PointingToDeclaration/"></a>[wrappedInstruction](index.md#%5Bcom.github.jonathanxd.kores.base%2FLine.TypedLine%2FwrappedInstruction%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1211764316)| <a name="com.github.jonathanxd.kores.base/Line.TypedLine/wrappedInstruction/#/PointingToDeclaration/"></a> [jvm] open override val [wrappedInstruction](index.md#%5Bcom.github.jonathanxd.kores.base%2FLine.TypedLine%2FwrappedInstruction%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1211764316): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)Wrapped instruction instance.   <br>

