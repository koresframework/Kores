//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[InvokeType](../index.md)/[Companion](index.md)/[get](get.md)



# get  
[jvm]  
Content  
@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()  
  
fun [get](get.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?): [InvokeType](../index.md)  
More info  


Get InvokeType corresponding to the type. If type is null, [INVOKE_STATIC](../-i-n-v-o-k-e_-s-t-a-t-i-c/index.md), if com.github.jonathanxd.kores.util.isInterface, [INVOKE_INTERFACE](../-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md), if not, [INVOKE_VIRTUAL](../-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md).



#### Return  


[INVOKE_STATIC](../-i-n-v-o-k-e_-s-t-a-t-i-c/index.md) if null, [INVOKE_INTERFACE](../-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md) if is is an interface, or is not an interface [INVOKE_VIRTUAL](../-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md)



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/InvokeType.Companion/get/#java.lang.reflect.Type?/PointingToDeclaration/"></a>type| <a name="com.github.jonathanxd.kores.base/InvokeType.Companion/get/#java.lang.reflect.Type?/PointingToDeclaration/"></a><br><br>Type<br><br>
  
  



