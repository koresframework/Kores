//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Typed](index.md)



# Typed  
 [jvm] interface [Typed](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

A element that can have a type.

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Typed.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/Typed.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [Typed](index.md), [S](-builder/index.md) : [Typed.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Typed/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/Typed/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [Typed.Builder](-builder/index.md)<[Typed](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Typed/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/Typed/type/#/PointingToDeclaration/"></a> [jvm] abstract val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Element type   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/Annotation///PointingToDeclaration/"></a>[Annotation](../-annotation/index.md)
| <a name="com.github.jonathanxd.kores.base/AnnotationProperty///PointingToDeclaration/"></a>[AnnotationProperty](../-annotation-property/index.md)
| <a name="com.github.jonathanxd.kores.base/ArrayConstructor///PointingToDeclaration/"></a>[ArrayConstructor](../-array-constructor/index.md)
| <a name="com.github.jonathanxd.kores.base/ArrayLength///PointingToDeclaration/"></a>[ArrayLength](../-array-length/index.md)
| <a name="com.github.jonathanxd.kores.base/ArrayLoad///PointingToDeclaration/"></a>[ArrayLoad](../-array-load/index.md)
| <a name="com.github.jonathanxd.kores.base/Case///PointingToDeclaration/"></a>[Case](../-case/index.md)
| <a name="com.github.jonathanxd.kores.base/Cast///PointingToDeclaration/"></a>[Cast](../-cast/index.md)
| <a name="com.github.jonathanxd.kores.base/CatchStatement///PointingToDeclaration/"></a>[CatchStatement](../-catch-statement/index.md)
| <a name="com.github.jonathanxd.kores.base/Concat///PointingToDeclaration/"></a>[Concat](../-concat/index.md)
| <a name="com.github.jonathanxd.kores.base/EnumValue///PointingToDeclaration/"></a>[EnumValue](../-enum-value/index.md)
| <a name="com.github.jonathanxd.kores.base/FieldAccess///PointingToDeclaration/"></a>[FieldAccess](../-field-access/index.md)
| <a name="com.github.jonathanxd.kores.base/FieldBase///PointingToDeclaration/"></a>[FieldBase](../-field-base/index.md)
| <a name="com.github.jonathanxd.kores.base/FieldDeclaration///PointingToDeclaration/"></a>[FieldDeclaration](../-field-declaration/index.md)
| <a name="com.github.jonathanxd.kores.base/InstanceOfCheck///PointingToDeclaration/"></a>[InstanceOfCheck](../-instance-of-check/index.md)
| <a name="com.github.jonathanxd.kores.base/InvokeDynamicBase///PointingToDeclaration/"></a>[InvokeDynamicBase](../-invoke-dynamic-base/index.md)
| <a name="com.github.jonathanxd.kores.base/KoresParameter///PointingToDeclaration/"></a>[KoresParameter](../-kores-parameter/index.md)
| <a name="com.github.jonathanxd.kores.base/Line.TypedLine///PointingToDeclaration/"></a>[Line](../-line/-typed-line/index.md)
| <a name="com.github.jonathanxd.kores.base/MethodDeclarationBase///PointingToDeclaration/"></a>[MethodDeclarationBase](../-method-declaration-base/index.md)
| <a name="com.github.jonathanxd.kores.base/MethodInvocation///PointingToDeclaration/"></a>[MethodInvocation](../-method-invocation/index.md)
| <a name="com.github.jonathanxd.kores.base/Operate///PointingToDeclaration/"></a>[Operate](../-operate/index.md)
| <a name="com.github.jonathanxd.kores.base/Return///PointingToDeclaration/"></a>[Return](../-return/index.md)
| <a name="com.github.jonathanxd.kores.base/SwitchStatement///PointingToDeclaration/"></a>[SwitchStatement](../-switch-statement/index.md)
| <a name="com.github.jonathanxd.kores.base/TypeSpec///PointingToDeclaration/"></a>[TypeSpec](../-type-spec/index.md)
| <a name="com.github.jonathanxd.kores.base/VariableBase///PointingToDeclaration/"></a>[VariableBase](../-variable-base/index.md)
| <a name="com.github.jonathanxd.kores.base/VariableDeclaration///PointingToDeclaration/"></a>[VariableDeclaration](../-variable-declaration/index.md)
| <a name="com.github.jonathanxd.kores.base/VariableDefinition///PointingToDeclaration/"></a>[VariableDefinition](../-variable-definition/index.md)
| <a name="com.github.jonathanxd.kores.common/DynamicMethodSpec///PointingToDeclaration/"></a>[DynamicMethodSpec](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)
| <a name="com.github.jonathanxd.kores.common/MethodInvokeSpec///PointingToDeclaration/"></a>[MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)
| <a name="com.github.jonathanxd.kores.common/MethodSpec///PointingToDeclaration/"></a>[MethodSpec](../../com.github.jonathanxd.kores.common/-method-spec/index.md)
| <a name="com.github.jonathanxd.kores.common/MethodTypeSpec///PointingToDeclaration/"></a>[MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)
| <a name="com.github.jonathanxd.kores.common/Nothing///PointingToDeclaration/"></a>[Nothing](../../com.github.jonathanxd.kores.common/-nothing/index.md)
| <a name="com.github.jonathanxd.kores.common/Void///PointingToDeclaration/"></a>[Void](../../com.github.jonathanxd.kores.common/-void/index.md)
| <a name="com.github.jonathanxd.kores.literal/Literal///PointingToDeclaration/"></a>[Literal](../../com.github.jonathanxd.kores.literal/-literal/index.md)

