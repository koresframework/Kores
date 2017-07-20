[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [visit](.)

# visit

`fun visit(codeSource: `[`CodeSource`](../com.github.jonathanxd.codeapi/-code-source/index.md)`, consumer: (`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, `[`Location`](-location/index.md)`, `[`MutableCodeSource`](../com.github.jonathanxd.codeapi/-mutable-code-source/index.md)`) -> Unit): `[`MutableCodeSource`](../com.github.jonathanxd.codeapi/-mutable-code-source/index.md)

Visit Code Source elements.

This method create a new [CodeSource](../com.github.jonathanxd.codeapi/-code-source/index.md) and add all elements from `codeSource`
before and after visits each [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) of `codeSource`.

When visiting process finish, it will clear `codeSource` and add all elements from new
[CodeSource](../com.github.jonathanxd.codeapi/-code-source/index.md)

### Parameters

`codeSource` - Code Source to visit

`consumer` - Consumer

**Return**
Result source.

