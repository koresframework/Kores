[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [IfExpressionHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`IfExpressionHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [withExpressions](with-expressions.md) | `abstract fun withExpressions(value: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): S`<br>`open fun withExpressions(vararg values: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): S`<br>See [T.expressions](../expressions.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-while-statement/-builder/index.md) | `class Builder : Builder<`[`WhileStatement`](../../-while-statement/index.md)`, `[`Builder`](../../-while-statement/-builder/index.md)`>, `[`Builder`](../../-body-holder/-builder/index.md)`<`[`WhileStatement`](../../-while-statement/index.md)`, `[`Builder`](../../-while-statement/-builder/index.md)`>` |
| [Builder](../../-for-statement/-builder/index.md) | `class Builder : Builder<`[`ForStatement`](../../-for-statement/index.md)`, `[`Builder`](../../-for-statement/-builder/index.md)`>, `[`Builder`](../../-body-holder/-builder/index.md)`<`[`ForStatement`](../../-for-statement/index.md)`, `[`Builder`](../../-for-statement/-builder/index.md)`>` |
| [Builder](../../-if-group/-builder/index.md) | `class Builder : Builder<`[`IfGroup`](../../-if-group/index.md)`, `[`Builder`](../../-if-group/-builder/index.md)`>` |
| [Builder](../../-if-statement/-builder/index.md) | `class Builder : Builder<`[`IfStatement`](../../-if-statement/index.md)`, `[`Builder`](../../-if-statement/-builder/index.md)`>, `[`Builder`](../../-body-holder/-builder/index.md)`<`[`IfStatement`](../../-if-statement/index.md)`, `[`Builder`](../../-if-statement/-builder/index.md)`>` |
