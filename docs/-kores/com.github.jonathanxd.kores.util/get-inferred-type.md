//[Kores](../index.md)/[com.github.jonathanxd.kores.util](index.md)/[getInferredType](get-inferred-type.md)



# getInferredType  
[jvm]  
Content  
fun [getInferredType](get-inferred-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), parameterizedType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), startingType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), koresTypeResolver: [KoresTypeResolver](../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>, genericResolver: [GenericResolver](-generic-resolver/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)>  
More info  


See [getInferredType](get-inferred-type.md) below.

  


[jvm]  
Content  
fun [getInferredType](get-inferred-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), parameterizedType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), startingType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), koresTypeResolver: [KoresTypeResolver](../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>, genericResolver: [GenericResolver](-generic-resolver/index.md), found: [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)>): [State](-state/index.md)  
More info  


This function tries to find name in all possible types which inherits parameterizedType, this function uses a defined genericResolver to resolve the [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md) representation of a [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a>name| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a><br><br>Type variable name.<br><br>
| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a>parameterizedType| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a><br><br>Target class which have the type variable name.<br><br>
| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a>startingType| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a><br><br>Initial type of class hierarchy (in other words, the type which extends parameterizedType explicitly or implicitly).<br><br>
| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a>koresTypeResolver| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a><br><br>Resolver of super types. This resolver will be used also to resolve original types.<br><br>
| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a>genericResolver| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a><br><br>Resolver which will resolve generic types from [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).<br><br>
| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a>found| <a name="com.github.jonathanxd.kores.util//getInferredType/#kotlin.String#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.collections.MutableList[com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a><br><br>List which types should be added<br><br>
  
  



