# Literals

Literals are the most basic unit in Kores, they are commonly loaded into the stack through the `ldc` instruction.

## Types of Literals

- Boolean
- Byte
- Char
- Short
- Int
- Long
- Float
- Double
- String
- Type/Class
- Dynamic Constant

Also, there is a special value that Kores treats like literals: the `null` value.

## Example of literals use

```kotlin
val str = Literals.STRING("Hello World")
val number1 = Literals.INT(1)
val trueBool = Literals.TRUE
val long10 = Literals.LONG(10)
val nullLiteral = Literals.NULL
```

## Dynamic Constant

The dynamic constant is a more advanced Literal, we will be talking about this feature later, but let's see an example of `Dynamic Constant` literal use:

```kotlin
data class Coord(val x: Double, val y: Double)

object MyConstBootstrap {
    @JvmStatic
    fun coordBootstrap(lookup: MethodHandles.Lookup, name: String, type: Class<*>, vararg args: Any): Coord {
        return Coord(x = 150.0, y = 150.0)
    }
}

val constantBoostrapSpec = MethodTypeSpec(
    typeOf<MyConstBootstrap>(),
    "coordBootstrap",
    typeSpec(typeOf<Coord>(), typeOf<MethodHandles.Lookup>(), typeOf<String>, typeOf<Class>, typeOf<Array<Any>>())
)

val coordConst = DynamicConstantSpec(
    "coord",
    typeOf<Coord>(),
    MethodInvokeHandleSpec(DynamicInvokeType.INVOKE_STATIC, constantBoostrapSpec),
    Collections.emptyList()
)

Literals.DYNAMIC_CONSTANT(coordConst)
```