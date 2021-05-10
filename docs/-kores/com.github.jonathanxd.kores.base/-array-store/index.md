//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ArrayStore](index.md)



# ArrayStore  
 [jvm] data class [ArrayStore](index.md)(**arrayType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **target**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **index**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **valueType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **valueToStore**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [ArrayAccess](../-array-access/index.md), [ValueHolder](../-value-holder/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Stores [value](value-to-store.md) of type [valueType](value-type.md) in array [target](target.md) of type [arrayType](array-type.md) at [index](--index--.md).

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayStore/ArrayStore/#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[ArrayStore](-array-store.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/ArrayStore/#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a> [jvm] fun [ArrayStore](-array-store.md)(arrayType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), index: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), valueToStore: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayStore.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [ArrayAccess.Builder](../-array-access/-builder/index.md)<[ArrayStore](index.md), [ArrayStore.Builder](-builder/index.md)> , [ValueHolder.Builder](../-value-holder/-builder/index.md)<[ArrayStore](index.md), [ArrayStore.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayStore/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [ArrayStore.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/component4/#/PointingToDeclaration/"></a>[component4](component4.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/component4/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component4](component4.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/component5/#/PointingToDeclaration/"></a>[component5](component5.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/component5/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component5](component5.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/copy/#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/copy/#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(arrayType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), index: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), valueToStore: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [ArrayStore](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayStore/arrayType/#/PointingToDeclaration/"></a>[arrayType](array-type.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/arrayType/#/PointingToDeclaration/"></a> [jvm] open override val [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Array type   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/index/#/PointingToDeclaration/"></a>[index](--index--.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/index/#/PointingToDeclaration/"></a> [jvm] val [index](--index--.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Index to access   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/target/#/PointingToDeclaration/"></a>[target](target.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/target/#/PointingToDeclaration/"></a> [jvm] open override val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Target array to access   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/value/#/PointingToDeclaration/"></a> [jvm] open override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Value   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/valueToStore/#/PointingToDeclaration/"></a>[valueToStore](value-to-store.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/valueToStore/#/PointingToDeclaration/"></a> [jvm] val [valueToStore](value-to-store.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Value to store   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayStore/valueType/#/PointingToDeclaration/"></a>[valueType](value-type.md)| <a name="com.github.jonathanxd.kores.base/ArrayStore/valueType/#/PointingToDeclaration/"></a> [jvm] val [valueType](value-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Type of value to store   <br>

