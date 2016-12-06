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
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.InstructionCodePart;
import com.github.jonathanxd.codeapi.util.collection.CollectionUtil;
import com.github.jonathanxd.iutils.object.IntNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StackManager {
    private static final Predicate<CodePart> NOT_IP = part -> !(part instanceof InstructionCodePart);

    private final List<CodePart> stack = new ArrayList<>();

    public void push(CodePart part) {
        this.stack.add(part);
    }

    public void push(List<CodePart> parts) {
        this.stack.addAll(parts);
    }

    @SuppressWarnings("unchecked")
    public <T> T popAs(Class<T> type) {
        CodePart pop = this.pop();

        if(!type.isInstance(pop))
            throw new ClassCastException("Value '"+pop+"' popped from stack cannot be cast to '"+type+"'!");

        return (T) pop;
    }

    public List<CodePart> popAll() {
        List<CodePart> popped = new ArrayList<>(this.stack);

        this.stack.clear();

        return popped;
    }

    public CodePart pop() {
        this.checkEmpty();

        this.checkEmpty();

        for (int i = this.stack.size() - 1; i >= 0; i--) {
            CodePart codePart = this.stack.get(i);

            if(!(codePart instanceof InstructionCodePart)) {
                return this.stack.remove(i);
            }
        }

        throw new IllegalStateException("Cannot peek value from stack.");
    }

    public CodePart peek() {
        this.checkEmpty();

        for (int i = this.stack.size() - 1; i >= 0; i--) {
            CodePart codePart = this.stack.get(i);

            if(!(codePart instanceof InstructionCodePart))
                return codePart;
        }

        throw new IllegalStateException("Cannot peek value from stack.");
    }

    public List<CodePart> pop(int n) {
        if(n == 0)
            return new ArrayList<>();

        this.checkEmpty(n);

        List<IntNode<CodePart>> intNodes = CollectionUtil.filterWithIndex(this.stack, StackManager.NOT_IP);

        int size = intNodes.size();
        int start = size - n;

        List<IntNode<CodePart>> sub = intNodes.subList(start, intNodes.size());

        List<CodePart> result = sub.stream().map(IntNode::getValue).collect(Collectors.toList());

        CollectionUtil.remove(this.stack, sub.stream().mapToInt(IntNode::getKey).toArray());

        return result;
    }

    private List<CodePart> peek(int n) {
        if(n == 0)
            return new ArrayList<>();

        this.checkEmpty(n);

        List<CodePart> collect = this.stack.stream().filter(codePart -> !(codePart instanceof InstructionCodePart)).collect(Collectors.toList());

        int size = collect.size();
        int start = size - n;

        return new ArrayList<>(collect.subList(start, size));
    }

    private void checkEmpty() {
        if(this.stack.stream().noneMatch(StackManager.NOT_IP))
            throw new NoSuchElementException("Empty stack.");
    }

    private void checkEmpty(int n) {
        this.checkEmpty();

        if(this.stack.stream().filter(StackManager.NOT_IP).count() - n < 0)
            throw new NoSuchElementException("Cannot get '"+n+"' elements from stack. Stack size: "+this.stack.size());
    }
}
