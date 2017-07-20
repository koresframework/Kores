[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ForEachStatement](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`ForEachStatement(variable: `[`VariableDeclaration`](../-variable-declaration/index.md)`, iterationType: `[`IterationType`](../-iteration-type/index.md)`, iterableElement: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`)`

For each statement.

For each statement behavior depends on [IterationType](../-iteration-type/index.md). For Source generation [iterationType](-init-.md#com.github.jonathanxd.codeapi.base.ForEachStatement$<init>(com.github.jonathanxd.codeapi.base.VariableDeclaration, com.github.jonathanxd.codeapi.base.IterationType, com.github.jonathanxd.codeapi.CodeInstruction, com.github.jonathanxd.codeapi.CodeSource)/iterationType) is useless,
but for bytecode generation it is useful because `foreach` is translated to a [ForStatement](../-for-statement/index.md), and arrays
requires a special treatment to access length and values.

