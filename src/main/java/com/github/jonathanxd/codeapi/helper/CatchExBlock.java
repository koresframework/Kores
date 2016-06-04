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
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.annotation.Store;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.Parameterizable;
import com.github.jonathanxd.codeapi.util.CodeParameter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by jonathan on 11/05/16.
 */
@GenerateTo(CatchBlock.class)
public class CatchExBlock extends AbstractStorage implements CatchBlock<CatchExBlock> {

    @Store(CodeSource.class)
    private final Collection<CodeSource> bodies;

    @Store(CodeParameter.class)
    private final Collection<CodeParameter> parameters;

    public CatchExBlock(Collection<CodeSource> bodies, Collection<CodeParameter> parameters) {
        this.bodies = bodies == null ? Collections.emptyList() : Collections.unmodifiableCollection(bodies);
        this.parameters = parameters == null ? Collections.emptyList() : Collections.unmodifiableCollection(parameters);
    }

    @Override
    public CatchExBlock addBody(CodeSource body) {
        return new CatchExBlock(new ArrayList<CodeSource>(bodies){{
            add(body);
        }}, parameters);
    }

    @Override
    public Collection<CodeSource> getBodies() {
        return this.bodies;
    }

    @Override
    public CatchExBlock clearBodies() {
        return new CatchExBlock(Collections.emptyList(), parameters);
    }

    @Override
    public Parameterizable addParameter(CodeParameter parameter) {
        return new CatchExBlock(bodies, new ArrayList<CodeParameter>(parameters){{
            add(parameter);
        }});
    }

    @Override
    public Collection<CodeParameter> getParameters() {
        return this.parameters;
    }

    @Override
    public Parameterizable clearParameters() {
        return new CatchExBlock(bodies, Collections.emptyList());
    }

}
