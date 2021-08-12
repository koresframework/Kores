//[Kores](../../../index.md)/[com.github.jonathanxd.kores.processor](../index.md)/[ValidatorManager](index.md)/[validate](validate.md)

# validate

[jvm]\
open fun [validate](validate.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), data: TypedData, environment: [ValidationEnvironment](../-validation-environment/index.md)? = null): [ValidationEnvironment](../-validation-environment/index.md)

Validates [part](validate.md) and return environment used to validate.

[jvm]\
abstract fun <[P](validate.md)> [validate](validate.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [P](validate.md)>, part: [P](validate.md), data: TypedData, environment: [ValidationEnvironment](../-validation-environment/index.md)? = null): [ValidationEnvironment](../-validation-environment/index.md)

Validates [part](validate.md) of type [type](validate.md) and return environment used to validate.
