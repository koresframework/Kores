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
package com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodeElement;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.InnerType;
import com.github.jonathanxd.codeapi.common.MemberInfo;
import com.github.jonathanxd.codeapi.common.MemberInfos;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.inspect.SourceInspect;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.Accessor;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.Modifierable;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Lazy;
import com.github.jonathanxd.codeapi.util.element.ElementUtil;
import com.github.jonathanxd.iutils.container.MutableContainer;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.object.Pair;
import com.github.jonathanxd.iutils.type.TypeInfo;

import org.objectweb.asm.ClassWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public class Util {

    @SuppressWarnings("unchecked")
    public static <T> T find(TypeInfo<T> typeInfo, MapData data, Object additional) {
        Class<? extends T> aClass = typeInfo.getAClass();

        Optional<T> optional = data.getOptional(typeInfo);

        if (additional != null && aClass.isInstance(additional)) {
            return (T) additional;
        } else {
            return optional.orElseThrow(() -> new IllegalArgumentException("Could not determine: " + typeInfo + "! You must to register. Current additional data: " + additional));
        }
    }

    public static Pair<List<TypeDeclaration>, MutableCodeSource> grabAndRemoveInnerDecl(CodeSource source) {

        if (source == null)
            return null;

        List<TypeDeclaration> typeDeclarationList = new ArrayList<>();
        MutableCodeSource codeSource = new MutableCodeSource();

        Pair<List<TypeDeclaration>, MutableCodeSource> pair = Pair.of(typeDeclarationList, codeSource);

        for (CodePart part : source) {
            if (part instanceof CodeSource) {
                Pair<List<TypeDeclaration>, MutableCodeSource> listCodeSourcePair = Util.grabAndRemoveInnerDecl((CodeSource) part);

                typeDeclarationList.addAll(listCodeSourcePair._1());

                codeSource.add(listCodeSourcePair._2());
            } else {
                if (part instanceof TypeDeclaration) {
                    typeDeclarationList.add((TypeDeclaration) part);
                } else {
                    codeSource.add(part);
                }
            }
        }

        return pair;
    }


    public static List<TypeDeclaration> visitInner(ClassWriter cw, TypeDeclaration outer, List<TypeDeclaration> innerClasses) {

        List<TypeDeclaration> visited = new ArrayList<>();
        String name = Common.codeTypeToSimpleAsm(outer);

        for (TypeDeclaration innerClass : innerClasses) {
            int modifiers = Common.innerModifierToAsm(innerClass);
            cw.visitInnerClass(Common.codeTypeToSimpleAsm(innerClass), name, innerClass.getQualifiedName(), modifiers);


            MutableCodeSource source = new MutableCodeSource(innerClass.getBody().orElse(CodeSource.empty()));

            InstructionCodePart instructionCodePart = (value, extraData, visitorGenerator, additional) -> {
                extraData.getRequired(TypeVisitor.CLASS_WRITER_REPRESENTATION)
                        .visitInnerClass(Common.codeTypeToSimpleAsm(innerClass), name, innerClass.getQualifiedName(), modifiers);
            };

            source.add(0, instructionCodePart);

            visited.add(innerClass.setBody(source));
        }

        return visited;
    }

    public static String getRealNameStr(String qualified, CodeType outer) {
        return outer.getCanonicalName() + "$" + qualified;
    }

    /**
     * Fixes access of outer classes trying to access inner class elements.
     *
     * @param accessor     Accessor
     * @param extraData    Data
     * @param localization Localization
     * @param consumer     Consumer
     * @param <T>          Type
     * @return Fixed accessor.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Accessor> T fixAccessor(T accessor, MapData extraData,
                                                     MutableContainer<CodeType> localization,
                                                     BiConsumer<MutableContainer<T>, InnerType> consumer) {


        List<InnerType> innerTypes = extraData.getAllAsList(TypeVisitor.INNER_TYPE_REPRESENTATION);

        for (InnerType innerType : innerTypes) {

            TypeDeclaration originalDeclaration = innerType.getOriginalDeclaration();

            if (originalDeclaration.getModifiers().contains(CodeModifier.STATIC))
                continue;


            if (originalDeclaration.is(localization.get())) {
                localization.set(innerType.getAdaptedDeclaration());

                accessor = (T) accessor.setLocalization(localization.get());

                if (consumer != null) {
                    MutableContainer<T> container = MutableContainer.of(accessor);
                    consumer.accept(container, innerType);
                    accessor = container.get();
                }

                return accessor;
            }
        }


        return accessor;
    }

    /**
     * Fixes access to outer class element from inner class.
     *
     * @param extraData    Data
     * @param target       Target
     * @param localization Localization
     * @return Access to its enclosing class.
     */
    @SuppressWarnings("unchecked")
    public static CodePart accessEnclosingClass(MapData extraData,
                                                CodePart target,
                                                CodeType localization) {
        Lazy<CodeType> enclosingType = new Lazy<>(() -> extraData.getRequired(TypeVisitor.CODE_TYPE_REPRESENTATION, "Cannot determine current type!"));

        if (target instanceof AccessThis && localization != null && !localization.is(enclosingType.get())) {
            List<FieldDeclaration> allAsList = extraData.getAllAsList(TypeVisitor.OUTER_FIELD_REPRESENTATION);

            for (FieldDeclaration fieldDeclaration : allAsList) {
                if (fieldDeclaration.getVariableType().is(localization)) {
                    return CodeAPI.accessThisField(fieldDeclaration.getVariableType(), fieldDeclaration.getName());
                }
            }

        }

        return null;
    }

    /**
     * Fixes access to outer class element from inner class.
     *
     * @param extraData Data
     * @return Access to its enclosing class.
     */
    @SuppressWarnings("unchecked")
    public static CodePart accessEnclosingClass(MapData extraData,
                                                CodeType type) {
        List<FieldDeclaration> allAsList = extraData.getAllAsList(TypeVisitor.OUTER_FIELD_REPRESENTATION);

        for (FieldDeclaration fieldDeclaration : allAsList) {
            if (fieldDeclaration.getVariableType().is(type)) {
                return CodeAPI.accessThisField(fieldDeclaration.getVariableType(), fieldDeclaration.getName());
            }
        }


        return null;
    }


    public static BytecodeClass[] access(CodePart part, CodeType localization, VisitorGenerator<BytecodeClass> visitorGenerator, MapData extraData, Object additional) {
        if (localization != null) {
            Optional<TypeDeclaration> declaringOpt = extraData.getOptional(TypeVisitor.OUTER_TYPE_REPRESENTATION);

            InnerType innerType = null;
            MemberInfos infos = null;

            if (!declaringOpt.isPresent()) {
                List<InnerType> innerTypes = extraData.getAllAsList(TypeVisitor.INNER_TYPE_REPRESENTATION);

                for (InnerType inner : innerTypes) {
                    TypeDeclaration adaptedDeclaration = inner.getAdaptedDeclaration();

                    if (adaptedDeclaration.is(localization)) {
                        infos = inner.getMemberInfos();
                        declaringOpt = Optional.of(adaptedDeclaration);

                        innerType = inner;
                    }
                }


            }

            if (innerType == null && extraData.getParent() != null) {
                infos = extraData.getParent().getOptional(ConstantDatas.MEMBER_INFOS).orElse(null);
            }

            if (infos != null && declaringOpt.isPresent()) {

                // If accessing enclosing class.
                if (localization.is(declaringOpt.get())) {


                    MemberInfo memberInfo;
                    boolean isConstructor = false;

                    List<CodeArgument> codeArguments = new ArrayList<>();

                    CodePart target = ((Accessor) part).getTarget().orElse(null);

                    if (part instanceof VariableAccess) {
                        VariableAccess access = (VariableAccess) part;
                        memberInfo = infos.find(access);
                    } else {
                        MethodSpecification spec = ((MethodInvocation) part).getSpec();
                        memberInfo = infos.find(spec);
                        codeArguments.addAll(spec.getArguments());
                        isConstructor = spec.getMethodName().equals("<init>");
                    }

                    if (memberInfo != null && !memberInfo.isAccessible()) {
                        if (!memberInfo.hasAccessibleMember() || isConstructor) {
                            Common.genOuterAccessor(declaringOpt.get(), innerType, memberInfo, extraData, visitorGenerator, isConstructor);
                        }

                        MethodDeclaration accessibleMember = (MethodDeclaration) memberInfo.getAccessibleMember();

                        if (isConstructor) {
                            codeArguments.add(CodeAPI.argument(CodeAPI.accessThis()));
                            target = null;
                        }

                        MethodInvocation invoke = ElementUtil.invoke(accessibleMember, target, codeArguments, declaringOpt.get());

                        return visitorGenerator.generateTo(MethodInvocation.class, invoke, extraData, additional);

                    }
                }
            }

        }

        return null;
    }

    public static MemberInfos createMemberInfos(TypeDeclaration typeDeclaration) {
        CodeSource body = typeDeclaration.getBody().orElse(CodeSource.empty());

        List<CodeElement> elements = SourceInspect.find(codePart -> codePart instanceof MethodDeclaration || codePart instanceof FieldDeclaration)
                .include(bodied -> bodied instanceof CodeSource)
                .mapTo(codePart -> (CodeElement) codePart)
                .inspect(body);

        MemberInfos memberInfos = new MemberInfos(typeDeclaration);

        for (CodeElement element : elements) {
            if (element instanceof Modifierable) {
                memberInfos.put(MemberInfo.of(element, !((Modifierable) element).getModifiers().contains(CodeModifier.PRIVATE)));
            }
        }

        return memberInfos;
    }
}
