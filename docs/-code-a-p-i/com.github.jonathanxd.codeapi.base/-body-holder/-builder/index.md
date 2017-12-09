[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [BodyHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`BodyHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `abstract fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): S`<br>See [T.body](body.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-case/-builder/index.md) | `class Builder : `[`Builder`](../../-value-holder/-builder/index.md)`<`[`Case`](../../-case/index.md)`, `[`Builder`](../../-case/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`Case`](../../-case/index.md)`, `[`Builder`](../../-case/-builder/index.md)`>, Builder<`[`Case`](../../-case/index.md)`, `[`Builder`](../../-case/-builder/index.md)`>` |
| [Builder](../../-catch-statement/-builder/index.md) | `class Builder : Builder<`[`CatchStatement`](../../-catch-statement/index.md)`, `[`Builder`](../../-catch-statement/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`CatchStatement`](../../-catch-statement/index.md)`, `[`Builder`](../../-catch-statement/-builder/index.md)`>` |
| [Builder](../../-for-each-statement/-builder/index.md) | `class Builder : Builder<`[`ForEachStatement`](../../-for-each-statement/index.md)`, `[`Builder`](../../-for-each-statement/-builder/index.md)`>` |
| [Builder](../../-for-statement/-builder/index.md) | `class Builder : `[`Builder`](../../-if-expression-holder/-builder/index.md)`<`[`ForStatement`](../../-for-statement/index.md)`, `[`Builder`](../../-for-statement/-builder/index.md)`>, Builder<`[`ForStatement`](../../-for-statement/index.md)`, `[`Builder`](../../-for-statement/-builder/index.md)`>` |
| [Builder](../../-if-statement/-builder/index.md) | `class Builder : `[`Builder`](../../-if-expression-holder/-builder/index.md)`<`[`IfStatement`](../../-if-statement/index.md)`, `[`Builder`](../../-if-statement/-builder/index.md)`>, Builder<`[`IfStatement`](../../-if-statement/index.md)`, `[`Builder`](../../-if-statement/-builder/index.md)`>` |
| [Builder](../../-label/-builder/index.md) | `class Builder : Builder<`[`Label`](../../-label/index.md)`, `[`Builder`](../../-label/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`Label`](../../-label/index.md)`, `[`Builder`](../../-label/-builder/index.md)`>` |
| [Builder](../../-method-declaration-base/-builder/index.md) | `interface Builder<out T : `[`MethodDeclarationBase`](../../-method-declaration-base/index.md)`, S : `[`Builder`](../../-method-declaration-base/-builder/index.md)`<T, S>> : Builder<T, S>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-return-type-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-parameters-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-throws-holder/-builder/index.md)`<T, S>` |
| [Builder](../../-synchronized/-builder/index.md) | `class Builder : Builder<`[`Synchronized`](../../-synchronized/index.md)`, `[`Builder`](../../-synchronized/-builder/index.md)`>` |
| [Builder](../../-try-statement-base/-builder/index.md) | `interface Builder<out T : `[`TryStatementBase`](../../-try-statement-base/index.md)`, S : `[`Builder`](../../-try-statement-base/-builder/index.md)`<T, S>> : Builder<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>` |
| [Builder](../../-while-statement/-builder/index.md) | `class Builder : `[`Builder`](../../-if-expression-holder/-builder/index.md)`<`[`WhileStatement`](../../-while-statement/index.md)`, `[`Builder`](../../-while-statement/-builder/index.md)`>, Builder<`[`WhileStatement`](../../-while-statement/index.md)`, `[`Builder`](../../-while-statement/-builder/index.md)`>` |
