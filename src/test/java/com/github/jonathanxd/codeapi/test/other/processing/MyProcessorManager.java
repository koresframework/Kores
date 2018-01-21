/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.test.other.processing;

import com.github.jonathanxd.codeapi.base.VariableAccess;
import com.github.jonathanxd.codeapi.base.VariableDeclaration;
import com.github.jonathanxd.codeapi.literal.Literal;
import com.github.jonathanxd.codeapi.processor.AbstractProcessorManager;
import com.github.jonathanxd.codeapi.processor.ValidatorManager;
import com.github.jonathanxd.iutils.data.TypedData;
import com.github.jonathanxd.iutils.object.TypedKey;
import com.github.jonathanxd.iutils.option.Options;
import com.github.jonathanxd.iutils.type.TypeParameterProvider;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MyProcessorManager extends AbstractProcessorManager<String> {
    public static final TypedKey<StringBuilder> APPENDER_KEY =
            new TypedKey<>("APPENDER", new TypeParameterProvider<StringBuilder>() {
            }.createTypeInfo());
    private final Options options = new Options();
    private final ValidatorManager myValidatorManager = new MyValidatorManager();

    public MyProcessorManager() {
        this.registerProcessor(new VariableDeclarationProcessor(), VariableDeclaration.class);
        this.registerProcessor(new VariableAccessProcessor(), VariableAccess.class);
        this.registerProcessor(new LiteralProcessor(), Literal.class);
    }

    @NotNull
    @Override
    public Options getOptions() {
        return this.options;
    }

    @NotNull
    @Override
    public ValidatorManager getValidatorManager() {
        return this.myValidatorManager;
    }

    @Override
    protected void printFailMessage(@NotNull String message) {
        System.err.println(message);
        System.err.flush();
    }

    @Override
    protected String getFinalValue(@NotNull TypedData data) {
        return Objects.requireNonNull(APPENDER_KEY.getOrNull(data)).toString();
    }

    @NotNull
    @Override
    public TypedData createData() {
        TypedData data = new TypedData();

        APPENDER_KEY.set(data, new StringBuilder());

        return data;
    }
}
