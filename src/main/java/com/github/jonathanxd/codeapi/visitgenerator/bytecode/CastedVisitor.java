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
package com.github.jonathanxd.codeapi.visitgenerator.bytecode;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.codeapi.interfaces.Casted;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.iutils.conditions.Conditions;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Collections;

/**
 * Created by jonathan on 03/06/16.
 */
public class CastedVisitor implements Visitor<Casted, Byte, MVData>, Opcodes {

    @Override
    public Byte[] visit(Casted casted,
                        Data extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        MVData mvData) {

        MethodVisitor additional = mvData.getMethodVisitor();

        CodeType from = casted.getOriginalType();
        CodeType to = casted.getType().get();

        CodePart autoboxing = autoboxing(from, to, casted.getCastedPart().get());

        CodePart codePart = casted.getCastedPart().get();

        if(autoboxing != null) {
            visitorGenerator.generateTo(autoboxing.getClass(), autoboxing, extraData, navigator, null, mvData);

            if((from.isPrimitive() && !to.isPrimitive())
                    && !from.getWrapperType().getCanonicalName().equals(to.getCanonicalName())) {
                additional.visitTypeInsn(CHECKCAST, Common.codeTypeToSimpleAsm(to));
            }

        }else {
            visitorGenerator.generateTo(codePart.getClass(), codePart, extraData, navigator, null, mvData);

            if(!from.equals(to)) {
                if (to.isPrimitive())
                    throw new IllegalArgumentException("Cannot cast to primitive type!");

                additional.visitTypeInsn(CHECKCAST, Common.codeTypeToSimpleAsm(to));
            }
        }


        return new Byte[0];
    }

    //
    // http://prntscr.com/bzx6kw/direct

    @Override
    public void endVisit(Byte[] r,
                         Casted casted,
                         Data extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         MVData mvData) {

    }
    // CAST DE -> PARA
    private CodePart autoboxing(CodeType from, CodeType to, CodePart casted) {

        CodePart translate = null;

        if(from.isPrimitive() && !to.isPrimitive()) {

            translate = CodeAPI.invokeConstructor(from.getWrapperType(), CodeAPI.argument(casted, from));

        } else if(!from.isPrimitive() && to.isPrimitive()) {

            CodeType wrapper = to.getWrapperType();

            CodeType castTo = null;

            if(!to.getWrapperType().getCanonicalName().equals(from.getCanonicalName())) {
                castTo = to.getWrapperType();
            }

            String methodName = null;

            if(wrapper.getCanonicalName().equals("java.lang.Byte")) {
                methodName = "byteValue";
            } else if(wrapper.getCanonicalName().equals("java.lang.Short")) {
                methodName = "shortValue";
            } else if(wrapper.getCanonicalName().equals("java.lang.Integer")) {
                methodName = "intValue";
            } else if(wrapper.getCanonicalName().equals("java.lang.Long")) {
                methodName = "longValue";
            } else if(wrapper.getCanonicalName().equals("java.lang.Integer")) {
                methodName = "floatValue";
            } else if(wrapper.getCanonicalName().equals("java.lang.Double")) {
                methodName = "doubleValue";
            } else if(wrapper.getCanonicalName().equals("java.lang.Boolean")) {
                methodName = "booleanValue";
            } else if(wrapper.getCanonicalName().equals("java.lang.Character")) {
                methodName = "charValue";
            }

            Conditions.checkNotNull(methodName);

            if(castTo == null) {
                translate = CodeAPI.invokeVirtual(wrapper, casted, methodName, new TypeSpec(to));
            } else {
                translate = CodeAPI.invokeVirtual(wrapper, Helper.cast(from, castTo, casted), methodName, new TypeSpec(to));
            }
        }

        return translate;

    }
}
