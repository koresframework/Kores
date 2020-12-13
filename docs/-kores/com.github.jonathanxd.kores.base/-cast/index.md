//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Cast](index.md)



# Cast  
 [jvm] data class [Cast](index.md)(**originalType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?, **targetType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **instruction**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [Typed](../-typed/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Value cast. Cast [instruction](instruction.md) of type [originalType](original-type.md) (null if unknown) to [targetType](target-type.md). Official BytecodeGenerator uses the [originalType](original-type.md) to auto-box and auto-unbox the value.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Cast/Cast/#java.lang.reflect.Type?#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[Cast](-cast.md)| <a name="com.github.jonathanxd.kores.base/Cast/Cast/#java.lang.reflect.Type?#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a> [jvm] fun [Cast](-cast.md)(originalType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?, targetType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), instruction: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Cast.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/Cast.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Typed.Builder](../-typed/-builder/index.md)<[Cast](index.md), [Cast.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Cast/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/Cast/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [Cast.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Cast/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/Cast/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Cast/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/Cast/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Cast/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/Cast/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Cast/copy/#java.lang.reflect.Type?#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/Cast/copy/#java.lang.reflect.Type?#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(originalType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?, targetType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), instruction: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [Cast](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Cast/instruction/#/PointingToDeclaration/"></a>[instruction](instruction.md)| <a name="com.github.jonathanxd.kores.base/Cast/instruction/#/PointingToDeclaration/"></a> [jvm] val [instruction](instruction.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Instruction to cast   <br>
| <a name="com.github.jonathanxd.kores.base/Cast/originalType/#/PointingToDeclaration/"></a>[originalType](original-type.md)| <a name="com.github.jonathanxd.kores.base/Cast/originalType/#/PointingToDeclaration/"></a> [jvm] val [originalType](original-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?Origin type   <br>
| <a name="com.github.jonathanxd.kores.base/Cast/targetType/#/PointingToDeclaration/"></a>[targetType](target-type.md)| <a name="com.github.jonathanxd.kores.base/Cast/targetType/#/PointingToDeclaration/"></a> [jvm] val [targetType](target-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Target type   <br>
| <a name="com.github.jonathanxd.kores.base/Cast/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/Cast/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>

