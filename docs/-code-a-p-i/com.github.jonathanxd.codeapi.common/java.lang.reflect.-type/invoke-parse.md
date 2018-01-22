[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.common](../index.md) / [java.lang.reflect.Type](index.md) / [invokeParse](.)

# invokeParse

`fun Type.invokeParse(arg: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invokes `X Y.parseN(String)` static method of receiver [Type](#).

Where `X` is the primitive type of [Type](#), `Y` is the wrapper type of [Type](#) and
`N` is the capitalized simple name of [Type](#).

### Parameters

`arg` - Argument to parse value from.