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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.interfaces.RequiredTyped;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.interfaces.Valuable;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.Common;
import com.github.jonathanxd.iutils.optional.Require;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents an Argument to be passed to a {@link com.github.jonathanxd.codeapi.interfaces.Argumenterizable}.
 */
public class CodeArgument implements Typed, Valuable, RequiredTyped, CodePart {
    /**
     * Value of Argument
     */
    private final CodePart value;

    /**
     * Generate type cast
     */
    private final boolean casted;

    /**
     * Expected argument type.
     */
    private final CodeType type;

    /**
     * Create a {@link CodeArgument} that receives only the value to pass to an {@link
     * com.github.jonathanxd.codeapi.interfaces.Argumenterizable} part.
     *
     * If you are not passing the {@link TypeSpec} to {@link com.github.jonathanxd.codeapi.interfaces.Argumenterizable},
     * you must to use {@link #CodeArgument(CodePart, CodeType)}. If you don't use that a exception
     * will be thrown.
     *
     * @param value Value to pass to {@link com.github.jonathanxd.codeapi.interfaces.Argumenterizable}
     *              part.
     */
    public CodeArgument(CodePart value) {
        this(value, false, (CodeType) null);
    }

    /**
     * Create a {@link CodeArgument} that receives the value and type.
     *
     * @param value  Value to pass to {@link com.github.jonathanxd.codeapi.interfaces.Argumenterizable}
     *               part.
     * @param casted If true, the generator will cast the value to specified {@code type}.
     * @param type   Expected argument type.
     */
    public CodeArgument(CodePart value, boolean casted, CodeType type) {
        this.value = Objects.requireNonNull(value, "value must no be null.");
        this.casted = casted;
        this.type = type;
    }

    /**
     * Create a {@link CodeArgument} that receives the value and type.
     *
     * @param value Value to pass to {@link com.github.jonathanxd.codeapi.interfaces.Argumenterizable}
     *              part.
     * @param type  Expected argument type.
     */
    public CodeArgument(CodePart value, CodeType type) {
        this(value, false, type);
    }

    /**
     * Create a {@link CodeArgument} that receives the value and type.
     *
     * @param value Value to pass to {@link com.github.jonathanxd.codeapi.interfaces.Argumenterizable}
     *              part.
     * @param type  Expected argument type.
     */
    public CodeArgument(CodePart value, Class<?> type) {
        this(value, false, Helper.getJavaType(type));
    }

    /**
     * Create a {@link CodeArgument} that receives the value and type.
     *
     * @param value  Value to pass to {@link com.github.jonathanxd.codeapi.interfaces.Argumenterizable}
     *               part.
     * @param casted If true, the generator will cast the value to specified {@code type}.
     * @param type   Expected argument type.
     */
    public CodeArgument(CodePart value, boolean casted, Class<?> type) {
        this(value, casted, Helper.getJavaType(type));
    }

    /**
     * True if the {@link #value} may be casted to {@link #type}.
     *
     * @return True if the {@link #value} may be casted to {@link #type}.
     */
    public boolean isCasted() {
        return this.casted;
    }

    @Override
    public Optional<CodePart> getValue() {
        return Optional.of(this.value);
    }

    @Override
    public CodeArgument setValue(CodePart value) {
        return new CodeArgument(value, this.isCasted(), this.getType().orElse(null));
    }

    @Override
    public Optional<CodeType> getType() {
        if (this.type == null) {
            try {
                Common.getType(Require.require(this.getValue(), "Value is required"));
            } catch (Exception e) {
                return Optional.empty();
            }
        }

        return Optional.ofNullable(this.type);
    }

    @Override
    public CodeArgument setType(CodeType codeType) {
        return new CodeArgument(this.getValue().orElse(null), this.isCasted(), codeType);
    }
}
