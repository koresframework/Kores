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

import com.github.jonathanxd.codeapi.CodeElement;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Static block.
 */
public interface StaticBlock extends CodeElement, MethodDeclaration, Bodied {


    @Override
    default String getName() {
        return Constants.NAME;
    }

    @Override
    default Collection<CodeModifier> getModifiers() {
        return Constants.MODIFIERS;
    }

    @Override
    default List<CodeParameter> getParameters() {
        return Constants.PARAMETERS;
    }

    @Override
    default Optional<CodeType> getReturnType() {
        return Optional.of(Constants.RETURN_TYPE);
    }

    @Override
    default GenericSignature<GenericType> getGenericSignature() {
        return GenericSignature.empty();
    }

    class Constants {
        public static final String NAME = "<clinit>";
        public static final Collection<CodeModifier> MODIFIERS = Collections.singletonList(CodeModifier.STATIC);
        public static final List<CodeParameter> PARAMETERS = Collections.emptyList();
        public static final CodeType RETURN_TYPE = PredefinedTypes.VOID;

        Constants() {
            throw new IllegalStateException("Singleton class.");
        }
    }
}
