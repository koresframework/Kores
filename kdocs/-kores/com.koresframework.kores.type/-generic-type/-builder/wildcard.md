//[Kores](../../../../index.md)/[com.koresframework.kores.type](../../index.md)/[GenericType](../index.md)/[Builder](index.md)/[wildcard](wildcard.md)

# wildcard

[jvm]\
abstract fun [wildcard](wildcard.md)(): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)>

See T.isWildcard

Defines as a wildcard type, this method is the same as calling withName("*").

**Note:** **withName("?")** **is invalid because Kores denotes wildcards with** ***** **instead of** **?**

This method will overwrite defined type and name.
