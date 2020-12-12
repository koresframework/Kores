//[Kores](../index.md)/[com.github.jonathanxd.kores.common](index.md)/[invokeValue](invoke-value.md)



# invokeValue  
[jvm]  
Content  
fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[invokeValue](invoke-value.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Invokes X Y.nValue() virtual method of type with receiver [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).



Where X is the primitive type of type, Y is the wrapper type of type and n is the de-capitalized simple name of type.

  


[jvm]  
Content  
fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[invokeValue](invoke-value.md)(base: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Invokes X Y.nValue() virtual method of base type with receiver [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).



Where X is the primitive type of type, Y is the wrapper type of base and n is the de-capitalized simple name of type.



Used in cases like int Byte.intValue().

  



