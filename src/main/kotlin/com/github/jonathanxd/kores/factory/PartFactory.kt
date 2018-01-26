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
@file:JvmName("PartFactory")

package com.github.jonathanxd.kores.factory

import com.github.jonathanxd.kores.ArrayInstructions
import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.Instructions
import com.github.jonathanxd.kores.base.*

// Builders
fun annotationDec() = AnnotationDeclaration.Builder.builder()

fun annotationProperty() = AnnotationProperty.Builder.builder()
fun anonymousClass() = AnonymousClass.Builder.builder()
fun arrayConstructor() = ArrayConstructor.Builder.builder()
fun arrayLength() = ArrayLength.Builder.builder()
fun arrayLoad() = ArrayLoad.Builder.builder()
fun arrayStore() = ArrayStore.Builder.builder()
fun caseStm() = Case.Builder.builder()
fun cast() = Cast.Builder.builder()
fun catchStm() = CatchStatement.Builder.builder()
fun classDec() = ClassDeclaration.Builder.builder()
fun koresParameter() = KoresParameter.Builder.builder()
fun concat() = Concat.Builder.builder()
fun constructorDec() = ConstructorDeclaration.Builder.builder()
fun controlFlow() = ControlFlow.Builder.builder()
fun enumDec() = EnumDeclaration.Builder.builder()
fun enumEntry() = EnumEntry.Builder.builder()
fun enumValue() = EnumValue.Builder.builder()
fun fieldAccess() = FieldAccess.Builder.builder()
fun fieldDec() = FieldDeclaration.Builder.builder()
fun fieldDef() = FieldDefinition.Builder.builder()
fun forEach() = ForEachStatement.Builder.builder()
fun forStm() = ForStatement.Builder.builder()
fun ifExpr() = IfExpr.Builder.builder()
fun ifGroup() = IfGroup.Builder.builder()
fun ifStm() = IfStatement.Builder.builder()
fun instanceOf() = InstanceOfCheck.Builder.builder()
fun interfaceDec() = InterfaceDeclaration.Builder.builder()
fun invokeDyn() = InvokeDynamic.Builder.builder()
fun invokeDynLambda() = InvokeDynamic.LambdaMethodRef.Builder.builder()
fun invokeDynLambdaCode() = InvokeDynamic.LambdaLocalCode.Builder.builder()
fun label() = Label.Builder.builder()
fun localCode() = LocalCode.Builder.builder()
fun methodDec() = MethodDeclaration.Builder.builder()
fun methodInv() = MethodInvocation.Builder.builder()
fun moduleDec() = ModuleDeclaration.Builder.builder()
fun moduleRef() = ModuleReference.Builder.builder()
fun newStm() = New.Builder.builder()
fun operate() = Operate.Builder.builder()
fun returnStm() = Return.Builder.builder()
fun staticBlock() = StaticBlock.Builder.builder()
fun switchStm() = SwitchStatement.Builder.builder()
fun sync() = Synchronized.Builder.builder()
fun throwStm() = ThrowException.Builder.builder()
fun tryStm() = TryStatement.Builder.builder()
fun tryWithRes() = TryWithResources.Builder.builder()
fun typeSpec() = TypeSpec.Builder.builder()
fun varAccess() = VariableAccess.Builder.builder()
fun varDec() = VariableDeclaration.Builder.builder()
fun varDef() = VariableDefinition.Builder.builder()
fun whileStm() = WhileStatement.Builder.builder()

fun source(ins: Instruction): Instructions = Instructions.fromPart(ins)
fun source(ins: Instruction, vararg other: Instruction): Instructions = ArrayInstructions(
    Array(other.size + 1, { if (it == 0) ins else other[it - 1] })
)
