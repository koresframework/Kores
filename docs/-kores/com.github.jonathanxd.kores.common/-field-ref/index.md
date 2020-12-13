//[Kores](../../index.md)/[com.github.jonathanxd.kores.common](../index.md)/[FieldRef](index.md)



# FieldRef  
 [jvm] data class [FieldRef](index.md)(**localization**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **target**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [FieldBase](../../com.github.jonathanxd.kores.base/-field-base/index.md)

Field reference

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.common/FieldRef/FieldRef/#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>[FieldRef](-field-ref.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/FieldRef/#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a> [jvm] fun [FieldRef](-field-ref.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.common/FieldRef.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.common/FieldRef.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [FieldBase.Builder](../../com.github.jonathanxd.kores.base/-field-base/-builder/index.md)<[FieldRef](index.md), [FieldRef.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/FieldBase/access/#/PointingToDeclaration/"></a>[access](../../com.github.jonathanxd.kores.base/-field-base/access.md)| <a name="com.github.jonathanxd.kores.base/FieldBase/access/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [access](../../com.github.jonathanxd.kores.base/-field-base/access.md)(): [FieldAccess](../../com.github.jonathanxd.kores.base/-field-access/index.md)  <br>More info  <br>Creates access to the field that this instance represents.  <br><br><br>
| <a name="com.github.jonathanxd.kores.common/FieldRef/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [FieldRef.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.common/FieldRef/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.common/FieldRef/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.common/FieldRef/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.common/FieldRef/component4/#/PointingToDeclaration/"></a>[component4](component4.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/component4/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component4](component4.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.common/FieldRef/copy/#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/copy/#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldRef](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/FieldBase/set/#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[set](../../com.github.jonathanxd.kores.base/-field-base/set.md)| <a name="com.github.jonathanxd.kores.base/FieldBase/set/#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [set](../../com.github.jonathanxd.kores.base/-field-base/set.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [FieldDefinition](../../com.github.jonathanxd.kores.base/-field-definition/index.md)  <br>More info  <br>Creates a definition of the value of the field that this instance represents.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.common/FieldRef/localization/#/PointingToDeclaration/"></a>[localization](localization.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/localization/#/PointingToDeclaration/"></a> [jvm] open override val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Field localization.   <br>
| <a name="com.github.jonathanxd.kores.common/FieldRef/name/#/PointingToDeclaration/"></a>[name](name.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/name/#/PointingToDeclaration/"></a> [jvm] open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)Name   <br>
| <a name="com.github.jonathanxd.kores.common/FieldRef/target/#/PointingToDeclaration/"></a>[target](target.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/target/#/PointingToDeclaration/"></a> [jvm] open override val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Target of the access   <br>
| <a name="com.github.jonathanxd.kores.common/FieldRef/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.common/FieldRef/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>

