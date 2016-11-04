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
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.Visitor;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.util.gen.ConstructorUtil;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 03/06/16.
 */
public class ConstructorVisitor implements Visitor<ConstructorDeclaration, BytecodeClass, Object>, Opcodes {

    public static final ConstructorVisitor INSTANCE = new ConstructorVisitor();

    @Override
    public BytecodeClass[] visit(ConstructorDeclaration codeConstructor, MapData extraData, VisitorGenerator<BytecodeClass> visitorGenerator, Object additional) {

        List<FieldDeclaration> outerFields = extraData.getAllAsList(TypeVisitor.OUTER_FIELD_REPRESENTATION);

        if (!outerFields.isEmpty()) {
            TypeDeclaration typeDeclaration = extraData.getRequired(TypeVisitor.CODE_TYPE_REPRESENTATION, "Cannot find CodeClass. Register 'TypeVisitor.CODE_TYPE_REPRESENTATION'!");

            List<CodeParameter> parameters = new ArrayList<>(codeConstructor.getParameters());
            CodeSource source = CodeSource.fromIterable(codeConstructor.getBody().orElse(CodeSource.empty()));

            for (FieldDeclaration outerField : outerFields) {
                parameters.add(0, new CodeParameter(outerField.getName(), outerField.getVariableType()));

                source =
                        CodeSourceUtil.insertAfterOrEnd(
                                part -> part instanceof MethodInvocation
                                        && ConstructorUtil.isInitForThat(typeDeclaration, (MethodInvocation) part),
                                CodeAPI.sourceOfParts(
                                        CodeAPI.setThisField(outerField.getVariableType(), outerField.getName(),
                                                CodeAPI.accessLocalVariable(outerField.getVariableType(), outerField.getName()))
                                ),
                                source);
            }

            codeConstructor = codeConstructor.setParameters(parameters);
            codeConstructor = codeConstructor.setBody(source);
        }

        visitorGenerator.generateTo(MethodDeclaration.class, codeConstructor, extraData, null, null);

        return new BytecodeClass[0];
    }

}
