[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Field](index.md) / [toAccess](.)

# toAccess

`fun Field.toAccess(target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`?): `[`FieldAccess`](../../com.github.jonathanxd.codeapi.base/-field-access/index.md)

Create [FieldAccess](../../com.github.jonathanxd.codeapi.base/-field-access/index.md) from [Field](#).

### Parameters

`target` - Target of the field access, null (or static access) for static access.