[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ArrayConstructor](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`ArrayConstructor(arrayType: Type, dimensions: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>)`

Constructs an array of type [arrayType](-init-.md#com.github.jonathanxd.codeapi.base.ArrayConstructor$<init>(java.lang.reflect.Type, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)), kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/arrayType) with dimensions [dimensions](-init-.md#com.github.jonathanxd.codeapi.base.ArrayConstructor$<init>(java.lang.reflect.Type, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)), kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/dimensions). Example:

`new ArrayConstructor(String[].class, listOf(Literals.INT(5)), emptyList()) = new String[5]`
`new ArrayConstructor(String[].class, listOf(Literals.INT(5), Literals.INT(9)), emptyList()) = new String[5][9]`

```
new ArrayConstructor(
    String[].class,
    listOf(Literals.INT(3)),
    listOf(Literals.STRING("A"), Literals.STRING("B"), Literals.STRING("C"))
) = new String[] {"A", "B", "C"}
```

