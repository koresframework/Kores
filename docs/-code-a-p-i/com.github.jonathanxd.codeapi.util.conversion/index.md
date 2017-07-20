[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util.conversion](.)

## Package com.github.jonathanxd.codeapi.util.conversion

### Extensions for External Classes

| Name | Summary |
|---|---|
| [java.lang.Class](java.lang.-class/index.md) |  |
| [java.lang.reflect.Constructor](java.lang.reflect.-constructor/index.md) |  |
| [java.lang.reflect.Executable](java.lang.reflect.-executable/index.md) |  |
| [java.lang.reflect.Field](java.lang.reflect.-field/index.md) |  |
| [java.lang.reflect.Method](java.lang.reflect.-method/index.md) |  |
| [java.lang.reflect.Parameter](java.lang.reflect.-parameter/index.md) |  |
| [javax.lang.model.element.ExecutableElement](javax.lang.model.element.-executable-element/index.md) |  |
| [javax.lang.model.element.VariableElement](javax.lang.model.element.-variable-element/index.md) |  |
| [kotlin.Any](kotlin.-any/index.md) |  |
| [kotlin.collections.Iterable](kotlin.collections.-iterable/index.md) |  |
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |
| [kotlin.reflect.KParameter](kotlin.reflect.-k-parameter/index.md) |  |

### Properties

| Name | Summary |
|---|---|
| [access](access.md) | `val `[`CodeParameter`](../com.github.jonathanxd.codeapi.base/-code-parameter/index.md)`.access: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Convert [CodeParameter](../com.github.jonathanxd.codeapi.base/-code-parameter/index.md) to variable access |

### Functions

| Name | Summary |
|---|---|
| [extend](extend.md) | `fun <T : `[`TypeDeclaration`](../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`> T.extend(klass: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): T`<br>Makes the declaration [T](#) extend the [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) overriding all public/protected methods
and invoking the super method. |
| [fixModifiers](fix-modifiers.md) | `fun fixModifiers(modifiers: Int): `[`EnumSet`](http://docs.oracle.com/javase/6/docs/api/java/util/EnumSet.html)`<`[`CodeModifier`](../com.github.jonathanxd.codeapi.base/-code-modifier/index.md)`>` |
| [isValidImpl](is-valid-impl.md) | `fun isValidImpl(method: `[`Method`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`): Boolean`<br>Returns if [method](is-valid-impl.md#com.github.jonathanxd.codeapi.util.conversion$isValidImpl(java.lang.reflect.Method)/method) is valid for implementation. |
| [toInvocation](to-invocation.md) | `fun `[`MethodTypeSpec`](../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`.toInvocation(invokeType: `[`InvokeType`](../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, target: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, arguments: List<`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Create [MethodInvocation](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md) from [MethodTypeSpec](../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`fun `[`MethodInvokeSpec`](../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`.toInvocation(target: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, arguments: List<`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Create [MethodInvocation](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md) from [MethodInvokeSpec](../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md) |
| [toVariableAccess](to-variable-access.md) | `fun `[`CodeParameter`](../com.github.jonathanxd.codeapi.base/-code-parameter/index.md)`.toVariableAccess(): `[`VariableAccess`](../com.github.jonathanxd.codeapi.base/-variable-access/index.md) |
