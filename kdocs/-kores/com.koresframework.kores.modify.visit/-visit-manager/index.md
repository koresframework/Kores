//[Kores](../../../index.md)/[com.koresframework.kores.modify.visit](../index.md)/[VisitManager](index.md)

# VisitManager

[jvm]\
open class [VisitManager](index.md)<[T](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>

Manager of visitor of part [T](index.md).

The implementation must care about [register](register.md) methods, these methods put values in partVisitorMap, that isn't accessible from the implementation, if you want to control the register behavior override these methods.

The getVisitor method is always called to find a registered visitor.

## Constructors

| | |
|---|---|
| [VisitManager](-visit-manager.md) | [jvm]<br>fun [VisitManager](-visit-manager.md)() |

## Functions

| Name | Summary |
|---|---|
| [register](register.md) | [jvm]<br>open fun <[U](register.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [register](register.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[U](register.md)>, visitor: [PartVisitor](../-part-visitor/index.md)<[U](register.md)>)<br>Registers visitor of [type](register.md). |
| [registerGeneric](register-generic.md) | [jvm]<br>open fun [registerGeneric](register-generic.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<*>, visitor: [PartVisitor](../-part-visitor/index.md)<*>)<br>Register a generic visitor of [type](register-generic.md). |
| [registerSuper](register-super.md) | [jvm]<br>open fun <[U](register-super.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [registerSuper](register-super.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[U](register-super.md)>, visitor: [PartVisitor](../-part-visitor/index.md)<in [U](register-super.md)>)<br>Registers a visitor of [type](register-super.md). |
| [visit](visit.md) | [jvm]<br>fun [visit](visit.md)(part: [T](index.md)): [T](index.md)<br>Visits [part](visit.md).<br>[jvm]<br>fun <[U](visit.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [visit](visit.md)(part: [U](visit.md), data: TypedData): [U](visit.md)<br>Visits [part](visit.md)<br>[jvm]<br>fun <[U](visit.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [visit](visit.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[U](visit.md)>, part: [U](visit.md), data: TypedData): [U](visit.md)<br>Visits [part](visit.md) of [type](visit.md). |

## Properties

| Name | Summary |
|---|---|
| [visitors](visitors.md) | [jvm]<br>val [visitors](visitors.md): [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)<[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<*>, [PartVisitor](../-part-visitor/index.md)<*>><br>Unmodifiable view of registered visitors. |
