[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.processor](../../index.md) / [ValidationEnvironment](../index.md) / [Impl](index.md) / [exitInspectionOf](.)

# exitInspectionOf

`fun exitInspectionOf(part: Any): Unit`

Overrides [ValidationEnvironment.exitInspectionOf](../exit-inspection-of.md)

Exits the inspection of [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Impl$exitInspectionOf(kotlin.Any)/part). This method may throw [UnexpectedInspectionContext](../../-unexpected-inspection-context/index.md), if
the last value of inspection context is not [Any.equals](#) to [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Impl$exitInspectionOf(kotlin.Any)/part).

