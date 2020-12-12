//[Kores](../index.md)/[com.github.jonathanxd.kores.util.conversion](index.md)/[toMethodDeclaration](to-method-declaration.md)



# toMethodDeclaration  
[jvm]  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html).[toMethodDeclaration](to-method-declaration.md)(nameProvider: (index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), parameter: [Parameter](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Parameter.html)) -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { i, _ -> this.parameterNames[i] }): [MethodDeclaration](../com.github.jonathanxd.kores.base/-method-declaration/index.md)  
More info  


Convert this [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html) to [MethodDeclaration](../com.github.jonathanxd.kores.base/-method-declaration/index.md).



#### Return  


[MethodDeclaration](../com.github.jonathanxd.kores.base/-method-declaration/index.md).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util.conversion//toMethodDeclaration/java.lang.reflect.Method#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a>nameProvider| <a name="com.github.jonathanxd.kores.util.conversion//toMethodDeclaration/java.lang.reflect.Method#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a><br><br>Provider of parameter names.<br><br>
  
  


[jvm]  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html).[toMethodDeclaration](to-method-declaration.md)(superClass: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), nameProvider: (index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), parameter: [Parameter](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Parameter.html)) -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { i, _ -> this.parameterNames[i] }): [MethodDeclaration](../com.github.jonathanxd.kores.base/-method-declaration/index.md)  
More info  


Convert this [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html) structure to [MethodDeclaration](../com.github.jonathanxd.kores.base/-method-declaration/index.md) structure invoking the super class method.



#### Return  


[MethodDeclaration](../com.github.jonathanxd.kores.base/-method-declaration/index.md) structure from [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html) invoking super class method.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util.conversion//toMethodDeclaration/java.lang.reflect.Method#java.lang.reflect.Type#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a>superClass| <a name="com.github.jonathanxd.kores.util.conversion//toMethodDeclaration/java.lang.reflect.Method#java.lang.reflect.Type#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a><br><br>super class to invoke<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toMethodDeclaration/java.lang.reflect.Method#java.lang.reflect.Type#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a>nameProvider| <a name="com.github.jonathanxd.kores.util.conversion//toMethodDeclaration/java.lang.reflect.Method#java.lang.reflect.Type#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a><br><br>Provider of parameter names.<br><br>
  
  



