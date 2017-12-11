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

import com.github.jonathanxd.codeapi.CodeInstruction;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.InvokeDynamic;
import com.github.jonathanxd.codeapi.base.InvokeType;
import com.github.jonathanxd.codeapi.base.LocalCode;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.MethodInvocation;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.TypeSpec;
import com.github.jonathanxd.codeapi.base.VariableDeclaration;
import com.github.jonathanxd.codeapi.common.DynamicMethodSpec;
import com.github.jonathanxd.codeapi.common.MethodInvokeSpec;
import com.github.jonathanxd.codeapi.common.MethodTypeSpec;
import com.github.jonathanxd.codeapi.factory.DynamicInvocationFactory;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.InvocationFactory;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.type.TypeRef;
import com.github.jonathanxd.codeapi.util.CodeTypes;

import org.junit.Test;

import java.io.PrintStream;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Supplier;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

@SuppressWarnings("Duplicates")
public class InvocationsTest_ {
    public static final InvocationsTest_ INSTANCE = new InvocationsTest_();
    public static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();
    public static final MethodTypeSpec BOOTSTRAP_SPEC = new MethodTypeSpec(
            CodeTypes.getCodeType(InvocationsTest_.class),
            "myBootstrap",
            Factories.typeSpec(CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class, Object[].class)
    );

    public static final MethodHandle FALLBACK;

    static {
        try {
            FALLBACK = LOOKUP.findStatic(
                    InvocationsTest_.class,
                    "fallback",
                    MethodType.methodType(Object.class, MyCallSite.class, Object[].class));
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static CodePart invokePrintln(CodeInstruction toPrint) {
        return InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, CodeTypes.getCodeType(PrintStream.class),
                Factories.accessStaticField(CodeTypes.getCodeType(System.class), CodeTypes.getCodeType(PrintStream.class), "out"),
                "println",
                Factories.voidTypeSpec(Types.OBJECT),
                Collections.singletonList(toPrint));
    }

    public static void bmp(String a, String b) {
        System.out.println("A = " + a + ", B = " + b);
    }

    public static CallSite myBootstrap(MethodHandles.Lookup caller, String name,
                                       MethodType type, Object... parameters) throws Throwable {

        MyCallSite myCallSite = new MyCallSite(caller, name, type);

        MethodHandle methodHandle = FALLBACK.bindTo(myCallSite).asCollector(Object[].class, type.parameterCount()).asType(type);

        myCallSite.setTarget(methodHandle);

        return myCallSite;
    }

    public static Object fallback(MyCallSite callSite, Object[] args) throws Throwable {
        MethodHandle virtual = LOOKUP.findVirtual(InvocationsTest_.class, callSite.name, callSite.type()).bindTo(INSTANCE);

        System.out.println("Invoking '" + callSite.name + "' type: '" + callSite.getTarget().type() + "', with args: '" + Arrays.toString(args) + "' ");

        //return virtual.invokeWithArguments(args);
        throw new RuntimeException("Oops");
    }

    public static TypeDeclaration $() {
        MutableCodeSource codeSource = MutableCodeSource.create();

        TypeRef typeRef = new TypeRef("fullName." + InvocationsTest_.class.getSimpleName() + "_Generated");

        CodeInstruction invokeTest = InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, CodeTypes.getCodeType(PrintStream.class),
                Factories.accessStaticField(CodeTypes.getCodeType(System.class), CodeTypes.getCodeType(PrintStream.class), "out"),
                "println",
                Factories.voidTypeSpec(Types.OBJECT),
                Collections.singletonList(Literals.STRING("Hello")));

        CodeInstruction invokeTest2 = InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, typeRef, Factories.accessThis(),
                "printIt",
                Factories.voidTypeSpec(Types.OBJECT),
                Collections.singletonList(Literals.STRING("Oi")));

        ClassDeclaration codeClass = ClassDeclaration.Builder.Companion.builder()
                .modifiers(CodeModifier.PUBLIC)
                .base(typeRef)
                .superClass(Types.OBJECT)
                .fields(FieldDeclaration.Builder.builder()
                                .modifiers(CodeModifier.PUBLIC, CodeModifier.FINAL)
                                .type(Types.STRING)
                                .name("FIELD")
                                .value(Literals.STRING("AVD"))
                                .build(),
                        FieldDeclaration.Builder.builder()
                                .modifiers(CodeModifier.PUBLIC, CodeModifier.FINAL)
                                .type(Types.INT)
                                .name("n")
                                .value(Literals.INT(15))
                                .build()
                )
                .constructors(ConstructorDeclaration.Builder.Companion.builder()
                        .modifiers(CodeModifier.PUBLIC)
                        .body(CodeSource.fromVarArgs(invokeTest, invokeTest2))
                        .build())
                .methods(TestFeatures_.createPrintItMethod(), makeCM2(typeRef))
                .build();

        return codeClass;
    }

    public static MethodDeclaration makeCM2(TypeRef typeDeclaration) {
        MutableCodeSource methodSource = MutableCodeSource.create();

        MethodDeclaration codeMethod = MethodDeclaration.Builder.builder()
                .modifiers(CodeModifier.PUBLIC)
                .name("check")
                .returnType(Types.BOOLEAN)
                .parameters(Factories.parameter(Types.INT, "x"))
                .body(methodSource)
                .build();

        // Invoke BMP

        methodSource.add(
                InvocationFactory.invoke(InvokeType.INVOKE_STATIC, InvocationsTest_.class, Factories.accessStatic(),
                        "bmp",
                        Factories.voidTypeSpec(String.class, String.class),
                        Arrays.asList(Literals.STRING("xy"), Literals.STRING("yz"))
                )
        );

        // Invocations test
        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Interface ->")));

        methodSource.add(
                VariableFactory.variable(CodeTypes.getCodeType(Greeter.class), "greeter", InvocationFactory.invokeConstructor(CodeTypes.getCodeType(WorldGreeter.class)))
        );

        MethodInvokeSpec greet = new MethodInvokeSpec(InvokeType.INVOKE_INTERFACE,
                new MethodTypeSpec(Greeter.class, "hello", Factories.typeSpec(Types.STRING)));

        MethodInvocation greetingInvoke = InvocationFactory.invoke(
                InvokeType.INVOKE_INTERFACE, Greeter.class, Factories.accessVariable(Greeter.class, "greeter"),
                "hello",
                Factories.typeSpec(Types.STRING),
                emptyList());

        VariableDeclaration greetingVar = VariableFactory.variable(Types.STRING, "greetingVar", greetingInvoke);

        methodSource.add(greetingVar);

        methodSource.add(Predefined.invokePrintln(Factories.accessVariable(greetingVar)));

        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Interface <-")));

        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Dynamic ->")));

        CodeType supplierType = CodeTypes.getCodeType(Supplier.class);

        ////////////////////////////////////////////////////////////////////////////////////////////

        InvokeDynamic.LambdaLocalCode dynamicSupplierGet = DynamicInvocationFactory.invokeDynamicLambdaCode(
                new MethodTypeSpec(supplierType, "get", Factories.typeSpec(Types.OBJECT)),
                Factories.typeSpec(Types.OBJECT),
                new LocalCode(typeDeclaration, MethodDeclaration.Builder.builder()
                        .modifiers(CodeModifier.PRIVATE, CodeModifier.STATIC)
                        .name("$$lambda$0")
                        .returnType(Types.STRING)
                        .body(CodeSource.fromVarArgs(
                                Factories.returnValue(Types.STRING, Literals.STRING("BRB"))
                        ))
                        .build(), emptyList()),
                emptyList()
        );

        VariableDeclaration supplierField = VariableFactory.variable(supplierType, "supplier2", dynamicSupplierGet);

        methodSource.add(supplierField);

        methodSource.add(Predefined.invokePrintln(

                Factories.cast(Types.OBJECT, Types.STRING,
                        InvocationFactory.invokeInterface(supplierType, Factories.accessVariable(supplierField), "get",
                                new TypeSpec(Types.OBJECT),
                                emptyList())
                )

        ));

        ////////////////////////////////////////////////////////////////////////////////////////////

        InvokeDynamic.LambdaMethodRef dynamicGet = DynamicInvocationFactory.invokeDynamicLambda(
                greet,
                singletonList(Factories.accessVariable(Greeter.class, "greeter")), // Receiver
                new MethodTypeSpec(supplierType, "get", Factories.typeSpec(Types.OBJECT)),
                new TypeSpec(Types.STRING));

        VariableDeclaration supplierVar = VariableFactory.variable(supplierType, "supplier", dynamicGet);

        methodSource.add(supplierVar);

        CodeInstruction castedGet = Factories.cast(Types.OBJECT, Types.STRING,
                InvocationFactory.invokeInterface(
                        supplierType,
                        Factories.accessVariable(supplierVar),
                        "get",
                        new TypeSpec(Types.OBJECT),
                        emptyList()
                )
        );

        VariableDeclaration var2 = VariableFactory.variable(Types.STRING, "str", castedGet);

        methodSource.add(var2);

        methodSource.add(Predefined.invokePrintln(Factories.accessVariable(var2)));

        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Dynamic <-")));

        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Dynamic Bootstrap ->")));

        InvokeDynamic bootstrapInvocation = DynamicInvocationFactory.invokeDynamic(
                new MethodInvokeSpec(InvokeType.INVOKE_STATIC, BOOTSTRAP_SPEC),
                new DynamicMethodSpec("helloWorld", Factories.typeSpec(Types.VOID, Types.STRING),
                        singletonList(Literals.STRING("World"))),
                emptyList()
        );


        methodSource.add(bootstrapInvocation);

        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Dynamic Bootstrap <-")));

        methodSource.add(Factories.ifStatement(
                Factories.ifExprs(
                        Factories.check(Factories.accessVariable(Types.INT, "x"), Operators.EQUAL_TO, Literals.INT(9)),
                        Operators.OR,
                        Factories.check(Factories.accessVariable(Types.INT, "x"), Operators.EQUAL_TO, Literals.INT(7))
                ),
                CodeSource.fromVarArgs(
                        Factories.returnValue(Types.INT, Literals.INT(0))
                )));

        methodSource.add(Predefined.invokePrintln(
                Factories.accessVariable(Types.INT, "x")
        ));

        methodSource.add(Factories.returnValue(Types.INT, Literals.INT(1)));

        return codeMethod;
    }

    public void helloWorld(String name) {
        System.out.println("Hello, " + name);
    }

    @Test
    public void test() {
        $();
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