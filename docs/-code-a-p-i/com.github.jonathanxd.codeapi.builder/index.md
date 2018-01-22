[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.builder](.)

## Package com.github.jonathanxd.codeapi.builder

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T, S : `[`Builder`](-builder/index.md)`<T, S>>`<br>Builder pattern. |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun <T, S : `[`Builder`](-builder/index.md)`<T, S>> S.build(func: S.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): T`<br>Build the object of type [T](#). |
| [self](self.md) | `fun <T, S : `[`Builder`](-builder/index.md)`<T, S>> `[`Builder`](-builder/index.md)`<T, S>.self(): S`<br>Cast from [Builder](-builder/index.md) of [T](#) of implicit type [S](#). |
