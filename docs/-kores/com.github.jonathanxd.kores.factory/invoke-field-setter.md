//[Kores](../index.md)/[com.github.jonathanxd.kores.factory](index.md)/[invokeFieldSetter](invoke-field-setter.md)



# invokeFieldSetter  
[jvm]  
Content  
fun [invokeFieldSetter](invoke-field-setter.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Invoke setter of a field (set+capitalize(fieldName)) with value.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>invokeType| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Type of invocation<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>localization| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Localization of setter<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>target| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Target of invocation<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>type| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Type of field.<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>name| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Name of field.<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>value| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Value to pass to setter<br><br>
  
  


[jvm]  
Content  
fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[invokeFieldSetter](invoke-field-setter.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Invoke setter of a field (set+capitalize(fieldName)) of [receiver](../com.github.jonathanxd.kores/-instruction/index.md) with value.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>invokeType| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Type of invocation<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>localization| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Localization of setter<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>type| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Type of field.<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>name| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Name of field.<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>value| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Value to pass to setter<br><br>
  
  


[jvm]  
Content  
fun [TypedInstruction](../com.github.jonathanxd.kores.base/-typed-instruction/index.md).[invokeFieldSetter](invoke-field-setter.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Invoke setter of a field (set+capitalize(fieldName)) of [receiver](../com.github.jonathanxd.kores/-instruction/index.md) of [receiver type](../com.github.jonathanxd.kores/type.md) with value.



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>invokeType| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Type of invocation<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>localization| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Localization of setter<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>type| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Type of field.<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>name| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Name of field.<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>value| <a name="com.github.jonathanxd.kores.factory//invokeFieldSetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a><br><br>Value to pass to setter<br><br>
  
  



