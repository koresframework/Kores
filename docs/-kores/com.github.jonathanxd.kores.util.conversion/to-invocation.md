//[Kores](../index.md)/[com.github.jonathanxd.kores.util.conversion](index.md)/[toInvocation](to-invocation.md)



# toInvocation  
[jvm]  
Content  
fun [MethodTypeSpec](../com.github.jonathanxd.kores.common/-method-type-spec/index.md).[toInvocation](to-invocation.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Create [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md) from [MethodTypeSpec](../com.github.jonathanxd.kores.common/-method-type-spec/index.md)



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/com.github.jonathanxd.kores.common.MethodTypeSpec#com.github.jonathanxd.kores.base.InvokeType#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>invokeType| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/com.github.jonathanxd.kores.common.MethodTypeSpec#com.github.jonathanxd.kores.base.InvokeType#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a><br><br>Type of invocation.<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/com.github.jonathanxd.kores.common.MethodTypeSpec#com.github.jonathanxd.kores.base.InvokeType#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>target| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/com.github.jonathanxd.kores.common.MethodTypeSpec#com.github.jonathanxd.kores.base.InvokeType#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a><br><br>Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../com.github.jonathanxd.kores/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)).<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/com.github.jonathanxd.kores.common.MethodTypeSpec#com.github.jonathanxd.kores.base.InvokeType#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>arguments| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/com.github.jonathanxd.kores.common.MethodTypeSpec#com.github.jonathanxd.kores.base.InvokeType#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a><br><br>Arguments to pass to method.<br><br>
  
  


[jvm]  
Content  
fun [MethodInvokeSpec](../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md).[toInvocation](to-invocation.md)(target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Create [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md) from [MethodInvokeSpec](../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/com.github.jonathanxd.kores.common.MethodInvokeSpec#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>target| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/com.github.jonathanxd.kores.common.MethodInvokeSpec#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a><br><br>Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../com.github.jonathanxd.kores/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)).<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/com.github.jonathanxd.kores.common.MethodInvokeSpec#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>arguments| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/com.github.jonathanxd.kores.common.MethodInvokeSpec#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a><br><br>Arguments to pass to method.<br><br>
  
  


[jvm]  
Content  
fun [Executable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Executable.html).[toInvocation](to-invocation.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md)?, target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Create [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md) from [Executable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Executable.html)



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/java.lang.reflect.Executable#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>invokeType| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/java.lang.reflect.Executable#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a><br><br>Type of invocation, if null, Kores will try to infer the invocation type.<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/java.lang.reflect.Executable#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>target| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/java.lang.reflect.Executable#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a><br><br>Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../com.github.jonathanxd.kores/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)).<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/java.lang.reflect.Executable#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>arguments| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/java.lang.reflect.Executable#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a><br><br>Arguments to pass to method.<br><br>
  
  


[jvm]  
Content  
fun [ExecutableElement](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/ExecutableElement.html).[toInvocation](to-invocation.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md)?, target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>, elements: [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Create [ExecutableElement](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/ExecutableElement.html) from [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html)



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/javax.lang.model.element.ExecutableElement#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#javax.lang.model.util.Elements/PointingToDeclaration/"></a>invokeType| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/javax.lang.model.element.ExecutableElement#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#javax.lang.model.util.Elements/PointingToDeclaration/"></a><br><br>Type of invocation, if null, Kores will try to infer the invocation type.<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/javax.lang.model.element.ExecutableElement#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#javax.lang.model.util.Elements/PointingToDeclaration/"></a>target| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/javax.lang.model.element.ExecutableElement#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#javax.lang.model.util.Elements/PointingToDeclaration/"></a><br><br>Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../com.github.jonathanxd.kores/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)).<br><br>
| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/javax.lang.model.element.ExecutableElement#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#javax.lang.model.util.Elements/PointingToDeclaration/"></a>arguments| <a name="com.github.jonathanxd.kores.util.conversion//toInvocation/javax.lang.model.element.ExecutableElement#com.github.jonathanxd.kores.base.InvokeType?#com.github.jonathanxd.kores.Instruction#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]#javax.lang.model.util.Elements/PointingToDeclaration/"></a><br><br>Arguments to pass to method.<br><br>
  
  



