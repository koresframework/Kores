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
import com.github.jonathanxd.codeapi.CodeRoot;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Declaration of a {@code method}.
 */
public interface MethodDeclaration extends CodeElement, Returnable, Bodied, Parameterizable, Named, Modifierable, Generifiable, CodeRoot, Annotable, Typed {
    @Override
    MethodDeclaration setName(String name);

    @Override
    MethodDeclaration setBody(CodeSource body);

    @Override
    MethodDeclaration setAnnotations(List<Annotation> annotations);

    @Override
    MethodDeclaration setReturnType(CodeType returnType);

    @Override
    MethodDeclaration setParameters(List<CodeParameter> codeParameters);

    @Override
    MethodDeclaration setModifiers(Collection<CodeModifier> modifiers);

    @Override
    MethodDeclaration setGenericSignature(GenericSignature<GenericType> genericSignature);

    @Override
    default Optional<CodeType> getType() {
        return this.getReturnType();
    }

    @Override
    MethodDeclaration setType(CodeType codeType);
}
