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
package com.github.jonathanxd.codeapi.test.processor;

import com.github.jonathanxd.codeapi.base.VariableDeclaration;
import com.github.jonathanxd.codeapi.exception.ValidationException;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.processor.CodeProcessor;
import com.github.jonathanxd.codeapi.processor.CodeValidator;
import com.github.jonathanxd.codeapi.processor.ContextedValidationMessage;
import com.github.jonathanxd.codeapi.processor.Processor;
import com.github.jonathanxd.codeapi.processor.ValidationMessage;
import com.github.jonathanxd.codeapi.processor.ValidatorKt;
import com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor;
import com.github.jonathanxd.codeapi.util.CodeTypes;
import com.github.jonathanxd.iutils.data.TypedData;
import com.github.jonathanxd.iutils.option.Options;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyProcessor implements CodeProcessor<String> {

    private final Options options = new Options();
    private final Map<Class<?>, Processor<?>> map = new HashMap<>();

    @NotNull
    @Override
    public Options getOptions() {
        return this.options;
    }

    @NotNull
    @Override
    public CodeValidator getValidator() {
        return MyValidator.INSTANCE;
    }

    @NotNull
    @Override
    public TypedData createData() {
        return new TypedData();
    }

    @Override
    public <T> void registerProcessor(@NotNull Processor<? super T> processor, @NotNull Class<T> type) {
        this.map.put(type, processor);
    }

    @Override
    public <T> void registerSugarSyntaxProcessor(@NotNull SugarSyntaxProcessor<? super T> sugarSyntaxProcessor, @NotNull Class<T> type) {
        this.map.put(type, sugarSyntaxProcessor);
    }

    @Override
    public String process(@NotNull Object part) {
        return (String) CodeProcessor.DefaultImpls.process(this, part);
    }

    @Override
    public <T> String process(@NotNull Class<T> type, T part) {
        return (String) CodeProcessor.DefaultImpls.process(this, type, part);
    }

    @Override
    public String process(@NotNull Object part, @NotNull TypedData data) {
        return (String) CodeProcessor.DefaultImpls.process(this, part, data);
    }

    @Override
    public <T> String process(@NotNull Class<? extends T> type, T part, @NotNull TypedData data) {

        List<ContextedValidationMessage> validate = this.getValidator().validate(type, part, this.getValidator().createData(), null).getValidationMessages();

        if (ValidatorKt.hasContextedError(validate)) {
            ValidationException e = null;

            for (ContextedValidationMessage validationMessage : validate) {
                ValidationException ex = new ValidationException(validationMessage);

                if (e == null)
                    e = ex;
                else
                    e.addSuppressed(ex);
            }

            if (e != null)
                throw new ValidationException("Validation failed!", e);
        }


        if (type == VariableDeclaration.class) {
            VariableDeclaration declaration = (VariableDeclaration) part;
            return this.process(Type.class, declaration.getVariableType(), data)
                    + " "
                    + declaration.getName()
                    + (declaration.getValue() != null ?
                    " = " + this.process(declaration.getValue(), data)
                    : "");
        }

        if (type == Type.class) {
            return CodeTypes.getCodeType((Type) part).getCanonicalName();
        }

        if (type == Literals.StringLiteral.class) {
            return ((Literals.StringLiteral) part).getName();
        }

        throw new IllegalArgumentException("Cannot process type: " + type + " (part: " + part + ", data: " + data + ")");
    }
}
