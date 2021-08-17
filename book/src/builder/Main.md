# Builder model

All Kores structures (AST) implements `KoresPart`, which specifies a `builder` function to implement. Every implementor must implement a conversion from its value into a specialized Builder.

Because of this contract, every value in Kores can be converted into a specialized Builder and converted back into the same value as before, for example:

```kotlin
val nameFieldDeclaration = FieldDeclaration.Builder.builder()
    .modifiers(KoresModifier.PRIVATE, KoresModifier.FINAL)
    .type(Types.STRING)
    .name("name")
    .build()

val otherNameFieldDeclaration = nameFieldDeclaration.builder()
    .name("otherName")
    .build()
```

The `build` function is guaranteed to produce a new value of the same type as before, in other words, the old value (`nameFieldDeclaration` in this case) keeps unchanged while the new one has the changes applied to it.

## Mutability

Kores does not enforce immutability, **builders** produces a new instance that reuses the value of the original one, only replacing the changed values.

This means that you can provide mutable values to `KoresParts` and manipulate this mutable value. It allows data to be incremented in `KoresPart` without the need to recreate the instance for every change.

For example:

```kotlin
val arguments = mutableListOf<Instruction>()
val methodInvocation = invokeStatic(
    Types.INTEGER_WRAPPER,
    Access.STATIC,
    "compare",
    typeSpec(Types.INT, Types.INT, Types.INT),
    arguments
)

val methodInvocation2 = methodInvocation.builder().build()

arguments.add(Literals.INT(10))
arguments.add(Literals.INT(11))
```

Changes to the `arguments` are reflected in the `methodInvocation` as well as in `methodInvocation2`.

### Avoiding the change reflection

There is some approaches that can be done in order to prevent the changes made to one value being reflected on another one. One of the approaches is copying the mutable values into a new (mutable or immutable) one:

```kotlin
val arguments = mutableListOf<Instruction>()
val methodInvocation = invokeStatic(
    Types.INTEGER_WRAPPER,
    Access.STATIC,
    "compare",
    typeSpec(Types.INT, Types.INT, Types.INT),
    arguments
)
val methodInvocation2 = methodInvocation.builder()
    .arguments(methodInvocation.arguments.toList())
    .build()

arguments.add(Literals.INT(10))
arguments.add(Literals.INT(11))
```

Also, adding new values to the list using the kotlin `+` operator will cause the list to be copied:

```kotlin
val arguments = mutableListOf<Instruction>()
val methodInvocation = invokeStatic(
    Types.INTEGER_WRAPPER,
    Access.STATIC,
    "compare",
    typeSpec(Types.INT, Types.INT, Types.INT),
    arguments
)
val methodInvocation2 = methodInvocation.builder()
    .arguments(methodInvocation.arguments + Literals.INT(1) + Literals.INT(2))
    .build()

arguments.add(Literals.INT(10))
arguments.add(Literals.INT(11))
```

## AST modifications

The **builder pattern** is also used in order to apply modifications to the AST without losing data in the process. We will be talking about this mechanism later.

## Factories

Kores also provides some factories functions to build AST objects without using the builder pattern, for example, for parameters:

```kotlin
val parameter = parameter(type = Types.STRING, name = "name")
```

For invocation and field access:

```kotlin
val out = accessStaticField(Types.SYSTEM, typeOf<PrintStream>(), "out")

invokeVirtual(typeOf<PrintStream>(), out, "println", typeSpec(Types.VOID, Types.OBJECT), listOf(Literals.STRING("Hello World!"))) 
```

Also, there are factories for the builders:

```kotlin
val nameGetter = methodDec().build {
    modifiers = setOf(KoresModifier.PUBLIC)
    returnType = Types.STRING
    name = "getName"
    parameters = emptyList()
    body = MutableInstructions.create(listOf(
        accessThisField(Types.STRING, "name")
    ))
}
```

And some `inline` functions for fast prototyping:

```kotlin
accessVariable<String>("name") // Inline with reified type
```

```kotlin
val sumMethod = methodDec().build {
    publicModifier()
    returnType = typeOf<Int>() // Inline with reified type
    name = "sum"
    parameters2<Int, Int>("a", "b") // Inline with reified type
    body = MutableInstructions.create(listOf(
        returnValue(operate(
            accessVariable<Int>("a"), // Inline with reified type
            Operators.ADD,
            accessVariable<Int>("b") // Inline with reified type
        ))
    ))
}
```

> Do not confuse Kores `typeOf` with Kotlin `typeOf`, the Kores one resides in `com.koresframework.kores.type` package, the Kotlin's one in `kotlin.reflect` package.
