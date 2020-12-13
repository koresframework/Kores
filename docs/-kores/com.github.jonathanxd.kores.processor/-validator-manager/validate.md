//[Kores](../../index.md)/[com.github.jonathanxd.kores.processor](../index.md)/[ValidatorManager](index.md)/[validate](validate.md)



# validate  
[jvm]  
Content  
open fun [validate](validate.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), data: TypedData, environment: [ValidationEnvironment](../-validation-environment/index.md)? = null): [ValidationEnvironment](../-validation-environment/index.md)  
More info  


Validates part and return environment used to validate.

  


[jvm]  
Content  
abstract fun <[P](validate.md)> [validate](validate.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [P](validate.md)>, part: [P](validate.md), data: TypedData, environment: [ValidationEnvironment](../-validation-environment/index.md)? = null): [ValidationEnvironment](../-validation-environment/index.md)  
More info  


Validates part of type type and return environment used to validate.

  



