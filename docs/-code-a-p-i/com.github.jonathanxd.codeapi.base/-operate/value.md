[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Operate](index.md) / [value](.)

# value

`val value: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Overrides [ValueHolder.value](../-value-holder/value.md)

Second argument of the operation, may be [CodeNothing](../../com.github.jonathanxd.codeapi.common/-code-nothing.md).
Some operations may not require a second argument and some can behave different without them,
example, if a second argument is provided for [Operators.SUBTRACT](../../com.github.jonathanxd.codeapi.operator/-operators/-s-u-b-t-r-a-c-t.md), the operation
will be `target-value`, otherwise, if [CodeNothing](../../com.github.jonathanxd.codeapi.common/-code-nothing.md) is provided, the operation will be `-target` (or negative target).

### Property

`value` - Second argument of the operation, may be [CodeNothing](../../com.github.jonathanxd.codeapi.common/-code-nothing.md).
Some operations may not require a second argument and some can behave different without them,
example, if a second argument is provided for [Operators.SUBTRACT](../../com.github.jonathanxd.codeapi.operator/-operators/-s-u-b-t-r-a-c-t.md), the operation
will be `target-value`, otherwise, if [CodeNothing](../../com.github.jonathanxd.codeapi.common/-code-nothing.md) is provided, the operation will be `-target` (or negative target).