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
package com.github.jonathanxd.codeapi.helper;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.abs.AbstractStorage;
import com.github.jonathanxd.codeapi.annotation.Store;
import com.github.jonathanxd.codeapi.gen.GenericGenerator;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.util.CodeParameter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by jonathan on 11/05/16.
 */
public class CatchExBlock extends AbstractStorage implements CatchBlock, GenericGenerator {

    @Store(CodeSource.class)
    private final Collection<CodeSource> bodies = new ArrayList<>();

    @Store(CodeParameter.class)
    private final Collection<CodeParameter> parameters = new ArrayList<>();

    @Override
    public void addBody(CodeSource body) {
        this.bodies.add(body);
    }

    @Override
    public Collection<CodeSource> getBodies() {
        return this.bodies;
    }

    @Override
    public void clearBodies() {
        this.bodies.clear();
    }

    @Override
    public void addParameter(CodeParameter parameter) {
        this.parameters.add(parameter);
    }

    @Override
    public Collection<CodeParameter> getParameters() {
        return this.parameters;
    }

    @Override
    public void clearParameters() {
        this.parameters.clear();
    }

}
