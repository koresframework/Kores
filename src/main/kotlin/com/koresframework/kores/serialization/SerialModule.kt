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
package com.koresframework.kores.serialization

import com.koresframework.kores.*
import com.koresframework.kores.base.*
import com.koresframework.kores.base.comment.Code
import com.koresframework.kores.base.comment.Comments
import com.koresframework.kores.common.KoresNothing
import com.koresframework.kores.common.KoresVoid
import com.koresframework.kores.common.Stack
import com.koresframework.kores.literal.Literal
import com.koresframework.kores.literal.Literals
import com.koresframework.kores.operator.Operator
import com.koresframework.kores.type.JavaType
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import java.lang.reflect.Type

val koresSerializerModule = SerializersModule {
    // KoresPart
    polymorphic(KoresPart::class) {

    }

    polymorphic(Instruction::class) {
        subclass(Access::class, PolymorphicEnumSerializer(Access.serializer()))
        //subclass(Alias::class)
        subclass(ArrayConstructor::class)
        subclass(ArrayLength::class)
        subclass(ArrayLoad::class)
        subclass(ArrayStore::class)
        subclass(Cast::class)
        subclass(Comments::class)
        subclass(Concat::class)
        subclass(ControlFlow::class)
        subclass(EnumValue::class)
        subclass(FieldAccess::class)
        subclass(FieldDefinition::class)
        subclass(ForEachStatement::class)
        subclass(ForStatement::class)
        subclass(IfExpr::class)
        subclass(IfGroup::class)
        subclass(IfStatement::class)
        subclass(InstanceOfCheck::class)
        //subclass(InvokeDynamicBase::class)
        subclass(Label::class)
        //subclass(Line::class)
        //subclass(Literal::class)
        subclass(LocalCode::class)
        subclass(MethodInvocation::class)
        subclass(New::class)
        subclass(KoresNothing::class)
        subclass(Operate::class)
        //subclass(Operator::class)
        subclass(Return::class)
        subclass(ScopeAccess::class)
        subclass(Stack::class)
        subclass(SwitchStatement::class)
        subclass(Synchronized::class)
        subclass(ThrowException::class)
        subclass(TryStatement::class)
        subclass(TryWithResources::class)
        subclass(VariableAccess::class)
        subclass(VariableDeclaration::class)
        subclass(VariableDefinition::class)
        subclass(KoresVoid::class)
        subclass(WhileStatement::class)

        // Literal

        subclass(Literals.NullLiteral::class)
        subclass(Literals.ClassLiteral::class)
        subclass(Literals.ByteLiteral::class)
        subclass(Literals.ShortLiteral::class)
        subclass(Literals.IntLiteral::class)
        subclass(Literals.BoolLiteral::class)
        subclass(Literals.LongLiteral::class)
        subclass(Literals.FloatLiteral::class)
        subclass(Literals.DoubleLiteral::class)
        subclass(Literals.CharLiteral::class)
        subclass(Literals.StringLiteral::class)

        //
    }

    polymorphic(Alias::class) {
        subclass(Alias.SUPER::class)
        subclass(Alias.THIS::class)
        subclass(Alias.INTERFACE::class)
    }

    polymorphic(Operator::class) {
        subclass(Operator.Math::class)
        subclass(Operator.Conditional::class)
    }

    polymorphic(InvokeDynamicBase::class) {
        subclass(InvokeDynamic::class)
        subclass(InvokeDynamic.LambdaMethodRef::class)
        subclass(InvokeDynamic.LambdaLocalCode::class)
    }

    polymorphic(Line::class) {
        subclass(Line.TypedLine::class)
        subclass(Line.NormalLine::class)
    }

    // Literals
    polymorphic(Literal::class) {
        subclass(Literals.NullLiteral::class)
        subclass(Literals.ClassLiteral::class)
        subclass(Literals.ByteLiteral::class)
        subclass(Literals.ShortLiteral::class)
        subclass(Literals.IntLiteral::class)
        subclass(Literals.BoolLiteral::class)
        subclass(Literals.LongLiteral::class)
        subclass(Literals.FloatLiteral::class)
        subclass(Literals.DoubleLiteral::class)
        subclass(Literals.CharLiteral::class)
        subclass(Literals.StringLiteral::class)
    }

    // Type
    polymorphic(Type::class) {
        this.default {
            TypeSerializer
        }
        /*subclass(Types.PredefinedType.serializer(PredefinedTypeSerializer))
        subclass(JavaType.serializer(JavaTypeSerializer))*/
    }

    // Code.CodeNode
    polymorphic(Code.CodeNode::class) {
        subclass(Code.CodeNode.Plain::class)
        subclass(Code.CodeNode.CodeRepresentation::class)
    }

    polymorphic(TypeDeclaration::class) {
        subclass(AnnotationDeclaration::class)
        subclass(AnonymousClass::class)
        subclass(ClassDeclaration::class)
        subclass(EnumDeclaration::class)
    }

    polymorphic(Instructions::class) {
        subclass(ArrayInstructions::class)
        subclass(InstructionsView::class)
        subclass(ListInstructions::class)
    }

    polymorphic(MutableInstructions::class) {
        subclass(InstructionsView::class)
        subclass(ListInstructions::class)
    }
}