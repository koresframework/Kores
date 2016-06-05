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
package com.github.jonathanxd.codeapi.generatorv2;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.generatorv2.bytecode.CodeSourceVisitor;
import com.github.jonathanxd.codeapi.generatorv2.bytecode.ConstructorVisitor;
import com.github.jonathanxd.codeapi.generatorv2.bytecode.FieldVisitor;
import com.github.jonathanxd.codeapi.generatorv2.bytecode.InterfaceVisitor;
import com.github.jonathanxd.codeapi.generatorv2.bytecode.LiteralVisitor;
import com.github.jonathanxd.codeapi.generatorv2.bytecode.MethodInvocationVisitor;
import com.github.jonathanxd.codeapi.generatorv2.bytecode.PackageVisitor;
import com.github.jonathanxd.codeapi.generatorv2.bytecode.VariableAccessVisitor;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.PackageDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.iutils.arrays.Arrays;

/**
 * Created by jonathan on 03/06/16.
 */
public class ByteVisitGenerator extends VisitorGenerator<Byte> {


    public ByteVisitGenerator() {
        addVisitor(PackageDeclaration.class, new PackageVisitor());
        addVisitor(CodeInterface.class, new InterfaceVisitor());
        addUncheckedVisitor(CodeClass.class, new InterfaceVisitor());
        addVisitor(CodeField.class, new FieldVisitor());
        addVisitor(CodeSource.class, new CodeSourceVisitor());
        addVisitor(CodeConstructor.class, new ConstructorVisitor());
        addVisitor(Literal.class, new LiteralVisitor());
        addVisitor(MethodInvocation.class, new MethodInvocationVisitor());
        addVisitor(VariableAccess.class, new VariableAccessVisitor());
    }

    @Override
    public Appender<Byte> createAppender() {
        return new ByteAppender();
    }

    private static class ByteAppender extends Appender<Byte> {

        Arrays<Byte> byteArrays = new Arrays<>();

        ByteAppender() {

        }

        @Override
        public void add(Byte elem) {
            byteArrays.add(elem);
        }

        @Override
        public Byte[] get() {
            return byteArrays.toGenericArray(Byte[].class);
        }
    }

}
