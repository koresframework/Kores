//[Kores](../../index.md)/[com.github.jonathanxd.kores.base.comment](../index.md)/[Link](index.md)



# Link  
 [jvm] data class [Link](index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **target**: [Link.LinkTarget](-link-target/index.md)) : [Comment](../-comment/index.md)

Link comment: comment linking to an element or a url

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base.comment/Link/Link/#kotlin.String?#com.github.jonathanxd.kores.base.comment.Link.LinkTarget/PointingToDeclaration/"></a>[Link](-link.md)| <a name="com.github.jonathanxd.kores.base.comment/Link/Link/#kotlin.String?#com.github.jonathanxd.kores.base.comment.Link.LinkTarget/PointingToDeclaration/"></a> [jvm] fun [Link](-link.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, target: [Link.LinkTarget](-link-target/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base.comment/Link.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base.comment/Link.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[Link](index.md), [Link.Builder](-builder/index.md)>   <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Link.LinkTarget///PointingToDeclaration/"></a>[LinkTarget](-link-target/index.md)| <a name="com.github.jonathanxd.kores.base.comment/Link.LinkTarget///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [LinkTarget](-link-target/index.md)  <br>More info  <br>Target of the link  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base.comment/Link/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base.comment/Link/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [Link.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Link/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base.comment/Link/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Link/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base.comment/Link/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Link.LinkTarget](-link-target/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Link/copy/#kotlin.String?#com.github.jonathanxd.kores.base.comment.Link.LinkTarget/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base.comment/Link/copy/#kotlin.String?#com.github.jonathanxd.kores.base.comment.Link.LinkTarget/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, target: [Link.LinkTarget](-link-target/index.md)): [Link](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base.comment/Link/name/#/PointingToDeclaration/"></a>[name](name.md)| <a name="com.github.jonathanxd.kores.base.comment/Link/name/#/PointingToDeclaration/"></a> [jvm] val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?Title/name of link (null to default)   <br>
| <a name="com.github.jonathanxd.kores.base.comment/Link/target/#/PointingToDeclaration/"></a>[target](target.md)| <a name="com.github.jonathanxd.kores.base.comment/Link/target/#/PointingToDeclaration/"></a> [jvm] val [target](target.md): [Link.LinkTarget](-link-target/index.md)Link target.   <br>

