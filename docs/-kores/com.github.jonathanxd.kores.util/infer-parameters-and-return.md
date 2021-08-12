//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](index.md)/[inferParametersAndReturn](infer-parameters-and-return.md)

# inferParametersAndReturn

[jvm]\
fun [inferParametersAndReturn](infer-parameters-and-return.md)(owner: [Lazy](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)<[TypeDeclaration](../com.github.jonathanxd.kores.base/-type-declaration/index.md)>, holder: [GenericSignatureHolder](../com.github.jonathanxd.kores.base/-generic-signature-holder/index.md), codeParameters: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[KoresParameter](../com.github.jonathanxd.kores.base/-kores-parameter/index.md)>, returnType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [TypeSpec](../com.github.jonathanxd.kores.base/-type-spec/index.md)

Infer bound of generic types using types specified in [signature holder](infer-parameters-and-return.md) and in [type declaration](infer-parameters-and-return.md) and returns inferred types.

This class uses lazy owner because depending on method signature, the [TypeDeclaration](../com.github.jonathanxd.kores.base/-type-declaration/index.md) is not required.
