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
package com.github.jonathanxd.codeapi.impl;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.Scope;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.Common;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by jonathan on 21/08/16.
 */
@GenerateTo(MethodFragment.class)
public class MethodFragmentImpl extends MethodInvocationImpl implements MethodFragment {

    private static final Random RANDOM = new Random();
    private final MethodDeclaration codeMethod;
    private final TypeDeclaration targetDeclaration;

    public MethodFragmentImpl(TypeDeclaration targetDeclaration,
                              Scope scope,
                              CodeType returnType,
                              CodeParameter[] parameters,
                              CodeArgument[] arguments,
                              CodeSource body) {
        super(scope == Scope.STATIC ? InvokeType.INVOKE_STATIC : InvokeType.INVOKE_VIRTUAL,
                targetDeclaration,
                scope == Scope.STATIC ? null : Helper.accessThis(),
                MethodFragmentImpl.createSpec(targetDeclaration, returnType, arguments));

        this.targetDeclaration = targetDeclaration;
        this.codeMethod = new CodeMethod(this.getSpec().getMethodName(),
                Arrays.asList(CodeModifier.PRIVATE, scope == Scope.STATIC ? CodeModifier.STATIC : CodeModifier.FINAL),
                Arrays.asList(parameters),
                returnType,
                body);
    }

    public MethodFragmentImpl(TypeDeclaration targetDeclaration, InvokeDynamic dynamicInvoke, InvokeType invokeType, CodeType localization, CodePart target, MethodSpecification spec, MethodDeclaration method) {
        super(dynamicInvoke, invokeType, localization, target, spec.setMethodName(MethodFragmentImpl.newName(targetDeclaration)));
        this.targetDeclaration = targetDeclaration;
        this.codeMethod = method;
    }

    private static String newName(TypeDeclaration targetDeclaration) {
        return targetDeclaration.getSimpleName() + "_fragment$" + randomNumber();
    }

    private static MethodSpecImpl createSpec(TypeDeclaration targetDeclaration, CodeType returnType, CodeArgument[] arguments) {

        return new MethodSpecImpl(MethodFragmentImpl.newName(targetDeclaration),
                Common.specFromLegacy(returnType, arguments),
                Arrays.asList(arguments));
    }

    private static String randomNumber() {
        return String.valueOf(RANDOM.nextInt()).replace('-', '_');
    }

    @Override
    public MethodDeclaration getMethod() {
        return this.codeMethod;
    }

    @Override
    public MethodFragmentImpl setMethod(MethodDeclaration method) {
        return new MethodFragmentImpl(this.getTargetDeclaration(), this.getInvokeDynamic().orElse(null), this.getInvokeType(), this.getType().orElse(null), this.getTarget().orElse(null), this.getSpec(), method);
    }

    @Override
    public TypeDeclaration getTargetDeclaration() {
        return this.targetDeclaration;
    }

    @Override
    public MethodFragmentImpl setTargetDeclaration(TypeDeclaration targetDeclaration) {
        return new MethodFragmentImpl(targetDeclaration, this.getInvokeDynamic().orElse(null), this.getInvokeType(), this.getType().orElse(null), this.getTarget().orElse(null), this.getSpec(), this.getMethod());
    }

    @Override
    public MethodFragmentImpl setLocalization(CodeType localization) {
        return new MethodFragmentImpl(this.getTargetDeclaration(), this.getInvokeDynamic().orElse(null), this.getInvokeType(), localization, this.getTarget().orElse(null), this.getSpec(), this.getMethod());
    }

    @Override
    public MethodFragmentImpl setInvokeType(InvokeType invokeType) {
        return new MethodFragmentImpl(this.getTargetDeclaration(), this.getInvokeDynamic().orElse(null), invokeType, this.getType().orElse(null), this.getTarget().orElse(null), this.getSpec(), this.getMethod());
    }

    @Override
    public MethodFragmentImpl setInvokeDynamic(InvokeDynamic invokeDynamic) {
        return new MethodFragmentImpl(this.getTargetDeclaration(), invokeDynamic, this.getInvokeType(), this.getType().orElse(null), this.getTarget().orElse(null), this.getSpec(), this.getMethod());
    }

    @Override
    public MethodFragmentImpl setType(CodeType codeType) {
        MethodSpecification spec = this.getSpec();

        spec = spec.setMethodDescription(spec.getMethodDescription().setReturnType(codeType));

        return new MethodFragmentImpl(this.getTargetDeclaration(), this.getInvokeDynamic().orElse(null), this.getInvokeType(), this.getType().orElse(null), this.getTarget().orElse(null), spec, this.getMethod());
    }

    @Override
    public MethodFragmentImpl setTarget(CodePart target) {
        return new MethodFragmentImpl(this.getTargetDeclaration(), this.getInvokeDynamic().orElse(null), this.getInvokeType(), this.getType().orElse(null), target, this.getSpec(), this.getMethod());
    }

    @Override
    public MethodFragmentImpl setSpec(MethodSpecification specification) {
        return new MethodFragmentImpl(this.getTargetDeclaration(), this.getInvokeDynamic().orElse(null), this.getInvokeType(), this.getType().orElse(null), this.getTarget().orElse(null), specification, this.getMethod());
    }
}
