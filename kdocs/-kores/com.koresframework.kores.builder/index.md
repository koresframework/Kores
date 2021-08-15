//[Kores](../../index.md)/[com.koresframework.kores.builder](index.md)

# Package com.koresframework.kores.builder

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md), [S](-builder/index.md) : [Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>><br>Builder pattern. |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>inline fun <[T](build.md), [S](build.md) : [Builder](-builder/index.md)<[T](build.md), [S](build.md)>> [S](build.md).[build](build.md)(func: [S](build.md).() -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [T](build.md)<br>Build the object of type [T](build.md). |
| [self](self.md) | [jvm]<br>inline fun <[T](self.md), [S](self.md) : [Builder](-builder/index.md)<[T](self.md), [S](self.md)>> [Builder](-builder/index.md)<[T](self.md), [S](self.md)>.[self](self.md)(): [S](self.md)<br>Cast from [Builder](-builder/index.md) of [T](self.md) of implicit type [S](self.md). |
