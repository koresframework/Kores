[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.common](../index.md) / [java.lang.reflect.Type](index.md) / [invokeValueOf](.)

# invokeValueOf

`fun Type.invokeValueOf(arg: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invokes `Y Y.valueOf(X)` static method of receiver [Type](#) that accepts the
primitive variant of [Type](#).

Where `Y` is the wrapper type of [Type](#) (or itself) and `X` the primitive type of [Type](#) (or itself).

### Parameters

`arg` - Argument to get value from.