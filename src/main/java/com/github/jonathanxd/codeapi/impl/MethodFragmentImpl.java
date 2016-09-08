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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.Scope;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.Common;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by jonathan on 21/08/16.
 */
@GenerateTo(MethodFragment.class)
public class MethodFragmentImpl extends MethodInvocationImpl implements MethodFragment {

    private static final Random RANDOM = new Random();
    private final CodeMethod codeMethod;

    public MethodFragmentImpl(CodeInterface targetInterface,
                              Scope scope,
                              CodeType returnType,
                              CodeParameter[] parameters,
                              CodeArgument[] arguments,
                              CodeSource body) {
        super(scope == Scope.STATIC ? InvokeType.INVOKE_STATIC : InvokeType.INVOKE_VIRTUAL,
                targetInterface,
                scope == Scope.STATIC ? null : Helper.accessThis(),
                MethodFragmentImpl.createSpec(targetInterface, returnType, arguments));

        this.codeMethod = new CodeMethod(this.getSpec().getMethodName(),
                Arrays.asList(CodeModifier.PRIVATE, scope == Scope.STATIC ? CodeModifier.STATIC : CodeModifier.FINAL),
                Arrays.asList(parameters),
                returnType,
                body);
    }

    private static MethodSpec createSpec(CodeInterface codeInterface, CodeType returnType, CodeArgument[] arguments) {

        return new MethodSpec(codeInterface.getSimpleName() + "_fragment$" + randomNumber(),
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
}
