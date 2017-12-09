[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [GenericTypeBuilder](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`GenericTypeBuilder(defaults: `[`GenericType`](../-generic-type/index.md)`)``GenericTypeBuilder()`

Builder of a [GenericType](../-generic-type/index.md).

Examples:

List of String:
`GenericTypeBuilder().withType(List::class.codeType).addOfBound(String::class.codeType).build()`

T extends List of wildcard extends CharSequence: `<T: List<out CharSequence>>` or `<T extends List<? extends CharSequence>>`

```
GenericTypeBuilder().withName("T").withExtendsBound(
  GenericTypeBuilder().withType(List::class.codeType).withExtendsBound(
    GenericTypeBuilder().wildcard().withExtendsBound(CharSequence::class.codeType).build()
  ).build()
)
```

You may also prefer the [Generic](../-generic/index.md) style:

```
Generic.type("T").extends_(
  Generic.type(List::class.codeType).extends_(
    Generic.wildcard().extends_(CharSequence::class.codeType)
  )
)
```

**Attention: All calls of the methods of [Generic](../-generic/index.md) class creates a copy of the `bound` array (except the first call), if you mind performance use the [GenericTypeBuilder](index.md)**

