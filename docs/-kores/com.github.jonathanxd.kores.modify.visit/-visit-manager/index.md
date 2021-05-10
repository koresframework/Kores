//[Kores](../../index.md)/[com.github.jonathanxd.kores.modify.visit](../index.md)/[VisitManager](index.md)



# VisitManager  
 [jvm] open class [VisitManager](index.md)<[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>

Manager of visitor of part [T](index.md).



The implementation must care about [register](register.md) methods, these methods put values in partVisitorMap, that isn't accessible from the implementation, if you want to control the register behavior override these methods.



The getVisitor method is always called to find a registered visitor.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/VisitManager/#/PointingToDeclaration/"></a>[VisitManager](-visit-manager.md)| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/VisitManager/#/PointingToDeclaration/"></a> [jvm] fun [VisitManager](-visit-manager.md)()   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/register/#java.lang.Class[TypeParam(bounds=[kotlin.Any])]#com.github.jonathanxd.kores.modify.visit.PartVisitor[TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[register](register.md)| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/register/#java.lang.Class[TypeParam(bounds=[kotlin.Any])]#com.github.jonathanxd.kores.modify.visit.PartVisitor[TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun <[U](register.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [register](register.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[U](register.md)>, visitor: [PartVisitor](../-part-visitor/index.md)<[U](register.md)>)  <br>More info  <br>Registers visitor of type.  <br><br><br>
| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/registerGeneric/#java.lang.Class[*]#com.github.jonathanxd.kores.modify.visit.PartVisitor[*]/PointingToDeclaration/"></a>[registerGeneric](register-generic.md)| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/registerGeneric/#java.lang.Class[*]#com.github.jonathanxd.kores.modify.visit.PartVisitor[*]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [registerGeneric](register-generic.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<*>, visitor: [PartVisitor](../-part-visitor/index.md)<*>)  <br>More info  <br>Register a generic visitor of type.  <br><br><br>
| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/registerSuper/#java.lang.Class[TypeParam(bounds=[kotlin.Any])]#com.github.jonathanxd.kores.modify.visit.PartVisitor[TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[registerSuper](register-super.md)| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/registerSuper/#java.lang.Class[TypeParam(bounds=[kotlin.Any])]#com.github.jonathanxd.kores.modify.visit.PartVisitor[TypeParam(bounds=[kotlin.Any])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun <[U](register-super.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [registerSuper](register-super.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[U](register-super.md)>, visitor: [PartVisitor](../-part-visitor/index.md)<in [U](register-super.md)>)  <br>More info  <br>Registers a visitor of type.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/visit/#TypeParam(bounds=[kotlin.Any])/PointingToDeclaration/"></a>[visit](visit.md)| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/visit/#TypeParam(bounds=[kotlin.Any])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [visit](visit.md)(part: [T](index.md)): [T](index.md)  <br>More info  <br>Visits part.  <br><br><br>[jvm]  <br>Content  <br>fun <[U](visit.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [visit](visit.md)(part: [U](visit.md), data: TypedData): [U](visit.md)  <br>More info  <br>Visits part  <br><br><br>[jvm]  <br>Content  <br>fun <[U](visit.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [visit](visit.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[U](visit.md)>, part: [U](visit.md), data: TypedData): [U](visit.md)  <br>More info  <br>Visits part of type.  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/visitors/#/PointingToDeclaration/"></a>[visitors](visitors.md)| <a name="com.github.jonathanxd.kores.modify.visit/VisitManager/visitors/#/PointingToDeclaration/"></a> [jvm] val [visitors](visitors.md): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<*>, [PartVisitor](../-part-visitor/index.md)<*>>Unmodifiable view of registered visitors.   <br>

