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
package com.github.jonathanxd.codeapi.test.other;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.type.Generic;
import com.github.jonathanxd.codeapi.util.TypeVarUtil;

import org.junit.Test;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class GenericToTypeVarTest {

    @Test
    public void genericToTypeVar() {
        Generic generic = Generic.Companion.type(CodeAPI.getJavaType(MyClass.class))
                .of(Types.INTEGER_WRAPPER)
                .of(Generic.Companion.type("T"))
                .of(Types.STRING);

        TypeVariable<?>[] typeVariables = TypeVarUtil.fillTypeVars(MyClass.class, generic);

        print(typeVariables);
    }

    public void print(TypeVariable<?>[] typeVariables) {
        for (TypeVariable<?> typeVariable : typeVariables) {
            System.out.println("Name = " + typeVariable.getName());
            Type[] bounds = typeVariable.getBounds();

            if (bounds.length > 0) {
                System.out.println("Bounds = ");
                Arrays.stream(bounds).forEach(this::print);
            }

            System.out.println("===========================================");
        }
    }

    public void print(Type type) {
        if (type instanceof TypeVariable) {
            print(new TypeVariable[]{(TypeVariable<?>) type});
        } else {
            System.out.println("Name = " + type.getTypeName());
        }
    }

    public class AV<T> extends MyClass<Integer, T, String> {

    }

    public class MyClass<T, V, E extends CharSequence> {
        public T a(V v, E e) {
            return null;
        }
    }
}
