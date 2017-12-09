[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.type](../../../index.md) / [AnnotatedCodeType](../../index.md) / [Abstract](../index.md) / [BuilderImpl](.)

# BuilderImpl

`class BuilderImpl<T : `[`Abstract`](../index.md)`<T>> : `[`Builder`](../../-builder/index.md)`<T, BuilderImpl<T>>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BuilderImpl(defaults: `[`Abstract`](../index.md)`<T>)`<br>`BuilderImpl(factory: (type: Type, annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>) -> T)` |

### Properties

| Name | Summary |
|---|---|
| [annotatedType](annotated-type.md) | `lateinit var annotatedType: Type` |
| [annotations](annotations.md) | `var annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [addAnnotation](add-annotation.md) | `fun addAnnotation(annotation: `[`Annotation`](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`): BuilderImpl<T>`<br>Adds an [Annotation](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md) to [AnnotatedCodeType.annotations](../../annotations.md). |
| [annotatedType](annotated-type.md) | `fun annotatedType(type: Type): BuilderImpl<T>`<br>The [type](annotated-type.md#com.github.jonathanxd.codeapi.type.AnnotatedCodeType.Abstract.BuilderImpl$annotatedType(java.lang.reflect.Type)/type) that is annotated with [annotations](annotations.md). |
| [annotations](annotations.md) | `fun annotations(annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>): BuilderImpl<T>`<br>Defines [AnnotatedCodeType.annotations](../../annotations.md). |
| [build](build.md) | `fun build(): T`<br>Build the object of type [T](#). |

### Inherited Functions

| Name | Summary |
|---|---|
| [annotations](../../-builder/annotations.md) | `open fun annotations(vararg annotations: `[`Annotation`](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`): `[`Builder`](../../-builder/index.md)`<T, S>`<br>Defines [AnnotatedCodeType.annotations](../../annotations.md). |
