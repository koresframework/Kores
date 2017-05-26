[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.helper](.)

## Package com.github.jonathanxd.codeapi.helper

### Types

| Name | Summary |
|---|---|
| [ConcatHelper](-concat-helper/index.md) | `class ConcatHelper : Any`<br>Concatenation helper. |
| [IfExpressionHelper](-if-expression-helper/index.md) | `class IfExpressionHelper : Any`<br>If expression helper. |
| [OperateHelper](-operate-helper/index.md) | `class OperateHelper : Any`<br>Operator helper. |

### Functions

| Name | Summary |
|---|---|
| [intToString](int-to-string.md) | `fun intToString(part: `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `String.valueOf(int)` on [part](int-to-string.md#com.github.jonathanxd.codeapi.helper$intToString(com.github.jonathanxd.codeapi.CodePart)/part). |
| [invokePrintln](invoke-println.md) | `fun invokePrintln(vararg arguments: `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `System.out.println(Any)` with concatenation of [arguments](invoke-println.md#com.github.jonathanxd.codeapi.helper$invokePrintln(kotlin.Array((com.github.jonathanxd.codeapi.CodePart)))/arguments). |
| [invokePrintlnStr](invoke-println-str.md) | `fun invokePrintlnStr(part: `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `System.out.println(String)` with [part](invoke-println-str.md#com.github.jonathanxd.codeapi.helper$invokePrintlnStr(com.github.jonathanxd.codeapi.CodePart)/part) as argument. |
| [toString](to-string.md) | `fun toString(part: `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `Any.toString` on [part](to-string.md#com.github.jonathanxd.codeapi.helper$toString(com.github.jonathanxd.codeapi.CodePart)/part). |
