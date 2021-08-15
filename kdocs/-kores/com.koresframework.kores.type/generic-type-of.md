//[Kores](../../index.md)/[com.koresframework.kores.type](index.md)/[genericTypeOf](generic-type-of.md)

# genericTypeOf

[jvm]\
inline fun <[T](generic-type-of.md)> [genericTypeOf](generic-type-of.md)(): [GenericType](-generic-type/index.md)

Returns a [GenericType](-generic-type/index.md) of generic [T](generic-type-of.md). This means that genericTypeOf<List<String>>() returns a [GenericType](-generic-type/index.md) of List<String> (same representation as Generic.type(List::class.java).of(String::class.java) returns).
