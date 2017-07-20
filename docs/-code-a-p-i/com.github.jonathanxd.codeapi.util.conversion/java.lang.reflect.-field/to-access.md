[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Field](index.md) / [toAccess](.)

# toAccess

`fun `[`Field`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Field.html)`.toAccess(target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`?): `[`FieldAccess`](../../com.github.jonathanxd.codeapi.base/-field-access/index.md)

Create [FieldAccess](../../com.github.jonathanxd.codeapi.base/-field-access/index.md) from [Field](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Field.html).

### Parameters

`target` - Target of the field access, null (or static access) for static access.