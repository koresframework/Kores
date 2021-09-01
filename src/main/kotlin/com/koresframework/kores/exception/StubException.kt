package com.koresframework.kores.exception

import kotlin.reflect.KCallable
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

class StubException : RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
    constructor(message: String?, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean) : super(
        message,
        cause,
        enableSuppression,
        writableStackTrace
    )
}

@Suppress("NOTHING_TO_INLINE")
public inline fun STUB(fn: KFunction<*>): Nothing = throw StubException("The function '$fn' is a stub function and does not provide an implementation.")

@Suppress("NOTHING_TO_INLINE")
public inline fun STUB(fn: KCallable<*>): Nothing = throw StubException("The callable '$fn' is a stub function and does not provide an implementation.")

@Suppress("NOTHING_TO_INLINE")
public inline fun STUB(fn: KProperty<*>): Nothing = throw StubException("The property '$fn' is a stub function and does not provide an implementation.")

@Suppress("NOTHING_TO_INLINE")
public inline fun STUB(fn: String): Nothing = throw StubException("The function '$fn' is a stub function and does not provide an implementation.")