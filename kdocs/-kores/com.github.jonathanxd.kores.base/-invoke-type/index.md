//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[InvokeType](index.md)

# InvokeType

[jvm]\
enum [InvokeType](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[InvokeType](index.md)> 

Type of the invocation. In JVM, the invocation type depends on where the element is declared and which modifiers it has. [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md) is used to invoke instance methods in classes, [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md) is used to invoke interface methods in interfaces, a special opcode is required for methods declared in interface because JVM needs to resolve the position of the method in the method table. [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md) is used for invocation of static methods, does not matter where it is declared or if it is private. [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md) is used to invoke constructors, super constructors and for private methods, for private methods, [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md) is required because [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md) will always call the method of current class, which is bad for private methods, because class inheritance can hide the private method and can cause a unexpected behavior.

## Entries

| | |
|---|---|
| [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md) | [jvm]<br>[INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md)()<br>Interface method invocation. |
| [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md) | [jvm]<br>[INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md)()<br>Special invocation. |
| [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md) | [jvm]<br>[INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md)()<br>Virtual method invocation (instance methods). |
| [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md) | [jvm]<br>[INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md)()<br>Static method invocation. |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [isInterface](is-interface.md) | [jvm]<br>fun [isInterface](is-interface.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md). |
| [isSpecial](is-special.md) | [jvm]<br>fun [isSpecial](is-special.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md). |
| [isStatic](is-static.md) | [jvm]<br>fun [isStatic](is-static.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md). |
| [isVirtual](is-virtual.md) | [jvm]<br>fun [isVirtual](is-virtual.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md). |
| [toDynamicInvokeType](to-dynamic-invoke-type.md) | [jvm]<br>fun [toDynamicInvokeType](to-dynamic-invoke-type.md)(): [DynamicInvokeType](../-dynamic-invoke-type/index.md) |

## Properties

| Name | Summary |
|---|---|
| [name](index.md#1867273046%2FProperties%2F-1216412040) | [jvm]<br>val [name](index.md#1867273046%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](index.md#-1010775000%2FProperties%2F-1216412040) | [jvm]<br>val [ordinal](index.md#-1010775000%2FProperties%2F-1216412040): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
