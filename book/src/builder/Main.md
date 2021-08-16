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

The value produced by the `build` function is guaranteed to produce a new value of the same type as before, in other words, the old value (`nameFieldDeclaration` in this case) keeps unchanged while the new one has the changes applied to it.

**It does not mean that values are immutable**, even though all `KoresPart` are `data classes` with `val` properties that cannot be changed, values provided to `KoresPart` may change, list `List` of `arguments`, or `List` of parameters, or the `MutableInstructions` data type.

This allows users to increment data in `KoresPart` without the need to create a new instance for every change, and to propagate the change to all other instances that uses your object. However, Kores always uses types that seems to be immutable at the first look, for example, `MethodInvocation` receives a `List<Instruction>` of arguments, you can provide a `MutableList<Instruction>`, but when trying to retrieve the value, you will receive a value of `List<Instruction>` type, you can safely cast it to `MutableList<*>` as Kores does not copy lists, it just stores the provided value.

Doing **casts into mutable types** is only safe if you can prove that those values still mutable at the moment of the casting.
