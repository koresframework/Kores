[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [EnumEntry](.)

# EnumEntry

`data class EnumEntry : `[`ArgumentHolder`](../-argument-holder/index.md)`, `[`Named`](../-named/index.md)`, `[`ElementsHolder`](../-elements-holder/index.md)

Enumeration entry.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-argument-holder/-builder/index.md)`<EnumEntry, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-named/-builder/index.md)`<EnumEntry, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-elements-holder/-builder/index.md)`<EnumEntry, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `EnumEntry(name: String, constructorSpec: `[`TypeSpec`](../-type-spec/index.md)`?, arguments: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>, staticBlock: `[`StaticBlock`](../-static-block/index.md)`, fields: List<`[`FieldDeclaration`](../-field-declaration/index.md)`>, constructors: List<`[`ConstructorDeclaration`](../-constructor-declaration/index.md)`>, methods: List<`[`MethodDeclaration`](../-method-declaration/index.md)`>, innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>)`<br>Enumeration entry. |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `val arguments: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>`<br>Enum constructor arguments |
| [array](array.md) | `val array: Boolean`<br>Array arguments |
| [constructorSpec](constructor-spec.md) | `val constructorSpec: `[`TypeSpec`](../-type-spec/index.md)`?`<br>Enum constructor specification. Null for default enum constructor. |
| [constructors](constructors.md) | `val constructors: List<`[`ConstructorDeclaration`](../-constructor-declaration/index.md)`>`<br>Constructor declaration |
| [fields](fields.md) | `val fields: List<`[`FieldDeclaration`](../-field-declaration/index.md)`>`<br>Fields of the type. |
| [innerTypes](inner-types.md) | `val innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>`<br>Inner types |
| [methods](methods.md) | `val methods: List<`[`MethodDeclaration`](../-method-declaration/index.md)`>`<br>Methods of type |
| [name](name.md) | `val name: String`<br>Name |
| [staticBlock](static-block.md) | `val staticBlock: `[`StaticBlock`](../-static-block/index.md)<br>Static block |
| [types](types.md) | `val types: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Expected types of each argument |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
