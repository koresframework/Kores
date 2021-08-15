//[Kores](../../../index.md)/[com.koresframework.kores.util](../index.md)/[GenericResolver](index.md)

# GenericResolver

[jvm]\
interface [GenericResolver](index.md)

## Functions

| Name | Summary |
|---|---|
| [resolveGenericTypeImplementation](resolve-generic-type-implementation.md) | [jvm]<br>abstract fun [resolveGenericTypeImplementation](resolve-generic-type-implementation.md)(superType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), implemented: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../../com.koresframework.kores.type/-kores-type-resolver/index.md)<*>): [GenericType](../../com.koresframework.kores.type/-generic-type/index.md)<br>Resolves [GenericType](../../com.koresframework.kores.type/-generic-type/index.md) of [implemented](resolve-generic-type-implementation.md) type, which was implemented in [superType](resolve-generic-type-implementation.md). |
| [resolveTypeWithParameters](resolve-type-with-parameters.md) | [jvm]<br>abstract fun [resolveTypeWithParameters](resolve-type-with-parameters.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../../com.koresframework.kores.type/-kores-type-resolver/index.md)<*>): [GenericType](../../com.koresframework.kores.type/-generic-type/index.md)<br>Resolves the [GenericType](../../com.koresframework.kores.type/-generic-type/index.md) of [type](resolve-type-with-parameters.md). |

## Inheritors

| Name |
|---|
| [ModelResolver](../../com.koresframework.kores.type/-model-resolver/index.md) |
| [JavaResolver](../-java-resolver/index.md) |
| [KoresResolver](../-kores-resolver/index.md) |
| [MixedResolver](../-mixed-resolver/index.md) |
