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

import com.github.jonathanxd.codeapi.CodePart;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StackManager {

    private final List<CodePart> stack = new ArrayList<>();

    public void push(CodePart part) {
        this.stack.add(part);
    }

    public void push(List<CodePart> parts) {
        this.stack.addAll(parts);
    }

    public CodePart pop() {
        this.checkEmpty();

        return this.stack.remove(this.stack.size()-1);
    }

    public List<CodePart> pop(int n) {
        this.checkEmpty(n);

        List<CodePart> popped = new ArrayList<>();

        for(int x = n; x < this.stack.size(); ++x) {
            popped.add(this.stack.remove(x));
        }

        return popped;
    }

    public CodePart peek() {
        this.checkEmpty();

        return this.stack.get(this.stack.size()-1);
    }

    public List<CodePart> peek(int n) {
        this.checkEmpty(n);

        return this.stack.subList(n, this.stack.size());
    }

    private void checkEmpty() {
        if(this.stack.isEmpty())
            throw new NoSuchElementException("Empty stack.");
    }

    private void checkEmpty(int n) {
        this.checkEmpty();

        if(this.stack.size() - n < 0)
            throw new NoSuchElementException("Cannot get '"+n+"' elements from stack. Stack size: "+this.stack.size());
    }
}
