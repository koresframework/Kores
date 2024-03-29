/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
@file:JvmName("GenericTypeUtil")

package com.koresframework.kores.util

import com.koresframework.kores.base.*
import com.koresframework.kores.generic.GenericSignature
import com.koresframework.kores.type.*
import com.github.jonathanxd.iutils.condition.Conditions
import com.github.jonathanxd.iutils.type.TypeUtil
import com.koresframework.genericparser.*
import com.koresframework.genericparser.parser.VisitorGenericRepresentationParser
import kotlinx.coroutines.runBlocking
import java.lang.reflect.Type
import java.util.*
import java.util.regex.Pattern

/**
 * Create a type descriptor from [typeDeclaration] signature.
 */
fun genericTypesToDescriptor(
    typeDeclaration: TypeDeclaration,
    superClass: Type,
    implementations: Collection<Type>,
    superClassIsGeneric: Boolean,
    anyInterfaceIsGeneric: Boolean
): String? {
    val types = typeDeclaration.genericSignature.types

    var genericRepresentation: String? = null

    if (types.isNotEmpty()) {
        genericRepresentation = types.genericTypesToDescriptor()
    }

    if (types.isNotEmpty() || superClassIsGeneric || anyInterfaceIsGeneric) {

        if (genericRepresentation == null)
            genericRepresentation = ""

        genericRepresentation += superClass.simpleBoundDescriptor
    }

    if (types.isNotEmpty() || anyInterfaceIsGeneric) {
        val sb = StringBuilder()

        implementations.forEach { codeType -> sb.append(codeType.simpleBoundDescriptor) }

        genericRepresentation += sb.toString()
    }

    return genericRepresentation
}

/**
 * Create a type descriptor from receiver signature
 */
fun GenericSignature.genericSignatureToDescriptor(): String {
    val types = this.types

    if (types.size == 1 && types[0].isType)
        return types[0].genericTypeToDescriptor()
    else
        return types.genericTypesToDescriptor()
}

/**
 * Create a type descriptor from receiver array.
 */
fun Array<out GenericType>.genericTypesToDescriptor(): String {
    val sj = StringJoiner(";")

    val iter = this.iterator()
    while (iter.hasNext()) {
        val generic = iter.next()
        val descriptor = generic.genericTypeDescriptor_plain()

        if (iter.hasNext() && descriptor.endsWith(";") && descriptor.length - 1 > 0)
            sj.add(descriptor.substring(0 until descriptor.length-1))
        else
            sj.add(descriptor)
    }

    return "<$sj>"
}

/**
 * Create a type descriptor from receiver type.
 *
 * Descriptor are described as: `<GENERIC_TYPE_DESCRIPTOR>` where `GENERIC_TYPE_DESCRIPTOR` is
 * defined by [genericTypeDescriptor_plain].
 */
fun GenericType.genericTypeToDescriptor(): String =
    "<${this.genericTypeDescriptor_plain()}>"

/**
 * Create a type descriptor from generic `receiver`.
 *
 * As JVM specifies, a generic type descriptor is formatted as: `GENERIC_TYPE.NAME:(:?)BOUNDS_DESCRIPTOR`,
 * where additional `:` is generated only if the first bound of receiver [GenericType] is a [GenericType]
 * which has any bound, and `BOUNDS_DESCRIPTOR` is specified by [boundToDescriptorPlain].
 *
 */
private fun GenericType.genericTypeDescriptor_plain(): String {
    val name = this.name

    val additionalDel =
        this.isType && this.resolvedType.isInterface
                || this.bounds.isNotEmpty()
                && this.bounds.first().type.isInterface

    return name + (if (!this.isType) ":" else "") + (if (additionalDel) ":" else "") + boundToDescriptorPlain(
        this.isWildcard,
        this.bounds
    )
}

/**
 * Creates bound descriptor
 */
fun bounds(isWildcard: Boolean, bounds: Array<GenericType.Bound>): String {

    val sb = StringBuilder()

    for (bound in bounds) {

        val boundType = bound.type

        sb.append(if (isWildcard) bound.sign else "").append(boundType.descriptor)

    }

    return sb.toString()
}

/**
 * Creates bound descriptor
 */
fun boundsDiscardKnown(isWildcard: Boolean, bounds: Array<GenericType.Bound>, sig: List<GenericSignature>): String {

    val sb = StringBuilder()

    for (bound in bounds) {

        val boundType = bound.type

        sb.append(if (isWildcard) bound.sign else "").append(boundType.descriptorDiscardKnown(sig))

    }

    return sb.toString()
}

/**
 * Creates bound descriptor
 */
fun boundsDiscardForSignature(isWildcard: Boolean, bounds: Array<GenericType.Bound>): String {

    val sb = StringBuilder()

    for (bound in bounds) {

        val boundType = bound.type

        sb.append(if (isWildcard) bound.sign else "").append(boundType.descriptorForSignatures)

    }

    return sb.toString()
}



/**
 * Creates simple bound descriptor, used in super class and implementations declaration
 */
fun simpleBounds(isWildcard: Boolean, bounds: Array<GenericType.Bound>): String {

    val sb = StringBuilder()

    for (bound in bounds) {

        val boundType = bound.type

        sb.append(if (isWildcard) bound.sign else "")
                .append(
                        if (boundType is GenericType && !boundType.isType)
                            if (boundType.isWildcard) boundType.name
                            else "T${boundType.name};"
                        else boundType.descriptor
                )

    }

    return sb.toString()
}

/**
 * Creates bound descriptor.
 *
 * Generic type bound is formatted as: `(BOUND.SIGN?)(BOUND.TYPE.DESCRIPTOR)(:?)`. Where `BOUND.SIGN`
 * is only appended if the type is a wildcard and additional `:` is only generated if current
 * bound is not the last bound and `BOUND.TYPE.DESCRIPTOR` is specified by [descriptor].
 */
private fun boundToDescriptorPlain(isWildcard: Boolean, bounds: Array<GenericType.Bound>): String {

    val sb = StringBuilder()

    if (bounds.isEmpty())
        return Any::class.java.descriptor

    for (i in bounds.indices) {

        val isLast = i + 1 >= bounds.size

        val bound = bounds[i]

        val boundType = bound.type

        sb.append(if (isWildcard) bound.sign else "").append(boundType.descriptor)
            .append(if (!isLast) ":" else "")
    }

    return sb.toString()
}

/**
 * Creates [KoresType] type descriptor
 */
fun KoresType.createKoresTypeDescriptor(): String {
    return if (this is GenericType) {
        this.genericTypeToDescriptor()
    } else {
        this.javaSpecName
    }
}

fun Type.isNonReifiedType() = this.koresType.let {
    it is GenericType && (!it.isType || it.bounds.isNotEmpty())
}

/**
 * Creates method descriptor from receiver.
 *
 * The method descriptor is the result concatenation method generic [signature descriptor][genericTypeToDescriptor],
 * parameter types and return type [Type descriptor][descriptor].
 */
fun MethodDeclarationBase.methodGenericSignature(): String? {

    val returnType = this.returnType

    val signatureBuilder = StringBuilder()

    val methodSignature = this.genericSignature

    val genForThrows = this.throwsClause.any { it.isNonReifiedType() }

    val generateGenerics = methodSignature.isNotEmpty
            || this.parameters.any { it.type.isNonReifiedType() }
            || returnType.isNonReifiedType()
            || genForThrows


    if (generateGenerics && methodSignature.isNotEmpty) {
        signatureBuilder.append(methodSignature.types.genericTypesToDescriptor())
    }

    if (generateGenerics) {
        signatureBuilder.append('(')

        this.parameters.joinTo(buffer = signatureBuilder, separator = "") { it.type.descriptor }

        signatureBuilder.append(')')
    }

    if (generateGenerics) {
        signatureBuilder.append(returnType.descriptor)
    }

    if (genForThrows) {
        this.throwsClause.forEach {
            signatureBuilder.append('^').append(it.descriptor)
        }
    }

    return if (signatureBuilder.isNotEmpty()) signatureBuilder.toString() else null

}

/**
 * Creates method descriptor from receiver.
 *
 * The method descriptor is the result concatenation method generic [signature descriptor][genericTypeToDescriptor],
 * parameter types and return type [Type descriptor][descriptor].
 */
fun MethodDeclarationBase.methodClassfileGenericSignature(signatures: List<GenericSignature> = emptyList()): String? {

    val returnType = this.returnType

    val signatureBuilder = StringBuilder()

    val methodSignature = this.genericSignature
    val allSignatures = signatures + methodSignature

    val genForThrows = this.throwsClause.any { it.isNonReifiedType() }

    val generateGenerics = methodSignature.isNotEmpty
            || this.parameters.any { it.type.isNonReifiedType() }
            || returnType.isNonReifiedType()
            || genForThrows


    if (generateGenerics && methodSignature.isNotEmpty) {
        signatureBuilder.append(methodSignature.types.genericTypesToDescriptor())
    }

    if (generateGenerics) {
        signatureBuilder.append('(')

        this.parameters.joinTo(buffer = signatureBuilder, separator = "") {
            it.type.descriptorDiscardKnown(allSignatures)
        }

        signatureBuilder.append(')')
    }

    if (generateGenerics) {
        signatureBuilder.append(returnType.descriptorDiscardKnown(allSignatures))
    }

    if (genForThrows) {
        this.throwsClause.forEach {
            signatureBuilder.append('^').append(it.descriptorDiscardKnown(allSignatures))
        }
    }

    return if (signatureBuilder.isNotEmpty()) signatureBuilder.toString() else null

}

/**
 * Creates method descriptor from receiver.
 *
 * The method descriptor is the result concatenation method generic [signature descriptor][genericTypeToDescriptor],
 * parameter types and return type [Type descriptor][descriptor].
 */
fun MethodDeclarationBase.methodClassfileGenericSignature(): String? {

    val returnType = this.returnType

    val signatureBuilder = StringBuilder()

    val methodSignature = this.genericSignature

    val genForThrows = this.throwsClause.any { it.isNonReifiedType() }

    val generateGenerics = methodSignature.isNotEmpty
            || this.parameters.any { it.type.isNonReifiedType() }
            || returnType.isNonReifiedType()
            || genForThrows


    if (generateGenerics && methodSignature.isNotEmpty) {
        signatureBuilder.append(methodSignature.types.genericTypesToDescriptor())
    }

    if (generateGenerics) {
        signatureBuilder.append('(')

        this.parameters.joinTo(buffer = signatureBuilder, separator = "") {
            it.type.descriptorForSignatures
        }

        signatureBuilder.append(')')
    }

    if (generateGenerics) {
        signatureBuilder.append(returnType.descriptorForSignatures)
    }

    if (genForThrows) {
        this.throwsClause.forEach {
            signatureBuilder.append('^').append(it.descriptorForSignatures)
        }
    }

    return if (signatureBuilder.isNotEmpty()) signatureBuilder.toString() else null

}


/**
 * Infer bound of generic types using types specified in [signature holder][holder]
 * and in [type declaration][owner] and returns the string representing the description.
 */
fun parametersAndReturnToInferredDesc(
    owner: Lazy<TypeDeclaration>,
    holder: GenericSignatureHolder,
    codeParameters: Collection<KoresParameter>,
    returnType: Type
): String {

    val infer = inferParametersAndReturn(owner, holder, codeParameters, returnType)

    return parametersTypeAndReturnToDesc(infer.parameterTypes, infer.returnType)
}

/**
 * Infer bound of generic types using types specified in [signature holder][holder]
 * and in [type declaration][owner] and returns inferred types.
 *
 * This class uses lazy owner because depending on method signature, the [TypeDeclaration] is not required.
 */
fun inferParametersAndReturn(
    owner: Lazy<TypeDeclaration>,
    holder: GenericSignatureHolder,
    codeParameters: Collection<KoresParameter>,
    returnType: Type
): TypeSpec {

    val genericSign by lazy {
        owner.value.genericSignature
    }
    val methodGenericSign = holder.genericSignature
    val parameterTypes = codeParameters.map { it.type }

    fun infer(codeType: java.lang.reflect.Type): KoresType =
        if (codeType is GenericType && !codeType.isType) {
            find(methodGenericSign, codeType.name) ?: find(genericSign, codeType.name)
            ?: codeType.resolvedType
        } else {
            codeType.koresType
        }

    return TypeSpec(infer(returnType), parameterTypes.map(::infer))
}

/**
 * Searches for a type with name [typeName] in [genericSignature]
 */
fun find(genericSignature: GenericSignature, typeName: String): GenericType? =
    genericSignature.types.find { !it.isType && it.name == typeName }


private val TYPE_VAR_REGEX = Pattern.compile("(([A-Za-z0-9_?]*) (extends|super) ).*")

/**
 * Convert generic signature to string.
 */
fun GenericSignature.toSourceString(): String {
    val sb = StringBuilder()

    val types = this.types

    for (i in types.indices) {
        val hasNext = i + 1 < types.size

        val genericType = types[i]

        sb.append(genericType.toSourceString())

        if (hasNext)
            sb.append(",")
    }

    return sb.toString()
}

/**
 * Convert generic type to string.
 */
@JvmOverloads
fun GenericType.toSourceString(nameGenerator: (Type) -> String = {it.canonicalName}): String {

    val sb = StringBuilder()

    if (this.isType) {
        sb.append(this.canonicalName)
    } else {
        if (!this.isWildcard) {
            sb.append(this.name)
        } else {
            sb.append("?")
        }
    }


    val bounds = this.bounds

    if (bounds.isNotEmpty()) {

        for (i in bounds.indices) {

            val hasNext = i + 1 < bounds.size

            val bound = bounds[i]

            val extendsOrSuper = bound.sign == "+" || bound.sign == "-"

            if (bound.sign == "+") {
                if (i == 0) sb.append(" extends ")
                else sb.append(" ")
            } else if (bound.sign == "-") {
                if (i == 0) sb.append(" super ")
                else sb.append(" ")
            } else {
                if (i == 0) {
                    sb.append("<")
                }
            }

            val type = bound.type

            if (type is GenericType) {
                sb.append(type.toSourceString(nameGenerator))
            } else {
                sb.append(nameGenerator(type))
            }

            if (!extendsOrSuper && !hasNext) {
                sb.append(">")
            }

            if (hasNext && extendsOrSuper) {
                sb.append(" &")
            } else if (hasNext) {
                sb.append(", ")
            }
        }

    }

    return sb.toString()
}

fun genericContainerFactory(func: KoresTypeResolverFunc) = ContainerFactory {
    when (it) {
        is WildcardTypeOrName.Wildcard -> Generic.wildcard()
        is WildcardTypeOrName.Name -> Generic.type(it.name)
        is WildcardTypeOrName.Type -> Generic.type(func.invoke(it.type))
    }
}

fun genericAddBoundFunction() = AddBoundFunction<Generic> { root, kind, toBound ->
    when (kind) {
        BoundKind.Of -> root.of(toBound)
        BoundKind.Super -> root.`super$`(toBound)
        BoundKind.Extends -> root.`extends$`(toBound)
    }
}

/**
 * Parse [generic signature source string][String] and construct [GenericSignature].
 *
 * @param sourceString Source string.
 * @return Construct a [GenericSignature] from `generic signature source string`;
 */
fun genericSignatureFromSourceString(sourceString: String): GenericSignature {
    return genericSignatureFromSourceString(sourceString) { s ->
        try {
            TypeUtil.resolveClass<Any>(s).koresType
        } catch (e: Exception) {
            PlainKoresType(s, false)
        }
    }
}


/**
 * Parse [generic signature source string][String] and construct [GenericSignature].
 *
 * @param sourceString Source string.
 * @return Construct a [GenericSignature] from `generic signature source string`;
 */
fun genericSignatureFromSourceString(sourceString: String, classLoader: ClassLoader? = null): GenericSignature {
    return genericSignatureFromSourceString(sourceString) { s ->
        try {
            resolveClass<Any>(s, classLoader).koresType
        } catch (e: Exception) {
            PlainKoresType(s, false)
        }
    }
}

/**
 * Parse [generic signature source string][String] and construct [GenericSignature].
 *
 * @param sourceString Source string.
 * @return Construct a [GenericSignature] from `generic signature source string`;
 */
fun genericSignatureFromSourceString(sourceString: String, typeResolver: (String) -> KoresType): GenericSignature {
    return genericSignatureFromSourceString(sourceString, KoresTypeResolverFunc.fromKtFunction(typeResolver))
}

/**
 * Parse [generic signature source string][String] and construct [GenericSignature].
 *
 * @param sourceString Source string.
 * @return Construct a [GenericSignature] from `generic signature source string`;
 */
fun genericSignatureFromSourceString(sourceString: String, typeResolver: KoresTypeResolverFunc): GenericSignature {

    val parser = VisitorGenericRepresentationParser(
        genericContainerFactory(typeResolver),
        genericAddBoundFunction()
    )

    val genericTypes = runBlocking {
        parser.parse(sourceString, ParseOptions(parseMode = ParseMode.GenericSignature))
    }

    return GenericSignature.create(genericTypes)
}


// GenericType

/**
 * Parse [generic source string][String] and construct [GenericType].
 *
 * @param sourceString Source string.
 * @return Construct a [GenericType] from `generic source string`;
 */
fun genericTypeFromSourceString(sourceString: String): GenericType {
    return genericTypeFromSourceString(sourceString) { s ->
        try {
            TypeUtil.resolveClass<Any>(s).koresType
        } catch (e: Exception) {
            PlainKoresType(s, false)
        }
    }
}


/**
 * Parse [generic source string][String] and construct [GenericType].

 * @param sourceString Source string.
 * *
 * @return Construct a [GenericType] from `generic source string`;
 */
fun genericTypeFromSourceString(sourceString: String, classLoader: ClassLoader? = null): GenericType {
    return genericTypeFromSourceString(sourceString) { s ->
        try {
            resolveClass<Any>(s, classLoader).koresType
        } catch (e: Exception) {
            PlainKoresType(s, false)
        }
    }
}



/**
 * Parse [generic source string][String] and construct [GenericType].

 * @param sourceString Source string.
 * *
 * @return Construct a [GenericType] from `generic source string`;
 */
fun genericTypeFromSourceString(sourceString: String, typeResolver: (String) -> KoresType): GenericType {
    return genericTypeFromSourceString(sourceString, KoresTypeResolverFunc.fromKtFunction(typeResolver))
}

/**
 * Parse [generic source string][String] and construct [GenericType].

 * @param sourceString Source string.
 * *
 * @return Construct a [GenericType] from `generic source string`;
 */
fun genericTypeFromSourceString(sourceString: String, typeResolver: KoresTypeResolverFunc): GenericType {

    val parser = VisitorGenericRepresentationParser(
        genericContainerFactory(typeResolver),
        genericAddBoundFunction()
    )

    val genericTypes = runBlocking {
        parser.parse(sourceString, ParseOptions(parseMode = ParseMode.TypeArgument))
    }

    return genericTypes.single()
}


/**
 * Parse [generic source string][String] and construct [GenericType].

 * @param sourceString Source string.
 * *
 * @return Construct a [GenericType] from `generic source string`;
 */
@Deprecated(
    message = "This function is not reliable and is not able to parse some scenarios correctly",
    replaceWith = ReplaceWith("genericTypeFromSourceString")
)
fun fromSourceString(sourceString: String): GenericType {
    return fromSourceString(sourceString) { s ->
        try {
            TypeUtil.resolveClass<Any>(s).koresType
        } catch (e: Exception) {
            PlainKoresType(s, false)
        }
    }
}

/**
 * Parse [generic source string][String] and construct [GenericType].

 * @param sourceString Source string.
 * *
 * @return Construct a [GenericType] from `generic source string`;
 */
@Deprecated(
    message = "This function is not reliable and is not able to parse some scenarios correctly",
    replaceWith = ReplaceWith("genericTypeFromSourceString")
)
fun fromSourceString(sourceString: String, classLoader: ClassLoader? = null): GenericType {
    return fromSourceString(sourceString) { s ->
        try {
            resolveClass<Any>(s, classLoader).koresType
        } catch (e: Exception) {
            PlainKoresType(s, false)
        }
    }
}

/**
 * Parse [generic source string][String] and construct [GenericType].
 *
 * @param sourceString Source string.
 * @param typeResolver Resolves [KoresType] from [string type][String].
 * @return Construct a [GenericType] from `generic source string`;
 */
@Deprecated(
    message = "This function is not reliable and is not able to parse some scenarios correctly",
    replaceWith = ReplaceWith("genericTypeFromSourceString")
)
fun fromSourceString(sourceString: String, typeResolver: (String) -> KoresType): GenericType {
    return fromSourceString(sourceString, KoresTypeResolverFunc.fromKtFunction(typeResolver))
}

/**
 * Parse [generic source string][String] and construct [GenericType].
 *
 * @param sourceString Source string.
 * @param typeResolver Resolves [KoresType] from [string type][String].
 * @return Construct a [GenericType] from `generic source string`;
 */
@Deprecated(
    message = "This function is not reliable and is not able to parse some scenarios correctly",
    replaceWith = ReplaceWith("genericTypeFromSourceString")
)
fun fromSourceString(sourceString: String, typeResolver: KoresTypeResolverFunc): GenericType {
    if (sourceString.contains("<")
        && sourceString.containsBefore(" extends ", "<")
        && sourceString.containsBefore(" super ", "<")) {
        Conditions.require(
            sourceString.endsWith(">"),
            "The input generic string: '$sourceString' MUST end with '>'."
        )

        val type = extractType(sourceString)
        val generic = extractGeneric(sourceString)

        val apply = fromSourceString(type, typeResolver)

        val genericType = Generic.type(apply)

        return fromSourceString(genericType, generic, typeResolver)
    } else if (sourceString.contains(" extends ") || sourceString.contains(" super ")) {
        val extendsIndex = sourceString.indexOf(" extends ")
        val superIndex = sourceString.indexOf(" super ")
        val nameIndex = if (extendsIndex != -1) extendsIndex else superIndex
        val nameIndexEnds = if (extendsIndex != -1) (extendsIndex + " extends ".length)  else (superIndex + " super ".length)

        val name = sourceString.substring(0, nameIndex)

        if (!name.isPrimitiveName()) {
            val after = sourceString.substring(nameIndexEnds)

            if (after.isNotEmpty()) {
                val types = after.split(" & ")

                if (types.isNotEmpty()) {
                    val parsedTypes = Array(types.size) {
                        fromSourceString(types[it], typeResolver)
                    }

                    return if (extendsIndex != -1)
                        if (name == "?") Generic.wildcard().`extends$`(*parsedTypes)
                        else Generic.type(name).`extends$`(*parsedTypes)
                    else
                        if (name == "?") Generic.wildcard().`super$`(*parsedTypes)
                        else Generic.type(name).`super$`(*parsedTypes)
                }
            }
        }
    }

    return Generic.type(typeResolver.invoke(sourceString))
}

@Deprecated(
    message = "This function is not reliable and is not able to parse some scenarios correctly",
    replaceWith = ReplaceWith("genericTypeFromSourceString")
)
private fun fromSourceString(
    generic: Generic,
    sourceString: String,
    typeResolver: KoresTypeResolverFunc
): Generic {
    @Suppress("NAME_SHADOWING")
    var generic = generic

    val types: Array<String> = if (sourceString.containsBefore(",", "<"))
        sourceString.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    else
        arrayOf(sourceString)

    for (type_ in types) {
        @Suppress("NAME_SHADOWING")
        var type_ = type_.trim { it <= ' ' } // Remove unnecessary space.
        val containsTag = type_.contains("<")

        val genericStr = if (containsTag) extractGeneric(type_) else null
        type_ = if (containsTag) extractType(type_) else type_

        val matcher = TYPE_VAR_REGEX.matcher(type_)

        if (matcher.matches()) {
            type_ = type_.substring(matcher.group(1).length)

            val varName = matcher.group(2)
            val isWildcard = varName == "?"

            val isExtends = matcher.group(3) == "extends"

            val base = if (isWildcard) Generic.wildcard() else Generic.type(varName)

            val intersectionTypes = type_.split(" & ")

            val codeTypes =
                if (genericStr == null) if (intersectionTypes.size > 1) {
                    Array(intersectionTypes.size) {
                        fromSourceString(intersectionTypes[it], typeResolver)
                    }
                } else arrayOf(typeResolver.invoke(type_))
                else arrayOf(fromSourceString("$type_<$genericStr>", typeResolver))
            val gen = if (isExtends) base.`extends$`(*codeTypes)
            else base.`super$`(*codeTypes)
            generic = if (isExtends) {
                generic.of(gen)
            } else
            /* if(isSuper) */ {
                generic.of(gen)
            }
        } else {
            generic = if (type_ == "?") {
                generic.of(Generic.wildcard())
            } else {
                val codeType =
                    if (genericStr == null) typeResolver.invoke(type_)
                    else fromSourceString("$type_<$genericStr>", typeResolver)

                generic.of(codeType)
            }
        }

    }


    return generic

}

private fun extractType(str: String): String {
    return str.substring(0, str.indexOf("<"))
}

private fun extractGeneric(str: String): String {
    return str.substring(str.indexOf("<") + 1, str.lastIndexOf(">"))
}
