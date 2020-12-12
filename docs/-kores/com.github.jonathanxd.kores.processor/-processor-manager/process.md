//[Kores](../../index.md)/[com.github.jonathanxd.kores.processor](../index.md)/[ProcessorManager](index.md)/[process](process.md)



# process  
[jvm]  
Content  
open fun [process](process.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [R](index.md)  
open fun <[T](process.md)> [process](process.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](process.md)>, part: [T](process.md)): [R](index.md)  
More info  


Process part and returns a value of type [R](index.md).

  


[jvm]  
Content  
open fun [process](process.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), data: TypedData): [R](index.md)  
More info  


Process part with data and returns a value of type [R](index.md).

  


[jvm]  
Content  
abstract fun <[T](process.md)> [process](process.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [T](process.md)>, part: [T](process.md), data: TypedData): [R](index.md)  
More info  


Process part of type type with data and returns a value of type [R](index.md).

  



