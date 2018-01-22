[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.common](../index.md) / [java.lang.reflect.Type](.)

### Extensions for java.lang.reflect.Type

| Name | Summary |
|---|---|
| [invokeParse](invoke-parse.md) | `fun Type.invokeParse(arg: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `X Y.parseN(String)` static method of receiver [Type](#). |
| [invokeValueOf](invoke-value-of.md) | `fun Type.invokeValueOf(arg: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `Y Y.valueOf(X)` static method of receiver [Type](#) that accepts the primitive variant of [Type](#). |
