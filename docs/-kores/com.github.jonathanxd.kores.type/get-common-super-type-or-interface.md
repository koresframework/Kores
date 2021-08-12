//[Kores](../../index.md)/[com.github.jonathanxd.kores.type](index.md)/[getCommonSuperTypeOrInterface](get-common-super-type-or-interface.md)

# getCommonSuperTypeOrInterface

[jvm]\
fun [getCommonSuperTypeOrInterface](get-common-super-type-or-interface.md)(typeA: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), typeB: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?

Gets common super type of [typeA](get-common-super-type-or-interface.md) and [typeB](get-common-super-type-or-interface.md).

This function returns a class or an interface that both [typeA](get-common-super-type-or-interface.md) and [typeB](get-common-super-type-or-interface.md) extends from, first the function tries to get a common *super class*, and then a common *interface*.

If [typeA](get-common-super-type-or-interface.md), [typeB](get-common-super-type-or-interface.md) or both are primitive but not equal, null is returned.
