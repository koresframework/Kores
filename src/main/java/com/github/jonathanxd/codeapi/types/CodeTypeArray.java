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
package com.github.jonathanxd.codeapi.types;

import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.generatorv2.bytecode.Common;

/**
 * Created by jonathan on 18/06/16.
 */
@GenerateTo(CodeType.class)
class CodeTypeArray implements CodeType {

    private final CodeType component;
    private final int size;

    CodeTypeArray(CodeType component, int size) {
        this.component = component;
        this.size = size;
    }

    @Override
    public String getType() {
        String name = component.getType();

        StringBuilder sb = new StringBuilder();

        for(int x = 0; x < size; ++x)
            sb.append("[]");

        return name + sb.toString();
    }

    @Override
    public String getJavaSpecName() {
        return Common.codeTypeToArray(component, size);
    }

    @Override
    public boolean isVirtual() {
        return component.isVirtual();
    }

    @Override
    public boolean isInterface() {
        return component.isInterface();
    }

    @Override
    public boolean isPrimitive() {
        return component.isPrimitive();
    }

    @Override
    public boolean isExpression() {
        return component.isExpression();
    }
}
