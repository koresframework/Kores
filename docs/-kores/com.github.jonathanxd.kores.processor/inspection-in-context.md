//[Kores](../../index.md)/[com.github.jonathanxd.kores.processor](index.md)/[inspectionInContext](inspection-in-context.md)

# inspectionInContext

[jvm]\
inline fun <[P](inspection-in-context.md), [R](inspection-in-context.md)> [ValidationEnvironment](-validation-environment/index.md).[inspectionInContext](inspection-in-context.md)(part: [P](inspection-in-context.md), context: ([P](inspection-in-context.md)) -> [R](inspection-in-context.md)): [R](inspection-in-context.md)

Immediately enters the inspection of [part](inspection-in-context.md), calls [context](inspection-in-context.md) and then immediately exits the inspection of [part](inspection-in-context.md).
