[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [unwrap](.)

# unwrap

`tailrec fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.unwrap(): `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)

Unwraps [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md) if is a [InstructionWrapper](#) or return receiver if not.

This functions recursively unwraps [InstructionWrapper](#), the operation is executed until
`(receiver = InstructionWrapper.wrappedInstruction) is InstructionWrapper`

