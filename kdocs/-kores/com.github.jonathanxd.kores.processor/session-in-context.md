//[Kores](../../index.md)/[com.github.jonathanxd.kores.processor](index.md)/[sessionInContext](session-in-context.md)

# sessionInContext

[jvm]\
inline fun <[R](session-in-context.md)> [ValidationEnvironment](-validation-environment/index.md).[sessionInContext](session-in-context.md)(context: (session: [ValidationEnvironment.Session](-validation-environment/-session/index.md)) -> [R](session-in-context.md)): [R](session-in-context.md)

Creates session to be used only within [context](session-in-context.md), this session is exited immediately after [context](session-in-context.md) invocation.
