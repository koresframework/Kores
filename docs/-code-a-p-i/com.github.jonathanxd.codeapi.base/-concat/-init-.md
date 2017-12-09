[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Concat](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`Concat(concatenations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>)`

String concatenation. The result depends on generator, in official BytecodeGenerator a [StringBuilder](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-string-builder/index.html) will be
used to concat values (in a future patch it will be changed to use Java 9 dynamic concatenation), in official
JavaSourceGenerator this will be translated into string concatenation.

