//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](index.md)/[descriptorDiscardBound](descriptor-discard-bound.md)

# descriptorDiscardBound

[jvm]\
val [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[descriptorDiscardBound](descriptor-discard-bound.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Converts this type to simple type descriptor without bounds, this is used in descriptors which generic types does not require a bound to be present (normally, when describing that a method receives a type T, without providing that T extends class X).

This property is used in a particular case where you describe a USE of a type in the code, not the declaration itself, this means that you are describing a type of a variable, parameter or field, and not the declaration of the bounds of the generic type, such as in methods descriptors.

A particular example is:

class Test<A> { // Use descriptor with bounds.\
    fun hello(obj: A) { // Use descriptor with discarded bounds.\
    }\
}

This must be made because a normal descriptor includes the type which the GenericType is bound to, for example, when you declare a [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)T extends List<E>, you are describing a signature, the signature means that you are declaring a type variable T which extends a List<E>, but when you use this [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md) in a field or parameter, you is explicit saying that you want to use the declared type T, but if you reuse the [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md) that you used to specify a signature, and extract descriptor with [Type.descriptor](descriptor.md), it will generate a T<List<E>>, because T is a type bound to List<E>, this is an unwanted behavior, so, instead, you must use [Type.descriptorDiscardBound](descriptor-discard-bound.md), which will discard bounds in descriptor, providing the correctly declaration of use of type variable T, which is simply T (or TT;).

A type descriptor is formatted as:

<ul><li>TYPE_JAVA_SPEC (specified by [KoresType.javaSpecName](../com.github.jonathanxd.kores.type/-kores-type/java-spec-name.md)) when receiver [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) is not a [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)</li><li>TYPE_NAME when receiver is a [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), does not have bounds and is a wildcard (and not a type).</li><li>(T)(TYPE_NAME); when receiver is a [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), does not have bounds and is neither a wildcard nor a type.</li><li>TYPE_NAME; when receiver is a [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), and is a type.</li><li>TYPE_NAME<BOUNDS>; when receiver is a [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), have bounds and the receiver is not a wildcard.</li></ul>

Note: () is only used to make the format more readable and will not be generated in descriptors.
