/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.test.other;

import com.koresframework.kores.Types;
import com.koresframework.kores.type.Generic;
import com.koresframework.kores.type.GenericType;
import com.koresframework.kores.type.KoresTypes;
import com.koresframework.kores.util.TypeVarUtil;

import com.koresframework.kores.type.Generic;
import com.koresframework.kores.type.GenericType;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class GenericToTypeVarTest {

    @Test
    public void genericToTypeVar() {
        Generic generic = Generic.Companion.type(KoresTypes.getKoresType(MyClass.class))
                .of(Types.INTEGER_WRAPPER)
                .of(Generic.Companion.type("T"))
                .of(Types.STRING);

        TypeVariable<?>[] typeVariables = TypeVarUtil.fillTypeVars(MyClass.class, generic);

        print(typeVariables);
        Assert.assertEquals(3, typeVariables.length);
        Assert.assertEquals(1, typeVariables[0].getBounds().length);
        Assert.assertEquals(1, typeVariables[1].getBounds().length);
        Assert.assertEquals(1, typeVariables[2].getBounds().length);
        Assert.assertEquals("java.lang.Integer", typeVariables[0].getName());
        Assert.assertEquals("java.lang.Object", typeVariables[1].getName());
        Assert.assertEquals("java.lang.String", typeVariables[2].getName());

        Assert.assertEquals("java.lang.Integer", typeVariables[0].getBounds()[0].getTypeName());
        Assert.assertEquals("T", typeVariables[1].getBounds()[0].getTypeName());
        Assert.assertEquals("java.lang.String", typeVariables[2].getBounds()[0].getTypeName());
    }

    @Test
    public void typeVarToGeneric() {
        TypeVariable<Class<MyClass>>[] typeParameters = MyClass.class.getTypeParameters();
        GenericType type = (GenericType) TypeVarUtil.getType(typeParameters, "V", Generic.type(MyClass.class).of(Integer.class).of(Generic.type("T")).of(String.class));

        Assert.assertEquals("T", type.toString());
    }

    public void print(TypeVariable<?>[] typeVariables) {
        print(typeVariables, 0);
    }

    public void print(Type type) {
        print(type, 0);
    }

    public void print(TypeVariable<?>[] typeVariables, int cnt) {
        for (TypeVariable<?> typeVariable : typeVariables) {
            System.out.println(spaces(cnt) + "Name = " + typeVariable.getName());
            Type[] bounds = typeVariable.getBounds();

            if (bounds.length > 0) {
                System.out.println(spaces(cnt) + "Bounds = {");
                Arrays.stream(bounds).forEach(type -> this.print(type, cnt + 2));
                System.out.println(spaces(cnt) + "}");
            }

        }
    }

    public void print(Type type, int cnt) {
        if (type instanceof TypeVariable) {
            print(new TypeVariable[]{(TypeVariable<?>) type}, cnt);
        } else {
            System.out.println(spaces(cnt) + "Name = " + type.getTypeName());
        }
    }

    public String spaces(int i) {
        StringBuilder sb = new StringBuilder();

        for (int i1 = 0; i1 < i; i1++) {
            sb.append(' ');
        }

        return sb.toString();
    }

    public class AV<T> extends MyClass<Integer, T, String> {

    }

    public class MyClass<T, V, E extends CharSequence> {
        public T a(V v, E e) {
            return null;
        }
    }
}
