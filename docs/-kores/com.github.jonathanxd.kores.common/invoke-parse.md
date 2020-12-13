//[Kores](../index.md)/[com.github.jonathanxd.kores.common](index.md)/[invokeParse](invoke-parse.md)



# invokeParse  
[jvm]  
Content  
fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[invokeParse](invoke-parse.md)(arg: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Invokes X Y.parseN(String) static method of receiver [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).



Where X is the primitive type of [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), Y is the wrapper type of [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) and N is the capitalized simple name of [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.common//invokeParse/java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>arg| <a name="com.github.jonathanxd.kores.common//invokeParse/java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Argument to parse value from.<br><br>
  
  



