//[Kores](../../index.md)/[com.github.jonathanxd.kores.builder](../index.md)/[Builder](index.md)



# Builder  
 [jvm] interface [Builder](index.md)<out [T](index.md), [S](index.md) : [Builder](index.md)<[T](index.md), [S](index.md)>>

Builder pattern.

   


## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.builder/Builder///PointingToDeclaration/"></a>T| <a name="com.github.jonathanxd.kores.builder/Builder///PointingToDeclaration/"></a><br><br>Type of element to build.<br><br>
  


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.builder/Builder/build/#/PointingToDeclaration/"></a>[build](build.md)| <a name="com.github.jonathanxd.kores.builder/Builder/build/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [build](build.md)(): [T](index.md)  <br>More info  <br>Build the object of type [T](index.md).  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores/KoresPart.SelfBuilder///PointingToDeclaration/"></a>[KoresPart](../../com.github.jonathanxd.kores/-kores-part/-self-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/Accessor.Builder///PointingToDeclaration/"></a>[Accessor](../../com.github.jonathanxd.kores.base/-accessor/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/Annotable.Builder///PointingToDeclaration/"></a>[Annotable](../../com.github.jonathanxd.kores.base/-annotable/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ArgumentsHolder.Builder///PointingToDeclaration/"></a>[ArgumentsHolder](../../com.github.jonathanxd.kores.base/-arguments-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ArrayAccess.Builder///PointingToDeclaration/"></a>[ArrayAccess](../../com.github.jonathanxd.kores.base/-array-access/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/BodyHolder.Builder///PointingToDeclaration/"></a>[BodyHolder](../../com.github.jonathanxd.kores.base/-body-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ConstructorsHolder.Builder///PointingToDeclaration/"></a>[ConstructorsHolder](../../com.github.jonathanxd.kores.base/-constructors-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ControlFlow.Builder///PointingToDeclaration/"></a>[ControlFlow](../../com.github.jonathanxd.kores.base/-control-flow/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/EntryHolder.Builder///PointingToDeclaration/"></a>[EntryHolder](../../com.github.jonathanxd.kores.base/-entry-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/GenericSignatureHolder.Builder///PointingToDeclaration/"></a>[GenericSignatureHolder](../../com.github.jonathanxd.kores.base/-generic-signature-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/IfExpr.Builder///PointingToDeclaration/"></a>[IfExpr](../../com.github.jonathanxd.kores.base/-if-expr/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/IfExpressionHolder.Builder///PointingToDeclaration/"></a>[IfExpressionHolder](../../com.github.jonathanxd.kores.base/-if-expression-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ImplementationHolder.Builder///PointingToDeclaration/"></a>[ImplementationHolder](../../com.github.jonathanxd.kores.base/-implementation-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/InnerTypesHolder.Builder///PointingToDeclaration/"></a>[InnerTypesHolder](../../com.github.jonathanxd.kores.base/-inner-types-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/LocalCode.Builder///PointingToDeclaration/"></a>[LocalCode](../../com.github.jonathanxd.kores.base/-local-code/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ModifiersHolder.Builder///PointingToDeclaration/"></a>[ModifiersHolder](../../com.github.jonathanxd.kores.base/-modifiers-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/Named.Builder///PointingToDeclaration/"></a>[Named](../../com.github.jonathanxd.kores.base/-named/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/New.Builder///PointingToDeclaration/"></a>[New](../../com.github.jonathanxd.kores.base/-new/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ParametersHolder.Builder///PointingToDeclaration/"></a>[ParametersHolder](../../com.github.jonathanxd.kores.base/-parameters-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ReturnTypeHolder.Builder///PointingToDeclaration/"></a>[ReturnTypeHolder](../../com.github.jonathanxd.kores.base/-return-type-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/SuperClassHolder.Builder///PointingToDeclaration/"></a>[SuperClassHolder](../../com.github.jonathanxd.kores.base/-super-class-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ThrowsHolder.Builder///PointingToDeclaration/"></a>[ThrowsHolder](../../com.github.jonathanxd.kores.base/-throws-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/Typed.Builder///PointingToDeclaration/"></a>[Typed](../../com.github.jonathanxd.kores.base/-typed/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base/ValueHolder.Builder///PointingToDeclaration/"></a>[ValueHolder](../../com.github.jonathanxd.kores.base/-value-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base.comment/Code.Builder///PointingToDeclaration/"></a>[Code](../../com.github.jonathanxd.kores.base.comment/-code/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base.comment/CommentHolder.Builder///PointingToDeclaration/"></a>[CommentHolder](../../com.github.jonathanxd.kores.base.comment/-comment-holder/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base.comment/Comments.Builder///PointingToDeclaration/"></a>[Comments](../../com.github.jonathanxd.kores.base.comment/-comments/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base.comment/Link.Builder///PointingToDeclaration/"></a>[Link](../../com.github.jonathanxd.kores.base.comment/-link/-builder/index.md)
| <a name="com.github.jonathanxd.kores.base.comment/Plain.Builder///PointingToDeclaration/"></a>[Plain](../../com.github.jonathanxd.kores.base.comment/-plain/-builder/index.md)
| <a name="com.github.jonathanxd.kores.type/AnnotatedKoresType.Builder///PointingToDeclaration/"></a>[AnnotatedKoresType](../../com.github.jonathanxd.kores.type/-annotated-kores-type/-builder/index.md)
| <a name="com.github.jonathanxd.kores.type/GenericType.Builder///PointingToDeclaration/"></a>[GenericType](../../com.github.jonathanxd.kores.type/-generic-type/-builder/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.builder//self/com.github.jonathanxd.kores.builder.Builder[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[com.github.jonathanxd.kores.builder.Builder[TypeParam(bounds=[kotlin.Any?]),^]])]#/PointingToDeclaration/"></a>[self](../self.md)| <a name="com.github.jonathanxd.kores.builder//self/com.github.jonathanxd.kores.builder.Builder[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[com.github.jonathanxd.kores.builder.Builder[TypeParam(bounds=[kotlin.Any?]),^]])]#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>inline fun <[T](../self.md), [S](../self.md) : [Builder](index.md)<[T](../self.md), [S](../self.md)>> [Builder](index.md)<[T](../self.md), [S](../self.md)>.[self](../self.md)(): [S](../self.md)  <br>More info  <br>Cast from [Builder](index.md) of [T](../self.md) of implicit type [S](../self.md).  <br><br><br>

