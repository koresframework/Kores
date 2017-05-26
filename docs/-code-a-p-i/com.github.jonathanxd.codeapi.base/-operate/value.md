[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Operate](index.md) / [value](.)

# value

`val value: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?`

Overrides [ValueHolder.value](../-value-holder/value.md)

Second argument of the operation. Some operations may not require a second argument, some can
behave different without them, example, if a second argument is provided for [Operators.SUBTRACT](../../com.github.jonathanxd.codeapi.operator/-operators/-s-u-b-t-r-a-c-t.md), the operation
will be `target-value`, otherwise the operation will be `-target` (or negative).

### Property

`value` - Second argument of the operation. Some operations may not require a second argument, some can
behave different without them, example, if a second argument is provided for [Operators.SUBTRACT](../../com.github.jonathanxd.codeapi.operator/-operators/-s-u-b-t-r-a-c-t.md), the operation
will be `target-value`, otherwise the operation will be `-target` (or negative).