//[Kores](../index.md)/[com.github.jonathanxd.kores.util.conversion](index.md)/[isAccessibleFrom](is-accessible-from.md)



# isAccessibleFrom  
[jvm]  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html).[isAccessibleFrom](is-accessible-from.md)(typeDeclaration: [TypeDeclaration](../com.github.jonathanxd.kores.base/-type-declaration/index.md), override: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Returns true if receiver [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html) is accessible from typeDeclaration or accessible to be overwritten from typeDeclaration.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util.conversion//isAccessibleFrom/java.lang.reflect.Method#com.github.jonathanxd.kores.base.TypeDeclaration#kotlin.Boolean/PointingToDeclaration/"></a>override| <a name="com.github.jonathanxd.kores.util.conversion//isAccessibleFrom/java.lang.reflect.Method#com.github.jonathanxd.kores.base.TypeDeclaration#kotlin.Boolean/PointingToDeclaration/"></a><br><br>True to check if method is accessible to be overwritten by typeDeclaration method.<br><br>
  
  



