//[Kores](../../../index.md)/[com.koresframework.kores.type](../index.md)/[ModelResolver](index.md)/[resolveGenericTypeImplementation](resolve-generic-type-implementation.md)

# resolveGenericTypeImplementation

[jvm]\
open override fun [resolveGenericTypeImplementation](resolve-generic-type-implementation.md)(superType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), implemented: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): [GenericType](../-generic-type/index.md)

Resolves [GenericType](../-generic-type/index.md) of [implemented](resolve-generic-type-implementation.md) type, which was implemented in [superType](resolve-generic-type-implementation.md). This generic type should be the [implemented](resolve-generic-type-implementation.md) belong with type parameters provided by [superType](resolve-generic-type-implementation.md).
