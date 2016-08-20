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
package com.github.jonathanxd.codeapi.read.bytecode;

import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.function.Predicate;

/**
 * Created by jonathan on 19/08/16.
 */
@GenerateTo(CodeType.class)
public class BytecodeCodeType implements CodeType {

    private final String type;
    private final String canonicalName;
    private final boolean isInterface;
    private final Predicate<CodeType> predicate;

    public BytecodeCodeType(String type, String canonicalName, boolean isInterface) {
        this.type = type;
        this.canonicalName = canonicalName;
        this.isInterface = isInterface;
        this.predicate = null;
    }

    public BytecodeCodeType(String type, String canonicalName, Predicate<CodeType> isInterface) {
        this.type = type;
        this.canonicalName = canonicalName;
        this.isInterface = false;
        this.predicate = isInterface;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getCanonicalName() {
        return this.canonicalName;
    }

    @Override
    public boolean isInterface() {
        if(this.predicate != null)
            return this.predicate.test(this);

        return this.isInterface;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof CodeType)
            return ((CodeType) obj).compareTo(this) == 0;

        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.getJavaSpecName();
    }
}
