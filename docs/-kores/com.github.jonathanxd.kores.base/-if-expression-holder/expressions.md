//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[IfExpressionHolder](index.md)/[expressions](expressions.md)



# expressions  
[jvm]  
Content  
abstract val [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>  
More info  


If expressions and operations



Expressions can be: [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md) (both only before and/or after [Operators.OR](../../com.github.jonathanxd.kores.operator/-operators/-o-r.md) and [Operators.AND](../../com.github.jonathanxd.kores.operator/-operators/-a-n-d.md)), [Operators.AND](../../com.github.jonathanxd.kores.operator/-operators/-a-n-d.md) (only after a [IfExpr](../-if-expr/index.md)/[IfGroup](../-if-group/index.md), followed by other [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md)) and [Operators.OR](../../com.github.jonathanxd.kores.operator/-operators/-o-r.md) (only after a [IfExpr](../-if-expr/index.md)/[IfGroup](../-if-group/index.md) and followed by other [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md)).



Example of valid and invalid expressions:



[IfExpr](../../com.github.jonathanxd.kores.operator/-operators/-o-r.md)[IfExpr](../-if-expr/index.md) = Valid [IfExpr](../../com.github.jonathanxd.kores.operator/-operators/-a-n-d.md)[IfExpr](../-if-expr/index.md) = Valid [IfExpr](../-if-expr/index.md) = Invalid [Operators.OR](../-if-expr/index.md) = Invalid [Operators.OR](../-if-group/index.md) = Invalid [IfExpr](../../com.github.jonathanxd.kores.operator/-operators/-a-n-d.md) = Invalid [IfExpr](../-if-group/index.md) = Invalid [IfExpr](../../com.github.jonathanxd.kores.operator/-operators/-a-n-d.md)[IfGroup](../-if-group/index.md) = Valid

  



