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

### Creating your first class

###### Static Imports
```Java
import static com.github.jonathanxd.codeapi.CodeAPI.*;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.*;
import static java.lang.reflect.Modifier.*;
```

###### Creating a class
```Java

CodeSource source = source();
// Modifiers, Full Qualified Name
CodeClass myClass = aClass(PUBLIC, "mypackage.MyClass");

source.add(myClass);

```

###### Creating a class with constructor
```Java
// Modifiers, Full Qualified Name, CodeClass -> CodeSource
CodeClass myClass = aClass(PUBLIC, "mypackage.MyClass", codeClass -> sourceOfParts(
  // Modifiers, Declaring Class
  constructor(PUBLIC, codeClass)
));
```

###### Printing hello world in constructor
```Java
// Modifiers, Full Qualified Name, CodeClass -> CodeSource
CodeClass myClass = aClass(PUBLIC, "mypackage.MyClass", codeClass -> sourceOfParts(
  // Modifiers, Declaring Class, CodeConstructor -> CodeSource
  constructor(PUBLIC, codeClass, codeConstructor -> sourceOfParts(
    // Target (variable, method, etc...), Class of method, Method Description, Arguments
    invokeVirtual(
        // Class of Field, Type of Field, Name of field.
        accessStaticField(System.class, PrintStream.class, "out"),
        // Class of method
        PrintStream.class,
        // Method Name
        "println",
        // Method Description (ReturnType, ArgumentsTypes...)
        new TypeSpec(VOID, STRING),
        // Arguments (String Literal)
        argument(Literals.STRING("Hello, world!")))
  ))
));
```

###### Generating PlainSource

```Java
PlainSourceGenerator plainSourceGenerator = PlainSourceGenerator.INSTANCE;

String plainSource = plainSourceGenerator.gen(source);
```

**Print Source**: `System.out.println(plainSource);`

###### Generating Bytecode
```Java
BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();

Byte[] bytecode = bytecodeGenerator.gen(source).getResult();
```

###### Loading class
Class Loader:
```Java
private static final class BCLoader extends ClassLoader {

    public Class<?> define(CodeInterface codeInterface, byte[] bytes) {
        return super.defineClass(codeInterface.getQualifiedName(), bytes, 0, bytes.length);
    }
}
```

**Define & Call Constructor**

```Java
byte[] bytes = PrimitiveArrayConverter.toPrimitive(bytecode);

BCLoader bytecodeLoader = new BCLoader();

Class<?> cl = bytecodeLoader.define(myClass, bytes);

try {
  cl.newInstance();
} catch (Throwable t) { throw new RuntimeException(t); }

```

**Output**:
```Java
package mypackage ; public class MyClass { public MyClass ( ) { java.lang.System . out . println ( "Hello, world!" ) ; } }
```

`Hello, world!`

**Obs:** CodeAPI doens't format the code.

### The `Helper` Class

Helper class works like a factory class, but only helps the object creation. With the Helper methods you can create Instructions. (method invocation, variable definition, if, else...).

### Limitations

Some `CodePart`s may not work in Bytecode Generator or Source Generator because it's not implemented (bytecode) or cannot be implemented (Java Lang Specification).

###### InvokeDynamic

CodeAPI supports invokedynamic instructions, at the time, invokedynamic is partially implemented, and CodeAPI only supports Lambdas InvokeDynamic. (generated as lambdas expressions in PlainSource Generator).

###### Plain Source and Bytecode

Features supported only by Plain Source Generator:

- Inner classes
- Free Expressions (expression(NEW, ...))
- Variables with same name in differents code blocks (`try { String value; } catch(Exception e){} String value;`).

Features supported only by Bytecode Generator:

- Overloaded Return Types
- Overloaded Field Types
- Overloaded Local Variable Types
- Run method with checked exceptions without Try-Chatch-Block
- Reserved Names as names of elements. (Methods, Fields, Variables)

###### Bytecode Generator Limitations

Bytecode generator cannot:

- Generate Local Variables names (Variable names is stored in `common.MVData`)
- Generate Variables with same name and type (for example, a `String value` inside Try-Chatch-Block and same variable outside of that: `try { String value; } catch(Exception e){} String value;`).
- Generate Complex If Statements (`if(x || y && (u && (i || v)))`), at the time, basic if statements is supported, like: `x || y, y && x || z`.

### Performance

CodeAPI is an Abstract representation of ALL elements of Java, it has a cost, **complex classes** may take a **long** time to be generated.
