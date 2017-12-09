[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Method](index.md) / [toMethodDeclaration](.)

# toMethodDeclaration

`@JvmOverloads fun Method.toMethodDeclaration(nameProvider: (index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, parameter: Parameter) -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { i, _ -> this.parameterNames[i] }): `[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)

Convert this [Method](#) to [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md).

### Parameters

`nameProvider` - Provider of parameter names.

**Return**
[MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md).

`@JvmOverloads fun Method.toMethodDeclaration(superClass: Type, nameProvider: (index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, parameter: Parameter) -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { i, _ -> this.parameterNames[i] }): `[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)

Convert this [Method](#) structure to [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) structure invoking the super class method.

### Parameters

`superClass` - super class to invoke

`nameProvider` - Provider of parameter names.

**Return**
[MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) structure from [Method](#) invoking super class method.

