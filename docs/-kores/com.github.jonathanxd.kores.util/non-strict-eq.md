//[Kores](../index.md)/[com.github.jonathanxd.kores.util](index.md)/[nonStrictEq](non-strict-eq.md)



# nonStrictEq  
[jvm]  
Content  
fun [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md).[nonStrictEq](non-strict-eq.md)(other: [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Non-strict generic equality check, only works for generic types.



This method will not make strict bound checks, it means that List<?> is equal to List, List<? extends Person> is equal to List<Person>, but List<Number> is not equal to List<Integer>.

  


[jvm]  
Content  
fun [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md).[nonStrictEq](non-strict-eq.md)(other: [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  
More info  


Non-strict generic bound equality check, only works for generic types.



This method will not make strict bound checks, it means that List<?> is equal to List, List<? extends Person> is equal to List<Person>, but List<Number> is not equal to List<Integer>.

  



