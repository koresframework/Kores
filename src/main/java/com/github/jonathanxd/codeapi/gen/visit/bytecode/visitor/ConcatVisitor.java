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
package com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.gen.visit.VoidVisitor;
import com.github.jonathanxd.codeapi.interfaces.Concat;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.Opcodes;

import java.util.List;

import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.OBJECT;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.STRING;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.STRING_BUILDER;

public class ConcatVisitor implements VoidVisitor<Concat, BytecodeClass, MVData>, Opcodes {

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public void voidVisit(Concat concat,
                          MapData extraData,
                          VisitorGenerator<BytecodeClass> visitorGenerator,
                          MVData mvData) {

        List<CodePart> concatenations = concat.getConcatenations();

        CodePart first = concatenations.isEmpty() ? null : concatenations.get(0);

        if (first != null) {

            if(concatenations.size() == 1) {

                visitorGenerator.generateTo(first.getClass(), first, extraData, mvData);

            } else if(concatenations.size() == 2) {

                MethodInvocation stringConcat = CodeAPI.invokeVirtual(String.class, first, "concat",
                        CodeAPI.typeSpec(String.class, String.class),
                        CodeAPI.argument(concatenations.get(1)));

                visitorGenerator.generateTo(MethodInvocation.class, stringConcat, extraData, mvData);
            } else {

                MethodInvocation strBuilder = CodeAPI.invokeConstructor(StringBuilder.class, CodeAPI.argument(first, String.class));

                for (int i = 1; i < concatenations.size(); i++) {
                    CodePart part = concatenations.get(i);
                    strBuilder = CodeAPI.invokeVirtual(STRING_BUILDER, strBuilder, "append", CodeAPI.typeSpec(STRING_BUILDER, STRING), CodeAPI.argument(part));
                }

                strBuilder = CodeAPI.invokeVirtual(OBJECT, strBuilder, "toString", CodeAPI.typeSpec(STRING));

                visitorGenerator.generateTo(MethodInvocation.class, strBuilder, extraData, mvData);
            }
        } else {
            // If the concatenations is empty
            // It is better to CodeAPI (less things to process), and is better to JVM.
            mvData.getMethodVisitor().visitLdcInsn("");
        }

    }

}
