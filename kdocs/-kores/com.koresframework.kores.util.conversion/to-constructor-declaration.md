//[Kores](../../index.md)/[com.koresframework.kores.util.conversion](index.md)/[toConstructorDeclaration](to-constructor-declaration.md)

# toConstructorDeclaration

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

fun <[T](to-constructor-declaration.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html)<[T](to-constructor-declaration.md)>.[toConstructorDeclaration](to-constructor-declaration.md)(nameProvider: (index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), parameter: [Parameter](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Parameter.html)) -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { i, _ -> this.parameterNames[i] }): [ConstructorDeclaration](../com.koresframework.kores.base/-constructor-declaration/index.md)

Convert this [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html) to [MethodDeclaration](../com.koresframework.kores.base/-method-declaration/index.md).

#### Return

[MethodDeclaration](../com.koresframework.kores.base/-method-declaration/index.md).

## Parameters

jvm

| | |
|---|---|
| nameProvider | Provider of parameter names. |

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

fun <[T](to-constructor-declaration.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html)<[T](to-constructor-declaration.md)>.[toConstructorDeclaration](to-constructor-declaration.md)(arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.koresframework.kores/-instruction/index.md)>, nameProvider: (index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), parameter: [Parameter](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Parameter.html)) -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { i, _ -> this.parameterNames[i] }): [ConstructorDeclaration](../com.koresframework.kores.base/-constructor-declaration/index.md)

Convert this [Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html) structure to [ConstructorDeclaration](../com.koresframework.kores.base/-constructor-declaration/index.md) structure calling super constructor with [arguments](to-constructor-declaration.md).

#### Return

[ConstructorDeclaration](../com.koresframework.kores.base/-constructor-declaration/index.md) structure from [Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html) calling super constructor with [arguments](to-constructor-declaration.md).

## Parameters

jvm

| | |
|---|---|
| arguments | Arguments to pass to super constructor. |
| nameProvider | Provider of parameter names. |
