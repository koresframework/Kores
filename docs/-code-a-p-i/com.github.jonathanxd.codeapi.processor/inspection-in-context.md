[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.processor](index.md) / [inspectionInContext](.)

# inspectionInContext

`inline fun <P, R> `[`ValidationEnvironment`](-validation-environment/index.md)`.inspectionInContext(part: P, context: (part: P) -> R): R`

Immediately enters the inspection of [part](inspection-in-context.md#com.github.jonathanxd.codeapi.processor$inspectionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, com.github.jonathanxd.codeapi.processor.inspectionInContext.P, kotlin.Function1((com.github.jonathanxd.codeapi.processor.inspectionInContext.P, com.github.jonathanxd.codeapi.processor.inspectionInContext.R)))/part), calls [context](inspection-in-context.md#com.github.jonathanxd.codeapi.processor$inspectionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, com.github.jonathanxd.codeapi.processor.inspectionInContext.P, kotlin.Function1((com.github.jonathanxd.codeapi.processor.inspectionInContext.P, com.github.jonathanxd.codeapi.processor.inspectionInContext.R)))/context) and then immediately exits the inspection of [part](inspection-in-context.md#com.github.jonathanxd.codeapi.processor$inspectionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, com.github.jonathanxd.codeapi.processor.inspectionInContext.P, kotlin.Function1((com.github.jonathanxd.codeapi.processor.inspectionInContext.P, com.github.jonathanxd.codeapi.processor.inspectionInContext.R)))/part).

