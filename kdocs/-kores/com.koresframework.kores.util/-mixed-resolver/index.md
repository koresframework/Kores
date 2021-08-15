//[Kores](../../../index.md)/[com.koresframework.kores.util](../index.md)/[MixedResolver](index.md)

# MixedResolver

[jvm]\
class [MixedResolver](index.md)(**elements**: [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)?) : [GenericResolver](../-generic-resolver/index.md)

Mixes [JavaResolver](../-java-resolver/index.md) with [ModelResolver](../../com.koresframework.kores.type/-model-resolver/index.md) and [KoresResolver](../-kores-resolver/index.md) in one resolver.

## Constructors

| | |
|---|---|
| [MixedResolver](-mixed-resolver.md) | [jvm]<br>fun [MixedResolver](-mixed-resolver.md)(elements: [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)?) |

## Functions

| Name | Summary |
|---|---|
| [resolveGenericTypeImplementation](resolve-generic-type-implementation.md) | [jvm]<br>open override fun [resolveGenericTypeImplementation](resolve-generic-type-implementation.md)(superType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), implemented: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../../com.koresframework.kores.type/-kores-type-resolver/index.md)<*>): [GenericType](../../com.koresframework.kores.type/-generic-type/index.md)<br>Resolves [GenericType](../../com.koresframework.kores.type/-generic-type/index.md) of [implemented](resolve-generic-type-implementation.md) type, which was implemented in [superType](resolve-generic-type-implementation.md). |
| [resolveTypeWithParameters](resolve-type-with-parameters.md) | [jvm]<br>open override fun [resolveTypeWithParameters](resolve-type-with-parameters.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../../com.koresframework.kores.type/-kores-type-resolver/index.md)<*>): [GenericType](../../com.koresframework.kores.type/-generic-type/index.md)<br>Resolves the [GenericType](../../com.koresframework.kores.type/-generic-type/index.md) of [type](resolve-type-with-parameters.md). |

## Properties

| Name | Summary |
|---|---|
| [elements](elements.md) | [jvm]<br>val [elements](elements.md): [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)? |
