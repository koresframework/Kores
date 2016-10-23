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
package com.github.jonathanxd.codeapi.interfaces;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.iutils.optional.Require;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Constructor of array type.
 */
public interface ArrayConstructor extends Typed, CodePart, Argumenterizable {

    /**
     * Gets the type of the array.
     *
     * @return Type of the array.
     */
    CodeType getArrayType();

    /**
     * Sets the array type.
     *
     * @param arrayType Type of the array.
     * @return New instance.
     */
    ArrayConstructor setArrayType(CodeType arrayType);

    /**
     * Gets the array dimensions.
     *
     * @return Array dimensions.
     */
    CodePart[] getDimensions();

    /**
     * Sets the array dimensions.
     *
     * @param dimensions Array dimensions.
     * @return new instance.
     */
    ArrayConstructor setDimensions(CodePart[] dimensions);

    /**
     * Gets the array value list.
     *
     * @return Array value list.
     */
    default List<ArrayStore> getArrayValues() {
        List<CodeArgument> arguments = this.getArguments();
        List<ArrayStore> arrayStores = new ArrayList<>();

        for (int i = 0; i < arguments.size(); i++) {
            CodeArgument argument = arguments.get(i);

            arrayStores.add(Helper.setArrayValue(null, Literals.INT(i), Require.require(argument.getType()), Require.require(argument.getValue())));
        }

        return arrayStores;
    }

    @Override
    default Optional<CodeType> getType() {
        return Optional.ofNullable(this.getArrayType());
    }

    @Override
    ArrayConstructor setType(CodeType codeType);

    @Override
    default boolean isArray() {
        return true;
    }

    @Override
    ArrayConstructor setArguments(List<CodeArgument> codeArgumentList);


}
