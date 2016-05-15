# CodeAPI

Generate Java Source Code and Bytecode

### Why?

90% of the code generators give to you source manipulation (method bodies for example) and cannot generate Bytecode, CodeSource API only gives to you a Abstract Representation of the Instructions and generates bytecode (**Bytecode generation will be implemented after first stable release**).

### Can I manipulate source code?

Not, but you can implement your own Instructions and Generators.

### Basic CodeAPI Classes

- CodeSource
  - Represents a collection of instructions


- CodePart
  - Represents a code instruction


- CodeElement
  - Represents code elements, like Fields, Methods & static blocks.


- CodeRoot
  - Represents a holder of CodeElements

### The `Helper` Class

Helper class works like a factory class, but only helps the object creation. With the Helper methods you can create Instructions. (method invocation, variable definition, if, else...)

### Performance

CodeAPI is an Abstract representation of ALL elements of Java, it has a cost, complex classes may take a **long** time to be generated.
