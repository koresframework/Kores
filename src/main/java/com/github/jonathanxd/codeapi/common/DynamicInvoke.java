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
package com.github.jonathanxd.codeapi.common;

/**
 * Created by jonathan on 03/06/16.
 */
public class DynamicInvoke {
    private final FullMethodSpec methodSpec;
    private final TypeSpec expectedTypes;

    // Helper.invokeDynamic("run", Runnable.class, Void.class, Void.class)
    //                                    // Location   // Rethurn Type   // Method Name  // Parameter Types. MethodHandle?
    /* Helper.invokeDynamic(
          FullMethodSpec(Runnable.class, int.class,     "run",          Object.class, Object.class),
          METODO....
          TIPOS ESPERADOS ->          TypeSpec(int.class, Integer.class, Integer.class);
          );
    */
    // Helper.invokeDynamic("compare". Comparator.class, Object.class, Object.class, Int.class
    // mv.visitInvokeDynamicInsn("compare", "()Ljava/util/Comparator;",
    // new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;"),
    //
    // new Object[]{Type.getType("(Ljava/lang/Object;Ljava/lang/Object;)I"),
    // new Handle(Opcodes.H_INVOKEVIRTUAL, "java/lang/Integer", "compareTo", "(Ljava/lang/Integer;)I"),
    // Type.getType("(Ljava/lang/Integer;Ljava/lang/Integer;)I")});

    private DynamicInvoke(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
        this.methodSpec = fullMethodSpec;
        this.expectedTypes = expectedTypes;
    }

    public static DynamicInvoke invokeDynamicLambda(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
        return new InvokeDynamicLambda(fullMethodSpec, expectedTypes);
    }

    // TODO
    public static DynamicInvoke invokeDynamicBootstrap(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
        return new InvokeDynamicBootstrap(fullMethodSpec, expectedTypes);
    }

    public static boolean isInvokeDynamicLambda(DynamicInvoke type) {
        return type instanceof InvokeDynamicLambda;
    }

    public static boolean isInvokeDynamicBootstrap(DynamicInvoke type) {
        return type instanceof InvokeDynamicBootstrap;
    }

    public FullMethodSpec getMethodSpec() {
        return methodSpec;
    }

    public TypeSpec getExpectedTypes() {
        return expectedTypes;
    }

    @Deprecated // TODO
    public MethodType getMethodType() {
        throw new AbstractMethodError();
    }

    private static final class InvokeDynamicLambda extends DynamicInvoke {
        private InvokeDynamicLambda(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
            super(fullMethodSpec, expectedTypes);
        }
    }

    private static final class InvokeDynamicBootstrap extends DynamicInvoke {

        private InvokeDynamicBootstrap(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
            super(fullMethodSpec, expectedTypes);
        }


        /*@Override
        public MethodType getMethodType() {
            return methodType;
        }*/
    }
}
