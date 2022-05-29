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
package com.koresframework.kores.test.other.processing;

import com.koresframework.kores.base.VariableAccess;
import com.koresframework.kores.common.VariableRef;
import com.koresframework.kores.processor.ValidationEnvironment;
import com.koresframework.kores.processor.Validator;
import com.koresframework.kores.processor.ValidatorKt;
import com.koresframework.kores.processor.ValidatorManager;
import com.koresframework.kores.type.ImplicitKoresType;
import com.github.jonathanxd.iutils.data.TypedData;

import com.koresframework.kores.common.VariableRef;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import kotlin.collections.CollectionsKt;

public class VariableAccessValidator implements Validator<VariableAccess> {


    @Override
    public void validate(VariableAccess part,
                         @NotNull TypedData data,
                         @NotNull ValidatorManager validatorManager,
                         @NotNull ValidationEnvironment environment) {

        ValidatorKt.inspectionInContext(environment, part, variableDeclaration -> {
            List<VariableRef> vars = VariableDeclarationValidator.DECLARED_VARIABLES_KEY.getOrSet(data, new ArrayList<>());

            String name = part.getName();
            Type type = part.getVariableType();

            if (CollectionsKt.none(vars, variableRef -> variableRef.getName().equals(name)
                    && ImplicitKoresType.is(variableRef.getVariableType(), type))) {
                environment.addMessage(ValidatorKt.error(() -> "Variable '" + name + "' with type '" + type + "' was not declared."));
            }
            return null;
        });
    }
}
