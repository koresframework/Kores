//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ArrayConstructor](index.md)



# ArrayConstructor  
 [jvm] data class [ArrayConstructor](index.md)(**arrayType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **dimensions**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>) : [ArgumentsHolder](../-arguments-holder/index.md), [TypedInstruction](../-typed-instruction/index.md)

Constructs an array of type [arrayType](array-type.md) with dimensions [dimensions](dimensions.md). Example:



new ArrayConstructor(String[].class, listOf(Literals.INT(5)), emptyList()) = new String[5]new ArrayConstructor(String[].class, listOf(Literals.INT(5), Literals.INT(9)), emptyList()) = new String[5][9]

new ArrayConstructor(  
    String[].class,  
    listOf(Literals.INT(3)),  
    listOf(Literals.STRING("A"), Literals.STRING("B"), Literals.STRING("C"))  
) = new String[] {"A", "B", "C"}   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/ArrayConstructor/#java.lang.reflect.Type#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>[ArrayConstructor](-array-constructor.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/ArrayConstructor/#java.lang.reflect.Type#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a> [jvm] fun [ArrayConstructor](-array-constructor.md)(arrayType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), dimensions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>)   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [ArgumentsHolder.Builder](../-arguments-holder/-builder/index.md)<[ArrayConstructor](index.md), [ArrayConstructor.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[ArrayConstructor](index.md), [ArrayConstructor.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [ArrayConstructor.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/copy/#java.lang.reflect.Type#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/copy/#java.lang.reflect.Type#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(arrayType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), dimensions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>): [ArrayConstructor](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/arguments/#/PointingToDeclaration/"></a>[arguments](arguments.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/arguments/#/PointingToDeclaration/"></a> [jvm] open override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>Argument list   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/array/#/PointingToDeclaration/"></a>[array](array.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/array/#/PointingToDeclaration/"></a> [jvm] open override val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Array arguments   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/arrayType/#/PointingToDeclaration/"></a>[arrayType](array-type.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/arrayType/#/PointingToDeclaration/"></a> [jvm] val [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/arrayValues/#/PointingToDeclaration/"></a>[arrayValues](array-values.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/arrayValues/#/PointingToDeclaration/"></a> [jvm] val [arrayValues](array-values.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ArrayStore](../-array-store/index.md)>Array values   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/dimensions/#/PointingToDeclaration/"></a>[dimensions](dimensions.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/dimensions/#/PointingToDeclaration/"></a> [jvm] val [dimensions](dimensions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/types/#/PointingToDeclaration/"></a>[types](types.md)| <a name="com.github.jonathanxd.kores.base/ArrayConstructor/types/#/PointingToDeclaration/"></a> [jvm] open override val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>Expected types of each argument   <br>

