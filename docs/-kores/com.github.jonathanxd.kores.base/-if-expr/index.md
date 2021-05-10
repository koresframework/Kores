//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[IfExpr](index.md)



# IfExpr  
 [jvm] data class [IfExpr](index.md)(**expr1**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **operation**: [Operator.Conditional](../../com.github.jonathanxd.kores.operator/-operator/-conditional/index.md), **expr2**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Condition evaluation.

   


## See also  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfExpr///PointingToDeclaration/"></a>[com.github.jonathanxd.kores.base.IfStatement](../-if-statement/index.md)| <a name="com.github.jonathanxd.kores.base/IfExpr///PointingToDeclaration/"></a>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfExpr/IfExpr/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.operator.Operator.Conditional#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[IfExpr](-if-expr.md)| <a name="com.github.jonathanxd.kores.base/IfExpr/IfExpr/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.operator.Operator.Conditional#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a> [jvm] fun [IfExpr](-if-expr.md)(expr1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), operation: [Operator.Conditional](../../com.github.jonathanxd.kores.operator/-operator/-conditional/index.md), expr2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md))   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfExpr.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/IfExpr.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[IfExpr](index.md), [IfExpr.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfExpr/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/IfExpr/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [IfExpr.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/IfExpr/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/IfExpr/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/IfExpr/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/IfExpr/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Operator.Conditional](../../com.github.jonathanxd.kores.operator/-operator/-conditional/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/IfExpr/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/IfExpr/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/IfExpr/copy/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.operator.Operator.Conditional#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/IfExpr/copy/#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.operator.Operator.Conditional#com.github.jonathanxd.kores.Instruction/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(expr1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), operation: [Operator.Conditional](../../com.github.jonathanxd.kores.operator/-operator/-conditional/index.md), expr2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpr](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/IfExpr/expr1/#/PointingToDeclaration/"></a>[expr1](expr1.md)| <a name="com.github.jonathanxd.kores.base/IfExpr/expr1/#/PointingToDeclaration/"></a> [jvm] val [expr1](expr1.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)First expression   <br>
| <a name="com.github.jonathanxd.kores.base/IfExpr/expr2/#/PointingToDeclaration/"></a>[expr2](expr2.md)| <a name="com.github.jonathanxd.kores.base/IfExpr/expr2/#/PointingToDeclaration/"></a> [jvm] val [expr2](expr2.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Second expression   <br>
| <a name="com.github.jonathanxd.kores.base/IfExpr/operation/#/PointingToDeclaration/"></a>[operation](operation.md)| <a name="com.github.jonathanxd.kores.base/IfExpr/operation/#/PointingToDeclaration/"></a> [jvm] val [operation](operation.md): [Operator.Conditional](../../com.github.jonathanxd.kores.operator/-operator/-conditional/index.md)Operation   <br>


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.inspect//getRuntimeBooleanEqCheck/com.github.jonathanxd.kores.base.IfExpr#/PointingToDeclaration/"></a>[getRuntimeBooleanEqCheck](../../com.github.jonathanxd.kores.inspect/get-runtime-boolean-eq-check.md)| <a name="com.github.jonathanxd.kores.inspect//getRuntimeBooleanEqCheck/com.github.jonathanxd.kores.base.IfExpr#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [IfExpr](index.md).[getRuntimeBooleanEqCheck](../../com.github.jonathanxd.kores.inspect/get-runtime-boolean-eq-check.md)(): [EqCheck](../../com.github.jonathanxd.kores.inspect/-eq-check/index.md)?  <br>More info  <br>Gets the runtime [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) value that [IfExpr](index.md) check equality to.  <br><br><br>
| <a name="com.github.jonathanxd.kores.inspect//isCheckFalse/com.github.jonathanxd.kores.base.IfExpr#/PointingToDeclaration/"></a>[isCheckFalse](../../com.github.jonathanxd.kores.inspect/is-check-false.md)| <a name="com.github.jonathanxd.kores.inspect//isCheckFalse/com.github.jonathanxd.kores.base.IfExpr#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [IfExpr](index.md).[isCheckFalse](../../com.github.jonathanxd.kores.inspect/is-check-false.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if receiver[IfExpr](index.md) is a check of [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md) equality to false constant.  <br><br><br>
| <a name="com.github.jonathanxd.kores.inspect//isCheckFalseAnd/com.github.jonathanxd.kores.base.IfExpr#kotlin.Function1[com.github.jonathanxd.kores.Instruction,kotlin.Boolean]/PointingToDeclaration/"></a>[isCheckFalseAnd](../../com.github.jonathanxd.kores.inspect/is-check-false-and.md)| <a name="com.github.jonathanxd.kores.inspect//isCheckFalseAnd/com.github.jonathanxd.kores.base.IfExpr#kotlin.Function1[com.github.jonathanxd.kores.Instruction,kotlin.Boolean]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>inline fun [IfExpr](index.md).[isCheckFalseAnd](../../com.github.jonathanxd.kores.inspect/is-check-false-and.md)(predicate: ([Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if receiver[IfExpr](index.md) is a check of [instruction](../../com.github.jonathanxd.kores/-instruction/index.md) equality to false constant and predicate returns true for the [instruction](../../com.github.jonathanxd.kores/-instruction/index.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.inspect//isCheckTrue/com.github.jonathanxd.kores.base.IfExpr#/PointingToDeclaration/"></a>[isCheckTrue](../../com.github.jonathanxd.kores.inspect/is-check-true.md)| <a name="com.github.jonathanxd.kores.inspect//isCheckTrue/com.github.jonathanxd.kores.base.IfExpr#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [IfExpr](index.md).[isCheckTrue](../../com.github.jonathanxd.kores.inspect/is-check-true.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if receiver[IfExpr](index.md) is a check of [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md) equality to true constant.  <br><br><br>
| <a name="com.github.jonathanxd.kores.inspect//isCheckTrueAnd/com.github.jonathanxd.kores.base.IfExpr#kotlin.Function1[com.github.jonathanxd.kores.Instruction,kotlin.Boolean]/PointingToDeclaration/"></a>[isCheckTrueAnd](../../com.github.jonathanxd.kores.inspect/is-check-true-and.md)| <a name="com.github.jonathanxd.kores.inspect//isCheckTrueAnd/com.github.jonathanxd.kores.base.IfExpr#kotlin.Function1[com.github.jonathanxd.kores.Instruction,kotlin.Boolean]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>inline fun [IfExpr](index.md).[isCheckTrueAnd](../../com.github.jonathanxd.kores.inspect/is-check-true-and.md)(predicate: ([Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if receiver[IfExpr](index.md) is a check of [instruction](../../com.github.jonathanxd.kores/-instruction/index.md) equality to true constant and predicate returns true for the [instruction](../../com.github.jonathanxd.kores/-instruction/index.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.inspect//removeRedundantNot/com.github.jonathanxd.kores.base.IfExpr#/PointingToDeclaration/"></a>[removeRedundantNot](../../com.github.jonathanxd.kores.inspect/remove-redundant-not.md)| <a name="com.github.jonathanxd.kores.inspect//removeRedundantNot/com.github.jonathanxd.kores.base.IfExpr#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [IfExpr](index.md).[removeRedundantNot](../../com.github.jonathanxd.kores.inspect/remove-redundant-not.md)(): [IfExpr](index.md)  <br>More info  <br>Removes redundant not check.  <br><br><br>

