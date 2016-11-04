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
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.Visitor;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.EnumDeclaration;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.Generic;
import com.github.jonathanxd.codeapi.util.gen.EnumUtil;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.Opcodes;

import java.util.Collection;

public class EnumVisitor implements Visitor<EnumDeclaration, BytecodeClass, Object>, Opcodes {

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public BytecodeClass[] visit(EnumDeclaration enumDeclaration,
                                 MapData extraData,
                                 VisitorGenerator<BytecodeClass> visitorGenerator,
                                 Object o) {

        Collection<CodeModifier> enumModifiers = EnumUtil.getEnumModifiers(enumDeclaration);
        CodeSource source = EnumUtil.generateEnumClassSource(enumDeclaration);

        TypeDeclaration typeDeclaration = CodeAPI.aClassBuilder()
                .withModifiers(enumModifiers)
                .withQualifiedName(enumDeclaration.getQualifiedName())
                .withSuperClass(Generic.type(PredefinedTypes.ENUM).of(enumDeclaration))
                .withImplementations(enumDeclaration.getImplementations())
                .withBody(source)
                .build();

        return visitorGenerator.generateTo(typeDeclaration.getClass(), typeDeclaration, extraData, o);
    }


}
