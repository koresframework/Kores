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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.AccessSuper;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.Extender;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class ConstructorUtil {
    public static boolean isInitForThat(TypeDeclaration typeDeclaration, MethodInvocation methodInvocation) {
        boolean any = methodInvocation.getSpec().getMethodType() == MethodType.SUPER_CONSTRUCTOR;

        boolean accept = (methodInvocation.getTarget().orElse(null) instanceof AccessThis || methodInvocation.getTarget().orElse(null) instanceof AccessSuper);

        return any
                && accept
                && methodInvocation.getInvokeType().equals(InvokeType.INVOKE_SPECIAL)
                && methodInvocation.getSpec().getMethodName().equals("<init>");

    }

    public static SearchResult searchForInitTo(TypeDeclaration typeDeclaration, CodeSource codeParts, Predicate<CodePart> targetAccessPredicate) {
        return ConstructorUtil.searchForInitTo(typeDeclaration, codeParts, true, targetAccessPredicate, false);
    }

    public static SearchResult searchForInitTo(TypeDeclaration typeDeclaration, CodeSource codeParts, boolean includeChild, Predicate<CodePart> targetAccessPredicate, boolean isSub) {
        if (codeParts == null)
            return SearchResult.FALSE;

        for (CodePart codePart : codeParts) {
            if ((codePart instanceof Bodied && includeChild)) {
                SearchResult searchResult = ConstructorUtil.searchForInitTo(typeDeclaration, ((Bodied) codePart).getBody().orElse(null), includeChild, targetAccessPredicate, true);

                if (searchResult.found)
                    return searchResult;

            }

            if (codePart instanceof CodeSource) { // Another CodeSource is part of the Enclosing Source
                SearchResult searchResult = ConstructorUtil.searchForInitTo(typeDeclaration, ((CodeSource) codePart), includeChild, targetAccessPredicate, true);

                if (searchResult.found)
                    return searchResult;
            }

            if (codePart instanceof MethodInvocation) {
                MethodInvocation mi = (MethodInvocation) codePart;

                if (mi.getSpec().getMethodType() == MethodType.SUPER_CONSTRUCTOR
                        && targetAccessPredicate.test(mi.getTarget().orElse(null))
                        && mi.getInvokeType().equals(InvokeType.INVOKE_SPECIAL)
                        && mi.getSpec().getMethodName().equals("<init>")) {
                    return new SearchResult(true, isSub);
                }
            }

        }

        return SearchResult.FALSE;
    }

    public static boolean searchInitThis(TypeDeclaration typeDeclaration, CodeSource codeParts, boolean validate) {
        SearchResult searchResult = ConstructorUtil.searchForInitTo(typeDeclaration, codeParts, !validate, codePart -> codePart instanceof AccessThis, false);

        if (validate)
            searchResult = ConstructorUtil.validateConstructor(searchResult);

        return searchResult.found;
    }

    public static boolean searchForSuper(TypeDeclaration typeDeclaration, CodeSource codeParts, boolean validate) {
        SearchResult searchResult = ConstructorUtil.searchForInitTo(typeDeclaration, codeParts, !validate, codePart -> codePart instanceof AccessSuper, false);

        if (validate)
            searchResult = ConstructorUtil.validateConstructor(searchResult);

        return searchResult.found;
    }

    public static SearchResult validateConstructor(SearchResult searchResult) {
        if (searchResult.foundOnSub)
            throw new IllegalArgumentException("Don't invoke super() or this() inside a Bodied Element.");

        return searchResult;
    }

    public static void declareFinalFields(VisitorGenerator<?> visitorGenerator, CodeSource methodBody, TypeDeclaration typeDeclaration, MethodVisitor mv, MapData extraData, MVData mvData, boolean validate) {

        if (ConstructorUtil.searchInitThis(typeDeclaration, methodBody, validate)) {
            return;
        }

        /**
         * Declare variables
         */
        Collection<FieldDeclaration> all = CodeSourceUtil.find(
                typeDeclaration.getBody().orElseThrow(NullPointerException::new),
                codePart ->
                        codePart instanceof CodeField
                                && !((CodeField) codePart).getModifiers().contains(CodeModifier.STATIC)
                                && ((CodeField) codePart).getValue().isPresent(),
                codePart -> (CodeField) codePart);


        Label label = new Label();
        mv.visitLabel(label);

        for (FieldDeclaration codeField : all) {

            Optional<CodePart> valueOpt = codeField.getValue();

            if (valueOpt.isPresent()) {
                CodePart value = valueOpt.get();
                // No visitor overhead.
                mv.visitVarInsn(Opcodes.ALOAD, 0);

                visitorGenerator.generateTo(value.getClass(), value, extraData, null, mvData);

                // No visitor overhead.
                mv.visitFieldInsn(Opcodes.PUTFIELD, CodeTypeUtil.codeTypeToSimpleAsm(typeDeclaration), codeField.getName(), CodeTypeUtil.codeTypeToFullAsm(codeField.getType().get()));
            }

        }
    }

    public static void generateSuperInvoke(TypeDeclaration typeDeclaration, MethodVisitor mv) {
        mv.visitVarInsn(Opcodes.ALOAD, 0);

        CodeType superType = ((Extender) typeDeclaration).getSuperType().orElse(null);

        if (superType == null) {
            // No visitor overhead.
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        } else {
            // No visitor overhead.
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, CodeTypeUtil.codeTypeToSimpleAsm(superType), "<init>", "()V", false);
        }
    }

    public static CodeSource generateFinalFields(CodeSource classSource) {
        MutableCodeSource codeSource = new MutableCodeSource();

        /**
         * Declare variables
         */
        Collection<FieldDeclaration> all = CodeSourceUtil.find(
                classSource,
                codePart ->
                        codePart instanceof CodeField
                                && !((CodeField) codePart).getModifiers().contains(CodeModifier.STATIC)
                                && ((CodeField) codePart).getValue().isPresent(),
                codePart -> (CodeField) codePart);

        for (FieldDeclaration codeField : all) {

            CodeType type = codeField.getVariableType();
            String name = codeField.getName();
            Optional<CodePart> value = codeField.getValue();

            if (value.isPresent()) {
                codeSource.add(Helper.setThisVariable(name, type, value.get()));
            }
        }

        return codeSource;
    }

    static final class SearchResult {
        public static final SearchResult FALSE = new SearchResult(false, false);
        public final boolean found;
        public final boolean foundOnSub;

        private SearchResult(boolean found, boolean foundOnSub) {
            this.found = found;
            this.foundOnSub = foundOnSub;
        }
    }

}
