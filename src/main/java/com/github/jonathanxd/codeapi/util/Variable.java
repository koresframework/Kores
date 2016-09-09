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
package com.github.jonathanxd.codeapi.util;

import com.github.jonathanxd.codeapi.types.CodeType;

import org.objectweb.asm.Label;

/**
 * Internal class undocumented.
 */
public final class Variable {

    private final String name;
    private final CodeType type;
    private final Label startLabel;
    private final Label endLabel;
    private final boolean isTemp;

    public Variable(String name, CodeType type, Label startLabel, Label endLabel) {
        this(name, type, startLabel, endLabel, false);
    }

    public Variable(String name, CodeType type, Label startLabel, Label endLabel, boolean isTemp) {
        this.name = name;
        this.type = type;
        this.startLabel = startLabel;
        this.endLabel = endLabel;
        this.isTemp = isTemp;
    }

    public boolean isTemp() {
        return isTemp;
    }

    public String getName() {
        return name;
    }

    public CodeType getType() {
        return type;
    }

    public Label getStartLabel() {
        return startLabel;
    }

    public Label getEndLabel() {
        return endLabel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Variable))
            return false;

        return ((Variable) obj).getName().equals(this.getName()) && ((Variable) obj).getType().compareTo(this.getType()) == 0;

    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("name", this.getName())
                .add("type", this.getType())
                .add("isTemp", this.isTemp())
                .add("startLabel", this.getStartLabel())
                .add("endLabel", this.getEndLabel())
                .toString();
    }
}
