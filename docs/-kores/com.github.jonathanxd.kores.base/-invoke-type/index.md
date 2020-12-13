//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[InvokeType](index.md)



# InvokeType  
 [jvm] enum [InvokeType](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[InvokeType](index.md)> 

Type of the invocation. In JVM, the invocation type depends on where the element is declared and which modifiers it has. [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md) is used to invoke instance methods in classes, [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md) is used to invoke interface methods in interfaces, a special opcode is required for methods declared in interface because JVM needs to resolve the position of the method in the method table. [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md) is used for invocation of static methods, does not matter where it is declared or if it is private. [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md) is used to invoke constructors, super constructors and for private methods, for private methods, [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md) is required because [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md) will always call the method of current class, which is bad for private methods, because class inheritance can hide the private method and can cause a unexpected behavior.

   


## Entries  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/InvokeType.INVOKE_STATIC///PointingToDeclaration/"></a>[INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md)| <a name="com.github.jonathanxd.kores.base/InvokeType.INVOKE_STATIC///PointingToDeclaration/"></a> [jvm] [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md)()  <br>Static method invocation.   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeType.INVOKE_VIRTUAL///PointingToDeclaration/"></a>[INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md)| <a name="com.github.jonathanxd.kores.base/InvokeType.INVOKE_VIRTUAL///PointingToDeclaration/"></a> [jvm] [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md)()  <br>Virtual method invocation (instance methods).   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeType.INVOKE_SPECIAL///PointingToDeclaration/"></a>[INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md)| <a name="com.github.jonathanxd.kores.base/InvokeType.INVOKE_SPECIAL///PointingToDeclaration/"></a> [jvm] [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md)()  <br>Special invocation.   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeType.INVOKE_INTERFACE///PointingToDeclaration/"></a>[INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md)| <a name="com.github.jonathanxd.kores.base/InvokeType.INVOKE_INTERFACE///PointingToDeclaration/"></a> [jvm] [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md)()  <br>Interface method invocation.   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/InvokeType.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.github.jonathanxd.kores.base/InvokeType.Companion///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Enum/compareTo/#com.github.jonathanxd.kores.base.InvokeType/PointingToDeclaration/"></a>[compareTo](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md#%5Bkotlin%2FEnum%2FcompareTo%2F%23com.github.jonathanxd.kores.base.InvokeType%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Enum/compareTo/#com.github.jonathanxd.kores.base.InvokeType/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator override fun [compareTo](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md#%5Bkotlin%2FEnum%2FcompareTo%2F%23com.github.jonathanxd.kores.base.InvokeType%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [InvokeType](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Enum/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-state/-r-e-q-u-i-r-e_-s-u-p-e-r/index.md#%5Bkotlin%2FEnum%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Enum/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator override fun [equals](../../com.github.jonathanxd.kores.util/-state/-r-e-q-u-i-r-e_-s-u-p-e-r/index.md#%5Bkotlin%2FEnum%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Enum/finalize/#/PointingToDeclaration/"></a>[finalize](../../com.github.jonathanxd.kores.util/-state/-r-e-q-u-i-r-e_-s-u-p-e-r/index.md#%5Bkotlin%2FEnum%2Ffinalize%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Enum/finalize/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [finalize](../../com.github.jonathanxd.kores.util/-state/-r-e-q-u-i-r-e_-s-u-p-e-r/index.md#%5Bkotlin%2FEnum%2Ffinalize%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)()  <br><br><br>
| <a name="kotlin/Enum/getDeclaringClass/#/PointingToDeclaration/"></a>[getDeclaringClass](../../com.github.jonathanxd.kores.util/-state/-r-e-q-u-i-r-e_-s-u-p-e-r/index.md#%5Bkotlin%2FEnum%2FgetDeclaringClass%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Enum/getDeclaringClass/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [getDeclaringClass](../../com.github.jonathanxd.kores.util/-state/-r-e-q-u-i-r-e_-s-u-p-e-r/index.md#%5Bkotlin%2FEnum%2FgetDeclaringClass%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[InvokeType](index.md)>  <br><br><br>
| <a name="kotlin/Enum/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-state/-r-e-q-u-i-r-e_-s-u-p-e-r/index.md#%5Bkotlin%2FEnum%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Enum/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>override fun [hashCode](../../com.github.jonathanxd.kores.util/-state/-r-e-q-u-i-r-e_-s-u-p-e-r/index.md#%5Bkotlin%2FEnum%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/InvokeType/isInterface/#/PointingToDeclaration/"></a>[isInterface](is-interface.md)| <a name="com.github.jonathanxd.kores.base/InvokeType/isInterface/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [isInterface](is-interface.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if the InvokeType is [INVOKE_INTERFACE](-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e/index.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/InvokeType/isSpecial/#/PointingToDeclaration/"></a>[isSpecial](is-special.md)| <a name="com.github.jonathanxd.kores.base/InvokeType/isSpecial/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [isSpecial](is-special.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if the InvokeType is [INVOKE_SPECIAL](-i-n-v-o-k-e_-s-p-e-c-i-a-l/index.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/InvokeType/isStatic/#/PointingToDeclaration/"></a>[isStatic](is-static.md)| <a name="com.github.jonathanxd.kores.base/InvokeType/isStatic/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [isStatic](is-static.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if the InvokeType is [INVOKE_STATIC](-i-n-v-o-k-e_-s-t-a-t-i-c/index.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/InvokeType/isVirtual/#/PointingToDeclaration/"></a>[isVirtual](is-virtual.md)| <a name="com.github.jonathanxd.kores.base/InvokeType/isVirtual/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [isVirtual](is-virtual.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if the InvokeType is [INVOKE_VIRTUAL](-i-n-v-o-k-e_-v-i-r-t-u-a-l/index.md).  <br><br><br>
| <a name="kotlin/Enum/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-state/-r-e-q-u-i-r-e_-s-u-p-e-r/index.md#%5Bkotlin%2FEnum%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Enum/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-state/-r-e-q-u-i-r-e_-s-u-p-e-r/index.md#%5Bkotlin%2FEnum%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/InvokeType/name/#/PointingToDeclaration/"></a>[name](index.md#%5Bcom.github.jonathanxd.kores.base%2FInvokeType%2Fname%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-427383591)| <a name="com.github.jonathanxd.kores.base/InvokeType/name/#/PointingToDeclaration/"></a> [jvm] val [name](index.md#%5Bcom.github.jonathanxd.kores.base%2FInvokeType%2Fname%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-427383591): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)   <br>
| <a name="com.github.jonathanxd.kores.base/InvokeType/ordinal/#/PointingToDeclaration/"></a>[ordinal](index.md#%5Bcom.github.jonathanxd.kores.base%2FInvokeType%2Fordinal%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-427383591)| <a name="com.github.jonathanxd.kores.base/InvokeType/ordinal/#/PointingToDeclaration/"></a> [jvm] val [ordinal](index.md#%5Bcom.github.jonathanxd.kores.base%2FInvokeType%2Fordinal%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-427383591): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>

