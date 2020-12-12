//[Kores](../index.md)/[com.github.jonathanxd.kores.util](index.md)/[fromSourceString](from-source-string.md)



# fromSourceString  
[jvm]  
Content  
fun [fromSourceString](from-source-string.md)(sourceString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)  
More info  


Parse [generic source string](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) and construct [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md).



#### Return  


Construct a [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md) from generic source string;



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util//fromSourceString/#kotlin.String/PointingToDeclaration/"></a>sourceString| <a name="com.github.jonathanxd.kores.util//fromSourceString/#kotlin.String/PointingToDeclaration/"></a><br><br>Source string.<br><br><ul><li></li></ul>
  
  


[jvm]  
Content  
fun [fromSourceString](from-source-string.md)(sourceString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), typeResolver: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)): [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)  
More info  


Parse [generic source string](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) and construct [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md).



#### Return  


Construct a [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md) from generic source string;



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util//fromSourceString/#kotlin.String#kotlin.Function1[kotlin.String,com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a>sourceString| <a name="com.github.jonathanxd.kores.util//fromSourceString/#kotlin.String#kotlin.Function1[kotlin.String,com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a><br><br>Source string.<br><br>
| <a name="com.github.jonathanxd.kores.util//fromSourceString/#kotlin.String#kotlin.Function1[kotlin.String,com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a>typeResolver| <a name="com.github.jonathanxd.kores.util//fromSourceString/#kotlin.String#kotlin.Function1[kotlin.String,com.github.jonathanxd.kores.type.KoresType]/PointingToDeclaration/"></a><br><br>Resolves [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md) from [string type](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).<br><br>
  
  


[jvm]  
Content  
fun [fromSourceString](from-source-string.md)(sourceString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), typeResolver: [KoresTypeResolverFunc](-kores-type-resolver-func/index.md)): [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)  
More info  


Parse [generic source string](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) and construct [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md).



#### Return  


Construct a [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md) from generic source string;



## Parameters  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.util//fromSourceString/#kotlin.String#com.github.jonathanxd.kores.util.KoresTypeResolverFunc/PointingToDeclaration/"></a>sourceString| <a name="com.github.jonathanxd.kores.util//fromSourceString/#kotlin.String#com.github.jonathanxd.kores.util.KoresTypeResolverFunc/PointingToDeclaration/"></a><br><br>Source string.<br><br>
| <a name="com.github.jonathanxd.kores.util//fromSourceString/#kotlin.String#com.github.jonathanxd.kores.util.KoresTypeResolverFunc/PointingToDeclaration/"></a>typeResolver| <a name="com.github.jonathanxd.kores.util//fromSourceString/#kotlin.String#com.github.jonathanxd.kores.util.KoresTypeResolverFunc/PointingToDeclaration/"></a><br><br>Resolves [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md) from [string type](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).<br><br>
  
  



