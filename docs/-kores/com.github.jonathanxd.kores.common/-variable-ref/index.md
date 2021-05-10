//[Kores](../../index.md)/[com.github.jonathanxd.kores.common](../index.md)/[VariableRef](index.md)



# VariableRef  
 [jvm] data class [VariableRef](index.md)(**variableType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [VariableBase](../../com.github.jonathanxd.kores.base/-variable-base/index.md)

Reference to a Variable.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.common/VariableRef/VariableRef/#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>[VariableRef](-variable-ref.md)| <a name="com.github.jonathanxd.kores.common/VariableRef/VariableRef/#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a> [jvm] fun [VariableRef](-variable-ref.md)(variableType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.common/VariableRef.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.common/VariableRef.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [VariableBase.Builder](../../com.github.jonathanxd.kores.base/-variable-base/-builder/index.md)<[VariableRef](index.md), [VariableRef.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/VariableBase/access/#/PointingToDeclaration/"></a>[access](../../com.github.jonathanxd.kores.base/-variable-base/access.md)| <a name="com.github.jonathanxd.kores.base/VariableBase/access/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [access](../../com.github.jonathanxd.kores.base/-variable-base/access.md)(): [VariableAccess](../../com.github.jonathanxd.kores.base/-variable-access/index.md)  <br>More info  <br>Creates access to the variable that this instance represents.  <br><br><br>
| <a name="com.github.jonathanxd.kores.common/VariableRef/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.common/VariableRef/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [VariableRef.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.common/VariableRef/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.common/VariableRef/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.common/VariableRef/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.common/VariableRef/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.common/VariableRef/copy/#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.common/VariableRef/copy/#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(variableType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [VariableRef](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/VariableBase/set/#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[set](../../com.github.jonathanxd.kores.base/-variable-base/set.md)| <a name="com.github.jonathanxd.kores.base/VariableBase/set/#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [set](../../com.github.jonathanxd.kores.base/-variable-base/set.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [VariableDefinition](../../com.github.jonathanxd.kores.base/-variable-definition/index.md)  <br>More info  <br>Creates a definition of the value of the variable that this instance represents.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.common/VariableRef/name/#/PointingToDeclaration/"></a>[name](name.md)| <a name="com.github.jonathanxd.kores.common/VariableRef/name/#/PointingToDeclaration/"></a> [jvm] open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)Variable name   <br>
| <a name="com.github.jonathanxd.kores.common/VariableRef/type/#/PointingToDeclaration/"></a>[type](index.md#%5Bcom.github.jonathanxd.kores.common%2FVariableRef%2Ftype%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1211764316)| <a name="com.github.jonathanxd.kores.common/VariableRef/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](index.md#%5Bcom.github.jonathanxd.kores.common%2FVariableRef%2Ftype%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1211764316): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>
| <a name="com.github.jonathanxd.kores.common/VariableRef/variableType/#/PointingToDeclaration/"></a>[variableType](variable-type.md)| <a name="com.github.jonathanxd.kores.common/VariableRef/variableType/#/PointingToDeclaration/"></a> [jvm] open override val [variableType](variable-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Variable type   <br>

