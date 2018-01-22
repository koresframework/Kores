[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Annotation](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`Annotation(type: Type, values: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>, retention: `[`CodeRetention`](../-code-retention/index.md)`)`

An annotation, an annotation is composed by a pair of property name and property value.

# In Java

[type](-init-.md#com.github.jonathanxd.codeapi.base.Annotation$<init>(java.lang.reflect.Type, kotlin.collections.Map((kotlin.String, kotlin.Any)), com.github.jonathanxd.codeapi.base.CodeRetention)/type) is the annotation type and [values](-init-.md#com.github.jonathanxd.codeapi.base.Annotation$<init>(java.lang.reflect.Type, kotlin.collections.Map((kotlin.String, kotlin.Any)), com.github.jonathanxd.codeapi.base.CodeRetention)/values) are the pairs that denote annotation properties and their
respective values.

Example:

`Annotation(Override, emptyMap(), false)` is equal to `@Override`
`Annotation(Named, mapOf("value" to "Wow"), true)` is equal to `@Named("Wow")`
`Annotation(Wow, mapOf("a" to 9, "b" to 7), true)` is equal to `@Wow(a = 9, b = 7)`

The [retention](-init-.md#com.github.jonathanxd.codeapi.base.Annotation$<init>(java.lang.reflect.Type, kotlin.collections.Map((kotlin.String, kotlin.Any)), com.github.jonathanxd.codeapi.base.CodeRetention)/retention) is determined by the compiler, which inspects [type](-init-.md#com.github.jonathanxd.codeapi.base.Annotation$<init>(java.lang.reflect.Type, kotlin.collections.Map((kotlin.String, kotlin.Any)), com.github.jonathanxd.codeapi.base.CodeRetention)/type) and reads [Retention](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.annotation/-retention/index.html) annotation, but
here it need to be explicitly specified (you can also use [CodeRetention.resolveRetention](../-code-retention/resolve-retention.md) to try to resolve the
retention of [type](-init-.md#com.github.jonathanxd.codeapi.base.Annotation$<init>(java.lang.reflect.Type, kotlin.collections.Map((kotlin.String, kotlin.Any)), com.github.jonathanxd.codeapi.base.CodeRetention)/type)).

