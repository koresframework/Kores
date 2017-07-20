[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [java.lang.reflect.Type](index.md) / [getTypeDesc](.)

# getTypeDesc

`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getTypeDesc(typeStr: String = this.codeType.type): String`

Convert `this` [name](get-type-desc.md#com.github.jonathanxd.codeapi.util$getTypeDesc(java.lang.reflect.Type, kotlin.String)/typeStr) to type description.

All calls to [CodeType.javaSpecName](../../com.github.jonathanxd.codeapi.type/-code-type/java-spec-name.md) is delegated to this function.

### Parameters

`typeStr` - String to transform in type description (should be `this` name).