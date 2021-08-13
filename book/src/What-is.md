# What is

Kores Framework (named as CodeAPI earlier) is a library that provides AST ([Abstract Syntax Tree](https://en.wikipedia.org/wiki/Abstract_syntax_tree)) for Java and JVM classes and modules. With Kores AST Definitions you can produce **Java Source Code** using [**Kores-SourceWriter**](https://github.com/koresframework/Kores-SourceWriter) transpiler and **JVM Bytecode** using [**Kores-BytecodeWriter**](https://github.com/koresframework/Kores-BytecodeWriter) compiler.

## Why?

Initially, Kores was a toy project to learn JVM Bytecode and create a common structure for compile-time and runtime code generation, focused on **Annotation Processors**. Later, Kores evolved to more likely a JVM Bytecode compiler ecosystem, more focused on **JVM Bytecode Generation** than in **Java Source Generation**.

Kores bytecode generation module tries to generate bytecode as close as possible to **javac**, with some exceptions, like [**not generating inner class definition for every used inner class**](https://stackoverflow.com/a/48603069) as specified in second paragraph of [JVMS 4.7.6](https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.6). There is likely no popular JVM Implementation that does check for this (or no one of them check at all) or use this kind of information for something in fact, this is only a specification that is followed by **javac**.

## Projects that uses Kores

- [EventSys](https://github.com/ProjectSandstone/EventSys)
    - A dynamic property base event system written on top of Kores

- [CodeProxy](https://github.com/JonathanxD/CodeProxy)
    - A Proxy generator written on top of Kores, the key difference between Java proxies is that CodeProxies can extend classes.

- [AdapterHelper](https://github.com/JonathanxD/AdapterHelper)
    - A set of utilities to help with creation, registration and management of Adapters, some features requires Kores, such as deep instance adapting.

- [FireflyLang Compiler](https://github.com/FireflyLang/firefly-compiler)
  - A proof-of-concept language that implements type-reification, traits, rules, and so on.

## Applications

Kores could be used in compilers, runtime code generators, compile-time code generators (and mixed generators through the common AST). However, Kores is not focused on providing instrumentation of already compiled classes. There was an attempt to provide this functionality through [Kores-BytecodeReader](https://github.com/koresframework/Kores-BytecodeReader) but maintenance and implementation stopped to focus on code generation.

Also, Kores AST could be serialized and deserialized using [Kotlinx Serialization Library](https://github.com/Kotlin/kotlinx.serialization), providing easy way to compilers store and retrieve metadata about classes, including method inlining and Type Reification without Bytecode Manipulation.