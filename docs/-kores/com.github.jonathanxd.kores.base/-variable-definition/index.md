//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[VariableDefinition](index.md)



# VariableDefinition  
 [jvm] data class [VariableDefinition](index.md)(**type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [Named](../-named/index.md), [TypedInstruction](../-typed-instruction/index.md), [ValueHolder](../-value-holder/index.md)

Defines the value of variable of type [type](type.md) and name [name](name.md) to [value](value.md).

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/VariableDefinition/VariableDefinition/#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[VariableDefinition](-variable-definition.md)| <a name="com.github.jonathanxd.kores.base/VariableDefinition/VariableDefinition/#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a> [jvm] fun [VariableDefinition](-variable-definition.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/VariableDefinition.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/VariableDefinition.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Named.Builder](../-named/-builder/index.md)<[VariableDefinition](index.md), [VariableDefinition.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[VariableDefinition](index.md), [VariableDefinition.Builder](-builder/index.md)> , [ValueHolder.Builder](../-value-holder/-builder/index.md)<[VariableDefinition](index.md), [VariableDefinition.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/VariableDefinition/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/VariableDefinition/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [VariableDefinition.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/VariableDefinition/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/VariableDefinition/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/VariableDefinition/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/VariableDefinition/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/VariableDefinition/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/VariableDefinition/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/VariableDefinition/copy/#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/VariableDefinition/copy/#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [VariableDefinition](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/VariableDefinition/name/#/PointingToDeclaration/"></a>[name](name.md)| <a name="com.github.jonathanxd.kores.base/VariableDefinition/name/#/PointingToDeclaration/"></a> [jvm] open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)Name   <br>
| <a name="com.github.jonathanxd.kores.base/VariableDefinition/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/VariableDefinition/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>
| <a name="com.github.jonathanxd.kores.base/VariableDefinition/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="com.github.jonathanxd.kores.base/VariableDefinition/value/#/PointingToDeclaration/"></a> [jvm] open override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Value   <br>

