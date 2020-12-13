//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ForStatement](index.md)/[expressions](expressions.md)



# expressions  
[jvm]  
Content  
open override val [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>  
More info  


If expressions and operations



Expressions can be: [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md) (both only before and/or after Operators.OR and Operators.AND), Operators.AND (only after a [IfExpr](../-if-expr/index.md)/[IfGroup](../-if-group/index.md), followed by other [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md)) and Operators.OR (only after a [IfExpr](../-if-expr/index.md)/[IfGroup](../-if-group/index.md) and followed by other [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md)).



Example of valid and invalid expressions:



Operators.OR[IfExpr](../-if-expr/index.md) = Valid Operators.AND[IfExpr](../-if-expr/index.md) = Valid [IfExpr](../-if-expr/index.md) = Invalid [Operators.OR](../-if-expr/index.md) = Invalid [Operators.OR](../-if-group/index.md) = Invalid Operators.AND = Invalid [IfExpr](../-if-group/index.md) = Invalid Operators.AND[IfGroup](../-if-group/index.md) = Valid

  



