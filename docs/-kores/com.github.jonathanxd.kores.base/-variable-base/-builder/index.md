//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[VariableBase](../index.md)/[Builder](index.md)



# Builder  
 [jvm] interface [Builder](index.md)<out [T](index.md) : [VariableBase](../index.md), [S](index.md) : [VariableBase.Builder](index.md)<[T](index.md), [S](index.md)>> : [Named.Builder](../../-named/-builder/index.md)<[T](index.md), [S](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[T](index.md), [S](index.md)>    


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/VariableBase.Builder/base/#com.github.jonathanxd.kores.common.FieldRef/PointingToDeclaration/"></a>[base](base.md)| <a name="com.github.jonathanxd.kores.base/VariableBase.Builder/base/#com.github.jonathanxd.kores.common.FieldRef/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [base](base.md)(fieldRef: [FieldRef](../../../com.github.jonathanxd.kores.common/-field-ref/index.md)): [S](index.md)  <br>More info  <br>Base this builder on fieldRef (only name and [type](type.md)).  <br><br><br>[jvm]  <br>Content  <br>open fun [base](base.md)(variableRef: [VariableRef](../../../com.github.jonathanxd.kores.common/-variable-ref/index.md)): [S](index.md)  <br>More info  <br>Base this builder on variableRef.  <br><br><br>
| <a name="com.github.jonathanxd.kores.builder/Builder/build/#/PointingToDeclaration/"></a>[build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)| <a name="com.github.jonathanxd.kores.builder/Builder/build/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)  <br>More info  <br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md).  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Named.Builder/name/#kotlin.String/PointingToDeclaration/"></a>[name](../../-named/-builder/name.md)| <a name="com.github.jonathanxd.kores.base/Named.Builder/name/#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [name](../../-named/-builder/name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [S](index.md)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/VariableBase.Builder/type/#java.lang.reflect.Type/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/VariableBase.Builder/type/#java.lang.reflect.Type/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)  <br>More info  <br>See T.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/VariableBase.Builder/variableType/#java.lang.reflect.Type/PointingToDeclaration/"></a>[variableType](variable-type.md)| <a name="com.github.jonathanxd.kores.base/VariableBase.Builder/variableType/#java.lang.reflect.Type/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [variableType](variable-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)  <br>More info  <br>See [VariableBase.variableType](../variable-type.md)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/VariableAccess.Builder///PointingToDeclaration/"></a>[VariableAccess](../../-variable-access/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/VariableDeclaration.Builder///PointingToDeclaration/"></a>[VariableDeclaration](../../-variable-declaration/-builder/index.md)
| <a name="com.github.jonathanxd.kores.common/VariableRef.Builder///PointingToDeclaration/"></a>[VariableRef](../../../com.github.jonathanxd.kores.common/-variable-ref/-builder/index.md)

