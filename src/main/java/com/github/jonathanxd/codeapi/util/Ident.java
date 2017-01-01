/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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

/**
 * Internal class undocumented.
 */
public class Ident {

    private final int indentationSize;
    private int ident = 0;

    public Ident(int indentationSize) {
        this.indentationSize = indentationSize;
    }

    public void addIdent() {
        this.addIdent(1);
    }

    public void addIdent(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative value!");
        }
        this.ident += indentationSize * amount;
    }

    public void removeIdent() {
        this.removeIdent(1);
    }

    public void removeIdent(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative value!");
        }
        this.ident -= indentationSize * amount;
    }

    public String getIdentString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.ident; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }
}
