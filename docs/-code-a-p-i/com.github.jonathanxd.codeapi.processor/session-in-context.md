[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.processor](index.md) / [sessionInContext](.)

# sessionInContext

`inline fun <R> `[`ValidationEnvironment`](-validation-environment/index.md)`.sessionInContext(context: (session: `[`Session`](-validation-environment/-session/index.md)`) -> R): R`

Creates session to be used only within [context](session-in-context.md#com.github.jonathanxd.codeapi.processor$sessionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, kotlin.Function1((com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Session, com.github.jonathanxd.codeapi.processor.sessionInContext.R)))/context), this session is exited immediately after [context](session-in-context.md#com.github.jonathanxd.codeapi.processor$sessionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, kotlin.Function1((com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Session, com.github.jonathanxd.codeapi.processor.sessionInContext.R)))/context) invocation.

