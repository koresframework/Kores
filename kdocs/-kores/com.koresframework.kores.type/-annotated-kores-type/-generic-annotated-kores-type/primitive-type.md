//[Kores](../../../../index.md)/[com.koresframework.kores.type](../../index.md)/[AnnotatedKoresType](../index.md)/[GenericAnnotatedKoresType](index.md)/[primitiveType](primitive-type.md)

# primitiveType

[jvm]\
open override val [primitiveType](primitive-type.md): [KoresType](../../-kores-type/index.md)?

Only determine the Primitive type if:

isKoresType && bounds.isEmpty

Because

Integer<T> is invalid and List<T> has no primitive types because List is not a wrapper type.
