[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Accessor](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`Accessor`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [localization](localization.md) | `abstract fun localization(value: Type): S`<br>See [Accessor.localization](../localization.md) |
| [target](target.md) | `abstract fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [Accessor.target](../target.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-field-access/-builder/index.md) | `class Builder : Builder<`[`FieldAccess`](../../-field-access/index.md)`, `[`Builder`](../../-field-access/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`FieldAccess`](../../-field-access/index.md)`, `[`Builder`](../../-field-access/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`FieldAccess`](../../-field-access/index.md)`, `[`Builder`](../../-field-access/-builder/index.md)`>` |
| [Builder](../../-field-definition/-builder/index.md) | `class Builder : Builder<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>, `[`Builder`](../../-field-base/-builder/index.md)`<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>` |
| [Builder](../../-method-invocation/-builder/index.md) | `class Builder : Builder<`[`MethodInvocation`](../../-method-invocation/index.md)`, `[`Builder`](../../-method-invocation/-builder/index.md)`>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`MethodInvocation`](../../-method-invocation/index.md)`, `[`Builder`](../../-method-invocation/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`MethodInvocation`](../../-method-invocation/index.md)`, `[`Builder`](../../-method-invocation/-builder/index.md)`>` |
