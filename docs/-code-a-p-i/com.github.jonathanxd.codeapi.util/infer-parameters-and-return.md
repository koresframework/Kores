[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [inferParametersAndReturn](.)

# inferParametersAndReturn

`fun inferParametersAndReturn(owner: `[`Lazy`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html)`<`[`TypeDeclaration`](../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`>, holder: `[`GenericSignatureHolder`](../com.github.jonathanxd.codeapi.base/-generic-signature-holder/index.md)`, codeParameters: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`CodeParameter`](../com.github.jonathanxd.codeapi.base/-code-parameter/index.md)`>, returnType: Type): `[`TypeSpec`](../com.github.jonathanxd.codeapi.base/-type-spec/index.md)

Infer bound of generic types using types specified in [signature holder](infer-parameters-and-return.md#com.github.jonathanxd.codeapi.util$inferParametersAndReturn(kotlin.Lazy((com.github.jonathanxd.codeapi.base.TypeDeclaration)), com.github.jonathanxd.codeapi.base.GenericSignatureHolder, kotlin.collections.Collection((com.github.jonathanxd.codeapi.base.CodeParameter)), java.lang.reflect.Type)/holder)
and in [type declaration](infer-parameters-and-return.md#com.github.jonathanxd.codeapi.util$inferParametersAndReturn(kotlin.Lazy((com.github.jonathanxd.codeapi.base.TypeDeclaration)), com.github.jonathanxd.codeapi.base.GenericSignatureHolder, kotlin.collections.Collection((com.github.jonathanxd.codeapi.base.CodeParameter)), java.lang.reflect.Type)/owner) and returns inferred types.

This class uses lazy owner because depending on method signature, the [TypeDeclaration](../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) is not required.

