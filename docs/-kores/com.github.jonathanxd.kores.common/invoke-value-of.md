//[Kores](../index.md)/[com.github.jonathanxd.kores.common](index.md)/[invokeValueOf](invoke-value-of.md)



# invokeValueOf  
[jvm]  
Content  
fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[invokeValueOf](invoke-value-of.md)(arg: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Invokes Y Y.valueOf(X) static method of receiver [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) that accepts the primitive variant of [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).



Where Y is the wrapper type of [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) (or itself) and X the primitive type of [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) (or itself).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.common//invokeValueOf/java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>arg| <a name="com.github.jonathanxd.kores.common//invokeValueOf/java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Argument to get value from.<br><br>
  
  



