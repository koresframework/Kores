# Getting Started
In this guide we will be using Kores base library and Kores-BytecodeWriter and Kores-SourceWriter modules. Kores base module provides AST, but can't produce code by itself.

## Dependencies

Kores uses GitLab Packages to provide artifacts (because [Github does not support unauthenticated downloads yet](https://github.community/t/download-from-github-package-registry-without-authentication/14407/129) and jitpack does not support recent jdks):

Then configure the `build.gradle.kts` to include Kores Repositories and dependecies:

```gradle
repositories {
    mavenCentral()
    maven(url = "https://gitlab.com/api/v4/projects/28895078/packages/maven")
    maven(url = "https://gitlab.com/api/v4/projects/28905629/packages/maven")
    maven(url = "https://gitlab.com/api/v4/projects/28894889/packages/maven")
    maven(url = "https://gitlab.com/api/v4/projects/28905266/packages/maven")
    maven(url = "https://gitlab.com/api/v4/projects/28905428/packages/maven")
}

dependencies {
    implementation("com.koresframework:kores:4.2.4.base")
    implementation("com.koresframework:kores-bytecodewriter:4.2.4.bytecode")
    implementation("com.koresframework:kores-sourcewriter:4.2.4.source")
}
```

> GitHub Packages and Jitpack support was not entirely dropped, at the moment we are just not using them because of their limitations, such as GitHub not allowing unauthenticated artifact download and JitPack not supporting all JDKs.

## Your first class

Kores provides 5 (6 in recent versions with Record) different kinds of class declaration:

- ClassDeclaration
- InterfaceDeclaration
- EnumDeclaration
- AnonymousClassDeclaration
- AnnotationDeclaration

Let's get started with the class declaration:

```kotlin
val personDeclaration = ClassDeclaration.Builder.builder()
    .name("Person")
    .build()
```

Now we are going to use the Kores-SourceWriter to render this declaration into a Java class:

```kotlin
val sourceGenerator = PlainSourceGenerator()
val source = sourceGenerator.process(personDeclaration)
println(source)
```

The result would be:

```java
public class Person {
}
```

By default, Kores uses `public` modifier for all types, to generate a package-private class you need to use `PACKAGE_PRIVATE` modifier:

```kotlin
val personDeclaration = ClassDeclaration.Builder.builder()
    .modifiers(KoresModifier.PACKAGE_PRIVATE)
    .name("Person")
    .build()
```

Which renders to:

```java
class Person {
}
```

### Adding some fields

Adding new fields are very simple:

```kotlin
val nameFieldDeclaration = FieldDeclaration.Builder.builder()
    .modifiers(KoresModifier.PRIVATE, KoresModifier.FINAL)
    .type(Types.STRING)
    .name("name")
    .build()

val personDeclaration = ClassDeclaration.Builder.builder()
    .name("Person")
    .fields(nameFieldDeclaration)
    .build()

val sourceGenerator = PlainSourceGenerator()
val source = sourceGenerator.process(personDeclaration)

println(source)
```

Result:

```java
public class Person {

    private final String name;
}
```

### Constructor

Now we need to have a constructor in order to define our field (which is final):

```kotlin
val nameFieldDeclaration = FieldDeclaration.Builder.builder()
    .modifiers(KoresModifier.PRIVATE, KoresModifier.FINAL)
    .type(Types.STRING)
    .name("name")
    .build()

val constructorDeclaration = ConstructorDeclaration.Builder.builder()
    .build()

val personDeclaration = ClassDeclaration.Builder.builder()
    .name("Person")
    .fields(nameFieldDeclaration)
    .constructors(constructorDeclaration)
    .build()

val sourceGenerator = PlainSourceGenerator()
val source = sourceGenerator.process(personDeclaration)

println(source)
```

Result:

```java
public class Person {

    private final String name;

    public Person() {
    }
}
```

### Declaring the field and constructor parameters

Now that we have a field and a constructor, we need to define the field value to be the same as the constructor parameter value, first we need the parameter, so let's modify our constructor declaration:

```kotlin
val constructorDeclaration = ConstructorDeclaration.Builder.builder()
    .parameters(
        KoresParameter.Builder.builder()
            .type(Types.STRING)
            .name("name")
            .build()
    )
    .build()
```

And then provide a body for the constructor with the instructions which reads the parameter and sets the field:

```kotlin
val constructorDeclaration = ConstructorDeclaration.Builder.builder()
    .parameters(
        KoresParameter.Builder.builder()
            .type(Types.STRING)
            .name("name")
            .build()
    )
    .body(MutableInstructions.create(listOf(
        setThisFieldValue(Types.STRING, "name", accessVariable(Types.STRING, "name"))
    )))
    .build()
```

The full code is:

```kotlin
val nameFieldDeclaration = FieldDeclaration.Builder.builder()
    .modifiers(KoresModifier.PRIVATE, KoresModifier.FINAL)
    .type(Types.STRING)
    .name("name")
    .build()

val constructorDeclaration = ConstructorDeclaration.Builder.builder()
    .parameters(
        KoresParameter.Builder.builder()
            .type(Types.STRING)
            .name("name")
            .build()
    )
    .body(MutableInstructions.create(listOf(
        setThisFieldValue(Types.STRING, "name", accessVariable(Types.STRING, "name"))
    )))
    .build()

val personDeclaration = ClassDeclaration.Builder.builder()
    .name("Person")
    .fields(nameFieldDeclaration)
    .constructors(constructorDeclaration)
    .build()

val sourceGenerator = PlainSourceGenerator()
val source = sourceGenerator.process(personDeclaration)

println(source)
```

And the result:

```java
public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }
}
```

### Your first method

Now we need a getter in order to retrieve the field value, for this one we will be using the `MethodDeclaration` class:

```kotlin
val getterDeclaration = MethodDeclaration.Builder.builder()
    .publicModifier()
    .type(Types.STRING)
    .name("getName")
    .body(MutableInstructions.create(listOf(
        returnValue(accessThisField(Types.STRING, "name"))
    )))
    .build()
```

And the full code is:
```kotlin
val nameFieldDeclaration = FieldDeclaration.Builder.builder()
    .modifiers(KoresModifier.PRIVATE, KoresModifier.FINAL)
    .type(Types.STRING)
    .name("name")
    .build()

val constructorDeclaration = ConstructorDeclaration.Builder.builder()
    .parameters(
        KoresParameter.Builder.builder()
            .type(Types.STRING)
            .name("name")
            .build()
    )
    .body(MutableInstructions.create(listOf(
        setThisFieldValue(Types.STRING, "name", accessVariable(Types.STRING, "name"))
    )))
    .build()

val getterDeclaration = MethodDeclaration.Builder.builder()
    .publicModifier()
    .type(Types.STRING)
    .name("getName")
    .body(MutableInstructions.create(listOf(
        returnValue(accessThisField(Types.STRING, "name"))
    )))
    .build()

val personDeclaration = ClassDeclaration.Builder.builder()
    .name("Person")
    .fields(nameFieldDeclaration)
    .constructors(constructorDeclaration)
    .methods(getterDeclaration)
    .build()

val sourceGenerator = PlainSourceGenerator()
val source = sourceGenerator.process(personDeclaration)

println(source)
```

And the result:

```java
public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
```

### Bytecode Generation

In this guide we have not used the BytecodeWriter yet, so let's try it:

```kotlin
val nameFieldDeclaration = FieldDeclaration.Builder.builder()
    .modifiers(KoresModifier.PRIVATE, KoresModifier.FINAL)
    .type(Types.STRING)
    .name("name")
    .build()

val constructorDeclaration = ConstructorDeclaration.Builder.builder()
    .parameters(
        KoresParameter.Builder.builder()
            .type(Types.STRING)
            .name("name")
            .build()
    )
    .body(MutableInstructions.create(listOf(
        setThisFieldValue(Types.STRING, "name", accessVariable(Types.STRING, "name"))
    )))
    .build()

val getterDeclaration = MethodDeclaration.Builder.builder()
    .publicModifier()
    .type(Types.STRING)
    .name("getName")
    .body(MutableInstructions.create(listOf(
        returnValue(accessThisField(Types.STRING, "name"))
    )))
    .build()

val personDeclaration = ClassDeclaration.Builder.builder()
    .name("Person")
    .fields(nameFieldDeclaration)
    .constructors(constructorDeclaration)
    .methods(getterDeclaration)
    .build()

val sourceGenerator = PlainSourceGenerator()
val source = sourceGenerator.process(personDeclaration)

println(source)

val bytecodeGenerator = BytecodeGenerator()

// bytecodeClasses: Here we have a List<BytecodeClass>, every BytecodeClass stores its declaration 
// and the produced bytecode in the BytecodeClass.bytecode array.
// You can save those bytes and inspect them using bytecode inspection tools like
// Textifier, ASMifier, BytecodeDisassembler, javap or even a decompiler
// The disassembled version is available through BytecodeClass.disassembledCode as well, which uses
// the BytecodeDisassembler tool.
val bytecodeClasses = bytecodeGenerator.process(personDeclaration)

// Create a ClassLoader using the current as a parent loader
// this loader has the utilities to load BytecodeClasses
val loader = CodeClassLoader()
// `define` receives the BytecodeClass list to load, but outputs only one defined class.
// It takes a List because the `process` outputs inner classes as well as anonymous classes,
// that should not be used directly.
// You can define classes individually by looping through every one and calling loader.define
val generatedClass = loader.define(bytecodeClasses)
// generatedClass: Here is the loaded class
```

Let see if the class is working:

```kotlin
val lookup = MethodHandles.publicLookup()
val constructor = lookup.findConstructor(generatedClass, MethodType.methodType(Void.TYPE, String::class.java))
val getName = lookup.findVirtual(generatedClass, "getName", MethodType.methodType(String::class.java))
val personInstance = constructor.invokeWithArguments("Foo")
val personName = getName.bindTo(personInstance).invokeExact() as String
println(personName)
```

Outputs:
```
Foo
```

### Considerations

#### Additional Type Information

It is important to note that you need to provide a bunch of information, such as field type, variable type, and so on, even though those values are not used in the source code generator, this is needed in order to bytecode generator work. Java VM (JVM) implementations are strongly-typed oriented, even when we start talking about its `invokedynamic` capabilities. Because of this, the JVM needs to know every type upfront, it includes field types and variable types. At bytecode level, you could have more than one field and variable with the same name but different types.

And, the other important thing to know is that some Kores helper methods are able to "determine" the type based on provided instructions, like the `returnValue` helper that creates the `Return` instruction, it takes a `TypedInstruction` that does have a known type.

#### JVM Intrinsics

Even though there is a bunch of JVM Languages, like [Scala](https://www.scala-lang.org), [Groovy](https://groovy-lang.org), [Kotlin](https://kotlinlang.org), [Ceylon](http://ceylon-lang.org/), [Golo](https://golo-lang.org), [Gosu](https://gosu-lang.github.io), [Clojure](https://clojure.org), [Mirah](https://github.com/mirah/mirah), and Languages that targets JVM like [Haxe](https://haxe.org), and runtime implementations of other languages in JVM, like [JRuby](https://www.jruby.org), [Jython](https://www.jython.org), [Eta](https://eta-lang.org), [Reijin](https://www.renjin.org), [FastR](https://github.com/oracle/fastr) and [Graal.js](https://github.com/oracle/graaljs) (just to list **some** of them), the majority of JVM implementations (except GraalVM and GraalVM-based ones, which are more polyglot VM implementations) still very Java oriented, in other words, the Class structure is very close to Java needs and VM implementations are very optimized to Java language. So Kores is very Java-oriented as well, it implements AST very likely to what a Java AST would be, but it carries much more information than a regular Java AST carries (like those produced by Lexer and Parser generators).

However, some implementation details are abstracted away in Kores, like anonymous classes and non-static inner classes, as they carry a synthetic constructor that receives the enclosing class (outer type) instance. The other thing that is abstracted is switch-case translation, which have two outcomes: LookupSwitch and TableSwitch, Kores-BytecodeWriter is the one that decides which one to generate. Synthetic method generation for generic classes, concatenation indify, Nest Based Access Control, Lambda InvokeDynamic and Synthetic Methods Generation are also some of the other things that are abstracted and generated automatically by Kores-BytecodeWriter. But all of them are Java-related.

Things that other languages implements, like **inline functions**, **reified generics**, **traits**, **multi-dispatch** are not covered by Kores, instead, other projects that depends on Kores are being developed to cover these cases. This is possible through **Kores Visitors** and the **Builder Pattern** implemented in Kores, which allows you to clone a **Kores AST object**, modify it and build it again. We will be talking about this feature later.

#### Kores vs Truffle

Truffle is a language implementation framework, which aims the GraalVM ecosystem, Kores is an AST for generating Java source code and JVM Bytecode, as well as building the ground for Structure Analysis, Unification of Java Annotation Processor Environment and Java Reflection library, Compilers Implementation, Runtime Code Generators and Compile-Time Code generation.

Kores is a powerful framework to implement JVM Languages, and is being used to implement the [Firefly Language](https://github.com/fireflylang). With Kores, it is very fast to have a functional prototype, the first [Firefly Compiler](https://github.com/FireflyLang/firefly-compiler) prototype was written in 1 day. But extra work is needed in order to implement non-standard features (such as inline methods) because the JVM foundation is around Java, even with the nice `invokedynamic` instruction.

I don't have enough background in Truffle to make any assumptions about it being better or not for language implementation.