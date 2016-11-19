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
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.List;

public class EmulatedFrame {

    /**
     * Local variable table
     */
    private final LocalVariableTable localVariableTable = new LocalVariableTable();

    /**
     * Operand Stack
     */
    private final StackManager operandStack = new StackManager();

    /**
     * Pushes the values to {@link #localVariableTable}.
     *
     * Example of instructions that store value into Variable Table: istore, astore
     *
     * @param values     Part
     * @param startIndex Start Slot index
     */
    public void storeValues(List<? extends VariableAccess> values, int startIndex) {
        for (int i = 0; i < values.size(); i++) {
            this.store(values.get(i), startIndex + i);
        }

    }

    /**
     * Push the value to {@link #localVariableTable}.
     *
     * Example of instructions that store value into Variable Table: istore, astore
     *
     * @param part  Part
     * @param index Slot index
     */
    public void storeAccess(AccessThis part, int index) {
        this.getLocalVariableTable().store(part, index);
    }

    /**
     * Push the value to {@link #localVariableTable}.
     *
     * Example of instructions that store value into Variable Table: istore, astore
     *
     * @param part  Part
     * @param index Slot index
     */
    public void store(VariableAccess part, int index) {
        this.getLocalVariableTable().store(part, index);
    }

    /**
     * Pop the top value of the {@link #operandStack} and push into {@link #localVariableTable}.
     *
     * @param index Slot index.
     */
    public void storeFromStack(int index) {
        this.store((VariableAccess) this.getOperandStack().pop(), index);
    }

    /**
     * Gets the variable from {@link #localVariableTable}.
     *
     * @param index Slot index
     * @return The Variable.
     */
    public CodePart load(int index) {
        return this.getLocalVariableTable().get(index);
    }

    /**
     * Gets the variable from {@link #localVariableTable} and push to {@link #operandStack}.
     *
     * @param index Slot index
     */
    public void loadToStack(int index) {
        this.operandStack.push(this.load(index));
    }

    public void storeInfo(int slot, CodeType variableType, String variableName) {
        this.getLocalVariableTable().storeVariableInfo(slot, variableType, variableName);
    }

    public LocalVariableTable.VariableInfo getInfo(int slot) {
        return this.getLocalVariableTable().getInfo(slot);
    }

    public LocalVariableTable getLocalVariableTable() {
        return this.localVariableTable;
    }

    public StackManager getOperandStack() {
        return this.operandStack;
    }
}
