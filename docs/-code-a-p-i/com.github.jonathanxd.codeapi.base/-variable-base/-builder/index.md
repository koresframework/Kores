[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [VariableBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`VariableBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [withType](with-type.md) | `open fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](../type.md) |
| [withVariableType](with-variable-type.md) | `abstract fun withVariableType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.variableType](../variable-type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withName](../../-named/-builder/with-name.md) | `abstract fun withName(value: String): S` |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-variable-access/-builder/index.md) | `class Builder : Builder<`[`VariableAccess`](../../-variable-access/index.md)`, `[`Builder`](../../-variable-access/-builder/index.md)`>` |
| [Builder](../../-variable-declaration/-builder/index.md) | `class Builder : Builder<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>` |
| [Builder](../../../com.github.jonathanxd.codeapi.common/-variable-ref/-builder/index.md) | `class Builder : Builder<`[`VariableRef`](../../../com.github.jonathanxd.codeapi.common/-variable-ref/index.md)`, `[`Builder`](../../../com.github.jonathanxd.codeapi.common/-variable-ref/-builder/index.md)`>` |
