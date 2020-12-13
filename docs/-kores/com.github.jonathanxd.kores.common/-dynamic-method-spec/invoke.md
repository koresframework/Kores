//[Kores](../../index.md)/[com.github.jonathanxd.kores.common](../index.md)/[DynamicMethodSpec](index.md)/[invoke](invoke.md)



# invoke  
[jvm]  
Content  
operator fun [invoke](invoke.md)(bootstrap: [MethodInvokeSpec](../-method-invoke-spec/index.md)): [InvokeDynamic](../../com.github.jonathanxd.kores.base/-invoke-dynamic/index.md)  
More info  


Creates a dynamic invocation of this dynamic method spec. The dynamic invocation uses bootstrap to bind the invocation.

  


[jvm]  
Content  
operator fun [invoke](invoke.md)(bootstrap: [MethodInvokeSpec](../-method-invoke-spec/index.md), bootstrapArgs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [InvokeDynamic](../../com.github.jonathanxd.kores.base/-invoke-dynamic/index.md)  
More info  


Creates a dynamic invocation of this dynamic method spec. The dynamic invocation uses bootstrap (with bootstrapArgs) to bind the invocation.

  



