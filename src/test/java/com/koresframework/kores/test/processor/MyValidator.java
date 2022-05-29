/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.test.processor;

import com.koresframework.kores.KoresPart;
import com.koresframework.kores.base.VariableAccess;
import com.koresframework.kores.base.VariableDeclaration;
import com.koresframework.kores.processor.ValidatorManager;
import com.koresframework.kores.processor.ValidationEnvironment;
import com.koresframework.kores.processor.ValidationMessage;
import com.koresframework.kores.processor.Validator;
import com.koresframework.kores.type.KoresTypes;
import com.github.jonathanxd.iutils.data.TypedData;

import com.koresframework.kores.processor.ValidationEnvironment;
import com.koresframework.kores.processor.ValidationMessage;
import com.koresframework.kores.processor.Validator;
import com.koresframework.kores.processor.ValidatorManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MyValidator implements ValidatorManager {

    public static MyValidator INSTANCE = new MyValidator();


    @Override
    public <P> void registerValidator(@NotNull Validator<? super P> validator, @NotNull Class<P> type) {

    }

    @NotNull
    @Override
    public ValidationEnvironment createEnvironment(@NotNull TypedData data) {
        return ValidatorManager.DefaultImpls.createEnvironment(this, data);
    }

    @NotNull
    @Override
    public <P> ValidationEnvironment validate(@NotNull Class<? extends P> type,
                                                @NotNull P part,
                                                @NotNull TypedData data,
                                                @Nullable ValidationEnvironment environment) {

        if(environment == null)
            environment = this.createEnvironment(data);

        environment.enterInspectionOf(part);

        if (type == VariableDeclaration.class) {
            VariableDeclaration declaration = (VariableDeclaration) part;

            KoresPart access = declaration.getValue();

            if (access instanceof VariableAccess) {
                VariableAccess variableAccess = (VariableAccess) access;

                if (variableAccess.getName().equals(declaration.getName())
                        && KoresTypes.getKoresType(variableAccess.getVariableType()).is(KoresTypes.getKoresType(declaration.getVariableType())))
                    environment.addMessage(new ValidationMessage("Variable '" + variableAccess.getName() + "' is not defined!", ValidationMessage.Type.ERROR));

            }
        }

        environment.exitInspectionOf(part);

        return environment;
    }

    @NotNull
    @Override
    public ValidationEnvironment validate(@NotNull Object part,
                                            @NotNull TypedData data,
                                            @Nullable ValidationEnvironment environment) {
        return ValidatorManager.DefaultImpls.validate(this, part, data, environment);
    }

    @NotNull
    @Override
    public TypedData createData() {
        return new TypedData();
    }
}
