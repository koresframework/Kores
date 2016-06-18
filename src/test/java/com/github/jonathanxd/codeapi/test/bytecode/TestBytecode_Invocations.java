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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.FullLoadedMethodSpec;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeConstructorBuilder;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.VariableStore;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.test.Greeter;
import com.github.jonathanxd.codeapi.test.ResultSaver;
import com.github.jonathanxd.codeapi.test.WorldGreeter;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;
import com.github.jonathanxd.iutils.arrays.ArrayUtils;
import com.github.jonathanxd.iutils.arrays.PrimitiveArrayConverter;

import org.junit.Test;

import java.io.PrintStream;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Supplier;

import static com.github.jonathanxd.codeapi.helper.Helper.accessStaticVariable;
import static com.github.jonathanxd.codeapi.helper.Helper.invoke;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * Created by jonathan on 03/06/16.
 */
public class TestBytecode_Invocations {
    public static final TestBytecode_Invocations INSTANCE = new TestBytecode_Invocations();
    public static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();
    public static final FullLoadedMethodSpec BOOTSTRAP_SPEC = new FullLoadedMethodSpec(
            TestBytecode_Invocations.class,
            CallSite.class,
            "myBootstrap",
            MethodHandles.Lookup.class, String.class, MethodType.class, Object[].class);

    public static final MethodHandle FALLBACK;

    static {
        try {
            FALLBACK = LOOKUP.findStatic(
                    TestBytecode_Invocations.class,
                    "fallback",
                    MethodType.methodType(Object.class, MyCallSite.class, Object[].class));
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static CodePart invokePrintln(CodeArgument toPrint) {
        MethodSpec spec = new MethodSpec("println", Helper.getJavaType(Void.TYPE), Collections.singletonList(toPrint));

        return Helper.invoke(InvokeType.INVOKE_VIRTUAL, Helper.getJavaType(PrintStream.class),
                Helper.accessVariable(Helper.getJavaType(System.class), "out", Helper.getJavaType(PrintStream.class)), spec);
    }

    public static void bmp(String a, String b) {
        System.out.println("A = " + a + ", B = " + b);
    }

    public static CallSite myBootstrap(MethodHandles.Lookup caller, String name,
                                       MethodType type, Object... parameters) throws Throwable {

        MethodHandle virtual = LOOKUP.findVirtual(TestBytecode_Invocations.class, name, type);

        MyCallSite myCallSite = new MyCallSite(caller, name, type);

        MethodHandle methodHandle = FALLBACK.bindTo(myCallSite).asCollector(Object[].class, type.parameterCount()).asType(type);

        myCallSite.setTarget(methodHandle);

        return myCallSite;
    }

    public static Object fallback(MyCallSite callSite, Object[] args) throws Throwable {
        MethodHandle virtual = LOOKUP.findVirtual(TestBytecode_Invocations.class, callSite.name, callSite.type()).bindTo(INSTANCE);

        System.out.println("Invoking '"+callSite.name+"' type: '"+callSite.getTarget().type()+"', with args: '"+Arrays.toString(args)+"' ");

        return virtual.invokeWithArguments(args);
    }

    @Test
    public void testBytecode() {

        CodeSource codeSource = new CodeSource();
        CodeSource clSource = new CodeSource();

        CodeClass codeClass = new CodeClass("fullName." + this.getClass().getSimpleName() + "_Generated",
                java.util.Arrays.asList(CodeModifier.PUBLIC),
                null, null, clSource);

        CodeField codeField = new CodeField("FIELD",
                Helper.getJavaType(String.class),
                Literals.QUOTED_STRING("AVD"), java.util.Arrays.asList(CodeModifier.PUBLIC, CodeModifier.FINAL)
        );

        CodeField codeField2 = new CodeField("n",
                Helper.getJavaType(Integer.TYPE),
                Literals.INT(15), java.util.Arrays.asList(CodeModifier.PUBLIC, CodeModifier.FINAL)
        );

        clSource.add(codeField);
        clSource.add(codeField2);

        MethodSpec spec = new MethodSpec("println", Helper.getJavaType(Void.TYPE), Collections.singletonList(new CodeArgument(Literals.QUOTED_STRING("Hello"), false, Helper.getJavaType(String.class))));

        CodePart invokeTest = Helper.invoke(InvokeType.INVOKE_VIRTUAL, Helper.getJavaType(PrintStream.class),
                Helper.accessVariable(Helper.getJavaType(System.class), "out", Helper.getJavaType(PrintStream.class)), spec);

        CodePart invokeTest2 = Helper.invoke(InvokeType.INVOKE_VIRTUAL, codeClass,
                Helper.accessThis(), new MethodSpec("printIt", Helper.getJavaType(Void.TYPE),
                        Collections.singletonList(
                                new CodeArgument(Literals.STRING("Oi"), false, Helper.getJavaType(Object.class)))));

        CodeConstructor codeConstructor = CodeConstructorBuilder.builder()
                .withDeclaringClass(codeClass)
                .withModifiers(java.util.Arrays.asList(CodeModifier.PUBLIC))
                .withBody(Helper.sourceOf(invokeTest, invokeTest2))
                .build();

        clSource.add(codeConstructor);

        clSource.add(makeCM());
        clSource.add(makeCM2());

        codeSource.add(codeClass);

        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();

        Byte[] gen = bytecodeGenerator.gen(codeSource);

        byte[] bytes = PrimitiveArrayConverter.toPrimitive(gen);

        ResultSaver.save(this.getClass(), bytes);

        BCLoader bcLoader = new BCLoader(this.getClass().getClassLoader());

        Class<?> define = bcLoader.define("fullName." + this.getClass().getSimpleName() + "_Generated", bytes);

        System.out.println("Class -> " + Modifier.toString(define.getModifiers()) + " " + define);

        Object o;
        try {
            o = define.newInstance();
            MethodHandles.Lookup lookup = MethodHandles.publicLookup();

            MethodHandle printIt = lookup.findVirtual(define, "printIt", MethodType.methodType(Void.TYPE, Object.class)).bindTo(o);

            try {
                System.out.println("NAO DEVE FALAR HELLO");
                printIt.invoke((Object) null);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            MethodHandle check = lookup.findVirtual(define, "check", MethodType.methodType(Boolean.TYPE, Integer.TYPE)).bindTo(o);

            try {
                System.out.println("CHECK NINE");
                boolean invoke = (boolean) check.invoke(9);

                System.out.println("Invoke = " + invoke);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        for (Field field : define.getDeclaredFields()) {
            try {
                System.out.println("Field -> " + field + " = " + field.get(o));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public CodeMethod makeCM() {
        CodeSource methodSource = new CodeSource();

        CodeMethod codeMethod = new CodeMethod("printIt", Collections.singletonList(CodeModifier.PUBLIC),
                Collections.singleton(new CodeParameter("n", Helper.getJavaType(Object.class))),
                Helper.getJavaType(Void.TYPE), methodSource);

        methodSource.add(Helper.ifExpression(Helper.createIfVal().add1(
                Helper.checkNotNull(Helper.accessLocalVariable("n", Object.class))
                ).make(),
                Helper.sourceOf(
                        invokePrintln(new CodeArgument(Literals.STRING("Hello :D"), false, Helper.getJavaType(String.class)))
                )));

        methodSource.add(new CodeField("dingdong", Helper.getJavaType(String.class), Literals.STRING("DingDong")));

        methodSource.add(Predefined.invokePrintln(new CodeArgument(Helper.accessLocalVariable("dingdong", String.class), false, String.class)));

        methodSource.add(invoke(InvokeType.INVOKE_VIRTUAL, PrintStream.class,
                accessStaticVariable(System.class, "out", PrintStream.class),
                new MethodSpec("println", Helper.getJavaType(Void.TYPE),
                        singletonList(new CodeArgument(Helper.accessVariable(null, Helper.accessLocal(), "n", Helper.getJavaType(Object.class)), Object.class)))));


        return codeMethod;
    }

    public CodeMethod makeCM2() {
        CodeSource methodSource = new CodeSource();

        CodeMethod codeMethod = new CodeMethod("check",
                Collections.singletonList(CodeModifier.PUBLIC),
                Collections.singletonList(new CodeParameter("x", Helper.getJavaType(Integer.TYPE))),
                Helper.getJavaType(Boolean.TYPE),
                methodSource);

        // Invoke BMP

        methodSource.add(
                Helper.invoke(InvokeType.INVOKE_STATIC, TestBytecode_Invocations.class, null, new MethodSpec(
                        "bmp", PredefinedTypes.VOID, Arrays.asList(new CodeArgument(Literals.STRING("xy"), String.class),
                        new CodeArgument(Literals.STRING("yz"), String.class))
                ))
        );

        // Invocations test
        methodSource.add(Predefined.invokePrintln(new CodeArgument(Literals.STRING("Invoke Interface ->"), String.class)));

        methodSource.add(new CodeField("greeter", Helper.getJavaType(Greeter.class), Helper.invokeConstructor(Helper.getJavaType(WorldGreeter.class))));

        MethodInvocation greetingInvoke = Helper.invoke(InvokeType.INVOKE_INTERFACE, Greeter.class, Helper.accessLocalVariable("greeter", Greeter.class),
                new MethodSpec("hello", String.class, emptyList()));

        CodeField greetingVar = new CodeField("greetingVar", PredefinedTypes.STRING, greetingInvoke);

        methodSource.add(greetingVar);

        methodSource.add(Predefined.invokePrintln(new CodeArgument(Helper.accessLocalVariable(greetingVar), String.class)));

        methodSource.add(Predefined.invokePrintln(new CodeArgument(Literals.STRING("Invoke Interface <-"), String.class)));

        methodSource.add(Predefined.invokePrintln(new CodeArgument(Literals.STRING("Invoke Dynamic ->"), String.class)));

        CodeType supplierType = Helper.getJavaType(Supplier.class);

        MethodInvocation dynamicGet = Helper.invokeDynamic(InvokeDynamic.invokeDynamicLambda(
                new FullMethodSpec(supplierType, PredefinedTypes.OBJECT, "get"),
                new TypeSpec(PredefinedTypes.STRING)
                ),
                greetingInvoke);

        VariableStore supplierVar = new CodeField("supplier", supplierType, dynamicGet);

        methodSource.add(supplierVar);

        CodePart castedGet = Helper.cast(PredefinedTypes.STRING, Helper.invoke(InvokeType.INVOKE_INTERFACE, Supplier.class,
                Helper.accessLocalVariable(supplierVar),
                new MethodSpec("get", PredefinedTypes.OBJECT, emptyList())));

        VariableStore var2 = new CodeField("str", PredefinedTypes.STRING, castedGet);

        methodSource.add(var2);

        methodSource.add(Predefined.invokePrintln(new CodeArgument(Helper.accessLocalVariable(var2), String.class)));

        methodSource.add(Predefined.invokePrintln(new CodeArgument(Literals.STRING("Invoke Dynamic <-"), String.class)));

        methodSource.add(Predefined.invokePrintln(new CodeArgument(Literals.STRING("Invoke Dynamic Bootstrap ->"), String.class)));

        VariableAccess instance = Helper.accessStaticVariable(this.getClass(), "INSTANCE", this.getClass());

        MethodInvocation methodInvocation = Helper.invokeDynamic(InvokeDynamic.invokeDynamicBootstrap(InvokeType.INVOKE_STATIC, BOOTSTRAP_SPEC),
                Helper.invoke(InvokeType.INVOKE_VIRTUAL, (CodeType) null, null,
                        new MethodSpec("helloWorld", new TypeSpec(PredefinedTypes.VOID, PredefinedTypes.STRING),
                                singletonList(new CodeArgument(Literals.STRING("World"))))));

        methodSource.add(methodInvocation);

        methodSource.add(Predefined.invokePrintln(new CodeArgument(Literals.STRING("Invoke Dynamic Bootstrap <-"), String.class)));

        methodSource.add(Helper.ifExpression(
                Helper.createIfVal()
                        .add1(Helper.check(Helper.accessLocalVariable("x", PredefinedTypes.INT), Operators.EQUAL_TO, Literals.INT(9)))
                        .add2(Operators.OR)
                        .add1(Helper.check(Helper.accessLocalVariable("x", PredefinedTypes.INT), Operators.EQUAL_TO, Literals.INT(7)))
                        .make(),
                Helper.sourceOf(
                        Helper.returnValue(PredefinedTypes.INT, Literals.INT(0))
                )));

        methodSource.add(Predefined.invokePrintln(
                new CodeArgument(Helper.accessLocalVariable("x", PredefinedTypes.INT), false, PredefinedTypes.INT)
        ));

        methodSource.add(Helper.returnValue(PredefinedTypes.INT, Literals.INT(1)));

        return codeMethod;
    }

    public void helloWorld(String name) {
        System.out.println("Hello, " + name);
    }

    public static class MyCallSite extends MutableCallSite {

        final MethodHandles.Lookup callerLookup;
        final String name;

        MyCallSite(MethodHandles.Lookup callerLookup, String name, MethodType type) {
            super(type);
            this.callerLookup = callerLookup;
            this.name = name;
        }

        MyCallSite(MethodHandles.Lookup callerLookup, MethodHandle target, String name) {
            super(target);
            this.callerLookup = callerLookup;
            this.name = name;
        }


    }

    private static final class BCLoader extends ClassLoader {

        protected BCLoader(ClassLoader parent) {
            super(parent);
        }

        public Class<?> define(String name, byte[] bytes) {
            return super.defineClass(name, bytes, 0, bytes.length);
        }
    }


}
