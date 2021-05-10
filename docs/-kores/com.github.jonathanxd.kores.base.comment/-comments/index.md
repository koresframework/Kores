//[Kores](../../index.md)/[com.github.jonathanxd.kores.base.comment](../index.md)/[Comments](index.md)



# Comments  
 [jvm] data class [Comments](index.md)(**comments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](../-comment/index.md)>, **type**: [Comments.Type](-type/index.md)) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Hold a list of comments.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base.comment/Comments/Comments/#kotlin.collections.List[com.github.jonathanxd.kores.base.comment.Comment]#com.github.jonathanxd.kores.base.comment.Comments.Type/PointingToDeclaration/"></a>[Comments](-comments.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments/Comments/#kotlin.collections.List[com.github.jonathanxd.kores.base.comment.Comment]#com.github.jonathanxd.kores.base.comment.Comments.Type/PointingToDeclaration/"></a> [jvm] fun [Comments](-comments.md)(comments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](../-comment/index.md)>, type: [Comments.Type](-type/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base.comment/Comments.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[Comments](index.md), [Comments.Builder](-builder/index.md)>   <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Comments.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments.Companion///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Comments.Type///PointingToDeclaration/"></a>[Type](-type/index.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments.Type///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>enum [Type](-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[Comments.Type](-type/index.md)>   <br>More info  <br>Comment type  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base.comment/Comments/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [Comments.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Comments/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](../-comment/index.md)>  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Comments/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Comments.Type](-type/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Comments/copy/#kotlin.collections.List[com.github.jonathanxd.kores.base.comment.Comment]#com.github.jonathanxd.kores.base.comment.Comments.Type/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments/copy/#kotlin.collections.List[com.github.jonathanxd.kores.base.comment.Comment]#com.github.jonathanxd.kores.base.comment.Comments.Type/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(comments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](../-comment/index.md)>, type: [Comments.Type](-type/index.md)): [Comments](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Comments/isAbsent/#/PointingToDeclaration/"></a>[isAbsent](is-absent.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments/isAbsent/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [isAbsent](is-absent.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if this [Comments](index.md) instance is [Absent](-companion/-absent.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Comments/isNotAbsent/#/PointingToDeclaration/"></a>[isNotAbsent](is-not-absent.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments/isNotAbsent/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [isNotAbsent](is-not-absent.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if this [Comments](index.md) instance is not [Absent](-companion/-absent.md).  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base.comment/Comments/comments/#/PointingToDeclaration/"></a>[comments](comments.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments/comments/#/PointingToDeclaration/"></a> [jvm] val [comments](comments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](../-comment/index.md)>Comment list   <br>
| <a name="com.github.jonathanxd.kores.base.comment/Comments/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments/type/#/PointingToDeclaration/"></a> [jvm] val [type](type.md): [Comments.Type](-type/index.md)Type of comments entry.   <br>

