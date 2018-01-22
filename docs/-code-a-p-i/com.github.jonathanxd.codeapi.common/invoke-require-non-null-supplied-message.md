[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.common](index.md) / [invokeRequireNonNullSuppliedMessage](.)

# invokeRequireNonNullSuppliedMessage

`fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeRequireNonNullSuppliedMessage(messageSupplier: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invokes `Object Objects.requireNonNull(T, M)` static method (this function does not auto-cast).

Where `T` is the receiver and `M` the [messageSupplier](invoke-require-non-null-supplied-message.md#com.github.jonathanxd.codeapi.common$invokeRequireNonNullSuppliedMessage(com.github.jonathanxd.codeapi.CodeInstruction, com.github.jonathanxd.codeapi.CodeInstruction)/messageSupplier).

