//[Kores](../index.md)/[com.github.jonathanxd.kores](index.md)/[unwrap](unwrap.md)



# unwrap  
[jvm]  
Content  
tailrec fun [Instruction](-instruction/index.md).[unwrap](unwrap.md)(): [Instruction](-instruction/index.md)  
More info  


Unwraps [Instruction](-instruction/index.md) if is a InstructionWrapper or return receiver if not.



This functions recursively unwraps InstructionWrapper, the operation is executed until (receiver = InstructionWrapper.wrappedInstruction) is InstructionWrapper

  



