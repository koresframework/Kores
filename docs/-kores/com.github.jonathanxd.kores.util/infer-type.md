//[Kores](../index.md)/[com.github.jonathanxd.kores.util](index.md)/[inferType](infer-type.md)



# inferType  
[jvm]  
Content  
@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()  
  
fun [inferType](infer-type.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), parameterizedType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), startingType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), koresTypeResolver: [KoresTypeResolver](../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>, genericResolver: [GenericResolver](-generic-resolver/index.md), filter: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = { true }): [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)  
More info  


Infer generic types. This function will use [getInferredType](get-inferred-type.md) to replace TypeVariables in type.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a>type| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a><br><br>Type which have unresolved variable types. Example: List<T><br><br>
| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a>parameterizedType| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a><br><br>Target class which have the type variables of type.<br><br>
| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a>startingType| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a><br><br>Initial type of class hierarchy (in other words, the type which extends parameterizedType explicitly or implicitly).<br><br>
| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a>koresTypeResolver| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a><br><br>Type resolver which will get superclass and superinterfaces.<br><br>
| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a>genericResolver| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a><br><br>Resolver which will resolve generic types from [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).<br><br>
| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a>filter| <a name="com.github.jonathanxd.kores.util//inferType/#java.lang.reflect.Type#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.GenericType#com.github.jonathanxd.kores.type.KoresTypeResolver[*]#com.github.jonathanxd.kores.util.GenericResolver#kotlin.Function1[kotlin.String,kotlin.Boolean]/PointingToDeclaration/"></a><br><br>Filter which determines type variables to be inferred. (True to infer, false to ignore).<br><br>
  
  


[jvm]  
Content  
fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[inferType](infer-type.md)(variables: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>, classVariables: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>, genericType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)): [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)  
More info  


Infers a type for receiver type variable.

  



