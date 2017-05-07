# CodeAPI Base [![wercker status](https://app.wercker.com/status/5bb68f1c497f4e1cf3ff362874395e6f/s/master "wercker status")](https://app.wercker.com/project/byKey/5bb68f1c497f4e1cf3ff362874395e6f)

Class structure representation.

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