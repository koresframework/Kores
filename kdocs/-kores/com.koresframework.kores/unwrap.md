//[Kores](../../index.md)/[com.koresframework.kores](index.md)/[unwrap](unwrap.md)

# unwrap

[jvm]\
tailrec fun [Instruction](-instruction/index.md).[unwrap](unwrap.md)(): [Instruction](-instruction/index.md)

Unwraps [Instruction](-instruction/index.md) if is a InstructionWrapper or return receiver if not.

This functions recursively unwraps InstructionWrapper, the operation is executed until (receiver = InstructionWrapper.wrappedInstruction) is InstructionWrapper
