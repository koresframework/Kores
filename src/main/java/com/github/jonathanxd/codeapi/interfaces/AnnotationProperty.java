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

import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.List;
import java.util.Optional;

public interface AnnotationProperty extends Named, Typed, RequiredTyped, Annotable, Returnable {
    @Override
    AnnotationProperty setName(String name);

    @Override
    AnnotationProperty setAnnotations(List<Annotation> annotations);

    /**
     * Gets the annotation value.
     *
     * @return Annotation value.
     */
    Optional<Object> getValue();

    /**
     * Sets the annotation value.
     *
     * The Annotation value must be: {@link Byte}, {@link Boolean}, {@link Character}, {@link
     * Short}, {@link Integer}, {@link Long}, {@link Float}, {@link Double}, {@link String}, {@link
     * CodeType}, OBJECT, ARRAY, {@link EnumValue} or other {@link Annotation}.
     *
     * @param value Annotation value.
     * @return new instance.
     */
    AnnotationProperty setValue(Object value);

    @Override
    AnnotationProperty setType(CodeType codeType);

    @Override
    default Optional<CodeType> getReturnType() {
        return this.getType();
    }

    @Override
    default AnnotationProperty setReturnType(CodeType returnType) {
        return this.setType(returnType);
    }
}
