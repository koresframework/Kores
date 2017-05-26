[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [ValidationEnvironment](index.md) / [exitInspectionOf](.)

# exitInspectionOf

`abstract fun exitInspectionOf(part: Any): Unit`

Exits the inspection of [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment$exitInspectionOf(kotlin.Any)/part). This method may throw [UnexpectedInspectionContext](../-unexpected-inspection-context/index.md), if
the last value of inspection context is not [Any.equals](#) to [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment$exitInspectionOf(kotlin.Any)/part).

