[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.common](index.md) / [invokeRequireNonNull](.)

# invokeRequireNonNull

`fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeRequireNonNull(): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invokes `Object Objects.requireNonNull(T)` static method (this function does not auto-cast).

Where `T` is the receiver.

`fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeRequireNonNull(message: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invokes `Object Objects.requireNonNull(T, M)` static method (this function does not auto-cast).

Where `T` is the receiver and `M` the [message](invoke-require-non-null.md#com.github.jonathanxd.codeapi.common$invokeRequireNonNull(com.github.jonathanxd.codeapi.CodeInstruction, com.github.jonathanxd.codeapi.CodeInstruction)/message).

