[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ConstructorsHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ConstructorsHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [constructors](constructors.md) | `abstract fun constructors(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): S`<br>`open fun constructors(vararg values: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>`open fun constructors(value: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>See [ConstructorsHolder.constructors](../constructors.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-anonymous-class/-builder/index.md) | `class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>, Builder<`[`AnonymousClass`](../../-anonymous-class/index.md)`, `[`Builder`](../../-anonymous-class/-builder/index.md)`>` |
| [Builder](../../-class-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>, Builder<`[`ClassDeclaration`](../../-class-declaration/index.md)`, `[`Builder`](../../-class-declaration/-builder/index.md)`>` |
| [Builder](../../-enum-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, `[`Builder`](../../-entry-holder/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, Builder<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>` |
