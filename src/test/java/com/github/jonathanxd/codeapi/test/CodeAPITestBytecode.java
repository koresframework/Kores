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
package com.github.jonathanxd.codeapi.test;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.generatorv2.ByteVisitGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeClassBuilder;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeFieldBuilder;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.impl.CodeMethodBuilder;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.types.LoadedCodeType;
import com.github.jonathanxd.iutils.arrays.PrimitiveArrayConverter;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jonathan on 02/05/16.
 */
// Will works only if Bytecode Generator is fully complete!
    // No, i need to generate Try-Catch Blocks
    // Generate for, while, do statements, switch, <clint> and improve if statements!
@SuppressWarnings("Duplicates")
public class CodeAPITestBytecode {

    public final String b = "9";

    private static CodeSource rethrow(String variable) {
        CodeSource source = new CodeSource();

        source.add(Predefined.invokePrintln(new CodeArgument(Literals.STRING("Rethrow from var '"+variable+"'!"), PredefinedTypes.STRING)));

        source.add(Helper.invoke(InvokeType.INVOKE_VIRTUAL, Throwable.class, Helper.accessLocalVariable(variable, Throwable.class),
                new MethodSpec("printStackTrace", PredefinedTypes.VOID, Collections.emptyList())));

        /*source.add(Helper.throwException(Helper.getJavaType(RuntimeException.class), new CodeArgument[]{
                new CodeArgument(Helper.accessLocalVariable(variable, Helper.getJavaType(Throwable.class)), false, Helper.getJavaType(Throwable.class))
        }));*/

        //throw new RuntimeException(e);

        return source;
    }

    private static CodePart invokePrintlnMethod(CodePart varToPrint) {
        MethodSpec methodSpec = new MethodSpec("println", Void.TYPE, Collections.singleton(new CodeArgument(varToPrint, false, Object.class)));

        return Helper.invoke(InvokeType.INVOKE_VIRTUAL, Helper.getJavaType(PrintStream.class), Helper.accessVariable(Helper.getJavaType(System.class), "out", PrintStream.class), methodSpec);
    }

    private static CodeMethod createMethod() {

        CodeSource methodSource = new CodeSource();

        // Declare 'println' method
        CodeMethod codeMethod = CodeMethodBuilder.builder()
                .withName("println")
                // Add parameter 'Object msg'
                .withParameters(Collections.singleton(new CodeParameter("msg", Helper.getJavaType(Object.class))))
                // Add 'public static' modifier
                .withModifiers(Arrays.asList(CodeModifier.PUBLIC, CodeModifier.STATIC))
                // Set 'void' return type
                .withReturnType(Helper.getJavaType(Void.TYPE))
                // Set method source
                .withBody(methodSource)
                .build();

        LoadedCodeType<CodeAPITestBytecode> javaType = Helper.getJavaType(CodeAPITestBytecode.class);

        methodSource.add(new CodeField("test", javaType, Helper.invokeConstructor(javaType)));
        methodSource.add(Predefined.invokePrintln(new CodeArgument(
                Helper.accessVariable(javaType, Helper.accessLocalVariable("test", javaType), "b", PredefinedTypes.STRING),
                String.class
        )));

        // Create method body source
        CodeSource source = new CodeSource();

        IfBlock ifBlock = Helper.ifExpression(Helper.createIfVal()
                .add1(Helper.check(Helper.accessLocalVariable("msg", PredefinedTypes.OBJECT), Operators.NOT_EQUAL_TO, Literals.NULL)).make(),
                Helper.sourceOf(invokePrintlnMethod(Helper.accessLocalVariable("msg"))));

        source.add(ifBlock);

        // 'Localization' of a variable
        CodeType localization = Helper.localizedAtType(Helper.getJavaType(System.class));

        // Access variable in 'localization'
        CodePart variable = Helper.accessVariable(localization, "out", Helper.getJavaType(PrintStream.class));

        // ref local field
        CodeField cf = CodeFieldBuilder.builder()
                .withName("ref")
                // Type is Object
                .withType(Helper.getJavaType(Object.class))
                // Set as final
                .withModifiers(Collections.singleton(CodeModifier.FINAL))
                // Value = variable (System.out)
                .withValue(variable)
                .build();

        source.add(cf);

        source.add(Helper.throwException(
                Helper.getJavaType(IllegalStateException.class), new CodeArgument[]{new CodeArgument(Literals.STRING("Error"), false, PredefinedTypes.STRING)}));

        // Access Local Variable 'msg'
        CodePart msgVar = Helper.accessLocalVariable("msg", PredefinedTypes.OBJECT);

        // Add Invocation of println method declared in 'System.out' ('variable')
        source.add(Helper.invoke(InvokeType.INVOKE_VIRTUAL, Helper.getJavaType(PrintStream.class), variable,
                new MethodSpec("println", Collections.singletonList(
                        // with argument 'msgVar' (Method msg parameter)
                        new CodeArgument(msgVar,
                                // Cast type? = false
                                false,
                                // Type to cast (if 'cast type' is set to true)
                                Helper.getJavaType(Object.class))
                ), Helper.getJavaType(Void.TYPE), MethodType.METHOD)));


        List<CodeType> catchExceptions = Arrays.asList(Helper.getJavaType(IllegalArgumentException.class), Helper.getJavaType(IllegalStateException.class));

        List<CodeType> catchExceptions2 = Arrays.asList(Helper.getJavaType(IOException.class), Helper.getJavaType(ClassNotFoundException.class));

        // Finally block

        CodeSource finallySource = Helper.sourceOf(Predefined.invokePrintln(new CodeArgument(Literals.STRING("Finally!"), String.class)));

        // Surround 'source' with 'try-catch'
        CodePart surround = Helper.surround(source, Arrays.asList(Helper.catchBlock(catchExceptions, "thr", rethrow("thr")),
                Helper.catchBlock(catchExceptions2, "tlr", rethrow("tlr"))),
                finallySource);

        // Add body to method source
        methodSource.add(surround);

        return codeMethod;
    }

    @Test
    public void codeAPITest() {

        // Create a list of CodePart (source)
        CodeSource mySource = new CodeSource();

        // Create source of 'codeClass'
        CodeSource codeClassSource = new CodeSource();

        // Define a interface
        CodeClass codeClass = CodeClassBuilder.builder()
                .withQualifiedName("github.com."+this.getClass().getSimpleName())
                // Add 'public' modifier
                .withModifiers(Collections.singletonList(CodeModifier.PUBLIC))
                // CodeClass Source
                .withBody(codeClassSource)
                .build();

        // Adds to source list
        mySource.add(codeClass);

        CodeMethod method = createMethod();

        // Add method to body
        codeClassSource.add(method);

        ByteVisitGenerator generator = new ByteVisitGenerator();

        Byte[] gen = generator.gen(mySource);

        byte[] bytes = PrimitiveArrayConverter.toPrimitive(gen);

        ResultSaver.save(this.getClass(), bytes);

        Class<?> define = new BCLoader().define("github.com."+this.getClass().getSimpleName(), bytes);

        try {
            define.newInstance();

            MethodHandles.Lookup lookup = MethodHandles.publicLookup();

            MethodHandle println = lookup.findStatic(define, "println", java.lang.invoke.MethodType.methodType(Void.TYPE, Object.class));

            println.invoke((Object) "nano");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static final class BCLoader extends ClassLoader {

        public Class<?> define(String name, byte[] bytes) {
            return super.defineClass(name, bytes, 0, bytes.length);
        }
    }
    // TODO: LOW LEVEL TASK -> UPDATE

}
