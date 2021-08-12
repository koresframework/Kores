//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](index.md)/[getTypeDesc](get-type-desc.md)

# getTypeDesc

[jvm]\
fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[getTypeDesc](get-type-desc.md)(typeStr: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = this.koresType.type): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Convert this[name](get-type-desc.md) to type description.

All calls to [KoresType.javaSpecName](../com.github.jonathanxd.kores.type/-kores-type/java-spec-name.md) are delegated to this function.

## Parameters

jvm

| | |
|---|---|
| typeStr | String to transform in type description (should be this name). |
