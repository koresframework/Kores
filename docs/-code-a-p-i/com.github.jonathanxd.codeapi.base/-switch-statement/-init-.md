[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [SwitchStatement](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`SwitchStatement(value: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, switchType: `[`SwitchType`](../-switch-type/index.md)`, cases: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Case`](../-case/index.md)`>)`

Switch statement, this switch can switch numeric values and object values (like Enum, String or other
objects).

You could switch objects, but make sure that the object implements [Any.hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html)
and [Any.equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html) methods.

