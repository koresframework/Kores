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
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.MethodInvocation;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.VariableDeclaration;
import com.github.jonathanxd.codeapi.builder.ClassDeclarationBuilder;
import com.github.jonathanxd.codeapi.builder.ConstructorDeclarationBuilder;
import com.github.jonathanxd.codeapi.builder.MethodDeclarationBuilder;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodTypeSpec;
import com.github.jonathanxd.codeapi.common.Scope;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.factory.FieldFactory;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.fragment.SimpleMethodFragmentBuilder;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import java.io.PrintStream;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.function.Supplier;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

@SuppressWarnings("Duplicates")
public class InvocationsTest_ {
    public static final InvocationsTest_ INSTANCE = new InvocationsTest_();
    public static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();
    public static final MethodTypeSpec BOOTSTRAP_SPEC = new MethodTypeSpec(
            CodeAPI.getJavaType(InvocationsTest_.class),
            "myBootstrap",
            CodeAPI.typeSpec(CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class, Object[].class)
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

    public static CodePart invokePrintln(CodePart toPrint) {
        return CodeAPI.invoke(InvokeType.INVOKE_VIRTUAL, CodeAPI.getJavaType(PrintStream.class),
                CodeAPI.accessStaticField(CodeAPI.getJavaType(System.class), CodeAPI.getJavaType(PrintStream.class), "out"),
                "println",
                CodeAPI.voidTypeSpec(Types.OBJECT),
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

    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {
        MutableCodeSource codeSource = new MutableCodeSource();
        MutableCodeSource clSource = new MutableCodeSource();

        ClassDeclaration codeClass = ClassDeclarationBuilder.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withQualifiedName("fullName." + InvocationsTest_.class.getSimpleName() + "_Generated")
                .withSuperClass(Types.OBJECT)
                .withBody(clSource)
                .build();

        FieldDeclaration codeField = FieldFactory.field(
                EnumSet.of(CodeModifier.PUBLIC, CodeModifier.FINAL),
                Types.STRING,
                "FIELD",
                Literals.STRING("AVD")
        );

        FieldDeclaration codeField2 = FieldFactory.field(
                EnumSet.of(CodeModifier.PUBLIC, CodeModifier.FINAL),
                Types.INT,
                "n",
                Literals.INT(15)
        );

        clSource.add(codeField);
        clSource.add(codeField2);

        CodePart invokeTest = CodeAPI.invoke(InvokeType.INVOKE_VIRTUAL, CodeAPI.getJavaType(PrintStream.class),
                CodeAPI.accessStaticField(CodeAPI.getJavaType(System.class), CodeAPI.getJavaType(PrintStream.class), "out"),
                "println",
                CodeAPI.voidTypeSpec(Types.OBJECT),
                Collections.singletonList(Literals.STRING("Hello")));

        CodePart invokeTest2 = CodeAPI.invoke(InvokeType.INVOKE_VIRTUAL, codeClass, CodeAPI.accessThis(),
                "printIt",
                CodeAPI.voidTypeSpec(Types.OBJECT),
                Collections.singletonList(Literals.STRING("Oi")));

        ConstructorDeclaration codeConstructor = ConstructorDeclarationBuilder.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withBody(CodeAPI.source(invokeTest, invokeTest2))
                .build();

        clSource.add(codeConstructor);

        clSource.add(TestFeatures_.makeCM());
        clSource.add(makeCM2(codeClass));

        codeSource.add(codeClass);

        return Pair.of(codeClass, codeSource);
    }

    public static MethodDeclaration makeCM2(TypeDeclaration typeDeclaration) {
        MutableCodeSource methodSource = new MutableCodeSource();

        MethodDeclaration codeMethod = MethodDeclarationBuilder.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withName("check")
                .withReturnType(Types.BOOLEAN)
                .withParameters(new CodeParameter(Types.INT, "x"))
                .withBody(methodSource)
                .build();

        // Invoke BMP

        methodSource.add(
                CodeAPI.invoke(InvokeType.INVOKE_STATIC, InvocationsTest_.class, CodeAPI.accessStatic(),
                        "bmp",
                        CodeAPI.voidTypeSpec(String.class, String.class),
                        Arrays.asList(Literals.STRING("xy"), Literals.STRING("yz"))
                )
        );

        // Invocations test
        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Interface ->")));

        methodSource.add(
                VariableFactory.variable(CodeAPI.getJavaType(Greeter.class), "greeter", CodeAPI.invokeConstructor(CodeAPI.getJavaType(WorldGreeter.class)))
        );

        MethodInvocation greetingInvoke = CodeAPI.invoke(
                InvokeType.INVOKE_INTERFACE, Greeter.class, CodeAPI.accessLocalVariable(Greeter.class, "greeter"),
                "hello",
                CodeAPI.typeSpec(Types.STRING),
                emptyList());

        VariableDeclaration greetingVar = VariableFactory.variable(Types.STRING, "greetingVar", greetingInvoke);

        methodSource.add(greetingVar);

        methodSource.add(Predefined.invokePrintln(CodeAPI.accessLocalVariable(greetingVar)));

        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Interface <-")));

        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Dynamic ->")));

        CodeType supplierType = CodeAPI.getJavaType(Supplier.class);

        ////////////////////////////////////////////////////////////////////////////////////////////

        MethodInvocation dynamicSupplierGet = CodeAPI.Specific.invokeDynamicFragment(
                new InvokeDynamic.LambdaFragment(
                        new MethodTypeSpec(supplierType, "get", CodeAPI.typeSpec(Types.OBJECT)),
                        CodeAPI.typeSpec(Types.STRING),
                        SimpleMethodFragmentBuilder.builder()
                                .withDeclaringType(typeDeclaration)
                                .withScope(Scope.STATIC)
                                .withDescription(new TypeSpec(Types.STRING))
                                .withBody(
                                        CodeAPI.source(
                                                CodeAPI.returnValue(Types.STRING, Literals.STRING("BRB"))
                                        )
                                )
                                .build()
                )
        );
        //
        /*MethodInvocation dynamicSupplierGet = Helper.invokeDynamicFragment(InvokeDynamic.invokeDynamicLambdaFragment(
                new FullMethodSpec(supplierType, PredefinedTypes.OBJECT, "get"),
                new TypeSpec(PredefinedTypes.STRING),
                new MethodFragmentImpl(
                        typeDeclaration, Scope.STATIC, PredefinedTypes.STRING,
                        new CodeParameter[]{},
                        new CodeArgument[]{},
                        Helper.sourceOf(Helper.returnValue(PredefinedTypes.STRING, Literals.STRING("BRB")))
                )));*/

        VariableDeclaration supplierField = VariableFactory.variable(supplierType, "supplier2", dynamicSupplierGet);

        methodSource.add(supplierField);

        methodSource.add(Predefined.invokePrintln(

                CodeAPI.cast(Types.OBJECT, Types.STRING,
                        CodeAPI.invokeInterface(supplierType, CodeAPI.accessLocalVariable(supplierField), "get",
                                new TypeSpec(Types.OBJECT),
                                emptyList())
                )

        ));

        ////////////////////////////////////////////////////////////////////////////////////////////

        MethodInvocation dynamicGet = CodeAPI.invokeDynamic(
                new InvokeDynamic.LambdaMethodReference(
                        new MethodTypeSpec(supplierType, "get", CodeAPI.typeSpec(Types.OBJECT)),
                        new TypeSpec(Types.STRING)),
                greetingInvoke);

        VariableDeclaration supplierVar = VariableFactory.variable(supplierType, "supplier", dynamicGet);

        methodSource.add(supplierVar);

        CodePart castedGet = CodeAPI.cast(Types.OBJECT, Types.STRING,
                CodeAPI.invokeInterface(
                        supplierType,
                        CodeAPI.accessLocalVariable(supplierVar),
                        "get",
                        new TypeSpec(Types.OBJECT),
                        emptyList()
                )
        );

        VariableDeclaration var2 = VariableFactory.variable(Types.STRING, "str", castedGet);

        methodSource.add(var2);

        methodSource.add(Predefined.invokePrintln(CodeAPI.accessLocalVariable(var2)));

        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Dynamic <-")));

        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Dynamic Bootstrap ->")));

        MethodInvocation methodInvocation = CodeAPI.Specific.invokeDynamic(
                new InvokeDynamic.Bootstrap(BOOTSTRAP_SPEC, InvokeType.INVOKE_STATIC, new Object[0]),
                CodeAPI.invoke(InvokeType.INVOKE_VIRTUAL, CodeAPI.getJavaType(InvocationsTest_.class), CodeAPI.accessStatic(),
                        "helloWorld",
                        CodeAPI.typeSpec(Types.VOID, Types.STRING),
                        singletonList(Literals.STRING("World"))));

        methodSource.add(methodInvocation);

        methodSource.add(Predefined.invokePrintln(Literals.STRING("Invoke Dynamic Bootstrap <-")));

        methodSource.add(CodeAPI.ifStatement(
                CodeAPI.ifExprs(
                        CodeAPI.check(CodeAPI.accessLocalVariable(Types.INT, "x"), Operators.EQUAL_TO, Literals.INT(9)),
                        Operators.OR,
                        CodeAPI.check(CodeAPI.accessLocalVariable(Types.INT, "x"), Operators.EQUAL_TO, Literals.INT(7))
                ),
                CodeAPI.source(
                        CodeAPI.returnValue(Types.INT, Literals.INT(0))
                )));

        methodSource.add(Predefined.invokePrintln(
                CodeAPI.accessLocalVariable(Types.INT, "x")
        ));

        methodSource.add(CodeAPI.returnValue(Types.INT, Literals.INT(1)));

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