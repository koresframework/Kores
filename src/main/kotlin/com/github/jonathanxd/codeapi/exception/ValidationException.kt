/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
 *      Copyright (c) contributors
 *
 *
 *      Permission is hereby granted, free of charge, to any person obtaining a copy
 *      of this software and associated documentation files (the "Software"), to deal
 *      in the Software without restriction, including without limitation the rights
 *      to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *      copies of the Software, and to permit persons to whom the Software is
 *      furnished to do so, subject to the following conditions:
 *
 *      The above copyright notice and this permission notice shall be included in
 *      all copies or substantial portions of the Software.
 *
 *      THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *      IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *      FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *      AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *      LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *      OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *      THE SOFTWARE.
 */
package com.github.jonathanxd.codeapi.exception

import com.github.jonathanxd.codeapi.processor.ContextedValidationMessage
import com.github.jonathanxd.codeapi.processor.ValidationMessage
import com.github.jonathanxd.codeapi.processor.toMessage

/**
 * Occurs when validation fails.
 */
class ValidationException : RuntimeException {

    constructor() : super()
    constructor(message: String) : super(message)
    constructor(cause: Throwable) : super(cause)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(
        message: String,
        cause: Throwable,
        enableSuppression: Boolean,
        writableStackTrace: Boolean
    ) :
            super(message, cause, enableSuppression, writableStackTrace)

    constructor(message: ValidationMessage) : this(message.toMessage())
    constructor(message: ValidationMessage, cause: Throwable) : this(message.toMessage(), cause)
    constructor(
        message: ValidationMessage,
        cause: Throwable,
        enableSuppression: Boolean,
        writableStackTrace: Boolean
    ) :
            super(message.toMessage(), cause, enableSuppression, writableStackTrace)

    constructor(message: ContextedValidationMessage) : this(message.toMessage())
    constructor(message: ContextedValidationMessage, cause: Throwable) : this(
        message.toMessage(),
        cause
    )

    constructor(
        message: ContextedValidationMessage,
        cause: Throwable,
        enableSuppression: Boolean,
        writableStackTrace: Boolean
    ) :
            super(message.toMessage(), cause, enableSuppression, writableStackTrace)

}