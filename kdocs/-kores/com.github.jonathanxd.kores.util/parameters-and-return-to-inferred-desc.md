//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](index.md)/[parametersAndReturnToInferredDesc](parameters-and-return-to-inferred-desc.md)

# parametersAndReturnToInferredDesc

[jvm]\
fun [parametersAndReturnToInferredDesc](parameters-and-return-to-inferred-desc.md)(owner: [Lazy](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)<[TypeDeclaration](../com.github.jonathanxd.kores.base/-type-declaration/index.md)>, holder: [GenericSignatureHolder](../com.github.jonathanxd.kores.base/-generic-signature-holder/index.md), codeParameters: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[KoresParameter](../com.github.jonathanxd.kores.base/-kores-parameter/index.md)>, returnType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Infer bound of generic types using types specified in [signature holder](parameters-and-return-to-inferred-desc.md) and in [type declaration](parameters-and-return-to-inferred-desc.md) and returns the string representing the description.
