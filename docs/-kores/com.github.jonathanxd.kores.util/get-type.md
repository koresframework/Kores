//[Kores](../index.md)/[com.github.jonathanxd.kores.util](index.md)/[getType](get-type.md)



# getType  
[jvm]  
Content  
fun [getType](get-type.md)(typeVariables: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>, variable: [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>, generic: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)): [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)?  
More info  


Resolves the [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md) of variable of typeVariables using types provided by generic.

  


[jvm]  
Content  
fun [getType](get-type.md)(typeVariables: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>, variable: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), generic: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)): [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)?  
More info  


Resolves the [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md) of variable with name variable of typeVariables using types provided by generic.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util//getType/#kotlin.Array[java.lang.reflect.TypeVariable[*]]#kotlin.String#com.github.jonathanxd.kores.type.GenericType/PointingToDeclaration/"></a>typeVariables| <a name="com.github.jonathanxd.kores.util//getType/#kotlin.Array[java.lang.reflect.TypeVariable[*]]#kotlin.String#com.github.jonathanxd.kores.type.GenericType/PointingToDeclaration/"></a><br><br>Class Type variables<br><br>
| <a name="com.github.jonathanxd.kores.util//getType/#kotlin.Array[java.lang.reflect.TypeVariable[*]]#kotlin.String#com.github.jonathanxd.kores.type.GenericType/PointingToDeclaration/"></a>variable| <a name="com.github.jonathanxd.kores.util//getType/#kotlin.Array[java.lang.reflect.TypeVariable[*]]#kotlin.String#com.github.jonathanxd.kores.type.GenericType/PointingToDeclaration/"></a><br><br>Variable name to find type<br><br>
| <a name="com.github.jonathanxd.kores.util//getType/#kotlin.Array[java.lang.reflect.TypeVariable[*]]#kotlin.String#com.github.jonathanxd.kores.type.GenericType/PointingToDeclaration/"></a>generic| <a name="com.github.jonathanxd.kores.util//getType/#kotlin.Array[java.lang.reflect.TypeVariable[*]]#kotlin.String#com.github.jonathanxd.kores.type.GenericType/PointingToDeclaration/"></a><br><br>Generic type with types of typeVariables<br><br>
  
  



