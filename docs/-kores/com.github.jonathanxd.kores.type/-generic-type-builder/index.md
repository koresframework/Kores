//[Kores](../../index.md)/[com.github.jonathanxd.kores.type](../index.md)/[GenericTypeBuilder](index.md)



# GenericTypeBuilder  
 [jvm] class [GenericTypeBuilder](index.md) : [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)> 

Builder of a [GenericType](../-generic-type/index.md).



Examples:



List of String: GenericTypeBuilder().withType(List::class.codeType).addOfBound(String::class.codeType).build()



T extends List of wildcard extends CharSequence: <T: List<out CharSequence>> or <T extends List<? extends CharSequence>>

GenericTypeBuilder().withName("T").withExtendsBound(  
  GenericTypeBuilder().withType(List::class.codeType).withExtendsBound(  
    GenericTypeBuilder().wildcard().withExtendsBound(CharSequence::class.codeType).build()  
  ).build()  
)

You may also prefer the [Generic](../-generic/index.md) style:

Generic.type("T").extends_(  
  Generic.type(List::class.codeType).extends_(  
    Generic.wildcard().extends_(CharSequence::class.codeType)  
  )  
)

**Attention: All calls of the methods of** [**Generic**](../-generic/index.md) **class creates a copy of the** **bound** **array (except the first call), if you mind performance use the** [**GenericTypeBuilder**](index.md)

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/GenericTypeBuilder/#com.github.jonathanxd.kores.type.GenericType/PointingToDeclaration/"></a>[GenericTypeBuilder](-generic-type-builder.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/GenericTypeBuilder/#com.github.jonathanxd.kores.type.GenericType/PointingToDeclaration/"></a> [jvm] fun [GenericTypeBuilder](-generic-type-builder.md)(defaults: [GenericType](../-generic-type/index.md))   <br>
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/GenericTypeBuilder/#/PointingToDeclaration/"></a>[GenericTypeBuilder](-generic-type-builder.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/GenericTypeBuilder/#/PointingToDeclaration/"></a> [jvm] fun [GenericTypeBuilder](-generic-type-builder.md)()   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder.Companion///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/addBound/#com.github.jonathanxd.kores.type.GenericType.Bound/PointingToDeclaration/"></a>[addBound](add-bound.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/addBound/#com.github.jonathanxd.kores.type.GenericType.Bound/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [addBound](add-bound.md)(bound: [GenericType.Bound](../-generic-type/-bound/index.md)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>More info  <br>Adds a bound.  <br><br><br>
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/addBounds/#kotlin.Array[com.github.jonathanxd.kores.type.GenericType.Bound]/PointingToDeclaration/"></a>[addBounds](add-bounds.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/addBounds/#kotlin.Array[com.github.jonathanxd.kores.type.GenericType.Bound]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [addBounds](add-bounds.md)(bounds: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[GenericType.Bound](../-generic-type/-bound/index.md)>): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>More info  <br>Adds all bounds of [bounds](bounds.md) array.  <br><br><br>[jvm]  <br>Content  <br>open override fun [addBounds](add-bounds.md)(bounds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[GenericType.Bound](../-generic-type/-bound/index.md)>): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>More info  <br>Adds all bounds of [bounds](bounds.md) collection.  <br><br><br>
| <a name="com.github.jonathanxd.kores.type/GenericType.Builder/addExtendsBound/#kotlin.String/PointingToDeclaration/"></a>[addExtendsBound](../-generic-type/-builder/add-extends-bound.md)| <a name="com.github.jonathanxd.kores.type/GenericType.Builder/addExtendsBound/#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [addExtendsBound](../-generic-type/-builder/add-extends-bound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>open override fun [addExtendsBound](add-extends-bound.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>More info  <br>Adds a extends bound.  <br><br><br>
| <a name="com.github.jonathanxd.kores.type/GenericType.Builder/addOfBound/#kotlin.String/PointingToDeclaration/"></a>[addOfBound](../-generic-type/-builder/add-of-bound.md)| <a name="com.github.jonathanxd.kores.type/GenericType.Builder/addOfBound/#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [addOfBound](../-generic-type/-builder/add-of-bound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>open override fun [addOfBound](add-of-bound.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>More info  <br>Adds a of bound.  <br><br><br>
| <a name="com.github.jonathanxd.kores.type/GenericType.Builder/addSuperBound/#kotlin.String/PointingToDeclaration/"></a>[addSuperBound](../-generic-type/-builder/add-super-bound.md)| <a name="com.github.jonathanxd.kores.type/GenericType.Builder/addSuperBound/#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [addSuperBound](../-generic-type/-builder/add-super-bound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>open override fun [addSuperBound](add-super-bound.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>More info  <br>Adds a super bound.  <br><br><br>
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/bounds/#kotlin.Array[com.github.jonathanxd.kores.type.GenericType.Bound]/PointingToDeclaration/"></a>[bounds](bounds.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/bounds/#kotlin.Array[com.github.jonathanxd.kores.type.GenericType.Bound]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [bounds](bounds.md)(value: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[GenericType.Bound](../-generic-type/-bound/index.md)>): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>More info  <br>See T.  <br><br><br>
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/build/#/PointingToDeclaration/"></a>[build](build.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/build/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [build](build.md)(): [GenericType](../-generic-type/index.md)  <br>More info  <br>Build the object of type T.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/name/#kotlin.String/PointingToDeclaration/"></a>[name](name.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/name/#kotlin.String/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>More info  <br>See T.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/type/#java.lang.reflect.Type/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/type/#java.lang.reflect.Type/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>More info  <br>See T.  <br><br><br>
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/wildcard/#/PointingToDeclaration/"></a>[wildcard](wildcard.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/wildcard/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [wildcard](wildcard.md)(): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)>  <br>More info  <br>See T.  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/bounds/#/PointingToDeclaration/"></a>[bounds](bounds.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/bounds/#/PointingToDeclaration/"></a> [jvm] var [bounds](bounds.md): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[GenericType.Bound](../-generic-type/-bound/index.md)>   <br>
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/name/#/PointingToDeclaration/"></a>[name](name.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/name/#/PointingToDeclaration/"></a> [jvm] var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null   <br>
| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.type/GenericTypeBuilder/type/#/PointingToDeclaration/"></a> [jvm] var [type](type.md): [KoresType](../-kores-type/index.md)? = null   <br>

