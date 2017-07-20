[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ValueHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ValueHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [value](value.md) | `abstract fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.value](value.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-field-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-field-base/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, Builder<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-annotable/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>` |
| [Builder](../../-operate/-builder/index.md) | `class Builder : Builder<`[`Operate`](../../-operate/index.md)`, `[`Builder`](../../-operate/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`Operate`](../../-operate/index.md)`, `[`Builder`](../../-operate/-builder/index.md)`>` |
| [Builder](../../-return/-builder/index.md) | `class Builder : Builder<`[`Return`](../../-return/index.md)`, `[`Builder`](../../-return/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`Return`](../../-return/index.md)`, `[`Builder`](../../-return/-builder/index.md)`>` |
| [Builder](../../-case/-builder/index.md) | `class Builder : Builder<`[`Case`](../../-case/index.md)`, `[`Builder`](../../-case/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`Case`](../../-case/index.md)`, `[`Builder`](../../-case/-builder/index.md)`>, `[`Builder`](../../-body-holder/-builder/index.md)`<`[`Case`](../../-case/index.md)`, `[`Builder`](../../-case/-builder/index.md)`>` |
| [Builder](../../-line/-builder/index.md) | `interface Builder<out T : `[`Line`](../../-line/index.md)`, S : `[`Builder`](../../-line/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../-array-store/-builder/index.md) | `class Builder : `[`Builder`](../../-array-access/-builder/index.md)`<`[`ArrayStore`](../../-array-store/index.md)`, `[`Builder`](../../-array-store/-builder/index.md)`>, Builder<`[`ArrayStore`](../../-array-store/index.md)`, `[`Builder`](../../-array-store/-builder/index.md)`>` |
| [Builder](../../-field-definition/-builder/index.md) | `class Builder : `[`Builder`](../../-accessor/-builder/index.md)`<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>, `[`Builder`](../../-field-base/-builder/index.md)`<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>, Builder<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>` |
| [Builder](../../-variable-definition/-builder/index.md) | `class Builder : `[`Builder`](../../-named/-builder/index.md)`<`[`VariableDefinition`](../../-variable-definition/index.md)`, `[`Builder`](../../-variable-definition/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`VariableDefinition`](../../-variable-definition/index.md)`, `[`Builder`](../../-variable-definition/-builder/index.md)`>, Builder<`[`VariableDefinition`](../../-variable-definition/index.md)`, `[`Builder`](../../-variable-definition/-builder/index.md)`>` |
| [Builder](../../-variable-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-variable-base/-builder/index.md)`<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>, Builder<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>` |
| [Builder](../../-throw-exception/-builder/index.md) | `class Builder : Builder<`[`ThrowException`](../../-throw-exception/index.md)`, `[`Builder`](../../-throw-exception/-builder/index.md)`>` |
| [Builder](../../-switch-statement/-builder/index.md) | `class Builder : Builder<`[`SwitchStatement`](../../-switch-statement/index.md)`, `[`Builder`](../../-switch-statement/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`SwitchStatement`](../../-switch-statement/index.md)`, `[`Builder`](../../-switch-statement/-builder/index.md)`>` |
