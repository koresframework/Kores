//[Kores](../../index.md)/[com.koresframework.kores.inspect](index.md)/[alwaysBranch](always-branch.md)

# alwaysBranch

[jvm]\
fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.koresframework.kores/-instruction/index.md)>.[alwaysBranch](always-branch.md)(matcher: ([Instruction](../com.koresframework.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns true if the body is only reached when [matched](always-branch.md)[Instruction](../com.koresframework.kores/-instruction/index.md) returns true.

**The** **receiver** **list must contains entirely expressions of if statement.**

Examples:

if (x == y && (x % 2 == 0 || x == 3))

<ul><li>[alwaysBranch](always-branch.md) returns true for x == y because whenever the body of the flow is reached, x is equal to y.</li><li>[alwaysBranch](always-branch.md) returns false for x % 2 == 0 because when the body of flow is reached, x % 2 == 0 may or may not be true, the same condition applies to x == 3.</li></ul>

An example of where this function can be useful:

if (a instanceof AccountManager) { body }

You can use this function to ensures that a instanceof AccountManager is always true when body is reached to allow smart casting of a to AccountManager (inside the body).

[jvm]\
fun [IfExpressionHolder](../com.koresframework.kores.base/-if-expression-holder/index.md).[alwaysBranch](always-branch.md)(matcher: ([Instruction](../com.koresframework.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

## See also

jvm

| | |
|---|---|
| [alwaysBranch](always-branch.md) |  |
