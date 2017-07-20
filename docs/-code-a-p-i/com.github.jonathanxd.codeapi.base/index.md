[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.base](.)

## Package com.github.jonathanxd.codeapi.base

### Types

| Name | Summary |
|---|---|
| [Access](-access/index.md) | `enum class Access : Enum<`[`Access`](-access/index.md)`>, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Access to a scope. Example, access to static scope of [String](#). |
| [Accessor](-accessor/index.md) | `interface Accessor : `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Accessor of an element. Example: field access/definition, method invocation
and executable code. |
| [Annotable](-annotable/index.md) | `interface Annotable : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>An part that hold annotations. |
| [Annotation](-annotation/index.md) | `data class Annotation : `[`Typed`](-typed/index.md)<br>An annotation, an annotation is composed by a pair of property name and property value. |
| [AnnotationDeclaration](-annotation-declaration/index.md) | `data class AnnotationDeclaration : `[`TypeDeclaration`](-type-declaration/index.md)<br>Annotation declaration. |
| [AnnotationProperty](-annotation-property/index.md) | `data class AnnotationProperty : `[`Named`](-named/index.md)`, `[`Typed`](-typed/index.md)`, `[`Annotable`](-annotable/index.md)`, `[`ReturnTypeHolder`](-return-type-holder/index.md)`, `[`CommentHolder`](../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)<br>Annotation property, this is part of [AnnotationDeclaration](-annotation-declaration/index.md). |
| [AnonymousClass](-anonymous-class/index.md) | `data class AnonymousClass : `[`TypeDeclaration`](-type-declaration/index.md)`, `[`SuperClassHolder`](-super-class-holder/index.md)`, `[`ArgumentsHolder`](-arguments-holder/index.md)`, `[`ImplementationHolder`](-implementation-holder/index.md)<br>Anonymous class, in Bytecode, anonymous class can have implementations,
in other languages it depends on specification. (Official Java generator may comment implementations). |
| [ArgumentsHolder](-arguments-holder/index.md) | `interface ArgumentsHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Hold arguments. |
| [ArrayAccess](-array-access/index.md) | `interface ArrayAccess : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Access to an array. |
| [ArrayConstructor](-array-constructor/index.md) | `data class ArrayConstructor : `[`ArgumentsHolder`](-arguments-holder/index.md)`, `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Constructs an array of type [arrayType](-array-constructor/array-type.md) with dimensions [dimensions](-array-constructor/dimensions.md). Example: |
| [ArrayLength](-array-length/index.md) | `data class ArrayLength : `[`ArrayAccess`](-array-access/index.md)`, `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Access length of array [target](-array-length/target.md) of type [arrayType](-array-length/array-type.md). |
| [ArrayLoad](-array-load/index.md) | `data class ArrayLoad : `[`ArrayAccess`](-array-access/index.md)`, `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Loads a value of type [valueType](-array-load/value-type.md) at [index](-array-load/--index--.md) from array [target](-array-load/target.md) of type [arrayType](-array-load/array-type.md). |
| [ArrayStore](-array-store/index.md) | `data class ArrayStore : `[`ArrayAccess`](-array-access/index.md)`, `[`ValueHolder`](-value-holder/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Stores [value](-array-store/value-to-store.md) of type [valueType](-array-store/value-type.md) in array [target](-array-store/target.md) of type [arrayType](-array-store/array-type.md) at [index](-array-store/--index--.md). |
| [BodyHolder](-body-holder/index.md) | `interface BodyHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Holds a body. Example: method declarations, type declarations, static block, constructors... |
| [Case](-case/index.md) | `data class Case : `[`ValueHolder`](-value-holder/index.md)`, `[`Typed`](-typed/index.md)`, `[`BodyHolder`](-body-holder/index.md)<br>Case statement of [SwitchStatement](-switch-statement/index.md). |
| [Cast](-cast/index.md) | `data class Cast : `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Value cast. Cast [castedPart](-cast/casted-part.md) of type [originalType](-cast/original-type.md) (null if unknown) to [targetType](-cast/target-type.md). Official
BytecodeGenerator uses the [originalType](-cast/original-type.md) to auto-box and auto-unbox the value. |
| [CatchStatement](-catch-statement/index.md) | `data class CatchStatement : `[`BodyHolder`](-body-holder/index.md)`, `[`Typed`](-typed/index.md)<br>Catch statement of a try block. Catch [exceptionTypes](-catch-statement/exception-types.md) and store caught exception in [variable](-catch-statement/variable.md). |
| [ClassDeclaration](-class-declaration/index.md) | `data class ClassDeclaration : `[`TypeDeclaration`](-type-declaration/index.md)`, `[`SuperClassHolder`](-super-class-holder/index.md)`, `[`ImplementationHolder`](-implementation-holder/index.md)<br>Declaration of a class. |
| [CodeModifier](-code-modifier/index.md) | `enum class CodeModifier : Enum<`[`CodeModifier`](-code-modifier/index.md)`>, `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Modifiers enum. |
| [CodeParameter](-code-parameter/index.md) | `data class CodeParameter : `[`Typed`](-typed/index.md)`, `[`Named`](-named/index.md)`, `[`Annotable`](-annotable/index.md)`, `[`ModifiersHolder`](-modifiers-holder/index.md)<br>Parameter part. |
| [Concat](-concat/index.md) | `data class Concat : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>String concatenation. The result depends on generator, in official BytecodeGenerator a [StringBuilder](http://docs.oracle.com/javase/6/docs/api/java/lang/StringBuilder.html) will be
used to concat values (in a future patch it will be changed to use Java 9 dynamic concatenation), in official
JavaSourceGenerator this will be translated into string concatenation. |
| [ConstructorDeclaration](-constructor-declaration/index.md) | `data class ConstructorDeclaration : `[`MethodDeclarationBase`](-method-declaration-base/index.md)<br>Instance constructor declaration. |
| [ControlFlow](-control-flow/index.md) | `data class ControlFlow : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Control the flow of a statement. |
| [ElementsHolder](-elements-holder/index.md) | `interface ElementsHolder : `[`InnerTypesHolder`](-inner-types-holder/index.md) |
| [EntryHolder](-entry-holder/index.md) | `interface EntryHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Enum entry holder |
| [EnumDeclaration](-enum-declaration/index.md) | `data class EnumDeclaration : `[`TypeDeclaration`](-type-declaration/index.md)`, `[`ImplementationHolder`](-implementation-holder/index.md)`, `[`EntryHolder`](-entry-holder/index.md)<br>Enum declaration. |
| [EnumEntry](-enum-entry/index.md) | `data class EnumEntry : `[`ArgumentsHolder`](-arguments-holder/index.md)`, `[`Named`](-named/index.md)`, `[`ElementsHolder`](-elements-holder/index.md)<br>Enumeration entry. |
| [EnumValue](-enum-value/index.md) | `data class EnumValue : `[`Named`](-named/index.md)`, `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Enum value. |
| [Export](-export/index.md) | `data class Export : Any`<br>Exports [module](-export/module.md) to modules [to](-export/to.md). |
| [FieldAccess](-field-access/index.md) | `data class FieldAccess : `[`Accessor`](-accessor/index.md)`, `[`Typed`](-typed/index.md)`, `[`Named`](-named/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Access a field of type [type](-field-access/type.md), name [name](-field-access/name.md) in type [localization](-field-access/localization.md) using [target](-field-access/target.md) as instance (Use a [Access.Type.STATIC](#) to
static accesses). |
| [FieldBase](-field-base/index.md) | `interface FieldBase : `[`Named`](-named/index.md)`, `[`Typed`](-typed/index.md)<br>Base field (access and definition common class) |
| [FieldDeclaration](-field-declaration/index.md) | `data class FieldDeclaration : `[`CodeElement`](../com.github.jonathanxd.codeapi/-code-element.md)`, `[`FieldBase`](-field-base/index.md)`, `[`Named`](-named/index.md)`, `[`Typed`](-typed/index.md)`, `[`ValueHolder`](-value-holder/index.md)`, `[`ModifiersHolder`](-modifiers-holder/index.md)`, `[`Annotable`](-annotable/index.md)`, `[`CommentHolder`](../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](-inner-types-holder/index.md)<br>Declaration of a field. |
| [FieldDefinition](-field-definition/index.md) | `data class FieldDefinition : `[`Accessor`](-accessor/index.md)`, `[`FieldBase`](-field-base/index.md)`, `[`ValueHolder`](-value-holder/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Defines the value of a field of type [type](-field-definition/type.md), name [name](-field-definition/name.md) in type [localization](-field-definition/localization.md) to [value](-field-definition/value.md), and use [target](-field-definition/target.md) as instance to access
([Access.Type.STATIC](#) for static accesses). |
| [ForEachStatement](-for-each-statement/index.md) | `data class ForEachStatement : `[`BodyHolder`](-body-holder/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>For each statement. |
| [ForStatement](-for-statement/index.md) | `data class ForStatement : `[`IfExpressionHolder`](-if-expression-holder/index.md)`, `[`BodyHolder`](-body-holder/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>For statement. |
| [GenericSignatureHolder](-generic-signature-holder/index.md) | `interface GenericSignatureHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>An element that supports [GenericSignature](../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md). |
| [IfExpr](-if-expr/index.md) | `data class IfExpr : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Condition evaluation. |
| [IfExpressionHolder](-if-expression-holder/index.md) | `interface IfExpressionHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>A element that holds [IfExpressions](-if-expr/index.md) and [Operations](../com.github.jonathanxd.codeapi.operator/-operators/index.md). |
| [IfGroup](-if-group/index.md) | `data class IfGroup : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`IfExpressionHolder`](-if-expression-holder/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Group of if expressions. |
| [IfStatement](-if-statement/index.md) | `data class IfStatement : `[`IfExpressionHolder`](-if-expression-holder/index.md)`, `[`BodyHolder`](-body-holder/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>If statement. |
| [ImplementationHolder](-implementation-holder/index.md) | `interface ImplementationHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>An implementation holder |
| [InnerTypesHolder](-inner-types-holder/index.md) | `interface InnerTypesHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>A holder of inner types |
| [InstanceOfCheck](-instance-of-check/index.md) | `data class InstanceOfCheck : `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Checks if [part](-instance-of-check/part.md) is `instanceof` [checkType](-instance-of-check/check-type.md). |
| [InterfaceDeclaration](-interface-declaration/index.md) | `data class InterfaceDeclaration : `[`TypeDeclaration`](-type-declaration/index.md)`, `[`ImplementationHolder`](-implementation-holder/index.md)<br>Interface declaration. |
| [InvokeDynamic](-invoke-dynamic/index.md) | `data class InvokeDynamic : `[`InvokeDynamicBase`](-invoke-dynamic-base/index.md) |
| [InvokeDynamicBase](-invoke-dynamic-base/index.md) | `interface InvokeDynamicBase : `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>A dynamic invocation of a method. |
| [InvokeType](-invoke-type/index.md) | `enum class InvokeType : Enum<`[`InvokeType`](-invoke-type/index.md)`>`<br>Type of the invocation. In JVM, the invocation type depends on where the element is declared and
which modifiers it has. [INVOKE_VIRTUAL](-invoke-type/-i-n-v-o-k-e_-v-i-r-t-u-a-l.md) is used to invoke instance methods in `class`es, [INVOKE_INTERFACE](-invoke-type/-i-n-v-o-k-e_-i-n-t-e-r-f-a-c-e.md)
is used to invoke interface methods in `interface`s, a special opcode is required for methods declared
in `interface` because JVM needs to resolve the position of the method in the method table. [INVOKE_STATIC](-invoke-type/-i-n-v-o-k-e_-s-t-a-t-i-c.md) is used
for invocation of static methods, does not matter where it is declared or if it is private. [INVOKE_SPECIAL](-invoke-type/-i-n-v-o-k-e_-s-p-e-c-i-a-l.md) is used to invoke
constructors, super constructors and for private methods, for private methods,
[INVOKE_SPECIAL](-invoke-type/-i-n-v-o-k-e_-s-p-e-c-i-a-l.md) is required because [INVOKE_VIRTUAL](-invoke-type/-i-n-v-o-k-e_-v-i-r-t-u-a-l.md) will always call the method of `current class`, which
is bad for private methods, because class inheritance can hide the private method and can cause a unexpected
behavior. |
| [IterationType](-iteration-type/index.md) | `data class IterationType : Any`<br>Iteration type used to generate bytecode and source code iterations. |
| [Label](-label/index.md) | `data class Label : `[`BodyHolder`](-body-holder/index.md)`, `[`Named`](-named/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Label. |
| [Line](-line/index.md) | `sealed class Line : `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, `[`ValueHolder`](-value-holder/index.md)`, InstructionWrapper`<br>Base class of line mapping. Line mapping behaves differently for different
generators. |
| [LocalCode](-local-code/index.md) | `data class LocalCode : `[`CodeElement`](../com.github.jonathanxd.codeapi/-code-element.md)`, `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, `[`InnerTypesHolder`](-inner-types-holder/index.md)<br>A local code (or local method). This code may be inlined or declared as method of current
type or translated to a lambda (for [InvokeDynamic.LambdaLocalCode](-invoke-dynamic/-lambda-local-code/index.md)). |
| [MethodDeclaration](-method-declaration/index.md) | `data class MethodDeclaration : `[`MethodDeclarationBase`](-method-declaration-base/index.md)<br>Method declaration |
| [MethodDeclarationBase](-method-declaration-base/index.md) | `interface MethodDeclarationBase : `[`CodeElement`](../com.github.jonathanxd.codeapi/-code-element.md)`, `[`ModifiersHolder`](-modifiers-holder/index.md)`, `[`ReturnTypeHolder`](-return-type-holder/index.md)`, `[`ParametersHolder`](-parameters-holder/index.md)`, `[`GenericSignatureHolder`](-generic-signature-holder/index.md)`, `[`Annotable`](-annotable/index.md)`, `[`Named`](-named/index.md)`, `[`Typed`](-typed/index.md)`, `[`CommentHolder`](../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`BodyHolder`](-body-holder/index.md)`, `[`InnerTypesHolder`](-inner-types-holder/index.md)`, `[`ThrowsHolder`](-throws-holder/index.md)<br>Method declaration |
| [MethodInvocation](-method-invocation/index.md) | `data class MethodInvocation : `[`Accessor`](-accessor/index.md)`, `[`ArgumentsHolder`](-arguments-holder/index.md)`, `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Invokes a method. |
| [ModifierType](-modifier-type/index.md) | `enum class ModifierType : Enum<`[`ModifierType`](-modifier-type/index.md)`>`<br>Modifier type enum. |
| [ModifiersHolder](-modifiers-holder/index.md) | `interface ModifiersHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>A element that have modifiers. |
| [ModuleDeclaration](-module-declaration/index.md) | `data class ModuleDeclaration : `[`Named`](-named/index.md)<br>Declaration of a module. |
| [ModuleReference](-module-reference/index.md) | `data class ModuleReference : `[`Named`](-named/index.md)<br>Reference to a module. |
| [Named](-named/index.md) | `interface Named : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>A element that have a name. |
| [New](-new/index.md) | `data class New : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Represents the construction of type, used to invoke constructor methods. (not `super` constructor or `this` constructor). |
| [Operate](-operate/index.md) | `data class Operate : `[`ValueHolder`](-value-holder/index.md)`, `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Operate a value and return result of operation. |
| [ParametersHolder](-parameters-holder/index.md) | `interface ParametersHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Parameter holder |
| [Provide](-provide/index.md) | `data class Provide : Any`<br>Provides [with](-provide/with.md) to service [service](-provide/service.md). |
| [QualifiedNamed](-qualified-named/index.md) | `interface QualifiedNamed : `[`Named`](-named/index.md)<br>A part that have a qualified name. |
| [Require](-require/index.md) | `data class Require : Any`<br>Module requires statement |
| [Return](-return/index.md) | `data class Return : `[`ValueHolder`](-value-holder/index.md)`, `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Return value. |
| [ReturnTypeHolder](-return-type-holder/index.md) | `interface ReturnTypeHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Return type holder part |
| [StaticBlock](-static-block/index.md) | `data class StaticBlock : `[`MethodDeclarationBase`](-method-declaration-base/index.md)<br>Static block (aka class constructors/class initializers). |
| [SuperClassHolder](-super-class-holder/index.md) | `interface SuperClassHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Super class holder |
| [SwitchStatement](-switch-statement/index.md) | `data class SwitchStatement : `[`ValueHolder`](-value-holder/index.md)`, `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Switch statement, this switch can switch numeric values and object values (like Enum, String or other
objects). |
| [SwitchType](-switch-type/index.md) | `enum class SwitchType : Enum<`[`SwitchType`](-switch-type/index.md)`>`<br>Switch types |
| [Synchronized](-synchronized/index.md) | `class Synchronized : `[`BodyHolder`](-body-holder/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Synchronized statement. Locks resources to thread access. |
| [ThrowException](-throw-exception/index.md) | `data class ThrowException : `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`, `[`ValueHolder`](-value-holder/index.md)<br>Throws [value](-throw-exception/value.md). |
| [ThrowsHolder](-throws-holder/index.md) | `interface ThrowsHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>A code part which declares `throws` statement. |
| [TryStatement](-try-statement/index.md) | `data class TryStatement : `[`TryStatementBase`](-try-statement-base/index.md)<br>Try-catch-finally statement. |
| [TryStatementBase](-try-statement-base/index.md) | `interface TryStatementBase : `[`BodyHolder`](-body-holder/index.md)`, `[`Typed`](-typed/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Try-catch-finally statement |
| [TryWithResources](-try-with-resources/index.md) | `data class TryWithResources : `[`TryStatementBase`](-try-statement-base/index.md)<br>Try-with-resources |
| [TypeDeclaration](-type-declaration/index.md) | `interface TypeDeclaration : `[`ModifiersHolder`](-modifiers-holder/index.md)`, `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`, `[`QualifiedNamed`](-qualified-named/index.md)`, `[`GenericSignatureHolder`](-generic-signature-holder/index.md)`, `[`Annotable`](-annotable/index.md)`, `[`CommentHolder`](../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](-inner-types-holder/index.md)`, `[`ElementsHolder`](-elements-holder/index.md)<br>Base class of all [TypeDeclaration](-type-declaration/index.md)s like classes, interfaces and enums, and inner classes. |
| [TypeSpec](-type-spec/index.md) | `data class TypeSpec : `[`Typed`](-typed/index.md)`, Comparable<`[`TypeSpec`](-type-spec/index.md)`>`<br>Type Signature representation. |
| [Typed](-typed/index.md) | `interface Typed : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>A element that can have a type. |
| [ValueHolder](-value-holder/index.md) | `interface ValueHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Value holder part |
| [VariableAccess](-variable-access/index.md) | `data class VariableAccess : `[`VariableBase`](-variable-base/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Access to a variable in local scope. |
| [VariableBase](-variable-base/index.md) | `interface VariableBase : `[`Named`](-named/index.md)`, `[`Typed`](-typed/index.md)<br>Base variable manipulation. |
| [VariableDeclaration](-variable-declaration/index.md) | `data class VariableDeclaration : `[`VariableBase`](-variable-base/index.md)`, `[`ValueHolder`](-value-holder/index.md)`, `[`Typed`](-typed/index.md)`, `[`ModifiersHolder`](-modifiers-holder/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Declares a variable of type [variableType](-variable-declaration/variable-type.md) and name [name](-variable-declaration/name.md) with default value [value](-variable-declaration/value.md) (null does not
mean that you declared a variable with null value, it means that you declared a variable without a default value,
for null values use `Literals.NULL`). |
| [VariableDefinition](-variable-definition/index.md) | `data class VariableDefinition : `[`Named`](-named/index.md)`, `[`Typed`](-typed/index.md)`, `[`ValueHolder`](-value-holder/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Defines the value of variable of type [type](-variable-definition/type.md) and name [name](-variable-definition/name.md) to [value](-variable-definition/value.md). |
| [WhileStatement](-while-statement/index.md) | `data class WhileStatement : `[`IfExpressionHolder`](-if-expression-holder/index.md)`, `[`BodyHolder`](-body-holder/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>While statement |

### Type Aliases

| Name | Summary |
|---|---|
| [CodeAnnotation](-code-annotation.md) | `typealias CodeAnnotation = `[`Annotation`](-annotation/index.md) |

### Properties

| Name | Summary |
|---|---|
| [hasDeclarations](has-declarations.md) | `val `[`EnumEntry`](-enum-entry/index.md)`.hasDeclarations: Boolean`<br>Returns whether the [EnumEntry](-enum-entry/index.md) has any declaration inside (requires a new type to be created
or a body). |
