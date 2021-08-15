/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.koresframework.kores.type.KoresType;
import com.koresframework.kores.type.KoresTypes;
import com.koresframework.kores.type.Generic;
import com.koresframework.kores.type.GenericType;
import com.koresframework.kores.util.GenericTypeUtil;
import com.koresframework.kores.util.Identity;
import com.github.jonathanxd.iutils.type.TypeUtil;

import com.koresframework.kores.type.KoresType;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class GenTest {

    public static final Map<String, List<? super Map<Integer, String>>> ms = null;


    public Map<String, List<? super Map<Integer, String>>> myMethod() {
        return null;
    }

    @Test
    public void concreteTypeTest() {

        GenericType generic = Generic.type("S").extends$(Generic.type(List.class).of(String.class));

        Assert.assertTrue(Types.LIST.is(KoresTypes.getConcreteType(generic)));
        Assert.assertTrue(Generic.type(List.class).of(String.class).is(generic.getResolvedType()));
        Assert.assertFalse(Types.LIST.is(generic.getResolvedType()));

    }

    @Test
    public void nonStrictEqTest() {
        Generic of = Generic.type(List.class).of(Generic.wildcard());
        Generic ofCharSeqEx = Generic.type(List.class).of(Generic.wildcard().extends$(CharSequence.class));
        Generic ofCharSeq = Generic.type(List.class).of(CharSequence.class);
        Generic ofS = Generic.type(List.class).of(String.class);
        Generic ofS2 = Generic.type(List.class).of(String.class);
        Generic ofNb = Generic.type(List.class).of(Number.class);
        Generic ofInt = Generic.type(List.class).of(Integer.class);
        Generic ofWObj = Generic.type(List.class).of(Generic.wildcard().extends$(Object.class));
        Generic ofObj = Generic.type(List.class).of(Object.class);

        Assert.assertTrue(Identity.nonStrictEq(of, Types.LIST));
        Assert.assertTrue(Identity.nonStrictEq(ofCharSeq, ofCharSeqEx));
        Assert.assertTrue(Identity.nonStrictEq(ofS, ofS2));
        Assert.assertFalse(Identity.nonStrictEq(ofNb, ofInt));
        Assert.assertTrue(Identity.nonStrictEq(of, ofWObj));
        Assert.assertTrue(Identity.nonStrictEq(of, ofObj));
    }

    @Test
    public void fromStringTest() throws Exception {
        GenericType genericType = GenericTypeUtil.fromSourceString("java.util.Map<java.lang.String,java.lang.Object>");

        Assert.assertTrue(Generic.type(Map.class).of(String.class, Object.class).is(genericType));
    }

    @Test
    public void test() throws Exception {
        Type genericType = GenTest.class.getDeclaredField("ms").getGenericType();
        Type genericReturnType = GenTest.class.getDeclaredMethod("myMethod").getGenericReturnType();

        KoresType koresType = KoresTypes.getKoresType(genericType);
        KoresType returnKoresType = KoresTypes.getKoresType(genericReturnType);

        Assert.assertEquals(koresType.toString(), "java.util.Map<java.lang.String, java.util.List<? super java.util.Map<java.lang.Integer, java.lang.String>>>");

        Assert.assertEquals(koresType.toString(), returnKoresType.toString());


        Assert.assertTrue(returnKoresType.is(koresType));
        Assert.assertTrue(returnKoresType.is(
                Generic.type(KoresTypes.getKoresType(Map.class)).of(Types.STRING).of(Generic.type(Generic.type(KoresTypes.getKoresType(List.class))).of(
                        Generic.wildcard().super$(Generic.type(KoresTypes.getKoresType(Map.class)).of(Types.INTEGER_WRAPPER, Types.STRING))
                ))
        ));


        KoresType mType = KoresTypes.getKoresType(M.class.getTypeParameters()[0]);
        KoresType iter = KoresTypes.getKoresType(M.class.getDeclaredMethod("iter").getGenericReturnType());

        Assert.assertTrue(Generic.type("T").is(mType));
        Assert.assertTrue(Generic.type(Types.ITERATOR).of("T").is(iter));

        KoresType type = KoresTypes.applyType(iter, "T", Types.STRING);

        Assert.assertTrue(Generic.type(Types.ITERATOR).of(Types.STRING).is(type));

        KoresType generic = Generic.wildcard().extends$(Generic.type(Types.LIST).of(Generic.wildcard().super$("T")));
        KoresType typeGeneric = KoresTypes.applyType(generic, "T", Types.STRING);
        KoresType typed = Generic.wildcard().extends$(Generic.type(Types.LIST).of(Generic.wildcard().super$(Types.STRING)));

        Assert.assertTrue(typed.is(typeGeneric));


        KoresType t = KoresTypes.getType(generic, "T", typed);

        System.out.println(t);

        KoresType genericBase = Generic.type(Multi.class).of("K").of("V");
        KoresType base = Generic.type(Multi.class).of(String.class, Integer.class);

        KoresType consume = KoresTypes.getKoresType(Multi.class.getDeclaredMethod("consume", BiConsumer.class).getGenericParameterTypes()[0]);

        consume = KoresTypes.applyType(consume, "K", KoresTypes.getType(genericBase, "K", base));

        consume = KoresTypes.applyType(consume, "V", KoresTypes.getType(genericBase, "V", base));

        Assert.assertTrue(Generic.type(BiConsumer.class).of(Generic.wildcard().super$(String.class)).of(Generic.wildcard().super$(Integer.class)).is(consume));

    }


    @Test
    public void parseRecursive() {
        TypeVariable<Class<BD>>[] typeParameters = BD.class.getTypeParameters();

        TypeUtil.toTypeInfo(typeParameters[0]);
        TypeUtil.toTypeInfo(typeParameters[1]);

        KoresType baseType = KoresTypes.getKoresTypeFromTypeParameters(BD.class);

        String boundTypeName = null;

        if (baseType instanceof GenericType) {
            GenericType genType = (GenericType) baseType;

            if (genType.getBounds().length == 2) {
                GenericType.Bound bound = genType.getBounds()[1];
                KoresType boundType = bound.getType();

                if (boundType instanceof GenericType) {
                    GenericType bound_ = (GenericType) boundType;

                    if (!bound_.isType() && bound_.getBounds().length == 1) {
                        if (bound_.getBounds()[0].getType().getCanonicalName().equals(baseType.getCanonicalName()))
                            boundTypeName = bound_.getName();
                    }
                }
            }

        }
    }


    public static class M<T> {
        public Iterator<T> iter() {
            return null;
        }
    }

    public static class Multi<K, V> {
        public void consume(BiConsumer<? super K, ? super V> biConsumer) {

        }
    }


    public interface BD<T extends CharSequence, S extends BD<T, S>> extends Builder<T, S> {

    }

    public interface Builder<T, S extends Builder<T, S>> {

    }
}
