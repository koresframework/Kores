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
package com.github.jonathanxd.codeapi.test.bytecode;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeConstructorBuilder;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.test.ResultSaver;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;
import com.github.jonathanxd.iutils.arrays.PrimitiveArrayConverter;

import org.junit.Test;

import java.io.PrintStream;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import static com.github.jonathanxd.codeapi.helper.Helper.accessStaticVariable;
import static com.github.jonathanxd.codeapi.helper.Helper.invoke;
import static com.github.jonathanxd.codeapi.helper.Helper.sourceOf;
import static java.util.Collections.singletonList;

/**
 * Created by jonathan on 03/06/16.
 */
public class TestHelloBytecode {
    @Test
    public void testBytecode() {

        CodeSource codeSource = new CodeSource();

        CodeSource clSource = new CodeSource();

        CodeClass codeClass = new CodeClass("fullName." + this.getClass().getSimpleName(),
                singletonList(CodeModifier.PUBLIC),
                null, null, clSource);

        clSource.add(new CodeField("DEFAULT_VALUE", PredefinedTypes.INT, Literals.INT(17), Arrays.asList(CodeModifier.PUBLIC, CodeModifier.STATIC, CodeModifier.FINAL)));

        CodeConstructor codeConstructor = CodeConstructorBuilder.builder()
                .withDeclaringClass(codeClass)
                .withModifiers(singletonList(CodeModifier.PUBLIC))
                .withBody(sourceOf(
                        // Chama um metodo Virtual (metodos de instancia) na Classe PrintStream
                        invoke(InvokeType.INVOKE_VIRTUAL, PrintStream.class,
                                // Acessa uma variavel estatica 'out' com tipo PrintStream na classe System
                                accessStaticVariable(System.class, "out", PrintStream.class),
                                // Especificação do metodo
                                // Informa que o metodo é println, e retorna um void
                                new MethodSpec("println", Void.TYPE,
                                        // Adiciona um argumento String
                                        // Informa qual o tipo de argumento esperado no metodo, nao necessariamente o que foi passado
                                        singletonList(new CodeArgument(Literals.STRING("Hello World"), String.class))))
                ))
                .build();


        clSource.add(codeConstructor);

        codeSource.add(codeClass);

        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();

        Byte[] gen = bytecodeGenerator.gen(codeSource);

        ResultSaver.save(this.getClass(), gen);

        BCLoader bcLoader = new BCLoader();

        Class<?> define = bcLoader.define("fullName." + this.getClass().getSimpleName(), PrimitiveArrayConverter.toPrimitive(gen));

        Object o;
        try {
            o = define.newInstance();

            int i = (int) MethodHandles.lookup().findStaticGetter(define, "DEFAULT_VALUE", int.class).invoke();

            System.out.println("DEFAULT_VALUE = " + i);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }

    private static final class BCLoader extends ClassLoader {

        public Class<?> define(String name, byte[] bytes) {
            return super.defineClass(name, bytes, 0, bytes.length);
        }
    }
}
