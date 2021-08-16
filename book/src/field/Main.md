# Field Declaration and Field Access

Field declaration and access is a bit more complex than variables. You can have static fields and instance fields, they are declared and accessed differently.

## Instance Field Declaration

### Public

```kotlin
val myField = fieldDec().build {
    modifiers = setOf(KoresModifier.PUBLIC)
    type = Types.STRING
    name = "name"
}
```

### Private

```kotlin
val myField = fieldDec().build {
    modifiers = setOf(KoresModifier.PRIVATE)
    type = Types.STRING
    name = "name"
}
```

### Private and Final

```kotlin
val myField = fieldDec().build {
    modifiers = setOf(KoresModifier.PRIVATE, KoresModifier.FINAL)
    type = Types.STRING
    name = "name"
}
```

#### Private and final field must either have a default value or be defined in the constructor. 

Kores does not enforce this rule, but failing to meet this requirement will result in **Kores-SourceWriter** generating a non-valid Java Source File. For **Kores-BytecodeWriter**, a valid class-file is generated, since there is no runtime verifier that checks if a `private final` field is being set, however, trying to retrieve the value of a non-defined final field will result in `null`.

##### Example of field declaration with default value

```kotlin
val myField = fieldDec().build {
    modifiers = setOf(KoresModifier.PRIVATE, KoresModifier.FINAL)
    type = Types.STRING
    name = "name"
    value = Literals.STRING("Foo")
}
```

##### Example of constructor defining a private final field

```kotlin
val myConstructor = constructorDec().build {
    parameters = listOf(parameter<String>("name"))
    body = MutableInstructions.create(listOf(
        setThisFieldValue( // Sets the `name` field
            Types.STRING,
            "name",
            accessVariable<String>("name") // Access `name` constructor parameter
        )
    ))
}
```

### Access instance field

For fields in the current class:

```kotlin
val accessNameField = accessThisField(Types.STRING, "name")
```

For fields in other classes:

```kotlin
class MyType {
    @JvmField
    val name: String = ""
}

val myType = typeOf<MyType>()
val accessNameField = accessField(myType, accessThisField(myType, "myType"), Types.STRING, "name")
```

### Define instance field

For fields in the current class:

```kotlin
val setNameField = setThisFieldValue(Types.STRING, "name", Literals.STRING("Bar"))
```

For fields in other classes:

```kotlin
class MyType {
    @JvmField
    val name: String = ""
}

val myType = typeOf<MyType>()
val setNameField = setFieldValue(myType, accessThisField(myType, "myType"), Types.STRING, "name", Literals.STRING("Bar"))
```

## Static Field Declaration

The same way as declaring instance fields, but with the `STATIC` modifier.

```kotlin
val myField = fieldDec().build {
    modifiers = setOf(KoresModifier.PRIVATE, KoresModifier.STATIC)
    type = Types.STRING
    name = "NAME"
}
```

#### Private and final static field must either have a default value or be defined in the static block of the type declaration

##### Example of field declaration with default value

```kotlin
val myField = fieldDec().build {
    modifiers = setOf(KoresModifier.PRIVATE, KoresModifier.STATIC, KoresModifier.FINAL)
    type = Types.STRING
    name = "NAME"
    value = Literals.STRING("Foo")
}
```

##### Example of field declaration in static block.

```kotlin
val staticBlock = StaticBlock.Builder.builder()
    .body(MutableInstructions.create(listOf(
        setStaticFieldValue(Alias.THIS, Types.STRING, "NAME", Literals.STRING("Foo")))
    ))
    .build()
```

`StaticBlock` must be provided to a `TypeDeclaration`:

```kotlin
val myStaticField = fieldDec().build {
    modifiers = setOf(KoresModifier.PRIVATE, KoresModifier.STATIC, KoresModifier.FINAL)
    type = Types.STRING
    name = "NAME"
}

val staticBlock = StaticBlock.Builder.builder()
    .body(MutableInstructions.create(listOf(
        setStaticFieldValue(Alias.THIS, Types.STRING, "NAME", Literals.STRING("Foo")))  
    ))
    .build()

val myClassDeclaration = ClassDeclaration.Builder.builder()
    .name("MyClass")
    .fields(myStaticField)
    .staticBlock(staticBlock) // StaticBlock
    .build()
```

### Access static field

For fields in the current class:

```kotlin
val accessNameStaticField = accessStaticField(Alias.THIS, Types.STRING, "NAME")
```

For fields in other classes:

```kotlin
val accessOutStaticField = accessStaticField(Types.SYSTEM, typeOf<PrintStream>(), "out")
```

### Define static field

For fields in the current class:

```kotlin
val setNameField = setThisFieldValue(Types.STRING, "name", Literals.STRING("Bar"))
```

For fields in other classes:

```kotlin
class MyType {
    @JvmField
    val name: String = ""
}

val myType = typeOf<MyType>()
val setNameStaticField = setStaticFieldValue(myType, Types.STRING, "name", Literals.STRING("Bar"))
```
