[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.common](.)

## Package com.github.jonathanxd.codeapi.common

### Types

| Name | Summary |
|---|---|
| [FieldRef](-field-ref/index.md) | `data class FieldRef : `[`FieldBase`](../com.github.jonathanxd.codeapi.base/-field-base/index.md)<br>Field reference, this class must never appear in CodeSource. |
| [MethodInvokeSpec](-method-invoke-spec/index.md) | `data class MethodInvokeSpec : `[`Typed`](../com.github.jonathanxd.codeapi.base/-typed/index.md)`, Comparable<`[`MethodInvokeSpec`](-method-invoke-spec/index.md)`>` |
| [MethodTypeSpec](-method-type-spec/index.md) | `data class MethodTypeSpec : `[`Typed`](../com.github.jonathanxd.codeapi.base/-typed/index.md)`, Comparable<`[`MethodTypeSpec`](-method-type-spec/index.md)`>` |
| [Nothing](-nothing/index.md) | `object Nothing : `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, `[`Typed`](../com.github.jonathanxd.codeapi.base/-typed/index.md)<br>Nothing for values (some parts may not support nothing as value). |
| [Stack](-stack.md) | `object Stack : `[`Literal`](../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Use JVM Stack value (is supported by `BytecodeGenerators`). |
| [VariableRef](-variable-ref/index.md) | `data class VariableRef : `[`VariableBase`](../com.github.jonathanxd.codeapi.base/-variable-base/index.md)<br>Reference to a Variable, this class must never appear in CodeSource. |
| [Void](-void/index.md) | `object Void : `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, `[`Typed`](../com.github.jonathanxd.codeapi.base/-typed/index.md)<br>Void instance for void returns and void values. |

### Type Aliases

| Name | Summary |
|---|---|
| [CodeNothing](-code-nothing.md) | `typealias CodeNothing = `[`Nothing`](-nothing/index.md)<br>To avoid confusion with kotlin nothing |
| [CodeVoid](-code-void.md) | `typealias CodeVoid = `[`Void`](-void/index.md)<br>To avoid confusion with java void. |

### Properties

| Name | Summary |
|---|---|
| [CLASS_CONSTRUCTOR](-c-l-a-s-s_-c-o-n-s-t-r-u-c-t-o-r.md) | `const val CLASS_CONSTRUCTOR: String`<br>Class constructor JVM Name |
| [CONSTRUCTOR](-c-o-n-s-t-r-u-c-t-o-r.md) | `const val CONSTRUCTOR: String`<br>Instance constructor JVM Name |

### Functions

| Name | Summary |
|---|---|
| [contains](contains.md) | `fun contains(name: String, namedElements: List<`[`Named`](../com.github.jonathanxd.codeapi.base/-named/index.md)`>): Boolean`<br>Checks if any [namedElements](contains.md#com.github.jonathanxd.codeapi.common$contains(kotlin.String, kotlin.collections.List((com.github.jonathanxd.codeapi.base.Named)))/namedElements) has the name [name](contains.md#com.github.jonathanxd.codeapi.common$contains(kotlin.String, kotlin.collections.List((com.github.jonathanxd.codeapi.base.Named)))/name). |
| [getNewFieldName](get-new-field-name.md) | `fun getNewFieldName(name: String, source: `[`CodeSource`](../com.github.jonathanxd.codeapi/-code-source/index.md)`): String`<br>Gets a new unique field name based on [name](get-new-field-name.md#com.github.jonathanxd.codeapi.common$getNewFieldName(kotlin.String, com.github.jonathanxd.codeapi.CodeSource)/name) and check if the name is not already in use by other
[FieldDeclaration](../com.github.jonathanxd.codeapi.base/-field-declaration/index.md) in [source](get-new-field-name.md#com.github.jonathanxd.codeapi.common$getNewFieldName(kotlin.String, com.github.jonathanxd.codeapi.CodeSource)/source). |
| [getNewInnerName](get-new-inner-name.md) | `fun getNewInnerName(name: String, typeDeclaration: `[`TypeDeclaration`](../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`): String`<br>Gets a new name for inner class, this function always try to return a name that is not in
use by other class in [typeDeclaration](get-new-inner-name.md#com.github.jonathanxd.codeapi.common$getNewInnerName(kotlin.String, com.github.jonathanxd.codeapi.base.TypeDeclaration)/typeDeclaration). |
| [getNewMethodName](get-new-method-name.md) | `fun getNewMethodName(name: String, source: `[`CodeSource`](../com.github.jonathanxd.codeapi/-code-source/index.md)`): String`<br>Gets a new unique method name based on [name](get-new-method-name.md#com.github.jonathanxd.codeapi.common$getNewMethodName(kotlin.String, com.github.jonathanxd.codeapi.CodeSource)/name) and check if the name is not already in use by other
[MethodDeclarationBase](../com.github.jonathanxd.codeapi.base/-method-declaration-base/index.md) in [source](get-new-method-name.md#com.github.jonathanxd.codeapi.common$getNewMethodName(kotlin.String, com.github.jonathanxd.codeapi.CodeSource)/source). |
| [getNewName](get-new-name.md) | `fun getNewName(name: String, nameds: List<`[`Named`](../com.github.jonathanxd.codeapi.base/-named/index.md)`>): String`<br>Gets a new unique from a base [name](get-new-name.md#com.github.jonathanxd.codeapi.common$getNewName(kotlin.String, kotlin.collections.List((com.github.jonathanxd.codeapi.base.Named)))/name). This function always return a name that is not in [Named Element List](get-new-name.md#com.github.jonathanxd.codeapi.common$getNewName(kotlin.String, kotlin.collections.List((com.github.jonathanxd.codeapi.base.Named)))/nameds). |
