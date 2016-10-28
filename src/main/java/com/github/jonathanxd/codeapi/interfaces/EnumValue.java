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
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Optional;

/**
 * Enum value of a {@link Annotation} property.
 */
public interface EnumValue extends Named, Typed, CodePart {

    @Override
    default String getName() {
        return this.getEnumValue();
    }

    @Override
    EnumValue setName(String name);

    @Override
    default Optional<CodeType> getType() {
        return Optional.ofNullable(this.getEnumType());
    }

    @Override
    EnumValue setType(CodeType codeType);

    /**
     * Gets the type of enum.
     *
     * @return Type of enum.
     */
    CodeType getEnumType();

    /**
     * Sets the type of enum.
     *
     * @param codeType Type of enum.
     * @return new instance.
     */
    EnumValue setEnumType(CodeType codeType);

    /**
     * Gets the enum entry name.
     *
     * @return Enum entry name.
     */
    String getEnumValue();

    /**
     * Sets the enum entry name.
     *
     * @param entry Enum entry name.
     * @return new instance.
     */
    EnumValue setEnumValue(String entry);

    /**
     * Gets the ordinal value.
     *
     * @return Ordinal value.
     */
    int getOrdinal();

    /**
     * Sets the ordinal value.
     *
     * @param ordinal Ordinal value.
     * @return new instance.
     */
    EnumValue setOrdinal(int ordinal);
}
