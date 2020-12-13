//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Annotation](index.md)



# Annotation  
 [jvm] data class [Annotation](index.md)(**type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **values**: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>, **retention**: [Retention](../-retention/index.md)) : [Typed](../-typed/index.md)

An annotation, an annotation is composed by a pair of property name and property value.



#  In Java  


[type](type.md) is the annotation type and [values](values.md) are the pairs that denote annotation properties and their respective values.



Example:



Annotation(Override, emptyMap(), false) is equal to @OverrideAnnotation(Named, mapOf("value" to "Wow"), true) is equal to @Named("Wow")Annotation(Wow, mapOf("a" to 9, "b" to 7), true) is equal to @Wow(a = 9, b = 7)



The [retention](retention.md) is determined by the compiler, which inspects [type](type.md) and reads [Retention](../-retention/index.md) annotation, but here it need to be explicitly specified (you can also use [Retention.resolveRetention](../-retention/-companion/resolve-retention.md) to try to resolve the retention of [type](type.md)).

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Annotation/Annotation/#java.lang.reflect.Type#kotlin.collections.Map[kotlin.String,kotlin.Any]#com.github.jonathanxd.kores.base.Retention/PointingToDeclaration/"></a>[Annotation](-annotation.md)| <a name="com.github.jonathanxd.kores.base/Annotation/Annotation/#java.lang.reflect.Type#kotlin.collections.Map[kotlin.String,kotlin.Any]#com.github.jonathanxd.kores.base.Retention/PointingToDeclaration/"></a> [jvm] fun [Annotation](-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), values: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>, retention: [Retention](../-retention/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Annotation.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/Annotation.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Typed.Builder](../-typed/-builder/index.md)<[Annotation](index.md), [Annotation.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Annotation/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/Annotation/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [Annotation.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Annotation/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/Annotation/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Annotation/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/Annotation/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Annotation/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/Annotation/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Retention](../-retention/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Annotation/copy/#java.lang.reflect.Type#kotlin.collections.Map[kotlin.String,kotlin.Any]#com.github.jonathanxd.kores.base.Retention/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/Annotation/copy/#java.lang.reflect.Type#kotlin.collections.Map[kotlin.String,kotlin.Any]#com.github.jonathanxd.kores.base.Retention/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), values: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>, retention: [Retention](../-retention/index.md)): [Annotation](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Annotation/retention/#/PointingToDeclaration/"></a>[retention](retention.md)| <a name="com.github.jonathanxd.kores.base/Annotation/retention/#/PointingToDeclaration/"></a> [jvm] val [retention](retention.md): [Retention](../-retention/index.md)Annotation retention, this property must match the same retention of annotation [type](type.md).   <br>
| <a name="com.github.jonathanxd.kores.base/Annotation/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/Annotation/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Type of annotation.   <br>
| <a name="com.github.jonathanxd.kores.base/Annotation/values/#/PointingToDeclaration/"></a>[values](values.md)| <a name="com.github.jonathanxd.kores.base/Annotation/values/#/PointingToDeclaration/"></a> [jvm] val [values](values.md): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>Map of annotation values (key is the property of annotation), the Annotation value must be: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html), [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), [EnumValue](../-enum-value/index.md), other [Annotation](index.md) or a List of one of types cited above (with or without elements).   <br>

