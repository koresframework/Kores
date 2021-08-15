//[Kores](../../index.md)/[com.koresframework.kores.helper](index.md)

# Package com.koresframework.kores.helper

## Types

| Name | Summary |
|---|---|
| [ConcatHelper](-concat-helper/index.md) | [jvm]<br>class [ConcatHelper](-concat-helper/index.md)<br>Concatenation helper. |
| [IfExpressionHelper](-if-expression-helper/index.md) | [jvm]<br>class [IfExpressionHelper](-if-expression-helper/index.md)<br>If expression helper. |
| [OperateHelper](-operate-helper/index.md) | [jvm]<br>class [OperateHelper](-operate-helper/index.md)<br>Operator helper. |

## Functions

| Name | Summary |
|---|---|
| [invokeIntToString](invoke-int-to-string.md) | [jvm]<br>fun [Instruction](../com.koresframework.kores/-instruction/index.md).[invokeIntToString](invoke-int-to-string.md)(): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)<br>Invokes String.valueOf(int) on receiver. |
| [invokePrintln](invoke-println.md) | [jvm]<br>fun [invokePrintln](invoke-println.md)(vararg arguments: [Instruction](../com.koresframework.kores/-instruction/index.md)): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)<br>Invokes System.out.println(Any) with concatenation of [arguments](invoke-println.md). |
| [invokePrintlnStr](invoke-println-str.md) | [jvm]<br>fun [invokePrintlnStr](invoke-println-str.md)(part: [Instruction](../com.koresframework.kores/-instruction/index.md)): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)<br>Invokes System.out.println(String) with [part](invoke-println-str.md) as argument. |
| [invokeToString](invoke-to-string.md) | [jvm]<br>fun [Instruction](../com.koresframework.kores/-instruction/index.md).[invokeToString](invoke-to-string.md)(): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)<br>Invokes Any.toString on receiver. |
