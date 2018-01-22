[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ArgumentsHolder](.)

# ArgumentsHolder

`interface ArgumentsHolder : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

Hold arguments.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : ArgumentsHolder, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `abstract val arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Argument list |
| [array](array.md) | `abstract val array: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [types](types.md) | `abstract val types: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>Expected types of each argument |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<ArgumentsHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [AnonymousClass](../-anonymous-class/index.md) | `data class AnonymousClass : `[`TypeDeclaration`](../-type-declaration/index.md)`, `[`SuperClassHolder`](../-super-class-holder/index.md)`, ArgumentsHolder, `[`ImplementationHolder`](../-implementation-holder/index.md)`, `[`ConstructorsHolder`](../-constructors-holder/index.md)<br>Anonymous class, they can be defined like all other classes, but some generators may not support all definitions (like multiple [implementations](../-anonymous-class/implementations.md)). |
| [ArrayConstructor](../-array-constructor/index.md) | `data class ArrayConstructor : ArgumentsHolder, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Constructs an array of type [arrayType](../-array-constructor/array-type.md) with dimensions [dimensions](../-array-constructor/dimensions.md). Example: |
| [DynamicMethodSpec](../../com.github.jonathanxd.codeapi.common/-dynamic-method-spec/index.md) | `data class DynamicMethodSpec : `[`Typed`](../-typed/index.md)`, `[`Named`](../-named/index.md)`, ArgumentsHolder` |
| [EnumEntry](../-enum-entry/index.md) | `data class EnumEntry : `[`Annotable`](../-annotable/index.md)`, ArgumentsHolder, `[`Named`](../-named/index.md)`, `[`ElementsHolder`](../-elements-holder/index.md)<br>Enumeration entry. |
| [LambdaLocalCodeBase](../-invoke-dynamic-base/-lambda-local-code-base/index.md) | `interface LambdaLocalCodeBase : `[`LambdaMethodRefBase`](../-invoke-dynamic-base/-lambda-method-ref-base/index.md)`, ArgumentsHolder`<br>Invocation of lambda function. |
| [LambdaMethodRefBase](../-invoke-dynamic-base/-lambda-method-ref-base/index.md) | `interface LambdaMethodRefBase : `[`InvokeDynamicBase`](../-invoke-dynamic-base/index.md)`, ArgumentsHolder`<br>Dynamic invocation of lambda method reference. |
| [MethodInvocation](../-method-invocation/index.md) | `data class MethodInvocation : `[`Accessor`](../-accessor/index.md)`, ArgumentsHolder, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Invokes a method. |
