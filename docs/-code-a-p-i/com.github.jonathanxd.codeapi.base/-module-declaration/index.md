[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ModuleDeclaration](.)

# ModuleDeclaration

`data class ModuleDeclaration : `[`Named`](../-named/index.md)

Declaration of a module.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-named/-builder/index.md)`<ModuleDeclaration, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ModuleDeclaration(name: String, requires: List<`[`Require`](../-require/index.md)`>, exports: List<`[`Export`](../-export/index.md)`>, uses: List<`[`ModuleReference`](../-module-reference/index.md)`>, provides: List<`[`Provide`](../-provide/index.md)`>)`<br>Declaration of a module. |

### Properties

| Name | Summary |
|---|---|
| [exports](exports.md) | `val exports: List<`[`Export`](../-export/index.md)`>`<br>Module exports. |
| [moduleReference](module-reference.md) | `val moduleReference: `[`ModuleReference`](../-module-reference/index.md)<br>Module reference. |
| [name](name.md) | `val name: String`<br>Module name. |
| [provides](provides.md) | `val provides: List<`[`Provide`](../-provide/index.md)`>`<br>Module service provides. |
| [requires](requires.md) | `val requires: List<`[`Require`](../-require/index.md)`>`<br>Module requires. |
| [uses](uses.md) | `val uses: List<`[`ModuleReference`](../-module-reference/index.md)`>`<br>Module service uses. |

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
