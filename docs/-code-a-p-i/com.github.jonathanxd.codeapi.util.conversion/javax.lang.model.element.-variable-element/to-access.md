[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [javax.lang.model.element.VariableElement](index.md) / [toAccess](.)

# toAccess

`fun VariableElement.toAccess(target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`?, elements: Elements): `[`FieldAccess`](../../com.github.jonathanxd.codeapi.base/-field-access/index.md)

Create [FieldAccess](../../com.github.jonathanxd.codeapi.base/-field-access/index.md) from [VariableElement](#).

### Parameters

`target` - Target of the field access, null (or static access) for static access.