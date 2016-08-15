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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.visitgenerator.Appender;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.iterator.Navigator;

/**
 * Created by jonathan on 03/06/16.
 */
public class CodeSourceVisitor implements Visitor<CodeSource, Byte, Object> {

    public static final CodeSourceVisitor INSTANCE = new CodeSourceVisitor();

    @Override
    public Byte[] visit(CodeSource codeSource, MapData extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, Object additional) {

        Appender<Byte> appender = visitorGenerator.createAppender();

        for (int i = 0; i < codeSource.size(); i++) {
            CodePart codePart = codeSource.get(i);

            Navigator<CodePart> nav = new VisitorGenerator.Nav(codeSource);

            nav.navigateTo(i);

            Class<? extends CodePart> aClass = codePart.getClass();


            visitorGenerator.generateTo(aClass, codePart, extraData, nav, appender::addAll, additional);

        }

        return appender.get();
    }

    @Override
    public void endVisit(Byte[] r, CodeSource codeSource, MapData extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, Object additional) {

    }
}
