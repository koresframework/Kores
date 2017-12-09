[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [ValidatorManager](index.md) / [validate](.)

# validate

`open fun validate(part: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, data: TypedData, environment: `[`ValidationEnvironment`](../-validation-environment/index.md)`? = null): `[`ValidationEnvironment`](../-validation-environment/index.md)

Validates [part](validate.md#com.github.jonathanxd.codeapi.processor.ValidatorManager$validate(kotlin.Any, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/part) and return environment used to validate.

`abstract fun <P> validate(type: Class<out P>, part: P, data: TypedData, environment: `[`ValidationEnvironment`](../-validation-environment/index.md)`? = null): `[`ValidationEnvironment`](../-validation-environment/index.md)

Validates [part](validate.md#com.github.jonathanxd.codeapi.processor.ValidatorManager$validate(java.lang.Class((com.github.jonathanxd.codeapi.processor.ValidatorManager.validate.P)), com.github.jonathanxd.codeapi.processor.ValidatorManager.validate.P, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/part) of type [type](validate.md#com.github.jonathanxd.codeapi.processor.ValidatorManager$validate(java.lang.Class((com.github.jonathanxd.codeapi.processor.ValidatorManager.validate.P)), com.github.jonathanxd.codeapi.processor.ValidatorManager.validate.P, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/type) and return environment used to validate.

