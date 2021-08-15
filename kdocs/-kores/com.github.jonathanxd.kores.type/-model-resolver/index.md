//[Kores](../../../index.md)/[com.github.jonathanxd.kores.type](../index.md)/[ModelResolver](index.md)

# ModelResolver

[jvm]\
class [ModelResolver](index.md)(**elements**: [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)) : [GenericResolver](../../com.github.jonathanxd.kores.util/-generic-resolver/index.md)

## Functions

| Name | Summary |
|---|---|
| [resolveGenericTypeImplementation](resolve-generic-type-implementation.md) | [jvm]<br>open override fun [resolveGenericTypeImplementation](resolve-generic-type-implementation.md)(superType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), implemented: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): [GenericType](../-generic-type/index.md)<br>Resolves [GenericType](../-generic-type/index.md) of [implemented](resolve-generic-type-implementation.md) type, which was implemented in [superType](resolve-generic-type-implementation.md). |
| [resolveTypeWithParameters](resolve-type-with-parameters.md) | [jvm]<br>open override fun [resolveTypeWithParameters](resolve-type-with-parameters.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): [GenericType](../-generic-type/index.md)<br>Resolves the [GenericType](../-generic-type/index.md) of [type](resolve-type-with-parameters.md). |

## Properties

| Name | Summary |
|---|---|
| [elements](elements.md) | [jvm]<br>val [elements](elements.md): [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html) |
