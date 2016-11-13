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
package com.github.jonathanxd.codeapi.read.bytecode.asm

import com.github.jonathanxd.codeapi.MutableCodeSource
import com.github.jonathanxd.codeapi.common.CodeParameter
import com.github.jonathanxd.codeapi.common.Environment
import com.github.jonathanxd.codeapi.impl.CodeConstructor
import com.github.jonathanxd.codeapi.impl.CodeMethod
import com.github.jonathanxd.codeapi.impl.StaticBlockImpl
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration
import com.github.jonathanxd.codeapi.read.bytecode.CommonRead
import com.github.jonathanxd.codeapi.read.bytecode.Constants
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.ParameterNode

object MethodAnalyzer {
    @Suppress("UNCHECKED_CAST")
    fun analyze(methodNode: MethodNode, environment: Environment): MethodDeclaration {
        val methodName = methodNode.name
        val desc = methodNode.desc
        val parameters = methodNode.parameters as List<ParameterNode>

        val codeModifiers = CommonRead.modifiersFromAccess(methodNode.access)

        val declaration = environment.data.getRequired(Constants.TYPE_DECLARATION)

        val typeSpec = CommonRead.typeSpecFromDesc(environment, declaration, methodName, desc)

        val codeParameters = typeSpec.parameterTypes.mapIndexed { i, codeType ->

            val name = if (parameters.size > i) parameters[i].name else "param$i"

            CodeParameter(name, codeType)
        }


        val method: MethodDeclaration =
                when (methodName) {
                    "<init>" -> CodeConstructor(codeModifiers, codeParameters, MutableCodeSource())
                    "<clinit>" -> StaticBlockImpl(MutableCodeSource())
                    else -> CodeMethod(methodName, codeModifiers, codeParameters, typeSpec.returnType, MutableCodeSource())
                }

        val instructions = methodNode.instructions

        return method
    }
}
