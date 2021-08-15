//[Kores](../../../index.md)/[com.koresframework.kores.modify.visit](../index.md)/[PartVisitor](index.md)

# PartVisitor

[jvm]\
interface [PartVisitor](index.md)<[U](index.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>

Visitor that transforms part [U](index.md).

## Functions

| Name | Summary |
|---|---|
| [visit](visit.md) | [jvm]<br>abstract fun [visit](visit.md)(codePart: [U](index.md), data: TypedData, visitManager: [VisitManager](../-visit-manager/index.md)<*>): [U](index.md)<br>Visits part of type [U](index.md). |
