[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.modify.visit](../index.md) / [VisitManager](.)

# VisitManager

`open class VisitManager<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

Manager of visitor of part [T](#).

The implementation must care about [register](register.md) methods, these methods put values in [partVisitorMap](#),
that isn't accessible from the implementation, if you want to control the register behavior
override these methods.

The [getVisitor](get-visitor.md) method is always called to find a registered visitor.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `VisitManager()`<br>Manager of visitor of part [T](#). |

### Properties

| Name | Summary |
|---|---|
| [visitors](visitors.md) | `val visitors: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<Class<*>, `[`PartVisitor`](../-part-visitor/index.md)`<*>>`<br>Unmodifiable view of registered visitors. |

### Functions

| Name | Summary |
|---|---|
| [getVisitor](get-visitor.md) | `open fun <U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getVisitor(type: Class<*>): `[`PartVisitor`](../-part-visitor/index.md)`<U>?`<br>Gets the visitor of [type](get-visitor.md#com.github.jonathanxd.codeapi.modify.visit.VisitManager$getVisitor(java.lang.Class((kotlin.Any)))/type). |
| [register](register.md) | `open fun <U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> register(type: Class<U>, visitor: `[`PartVisitor`](../-part-visitor/index.md)`<U>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers visitor of [type](register.md#com.github.jonathanxd.codeapi.modify.visit.VisitManager$register(java.lang.Class((com.github.jonathanxd.codeapi.modify.visit.VisitManager.register.U)), com.github.jonathanxd.codeapi.modify.visit.PartVisitor((com.github.jonathanxd.codeapi.modify.visit.VisitManager.register.U)))/type). |
| [registerGeneric](register-generic.md) | `open fun registerGeneric(type: Class<*>, visitor: `[`PartVisitor`](../-part-visitor/index.md)`<*>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Register a generic visitor of [type](register-generic.md#com.github.jonathanxd.codeapi.modify.visit.VisitManager$registerGeneric(java.lang.Class((kotlin.Any)), com.github.jonathanxd.codeapi.modify.visit.PartVisitor((kotlin.Any)))/type). |
| [registerSuper](register-super.md) | `open fun <U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> registerSuper(type: Class<U>, visitor: `[`PartVisitor`](../-part-visitor/index.md)`<in U>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers a visitor of [type](register-super.md#com.github.jonathanxd.codeapi.modify.visit.VisitManager$registerSuper(java.lang.Class((com.github.jonathanxd.codeapi.modify.visit.VisitManager.registerSuper.U)), com.github.jonathanxd.codeapi.modify.visit.PartVisitor((com.github.jonathanxd.codeapi.modify.visit.VisitManager.registerSuper.U)))/type). (super variance). |
| [visit](visit.md) | `fun <U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> visit(part: U, data: TypedData): U`<br>Visits [part](visit.md#com.github.jonathanxd.codeapi.modify.visit.VisitManager$visit(com.github.jonathanxd.codeapi.modify.visit.VisitManager.visit.U, com.github.jonathanxd.iutils.data.TypedData)/part)`fun <U : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> visit(type: Class<U>, part: U, data: TypedData): U`<br>Visits [part](visit.md#com.github.jonathanxd.codeapi.modify.visit.VisitManager$visit(java.lang.Class((com.github.jonathanxd.codeapi.modify.visit.VisitManager.visit.U)), com.github.jonathanxd.codeapi.modify.visit.VisitManager.visit.U, com.github.jonathanxd.iutils.data.TypedData)/part) of [type](visit.md#com.github.jonathanxd.codeapi.modify.visit.VisitManager$visit(java.lang.Class((com.github.jonathanxd.codeapi.modify.visit.VisitManager.visit.U)), com.github.jonathanxd.codeapi.modify.visit.VisitManager.visit.U, com.github.jonathanxd.iutils.data.TypedData)/type).`fun visit(part: T): T`<br>Visits [part](visit.md#com.github.jonathanxd.codeapi.modify.visit.VisitManager$visit(com.github.jonathanxd.codeapi.modify.visit.VisitManager.T)/part). |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
