[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](index.md) / [find](.)

# find

`fun <U> `[`CodeSource`](-code-source/index.md)`.find(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, function: (`[`CodeInstruction`](-code-instruction.md)`) -> U): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<U>`

Find an element in a code source. (Highly recommended to use [SourceInspect](../com.github.jonathanxd.codeapi.inspect/-source-inspect/index.md) instead of this.

### Parameters

`predicate` - Predicate.

`function` - Mapper.

`U` - Mapped return type.

**Return**
List of mapped parts.

