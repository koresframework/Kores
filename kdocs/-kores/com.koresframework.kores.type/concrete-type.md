//[Kores](../../index.md)/[com.koresframework.kores.type](index.md)/[concreteType](concrete-type.md)

# concreteType

[jvm]\
val [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[concreteType](concrete-type.md): [KoresType](-kores-type/index.md)

See [KoresType.concreteType](concrete-type.md)

[jvm]\
val [KoresType](-kores-type/index.md).[concreteType](concrete-type.md): [KoresType](-kores-type/index.md)

Gets the concrete type of [KoresType](-kores-type/index.md), if this is a [GenericType](-generic-type/index.md), the property getter will try to infer the concrete type looping the [GenericType Inferred type](-generic-type/resolved-type.md).

Example: for S extends List<String>, it will return List (obs: the [GenericType.resolvedType](-generic-type/resolved-type.md) of S extends List<String> is List<String>.
