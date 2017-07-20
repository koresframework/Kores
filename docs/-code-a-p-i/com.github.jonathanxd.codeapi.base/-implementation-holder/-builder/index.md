[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ImplementationHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ImplementationHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [implementations](implementations.md) | `abstract fun implementations(value: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>): S`<br>`open fun implementations(vararg values: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.implementations](implementations.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-interface-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`InterfaceDeclaration`](../../-interface-declaration/index.md)`, `[`Builder`](../../-interface-declaration/-builder/index.md)`>, Builder<`[`InterfaceDeclaration`](../../-interface-declaration/index.md)`, `[`Builder`](../../-interface-declaration/-builder/index.md)`>` |
| [Builder](../../-anonymous-class/-builder/index.md) | `class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, Builder<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>` |
| [Builder](../../-class-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>, Builder<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>` |
| [Builder](../../-enum-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, Builder<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, `[`Builder`](../../-entry-holder/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>` |
