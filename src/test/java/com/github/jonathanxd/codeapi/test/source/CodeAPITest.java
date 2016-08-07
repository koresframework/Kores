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
package com.github.jonathanxd.codeapi.test.source;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeFieldBuilder;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeInterfaceBuilder;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.impl.CodeMethodBuilder;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.CodeType;

import org.junit.Test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.processing.Processor;

import static com.github.jonathanxd.codeapi.helper.Helper.getJavaType;

/**
 * Created by jonathan on 02/05/16.
 */
public class CodeAPITest {

    private static CodeSource rethrow(String variable) {
        CodeSource source = new CodeSource();

        source.add(Helper.throwException(getJavaType(RuntimeException.class), new CodeArgument[]{
                new CodeArgument(Helper.accessLocalVariable(variable, getJavaType(String.class)), false, getJavaType(Throwable.class))
        }));
        //throw new RuntimeException(e);

        return source;
    }

    private static CodePart invokePrintlnMethod(CodePart varToPrint) {
        MethodSpec methodSpec = new MethodSpec("println", Collections.singletonList(new CodeArgument(varToPrint)));

        return Helper.invoke(InvokeType.INVOKE_VIRTUAL, /*Null because source generator works ok*/ (CodeType) null, Helper.accessVariable(Helper.localizedAtType(getJavaType(System.class)), "out", getJavaType(OutputStream.class)), methodSpec);
    }

    private static CodeMethod createMethod() {

        CodeSource methodSource = new CodeSource();

        // Declare 'println' method

        CodeMethod codeMethod = CodeMethodBuilder.builder()
                .withName("println")
                // Add parameter 'Object msg'
                .withParameters(Collections.singletonList(new CodeParameter("msg", getJavaType(Object.class))))
                // Add 'public static' modifier
                .withModifiers(Arrays.asList(CodeModifier.PUBLIC, CodeModifier.STATIC))
                // Set 'void' return type
                .withReturnType(getJavaType(Void.TYPE))
                // Define method source
                .withBody(methodSource)
                .build();

        // Create method body source
        CodeSource source = new CodeSource();

        IfBlock ifBlock = Helper.ifExpression(Helper.createIfVal()
                        .add1(Helper.checkNotNull(Helper.accessLocalVariable("msg", getJavaType(String.class)))).make(),
                Helper.sourceOf(invokePrintlnMethod(Helper.accessLocalVariable("msg", getJavaType(String.class)))));

        source.add(ifBlock);

        // 'Localization' of a variable
        CodeType localization = getJavaType(System.class);

        // Access variable in 'localization'
        CodePart variable = Helper.accessVariable(localization, "out", getJavaType(OutputStream.class));

        // ref local field
        CodeField cf = CodeFieldBuilder.builder()
                .withName("ref")
                // Type is Object
                .withType(getJavaType(Object.class))
                // Set as final
                .withModifiers(Collections.singleton(CodeModifier.FINAL))
                // Value = variable (System.out)
                .withValue(variable)
                .build();

        source.add(cf);

        // Access Local Variable 'msg'
        CodePart msgVar = Helper.accessLocalVariable("msg", getJavaType(String.class));

        // Add Invocation of println method declared in 'System.out' ('variable')
        source.add(Helper.invoke(InvokeType.INVOKE_VIRTUAL, /*Null because source generator works ok*/PrintStream.class, variable, new MethodSpec(
                "println", Collections.singletonList(
                // with argument 'msgVar' (Method msg parameter)
                new CodeArgument(msgVar,
                        // Cast type? = false
                        false,
                        // Type to cast (if 'cast type' is set to true)
                        getJavaType(Object.class))), PredefinedTypes.VOID, MethodType.METHOD)));

        source.add(Helper.invoke(InvokeType.INVOKE_STATIC, CodeAPITest.class, null,
                new MethodSpec("test",
                        new TypeSpec(PredefinedTypes.VOID),
                        Arrays.asList(new CodeArgument(Literals.STRING("Test"))))));

        List<CodeType> catchExceptions = Collections.singletonList(getJavaType(Throwable.class));

        // Surround 'source' with 'try-catch'
        CodePart surround = Helper.surround(source, Collections.singletonList(Helper.catchBlock(catchExceptions, "thr", rethrow("thr"))));

        // Add body to method source
        methodSource.add(Helper.sourceOf(surround));

        return codeMethod;
    }

    public static void test(String aj) {
        System.out.println(aj);
    }

    @Test
    public void codeAPITest() {

        // Create a list of CodePart (source)
        CodeSource mySource = new CodeSource();

        CodeMethod method = createMethod();

        // Define a interface
        CodeInterface codeClass = CodeInterfaceBuilder.builder()
                .withQualifiedName("github.com.MyClass")
                // Add 'public' modifier
                .withModifiers(Collections.singletonList(CodeModifier.PUBLIC))
                // Implements Processor class
                .withImplementations(Collections.singletonList(getJavaType(Processor.class)))
                // Define body
                .withBody(Helper.sourceOf(method))
                .build();

        // Adds to source list
        mySource.add(codeClass);


        // Generator instance
        PlainSourceGenerator plainSourceGenerator = PlainSourceGenerator.INSTANCE;

        // Generate source
        String source = plainSourceGenerator.gen(mySource);


        // Print source
        System.out.println("source = " + source);
        // Generate: public interface MyClass implements javax.annotation.processing.Processor { { public static void println ( java.lang.Object msg ) { java.lang.System . out . println ( msg ) ; } } }

        //if(x) { } else { }

        // Helper.ifExpression(Keywords.IF,
        //   Helper.expressions(
        //     Helper.accessVariable(local(), "x")
        //   )
        //   , IFBODY, Helper.elseExpression(BODY | EXPRESSION))

        // if(x || y) { } else { }

        // Helper.ifExpression(Keywords.IF,
        //   Helper.expressions(
        //     Helper.accessVariable(local(), "x"),
        //     Helper.operator(Operators.OR) // Operators.BITWISE_AND
        //   )
        //   , IFBODY, Helper.elseExpression(BODY | EXPRESSION))

    }
}