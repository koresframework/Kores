# CodeAPI Base [![wercker status](https://app.wercker.com/status/5bb68f1c497f4e1cf3ff362874395e6f/s/master "wercker status")](https://app.wercker.com/project/byKey/5bb68f1c497f4e1cf3ff362874395e6f)

CodeAPI is a framework which provide to developers a way to construct bytecode and source from a common structure, which can grows and can be easily inspected.

## No instructions

CodeAPI provides a structural construction of Java classes, there is no instructions, some special behaviors may be provided via other projects.

## Projects using CodeAPI

CodeAPI 2:

All projects already updated.

CodeAPI 3:

- [EventSys](https://github.com/ProjectSandstone/EventSys)
  - A dynamic property base event system written on top of CodeAPI
  
- [CodeProxy](https://github.com/JonathanxD/CodeProxy)
  - A Proxy generator written on top of CodeAPI, the key difference between Java proxies is that CodeProxies can extend classes.
  
- [AdapterHelper](https://github.com/JonathanxD/AdapterHelper)
  - A set of utilities to help with creation, registration and management of Adapters, some features requires CodeAPI, such as deep instance adapting.

CodeAPI 4:

**Coming soon**

## Performance

In the beginning of CodeAPI, performance was one of the focus, but when I finished CodeAPI 2, I noticed that the performance never was a problem to CodeAPI, I always try to improve performance by looking the performance results (using JMH), the biggest performance problem is not with CodeAPI, but with JVM itself: classloader, classloading take too much time. 

Note for contributors: Performance improvement pull request will be always strictly analyzed, some optimizations that I thought about doing, was not needed because JVM was able to solve the problems in the 3rd-4th time execution of the code.

## Actual focus

CodeAPI changed the focus 2 times, first focus was on writing a full extensible API which generates bytecode and source code from structures, the actual focus, changed on CodeAPI 4, is to write an extensible, but not full extensible, API to construct code structures, validate code structures, modify and inspect structures.

In CodeAPI 4, some interfaces was changed to concrete final classes, I made this decision because if you want a custom `CodePart`, you should fully implement the processor behavior, you is free to chose which interfaces to implement, example, if you are implementing a custom expression which takes arguments and have a body, implements `ArgumentHolder` and `BodyHolder`, but if you want to write a custom method declaration, you should write the processor logic yourself or implement a `SugarSyntaxProcessor` which translates to a MethodDeclaration.

### Base classes

Classes suffixed with `Base` is part of internal API.

## Tutorials

**Coming soon**

## Code Generation and Reading

[BytecodeWriter](https://github.com/JonathanxD/CodeAPI-BytecodeWriter)
[SourceWriter](https://github.com/JonathanxD/CodeAPI-SourceWriter)
[BytecodeReader](https://github.com/JonathanxD/CodeAPI-BytecodeReader)


# Systems

CodeAPI-Base module has 8 systems which may be interdependent:

- Structure (aka `base`)
  - Structure of the code, like classes, methods, fields, variable assignment, etc.
 
- Builder
  - Builder of instances, like structure instances and common classes instances.
  
- Factory
  - Factory of instances, like structure instances and common classes instances.
  
- Conversion
  - Conversions between types, from/to CodeAPI type to/from other types.
  
- Inspection (only `inspect` package)
  - Inspection of `CodeSource` and elements inside `BodyHolder`s.
  
- Generator
  - Generator from CodeAPI types to other types.
  
- Validator
  - CodeAPI types structure validator.
  
- Misc
  - Miscellaneous: cover all other systems, it includes `utility classes`, `modify.visit package`, `helper` classes, etc...