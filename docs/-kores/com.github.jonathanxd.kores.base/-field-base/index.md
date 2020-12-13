//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[FieldBase](index.md)



# FieldBase  
 [jvm] interface [FieldBase](index.md) : [Named](../-named/index.md), [Typed](../-typed/index.md)

Base field (access and definition common class)

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/FieldBase.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/FieldBase.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [FieldBase](index.md), [S](-builder/index.md) : [FieldBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Named.Builder](../-named/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/FieldBase/access/#/PointingToDeclaration/"></a>[access](access.md)| <a name="com.github.jonathanxd.kores.base/FieldBase/access/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [access](access.md)(): [FieldAccess](../-field-access/index.md)  <br>More info  <br>Creates access to the field that this instance represents.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/FieldBase/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/FieldBase/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [FieldBase.Builder](-builder/index.md)<[FieldBase](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/FieldBase/set/#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[set](set.md)| <a name="com.github.jonathanxd.kores.base/FieldBase/set/#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [set](set.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [FieldDefinition](../-field-definition/index.md)  <br>More info  <br>Creates a definition of the value of the field that this instance represents.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/FieldBase/localization/#/PointingToDeclaration/"></a>[localization](localization.md)| <a name="com.github.jonathanxd.kores.base/FieldBase/localization/#/PointingToDeclaration/"></a> [jvm] abstract val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Field localization.   <br>
| <a name="com.github.jonathanxd.kores.base/FieldBase/name/#/PointingToDeclaration/"></a>[name](index.md#%5Bcom.github.jonathanxd.kores.base%2FFieldBase%2Fname%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-427383591)| <a name="com.github.jonathanxd.kores.base/FieldBase/name/#/PointingToDeclaration/"></a> [jvm] abstract val [name](index.md#%5Bcom.github.jonathanxd.kores.base%2FFieldBase%2Fname%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-427383591): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)Name   <br>
| <a name="com.github.jonathanxd.kores.base/FieldBase/target/#/PointingToDeclaration/"></a>[target](target.md)| <a name="com.github.jonathanxd.kores.base/FieldBase/target/#/PointingToDeclaration/"></a> [jvm] abstract val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Target of the access   <br>
| <a name="com.github.jonathanxd.kores.base/FieldBase/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/FieldBase/type/#/PointingToDeclaration/"></a> [jvm] abstract override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/FieldDeclaration///PointingToDeclaration/"></a>[FieldDeclaration](../-field-declaration/index.md)
| <a name="com.github.jonathanxd.kores.base/FieldDefinition///PointingToDeclaration/"></a>[FieldDefinition](../-field-definition/index.md)
| <a name="com.github.jonathanxd.kores.common/FieldRef///PointingToDeclaration/"></a>[FieldRef](../../com.github.jonathanxd.kores.common/-field-ref/index.md)

