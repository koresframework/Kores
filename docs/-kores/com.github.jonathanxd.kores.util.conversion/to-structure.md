//[Kores](../index.md)/[com.github.jonathanxd.kores.util.conversion](index.md)/[toStructure](to-structure.md)



# toStructure  
[jvm]  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun <[T](to-structure.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](to-structure.md)>.[toStructure](to-structure.md)(includeFields: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, includeMethods: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, includeSubClasses: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../com.github.jonathanxd.kores.base/-type-declaration/index.md)>  
More info  


Convert this [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html) structure to [TypeDeclaration](../com.github.jonathanxd.kores.base/-type-declaration/index.md)s (first element is the input class, other elements is inner-classes).



#### Return  


[TypeDeclaration](../com.github.jonathanxd.kores.base/-type-declaration/index.md) structure from [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util.conversion//toStructure/java.lang.Class[TypeParam(bounds=[kotlin.Any])]#kotlin.Boolean#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a>includeFields| <a name="com.github.jonathanxd.kores.util.conversion//toStructure/java.lang.Class[TypeParam(bounds=[kotlin.Any])]#kotlin.Boolean#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a><br><br>True to include fields.<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toStructure/java.lang.Class[TypeParam(bounds=[kotlin.Any])]#kotlin.Boolean#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a>includeMethods| <a name="com.github.jonathanxd.kores.util.conversion//toStructure/java.lang.Class[TypeParam(bounds=[kotlin.Any])]#kotlin.Boolean#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a><br><br>True to include methods.<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toStructure/java.lang.Class[TypeParam(bounds=[kotlin.Any])]#kotlin.Boolean#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a>includeSubClasses| <a name="com.github.jonathanxd.kores.util.conversion//toStructure/java.lang.Class[TypeParam(bounds=[kotlin.Any])]#kotlin.Boolean#kotlin.Boolean#kotlin.Boolean/PointingToDeclaration/"></a><br><br>True to include sub classes.<br><br>
  
  



