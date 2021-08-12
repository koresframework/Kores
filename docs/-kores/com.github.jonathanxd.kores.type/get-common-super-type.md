//[Kores](../../index.md)/[com.github.jonathanxd.kores.type](index.md)/[getCommonSuperType](get-common-super-type.md)

# getCommonSuperType

[jvm]\
fun [getCommonSuperType](get-common-super-type.md)(typeA: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), typeB: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?

Gets common super type of [typeA](get-common-super-type.md) and [typeB](get-common-super-type.md).

This function returns a super class that both [typeA](get-common-super-type.md) and [typeB](get-common-super-type.md) extends from.

If either [typeA](get-common-super-type.md) or [typeB](get-common-super-type.md) is primitive and are not equal, this function returns null.
