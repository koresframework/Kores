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
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.type.Generic;
import com.github.jonathanxd.codeapi.type.GenericType;
import com.github.jonathanxd.codeapi.util.CodeTypes;
import com.github.jonathanxd.codeapi.util.GenericTypeUtil;
import com.github.jonathanxd.codeapi.util.Identity;
import com.github.jonathanxd.iutils.type.TypeUtil;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        Assert.assertTrue(Types.LIST.is(CodeTypes.getConcreteType(generic)));
        Assert.assertTrue(Generic.type(List.class).of(String.class).is(generic.getCodeType()));
        Assert.assertFalse(Types.LIST.is(generic.getCodeType()));

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

        CodeType codeType = CodeTypes.getCodeType(genericType);
        CodeType returnCodeType = CodeTypes.getCodeType(genericReturnType);

        Assert.assertEquals(codeType.toString(), "java.util.Map<java.lang.String, java.util.List<? super java.util.Map<java.lang.Integer, java.lang.String>>>");

        Assert.assertEquals(codeType.toString(), returnCodeType.toString());


        Assert.assertTrue(returnCodeType.is(codeType));
        Assert.assertTrue(returnCodeType.is(
                Generic.type(CodeAPI.getJavaType(Map.class)).of(Types.STRING).of(Generic.type(Generic.type(CodeAPI.getJavaType(List.class))).of(
                        Generic.wildcard().super$(Generic.type(CodeAPI.getJavaType(Map.class)).of(Types.INTEGER_WRAPPER, Types.STRING))
                ))
        ));


        CodeType mType = CodeTypes.getCodeType(M.class.getTypeParameters()[0]);
        CodeType iter = CodeTypes.getCodeType(M.class.getDeclaredMethod("iter").getGenericReturnType());

        Assert.assertTrue(Generic.type("T").is(mType));
        Assert.assertTrue(Generic.type(Types.ITERATOR).of("T").is(iter));

        CodeType type = CodeTypes.applyType(iter, "T", Types.STRING);

        Assert.assertTrue(Generic.type(Types.ITERATOR).of(Types.STRING).is(type));

        CodeType generic = Generic.wildcard().extends$(Generic.type(Types.LIST).of(Generic.wildcard().super$("T")));
        CodeType typeGeneric = CodeTypes.applyType(generic, "T", Types.STRING);
        CodeType typed = Generic.wildcard().extends$(Generic.type(Types.LIST).of(Generic.wildcard().super$(Types.STRING)));

        Assert.assertTrue(typed.is(typeGeneric));


        CodeType t = CodeTypes.getType(generic, "T", typed);

        System.out.println(t);

        CodeType genericBase = Generic.type(Multi.class).of("K").of("V");
        CodeType base = Generic.type(Multi.class).of(String.class, Integer.class);

        CodeType consume = CodeTypes.getCodeType(Multi.class.getDeclaredMethod("consume", BiConsumer.class).getGenericParameterTypes()[0]);

        consume = CodeTypes.applyType(consume, "K", CodeTypes.getType(genericBase, "K", base));

        consume = CodeTypes.applyType(consume, "V", CodeTypes.getType(genericBase, "V", base));

        Assert.assertTrue(Generic.type(BiConsumer.class).of(Generic.wildcard().super$(String.class)).of(Generic.wildcard().super$(Integer.class)).is(consume));

    }


    @Test
    public void parseRecursive() {
        TypeVariable<Class<BD>>[] typeParameters = BD.class.getTypeParameters();

        TypeUtil.toTypeInfo(typeParameters[0]);
        TypeUtil.toTypeInfo(typeParameters[1]);

        CodeType baseType = CodeTypes.getCodeTypeFromTypeParameters(BD.class);

        String boundTypeName = null;

        if (baseType instanceof GenericType) {
            GenericType genType = (GenericType) baseType;

            if (genType.getBounds().length == 2) {
                GenericType.Bound bound = genType.getBounds()[1];
                CodeType boundType = bound.getType();

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
