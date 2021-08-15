//[Kores](../../index.md)/[com.koresframework.kores](index.md)/[getLeaveType](get-leave-type.md)

# getLeaveType

[jvm]\
fun [Instructions](-instructions/index.md).[getLeaveType](get-leave-type.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?

Returns the type that this [Instructions](-instructions/index.md) leaves on stack.

This function analyzes the last instruction of [Instructions](-instructions/index.md) and infer the type of value leaved on stack.

Examples:

For

if (a == 9) {\
  "x"\
} else {\
  "b"\
}

This returns [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

For

if (a == 9) {\
  "x"\
} else {\
  Integer.valueOf(0)\
}

This returns [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)

but for:

if (a == 9) {\
  "x"\
} else {\
}

This returns null.

[jvm]\
fun [Instruction](-instruction/index.md).[getLeaveType](get-leave-type.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?

Returns the type leaved in stack by this [Instruction](-instruction/index.md)
