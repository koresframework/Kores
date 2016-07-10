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
package com.github.jonathanxd.codeapi.common;

import com.github.jonathanxd.codeapi.interfaces.TagLine;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.Common;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 05/06/16.
 */
public class MVData {
    private final MethodVisitor methodVisitor;
    private final List<Variable> variables;
    private final List<Variable> unmod;
    private final List<TagLine<?, ?>> tagLines;

    public MVData(MethodVisitor methodVisitor, List<Variable> variables) {
        this.methodVisitor = methodVisitor;
        this.variables = variables;
        this.unmod = Collections.unmodifiableList(variables);
        this.tagLines = new ArrayList<>();
    }

    public Variable getVar(int i) {
        return variables.get(i);
    }

    public Optional<Variable> getVarByName(String name) {
        return variables.stream().filter(var -> var.getName().equals(name)).findAny();
    }

    public Optional<Variable> getVar(final String name, final CodeType type) {
        if(type == null) {
            return getVarByName(name);
        }

        return variables.stream().filter(var -> var.getName().equals(name) && var.getType().compareTo(type) == 0).findAny();
    }

    public int getVarPos(Variable variable) {
        for (int i = 0; i < this.variables.size(); i++) {
            if(this.variables.get(i).equals(variable))
                return i;
        }

        return -1;
    }

    public int storeVar(final String name, final CodeType type, final Label startLabel, final Label endLabel) {
        Variable variable = new Variable(name, type, startLabel, endLabel);

        for (int i = 0; i < this.variables.size(); i++) {
            Variable variable1 = this.variables.get(i);

            if(variable1.equals(variable)) {
                if(variable1.isTemp()) {
                    throw new RuntimeException("Cannot store variable named '"+name+"'. Variable already stored!");
                }
                return i;
            }
        }

        this.variables.add(variable);
        // ? Last index with synchronized method is good!!!
        return getVarPos(variable);
    }

    public int storeInternalVar(final String name, final CodeType type, final Label startLabel, final Label endLabel) {
        Variable variable = new Variable(name, type, startLabel, endLabel);

        for (int i = 0; i < this.variables.size(); i++) {
            if(this.variables.get(i).equals(variable)) {
                return i;
            }
        }

        this.variables.add(variable);
        // ? Last index with synchronized method is good!!!
        return getVarPos(variable);
    }

    public void redefineVar(final int pos, final String name, final CodeType type, final Label startLabel, final Label endLabel) {
        Variable variable = new Variable(name, type, startLabel, endLabel);

        if(pos >= this.variables.size()) {
            this.variables.add(pos, variable);
        } else {
            if(this.variables.get(pos).isTemp()) {
                throw new RuntimeException("Cannot store variable named '"+name+"'. Variable already stored!");
            }

            this.variables.set(pos, variable);
        }
    }

    public int visitLine(TagLine<?, ?> line) {
        this.tagLines.add(line);

        return this.tagLines.size()-1;
    }

    public int currentPos() {
        return this.variables.size() - 1;
    }

    public List<Variable> getVariables() {
        return this.unmod;
    }

    public MethodVisitor getMethodVisitor() {
        return this.methodVisitor;
    }

    public void visitVars(Label start, Label end) {
        List<Variable> variables = this.getVariables();

        for (int i = 0; i < variables.size(); i++) {
            Variable variable = variables.get(i);

            if(variable.isTemp())
                continue;

            Label varStart = variable.getStartLabel() != null ? variable.getStartLabel() : start;
            Label varEnd = variable.getEndLabel() != null ? variable.getEndLabel() : end;

            String type = Common.codeTypeToFullAsm(variable.getType());

            String signature = null;

            if(variable.getType() instanceof GenericType) {
                signature = Common.toAsm(variable.getType());
            }

            methodVisitor.visitLocalVariable(variable.getName(), type, signature, varStart, varEnd, i);
        }
    }
}
