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
package com.github.jonathanxd.codeapi;

import com.github.jonathanxd.codeapi.base.*;
import com.github.jonathanxd.codeapi.base.comment.*;
import com.github.jonathanxd.codeapi.builder.*;

public final class BuilderGenProvider extends MapBuilderProvider {

    @SuppressWarnings("unchecked")
    public BuilderGenProvider() {
        super();

        this.register(Access.Builder.class, AccessBuilder::new, AccessBuilder::new);
        this.register(Annotation.Builder.class, AnnotationBuilder::new, AnnotationBuilder::new);
        this.register(AnnotationDeclaration.Builder.class, AnnotationDeclarationBuilder::new, AnnotationDeclarationBuilder::new);
        this.register(AnnotationProperty.Builder.class, AnnotationPropertyBuilder::new, AnnotationPropertyBuilder::new);
        this.register(AnonymousClass.Builder.class, AnonymousClassBuilder::new, AnonymousClassBuilder::new);
        this.register(ArrayConstructor.Builder.class, ArrayConstructorBuilder::new, ArrayConstructorBuilder::new);
        this.register(ArrayLength.Builder.class, ArrayLengthBuilder::new, ArrayLengthBuilder::new);
        this.register(ArrayLoad.Builder.class, ArrayLoadBuilder::new, ArrayLoadBuilder::new);
        this.register(ArrayStore.Builder.class, ArrayStoreBuilder::new, ArrayStoreBuilder::new);
        this.register(Case.Builder.class, CaseBuilder::new, CaseBuilder::new);
        this.register(Cast.Builder.class, CastBuilder::new, CastBuilder::new);
        this.register(CatchStatement.Builder.class, CatchStatementBuilder::new, CatchStatementBuilder::new);
        this.register(ClassDeclaration.Builder.class, ClassDeclarationBuilder::new, ClassDeclarationBuilder::new);
        this.register(Code.Builder.class, CodeBuilder::new, CodeBuilder::new);
        this.register(Comments.Builder.class, CommentsBuilder::new, CommentsBuilder::new);
        this.register(Concat.Builder.class, ConcatBuilder::new, ConcatBuilder::new);
        this.register(ConstructorDeclaration.Builder.class, ConstructorDeclarationBuilder::new, ConstructorDeclarationBuilder::new);
        this.register(ControlFlow.Builder.class, ControlFlowBuilder::new, ControlFlowBuilder::new);
        this.register(EnumDeclaration.Builder.class, EnumDeclarationBuilder::new, EnumDeclarationBuilder::new);
        this.register(EnumEntry.Builder.class, EnumEntryBuilder::new, EnumEntryBuilder::new);
        this.register(EnumValue.Builder.class, EnumValueBuilder::new, EnumValueBuilder::new);
        this.register(FieldAccess.Builder.class, FieldAccessBuilder::new, FieldAccessBuilder::new);
        this.register(FieldDeclaration.Builder.class, FieldDeclarationBuilder::new, FieldDeclarationBuilder::new);
        this.register(FieldDefinition.Builder.class, FieldDefinitionBuilder::new, FieldDefinitionBuilder::new);
        this.register(ForEachStatement.Builder.class, ForEachStatementBuilder::new, ForEachStatementBuilder::new);
        this.register(ForStatement.Builder.class, ForStatementBuilder::new, ForStatementBuilder::new);
        this.register(IfExpr.Builder.class, IfExprBuilder::new, IfExprBuilder::new);
        this.register(IfStatement.Builder.class, IfStatementBuilder::new, IfStatementBuilder::new);
        this.register(InstanceOfCheck.Builder.class, InstanceOfCheckBuilder::new, InstanceOfCheckBuilder::new);
        this.register(InterfaceDeclaration.Builder.class, InterfaceDeclarationBuilder::new, InterfaceDeclarationBuilder::new);
        this.register(Label.Builder.class, LabelBuilder::new, LabelBuilder::new);
        this.register(Link.Builder.class, LinkBuilder::new, LinkBuilder::new);
        this.register(MethodDeclaration.Builder.class, MethodDeclarationBuilder::new, MethodDeclarationBuilder::new);
        this.register(MethodFragment.Builder.class, MethodFragmentBuilder::new, MethodFragmentBuilder::new);
        this.register(MethodInvocation.Builder.class, MethodInvocationBuilder::new, MethodInvocationBuilder::new);
        this.register(MethodSpecification.Builder.class, MethodSpecificationBuilder::new, MethodSpecificationBuilder::new);
        this.register(Operate.Builder.class, OperateBuilder::new, OperateBuilder::new);
        this.register(Plain.Builder.class, PlainBuilder::new, PlainBuilder::new);
        this.register(Return.Builder.class, ReturnBuilder::new, ReturnBuilder::new);
        this.register(StaticBlock.Builder.class, StaticBlockBuilder::new, StaticBlockBuilder::new);
        this.register(SwitchStatement.Builder.class, SwitchStatementBuilder::new, SwitchStatementBuilder::new);
        this.register(ThrowException.Builder.class, ThrowExceptionBuilder::new, ThrowExceptionBuilder::new);
        this.register(TryStatement.Builder.class, TryStatementBuilder::new, TryStatementBuilder::new);
        this.register(TryWithResources.Builder.class, TryWithResourcesBuilder::new, TryWithResourcesBuilder::new);
        this.register(VariableAccess.Builder.class, VariableAccessBuilder::new, VariableAccessBuilder::new);
        this.register(VariableDeclaration.Builder.class, VariableDeclarationBuilder::new, VariableDeclarationBuilder::new);
        this.register(VariableDefinition.Builder.class, VariableDefinitionBuilder::new, VariableDefinitionBuilder::new);
        this.register(WhileStatement.Builder.class, WhileStatementBuilder::new, WhileStatementBuilder::new);

    }
}
