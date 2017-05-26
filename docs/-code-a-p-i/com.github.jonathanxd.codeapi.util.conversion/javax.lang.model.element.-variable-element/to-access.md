[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [javax.lang.model.element.VariableElement](index.md) / [toAccess](.)

# toAccess

`fun `[`VariableElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/VariableElement.html)`.toAccess(target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?, elements: `[`Elements`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/util/Elements.html)`): `[`FieldAccess`](../../com.github.jonathanxd.codeapi.base/-field-access/index.md)

Create [FieldAccess](../../com.github.jonathanxd.codeapi.base/-field-access/index.md) from [VariableElement](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/VariableElement.html).

### Parameters

`target` - Target of the field access, null (or static access) for static access.