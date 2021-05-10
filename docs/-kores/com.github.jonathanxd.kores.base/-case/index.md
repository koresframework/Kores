//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Case](index.md)



# Case  
 [jvm] data class [Case](index.md)(**value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [ValueHolder](../-value-holder/index.md), [Typed](../-typed/index.md), [BodyHolder](../-body-holder/index.md)

Case statement of [SwitchStatement](../-switch-statement/index.md).

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Case/Case/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[Case](-case.md)| <a name="com.github.jonathanxd.kores.base/Case/Case/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a> [jvm] fun [Case](-case.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Case.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/Case.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [ValueHolder.Builder](../-value-holder/-builder/index.md)<[Case](index.md), [Case.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[Case](index.md), [Case.Builder](-builder/index.md)> , [BodyHolder.Builder](../-body-holder/-builder/index.md)<[Case](index.md), [Case.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Case/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/Case/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [Case.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Case/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/Case/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Case/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/Case/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Case/copy/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/Case/copy/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.Instructions/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)): [Case](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Case/body/#/PointingToDeclaration/"></a>[body](body.md)| <a name="com.github.jonathanxd.kores.base/Case/body/#/PointingToDeclaration/"></a> [jvm] open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)Body of case statement.   <br>
| <a name="com.github.jonathanxd.kores.base/Case/isDefault/#/PointingToDeclaration/"></a>[isDefault](is-default.md)| <a name="com.github.jonathanxd.kores.base/Case/isDefault/#/PointingToDeclaration/"></a> [jvm] val [isDefault](is-default.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Is case default   <br>
| <a name="com.github.jonathanxd.kores.base/Case/isNotDefault/#/PointingToDeclaration/"></a>[isNotDefault](is-not-default.md)| <a name="com.github.jonathanxd.kores.base/Case/isNotDefault/#/PointingToDeclaration/"></a> [jvm] val [isNotDefault](is-not-default.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Is not case default   <br>
| <a name="com.github.jonathanxd.kores.base/Case/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/Case/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>
| <a name="com.github.jonathanxd.kores.base/Case/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="com.github.jonathanxd.kores.base/Case/value/#/PointingToDeclaration/"></a> [jvm] open override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Value to check if operating element matches, null for default case.   <br>

