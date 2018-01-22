[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](index.md) / [unwrap](.)

# unwrap

`tailrec fun `[`CodeInstruction`](-code-instruction.md)`.unwrap(): `[`CodeInstruction`](-code-instruction.md)

Unwraps [CodeInstruction](-code-instruction.md) if is a [InstructionWrapper](#) or return receiver if not.

This functions recursively unwraps [InstructionWrapper](#), the operation is executed until
`(receiver = InstructionWrapper.wrappedInstruction) is InstructionWrapper`

