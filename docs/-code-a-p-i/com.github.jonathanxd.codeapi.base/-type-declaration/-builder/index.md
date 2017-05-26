[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [TypeDeclaration](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`TypeDeclaration`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-qualified-named/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-elements-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [base](base.md) | `open fun base(typeRef: `[`TypeRef`](../../../com.github.jonathanxd.codeapi.type/-type-ref/index.md)`): S`<br>Sets the name and outer type to values specified in [typeRef](base.md#com.github.jonathanxd.codeapi.base.TypeDeclaration.Builder$base(com.github.jonathanxd.codeapi.type.TypeRef)/typeRef) |
| [withOuterClass](with-outer-class.md) | `abstract fun withOuterClass(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): S`<br>See [TypeDeclaration.outerClass](../outer-class.md) |
| [withQualifiedName](with-qualified-name.md) | `open fun withQualifiedName(value: String): S` |
| [withSpecifiedName](with-specified-name.md) | `abstract fun withSpecifiedName(value: String): S`<br>See [TypeDeclaration.specifiedName](../specified-name.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withAnnotations](../../-annotable/-builder/with-annotations.md) | `abstract fun withAnnotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): S`<br>`open fun withAnnotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): S`<br>See [T.annotations](../../-annotable/annotations.md) |
| [withComments](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/with-comments.md) | `abstract fun withComments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): S`<br>See [T.comments](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/comments.md) |
| [withConstructors](../../-elements-holder/-builder/with-constructors.md) | `open fun withConstructors(value: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>`abstract fun withConstructors(value: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): S`<br>`open fun withConstructors(vararg values: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>See [TypeDeclaration.constructors](../../-elements-holder/constructors.md) |
| [withFields](../../-elements-holder/-builder/with-fields.md) | `abstract fun withFields(value: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): S`<br>`open fun withFields(value: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>`open fun withFields(vararg values: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>See [TypeDeclaration.fields](../../-elements-holder/fields.md) |
| [withGenericSignature](../../-generic-signature-holder/-builder/with-generic-signature.md) | `abstract fun withGenericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): S`<br>See [T.genericSignature](../../-generic-signature-holder/generic-signature.md) |
| [withInnerTypes](../../-inner-types-holder/-builder/with-inner-types.md) | `open fun withInnerTypes(vararg values: `[`TypeDeclaration`](../index.md)`): S`<br>`abstract fun withInnerTypes(value: List<`[`TypeDeclaration`](../index.md)`>): S`<br>See [T.innerTypes](../../-inner-types-holder/inner-types.md) |
| [withMethods](../../-elements-holder/-builder/with-methods.md) | `abstract fun withMethods(value: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): S`<br>`open fun withMethods(vararg values: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>`open fun withMethods(value: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>See [TypeDeclaration.methods](../../-elements-holder/methods.md) |
| [withModifiers](../../-modifiers-holder/-builder/with-modifiers.md) | `open fun withModifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>`abstract fun withModifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): S`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [withName](../../-qualified-named/-builder/with-name.md) | `open fun withName(value: String): S` |
| [withPublicModifier](../../-modifiers-holder/-builder/with-public-modifier.md) | `open fun withPublicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all
[ModifiersHolder](../../-modifiers-holder/index.md) which does not provide a modifier is public by default. |
| [withStaticBlock](../../-elements-holder/-builder/with-static-block.md) | `abstract fun withStaticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): S`<br>See [TypeDeclaration.staticBlock](../../-elements-holder/static-block.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-interface-declaration/-builder/index.md) | `class Builder : Builder<`[`InterfaceDeclaration`](../../-interface-declaration/index.md)`, `[`Builder`](../../-interface-declaration/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`InterfaceDeclaration`](../../-interface-declaration/index.md)`, `[`Builder`](../../-interface-declaration/-builder/index.md)`>` |
| [Builder](../../-anonymous-class/-builder/index.md) | `class Builder : Builder<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-argument-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>` |
| [Builder](../../-class-declaration/-builder/index.md) | `class Builder : Builder<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>` |
| [Builder](../../-annotation-declaration/-builder/index.md) | `class Builder : Builder<`[`AnnotationDeclaration`](../../-annotation-declaration/index.md)`, `[`Builder`](../../-annotation-declaration/-builder/index.md)`>` |
| [Builder](../../-enum-declaration/-builder/index.md) | `class Builder : Builder<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, `[`Builder`](../../-entry-holder/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>` |
