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
package com.github.jonathanxd.codeapi.util.gen;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodeElement;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InnerType;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MemberInfo;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.TypeVisitor;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.source.CodeArgumentUtil;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class InnerUtil {
    public static void genOuterAccessor(TypeDeclaration outer,
                                        InnerType inner,
                                        MemberInfo memberInfo,
                                        MapData extraData,
                                        VisitorGenerator<BytecodeClass> visitorGenerator,
                                        boolean isConstructor) {

        if (!memberInfo.hasAccessibleMember()
                || isConstructor) {
            CodeElement memberInstance = memberInfo.getMemberInstance();

            MethodDeclaration gen = InnerUtil.generatePackagePrivateAccess(outer, extraData, memberInstance);

            if (inner == null) {
                visitorGenerator.generateTo(MethodDeclaration.class, gen, Objects.requireNonNull(extraData.getParent()), null);
            } else {
                MutableCodeSource source = outer.getBody().orElse(CodeSource.empty()).toMutable();

                source.add(gen);

                inner.setAdaptedDeclaration(outer.setBody(source));
            }

            memberInfo.setAccessibleMember(gen);
        }
    }

    private static MethodDeclaration generatePackagePrivateAccess(TypeDeclaration outer, MapData extraData, CodePart element) {

        if (!(element instanceof Modifierable) || !(element instanceof Typed))
            throw new IllegalArgumentException("Element doesn't match requirements: extends Modifierable & Typed.");


        CodeType type = ((Typed) element).getType().orElseThrow(NullPointerException::new);

        boolean isConstructor = false;
        boolean isStatic = ((Modifierable) element).getModifiers().contains(CodeModifier.STATIC);

        Collection<CodeModifier> modifiers = CodeModifier.newModifierSet();

        modifiers.add(CodeModifier.SYNTHETIC);
        if (isStatic) modifiers.add(CodeModifier.STATIC);

        CodePart invk;
        List<CodeParameter> parameters = new ArrayList<>();

        if (element instanceof FieldDeclaration) {
            FieldDeclaration fieldDeclaration = (FieldDeclaration) element;

            if (!isStatic) {
                invk = CodeAPI.accessField(outer, CodeAPI.accessThis(), fieldDeclaration.getVariableType(), fieldDeclaration.getName());
            } else {
                invk = CodeAPI.accessStaticField(outer, fieldDeclaration.getVariableType(), fieldDeclaration.getName());
            }
        } else if (element instanceof MethodDeclaration) {
            MethodDeclaration methodDeclaration = (MethodDeclaration) element;

            parameters.addAll(methodDeclaration.getParameters());

            isConstructor = methodDeclaration.getName().equals("<init>");

            InvokeType invokeType = isStatic ? InvokeType.INVOKE_STATIC :
                    (isConstructor
                            ? InvokeType.INVOKE_SPECIAL
                            : (outer.isInterface()
                            ? InvokeType.INVOKE_INTERFACE
                            : InvokeType.INVOKE_VIRTUAL));

            List<CodeArgument> arguments = CodeArgumentUtil.argumentsFromParameters(parameters);

            if (isConstructor) {
                TypeDeclaration current = extraData.getRequired(TypeVisitor.CODE_TYPE_REPRESENTATION);
                CodeParameter parameter = CodeAPI.parameter(current, CodeSourceUtil.getNewName("$inner", parameters));

                parameters.add(parameter);
                //arguments.add(CodeAPI.argument(CodeAPI.accessThis(), current));
            }

            invk = Helper.invoke(invokeType, outer, isStatic ? outer : CodeAPI.accessThis(),
                    new MethodSpecImpl(methodDeclaration.getName(), methodDeclaration.getReturnType().orElse(PredefinedTypes.VOID),
                            arguments, isConstructor ? MethodType.SUPER_CONSTRUCTOR : MethodType.METHOD));
        } else {
            throw new IllegalArgumentException("Cannot process: " + element + "!");
        }

        if (!isConstructor) {
            return CodeAPI.methodBuilder()
                    .withName(CodeSourceUtil.getNewMethodName("invoke$000", outer.getBody().orElse(CodeSource.empty())))
                    .withModifiers(modifiers)
                    .withParameters(parameters)
                    .withReturnType(type)
                    .withBody(CodeAPI.sourceOfParts(
                            CodeAPI.returnValue(type, invk)
                    ))
                    .build();
        } else {
            return CodeAPI.constructorBuilder()
                    .withModifiers(modifiers)
                    .withParameters(parameters)
                    .withBody(CodeAPI.sourceOfParts(
                            invk
                    ))
                    .build();
        }
    }
}
