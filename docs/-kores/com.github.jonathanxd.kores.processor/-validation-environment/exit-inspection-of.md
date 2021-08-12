//[Kores](../../../index.md)/[com.github.jonathanxd.kores.processor](../index.md)/[ValidationEnvironment](index.md)/[exitInspectionOf](exit-inspection-of.md)

# exitInspectionOf

[jvm]\
abstract fun [exitInspectionOf](exit-inspection-of.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))

Exits the inspection of [part](exit-inspection-of.md). This method may throw [UnexpectedInspectionContext](../-unexpected-inspection-context/index.md), if the last value of inspection context is not [Any.equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html) to [part](exit-inspection-of.md).
