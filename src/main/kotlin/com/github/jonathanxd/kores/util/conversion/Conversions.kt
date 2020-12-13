/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.util.conversion

import com.github.jonathanxd.kores.Defaults
import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.MutableInstructions
import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.base.*
import com.github.jonathanxd.kores.base.Annotation
import com.github.jonathanxd.kores.base.comment.Comments
import com.github.jonathanxd.kores.common.MethodInvokeSpec
import com.github.jonathanxd.kores.common.MethodTypeSpec
import com.github.jonathanxd.kores.factory.*
import com.github.jonathanxd.kores.literal.Literal
import com.github.jonathanxd.kores.literal.Literals
import com.github.jonathanxd.kores.type.*
import com.github.jonathanxd.kores.util.genericSignature
import com.github.jonathanxd.kores.util.isKotlin
import java.lang.reflect.*
import java.util.*
import javax.lang.model.element.ElementKind
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.lang.model.util.Elements
import kotlin.reflect.KParameter
import kotlin.reflect.full.valueParameters
import kotlin.reflect.jvm.jvmErasure
import kotlin.reflect.jvm.kotlinFunction


/**
 * Convert parameter list to a list of access to these parameters.
 */
val List<KoresParameter>.access: List<Instruction>
    get() = this.map { it.access }

/**
 * Convert Java parameter list to Kores parameter list.
 */
val List<Parameter>.koresParameters: List<KoresParameter>
    get() = this.map { it.koresParameter }

/**
 * Convert parameter to access to the parameter.
 */
val Parameter.koresParameter: KoresParameter
    get() = KoresParameter(
            emptyList(),
            KoresModifier.fromJavaModifiers(this.modifiers),
            this.type.koresType,
            this.name
    )

/**
 * Convert [KoresParameter] to variable access
 */
val KoresParameter.access: Instruction
    get() = accessVariable(this.type, this.name)

/**
 * Gets the invocation type of the [Method].
 */
val Executable.invokeType: InvokeType
    get() = if (Modifier.isStatic(this.modifiers))
        InvokeType.INVOKE_STATIC
    else if (this.declaringClass.isInterface)
        InvokeType.INVOKE_INTERFACE
    else if (this is Constructor<*> || this.name == "<init>")
        InvokeType.INVOKE_SPECIAL
    else
        InvokeType.INVOKE_VIRTUAL

/**
 * Gets the [TypeSpec] of the [Executable].
 */
val Executable.typeSpec: TypeSpec
    get() = TypeSpec((this as? Method)?.returnType ?: Types.VOID, this.parameterTypes.toList())

/**
 * Gets the [MethodTypeSpec] of the [Executable].
 */
val Executable.methodTypeSpec: MethodTypeSpec
    get() = MethodTypeSpec(this.declaringClass, this.name, this.typeSpec)

/**
 * Gets the [MethodInvokeSpec] of the [Method].
 */
val Executable.methodInvokeSpec: MethodInvokeSpec
    get() = MethodInvokeSpec(this.invokeType, this.methodTypeSpec)

/**
 * Gets the invocation type of the [ExecutableElement].
 */
val ExecutableElement.invokeType: InvokeType
    get() = if (this.modifiers.contains(javax.lang.model.element.Modifier.STATIC))
        InvokeType.INVOKE_STATIC
    else if (this.enclosingElement.kind == ElementKind.INTERFACE)
        InvokeType.INVOKE_INTERFACE
    else if (this.kind == ElementKind.CONSTRUCTOR)
        InvokeType.INVOKE_SPECIAL
    else
        InvokeType.INVOKE_VIRTUAL


/**
 * Create [MethodInvocation] from [MethodTypeSpec]
 *
 * @param invokeType Type of invocation.
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun MethodTypeSpec.toInvocation(
        invokeType: InvokeType,
        target: Instruction,
        arguments: List<Instruction>
): MethodInvocation =
        invoke(invokeType, this.localization, target, this.methodName, this.typeSpec, arguments)


/**
 * Create [MethodInvocation] from [MethodInvokeSpec]
 *
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun MethodInvokeSpec.toInvocation(
        target: Instruction,
        arguments: List<Instruction>
): MethodInvocation =
        invoke(
                this.invokeType,
                this.methodTypeSpec.localization,
                target,
                this.methodTypeSpec.methodName,
                this.methodTypeSpec.typeSpec,
                arguments
        )

/**
 * Create [MethodInvocation] from [Executable]
 *
 * @param invokeType Type of invocation, if null, Kores will try to infer the invocation type.
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun Executable.toInvocation(
        invokeType: InvokeType?,
        target: Instruction,
        arguments: List<Instruction>
): MethodInvocation =
        com.github.jonathanxd.kores.factory.invoke(
                invokeType ?: this.invokeType,
                this.declaringClass.koresType,
                target,
                this.name,
                this.typeSpec,
                arguments
        )

/**
 * Gets [TypeSpec] of receiver [ExecutableElement]
 */
fun ExecutableElement.getTypeSpec(elements: Elements): TypeSpec =
        TypeSpec(returnType = this.returnType.getKoresType(elements),
                parameterTypes = this.parameters.map { it.asType().getKoresType(elements) })

/**
 * Gets [MethodTypeSpec] of receiver [ExecutableElement]
 */
fun ExecutableElement.getMethodTypeSpec(elements: Elements): MethodTypeSpec =
        MethodTypeSpec(
                localization = (this.enclosingElement as TypeElement).getKoresType(elements),
                typeSpec = this.getTypeSpec(elements),
                methodName = this.simpleName.toString()
        )

/**
 * Gets [MethodInvokeSpec] of receiver [ExecutableElement]
 */
fun ExecutableElement.getMethodInvokeSpec(elements: Elements): MethodInvokeSpec =
        MethodInvokeSpec(
                invokeType = this.invokeType,
                methodTypeSpec = this.getMethodTypeSpec(elements)
        )

/**
 * Create [ExecutableElement] from [Method]
 *
 * @param invokeType Type of invocation, if null, Kores will try to infer the invocation type.
 * @param target Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC]).
 * @param arguments Arguments to pass to method.
 */
fun ExecutableElement.toInvocation(
        invokeType: InvokeType?,
        target: Instruction,
        arguments: List<Instruction>,
        elements: Elements
): MethodInvocation =
        MethodInvocation(
                invokeType = invokeType ?: this.invokeType,
                target = target,
                spec = this.getMethodTypeSpec(elements),
                arguments = arguments
        )


/**
 * Create [FieldAccess] from [Field].
 *
 * @param target Target of the field access, null (or static access) for static access.
 */
fun Field.toAccess(target: Instruction?): FieldAccess =
        FieldAccess.Builder.builder()
                .localization(this.declaringClass.koresType)
                .target(target ?: accessStatic())
                .name(this.name)
                .build()

/**
 * Create [FieldAccess] from [VariableElement].
 *
 * @param target Target of the field access, null (or static access) for static access.
 */
fun VariableElement.toAccess(target: Instruction?, elements: Elements): FieldAccess =
        FieldAccess.Builder.builder()
                .localization((this.enclosingElement as TypeElement).getKoresType(elements))
                .target(target ?: accessStatic())
                .type(this.asType().getKoresType(elements))
                .name(this.simpleName.toString())
                .build()


/**
 * Creates an [ClassDeclaration] from receiver [Class].
 */
@Suppress("UNCHECKED_CAST")
fun <T : Any> Class<T>.toClassDeclaration(): ClassDeclaration =
        ClassDeclaration.Builder.builder()
                .modifiers(KoresModifier.fromJavaModifiers(this.modifiers))
                .qualifiedName(this.canonicalName)
                .superClass(this.superclass)
                .implementations(this.interfaces.toList())
                .build()

/**
 * Creates an [InterfaceDeclaration] from receiver [Class].
 */
fun <T : Any> Class<T>.toInterfaceDeclaration(): InterfaceDeclaration =
        InterfaceDeclaration.Builder.builder()
                .modifiers(KoresModifier.fromJavaModifiers(this.modifiers))
                .qualifiedName(this.canonicalName)
                .implementations(this.interfaces.toList())
                .build()


/**
 * Creates an [AnnotationDeclaration] from receiver [Class].
 */
fun <T : Any> Class<T>.toAnnotationDeclaration(): AnnotationDeclaration =
        AnnotationDeclaration.Builder.builder()
                .modifiers(KoresModifier.fromJavaModifiers(this.modifiers))
                .qualifiedName(this.canonicalName)
                .properties(this.declaredMethods.map {
                    AnnotationProperty(
                            Comments.Absent,
                            emptyList(),
                            it.returnType.koresType,
                            it.name,
                            it.defaultValue
                    )
                })
                .build()


/**
 * Creates enum declaration from receiver [Class] using parameter name provider: [nameProvider].
 */
@JvmOverloads
fun <T : Any> Class<T>.toEnumDeclaration(nameProvider: (method: Method, index: Int, parameter: Parameter) -> String = { m, i, _ -> m.parameterNames[i] }): EnumDeclaration {

    val abstractMethods = this.methods.filter { Modifier.isAbstract(it.modifiers) }

    val enumEntries = this.declaredFields
            .filter { it.isEnumConstant }
            .map {
                EnumEntry.Builder.builder().name(it.name).let {
                    if (abstractMethods.isNotEmpty())
                        it.methods(abstractMethods.map {
                            it.toMethodDeclaration { index, parameter ->
                                nameProvider(
                                        it,
                                        index,
                                        parameter
                                )
                            }
                        })
                    else it
                }.build()

            }

    return EnumDeclaration.Builder.builder()
            .modifiers(KoresModifier.fromJavaModifiers(this.modifiers))
            .qualifiedName(this.canonicalName)
            .implementations(this.interfaces.map { it.koresType })
            .entries(enumEntries)
            .build()
}

/**
 * Creates a [EnumDeclaration] from receiver [Enum] class.
 */
fun <T : Enum<T>> Class<T>.toDeclaration() =
        this.toEnumDeclaration()

/**
 * Creates a [AnnotationDeclaration] from receiver [Annotation] class.
 */
fun Class<Annotation>.toDeclaration() =
        this.toAnnotationDeclaration()

/**
 * Creates a [ClassDeclaration] from receiver [Class] class.
 */
fun <T : Any> Class<T>.toDeclaration() =
        when {
            this.isInterface -> this.toInterfaceDeclaration()
            this.isEnum -> this.toEnumDeclaration()
            this.isAnnotation -> this.toAnnotationDeclaration()
            else -> this.toClassDeclaration()
        }


/**
 * Convert this [Class] structure to [TypeDeclaration]s (first element is the
 * input class, other elements is inner-classes).
 *
 * @param includeFields True to include fields.
 * @param includeMethods True to include methods.
 * @param includeSubClasses True to include sub classes.
 * @return [TypeDeclaration] structure from [Class].
 */
@JvmOverloads
fun <T : Any> Class<T>.toStructure(
        includeFields: Boolean = true,
        includeMethods: Boolean = true,
        includeSubClasses: Boolean = true
): List<TypeDeclaration> {
    val list = mutableListOf<TypeDeclaration>()

    val declaration: TypeDeclaration = this.toDeclaration()

    val declarationBuilder = declaration.builder()

    if (includeSubClasses) {
        for (declaredClass in this.declaredClasses) {
            val extracted = declaredClass.toStructure(
                    includeFields = includeFields,
                    includeMethods = includeMethods,
                    includeSubClasses = includeSubClasses
            )

            list += extracted.first().builder().outerType(declaration).build()

            if (extracted.size > 1)
                list += extracted.subList(1, extracted.size)
        }
    }

    if (includeFields) {
        declarationBuilder.fields(this.fields.map { it.toFieldDeclaration() })
    }

    if (includeMethods) {
        declarationBuilder.methods(this.declaredMethods.filter { isValidImpl(it) }.map { it.toMethodDeclaration() })
    }

    list.add(0, declarationBuilder.build())

    return list
}


/**
 * Makes the declaration [T] extend the [Class] overriding all public/protected methods
 * and invoking the super method.
 *
 * @param klass Class to extend
 * @return The declaration extending the [klass] and overriding all public/protected methods.
 */
@Suppress("UNCHECKED_CAST")
fun <T : TypeDeclaration> T.extend(klass: Class<*>): T {
    val builder = this.builder()
    val type = klass.koresType

    builder.methods(this.methods + klass.methods.filter {
        it.isAccessibleFrom(
                this,
                true
        ) && isValidImpl(it)
    }.map { it.toMethodDeclaration(type) })

    var declaration = builder.build()

    if (klass.isInterface) {
        val implementer = declaration as ImplementationHolder
        declaration =
                implementer.builder().implementations(implementer.implementations + type).build() as TypeDeclaration
    } else {
        val extender = declaration as SuperClassHolder
        declaration = extender.builder().superClass(type).build() as TypeDeclaration
    }

    return declaration as T
}

// Fields

/**
 * Convert this [Field] structure to [FieldDeclaration].
 *
 * @return [FieldDeclaration] structure from [Field].
 */
fun Field.toFieldDeclaration(): FieldDeclaration =
        FieldDeclaration.Builder.builder()
                .modifiers(KoresModifier.fromJavaModifiers(this.modifiers))
                .type(this.type.koresType)
                .name(this.name)
                .build()

/**
 * Create access to this [Field].
 *
 * @param target Target
 * @return [VariableAccess] to this [Field]
 */
fun Field.createAccess(target: Instruction?): FieldAccess =
        accessField(
                this.declaringClass.koresType,
                target ?: Defaults.ACCESS_STATIC,
                this.type.koresType,
                this.name
        )

/**
 * Create static access to this [Field].
 *
 * @return **Static** [VariableAccess] to this [Field].
 */
fun Field.createStaticAccess(): FieldAccess =
        this.createAccess(null)

// Method

/**
 * Convert this [Method] to [MethodDeclaration].
 *
 * @param nameProvider Provider of parameter names.
 * @return [MethodDeclaration].
 */
@JvmOverloads
fun Method.toMethodDeclaration(nameProvider: (index: Int, parameter: Parameter) -> String = { i, _ -> this.parameterNames[i] }): MethodDeclaration =
        MethodDeclaration.Builder.builder()
                .modifiers(fixModifiers(this.modifiers))
                .genericSignature(this.genericSignature)
                .throwsClause(this.throwExceptionTypesToKores())
                .name(this.name)
                .returnType(this.returnTypeToKores())
                .parameters(this.parameterTypesToKores(nameProvider))
                .body(MutableInstructions.create())
                .build()

/**
 * Convert this [Method] structure to [MethodDeclaration] structure invoking the super class method.
 *
 * @param superClass super class to invoke
 * @param nameProvider Provider of parameter names.
 * @return [MethodDeclaration] structure from [Method] invoking super class method.
 */
@JvmOverloads
fun Method.toMethodDeclaration(
        superClass: Type,
        nameProvider: (index: Int, parameter: Parameter) -> String = { i, _ -> this.parameterNames[i] }
): MethodDeclaration =
        this.toMethodDeclaration(nameProvider).builder().body(
                MutableInstructions.create(
                        listOf(returnValue(this.returnType,
                                com.github.jonathanxd.kores.factory.invoke(
                                        InvokeType.INVOKE_SPECIAL,
                                        superClass,
                                        Defaults.ACCESS_THIS,
                                        this.name,
                                        typeSpec(this.returnType, this.parameterTypes.toList()),
                                        this.koresParameters.map { it.toVariableAccess() }
                                )))
                )
        ).build()


// Constructor

/**
 * Convert this [Method] to [MethodDeclaration].
 *
 * @param nameProvider Provider of parameter names.
 * @return [MethodDeclaration].
 */
@JvmOverloads
fun <T : Any> Constructor<T>.toConstructorDeclaration(nameProvider: (index: Int, parameter: Parameter) -> String = { i, _ -> this.parameterNames[i] }): ConstructorDeclaration =
        ConstructorDeclaration.Builder.builder()
                .modifiers(fixModifiers(this.modifiers))
                .parameters(this.parameterTypesToKores(nameProvider))
                .throwsClause(this.throwExceptionTypesToKores())
                .body(MutableInstructions.create())
                .build()

/**
 * Convert this [Constructor] structure to [ConstructorDeclaration] structure calling super constructor with [arguments].
 *
 * @param arguments Arguments to pass to super constructor.
 * @param nameProvider Provider of parameter names.
 * @return [ConstructorDeclaration] structure from [Constructor] calling super constructor with [arguments].
 */
@JvmOverloads
fun <T : Any> Constructor<T>.toConstructorDeclaration(
        arguments: List<Instruction>,
        nameProvider: (index: Int, parameter: Parameter) -> String = { i, _ -> this.parameterNames[i] }
): ConstructorDeclaration =
        this.toConstructorDeclaration(nameProvider).builder().body(
                MutableInstructions.create(
                        listOf(
                                invokeSuperConstructor(
                                        this.typeSpec,
                                        arguments
                                )
                        )
                )
        ).build()


// Parameters And Arguments
fun KParameter.toKoresParameter(): KoresParameter =
        parameter(type = this.type.jvmErasure.koresType, name = this.name ?: "parameter_$index")

fun Parameter.toKoresParameter(): KoresParameter =
        parameter(type = this.type.koresType, name = this.name)

fun KParameter.toVariableAccess() =
        accessVariable(this.type.jvmErasure.koresType, this.name ?: "parameter_$index")

fun Parameter.toVariableAccess() = accessVariable(this.type.koresType, this.name)

fun KoresParameter.toVariableAccess() = accessVariable(this.type, this.name)

// Any

/**
 * Convert this value to a literal
 */
fun Any.toLiteral(): Literal =
        this.toLiteralOrNull()
                ?: throw IllegalArgumentException("$this cannot be converted to Kores Literal.")

val Any.literal get() = this.toLiteral()
val Any.literalOrNull get() = this.toLiteralOrNull()

operator fun Any.not() = this.literal

/**
 * Convert this value to a literal
 */
fun Any.toLiteralOrNull(): Literal? = when (this) {
    is Byte -> Literals.BYTE(this)
    is Short -> Literals.SHORT(this)
    is Int -> Literals.INT(this)
    is Boolean -> Literals.BOOLEAN(this)
    is Long -> Literals.LONG(this)
    is Float -> Literals.FLOAT(this)
    is Double -> Literals.DOUBLE(this)
    is Char -> Literals.CHAR(this)
    is String -> Literals.STRING(this)
    is Type -> Literals.TYPE(this)
    else -> null
}

/**
 * Returns true if receiver [Method] is accessible from [typeDeclaration] or accessible to be [overwritten][override]
 * from [typeDeclaration].
 *
 * @param override True to check if method is accessible to be overwritten by [typeDeclaration] method.
 */
@JvmOverloads
fun Method.isAccessibleFrom(typeDeclaration: TypeDeclaration, override: Boolean = false): Boolean {
    val package_ = typeDeclaration.packageName
    val methodPackage = this.declaringClass.`package`?.name
    val modifiers = this.modifiers

    return if (Modifier.isPublic(modifiers)
            || (override && Modifier.isProtected(modifiers))
    )
        true
    else methodPackage != null && package_ == methodPackage
}

fun fixModifiers(modifiers: Int): EnumSet<KoresModifier> =
        EnumSet.copyOf(KoresModifier.fromJavaModifiers(modifiers).let {
            it.remove(KoresModifier.ABSTRACT)
            return@let it
        })

/**
 * Returns if [method] is valid for implementation.
 */
fun isValidImpl(method: Method) = !method.isBridge
        && !method.isSynthetic
        && !Modifier.isNative(method.modifiers)
        && !Modifier.isFinal(method.modifiers)

/**
 * Checks if all elements of receiver [Iterable] is equal to elements of [other].
 */
fun <T : Any> Iterable<T>.isEqual(other: Iterable<*>): Boolean {

    val thisIterator = this.iterator()
    val otherIterator = other.iterator()

    while (thisIterator.hasNext() && otherIterator.hasNext()) {
        if (thisIterator.next() != otherIterator.next())
            return false

    }

    return !thisIterator.hasNext() && !otherIterator.hasNext()
}

/**
 * Gets parameter names of receiver [Method].
 */
val Method.parameterNames: List<String>
    get() =
        if (this.parameters.any { it.isNamePresent } || !this.declaringClass.isKotlin)
            this.parameters.map { it.name }
        else
            this.kotlinParameters?.mapIndexed { i, it -> it.name ?: this.parameters[i].name }?.let {
                if (it.size != this.parameterCount) null
                else it
            } ?: this.parameters.map { it.name }

/**
 * Gets kotlin parameters from receiver [Method].
 */
val Method.kotlinParameters: List<KParameter>?
    get() = try {
        this.kotlinFunction?.valueParameters
    } catch (ex: Throwable) {
        null
    }

/**
 * Gets code parameters of receiver [Method].
 */
val Method.koresParameters: List<KoresParameter>
    get() =
        if (this.parameters.any { it.isNamePresent } || !this.declaringClass.isKotlin)
            this.parameters.map { it.toKoresParameter() }
        else
            this.kotlinParameters?.map { it.toKoresParameter() }?.let {
                if (it.size != this.parameterCount) null
                else it
            } ?: this.parameters.map { it.toKoresParameter() }

/**
 * Gets parameter names of receiver [Constructor].
 */
val <T : Any> Constructor<T>.parameterNames: List<String>
    get() =
        if (this.parameters.any { it.isNamePresent } || !this.declaringClass.isKotlin)
            this.parameters.map { it.name }
        else
            this.kotlinParameters?.mapIndexed { i, it -> it.name ?: this.parameters[i].name }?.let {
                if (it.size != this.parameterCount) null
                else it
            } ?: this.parameters.map { it.name }

/**
 * Gets kotlin parameter of receiver [Constructor].
 */
val <T : Any> Constructor<T>.kotlinParameters: List<KParameter>?
    get() = try {
        this.kotlinFunction?.valueParameters
    } catch (ex: Throwable) {
        null
    }

/**
 * Gets code parameters of receiver [Method].
 */
val <T : Any> Constructor<T>.koresParameters: List<KoresParameter>
    get() =
        if (this.parameters.any { it.isNamePresent } || !this.declaringClass.isKotlin)
            this.parameters.map { it.toKoresParameter() }
        else
            this.kotlinParameters?.map { it.toKoresParameter() }?.let {
                if (it.size != this.parameterCount) null
                else it
            } ?: this.parameters.map { it.toKoresParameter() }


/**
 * Creates [Instruction] from [receiver type representation][Type].
 */
fun Type.toInstruction(): Instruction =
        this.koresType.let {
            when (it) {
                is GenericType -> it.toInstruction()
                else -> Literals.CLASS(it)
            }
        }

/**
 * Creates [Instruction] from [receiver generic type representation][GenericType].
 */
fun GenericType.toInstruction(): Instruction =
        when {
            this.isWildcard -> typeOf<Generic>().invokeStatic(
                    "wildcard",
                    typeSpec(typeOf<Generic>()),
                    emptyList()
            )
            this.isType -> typeOf<Generic>().invokeStatic(
                    "type",
                    typeSpec(typeOf<Generic>(), typeOf<Type>()),
                    listOf(this.resolvedType.toInstruction())
            )
            else -> typeOf<Generic>().invokeStatic(
                    "type",
                    typeSpec(typeOf<Generic>(), Types.STRING),
                    listOf(Literals.STRING(this.name))
            )
        }.let {
            if (this.bounds.isEmpty()) it
            else {
                val args = this.bounds.toInstructions()

                val arrType = GenericType.Bound::class.java.koresType.toArray(1)

                invokeVirtual(
                        Generic::class.java,
                        it,
                        "of",
                        TypeSpec(Generic::class.java, listOf(arrType)),
                        listOf(createArray(arrType, listOf(Literals.INT(args.size)), args))
                )
            }
        }

/**
 * Creates [Instructions][Instruction] from [bound representation array][GenericType.Bound].
 */
fun Array<GenericType.Bound>.toInstructions(): List<Instruction> =
        this.map { it.toInstruction() }

/**
 * Creates [Instruction] from [bound representation][GenericType.Bound].
 */
fun GenericType.Bound.toInstruction(): Instruction =
        this::class.java.invokeConstructor(
                constructorTypeSpec(typeOf<KoresType>()),
                listOf(this.type.toInstruction())
        )

// Generic type conversions

/**
 * Method return type to kores (transform generic types into [Kores Generic Type][GenericType])
 */
fun Method.returnTypeToKores(): Type =
        this.genericReturnType?.koresType ?: this.returnType.koresType


/**
 * Method parameter types to kores (transform generic types into [Kores Generic Type][GenericType])
 */
fun Method.parameterTypesToKores(nameProvider: (index: Int, parameter: Parameter) -> String = { i, _ -> this.parameterNames[i] }): List<KoresParameter> =
        this.parameters.mapIndexed { index, parameter ->
            val type =
                    if (index < this.genericParameterTypes.size)
                        this.genericParameterTypes[index].koresType
                    else parameter.type.koresType

            parameter(
                    annotations = parameter.koresAnnotations,
                    modifiers = KoresModifier.fromJavaModifiers(parameter.modifiers),
                    name = nameProvider(index, parameter),
                    type = type
            )
        }

/**
 * Method exception types to Kores (transform generic types into [Kores Generic Type][GenericType])
 */
fun Method.throwExceptionTypesToKores(): List<Type> =
        this.genericExceptionTypes?.map { it.koresType }
                ?: this.exceptionTypes?.map { it.koresType }.orEmpty()


/**
 * Constructor parameter types to Kores (transform generic types into [Kores Generic Type][GenericType])
 */
fun <T: Any> Constructor<T>.parameterTypesToKores(nameProvider: (index: Int, parameter: Parameter) -> String = { i, _ -> this.parameterNames[i] }): List<KoresParameter> =
        this.parameters.mapIndexed { index, parameter ->
            val type =
                    if (index < this.genericParameterTypes.size)
                        this.genericParameterTypes[index].koresType
                    else parameter.type.koresType

            parameter(
                    annotations = parameter.koresAnnotations,
                    modifiers = KoresModifier.fromJavaModifiers(parameter.modifiers),
                    name = nameProvider(index, parameter),
                    type = type
            )
        }

/**
 * Constructor exception type to Kores (transform generic types into [Kores Generic Type][GenericType])
 */
fun <T: Any> Constructor<T>.throwExceptionTypesToKores(): List<Type> =
        this.genericExceptionTypes?.map { it.koresType }
                ?: this.exceptionTypes?.map { it.koresType }.orEmpty()

