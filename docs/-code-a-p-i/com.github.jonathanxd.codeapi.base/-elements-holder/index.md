[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ElementsHolder](.)

# ElementsHolder

`interface ElementsHolder : `[`InnerTypesHolder`](../-inner-types-holder/index.md)

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : ElementsHolder, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../-inner-types-holder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [constructors](constructors.md) | `abstract val constructors: List<`[`ConstructorDeclaration`](../-constructor-declaration/index.md)`>`<br>Constructor declaration |
| [fields](fields.md) | `abstract val fields: List<`[`FieldDeclaration`](../-field-declaration/index.md)`>`<br>Fields of the type. |
| [methods](methods.md) | `abstract val methods: List<`[`MethodDeclaration`](../-method-declaration/index.md)`>`<br>Methods of type |
| [staticBlock](static-block.md) | `abstract val staticBlock: `[`StaticBlock`](../-static-block/index.md)<br>Static block |

### Inherited Properties

| Name | Summary |
|---|---|
| [innerTypes](../-inner-types-holder/inner-types.md) | `abstract val innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>`<br>Inner types |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<ElementsHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [EnumEntry](../-enum-entry/index.md) | `data class EnumEntry : `[`ArgumentsHolder`](../-arguments-holder/index.md)`, `[`Named`](../-named/index.md)`, ElementsHolder`<br>Enumeration entry. |
| [TypeDeclaration](../-type-declaration/index.md) | `interface TypeDeclaration : `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`, `[`QualifiedNamed`](../-qualified-named/index.md)`, `[`GenericSignatureHolder`](../-generic-signature-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)`, ElementsHolder`<br>Base class of all [TypeDeclaration](../-type-declaration/index.md)s like classes, interfaces and enums, and inner classes. |
