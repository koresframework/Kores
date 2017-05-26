[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [EnumTypeUtil](index.md) / [resolve](.)

# resolve

`fun resolve(p: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, aSwitch: <ERROR CLASS><`[`SwitchStatement`](../../com.github.jonathanxd.codeapi.base/-switch-statement/index.md)`>): Int`

Try to resolve int value of part [p](resolve.md#com.github.jonathanxd.codeapi.util.EnumTypeUtil$resolve(com.github.jonathanxd.codeapi.CodePart, ((com.github.jonathanxd.codeapi.base.SwitchStatement)))/p). If is a numeric literal, returns the numeric value of
the literal, if is a string literal, returns the hashcode of the string, if is a [EnumValue](../../com.github.jonathanxd.codeapi.base/-enum-value/index.md), tries
to resolve the ordinal value.

