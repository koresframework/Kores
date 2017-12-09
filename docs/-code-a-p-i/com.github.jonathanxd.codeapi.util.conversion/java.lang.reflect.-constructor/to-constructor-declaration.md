[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Constructor](index.md) / [toConstructorDeclaration](.)

# toConstructorDeclaration

`@JvmOverloads fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> Constructor<T>.toConstructorDeclaration(nameProvider: (index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, parameter: Parameter) -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { i, _ -> this.parameterNames[i] }): `[`ConstructorDeclaration`](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)

Convert this [Method](#) to [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md).

### Parameters

`nameProvider` - Provider of parameter names.

**Return**
[MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md).

`@JvmOverloads fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> Constructor<T>.toConstructorDeclaration(arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>, nameProvider: (index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, parameter: Parameter) -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { i, _ -> this.parameterNames[i] }): `[`ConstructorDeclaration`](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)

Convert this [Constructor](#) structure to [ConstructorDeclaration](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) structure calling super constructor with [arguments](to-constructor-declaration.md#com.github.jonathanxd.codeapi.util.conversion$toConstructorDeclaration(java.lang.reflect.Constructor((com.github.jonathanxd.codeapi.util.conversion.toConstructorDeclaration.T)), kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)), kotlin.Function2((kotlin.Int, java.lang.reflect.Parameter, kotlin.String)))/arguments).

### Parameters

`arguments` - Arguments to pass to super constructor.

`nameProvider` - Provider of parameter names.

**Return**
[ConstructorDeclaration](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) structure from [Constructor](#) calling super constructor with [arguments](to-constructor-declaration.md#com.github.jonathanxd.codeapi.util.conversion$toConstructorDeclaration(java.lang.reflect.Constructor((com.github.jonathanxd.codeapi.util.conversion.toConstructorDeclaration.T)), kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)), kotlin.Function2((kotlin.Int, java.lang.reflect.Parameter, kotlin.String)))/arguments).

