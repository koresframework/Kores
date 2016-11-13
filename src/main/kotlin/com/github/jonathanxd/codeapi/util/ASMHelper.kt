package com.github.jonathanxd.codeapi.util

/**
 * Unsafe treat **this** [Iterable] as [Iterable] of [U]
 */
@Suppress("UNCHECKED_CAST")
inline fun <U> Iterable<*>.unsafeForEach(func: (U) -> Unit) {
    (this as Sequence<U>).forEach(func)
}

/**
 * Cast the elements of **this** [Iterable] to [U].
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified U> Iterable<*>.mapAs() = this.map { it as U }

/**
* Foreach elements of this [Iterable] as [U]
*/
@Suppress("UNCHECKED_CAST")
inline fun <reified U> Iterable<*>.forEachAs(func: (U) -> Unit) = this.mapAs<U>().forEach(func)