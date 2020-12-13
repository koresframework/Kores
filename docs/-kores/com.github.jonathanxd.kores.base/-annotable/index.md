//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Annotable](index.md)



# Annotable  
 [jvm] interface [Annotable](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

An part that can be annotated, like methods, fields, classes, type usage, etc...

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Annotable.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/Annotable.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [Annotable](index.md), [S](-builder/index.md) : [Annotable.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Annotable/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/Annotable/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract override fun [builder](builder.md)(): [Annotable.Builder](-builder/index.md)<[Annotable](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Annotable/getAnnotation/#java.lang.reflect.Type/PointingToDeclaration/"></a>[getAnnotation](get-annotation.md)| <a name="com.github.jonathanxd.kores.base/Annotable/getAnnotation/#java.lang.reflect.Type/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [getAnnotation](get-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?  <br>More info  <br>Gets the annotation of type type if present, or null otherwise.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Annotable/getDeclaredAnnotation/#java.lang.reflect.Type/PointingToDeclaration/"></a>[getDeclaredAnnotation](get-declared-annotation.md)| <a name="com.github.jonathanxd.kores.base/Annotable/getDeclaredAnnotation/#java.lang.reflect.Type/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [getDeclaredAnnotation](get-declared-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?  <br>More info  <br>Gets the annotation of type type if present, or null otherwise.  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/Annotable/isAnnotationPresent/#java.lang.reflect.Type/PointingToDeclaration/"></a>[isAnnotationPresent](is-annotation-present.md)| <a name="com.github.jonathanxd.kores.base/Annotable/isAnnotationPresent/#java.lang.reflect.Type/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [isAnnotationPresent](is-annotation-present.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns whether this[Annotable](index.md) contains an annotation of specified type.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/Annotable/annotations/#/PointingToDeclaration/"></a>[annotations](annotations.md)| <a name="com.github.jonathanxd.kores.base/Annotable/annotations/#/PointingToDeclaration/"></a> [jvm] abstract val [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>Annotations   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.base/AnnotationProperty///PointingToDeclaration/"></a>[AnnotationProperty](../-annotation-property/index.md)
| <a name="com.github.jonathanxd.kores.base/EnumEntry///PointingToDeclaration/"></a>[EnumEntry](../-enum-entry/index.md)
| <a name="com.github.jonathanxd.kores.base/FieldDeclaration///PointingToDeclaration/"></a>[FieldDeclaration](../-field-declaration/index.md)
| <a name="com.github.jonathanxd.kores.base/KoresParameter///PointingToDeclaration/"></a>[KoresParameter](../-kores-parameter/index.md)
| <a name="com.github.jonathanxd.kores.base/MethodDeclarationBase///PointingToDeclaration/"></a>[MethodDeclarationBase](../-method-declaration-base/index.md)
| <a name="com.github.jonathanxd.kores.base/TypeDeclaration///PointingToDeclaration/"></a>[TypeDeclaration](../-type-declaration/index.md)

