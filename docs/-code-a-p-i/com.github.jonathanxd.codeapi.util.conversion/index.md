[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util.conversion](.)

## Package com.github.jonathanxd.codeapi.util.conversion

### Extensions for External Classes

| Name | Summary |
|---|---|
| [java.lang.Class](java.lang.-class/index.md) |  |
| [java.lang.reflect.AnnotatedElement](java.lang.reflect.-annotated-element/index.md) |  |
| [java.lang.reflect.Constructor](java.lang.reflect.-constructor/index.md) |  |
| [java.lang.reflect.Executable](java.lang.reflect.-executable/index.md) |  |
| [java.lang.reflect.Field](java.lang.reflect.-field/index.md) |  |
| [java.lang.reflect.Method](java.lang.reflect.-method/index.md) |  |
| [java.lang.reflect.Parameter](java.lang.reflect.-parameter/index.md) |  |
| [javax.lang.model.AnnotatedConstruct](javax.lang.model.-annotated-construct/index.md) |  |
| [javax.lang.model.element.AnnotationMirror](javax.lang.model.element.-annotation-mirror/index.md) |  |
| [javax.lang.model.element.AnnotationValue](javax.lang.model.element.-annotation-value/index.md) |  |
| [javax.lang.model.element.Element](javax.lang.model.element.-element/index.md) |  |
| [javax.lang.model.element.ExecutableElement](javax.lang.model.element.-executable-element/index.md) |  |
| [javax.lang.model.element.TypeElement](javax.lang.model.element.-type-element/index.md) |  |
| [javax.lang.model.element.VariableElement](javax.lang.model.element.-variable-element/index.md) |  |
| [kotlin.Any](kotlin.-any/index.md) |  |
| [kotlin.Array](kotlin.-array/index.md) |  |
| [kotlin.collections.Iterable](kotlin.collections.-iterable/index.md) |  |
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |
| [kotlin.reflect.KParameter](kotlin.reflect.-k-parameter/index.md) |  |

### Properties

| Name | Summary |
|---|---|
| [access](access.md) | `val `[`CodeParameter`](../com.github.jonathanxd.codeapi.base/-code-parameter/index.md)`.access: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Convert [CodeParameter](../com.github.jonathanxd.codeapi.base/-code-parameter/index.md) to variable access |
| [codeAnnotation](code-annotation.md) | `val <T : `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`> T.codeAnnotation: `[`CodeAnnotation`](../com.github.jonathanxd.codeapi.base/-code-annotation.md) |

### Functions

| Name | Summary |
|---|---|
| [extend](extend.md) | `fun <T : `[`TypeDeclaration`](../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`> T.extend(klass: Class<*>): T`<br>Makes the declaration [T](#) extend the [Class](#) overriding all public/protected methods and invoking the super method. |
| [fixModifiers](fix-modifiers.md) | `fun fixModifiers(modifiers: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): EnumSet<`[`CodeModifier`](../com.github.jonathanxd.codeapi.base/-code-modifier/index.md)`>` |
| [isValidImpl](is-valid-impl.md) | `fun isValidImpl(method: Method): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns if [method](is-valid-impl.md#com.github.jonathanxd.codeapi.util.conversion$isValidImpl(java.lang.reflect.Method)/method) is valid for implementation. |
| [toInvocation](to-invocation.md) | `fun `[`MethodTypeSpec`](../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`.toInvocation(invokeType: `[`InvokeType`](../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, target: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Create [MethodInvocation](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md) from [MethodTypeSpec](../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`fun `[`MethodInvokeSpec`](../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`.toInvocation(target: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Create [MethodInvocation](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md) from [MethodInvokeSpec](../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md) |
| [toRepresentation](to-representation.md) | `fun `[`TypeDeclaration`](../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`.toRepresentation(): `[`TypeDeclaration`](../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)<br>`fun `[`CodeAnnotation`](../com.github.jonathanxd.codeapi.base/-code-annotation.md)`.toRepresentation(): `[`CodeAnnotation`](../com.github.jonathanxd.codeapi.base/-code-annotation.md)<br>`fun `[`EnumEntry`](../com.github.jonathanxd.codeapi.base/-enum-entry/index.md)`.toRepresentation(): `[`EnumEntry`](../com.github.jonathanxd.codeapi.base/-enum-entry/index.md)<br>`fun `[`FieldDeclaration`](../com.github.jonathanxd.codeapi.base/-field-declaration/index.md)`.toRepresentation(): `[`FieldDeclaration`](../com.github.jonathanxd.codeapi.base/-field-declaration/index.md)<br>`fun `[`ConstructorDeclaration`](../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)`.toRepresentation(): `[`ConstructorDeclaration`](../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)<br>`fun `[`MethodDeclaration`](../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)`.toRepresentation(): `[`MethodDeclaration`](../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)<br>`fun `[`CodeParameter`](../com.github.jonathanxd.codeapi.base/-code-parameter/index.md)`.toRepresentation(): `[`CodeParameter`](../com.github.jonathanxd.codeapi.base/-code-parameter/index.md) |
| [toVariableAccess](to-variable-access.md) | `fun `[`CodeParameter`](../com.github.jonathanxd.codeapi.base/-code-parameter/index.md)`.toVariableAccess(): `[`VariableAccess`](../com.github.jonathanxd.codeapi.base/-variable-access/index.md) |
