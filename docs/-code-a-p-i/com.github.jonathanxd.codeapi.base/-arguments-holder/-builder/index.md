[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ArgumentsHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ArgumentsHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `abstract fun arguments(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): S`<br>`open fun arguments(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.arguments](arguments.md) |
| [array](array.md) | `abstract fun array(value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): S`<br>See [T.array](array.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-anonymous-class/-builder/index.md) | `class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, Builder<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-constructors-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>` |
| [Builder](../../-array-constructor/-builder/index.md) | `class Builder : Builder<`[`ArrayConstructor`](../../-array-constructor/index.md)`, `[`Builder`](../../-array-constructor/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`ArrayConstructor`](../../-array-constructor/index.md)`, `[`Builder`](../../-array-constructor/-builder/index.md)`>` |
| [Builder](../../-enum-entry/-builder/index.md) | `class Builder : `[`Builder`](../../-annotable/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, Builder<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, `[`Builder`](../../-elements-holder/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>` |
| [Builder](../../-invoke-dynamic-base/-lambda-local-code-base/-builder/index.md) | `interface Builder<out T : `[`LambdaLocalCodeBase`](../../-invoke-dynamic-base/-lambda-local-code-base/index.md)`, S : `[`Builder`](../../-invoke-dynamic-base/-lambda-local-code-base/-builder/index.md)`<T, S>> : `[`Builder`](../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/index.md)`<T, S>, Builder<T, S>` |
| [Builder](../../-method-invocation/-builder/index.md) | `class Builder : `[`Builder`](../../-accessor/-builder/index.md)`<`[`MethodInvocation`](../../-method-invocation/index.md)`, `[`Builder`](../../-method-invocation/-builder/index.md)`>, Builder<`[`MethodInvocation`](../../-method-invocation/index.md)`, `[`Builder`](../../-method-invocation/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`MethodInvocation`](../../-method-invocation/index.md)`, `[`Builder`](../../-method-invocation/-builder/index.md)`>` |
