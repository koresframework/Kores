//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](../index.md)/[GenericResolver](index.md)



# GenericResolver  
 [jvm] interface [GenericResolver](index.md)   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.util/GenericResolver/resolveGenericTypeImplementation/#java.lang.reflect.Type#java.lang.reflect.Type#com.github.jonathanxd.kores.type.KoresTypeResolver[*]/PointingToDeclaration/"></a>[resolveGenericTypeImplementation](resolve-generic-type-implementation.md)| <a name="com.github.jonathanxd.kores.util/GenericResolver/resolveGenericTypeImplementation/#java.lang.reflect.Type#java.lang.reflect.Type#com.github.jonathanxd.kores.type.KoresTypeResolver[*]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [resolveGenericTypeImplementation](resolve-generic-type-implementation.md)(superType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), implemented: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>): [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)  <br>More info  <br>Resolves [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md) of implemented type, which was implemented in superType.  <br><br><br>
| <a name="com.github.jonathanxd.kores.util/GenericResolver/resolveTypeWithParameters/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.KoresTypeResolver[*]/PointingToDeclaration/"></a>[resolveTypeWithParameters](resolve-type-with-parameters.md)| <a name="com.github.jonathanxd.kores.util/GenericResolver/resolveTypeWithParameters/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.KoresTypeResolver[*]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [resolveTypeWithParameters](resolve-type-with-parameters.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>): [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)  <br>More info  <br>Resolves the [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md) of type.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.type/ModelResolver///PointingToDeclaration/"></a>[ModelResolver](../../com.github.jonathanxd.kores.type/-model-resolver/index.md)
| <a name="com.github.jonathanxd.kores.util/JavaResolver///PointingToDeclaration/"></a>[JavaResolver](../-java-resolver/index.md)
| <a name="com.github.jonathanxd.kores.util/KoresResolver///PointingToDeclaration/"></a>[KoresResolver](../-kores-resolver/index.md)
| <a name="com.github.jonathanxd.kores.util/MixedResolver///PointingToDeclaration/"></a>[MixedResolver](../-mixed-resolver/index.md)

