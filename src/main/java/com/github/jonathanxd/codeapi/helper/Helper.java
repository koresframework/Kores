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
package com.github.jonathanxd.codeapi.helper;

import com.github.jonathanxd.codeapi.CodeElement;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MethodType;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.Expression;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.Group;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.WhileBlock;
import com.github.jonathanxd.codeapi.keywords.Keywords;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.NullType;
import com.github.jonathanxd.codeapi.util.CodeArgument;
import com.github.jonathanxd.codeapi.util.CodeParameter;
import com.github.jonathanxd.codeapi.util.InvokeType;
import com.github.jonathanxd.codeapi.util.MultiVal;
import com.github.jonathanxd.codeapi.util.WeakValueHashMap;
import com.github.jonathanxd.iutils.object.ASMType;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 07/05/16.
 */
public final class Helper {

    private final static WeakValueHashMap<Class<?>, CodeType> CODE_TYPES_CACHE = new WeakValueHashMap<>();

    private static final None NONE = new None();

    //invoke(Helper.accessThis(), Helper.none(), Helper.methodSpec());
    public static CodePart invoke(InvokeType invokeType, CodeType localization, CodePart target, MethodSpec methodSpec) {
        return new MethodInvocationImpl(invokeType, localization, target, methodSpec);
    }

    public static CodePart invokeConstructor(InvokeType invokeType, CodeType localization, CodePart target, MethodSpec methodSpec) {
        return new MethodInvocationImpl(invokeType, localization, expressions(Keywords.NEW, target), methodSpec);
    }

    // TODO: need review: USING KEYWORDS, I CANNOT GENERATE BYTECODE USING KEYWORDS
    @Deprecated
    public static CodePart construct(InvokeType invokeType, CodeType localization, CodePart firstExpression, CodeType type) {
        return new MethodInvocationImpl(invokeType, localization, expression(firstExpression, expression(Keywords.NEW)), new MethodSpec(type, MethodType.CONSTRUCTOR, Collections.emptyList()));
    }

    public static CodePart accessLocalVariable(String name, CodeType type) {
        return accessVariable(accessLocal(), name, type);
    }

    public static CodePart accessVariable(CodePart localization, String name, CodeType variableType) {
        return new SimpleVariableAccess(localization, name, variableType);
    }

    public static CodePart simpleVariable(String name, CodeType type) {
        return new SimpleVariableAccess(null, name, type);
    }

    public static CodePart setVariable(CodePart localization, String variable, CodeType varType, CodePart value) {
        CodePart var = new SimpleVariableAccess(localization, variable, varType);
        return expression(var, expression(Operators.ASSIGNMENT, new NonExpressionExpr(value)));
    }

    public static CodeElement staticBlock(CodeSource body) {
        SimpleStaticBlock simpleStaticBlock = new SimpleStaticBlock(body);

        simpleStaticBlock.setBody(body);

        return simpleStaticBlock;
    }

    public static CodePart throwException(CodeType exception, CodeArgument[] arguments) {
        return new ThrowExceptionEx(exception, Arrays.asList(arguments));
    }

    public static ForBlock createFor(Expression initialization, Expression expression, Expression update, CodeSource body) {
        SimpleForBlock simpleForBlock = new SimpleForBlock(expression, expression, update, body);

        return simpleForBlock;
    }

    public static WhileBlock createWhile(Expression expression, CodeSource body) {
        return new SimpleExWhileBlock(expression, body);
    }

    public static CodePart createDoWhile(Expression expression, CodeSource body) {
        return new SimpleExDoWhileBlock(expression, body);
    }

    public static CodePart setVariableInline(CodePart localization, String variable, CodePart value) {
        VariableAccess var = new SimpleVariableAccess(localization, variable, null);
        return expression(var, expression(Operators.ASSIGNMENT, expression(value)));
    }

    public static Group group(Expression expression) {
        return new SimpleGroup(expression);
    }

    public static CodeType nullType() {
        return NullType.getNullType();
    }

    @SuppressWarnings("unchecked")
    public static CatchBlock catchBlock(Collection<CodeType> catchExceptions, String variable, CodeSource body) {
        CatchExBlock exBlock = new CatchExBlock(Collections.singleton(body),
                catchExceptions.stream().map(ex -> new CodeParameter(variable, ex)).collect(Collectors.toList()));

        return exBlock;
    }
    /*
    public static IfBlock ifExpression(MultiVal<Group> groups, CodeSource body, ElseBlock elseBlock) {
        IfBlock ifBlock = new SimpleIfBlock();

        ifBlock.addAll(StorageKeys.GROUPS, groups.iterator());

        ifBlock.setBody(body);



        return ifBlock;
    }*/

    public static ElseBlock elseExpression(CodePart next) {
        return new SimpleElseBlock(next);
    }

    public static IfBlock ifExpression(MultiVal<Group> groups, CodeSource body /*, ElseBlock else*/) {
        IfBlock ifBlock = new SimpleIfBlock(body, groups.toCollection());
        return ifBlock;
    }

    public static TryBlock tryCatchBlock(CodePart expression) {
        return new TryCatchBlock(expression, Collections.emptyList());
    }

    public static TryBlock tryCatchBlock(CodePart expression, Collection<CatchBlock> catchBlocks) {
        return new TryCatchBlock(expression, catchBlocks, Collections.emptyList());
    }

    public static TryCatchBlock surround(CodePart toSurround, Collection<CatchBlock> catchBlocks) {

        return new TryCatchBlock(null, catchBlocks, Collections.singletonList(sourceOf(toSurround)));
    }

    public static TryCatchBlock surround(CodeSource toSurround, Collection<CatchBlock> catchBlocks) {

        return new TryCatchBlock(null, catchBlocks, Collections.singletonList(toSurround));
    }

    public static CodePart localizedAtType(CodeType type) {
        return new LocalizedAtType(type);
    }

    public static Expression expression(CodePart expression, Expression nestedExpression) {
        return new SimpleExpression(expression, nestedExpression, false);
    }

    public static Expression expressions(CodePart expression, CodePart... moreExpressions) {

        if (moreExpressions.length == 0)
            return expression(expression);

        DynamicExpression base = new DynamicExpression(expression, null);

        DynamicExpression current = base;

        for (int i = 0; i < moreExpressions.length; i++) {
            CodePart atI = moreExpressions[i];

            DynamicExpression newDynamicExpression = new DynamicExpression(atI, null);

            current.setNextExpression(newDynamicExpression);

            current = newDynamicExpression;

        }

        return base;
    }

    public static Expression expression(CodePart expression) {
        return new SimpleExpression(expression, null, false);
    }

    public static Expression end(CodePart expression) {
        return new NonExpressionExpr(expression);
    }

    public static CodePart accessThis() {
        return new AccessThisEx();
    }

    public static CodePart accessThis(CodeType at) {
        return new AccessThisEx(at);
    }

    public static CodePart accessSuper() {
        return new AccessSuperEx();
    }

    public static CodePart accessSuper(CodeType at) {
        return new AccessSuperEx(at);
    }

    /**
     * Access local variable. Same as {@code null}.
     *
     * @return Access to local variable. Same as {@code null}.
     */
    public static CodePart accessLocal() {
        return null;
    }

    public static boolean isNone(CodePart codePart) {
        return codePart == NONE;
    }

    public static boolean isNone(Named named) {
        return named == NONE;
    }

    @SuppressWarnings("unchecked")
    public static <T extends CodePart & Named> T none() {
        return (T) NONE;
    }

    public static CodeSource sourceOf(CodePart... parts) {
        CodeSource source = new CodeSource();

        for (CodePart part : parts) {
            source.add(part);
        }

        return source;
    }

    public static CodePart cast(CodeType type, CodePart castedPart) {
        return new CastedExPart(type, castedPart);
    }


    public static CodeType getJavaType(Class<?> aClass) {

        if (CODE_TYPES_CACHE.containsKey(aClass)) {
            CodeType codeType = CODE_TYPES_CACHE.get(aClass);

            if (codeType != null)
                return codeType;
        }

        return new JavaType(aClass);
    }

    public static CodePart declarePackage(String packageName) {
        return new PkgDclEx(packageName);
    }

    @GenerateTo(CodeType.class)
    final private static class JavaType implements CodeType {
        private final Class<?> type;

        private JavaType(Class<?> type) {
            this.type = type;
        }

        @Override
        public String getType() {
            return type.getCanonicalName();
        }

        @Override
        public String getJavaSpecName() {
            return ASMType.getDescriptor(type);
        }

        @Override
        public int hashCode() {
            return type.hashCode();
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == null)
                return false;

            if (obj instanceof Class) {
                return this.type.equals(obj);
            }

            if (obj instanceof JavaType) {
                return this.type.equals(((JavaType) obj).type);
            }

            return super.equals(obj);
        }

        @Override
        public boolean isPrimitive() {
            return type.isPrimitive();
        }

        @Override
        public boolean isInterface() {
            return type.isInterface();
        }
    }

    final private static class None implements CodePart, Named {

        @Override
        public String getName() {
            throw new IllegalStateException("Empty element");
        }

        @Override
        public boolean isExpression() {
            throw new IllegalStateException("Empty element");
        }
    }

    @GenerateTo(Expression.class)
    private static final class NonExpressionExpr extends SimpleExpression {

        public NonExpressionExpr(CodePart expression) {
            this(expression, null);
        }

        public NonExpressionExpr(CodePart expression, Expression nextExpression) {
            super(expression, nextExpression, true);
        }

        @Override
        public boolean isCodeBlock() {
            return true;
        }

    }

}
