//[Kores](../../index.md)/[com.koresframework.kores.common](index.md)/[invokeParse](invoke-parse.md)

# invokeParse

[jvm]\
fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[invokeParse](invoke-parse.md)(arg: [Instruction](../com.koresframework.kores/-instruction/index.md)): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Invokes X Y.parseN(String) static method of receiver [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).

Where X is the primitive type of [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), Y is the wrapper type of [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) and N is the capitalized simple name of [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).

## Parameters

jvm

| | |
|---|---|
| arg | Argument to parse value from. |
