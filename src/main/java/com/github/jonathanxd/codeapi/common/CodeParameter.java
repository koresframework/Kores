/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.RequiredTyped;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Representation of element parameters (to be more specific, method parameters).
 */
public class CodeParameter implements Named, Typed, RequiredTyped, CodePart, Annotable {
    /**
     * Name of the parameter
     */
    private final String name;

    /**
     * Type of the parameter
     */
    private final CodeType type;

    /**
     * Annotations of the parameter
     */
    private final List<Annotation> annotations;

    /**
     * Create a Non-annotated parameter.
     *
     * @param name Name of parameter.
     * @param type Type of the parameter.
     */
    public CodeParameter(String name, CodeType type) {
        this(name, type, null);
    }

    /**
     * Create a annotated parameter.
     *
     * @param name        Name of parameter.
     * @param type        Type of the parameter.
     * @param annotations Annotations of parameter.
     */
    public CodeParameter(String name, CodeType type, List<Annotation> annotations) {
        this.name = Objects.requireNonNull(name, "Parameters cannot have null name.");
        this.type = Objects.requireNonNull(type, "Parameters cannot have null type.");
        this.annotations = annotations == null ? Collections.emptyList() : Collections.unmodifiableList(annotations);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public CodeParameter setName(String name) {
        return new CodeParameter(name, this.getType().orElse(null), this.getAnnotations());
    }

    @Override
    public Optional<CodeType> getType() {
        return Optional.of(this.type);
    }

    @Override
    public CodeParameter setType(CodeType codeType) {
        return new CodeParameter(this.getName(), codeType, this.getAnnotations());
    }

    @Override
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override
    public CodeParameter setAnnotations(List<Annotation> annotations) {
        return new CodeParameter(this.getName(), this.getType().orElse(null), annotations);
    }

    @Override
    public String toString() {
        return "CodeParameter[name="+this.getName()+", type="+this.getType()+", annotations="+this.getAnnotations()+"]";
    }
}
