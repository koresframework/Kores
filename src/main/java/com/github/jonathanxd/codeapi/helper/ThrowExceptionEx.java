/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2016 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.helper;

import com.github.jonathanxd.codeapi.abs.AbstractStorage;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.interfaces.ThrowException;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.CodeArgument;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by jonathan on 11/05/16.
 */
@GenerateTo(ThrowException.class)
public class ThrowExceptionEx extends AbstractStorage implements ThrowException<ThrowExceptionEx> {

    private final CodeType exceptionType;
    private final Collection<CodeArgument> arguments;


    protected ThrowExceptionEx(CodeType exceptionType, Collection<CodeArgument> arguments) {
        this.exceptionType = exceptionType;
        this.arguments = Collections.unmodifiableCollection(arguments);
    }

    @Override
    public Optional<CodeType> getExceptionType() {
        return Optional.ofNullable(exceptionType);
    }

    @Override
    public ThrowExceptionEx addArgument(CodeArgument argument) {
        return new ThrowExceptionEx(exceptionType, new ArrayList<CodeArgument>(arguments) {{
            add(argument);
        }});
    }

    @Override
    public Collection<CodeArgument> getArguments() {
        return arguments;
    }

    @Override
    public ThrowExceptionEx clearArguments() {
        return new ThrowExceptionEx(exceptionType, Collections.emptyList());
    }
}
