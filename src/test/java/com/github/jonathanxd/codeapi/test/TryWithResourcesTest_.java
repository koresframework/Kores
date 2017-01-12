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
package com.github.jonathanxd.codeapi.test;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.TryWithResources;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.factory.ClassFactory;
import com.github.jonathanxd.codeapi.factory.ConstructorFactory;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.type.LoadedCodeType;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import java.util.Collections;
import java.util.EnumSet;

import static com.github.jonathanxd.codeapi.CodeAPI.sourceOfParts;
import static java.lang.reflect.Modifier.PUBLIC;

public class TryWithResourcesTest_ {
    //

    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {

        LoadedCodeType<Trm> TRM_TYPE = CodeAPI.getJavaType(Trm.class);

        TryWithResources tryWithResources = CodeAPI.tryWithResources(
                VariableFactory.variable(TRM_TYPE, "trm", CodeAPI.invokeConstructor(TRM_TYPE)),
                CodeAPI.source(
                        CodeAPI.invokeVirtual(TRM_TYPE, CodeAPI.accessLocalVariable(TRM_TYPE, "trm"), "read", new TypeSpec(Types.VOID), Collections.emptyList())
                )
        );


        ClassDeclaration classDeclaration = ClassFactory.aClass(EnumSet.of(CodeModifier.PUBLIC),
                "test.TryWithResourcesTestClass", sourceOfParts(
                        ConstructorFactory.constructor(EnumSet.of(CodeModifier.PUBLIC), CodeAPI.source(
                                tryWithResources
                        ))
                ));

        return Pair.of(classDeclaration, sourceOfParts(classDeclaration));
    }


    public static class Trm implements AutoCloseable {

        public void read() throws Throwable {
            throw new IllegalStateException("Unable to read");
        }

        @Override
        public void close() throws Exception {
            throw new IllegalStateException("Failed to close");
        }
    }
}
