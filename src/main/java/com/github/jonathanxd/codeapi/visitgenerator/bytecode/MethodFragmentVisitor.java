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
package com.github.jonathanxd.codeapi.visitgenerator.bytecode;

import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.type.TypeInfo;

import org.objectweb.asm.Opcodes;

import java.util.Collection;

/**
 * Created by jonathan on 21/08/16.
 */
public class MethodFragmentVisitor implements Visitor<MethodFragment, Byte, Object>, Opcodes {

    public static final TypeInfo<MethodFragment> FRAGMENT_TYPE_INFO = TypeInfo.aUnique(MethodFragment.class);

    public static void visitFragmentsGeneration(VisitorGenerator<?> visitorGenerator, MapData extraData) {
        Collection<MethodFragment> all = extraData.getAll(MethodFragmentVisitor.FRAGMENT_TYPE_INFO);

        if (!all.isEmpty()) {
            for (MethodFragment methodFragment : all) {
                visitorGenerator.generateTo(MethodFragment.class, methodFragment, extraData, null, null);
            }
        }
    }

    @Override
    public Byte[] visit(MethodFragment methodFragment, MapData extraData, VisitorGenerator<Byte> visitorGenerator, Object additional) {

        if (additional != null && additional instanceof MVData) {
            MVData mvData = (MVData) additional;
            extraData.registerData(MethodFragmentVisitor.FRAGMENT_TYPE_INFO, methodFragment);
            visitorGenerator.generateTo(MethodInvocation.class, methodFragment, extraData, null, mvData);
        } else {
            visitorGenerator.generateTo(MethodDeclaration.class, methodFragment.getMethod(), extraData, null, null);
        }

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r, MethodFragment methodFragment, MapData extraData, VisitorGenerator<Byte> visitorGenerator, Object additional) {

    }
}
