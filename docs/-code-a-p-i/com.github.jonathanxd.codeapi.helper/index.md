[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.helper](.)

## Package com.github.jonathanxd.codeapi.helper

### Types

| Name | Summary |
|---|---|
| [ConcatHelper](-concat-helper/index.md) | `class ConcatHelper`<br>Concatenation helper. |
| [IfExpressionHelper](-if-expression-helper/index.md) | `class IfExpressionHelper`<br>If expression helper. |
| [OperateHelper](-operate-helper/index.md) | `class OperateHelper`<br>Operator helper. |

### Functions

| Name | Summary |
|---|---|
| [invokeIntToString](invoke-int-to-string.md) | `fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeIntToString(): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `String.valueOf(int)` on receiver. |
| [invokePrintln](invoke-println.md) | `fun invokePrintln(vararg arguments: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `System.out.println(Any)` with concatenation of [arguments](invoke-println.md#com.github.jonathanxd.codeapi.helper$invokePrintln(kotlin.Array((com.github.jonathanxd.codeapi.CodeInstruction)))/arguments). |
| [invokePrintlnStr](invoke-println-str.md) | `fun invokePrintlnStr(part: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `System.out.println(String)` with [part](invoke-println-str.md#com.github.jonathanxd.codeapi.helper$invokePrintlnStr(com.github.jonathanxd.codeapi.CodeInstruction)/part) as argument. |
| [invokeToString](invoke-to-string.md) | `fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeToString(): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `Any.toString` on receiver. |
