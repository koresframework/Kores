/*
 *      ${expr} - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
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
package com.github.jonathanxd.codeapi.test;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MethodType;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.keywords.Keywords;
import com.github.jonathanxd.codeapi.storage.StorageKeys;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.CodeArgument;
import com.github.jonathanxd.codeapi.util.CodeModifier;
import com.github.jonathanxd.codeapi.util.CodeParameter;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import javax.annotation.processing.Processor;

/**
 * Created by jonathan on 02/05/16.
 */
public class CodeAPITest {

    @Test
    public void codeAPITest() {

        // Create a list of CodePart (source)
        CodeSource mySource = new CodeSource();

        // Define a interface
        CodeInterface codeClass = new CodeInterface("github.com.MyClass");

        // Add 'public' modifier
        codeClass.addModifier(CodeModifier.PUBLIC);

        // Adds to source list
        mySource.add(codeClass);

        // Implements Processor class
        codeClass.addImplementation(Helper.getJavaType(Processor.class));

        CodeMethod method = createMethod();


        // Add method to body
        codeClass.add(StorageKeys.BODIES, Helper.sourceOf(method));

        // Generator instance
        PlainSourceGenerator plainSourceGenerator = PlainSourceGenerator.INSTANCE;

        // Generate source
        String source = plainSourceGenerator.gen(mySource);


        // Print source
        System.out.println("source = "+source);
        // Generate: public interface MyClass implements javax.annotation.processing.Processor { { public static void println ( java.lang.Object msg ) { java.lang.System . out . println ( msg ) ; } } }

    }

    private static CodeSource rethrow(String variable) {
        CodeSource source = new CodeSource();

        CodePart trNew = Helper.expression(Keywords.THROW, Helper.expression(Keywords.NEW));

        source.add(Helper.invoke(trNew, new MethodSpec(Helper.getJavaType(RuntimeException.class), MethodType.CONSTRUCTOR)
                .addArgument(new CodeArgument(Helper.accessVariable(Helper.accessLocal(), variable), false, Helper.getJavaType(Throwable.class)))));

        //throw new RuntimeException(e);

        return source;
    }

    private static CodeMethod createMethod() {

        // Declare 'println' method

        CodeMethod codeMethod = new CodeMethod("println");

        // Add parameter 'Object msg'
        codeMethod.add(StorageKeys.PARAMETERS, new CodeParameter("msg", Helper.getJavaType(Object.class)));

        // Add 'public static' modifier
        codeMethod.addAll(StorageKeys.MODIFIERS, CodeModifier.PUBLIC, CodeModifier.STATIC);

        // Set 'void' return type
        codeMethod.setReturnType(Helper.getJavaType(Void.TYPE));

        // Create method body source
        CodeSource source = new CodeSource();


        // 'Localization' of a variable
        CodePart localization = Helper.localizedAtType(Helper.getJavaType(System.class));

        // Access variable in 'localization'
        CodePart variable = Helper.accessVariable(localization, "out");

        // ref local field
        CodeField cf = new CodeField("ref");

        // Type is Object
        cf.setType(Helper.getJavaType(Object.class));

        // Set as final
        cf.addModifier(CodeModifier.FINAL);

        // Value = variable (System.out)
        cf.setValue(variable);

        source.add(cf);

        // Access Local Variable 'msg'
        CodePart msgVar = Helper.accessVariable(Helper.accessLocal(), "msg");

        // Add Invocation of println method declared in 'System.out' ('variable')
        source.add(Helper.invoke(variable, new MethodSpec("println", null, MethodType.METHOD).addArgument(
                // with argument 'msgVar' (Method msg parameter)
                new CodeArgument(msgVar,
                        // Cast type? = false
                        false,
                        // Type to cast (if 'cast type' is set to true)
                        Helper.getJavaType(Object.class)))));


        Collection<CodeType> catchExceptions = Collections.singletonList(Helper.getJavaType(Throwable.class));

        // Surround 'source' with 'try-catch'
        CodePart surround = Helper.surround(source, Collections.singletonList(Helper.catchBlock(catchExceptions, "thr", rethrow("thr"))));

        // Add body to method source
        codeMethod.add(StorageKeys.BODIES, Helper.sourceOf(surround));

        return codeMethod;
    }


}
