[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [find](.)

# find

`fun <U> find(codeSource: `[`CodeSource`](../com.github.jonathanxd.codeapi/-code-source/index.md)`, predicate: (`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, function: (`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> U): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<U>`

Find an element in a code source. (Highly recommended to use [SourceInspect](../com.github.jonathanxd.codeapi.inspect/-source-inspect/index.md) instead of this.

### Parameters

`codeSource` - Code Source.

`predicate` - Predicate.

`function` - Mapper.

`U` - Mapped return type.

**Return**
List of mapped parts.

`fun find(genericSignature: `[`GenericSignature`](../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`, typeName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`?`

Searches for a type with name [typeName](find.md#com.github.jonathanxd.codeapi.util$find(com.github.jonathanxd.codeapi.generic.GenericSignature, kotlin.String)/typeName) in [genericSignature](find.md#com.github.jonathanxd.codeapi.util$find(com.github.jonathanxd.codeapi.generic.GenericSignature, kotlin.String)/genericSignature)

