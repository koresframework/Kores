//[Kores](../index.md)/[com.github.jonathanxd.kores.type](index.md)/[getCommonSuperType](get-common-super-type.md)



# getCommonSuperType  
[jvm]  
Content  
fun [getCommonSuperType](get-common-super-type.md)(typeA: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), typeB: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?  
More info  


Gets common super type of typeA and typeB.



This function returns a super class that both typeA and typeB extends from.



If either typeA or typeB is primitive and are not equal, this function returns null.

  



