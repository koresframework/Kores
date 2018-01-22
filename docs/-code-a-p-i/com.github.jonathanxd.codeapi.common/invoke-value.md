[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.common](index.md) / [invokeValue](.)

# invokeValue

`fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeValue(type: Type): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invokes `X Y.nValue()` virtual method of [type](invoke-value.md#com.github.jonathanxd.codeapi.common$invokeValue(com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type)/type) with receiver [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md).

Where `X` is the primitive type of [type](invoke-value.md#com.github.jonathanxd.codeapi.common$invokeValue(com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type)/type), `Y` is the wrapper type of [type](invoke-value.md#com.github.jonathanxd.codeapi.common$invokeValue(com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type)/type) and `n`
is the de-capitalized simple name of [type](invoke-value.md#com.github.jonathanxd.codeapi.common$invokeValue(com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type)/type).

`fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeValue(base: Type, type: Type): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)

Invokes `X Y.nValue()` virtual method of [base type](invoke-value.md#com.github.jonathanxd.codeapi.common$invokeValue(com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, java.lang.reflect.Type)/base) with receiver [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md).

Where `X` is the primitive type of [type](invoke-value.md#com.github.jonathanxd.codeapi.common$invokeValue(com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, java.lang.reflect.Type)/type), `Y` is the wrapper type of [base](invoke-value.md#com.github.jonathanxd.codeapi.common$invokeValue(com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, java.lang.reflect.Type)/base) and `n`
is the de-capitalized simple name of [type](invoke-value.md#com.github.jonathanxd.codeapi.common$invokeValue(com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, java.lang.reflect.Type)/type).

Used in cases like `int Byte.intValue()`.

