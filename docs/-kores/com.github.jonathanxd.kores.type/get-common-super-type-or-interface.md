//[Kores](../index.md)/[com.github.jonathanxd.kores.type](index.md)/[getCommonSuperTypeOrInterface](get-common-super-type-or-interface.md)



# getCommonSuperTypeOrInterface  
[jvm]  
Content  
fun [getCommonSuperTypeOrInterface](get-common-super-type-or-interface.md)(typeA: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), typeB: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?  
More info  


Gets common super type of typeA and typeB.



This function returns a class or an interface that both typeA and typeB extends from, first the function tries to get a common *super class*, and then a common *interface*.



If typeA, typeB or both are primitive but not equal, null is returned.

  



