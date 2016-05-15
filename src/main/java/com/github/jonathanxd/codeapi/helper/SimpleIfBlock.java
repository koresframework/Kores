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
import com.github.jonathanxd.codeapi.interfaces.Expression;
import com.github.jonathanxd.codeapi.interfaces.Group;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by jonathan on 12/05/16.
 */
@GenerateTo(IfBlock.class)
public class SimpleIfBlock extends AbstractStorage implements IfBlock {

    private CodeSource body;

    @Store
    private final Collection<Group> groups = new ArrayList<>();

    @Override
    public void addGroup(Group group) {
        this.groups.add(group);
    }

    @Override
    public Collection<Group> getGroups() {
        return this.groups;
    }

    @Override
    public void clearGroups() {
        this.groups.clear();
    }

    @Override
    public void setBody(CodeSource body) {
        this.body = body;
    }

    @Override
    public Optional<CodeSource> getBody() {
        return Optional.ofNullable(body);
    }

    @Override
    public void removeBody() {
        this.body = null;
    }
}
