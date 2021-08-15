//[Kores](../../../index.md)/[com.koresframework.kores.type](../index.md)/[Generic](index.md)/[wrapperType](wrapper-type.md)

# wrapperType

[jvm]\
open override val [wrapperType](wrapper-type.md): [KoresType](../-kores-type/index.md)?

Only determine the Wrapper type if:

isKoresType && bounds.isEmpty

Because int<T> is invalid.
