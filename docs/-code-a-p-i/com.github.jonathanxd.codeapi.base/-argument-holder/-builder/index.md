[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ArgumentHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ArgumentHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [withArguments](with-arguments.md) | `abstract fun withArguments(value: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): S`<br>`open fun withArguments(vararg values: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): S`<br>See [T.arguments](../arguments.md) |
| [withArray](with-array.md) | `abstract fun withArray(value: Boolean): S`<br>See [T.array](../array.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-enum-entry/-builder/index.md) | `class Builder : Builder<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, `[`Builder`](../../-elements-holder/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>` |
| [Builder](../../-method-invocation/-builder/index.md) | `class Builder : `[`Builder`](../../-accessor/-builder/index.md)`<`[`MethodInvocation`](../../-method-invocation/index.md)`, `[`Builder`](../../-method-invocation/-builder/index.md)`>, Builder<`[`MethodInvocation`](../../-method-invocation/index.md)`, `[`Builder`](../../-method-invocation/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`MethodInvocation`](../../-method-invocation/index.md)`, `[`Builder`](../../-method-invocation/-builder/index.md)`>` |
| [Builder](../../-array-constructor/-builder/index.md) | `class Builder : Builder<`[`ArrayConstructor`](../../-array-constructor/index.md)`, `[`Builder`](../../-array-constructor/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`ArrayConstructor`](../../-array-constructor/index.md)`, `[`Builder`](../../-array-constructor/-builder/index.md)`>` |
| [Builder](../../-anonymous-class/-builder/index.md) | `class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, Builder<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>` |
