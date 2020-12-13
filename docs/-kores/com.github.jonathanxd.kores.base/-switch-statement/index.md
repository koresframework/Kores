//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[SwitchStatement](index.md)



# SwitchStatement  
 [jvm] data class [SwitchStatement](index.md)(**value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **switchType**: [SwitchType](../-switch-type/index.md), **cases**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Case](../-case/index.md)>) : [ValueHolder](../-value-holder/index.md), [Typed](../-typed/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Switch statement, this switch can switch numeric values and object values (like Enum, String or other objects).



You could switch objects, but make sure that the object implements [Any.hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591) and [Any.equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591) methods.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/SwitchStatement/SwitchStatement/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.SwitchType#kotlin.collections.List[com.github.jonathanxd.kores.base.Case]/PointingToDeclaration/"></a>[SwitchStatement](-switch-statement.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement/SwitchStatement/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.SwitchType#kotlin.collections.List[com.github.jonathanxd.kores.base.Case]/PointingToDeclaration/"></a> [jvm] fun [SwitchStatement](-switch-statement.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), switchType: [SwitchType](../-switch-type/index.md), cases: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Case](../-case/index.md)>)   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/SwitchStatement.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [ValueHolder.Builder](../-value-holder/-builder/index.md)<[SwitchStatement](index.md), [SwitchStatement.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[SwitchStatement](index.md), [SwitchStatement.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/SwitchStatement/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [SwitchStatement.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/SwitchStatement/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/SwitchStatement/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [SwitchType](../-switch-type/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/SwitchStatement/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Case](../-case/index.md)>  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/SwitchStatement/copy/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.SwitchType#kotlin.collections.List[com.github.jonathanxd.kores.base.Case]/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement/copy/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.SwitchType#kotlin.collections.List[com.github.jonathanxd.kores.base.Case]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), switchType: [SwitchType](../-switch-type/index.md), cases: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Case](../-case/index.md)>): [SwitchStatement](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/SwitchStatement/cases/#/PointingToDeclaration/"></a>[cases](cases.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement/cases/#/PointingToDeclaration/"></a> [jvm] val [cases](cases.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Case](../-case/index.md)>Cases statements.   <br>
| <a name="com.github.jonathanxd.kores.base/SwitchStatement/switchType/#/PointingToDeclaration/"></a>[switchType](switch-type.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement/switchType/#/PointingToDeclaration/"></a> [jvm] val [switchType](switch-type.md): [SwitchType](../-switch-type/index.md)Type of the switch   <br>
| <a name="com.github.jonathanxd.kores.base/SwitchStatement/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>
| <a name="com.github.jonathanxd.kores.base/SwitchStatement/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="com.github.jonathanxd.kores.base/SwitchStatement/value/#/PointingToDeclaration/"></a> [jvm] open override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Value to switch   <br>

