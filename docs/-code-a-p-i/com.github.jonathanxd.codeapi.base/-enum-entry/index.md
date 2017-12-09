[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [EnumEntry](.)

# EnumEntry

`data class EnumEntry : `[`Annotable`](../-annotable/index.md)`, `[`ArgumentsHolder`](../-arguments-holder/index.md)`, `[`Named`](../-named/index.md)`, `[`ElementsHolder`](../-elements-holder/index.md)

Enumeration entry.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-annotable/-builder/index.md)`<EnumEntry, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-arguments-holder/-builder/index.md)`<EnumEntry, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-named/-builder/index.md)`<EnumEntry, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-elements-holder/-builder/index.md)`<EnumEntry, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `EnumEntry(annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../-annotation/index.md)`>, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, constructorSpec: `[`TypeSpec`](../-type-spec/index.md)`?, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>, staticBlock: `[`StaticBlock`](../-static-block/index.md)`, fields: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../-field-declaration/index.md)`>, methods: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../-method-declaration/index.md)`>, innerTypes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../-type-declaration/index.md)`>)`<br>Enumeration entry. |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `val annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../-annotation/index.md)`>`<br>Annotations |
| [arguments](arguments.md) | `val arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Enum constructor arguments |
| [array](array.md) | `val array: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [constructorSpec](constructor-spec.md) | `val constructorSpec: `[`TypeSpec`](../-type-spec/index.md)`?`<br>Enum constructor specification. Null for default enum constructor. |
| [fields](fields.md) | `val fields: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../-field-declaration/index.md)`>`<br>Fields of the type. |
| [innerTypes](inner-types.md) | `val innerTypes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../-type-declaration/index.md)`>`<br>Inner types |
| [methods](methods.md) | `val methods: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../-method-declaration/index.md)`>`<br>Methods of type |
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [staticBlock](static-block.md) | `val staticBlock: `[`StaticBlock`](../-static-block/index.md)<br>Static block |
| [types](types.md) | `val types: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>Expected types of each argument |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [hasDeclarations](../has-declarations.md) | `val EnumEntry.hasDeclarations: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether the EnumEntry has any declaration inside (requires a new type to be created or a body). |
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toRepresentation](../../com.github.jonathanxd.codeapi.util.conversion/to-representation.md) | `fun EnumEntry.toRepresentation(): EnumEntry` |
