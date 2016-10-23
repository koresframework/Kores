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
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.Common;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Internal class that holds a {@link MethodVisitor} and data about current stored variables (stack)
 * and tag lines.
 *
 * This class doesn't generate variables bytecode instructions, this class only hold information
 * about them.
 */
public class MVData {
    /**
     * ASM Method visitor
     */
    private final MethodVisitor methodVisitor;

    /**
     * Variables in stack (including {@code this}).
     */
    private final List<Variable> variables;

    /**
     * Unmodifiable variable list.
     */
    private final List<Variable> unmod;

    /**
     * Tag lines for debug.
     */
    private final List<TagLine<?, ?>> tagLines;

    /**
     * Constructor.
     *
     * @param methodVisitor ASM method visitor.
     * @param variables     Initial Variables list.
     */
    public MVData(MethodVisitor methodVisitor, List<Variable> variables) {
        this.methodVisitor = methodVisitor;
        this.variables = variables;
        this.unmod = Collections.unmodifiableList(variables);
        this.tagLines = new ArrayList<>();
    }

    /**
     * Get variable at stack pos {@code i}.
     *
     * @param i Index in the stack.
     * @return Variable or {@link Optional#empty()} if not present.
     */
    public Optional<Variable> getVar(int i) {
        if (i < 0 || i >= this.variables.size())
            return Optional.empty();

        return Optional.of(this.variables.get(i));
    }

    /**
     * Get a variable by name.
     *
     * @param name Name of the variable.
     * @return Variable or {@link Optional#empty()} if not present.
     */
    public Optional<Variable> getVarByName(String name) {
        return this.variables.stream().filter(var -> var.getName().equals(name)).findAny();
    }

    /**
     * Get a variable by name and type.
     *
     * @param name Name of the variable.
     * @param type Type of the variable.
     * @return Variable or {@link Optional#empty()} if not present.
     */
    public Optional<Variable> getVar(final String name, final CodeType type) {
        if (type == null) {
            return this.getVarByName(name);
        }

        return variables.stream().filter(var -> var.getName().equals(name) && var.getType().compareTo(type) == 0).findAny();
    }

    /**
     * Gets the position of a variable instance
     *
     * @param variable Variable instance
     * @return Position of variable if exists, or {@link OptionalInt#empty()} otherwise.
     */
    public OptionalInt getVarPos(Variable variable) {
        for (int i = variables.size() - 1; i >= 0; i--) {
            if (this.variables.get(i).equals(variable))
                return OptionalInt.of(i);
        }

        return OptionalInt.empty();
    }

    /**
     * Store a variable in stack "table".
     *
     * @param name       Name of variable
     * @param type       Type of variable
     * @param startLabel Start label (first occurrence of variable).
     * @param endLabel   End label (last usage of variable).
     * @return {@link OptionalInt} holding the position, or empty if failed to store.
     * @throws RuntimeException if variable is already defined.
     */
    public OptionalInt storeVar(final String name, final CodeType type, final Label startLabel, final Label endLabel) {
        Variable variable = new Variable(name, type, startLabel, endLabel);

        for (int i = this.variables.size() - 1; i >= 0; i--) {
            Variable variable1 = this.variables.get(i);

            if (variable1.equals(variable)) {
                if (variable1.isTemp()) {
                    throw new RuntimeException("Cannot store variable named '" + name + "'. Variable already stored!");
                }

                return OptionalInt.of(i);
            }
        }

        this.variables.add(variable);
        // ? Last index with synchronized method is good!!!
        return this.getVarPos(variable);
    }

    /**
     * Store a internal variable. (internal variables doesn't have their names generated in
     * LocalVariableTable).
     *
     * Name generation could also be avoided using '#' symbol in the variable name.
     *
     * Position of internal variables couldn't be getted by {@link #storeVar(String, CodeType,
     * Label, Label)}.
     *
     * Internal variables could be freely redefined and has no restrictions about the redefinition.
     *
     * @param name       Name of variable
     * @param type       Type of variable
     * @param startLabel Start label (first occurrence of variable).
     * @param endLabel   End label (last usage of variable).
     * @return {@link OptionalInt} holding the position, or empty if failed to store.
     */
    public OptionalInt storeInternalVar(final String name, final CodeType type, final Label startLabel, final Label endLabel) {
        Variable variable = new Variable(name, type, startLabel, endLabel, true);

        for (int i = variables.size() - 1; i >= 0; i--) {
            if (this.variables.get(i).equals(variable)) {
                return OptionalInt.of(i);
            }
        }

        this.variables.add(variable);
        // ? Last index with synchronized method is good!!!
        return this.getVarPos(variable);
    }

    /**
     * Redefine a variable in a {@code position}.
     *
     * @param pos        Position of variable in stack map.
     * @param name       Name of variable
     * @param type       Type of variable
     * @param startLabel Start label (first occurrence of variable).
     * @param endLabel   End label (last usage of variable).
     */
    public void redefineVar(final int pos, final String name, final CodeType type, final Label startLabel, final Label endLabel) {
        Variable variable = new Variable(name, type, startLabel, endLabel);

        if (pos >= this.variables.size()) {
            this.variables.add(pos, variable);
        } else {
            if (this.variables.get(pos).isTemp()) {
                throw new RuntimeException("Cannot store variable named '" + name + "'. Variable already stored!");
            }

            this.variables.set(pos, variable);
        }
    }

    /**
     * Visit a tag line.
     *
     * @param line Tag line.
     * @return Position of the tag line.
     */
    public int visitLine(TagLine<?, ?> line) {
        this.tagLines.add(line);

        return this.tagLines.size() - 1;
    }

    /**
     * Return last position in stack map.
     *
     * @return Last position in stack map.
     */
    public int currentPos() {
        return this.variables.size() - 1;
    }

    /**
     * Gets a immutable list with all variables.
     *
     * @return Immutable list with all variables.
     */
    public List<Variable> getVariables() {
        return this.unmod;
    }

    /**
     * Gets the ASM {@link MethodVisitor}
     *
     * @return ASM {@link MethodVisitor}
     */
    public MethodVisitor getMethodVisitor() {
        return this.methodVisitor;
    }

    /**
     * Generate LocalVariableTable
     *
     * @param start Start of the method.
     * @param end   End of the method.
     */
    public void visitVars(Label start, Label end) {
        List<Variable> variables = this.getVariables();

        for (int i = 0; i < variables.size(); i++) {
            Variable variable = variables.get(i);

            if (variable.isTemp() || variable.getName().contains("#")) // Internal variables
                continue;

            Label varStart = variable.getStartLabel() != null ? variable.getStartLabel() : start;
            Label varEnd = variable.getEndLabel() != null ? variable.getEndLabel() : end;

            String type = Common.codeTypeToFullAsm(variable.getType());

            String signature = null;

            if (variable.getType() instanceof GenericType) {
                signature = Common.toAsm(variable.getType());
            }

            methodVisitor.visitLocalVariable(variable.getName(), type, signature, varStart, varEnd, i);
        }
    }

    /**
     * Generate "find fail" exception to a variable.
     *
     * @param variable Variable failed to find.
     * @return Exception
     */
    public IllegalStateException failFind(Variable variable) {
        return new IllegalStateException("Cannot find variable '" + variable + "' in stack table: " + this.getVariables());
    }

    /**
     * Generate "store fail" exception to a variable.
     *
     * @param o Object failed to be stored.
     * @return Exception
     */
    public IllegalStateException failStore(Object o) {
        return new IllegalStateException("Couldn't store '" + o + "' in stack table: " + this.getVariables());
    }
}
