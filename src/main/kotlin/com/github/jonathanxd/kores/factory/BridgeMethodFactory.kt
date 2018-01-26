/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
@file:JvmName("BridgeMethodFactory")

package com.github.jonathanxd.kores.factory

import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.Instructions
import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.base.*
import com.github.jonathanxd.kores.base.comment.Comments
import com.github.jonathanxd.kores.common.MethodTypeSpec
import com.github.jonathanxd.kores.generic.GenericSignature
import com.github.jonathanxd.kores.type.koresType
import java.util.*

/**
 * Help with bridge method creation.
 *
 * Obs: this code is a bit old but still working as intended.
 *
 * @param owner Owner of the method [current].
 * @param current Method to bridge.
 * @param methodSpec Specification of the erased method to bridge.
 */
fun bridgeMethod(
    owner: TypeDeclaration,
    current: MethodDeclarationBase,
    methodSpec: MethodTypeSpec
): MethodDeclaration {
    val parameterTypes = methodSpec.typeSpec.parameterTypes
    val currentParameters = current.parameters

    if (parameterTypes.size > currentParameters.size)
        throw IllegalArgumentException("Specified target method has more parameters than current method!")

    val currentReturnType = current.returnType

    val return_ = !currentReturnType.koresType.`is`(Types.VOID)

    val codeParameters = mutableListOf<KoresParameter>()
    val codeArguments = mutableListOf<Instruction>()

    for (i in currentParameters.indices) {
        val (_, _, currentType, name) = currentParameters[i]
        val targetType = parameterTypes[i]

        codeParameters.add(KoresParameter(emptyList(), emptySet(), targetType, name))

        codeArguments.add(cast(targetType, currentType, accessVariable(targetType, name)))
    }


    val isStatic = current.modifiers.contains(KoresModifier.STATIC)

    val invokeType = if (isStatic) InvokeType.INVOKE_STATIC else InvokeType.get(owner)

    var toAdd: Instruction = invoke(
        invokeType,
        if (isStatic) owner else Alias.THIS, if (isStatic) accessStatic() else accessThis(),
        methodSpec.methodName,
        TypeSpec(currentReturnType, currentParameters.map(KoresParameter::type)),
        codeArguments
    )

    if (return_) {
        val returnType = methodSpec.typeSpec.returnType

        toAdd = returnValue(returnType, cast(currentReturnType, returnType, toAdd))
    }

    val codeModifiers = HashSet(current.modifiers)

    codeModifiers.add(KoresModifier.BRIDGE)

    return MethodDeclaration(
        Comments.Absent,
        emptyList(),
        codeModifiers,
        GenericSignature.empty(),
        methodSpec.typeSpec.returnType,
        methodSpec.methodName,
        codeParameters,
        emptyList(),
        emptyList(),
        Instructions.fromPart(toAdd)
    )
}