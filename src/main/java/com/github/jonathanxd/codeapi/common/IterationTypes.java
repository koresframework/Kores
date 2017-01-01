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
package com.github.jonathanxd.codeapi.common;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.BiMultiVal;
import com.github.jonathanxd.codeapi.util.CodePartUtil;
import com.github.jonathanxd.codeapi.util.HiddenField;

import java.util.Iterator;

/**
 * Basic iteration types.
 */
public final class IterationTypes {

    /**
     * Iterate a array
     */
    public static final IterationType ARRAY = new ArrayIterationType();

    /**
     * Iterate a Iterable element.
     */
    public static final IterationType ITERABLE_ELEMENT = new IterableIterationType();

    private IterationTypes() {
        throw new IllegalStateException();
    }

    /**
     * Array Iteration
     */
    public static class ArrayIterationType implements IterationType {

        private int indexFields = 0;

        @Override
        public Generator getGenerator() {
            return new Gen();
        }

        public class Gen implements IterationType.Generator {

            private ForEachBlock forEachBlock;
            private CodePart iterableElement;
            private String fieldName;
            private FieldDeclaration indexFieldDecl;

            @Override
            public CodeSource createInitialization() {
                return Helper.sourceOf(this.indexFieldDecl);
            }

            @Override
            public BiMultiVal<CodePart, IfExpr, Operator> createCondition() {
                return Helper.createIfVal().add1(Helper.check(Helper.accessLocalVariable(indexFieldDecl), Operators.LESS_THAN, Helper.arrayLength(CodePartUtil.getType(iterableElement), iterableElement))).make();
            }

            @Override
            public CodeSource createUpdate() {
                return Helper.sourceOf(Helper.operateLocalVariable(indexFieldDecl, Operators.INCREMENT));
            }

            @Override
            public CodeSource declareBody() {
                FieldDeclaration field = forEachBlock.getField();

                MutableCodeSource body = new MutableCodeSource();

                body.add(new CodeField(field.getName(), field.getVariableType(),
                        Helper.accessArrayValue(CodePartUtil.getType(iterableElement), iterableElement, Helper.accessLocalVariable(indexFieldDecl), field.getVariableType())));

                forEachBlock.getBody().ifPresent(body::addAll);

                return body;
            }

            @Override
            public CodeSource generate(ForEachBlock forEachBlock) {
                this.forEachBlock = forEachBlock;
                this.iterableElement = forEachBlock.getIterableElement();
                this.fieldName = "$index#" + (++indexFields);
                this.indexFieldDecl = new HiddenField(fieldName, PredefinedTypes.INT, Literals.INT(0));

                return Generator.super.generate(forEachBlock);
            }
        }
    }

    /**
     * Iterable iteration
     */
    public static class IterableIterationType implements IterationType {
        private int iterFields = 0;

        @Override
        public Generator getGenerator() {
            return new Gen();
        }

        public class Gen implements IterationType.Generator {
            private CodeType iterType = Helper.getJavaType(Iterator.class);
            private FieldDeclaration iterableField;
            private ForEachBlock forEachBlock;
            private String fieldName;
            private VariableDeclaration field;


            @Override
            public CodeSource createInitialization() {
                return Helper.sourceOf(iterableField);
            }

            @Override
            public BiMultiVal<CodePart, IfExpr, Operator> createCondition() {
                // Iterator.hasNext()Z
                MethodInvocation hasNext = CodeAPI.invokeInterface(Iterator.class,
                        CodeAPI.accessLocalVariable(iterType, fieldName), "hasNext", new TypeSpec(PredefinedTypes.BOOLEAN));

                return CodeAPI.ifExprs(CodeAPI.check(hasNext, Operators.EQUAL_TO, Literals.BOOLEAN(true)));
            }

            @Override
            public CodeSource createUpdate() {
                return null;
            }

            @Override
            public CodeSource declareBody() {
                // Iterator.next()Ljava/lang/Object;
                MethodInvocation next = CodeAPI.invokeInterface(Iterator.class,
                        CodeAPI.accessLocalVariable(iterType, fieldName), "next", new TypeSpec(PredefinedTypes.OBJECT));


                // #Type Field_Name = (#Type) Iterator.next()Ljava/lang/Object;
                FieldDeclaration forEachField = new CodeField(field.getName(), field.getVariableType(),
                        Helper.cast(PredefinedTypes.OBJECT, field.getVariableType(), next));


                MutableCodeSource codeSource = new MutableCodeSource();

                codeSource.add(forEachField);

                forEachBlock.getBody().ifPresent(codeSource::addAll);

                return codeSource;
            }

            @Override
            public CodeSource generate(ForEachBlock forEachBlock) {
                this.forEachBlock = forEachBlock;
                this.field = forEachBlock.getField();

                CodePart iterableElement = forEachBlock.getIterableElement();

                this.fieldName = "$iter#" + (++iterFields);
                this.iterableField = new HiddenField(fieldName, iterType,
                        CodeAPI.invokeInterface(Iterable.class, iterableElement, "iterator",
                                new TypeSpec(Helper.getJavaType(Iterator.class))));
                return Generator.super.generate(forEachBlock);
            }
        }
    }


}
