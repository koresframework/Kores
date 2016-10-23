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
 * Access to a variable.
 */
public interface VariableAccess extends CodePart, Typed, Accessor {

    /**
     * Gets the localization of the variable.
     *
     * @return Localization of the variable.
     */
    @Override
    Optional<CodeType> getLocalization();

    /**
     * Gets the localization of the variable.
     *
     * @param localization Localization of the variable.
     * @return new instance.
     */
    @Override
    VariableAccess setLocalization(CodeType localization);

    /**
     * Gets the instance of field.
     *
     * @return Instance of field.
     */
    @Override
    Optional<CodePart> getTarget();

    /**
     * Gets the instance of field.
     *
     * @param at Instance of field.
     * @return new instance.
     */
    @Override
    VariableAccess setTarget(CodePart at);

    /**
     * Gets the name of field.
     *
     * @return Name of field.
     */
    String getName();

    /**
     * Gets the name of field.
     *
     * @param name Name of field.
     * @return new instance.
     */
    VariableAccess setName(String name);

    /**
     * Gets the variable value type.
     *
     * @return Variable value type.
     */
    CodeType getVariableType();

    /**
     * Gets the variable value type.
     *
     * @param type Variable value type.
     * @return new instance.
     */
    VariableAccess setVariableType(CodeType type);

    @Override
    VariableAccess setType(CodeType codeType);
}
