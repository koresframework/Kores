[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Constructor](index.md) / [toConstructorDeclaration](.)

# toConstructorDeclaration

`fun <T : Any> `[`Constructor`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Constructor.html)`<T>.toConstructorDeclaration(nameProvider: (Int, `[`Parameter`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Parameter.html)`) -> String = { i, _ -> this.parameterNames[i] }): `[`ConstructorDeclaration`](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)

Convert this [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html) to [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md).

### Parameters

`nameProvider` - Provider of parameter names.

**Return**
[MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md).

`fun <T : Any> `[`Constructor`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Constructor.html)`<T>.toConstructorDeclaration(arguments: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>, nameProvider: (Int, `[`Parameter`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Parameter.html)`) -> String = { i, _ -> this.parameterNames[i] }): `[`ConstructorDeclaration`](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)

Convert this [Constructor](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Constructor.html) structure to [ConstructorDeclaration](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) structure calling super constructor with [arguments](to-constructor-declaration.md#com.github.jonathanxd.codeapi.util.conversion$toConstructorDeclaration(java.lang.reflect.Constructor((com.github.jonathanxd.codeapi.util.conversion.toConstructorDeclaration.T)), kotlin.collections.List((com.github.jonathanxd.codeapi.CodePart)), kotlin.Function2((kotlin.Int, java.lang.reflect.Parameter, kotlin.String)))/arguments).

### Parameters

`arguments` - Arguments to pass to super constructor.

`nameProvider` - Provider of parameter names.

**Return**
[ConstructorDeclaration](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) structure from [Constructor](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Constructor.html) calling super constructor with [arguments](to-constructor-declaration.md#com.github.jonathanxd.codeapi.util.conversion$toConstructorDeclaration(java.lang.reflect.Constructor((com.github.jonathanxd.codeapi.util.conversion.toConstructorDeclaration.T)), kotlin.collections.List((com.github.jonathanxd.codeapi.CodePart)), kotlin.Function2((kotlin.Int, java.lang.reflect.Parameter, kotlin.String)))/arguments).

