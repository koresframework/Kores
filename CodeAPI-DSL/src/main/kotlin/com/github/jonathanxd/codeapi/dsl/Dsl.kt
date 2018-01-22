/*
 *      CodeAPI-DSL - Defines Kotlin DSL to create CodeAPI parts. <https://github.com/JonathanxD/CodeAPI>
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
package com.github.jonathanxd.codeapi.dsl

import com.github.jonathanxd.codeapi.*
import com.github.jonathanxd.codeapi.base.*
import com.github.jonathanxd.codeapi.base.Annotation
import com.github.jonathanxd.codeapi.base.comment.*
import com.github.jonathanxd.codeapi.common.DynamicMethodSpec
import com.github.jonathanxd.codeapi.common.MethodInvokeSpec
import com.github.jonathanxd.codeapi.common.MethodTypeSpec
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.literal.Literals
import com.github.jonathanxd.codeapi.operator.Operator
import com.github.jonathanxd.codeapi.type.*
import com.github.jonathanxd.iutils.type.TypeParameterProvider
import java.lang.reflect.Type

typealias Recv<T> = T.() -> Unit
typealias DslAnnotations = DslList<Annotation>
typealias DslComments = DslList<Comment>
typealias DslModifiers = DslSet<CodeModifier>
typealias DslGenericTypes = DslList<GenericType>
typealias DslProperties = DslList<AnnotationProperty>
typealias DslFields = DslList<FieldDeclaration>
typealias DslConstructors = DslList<ConstructorDeclaration>
typealias DslMethods = DslList<MethodDeclaration>
typealias DslTypeDeclarations = DslList<TypeDeclaration>
typealias DslTypes = DslList<TypeDeclaration>
typealias DslEnumEntries = DslList<EnumEntry>
typealias DslValues = DslMap<String, Any>
typealias DslCodeSource = DslList<CodeInstruction>
typealias DslInstructions = DslList<CodeInstruction>
typealias DslRequires = DslList<Require>
typealias DslExports = DslList<Export>
typealias DslOpens = DslList<Open>
typealias DslModuleReferences = DslList<ModuleReference>
typealias DslProvides = DslList<Provide>
typealias DslCases = DslList<Case>

/**
 * @see AnnotationDeclaration
 */
fun annotationDeclaration(
    comments: Comments = Comments.Absent,
    outerType: Type? = null,
    annotations: List<Annotation> = emptyList(),
    modifiers: Set<CodeModifier> = emptySet(),
    name: String,
    genericSignature: GenericSignature = GenericSignature.empty(),
    properties: List<AnnotationProperty> = emptyList(),
    fields: List<FieldDeclaration> = emptyList(),
    innerTypes: List<TypeDeclaration>
) = AnnotationDeclaration(
    comments = comments,
    outerType = outerType,
    annotations = annotations,
    modifiers = modifiers,
    specifiedName = name,
    genericSignature = genericSignature,
    properties = properties,
    fields = fields,
    innerTypes = innerTypes
)

/**
 * @see AnonymousClass
 */
fun anonymousClass(
    comments: Comments = Comments.Absent,
    outerType: Type? = null,
    annotations: List<Annotation> = emptyList(),
    name: String,
    superClass: Type = Types.OBJECT,
    implementations: List<Type> = emptyList(),
    constructorSpec: TypeSpec = constructorTypeSpec(),
    arguments: List<CodeInstruction> = emptyList(),
    constructorBody: CodeSource = CodeSource.empty(),
    staticBlock: StaticBlock = staticBlock(),
    fields: List<FieldDeclaration> = emptyList(),
    constructors: List<ConstructorDeclaration> = emptyList(),
    methods: List<MethodDeclaration> = emptyList(),
    innerTypes: List<TypeDeclaration> = emptyList()
) = AnonymousClass(
    comments = comments,
    outerType = outerType,
    annotations = annotations,
    specifiedName = name,
    superClass = superClass,
    implementations = implementations,
    constructorSpec = constructorSpec,
    arguments = arguments,
    constructorBody = constructorBody,
    staticBlock = staticBlock,
    fields = fields,
    constructors = constructors,
    methods = methods,
    innerTypes = innerTypes
)

/**
 * @see ClassDeclaration
 */
fun classDeclaration(
    outerType: Type? = null,
    comments: Comments = Comments.Absent,
    annotations: List<Annotation> = emptyList(),
    modifiers: Set<CodeModifier> = emptySet(),
    name: String,
    genericSignature: GenericSignature = GenericSignature.empty(),
    superClass: Type = Types.OBJECT,
    implementations: List<Type> = emptyList(),
    staticBlock: StaticBlock = staticBlock(),
    fields: List<FieldDeclaration> = emptyList(),
    constructors: List<ConstructorDeclaration> = emptyList(),
    methods: List<MethodDeclaration> = emptyList(),
    innerTypes: List<TypeDeclaration> = emptyList()
) = ClassDeclaration(
    outerType = outerType,
    comments = comments,
    annotations = annotations,
    modifiers = modifiers,
    specifiedName = name,
    genericSignature = genericSignature,
    superClass = superClass,
    implementations = implementations,
    staticBlock = staticBlock,
    fields = fields,
    constructors = constructors,
    methods = methods,
    innerTypes = innerTypes
)

/**
 * @see EnumDeclaration
 */
fun enumDeclaration(
    outerType: Type? = null,
    comments: Comments = Comments.Absent,
    annotations: List<Annotation> = emptyList(),
    modifiers: Set<CodeModifier> = emptySet(),
    name: String,
    genericSignature: GenericSignature = GenericSignature.empty(),
    implementations: List<Type> = emptyList(),
    entries: List<EnumEntry> = emptyList(),
    staticBlock: StaticBlock = staticBlock(),
    fields: List<FieldDeclaration> = emptyList(),
    constructors: List<ConstructorDeclaration> = emptyList(),
    methods: List<MethodDeclaration> = emptyList(),
    innerTypes: List<TypeDeclaration> = emptyList()
) = EnumDeclaration(
    outerType = outerType,
    comments = comments,
    annotations = annotations,
    modifiers = modifiers,
    specifiedName = name,
    genericSignature = genericSignature,
    implementations = implementations,
    entries = entries,
    staticBlock = staticBlock,
    fields = fields,
    constructors = constructors,
    methods = methods,
    innerTypes = innerTypes
)

/**
 * @see InterfaceDeclaration
 */
fun interfaceDeclaration(
    outerType: Type? = null,
    comments: Comments = Comments.Absent,
    annotations: List<Annotation> = emptyList(),
    modifiers: Set<CodeModifier> = emptySet(),
    name: String,
    genericSignature: GenericSignature = GenericSignature.empty(),
    implementations: List<Type> = emptyList(),
    fields: List<FieldDeclaration> = emptyList(),
    methods: List<MethodDeclaration> = emptyList(),
    innerTypes: List<TypeDeclaration> = emptyList()
) = InterfaceDeclaration(
    outerType = outerType,
    comments = comments,
    annotations = annotations,
    modifiers = modifiers,
    specifiedName = name,
    genericSignature = genericSignature,
    implementations = implementations,
    fields = fields,
    methods = methods,
    innerTypes = innerTypes
)

/**
 * @see StaticBlock
 */
fun staticBlock(
    comments: Comments = Comments.Absent,
    innerTypes: List<TypeDeclaration> = emptyList(),
    body: CodeSource = CodeSource.empty()
) = StaticBlock(
    comments = comments,
    innerTypes = innerTypes,
    body = body
)

/**
 * A [TypeSpec] of [Void] return type.
 *
 * @see TypeSpec
 */
fun constructorTypeSpec(vararg parameterTypes: Type) = voidTypeSpec(*parameterTypes)

/**
 * A [TypeSpec] of [Void] return type.
 *
 * @see TypeSpec
 */
fun constructorTypeSpec(parameterTypes: List<Type>) = voidTypeSpec(parameterTypes)

/**
 * A [TypeSpec] of [Void] return type.
 *
 * @see TypeSpec
 */
fun constructorTypeSpec() = voidTypeSpec()

/**
 * A [TypeSpec] of [Void] return type.
 *
 * @see TypeSpec
 */
fun voidTypeSpec(parameterTypes: List<Type> = emptyList()) = TypeSpec(
    returnType = Types.VOID,
    parameterTypes = parameterTypes
)

/**
 * A [TypeSpec] of [Void] return type.
 *
 * @see TypeSpec
 */
fun voidTypeSpec(vararg parameterTypes: Type) = voidTypeSpec(parameterTypes.toList())

/**
 * A [TypeSpec] of [Void] return type.
 *
 * @see TypeSpec
 */
fun voidTypeSpec() = voidTypeSpec(emptyList())

/**
 * @see TypeSpec
 */
fun typeSpec(
    returnType: Type,
    parameterTypes: List<Type> = emptyList()
) = TypeSpec(
    returnType = returnType,
    parameterTypes = parameterTypes
)

/**
 * @see TypeSpec
 */
fun typeSpec(
    returnType: Type,
    vararg parameterTypes: Type
) = typeSpec(returnType, parameterTypes.toList())

/**
 * @see TypeRef
 */
fun typeRef(
    outerType: Type? = null,
    name: String,
    isInterface: Boolean = false
) = TypeRef(
    outerType = outerType,
    specifiedName = name,
    isInterface = isInterface
)

/**
 * @see AnnotationProperty
 */
fun annotationProperty(
    comments: Comments = Comments.Absent,
    annotations: List<Annotation> = emptyList(),
    type: Type,
    name: String,
    defaultValue: Any? = null
) = AnnotationProperty(
    comments = comments,
    annotations = annotations,
    type = type,
    name = name,
    defaultValue = defaultValue
)

/**
 * @see Annotation
 */
fun annotation(
    type: Type,
    values: Map<String, Any> = emptyMap(),
    retention: CodeRetention = CodeRetention.CLASS
) = Annotation(
    type = type,
    values = values,
    retention = retention
)

/**
 * [CodeRetention.RUNTIME]
 */
fun runtimeRetention() = CodeRetention.RUNTIME

/**
 * [CodeRetention.CLASS]
 */
fun classRetention() = CodeRetention.CLASS

/**
 * [CodeRetention.SOURCE]
 */
fun sourceRetention() = CodeRetention.SOURCE

/**
 * @see ArrayConstructor
 */
fun arrayConstructor(
    arrayType: Type,
    dimensions: List<CodeInstruction> = emptyList(),
    arguments: List<CodeInstruction>
) = ArrayConstructor(
    arrayType = arrayType,
    dimensions = if (dimensions.isNotEmpty()) dimensions else listOf(Literals.INT(arguments.size)),
    arguments = arguments
)

/**
 * @see ArrayLength
 */
fun arrayLength(
    arrayType: Type,
    target: CodeInstruction
) = ArrayLength(
    arrayType = arrayType,
    target = target
)

/**
 * @see ArrayLoad
 */
fun arrayLoad(
    arrayType: Type,
    target: CodeInstruction,
    index: CodeInstruction,
    valueType: Type
) = ArrayLoad(
    arrayType = arrayType,
    target = target,
    index = index,
    valueType = valueType
)

/**
 * @see ArrayStore
 */
fun arrayStore(
    arrayType: Type,
    target: CodeInstruction,
    index: CodeInstruction,
    valueType: Type,
    valueToStore: CodeInstruction
) = ArrayStore(
    arrayType = arrayType,
    target = target,
    index = index,
    valueType = valueType,
    valueToStore = valueToStore
)

/**
 * @see Case
 */
fun case(
    value: CodeInstruction,
    body: CodeSource = CodeSource.empty()
) = Case(
    value = value,
    body = body
)

/**
 * @see Cast
 */
fun cast(
    originalType: Type?,
    targetType: Type,
    instruction: CodeInstruction
) = Cast(
    originalType = originalType,
    targetType = targetType,
    instruction = instruction
)

/**
 * @see CatchStatement
 */
fun catchStatement(
    exceptionTypes: List<Type>,
    variable: VariableDeclaration,
    body: CodeSource = CodeSource.empty()
) = CatchStatement(
    exceptionTypes = exceptionTypes,
    variable = variable,
    body = body
)

/**
 * @see CodeParameter
 */
fun codeParameter(
    annotations: List<Annotation> = emptyList(),
    modifiers: Set<CodeModifier> = emptySet(),
    type: Type,
    name: String
) = CodeParameter(
    annotations = annotations,
    modifiers = modifiers,
    type = type,
    name = name
)

/**
 * @see Concat
 */
fun concat(
    concatenations: List<CodeInstruction>
) = Concat(
    concatenations = concatenations
)

/**
 * @see ConstructorDeclaration
 */
fun constructorDeclaration(
    comments: Comments = Comments.Absent,
    annotations: List<Annotation> = emptyList(),
    modifiers: Set<CodeModifier> = emptySet(),
    genericSignature: GenericSignature = GenericSignature.empty(),
    parameters: List<CodeParameter> = emptyList(),
    innerTypes: List<TypeDeclaration> = emptyList(),
    throwsClause: List<Type> = emptyList(),
    body: CodeSource = CodeSource.empty()

) = ConstructorDeclaration(
    comments = comments,
    annotations = annotations,
    modifiers = modifiers,
    genericSignature = genericSignature,
    parameters = parameters,
    innerTypes = innerTypes,
    throwsClause = throwsClause,
    body = body
)

/**
 * @see ControlFlow
 */
fun controlFlow(
    type: ControlFlow.Type,
    at: Label?
) = ControlFlow(
    type = type,
    at = at
)

/**
 * @see EnumValue
 */
fun enumValue(
    enumType: Type,
    enumEntry: String
) = EnumValue(
    enumType = enumType,
    enumEntry = enumEntry
)

/**
 * @see FieldAccess
 */
fun fieldAccess(
    localization: Type,
    target: CodeInstruction,
    type: Type,
    name: String
) = FieldAccess(
    localization = localization,
    target = target,
    type = type,
    name = name
)

/**
 * @see FieldDeclaration
 */
fun fieldDeclaration(
    comments: Comments = Comments.Absent,
    annotations: List<Annotation> = emptyList(),
    modifiers: Set<CodeModifier> = emptySet(),
    type: Type,
    name: String,
    innerTypes: List<TypeDeclaration> = emptyList(),
    value: CodeInstruction
) = FieldDeclaration(
    comments = comments,
    annotations = annotations,
    modifiers = modifiers,
    type = type,
    name = name,
    innerTypes = innerTypes,
    value = value
)

/**
 * @see FieldDefinition
 */
fun fieldDefinition(
    localization: Type,
    target: CodeInstruction,
    type: Type,
    name: String,
    value: CodeInstruction
) = FieldDefinition(
    localization = localization,
    target = target,
    type = type,
    name = name,
    value = value
)

/**
 * @see ForEachStatement
 */
fun forEachStatement(
    variable: VariableDeclaration,
    iterationType: IterationType = IterationType.ITERABLE_ELEMENT,
    iterableElement: CodeInstruction,
    body: CodeSource = CodeSource.empty()
) = ForEachStatement(
    variable = variable,
    iterationType = iterationType,
    iterableElement = iterableElement,
    body = body
)

/**
 * [IterationType.ARRAY]
 */
fun arrayIteration() = IterationType.ARRAY

/**
 * [IterationType.ITERABLE_ELEMENT]
 */
fun iterableIteration() = IterationType.ITERABLE_ELEMENT

/**
 * @see ForStatement
 */
fun forStatement(
    forInit: List<CodeInstruction>,
    forExpression: List<CodeInstruction>,
    forUpdate: List<CodeInstruction>,
    body: CodeSource = CodeSource.empty()
) = ForStatement(
    forInit = forInit,
    forExpression = forExpression,
    forUpdate = forUpdate,
    body = body
)

/**
 * @see IfExpr
 */
fun ifExpr(
    expr1: CodeInstruction,
    operation: Operator.Conditional,
    expr2: CodeInstruction
) = IfExpr(
    expr1 = expr1,
    operation = operation,
    expr2 = expr2
)

/**
 * @see IfGroup
 */
fun ifGroup(
    expressions: List<CodeInstruction>
) = IfGroup(
    expressions = expressions
)

/**
 * @see IfStatement
 */
fun ifStatement(
    expressions: List<CodeInstruction>,
    body: CodeSource = CodeSource.empty(),
    elseStatement: CodeSource = CodeSource.empty()
) = IfStatement(
    expressions = expressions,
    body = body,
    elseStatement = elseStatement
)

/**
 * @see InstanceOfCheck
 */
fun instanceOfCheck(
    part: CodeInstruction,
    checkType: Type
) = InstanceOfCheck(
    part = part,
    checkType = checkType
)

/**
 * @see InvokeDynamic
 */
fun invokeDynamic(
    bootstrap: MethodInvokeSpec,
    dynamicMethod: DynamicMethodSpec,
    bootstrapArgs: List<Any>
) = InvokeDynamic(
    bootstrap,
    dynamicMethod,
    bootstrapArgs
)

/**
 * @see InvokeDynamic.LambdaMethodRef
 */
fun invokeDynamicMethodRef(
    methodRef: MethodInvokeSpec,
    target: CodeInstruction,
    arguments: List<CodeInstruction>,
    baseSam: MethodTypeSpec,
    expectedTypes: TypeSpec
) = InvokeDynamic.LambdaMethodRef(
    methodRef = methodRef,
    target = target,
    arguments = arguments,
    baseSam = baseSam,
    expectedTypes = expectedTypes
)

/**
 * @see InvokeDynamic.LambdaLocalCode
 */
fun invokeDynamicCode(
    baseSam: MethodTypeSpec,
    expectedTypes: TypeSpec,
    localCode: LocalCode,
    arguments: List<CodeInstruction>
) = InvokeDynamic.LambdaLocalCode(
    baseSam = baseSam,
    expectedTypes = expectedTypes,
    localCode = localCode,
    arguments = arguments
)

/**
 * @see Label
 */
fun label(
    name: String,
    body: CodeSource = CodeSource.empty()
) = Label(
    name = name,
    body = body
)

/**
 * @see Line.TypedLine
 */
fun typedLine(
    line: Int,
    value: CodeInstruction,
    type: Type
) = Line.TypedLine(
    line = line,
    value = value,
    type = type
)

/**
 * @see Line.NormalLine
 */
fun normalLine(
    line: Int,
    value: CodeInstruction
) = Line.NormalLine(
    line = line,
    value = value
)

/**
 * @see LocalCode
 */
fun localCode(
    declaringType: Type,
    invokeType: InvokeType,
    declaration: MethodDeclaration,
    innerTypes: List<TypeDeclaration> = emptyList()
) = LocalCode(
    declaringType = declaringType,
    invokeType = invokeType,
    declaration = declaration,
    innerTypes = innerTypes
)

/**
 * @see MethodInvocation
 */
fun methodInvocation(
    invokeType: InvokeType,
    target: CodeInstruction,
    spec: MethodTypeSpec,
    arguments: List<CodeInstruction> = emptyList()
) = MethodInvocation(
    invokeType = invokeType,
    target = target,
    spec = spec,
    arguments = arguments
)

/**
 * @see MethodTypeSpec
 */
fun methodTypeSpec(
    localization: Type,
    methodName: String,
    typeSpec: TypeSpec
) = MethodTypeSpec(
    localization = localization,
    methodName = methodName,
    typeSpec = typeSpec
)

/**
 * @see MethodDeclaration
 */
fun methodDeclaration(
    comments: Comments = Comments.Absent,
    annotations: List<Annotation> = emptyList(),
    modifiers: Set<CodeModifier> = emptySet(),
    genericSignature: GenericSignature = GenericSignature.empty(),
    returnType: Type,
    name: String,
    parameters: List<CodeParameter> = emptyList(),
    innerTypes: List<TypeDeclaration> = emptyList(),
    throwsClause: List<Type> = emptyList(),
    body: CodeSource = CodeSource.empty()
) = MethodDeclaration(
    comments = comments,
    annotations = annotations,
    modifiers = modifiers,
    genericSignature = genericSignature,
    returnType = returnType,
    name = name,
    parameters = parameters,
    innerTypes = innerTypes,
    throwsClause = throwsClause,
    body = body
)

/**
 * @see ModuleReference
 */
fun moduleReference(
    name: String
) = ModuleReference(
    name = name
)

/**
 * @see ModuleReference
 */
fun moduleDeclaration(
    modifiers: Set<CodeModifier> = emptySet(),
    name: String,
    version: String? = null,
    requires: List<Require> = emptyList(),
    exports: List<Export> = emptyList(),
    opens: List<Open> = emptyList(),
    uses: List<ModuleReference> = emptyList(),
    provides: List<Provide> = emptyList()
) = ModuleDeclaration(
    modifiers = modifiers,
    name = name,
    version = version,
    requires = requires,
    exports = exports,
    opens = opens,
    uses = uses,
    provides = provides
)

/**
 * @see New
 */
fun newInstance(
    localization: Type
) = New(
    localization = localization
)

/**
 * @see Operate
 */
fun operate(
    target: CodeInstruction,
    operation: Operator.Math,
    value: CodeInstruction
) = Operate(
    target = target,
    operation = operation,
    value = value
)

/**
 * @see Return
 */
fun returnValue(
    type: Type,
    value: CodeInstruction
) = Return(
    type = type,
    value = value
)

/**
 * @see ScopeAccess
 */
fun scopeAccess(
    type: Type,
    scope: Scope = Scope.OUTER
) = ScopeAccess(
    type = type,
    scope = scope
)

/**
 * @see SwitchStatement
 */
fun switchStatement(
    value: CodeInstruction,
    switchType: SwitchType,
    cases: List<Case> = emptyList()
) = SwitchStatement(
    value = value,
    switchType = switchType,
    cases = cases
)

/**
 * @see Synchronized
 */
fun synchronizedStatement(
    instruction: CodeInstruction,
    body: CodeSource = CodeSource.empty()
) = Synchronized(
    instruction = instruction,
    body = body
)

/**
 * @see ThrowException
 */
fun throwException(
    value: CodeInstruction
) = ThrowException(
    value = value
)

/**
 * @see TryStatement
 */
fun tryStatement(
    body: CodeSource = CodeSource.empty(),
    catchStatements: List<CatchStatement> = emptyList(),
    finallyStatement: CodeSource = CodeSource.empty()
) = TryStatement(
    body = body,
    catchStatements = catchStatements,
    finallyStatement = finallyStatement
)

/**
 * @see TryWithResources
 */
fun tryWithResources(
    variable: VariableDeclaration,
    body: CodeSource = CodeSource.empty(),
    catchStatements: List<CatchStatement> = emptyList(),
    finallyStatement: CodeSource = CodeSource.empty()
) = TryWithResources(
    variable = variable,
    body = body,
    catchStatements = catchStatements,
    finallyStatement = finallyStatement
)

/**
 * @see VariableAccess
 */
fun variableAccess(
    variableType: Type,
    name: String
) = VariableAccess(
    variableType = variableType,
    name = name
)

/**
 * @see VariableDeclaration
 */
fun variableDeclaration(
    modifiers: Set<CodeModifier> = emptySet(),
    variableType: Type,
    name: String,
    value: CodeInstruction
) = VariableDeclaration(
    modifiers = modifiers,
    variableType = variableType,
    name = name,
    value = value
)

/**
 * @see VariableDefinition
 */
fun variableDefinition(
    type: Type,
    name: String,
    value: CodeInstruction
) = VariableDefinition(
    type = type,
    name = name,
    value = value
)

/**
 * @see VariableDefinition
 */
fun whileStatement(
    type: WhileStatement.Type,
    expressions: List<CodeInstruction>,
    body: CodeSource = CodeSource.empty()
) = WhileStatement(
    type = type,
    expressions = expressions,
    body = body
)

/**
 * @see [Literals.STRING]
 */
fun String.toLiteral() = Literals.STRING(this)

/**
 * @see [Literals.BOOLEAN]
 */
fun Boolean.toLiteral() = Literals.BOOLEAN(this)

/**
 * @see [Literals.CHAR]
 */
fun Char.toLiteral() = Literals.CHAR(this)

/**
 * @see [Literals.BYTE]
 */
fun Byte.toLiteral() = Literals.BYTE(this)

/**
 * @see [Literals.SHORT]
 */
fun Short.toLiteral() = Literals.SHORT(this)

/**
 * @see [Literals.INT]
 */
fun Int.toLiteral() = Literals.INT(this)

/**
 * @see [Literals.FLOAT]
 */
fun Float.toLiteral() = Literals.FLOAT(this)

/**
 * @see [Literals.LONG]
 */
fun Long.toLiteral() = Literals.LONG(this)

/**
 * @see [Literals.DOUBLE]
 */
fun Double.toLiteral() = Literals.DOUBLE(this)

/**
 * @see [Literals.TYPE]
 */
fun Type.toLiteral() = Literals.TYPE(this)

/**
 * @see [Literals.NULL]
 */
fun nullLiteral() = Literals.NULL

/**
 * @see [Literals.TRUE]
 */
fun trueLiteral() = Literals.TRUE

/**
 * @see [Literals.FALSE]
 */
fun falseLiteral() = Literals.FALSE

// Comments

/**
 * @see Code.CodeNode.Plain
 */
fun plainCode(plain: String) = Code(Code.CodeNode.Plain(plain))

/**
 * @see Code.CodeNode.CodeRepresentation
 */
fun representationCode(codePart: CodePart) = Code(Code.CodeNode.CodeRepresentation(codePart))

/**
 * @see Link
 */
fun link(linkName: String? = null, target: Link.LinkTarget) = Link(name = linkName, target = target)

/**
 * @see Link.LinkTarget.Element.Class
 */
fun linkClass(linkName: String? = null, type: Type) =
    link(linkName, Link.LinkTarget.Element.Class(type))

/**
 * @see Link.LinkTarget.Element.Field
 */
fun linkField(linkName: String? = null, declaringClass: Type, fieldName: String, type: Type) =
    link(
        linkName,
        Link.LinkTarget.Element.Field(
            declaringClass = declaringClass,
            name = fieldName,
            type = type
        )
    )

/**
 * @see Link.LinkTarget.Element.Method
 */
fun linkMethod(linkName: String? = null, spec: MethodTypeSpec) =
    link(linkName, Link.LinkTarget.Element.Method(spec))

/**
 * @see Link.LinkTarget.URL
 */
fun linkUrl(url: String) = Link.LinkTarget.URL(url)

/**
 * @see Plain
 */
fun plain(plain: String) = Plain(plain)

/**
 * Returns a [Type] of [T]. (Same [codeTypeOf] but with shorter name and [Type] return type)
 */
inline fun <reified T> typeOf(): Type = codeTypeOf<T>()

/**
 * Returns a [CodeType] of [T]. (Same as [T]`::class.java.codeType`)
 */
inline fun <reified T> codeTypeOf(): CodeType = T::class.java.codeType

/**
 * Returns a [GenericType] of generic [T]. This means that `genericTypeOf<List<String>>()`
 * returns a [GenericType] of `List<String>` (same representation as
 * `Generic.type(List::class.java).of(String::class.java)` returns).
 */
inline fun <reified T> genericTypeOf(): GenericType =
    object : TypeParameterProvider<T>() {}.type.codeType.asGeneric

fun annotations(f: Recv<DslAnnotations>): List<Annotation> =
    DslAnnotations().also(f).collection

fun absentComments() =
    Comments.Absent

fun comments(type: Comments.Type, f: Recv<DslComments>): Comments =
    DslComments().also(f).let { Comments(it.collection, type) }

fun modifiers(f: Recv<DslModifiers>): Set<CodeModifier> =
    DslModifiers().also(f).collection

fun signature(f: Recv<DslGenericTypes>): GenericSignature =
    GenericSignature.create(DslGenericTypes().also(f).collection)

fun properties(f: Recv<DslProperties>): List<AnnotationProperty> =
    DslProperties().also(f).collection

fun fields(f: Recv<DslFields>): List<FieldDeclaration> =
    DslFields().also(f).collection

fun constructors(f: Recv<DslConstructors>): List<ConstructorDeclaration> =
    DslConstructors().also(f).collection

fun methods(f: Recv<DslMethods>): List<MethodDeclaration> =
    DslMethods().also(f).collection

fun typeDeclarations(f: Recv<DslTypeDeclarations>): List<TypeDeclaration> =
    DslTypeDeclarations().also(f).collection

fun types(f: Recv<DslTypes>): List<Type> =
    DslTypes().also(f).collection

fun enumEntries(f: Recv<DslEnumEntries>): List<EnumEntry> =
    DslEnumEntries().also(f).collection

fun values(f: Recv<DslValues>): Map<String, Any> =
    DslValues().also(f).map

fun codeSource(f: Recv<DslCodeSource>): CodeSource =
    CodeSource.fromIterable(DslCodeSource().also(f).collection)

fun mutableCodeSource(f: Recv<DslCodeSource>): MutableCodeSource =
    MutableCodeSource.create(DslCodeSource().also(f).collection)

fun instructions(f: Recv<DslInstructions>): List<CodeInstruction> =
    DslInstructions().also(f).collection

fun concatenations(f: Recv<DslInstructions>): List<CodeInstruction> =
    DslInstructions().also(f).collection

fun requires(f: Recv<DslRequires>): List<Require> =
    DslRequires().also(f).collection

fun exports(f: Recv<DslExports>): List<Export> =
    DslExports().also(f).collection

fun opens(f: Recv<DslOpens>): List<Open> =
    DslOpens().also(f).collection

fun moduleReferences(f: Recv<DslModuleReferences>): List<ModuleReference> =
    DslModuleReferences().also(f).collection

fun provides(f: Recv<DslProvides>): List<Provide> =
    DslProvides().also(f).collection

fun cases(f: Recv<DslCases>): List<Case> =
    DslCases().also(f).collection

