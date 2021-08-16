# Type Declarations

## Interface Declaration

```kotlin
val build = methodDec().build {
    publicModifier()
    returnType(Types.OBJECT)
    name("build")
}

val builderType = interfaceDec().build {
    publicModifier()
    name("com.mypackage.Builder")
    methods(build)
}
```

## Enum Declaration

```kotlin
val enumType = enumDec().build {
    publicModifier()
    name("com.mypackage.Types")
    entries(
        enumEntry("CLASS"),
        enumEntry("INTERFACE"),
        enumEntry("ENUM")
    )
}
```

## Annotation Declaration

```kotlin
val annotationType = annotationDec().build {
    publicModifier()
    name("com.mypackage.Deprecated")
    properties(annotationProperty(type = Types.STRING, name = "message", defaultValue = ""))
}
```

## Class Declaration

```kotlin
val classType = classDec().build {
    publicModifier()
    name("com.mypackage.Person")
    superClass(Any::class.java)
    fields(fieldDec().build {
        type = Types.STRING
        name = "name"
    })
}
```

## Anonymous Class

Anonymous classes are very special, from the Java point of view, they have only one constructor which is the same used for the instance creation, but from the JVM point of view, they are just like regular inner classes (which are regular classes).

Because of this, they are a bit harder to define, below is an example of use of Anonymous Classes:

```kotlin
fun anonymous(): AnonymousClass {
    val ctr = constructorDec().build {
        parameters(parameter<String>("str"))
        body = MutableInstructions.create(listOf(
            setThisFieldValue(Types.STRING, "str", accessVariable<String>("str"))
        ))
    }

    val field = fieldDec().build {
        modifiers = setOf(KoresModifier.PRIVATE, KoresModifier.FINAL)
        type = Types.STRING
        name = "str"
    }

    val stringsKtType = Class.forName("kotlin.text.StringsKt")

    val method = methodDec().build {
        annotations(overrideAnnotation())
        publicModifier()
        returnType<Iterator<*>>()
        name = "iterator"
        body(MutableInstructions.create(listOf(
            returnValue(Types.ITERATOR,
                invokeStatic(
                    stringsKtType,
                    Access.STATIC,
                    "iterator",
                    typeSpec(typeOf<CharIterator>(), typeOf<CharSequence>()),
                    listOf(accessThisField(Types.STRING, "str"))
                ))
        )))
    }

    return anonymousClass().build {
        fields(field)
        methods(method)
        constructors(ctr)
        specifiedName = "Iter"
        constructorSpec = ctr.typeSpec
        constructorBody = ctr.body
    }
}

fun anonymousClassUse(): TypeDeclaration {
    val anonymousType = anonymous()
    return classDec().build {
        publicModifier()
        name("com.mypackage.Person")
        superClass(Any::class.java)
        fields(fieldDec().build {
            type = Types.STRING
            name = "name"
        })
        methods(methodDec().build {
            innerTypes(anonymousType)
            type(Types.ITERATOR)
            name("nameIterator")
            body(MutableInstructions.create(listOf(
                returnValue(Types.ITERATOR,
                    invokeSpecial(anonymousType, New(anonymousType), CONSTRUCTOR, anonymousType.constructorSpec, listOf(
                        accessThisField(Types.STRING, "name")
                    ))
                )
            )))
        })
    }
}
```

**Anonymous Classes are not yet supported, see [#1](https://gitlab.com/Kores/Kores/-/issues/1) for more information.