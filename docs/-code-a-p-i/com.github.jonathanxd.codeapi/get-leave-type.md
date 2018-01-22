[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](index.md) / [getLeaveType](.)

# getLeaveType

`fun `[`CodeSource`](-code-source/index.md)`.getLeaveType(): Type?`

Returns the type that this [CodeSource](-code-source/index.md) leaves on stack.

This function analyzes the last instruction of [CodeSource](-code-source/index.md) and infer the type of value leaved on stack.

Examples:

For

```
if (a == 9) {
  "x"
} else {
  "b"
}
```

This returns [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

For

```
if (a == 9) {
  "x"
} else {
  Integer.valueOf(0)
}
```

This returns [Object](#)

but for:

```
if (a == 9) {
  "x"
} else {
}
```

This returns `null`.

`fun `[`CodeInstruction`](-code-instruction.md)`.getLeaveType(): Type?`

Returns the type leaved in stack by this [CodeInstruction](-code-instruction.md)

