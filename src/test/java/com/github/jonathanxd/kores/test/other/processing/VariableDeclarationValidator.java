/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.test.other.processing;

import com.github.jonathanxd.kores.base.VariableDeclaration;
import com.github.jonathanxd.kores.common.VariableRef;
import com.github.jonathanxd.kores.processor.ValidationEnvironment;
import com.github.jonathanxd.kores.processor.Validator;
import com.github.jonathanxd.kores.processor.ValidatorKt;
import com.github.jonathanxd.kores.processor.ValidatorManager;
import com.github.jonathanxd.iutils.data.TypedData;
import com.github.jonathanxd.iutils.object.TypedKey;
import com.github.jonathanxd.iutils.type.TypeParameterProvider;
import com.github.jonathanxd.iutils.kt.KeyUtilKt;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VariableDeclarationValidator implements Validator<VariableDeclaration> {
    // Note: this is only an example, a real world index of declared variables should be made using
    // contexts, because if a variable is declared inside a IfStatement, it should be registered in the context
    // of the IfStatement, which can access all variables inside outer contexts
    // And when exits from IfStatement context, all variables declared inside the context
    // should be removed, thus this variable will not be accessible from outer context.
    // Both generators - BytecodeGenerator with 'Frame' and SourceGenerator with VariableIndexer - have good examples
    public static final TypedKey<List<VariableRef>> DECLARED_VARIABLES_KEY = new TypedKey<>("DECLARED_VARIABLES",
            new TypeParameterProvider<List<VariableRef>>() {
            }.createTypeInfo());

    @Override
    public void validate(VariableDeclaration part,
                         @NotNull TypedData data,
                         @NotNull ValidatorManager validatorManager,
                         @NotNull ValidationEnvironment environment) {

        ValidatorKt.inspectionInContext(environment, part, variableDeclaration -> {
            environment.enterSession();

            validatorManager.validate(part.getValue(), data, environment);

            ValidationEnvironment.Session session =
                    environment.exitSession();

            if (!session.anyError()) {
                KeyUtilKt.add(DECLARED_VARIABLES_KEY, data, new VariableRef(part.getVariableType(), part.getName()));
            }

            return null;
        });
    }
}
