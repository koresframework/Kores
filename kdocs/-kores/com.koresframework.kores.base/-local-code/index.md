//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[LocalCode](index.md)

# LocalCode

[jvm]\
data class [LocalCode](index.md)(**declaringType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **invokeType**: [InvokeType](../-invoke-type/index.md), **declaration**: [MethodDeclaration](../-method-declaration/index.md), **innerTypes**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)>) : [KoresElement](../../com.koresframework.kores/-kores-element/index.md), [KoresPart](../../com.koresframework.kores/-kores-part/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md), [InnerTypesHolder](../-inner-types-holder/index.md)

A local code (or local method). This code may be inlined or declared as method of current type or translated to a lambda (for [InvokeDynamic.LambdaLocalCode](../-invoke-dynamic/-lambda-local-code/index.md)).

## Constructors

| | |
|---|---|
| [LocalCode](-local-code.md) | [jvm]<br>fun [LocalCode](-local-code.md)(declaringType: [KoresType](../../com.koresframework.kores.type/-kores-type/index.md), declaration: [MethodDeclaration](../-method-declaration/index.md), innerTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)>)<br>Local code execution constructor, this constructor resolves [invokeType](invoke-type.md) based on declaration and declaringType. |
| [LocalCode](-local-code.md) | [jvm]<br>fun [LocalCode](-local-code.md)(declaringType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), invokeType: [InvokeType](../-invoke-type/index.md), declaration: [MethodDeclaration](../-method-declaration/index.md), innerTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)>) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[LocalCode](index.md), [LocalCode.Builder](-builder/index.md)> , [InnerTypesHolder.Builder](../-inner-types-holder/-builder/index.md)<[LocalCode](index.md), [LocalCode.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [LocalCode.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [createInvocation](create-invocation.md) | [jvm]<br>fun [createInvocation](create-invocation.md)(arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>): [MethodInvocation](../-method-invocation/index.md)<br>Creates a invocation of this [LocalCode](index.md) with [arguments](create-invocation.md). |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>val [body](body.md): [Instructions](../../com.koresframework.kores/-instructions/index.md)<br>Method body |
| [declaration](declaration.md) | [jvm]<br>val [declaration](declaration.md): [MethodDeclaration](../-method-declaration/index.md)<br>Method declaration of the code. |
| [declaringType](declaring-type.md) | [jvm]<br>val [declaringType](declaring-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Declaring type of [declaration](declaration.md) ([Alias](../-alias/index.md) is supported) |
| [description](description.md) | [jvm]<br>val [description](description.md): [TypeSpec](../-type-spec/index.md)<br>Method description |
| [innerTypes](inner-types.md) | [jvm]<br>open override val [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)><br>Inner types |
| [invokeType](invoke-type.md) | [jvm]<br>val [invokeType](invoke-type.md): [InvokeType](../-invoke-type/index.md)<br>Invocation type (static, virtual or interface) this depends on where [declaration](declaration.md) is declared and which are the modifiers, if [declaration](declaration.md) is a instance method and declared in an interface, this must be [InvokeType.INVOKE_INTERFACE](../-invoke-type/-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md), if [declaration](declaration.md) is static, this must be [InvokeType.INVOKE_STATIC](../-invoke-type/-i-n-v-o-k-e_-s-t-a-t-i-c/index.md) does not matter if is declared in an interface or a class, if is not static and is declared in a class, this must be [InvokeType.INVOKE_VIRTUAL](../-invoke-type/-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md). |
| [parameters](parameters.md) | [jvm]<br>val [parameters](parameters.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../-kores-parameter/index.md)><br>Parameters |
