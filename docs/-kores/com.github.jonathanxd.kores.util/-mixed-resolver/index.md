//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](../index.md)/[MixedResolver](index.md)



# MixedResolver  
 [jvm] class [MixedResolver](index.md)(**elements**: [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)?) : [GenericResolver](../-generic-resolver/index.md)

Mixes [JavaResolver](../-java-resolver/index.md) with [ModelResolver](../../com.github.jonathanxd.kores.type/-model-resolver/index.md) and [KoresResolver](../-kores-resolver/index.md) in one resolver.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util/MixedResolver/MixedResolver/#javax.lang.model.util.Elements?/PointingToDeclaration/"></a>[MixedResolver](-mixed-resolver.md)| <a name="com.github.jonathanxd.kores.util/MixedResolver/MixedResolver/#javax.lang.model.util.Elements?/PointingToDeclaration/"></a> [jvm] fun [MixedResolver](-mixed-resolver.md)(elements: [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)?)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.util/MixedResolver/resolveGenericTypeImplementation/#java.lang.reflect.Type#java.lang.reflect.Type#com.github.jonathanxd.kores.type.KoresTypeResolver[*]/PointingToDeclaration/"></a>[resolveGenericTypeImplementation](resolve-generic-type-implementation.md)| <a name="com.github.jonathanxd.kores.util/MixedResolver/resolveGenericTypeImplementation/#java.lang.reflect.Type#java.lang.reflect.Type#com.github.jonathanxd.kores.type.KoresTypeResolver[*]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [resolveGenericTypeImplementation](resolve-generic-type-implementation.md)(superType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), implemented: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>): [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)  <br>More info  <br>Resolves [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md) of implemented type, which was implemented in superType.  <br><br><br>
| <a name="com.github.jonathanxd.kores.util/MixedResolver/resolveTypeWithParameters/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.KoresTypeResolver[*]/PointingToDeclaration/"></a>[resolveTypeWithParameters](resolve-type-with-parameters.md)| <a name="com.github.jonathanxd.kores.util/MixedResolver/resolveTypeWithParameters/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.KoresTypeResolver[*]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [resolveTypeWithParameters](resolve-type-with-parameters.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>): [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)  <br>More info  <br>Resolves the [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md) of type.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util/MixedResolver/elements/#/PointingToDeclaration/"></a>[elements](elements.md)| <a name="com.github.jonathanxd.kores.util/MixedResolver/elements/#/PointingToDeclaration/"></a> [jvm] val [elements](elements.md): [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)?   <br>

