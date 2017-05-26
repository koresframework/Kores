[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [SwitchStatement](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`SwitchStatement(value: `[`Typed`](../-typed/index.md)`, switchType: `[`SwitchType`](../-switch-type/index.md)`, cases: List<`[`Case`](../-case/index.md)`>)`

Switch statement, this switch can switch numeric values and object values (like Enum, String or other
objects).

You could switch objects, but make sure that the object implements [Any.hashCode](#)
and [Any.equals](#) methods.

