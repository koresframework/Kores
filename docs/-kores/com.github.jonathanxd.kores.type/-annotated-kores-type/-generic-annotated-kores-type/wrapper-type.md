//[Kores](../../../index.md)/[com.github.jonathanxd.kores.type](../../index.md)/[AnnotatedKoresType](../index.md)/[GenericAnnotatedKoresType](index.md)/[wrapperType](wrapper-type.md)



# wrapperType  
[jvm]  
Content  
open override val [wrapperType](wrapper-type.md): [KoresType](../../-kores-type/index.md)?  
More info  


Only determine the Wrapper type if:



isKoresType && bounds.isEmpty



Because int<T> is invalid.

  



