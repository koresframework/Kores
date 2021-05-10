//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](../index.md)/[TypeResolver](index.md)



# TypeResolver  
 [jvm] @[FunctionalInterface](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html)()  
  
interface [TypeResolver](index.md)

Resolves a class name which may vary to a [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) and cache the resolved type.

   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.util/TypeResolver/resolve/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a>[resolve](resolve.md)| <a name="com.github.jonathanxd.kores.util/TypeResolver/resolve/#kotlin.String#kotlin.Boolean/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [resolve](resolve.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), isInterface: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br>More info  <br>Resolves type with name to a [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.util/SimpleResolver///PointingToDeclaration/"></a>[SimpleResolver](../-simple-resolver/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util//resolveClass/com.github.jonathanxd.kores.util.TypeResolver#kotlin.String/PointingToDeclaration/"></a>[resolveClass](../resolve-class.md)| <a name="com.github.jonathanxd.kores.util//resolveClass/com.github.jonathanxd.kores.util.TypeResolver#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [TypeResolver](index.md).[resolveClass](../resolve-class.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br>More info  <br>Resolve type as class.  <br><br><br>
| <a name="com.github.jonathanxd.kores.util//resolveInterface/com.github.jonathanxd.kores.util.TypeResolver#kotlin.String/PointingToDeclaration/"></a>[resolveInterface](../resolve-interface.md)| <a name="com.github.jonathanxd.kores.util//resolveInterface/com.github.jonathanxd.kores.util.TypeResolver#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [TypeResolver](index.md).[resolveInterface](../resolve-interface.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br>More info  <br>Resolve type as interface.  <br><br><br>
| <a name="com.github.jonathanxd.kores.util//resolveUnknown/com.github.jonathanxd.kores.util.TypeResolver#kotlin.String/PointingToDeclaration/"></a>[resolveUnknown](../resolve-unknown.md)| <a name="com.github.jonathanxd.kores.util//resolveUnknown/com.github.jonathanxd.kores.util.TypeResolver#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [TypeResolver](index.md).[resolveUnknown](../resolve-unknown.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br>More info  <br>Resolve type as unknown, same as [resolveClass](../resolve-class.md)  <br><br><br>

