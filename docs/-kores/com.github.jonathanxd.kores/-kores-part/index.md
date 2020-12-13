//[Kores](../../index.md)/[com.github.jonathanxd.kores](../index.md)/[KoresPart](index.md)



# KoresPart  
 [jvm] interface [KoresPart](index.md)

A KoresPart is the heart of Kores, all elements that can appear in the code must extend KoresPart.



All interfaces that have a concrete implementation and extends [KoresPart](index.md) must provide a builder method that return a builder instance with defined default values.

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores/KoresPart.SelfBuilder///PointingToDeclaration/"></a>[SelfBuilder](-self-builder/index.md)| <a name="com.github.jonathanxd.kores/KoresPart.SelfBuilder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [SelfBuilder](-self-builder/index.md)(**self**: [KoresPart](index.md)) : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](index.md), [KoresPart.SelfBuilder](-self-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores/KoresPart/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores/KoresPart/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [builder](builder.md)(): [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](index.md), *>  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores/Instruction///PointingToDeclaration/"></a>[Instruction](../-instruction/index.md)
| <a name="com.github.jonathanxd.kores/Instructions///PointingToDeclaration/"></a>[Instructions](../-instructions/index.md)
| <a name="com.github.jonathanxd.kores/KoresElement///PointingToDeclaration/"></a>[KoresElement](../-kores-element/index.md)
| <a name="com.github.jonathanxd.kores.base/Annotable///PointingToDeclaration/"></a>[Annotable](../../com.github.jonathanxd.kores.base/-annotable/index.md)
| <a name="com.github.jonathanxd.kores.base/ArgumentsHolder///PointingToDeclaration/"></a>[ArgumentsHolder](../../com.github.jonathanxd.kores.base/-arguments-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/ArrayAccess///PointingToDeclaration/"></a>[ArrayAccess](../../com.github.jonathanxd.kores.base/-array-access/index.md)
| <a name="com.github.jonathanxd.kores.base/BodyHolder///PointingToDeclaration/"></a>[BodyHolder](../../com.github.jonathanxd.kores.base/-body-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/Concat///PointingToDeclaration/"></a>[Concat](../../com.github.jonathanxd.kores.base/-concat/index.md)
| <a name="com.github.jonathanxd.kores.base/ConstructorsHolder///PointingToDeclaration/"></a>[ConstructorsHolder](../../com.github.jonathanxd.kores.base/-constructors-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/ControlFlow///PointingToDeclaration/"></a>[ControlFlow](../../com.github.jonathanxd.kores.base/-control-flow/index.md)
| <a name="com.github.jonathanxd.kores.base/EntryHolder///PointingToDeclaration/"></a>[EntryHolder](../../com.github.jonathanxd.kores.base/-entry-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/GenericSignatureHolder///PointingToDeclaration/"></a>[GenericSignatureHolder](../../com.github.jonathanxd.kores.base/-generic-signature-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/IfExpr///PointingToDeclaration/"></a>[IfExpr](../../com.github.jonathanxd.kores.base/-if-expr/index.md)
| <a name="com.github.jonathanxd.kores.base/IfExpressionHolder///PointingToDeclaration/"></a>[IfExpressionHolder](../../com.github.jonathanxd.kores.base/-if-expression-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/IfGroup///PointingToDeclaration/"></a>[IfGroup](../../com.github.jonathanxd.kores.base/-if-group/index.md)
| <a name="com.github.jonathanxd.kores.base/ImplementationHolder///PointingToDeclaration/"></a>[ImplementationHolder](../../com.github.jonathanxd.kores.base/-implementation-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/InnerTypesHolder///PointingToDeclaration/"></a>[InnerTypesHolder](../../com.github.jonathanxd.kores.base/-inner-types-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/KoresModifier///PointingToDeclaration/"></a>[KoresModifier](../../com.github.jonathanxd.kores.base/-kores-modifier/index.md)
| <a name="com.github.jonathanxd.kores.base/LocalCode///PointingToDeclaration/"></a>[LocalCode](../../com.github.jonathanxd.kores.base/-local-code/index.md)
| <a name="com.github.jonathanxd.kores.base/ModifiersHolder///PointingToDeclaration/"></a>[ModifiersHolder](../../com.github.jonathanxd.kores.base/-modifiers-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/Named///PointingToDeclaration/"></a>[Named](../../com.github.jonathanxd.kores.base/-named/index.md)
| <a name="com.github.jonathanxd.kores.base/New///PointingToDeclaration/"></a>[New](../../com.github.jonathanxd.kores.base/-new/index.md)
| <a name="com.github.jonathanxd.kores.base/ParametersHolder///PointingToDeclaration/"></a>[ParametersHolder](../../com.github.jonathanxd.kores.base/-parameters-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/ReturnTypeHolder///PointingToDeclaration/"></a>[ReturnTypeHolder](../../com.github.jonathanxd.kores.base/-return-type-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/SuperClassHolder///PointingToDeclaration/"></a>[SuperClassHolder](../../com.github.jonathanxd.kores.base/-super-class-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/ThrowsHolder///PointingToDeclaration/"></a>[ThrowsHolder](../../com.github.jonathanxd.kores.base/-throws-holder/index.md)
| <a name="com.github.jonathanxd.kores.base/Typed///PointingToDeclaration/"></a>[Typed](../../com.github.jonathanxd.kores.base/-typed/index.md)
| <a name="com.github.jonathanxd.kores.base/ValueHolder///PointingToDeclaration/"></a>[ValueHolder](../../com.github.jonathanxd.kores.base/-value-holder/index.md)
| <a name="com.github.jonathanxd.kores.base.comment/Comment///PointingToDeclaration/"></a>[Comment](../../com.github.jonathanxd.kores.base.comment/-comment/index.md)
| <a name="com.github.jonathanxd.kores.base.comment/CommentHolder///PointingToDeclaration/"></a>[CommentHolder](../../com.github.jonathanxd.kores.base.comment/-comment-holder/index.md)
| <a name="com.github.jonathanxd.kores.base.comment/Comments///PointingToDeclaration/"></a>[Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md)
| <a name="com.github.jonathanxd.kores.type/KoresType///PointingToDeclaration/"></a>[KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores//isPrimitive/com.github.jonathanxd.kores.KoresPart#/PointingToDeclaration/"></a>[isPrimitive](../is-primitive.md)| <a name="com.github.jonathanxd.kores//isPrimitive/com.github.jonathanxd.kores.KoresPart#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>val [KoresPart](index.md).[isPrimitive](../is-primitive.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if the type of this [KoresPart](index.md) is primitive  <br><br><br>
| <a name="com.github.jonathanxd.kores//type/com.github.jonathanxd.kores.KoresPart#/PointingToDeclaration/"></a>[type](../type.md)| <a name="com.github.jonathanxd.kores//type/com.github.jonathanxd.kores.KoresPart#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>val [KoresPart](index.md).[type](../type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)  <br>More info  <br>Gets the type of [KoresPart](index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores//typeOrNull/com.github.jonathanxd.kores.KoresPart#/PointingToDeclaration/"></a>[typeOrNull](../type-or-null.md)| <a name="com.github.jonathanxd.kores//typeOrNull/com.github.jonathanxd.kores.KoresPart#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>val [KoresPart](index.md).[typeOrNull](../type-or-null.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?  <br>More info  <br>Gets the type of [KoresPart](index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.kores.base/-typed/index.md) instance.  <br><br><br>

