//[Kores](../index.md)/[com.github.jonathanxd.kores.util.conversion](index.md)/[toConstructorDeclaration](to-constructor-declaration.md)



# toConstructorDeclaration  
[jvm]  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun <[T](to-constructor-declaration.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html)<[T](to-constructor-declaration.md)>.[toConstructorDeclaration](to-constructor-declaration.md)(nameProvider: (index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), parameter: [Parameter](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Parameter.html)) -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { i, _ -> this.parameterNames[i] }): [ConstructorDeclaration](../com.github.jonathanxd.kores.base/-constructor-declaration/index.md)  
More info  


Convert this [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html) to [MethodDeclaration](../com.github.jonathanxd.kores.base/-method-declaration/index.md).



#### Return  


[MethodDeclaration](../com.github.jonathanxd.kores.base/-method-declaration/index.md).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util.conversion//toConstructorDeclaration/java.lang.reflect.Constructor[TypeParam(bounds=[kotlin.Any])]#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a>nameProvider| <a name="com.github.jonathanxd.kores.util.conversion//toConstructorDeclaration/java.lang.reflect.Constructor[TypeParam(bounds=[kotlin.Any])]#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a><br><br>Provider of parameter names.<br><br>
  
  


[jvm]  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun <[T](to-constructor-declaration.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html)<[T](to-constructor-declaration.md)>.[toConstructorDeclaration](to-constructor-declaration.md)(arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>, nameProvider: (index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), parameter: [Parameter](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Parameter.html)) -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { i, _ -> this.parameterNames[i] }): [ConstructorDeclaration](../com.github.jonathanxd.kores.base/-constructor-declaration/index.md)  
More info  


Convert this [Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html) structure to [ConstructorDeclaration](../com.github.jonathanxd.kores.base/-constructor-declaration/index.md) structure calling super constructor with arguments.



#### Return  


[ConstructorDeclaration](../com.github.jonathanxd.kores.base/-constructor-declaration/index.md) structure from [Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html) calling super constructor with arguments.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util.conversion//toConstructorDeclaration/java.lang.reflect.Constructor[TypeParam(bounds=[kotlin.Any])]#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a>arguments| <a name="com.github.jonathanxd.kores.util.conversion//toConstructorDeclaration/java.lang.reflect.Constructor[TypeParam(bounds=[kotlin.Any])]#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a><br><br>Arguments to pass to super constructor.<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toConstructorDeclaration/java.lang.reflect.Constructor[TypeParam(bounds=[kotlin.Any])]#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a>nameProvider| <a name="com.github.jonathanxd.kores.util.conversion//toConstructorDeclaration/java.lang.reflect.Constructor[TypeParam(bounds=[kotlin.Any])]#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#kotlin.Function2[kotlin.Int,java.lang.reflect.Parameter,kotlin.String]/PointingToDeclaration/"></a><br><br>Provider of parameter names.<br><br>
  
  



