[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [InvokeType](.)

# InvokeType

`enum class InvokeType`

Type of the invocation. In JVM, the invocation type depends on where the element is declared and
which modifiers it has. [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l.md) is used to invoke instance methods in `class`es, [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md)
is used to invoke interface methods in `interface`s, a special opcode is required for methods declared
in `interface` because JVM needs to resolve the position of the method in the method table. [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c.md) is used
for invocation of static methods, does not matter where it is declared or if it is private. [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l.md) is used to invoke
constructors, super constructors and for private methods, for private methods,
[INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l.md) is required because [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l.md) will always call the method of `current class`, which
is bad for private methods, because class inheritance can hide the private method and can cause a unexpected
behavior.

### Enum Values

| Name | Summary |
|---|---|
| [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c.md) | Static method invocation. |
| [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l.md) | Virtual method invocation (instance methods). |
| [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l.md) | Special invocation. |
| [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md) | Interface method invocation. |

### Functions

| Name | Summary |
|---|---|
| [isInterface](is-interface.md) | `fun isInterface(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md). |
| [isSpecial](is-special.md) | `fun isSpecial(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l.md). |
| [isStatic](is-static.md) | `fun isStatic(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c.md). |
| [isVirtual](is-virtual.md) | `fun isVirtual(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l.md). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [get](get.md) | `fun get(type: Type?): InvokeType`<br>Get InvokeType corresponding to the [type](get.md#com.github.jonathanxd.codeapi.base.InvokeType.Companion$get(java.lang.reflect.Type)/type). If [type](get.md#com.github.jonathanxd.codeapi.base.InvokeType.Companion$get(java.lang.reflect.Type)/type) is null, [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c.md), if [type](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-interface.md), [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md), if not, [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l.md). |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
