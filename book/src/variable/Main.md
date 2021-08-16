# Variable Declaration and Access

## Declaration

Variable declaration is very easy to create:

```kotlin
val myVariable = variable(Types.STRING, "name")
```

And with an initial default value:

```kotlin
val myVariable = variable(Types.STRING, "name", "Foo".toLiteral())
```

## Access

```kotlin
val accessMyVariable = accessVariable(Types.STRING, "name")
```

### Method and Constructor Parameters

Parameters provided to `MethodDeclaration` are variables as well:

```kotlin
val sumMethod = methodDec().build { 
    publicModifier()
    returnType = typeOf<Int>()
    name = "sum"
    parameters2<Int, Int>("a", "b") // a and b can be accessed just like variables
    body = MutableInstructions.create(listOf(
        returnValue(operate(accessVariable<Int>("a"), Operators.ADD, accessVariable<Int>("b")))
    ))
}
```