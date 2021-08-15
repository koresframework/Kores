//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[DynamicInvokeType](index.md)

# DynamicInvokeType

[jvm]\
enum [DynamicInvokeType](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[DynamicInvokeType](index.md)> 

TODO Documentation

## Entries

| | |
|---|---|
| [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md) | [jvm]<br>[INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md)()<br>Interface method invocation. |
| [NEW_INVOKE_SPECIAL](-n-e-w_-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md) | [jvm]<br>[NEW_INVOKE_SPECIAL](-n-e-w_-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md)()<br>Special invocation of constructors. |
| [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md) | [jvm]<br>[INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md)()<br>Special invocation. |
| [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md) | [jvm]<br>[INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md)()<br>Virtual method invocation (instance methods). |
| [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md) | [jvm]<br>[INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md)()<br>Static method invocation. |

## Functions

| Name | Summary |
|---|---|
| [isInterface](is-interface.md) | [jvm]<br>fun [isInterface](is-interface.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md). |
| [isNewSpecial](is-new-special.md) | [jvm]<br>fun [isNewSpecial](is-new-special.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [NEW_INVOKE_SPECIAL](-n-e-w_-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md). |
| [isSpecial](is-special.md) | [jvm]<br>fun [isSpecial](is-special.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md). |
| [isStatic](is-static.md) | [jvm]<br>fun [isStatic](is-static.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md). |
| [isVirtual](is-virtual.md) | [jvm]<br>fun [isVirtual](is-virtual.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the InvokeType is [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md). |
| [toInvokeType](to-invoke-type.md) | [jvm]<br>fun [toInvokeType](to-invoke-type.md)(): [InvokeType](../-invoke-type/index.md) |

## Properties

| Name | Summary |
|---|---|
| [name](index.md#202573587%2FProperties%2F-1216412040) | [jvm]<br>val [name](index.md#202573587%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](index.md#-84991157%2FProperties%2F-1216412040) | [jvm]<br>val [ordinal](index.md#-84991157%2FProperties%2F-1216412040): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
