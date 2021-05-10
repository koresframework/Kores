//[Kores](../index.md)/[com.github.jonathanxd.kores.factory](index.md)/[invokeFieldGetter](invoke-field-getter.md)



# invokeFieldGetter  
[jvm]  
Content  
fun [invokeFieldGetter](invoke-field-getter.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Invoke getter of a field (get+capitalize(fieldName)).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>invokeType| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Type of invocation<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>localization| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Localization of getter<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>target| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Target of invocation<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>type| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Type of field.<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>name| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#com.github.jonathanxd.kores.Instruction#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Name of field.<br><br>
  
  


[jvm]  
Content  
fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[invokeFieldGetter](invoke-field-getter.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Invoke getter of a field (get+capitalize(fieldName)) of [receiver](../com.github.jonathanxd.kores/-instruction/index.md).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>invokeType| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Type of invocation<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>localization| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Localization of getter<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>type| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Type of field.<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>name| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Name of field.<br><br>
  
  


[jvm]  
Content  
fun [TypedInstruction](../com.github.jonathanxd.kores.base/-typed-instruction/index.md).[invokeFieldGetter](invoke-field-getter.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)  
More info  


Invoke getter of a field (get+capitalize(fieldName)) of [receiver](../com.github.jonathanxd.kores.base/-typed-instruction/index.md) and [receiver type](../com.github.jonathanxd.kores.base/-typed-instruction/index.md#%5Bcom.github.jonathanxd.kores.base%2FTypedInstruction%2Ftype%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1211764316).



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>invokeType| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Type of invocation<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>localization| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Localization of getter<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>type| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Type of field.<br><br>
| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a>name| <a name="com.github.jonathanxd.kores.factory//invokeFieldGetter/com.github.jonathanxd.kores.base.TypedInstruction#com.github.jonathanxd.kores.base.InvokeType#java.lang.reflect.Type#kotlin.String/PointingToDeclaration/"></a><br><br>Name of field.<br><br>
  
  



