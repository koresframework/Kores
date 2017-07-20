[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [TypeDeclaration](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`TypeDeclaration`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-qualified-named/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-elements-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [base](base.md) | `open fun base(typeRef: `[`TypeRef`](../../../com.github.jonathanxd.codeapi.type/-type-ref/index.md)`): S`<br>Sets the name and outer type to values specified in [typeRef](base.md#com.github.jonathanxd.codeapi.base.TypeDeclaration.Builder$base(com.github.jonathanxd.codeapi.type.TypeRef)/typeRef) |
| [outerClass](outer-class.md) | `abstract fun outerClass(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): S`<br>See [TypeDeclaration.outerClass](../outer-class.md) |
| [qualifiedName](qualified-name.md) | `open fun qualifiedName(value: String): S` |
| [specifiedName](specified-name.md) | `abstract fun specifiedName(value: String): S`<br>See [TypeDeclaration.specifiedName](../specified-name.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | `abstract fun annotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): S`<br>`open fun annotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): S`<br>See [T.annotations](../../-annotable/-builder/annotations.md) |
| [comments](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/comments.md) | `abstract fun comments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): S`<br>See [T.comments](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/comments.md) |
| [constructors](../../-elements-holder/-builder/constructors.md) | `open fun constructors(value: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>`abstract fun constructors(value: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): S`<br>`open fun constructors(vararg values: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>See [TypeDeclaration.constructors](../../-elements-holder/constructors.md) |
| [fields](../../-elements-holder/-builder/fields.md) | `open fun fields(vararg values: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>`open fun fields(value: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>`abstract fun fields(value: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): S`<br>See [TypeDeclaration.fields](../../-elements-holder/fields.md) |
| [genericSignature](../../-generic-signature-holder/-builder/generic-signature.md) | `abstract fun genericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): S`<br>See [T.genericSignature](../../-generic-signature-holder/-builder/generic-signature.md) |
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | `abstract fun innerTypes(value: List<`[`TypeDeclaration`](../index.md)`>): S`<br>`open fun innerTypes(vararg values: `[`TypeDeclaration`](../index.md)`): S`<br>See [T.innerTypes](../../-inner-types-holder/-builder/inner-types.md) |
| [methods](../../-elements-holder/-builder/methods.md) | `open fun methods(vararg values: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>`abstract fun methods(value: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): S`<br>`open fun methods(value: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>See [TypeDeclaration.methods](../../-elements-holder/methods.md) |
| [modifiers](../../-modifiers-holder/-builder/modifiers.md) | `abstract fun modifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): S`<br>`open fun modifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](../../-qualified-named/-builder/name.md) | `open fun name(value: String): S` |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | `open fun publicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all
[ModifiersHolder](../../-modifiers-holder/index.md) which does not provide a modifier is public by default. |
| [staticBlock](../../-elements-holder/-builder/static-block.md) | `abstract fun staticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): S`<br>See [TypeDeclaration.staticBlock](../../-elements-holder/static-block.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-interface-declaration/-builder/index.md) | `class Builder : Builder<`[`InterfaceDeclaration`](../../-interface-declaration/index.md)`, `[`Builder`](../../-interface-declaration/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`InterfaceDeclaration`](../../-interface-declaration/index.md)`, `[`Builder`](../../-interface-declaration/-builder/index.md)`>` |
| [Builder](../../-anonymous-class/-builder/index.md) | `class Builder : Builder<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>` |
| [Builder](../../-class-declaration/-builder/index.md) | `class Builder : Builder<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>` |
| [Builder](../../-annotation-declaration/-builder/index.md) | `class Builder : Builder<`[`AnnotationDeclaration`](../../-annotation-declaration/index.md)`, `[`Builder`](../../-annotation-declaration/-builder/index.md)`>` |
| [Builder](../../-enum-declaration/-builder/index.md) | `class Builder : Builder<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, `[`Builder`](../../-entry-holder/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>` |
