package com.github.jonathanxd.kores.serialization

import com.github.jonathanxd.kores.*
import com.github.jonathanxd.kores.base.*
import com.github.jonathanxd.kores.base.comment.Code
import com.github.jonathanxd.kores.base.comment.Comments
import com.github.jonathanxd.kores.common.KoresNothing
import com.github.jonathanxd.kores.common.KoresVoid
import com.github.jonathanxd.kores.common.Stack
import com.github.jonathanxd.kores.literal.Literal
import com.github.jonathanxd.kores.literal.Literals
import com.github.jonathanxd.kores.operator.Operator
import com.github.jonathanxd.kores.type.JavaType
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