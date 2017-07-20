[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ArrayAccess](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ArrayAccess`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | `abstract fun arrayType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.arrayType](array-type.md) |
| [target](target.md) | `abstract fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.target](target.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-array-load/-builder/index.md) | `class Builder : Builder<`[`ArrayLoad`](../../-array-load/index.md)`, `[`Builder`](../../-array-load/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`ArrayLoad`](../../-array-load/index.md)`, `[`Builder`](../../-array-load/-builder/index.md)`>` |
| [Builder](../../-array-store/-builder/index.md) | `class Builder : Builder<`[`ArrayStore`](../../-array-store/index.md)`, `[`Builder`](../../-array-store/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`ArrayStore`](../../-array-store/index.md)`, `[`Builder`](../../-array-store/-builder/index.md)`>` |
| [Builder](../../-array-length/-builder/index.md) | `class Builder : Builder<`[`ArrayLength`](../../-array-length/index.md)`, `[`Builder`](../../-array-length/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`ArrayLength`](../../-array-length/index.md)`, `[`Builder`](../../-array-length/-builder/index.md)`>` |
