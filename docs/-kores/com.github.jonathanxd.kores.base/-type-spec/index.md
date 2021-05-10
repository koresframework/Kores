//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[TypeSpec](index.md)



# TypeSpec  
 [jvm] data class [TypeSpec](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()constructor(**returnType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **parameterTypes**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>) : [Typed](../-typed/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[TypeSpec](index.md)> 

Type Signature representation.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TypeSpec/TypeSpec/#java.lang.reflect.Type#kotlin.collections.List[java.lang.reflect.Type]/PointingToDeclaration/"></a>[TypeSpec](-type-spec.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/TypeSpec/#java.lang.reflect.Type#kotlin.collections.List[java.lang.reflect.Type]/PointingToDeclaration/"></a> [jvm] @[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  <br>  <br>fun [TypeSpec](-type-spec.md)(returnType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), parameterTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> = emptyList())   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TypeSpec.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Typed.Builder](../-typed/-builder/index.md)<[TypeSpec](index.md), [TypeSpec.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TypeSpec/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [TypeSpec.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TypeSpec/compareTo/#com.github.jonathanxd.kores.base.TypeSpec/PointingToDeclaration/"></a>[compareTo](compare-to.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/compareTo/#com.github.jonathanxd.kores.base.TypeSpec/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [compareTo](compare-to.md)(other: [TypeSpec](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TypeSpec/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TypeSpec/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TypeSpec/copy/#java.lang.reflect.Type#kotlin.collections.List[java.lang.reflect.Type]/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/copy/#java.lang.reflect.Type#kotlin.collections.List[java.lang.reflect.Type]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(returnType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), parameterTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> = emptyList()): [TypeSpec](index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TypeSpec/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](equals.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TypeSpec/hashCode/#/PointingToDeclaration/"></a>[hashCode](hash-code.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TypeSpec/isConreteEq/#com.github.jonathanxd.kores.base.TypeSpec/PointingToDeclaration/"></a>[isConreteEq](is-conrete-eq.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/isConreteEq/#com.github.jonathanxd.kores.base.TypeSpec/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [isConreteEq](is-conrete-eq.md)(other: [TypeSpec](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if concrete types of this spec is same as concrete types of other spec.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/TypeSpec/toTypeString/#/PointingToDeclaration/"></a>[toTypeString](to-type-string.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/toTypeString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [toTypeString](to-type-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br>More info  <br>Human readable type specification string.  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/TypeSpec/parameterTypes/#/PointingToDeclaration/"></a>[parameterTypes](parameter-types.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/parameterTypes/#/PointingToDeclaration/"></a> [jvm] val [parameterTypes](parameter-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>Type of parameters   <br>
| <a name="com.github.jonathanxd.kores.base/TypeSpec/returnType/#/PointingToDeclaration/"></a>[returnType](return-type.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/returnType/#/PointingToDeclaration/"></a> [jvm] val [returnType](return-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Type of the return.   <br>
| <a name="com.github.jonathanxd.kores.base/TypeSpec/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/TypeSpec/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base//typeDesc/com.github.jonathanxd.kores.base.TypeSpec#/PointingToDeclaration/"></a>[typeDesc](../type-desc.md)| <a name="com.github.jonathanxd.kores.base//typeDesc/com.github.jonathanxd.kores.base.TypeSpec#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>val [TypeSpec](index.md).[typeDesc](../type-desc.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br>More info  <br>Convert [TypeSpec](index.md) string description  <br><br><br>

