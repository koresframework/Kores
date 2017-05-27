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
@file:JvmName("GenericTypeUtil")
package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.base.*
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.type.Generic
import com.github.jonathanxd.codeapi.type.GenericType
import com.github.jonathanxd.codeapi.type.PlainCodeType
import com.github.jonathanxd.iutils.condition.Conditions
import com.github.jonathanxd.iutils.type.TypeUtil
import java.lang.reflect.Type
import java.util.*
import java.util.regex.Pattern

/**
 * Create a type descriptor from [typeDeclaration] signature.
 */
fun genericTypesToDescriptor(typeDeclaration: TypeDeclaration, superClass: CodeType, implementations: Collection<CodeType>, superClassIsGeneric: Boolean, anyInterfaceIsGeneric: Boolean): String? {
    val types = typeDeclaration.genericSignature.types

    var genericRepresentation: String? = null

    if (types.isNotEmpty()) {
        genericRepresentation = genericTypesToDescriptor(types)
    }

    if (types.isNotEmpty() || superClassIsGeneric || anyInterfaceIsGeneric) {

        if (genericRepresentation == null)
            genericRepresentation = ""

        genericRepresentation += toDescriptor(superClass)
    }

    if (types.isNotEmpty() || anyInterfaceIsGeneric) {
        val sb = StringBuilder()

        implementations.forEach { codeType -> sb.append(toDescriptor(codeType)) }

        genericRepresentation += sb.toString()
    }

    return genericRepresentation
}

/**
 * Create a type descriptor from [signature]
 */
fun genericSignatureToDescriptor(signature: GenericSignature): String {
    val types = signature.types

    if (types.size == 1 && types[0].isType)
        return genericTypeToDescriptor(types[0])
    else
        return genericTypesToDescriptor(types)
}

/**
 * Create a type descriptor from [generics]
 */
fun genericTypesToDescriptor(generics: Array<out GenericType>): String {
    val sj = StringJoiner(";")

    for (generic in generics) {
        sj.add(genericTypeDescriptor_plain(generic))
    }

    return "<" + fixResult(sj.toString()) + ">"
}

/**
 * Create a type descriptor from [generic]
 */
fun genericTypeToDescriptor(generic: GenericType): String {
    return "<" + fixResult(genericTypeDescriptor_plain(generic)) + ">"

}

/**
 * Fixes some descriptor inconsistencies present in [str] (why this exists... I bet that I've wrote a bad algorithm :D)
 */
fun fixResult(str: String): String {
    val sb = StringBuilder()

    val chars = str.toCharArray()

    var ign = false

    for (aChar in chars) {
        if (aChar == ';') {
            if (!ign) {
                sb.append(aChar)
            }

            ign = true
        } else {
            sb.append(aChar)
            ign = false
        }
    }

    return sb.toString()
}

/**
 * Create a type descriptor from [generic]
 */
private fun genericTypeDescriptor_plain(generic: GenericType): String {
    val name = generic.name

    var gen2 = false
    if (generic.bounds.isNotEmpty()) {
        val codeTypeBound = generic.bounds[0]

        val type = codeTypeBound.type

        if (type is GenericType) {
            gen2 = type.bounds.isNotEmpty()
        }
    }

    return name + (if (!generic.isType) ":" else "") + (if (gen2) ":" else "") + boundToDescriptorPlain(generic.isWildcard, generic.bounds)

}

/**
 * Creates bound descriptor
 */
fun bounds(isWildcard: Boolean, bounds: Array<GenericType.Bound>): String {

    val sb = StringBuilder()

    for (bound in bounds) {

        val boundType = bound.type

        if (boundType is GenericType && !boundType.isType) {
            sb.append(if (isWildcard) bound.sign else "").append(toDescriptor(boundType))
        } else {
            sb.append(if (isWildcard) bound.sign else "").append(toDescriptor(boundType))
        }

    }

    return sb.toString()
}

/**
 * Creates bound descriptor
 */
private fun boundToDescriptorPlain(isWildcard: Boolean, bounds: Array<GenericType.Bound>): String {

    val sb = StringBuilder()

    for (i in bounds.indices) {

        val isLast = i + 1 >= bounds.size

        val bound = bounds[i]

        val boundType = bound.type

        if (boundType is GenericType && !boundType.isType) {
            sb.append(if (isWildcard) bound.sign else "").append(toDescriptor(boundType)).append(if (!isLast) ":" else "")
        } else {
            sb.append(if (isWildcard) bound.sign else "").append(toDescriptor(boundType)).append(if (!isLast) ":" else "")
        }
    }

    return sb.toString()
}

/**
 * Creates [CodeType] type descriptor
 */
fun createCodeTypeDescriptor(codeType: CodeType): String {
    if (codeType is GenericType) {
        return genericTypeToDescriptor(codeType)
    } else {
        return codeType.javaSpecName
    }
}

/**
 * Creates method descriptor from [methodDeclaration]
 */
fun methodGenericSignature(methodDeclaration: MethodDeclaration): String? {
    return methodGenericSignature(methodDeclaration as MethodDeclarationBase)
}

/**
 * Creates method descriptor from [constructorDeclaration]
 */
fun methodGenericSignature(constructorDeclaration: ConstructorDeclaration): String? {
    return methodGenericSignature(constructorDeclaration as MethodDeclarationBase)
}

/**
 * Creates method descriptor from [methodDeclaration]
 */
internal fun methodGenericSignature(methodDeclaration: MethodDeclarationBase): String? {

    val returnType = methodDeclaration.returnType

    val signatureBuilder = StringBuilder()

    val methodSignature = methodDeclaration.genericSignature


    val generateGenerics = methodSignature.isNotEmpty
            || methodDeclaration.parameters.stream().anyMatch { parameter -> parameter.type is GenericType }
            || returnType is GenericType


    if (generateGenerics && methodSignature.isNotEmpty) {
        signatureBuilder.append(genericTypesToDescriptor(methodSignature.types))
    }

    if (generateGenerics) {
        signatureBuilder.append('(')

        methodDeclaration.parameters.stream().map { parameter -> toDescriptor(parameter.type) }.forEach { signatureBuilder.append(it) }

        signatureBuilder.append(')')
    }

    if (generateGenerics) {
        signatureBuilder.append(toDescriptor(returnType))
    }

    return if (signatureBuilder.isNotEmpty()) signatureBuilder.toString() else null

}

/**
 * Infer bound of generic types using types specified in [signature holder][holder]
 * and in [type declaration][owner] and returns the string representing the description.
 */
fun parametersAndReturnToInferredDesc(owner: Lazy<TypeDeclaration>,
                                      holder: GenericSignatureHolder,
                                      codeParameters: Collection<CodeParameter>,
                                      returnType: Type): String {

    val infer = inferParametersAndReturn(owner, holder, codeParameters, returnType)

    return parametersTypeAndReturnToDesc(infer.parameterTypes, infer.returnType)
}

/**
 * Infer bound of generic types using types specified in [signature holder][holder]
 * and in [type declaration][owner] and returns inferred types.
 *
 * This class uses lazy owner because depending on method signature, the [TypeDeclaration] is not required.
 */
fun inferParametersAndReturn(owner: Lazy<TypeDeclaration>,
                                      holder: GenericSignatureHolder,
                                      codeParameters: Collection<CodeParameter>,
                                      returnType: Type): TypeSpec {

    val genericSign by lazy {
        owner.value.genericSignature
    }
    val methodGenericSign = holder.genericSignature
    val parameterTypes = codeParameters.map { it.type }

    fun infer(codeType: java.lang.reflect.Type): CodeType =
            if (codeType is GenericType && !codeType.isType) {
                find(methodGenericSign, codeType.name) ?: find(genericSign, codeType.name) ?: codeType.codeType
            } else {
                codeType.codeType
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
 *
 * @param genericSignature Generic signature.
 * @return Generic signature string.
 */
fun toSourceString(genericSignature: GenericSignature): String {
    val sb = StringBuilder()

    val types = genericSignature.types

    for (i in types.indices) {
        val hasNext = i + 1 < types.size

        val genericType = types[i]

        sb.append(toSourceString(genericType))

        if (hasNext)
            sb.append(",")
    }

    return sb.toString()
}

/**
 * Convert generic type to string.
 *
 * @param genericType Generic type.
 * @return Generic type string.
 */
fun toSourceString(genericType: GenericType): String {

    val sb = StringBuilder()

    if (genericType.isType) {
        sb.append(genericType.canonicalName)
    } else {
        if (!genericType.isWildcard) {
            sb.append(genericType.name)
        } else {
            sb.append("?")
        }
    }


    val bounds = genericType.bounds

    if (bounds.size != 0) {

        for (i in bounds.indices) {

            val hasNext = i + 1 < bounds.size

            val bound = bounds[i]

            val extendsOrSuper = bound.sign == "+" || bound.sign == "-"

            if (bound.sign == "+") {
                sb.append(" extends ")
            } else if (bound.sign == "-") {
                sb.append(" super ")
            } else {
                if (i == 0) {
                    sb.append("<")
                }
            }

            val type = bound.type

            if (type is GenericType) {
                sb.append(toSourceString(type))
            } else {
                sb.append(type.canonicalName)
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

/**
 * Parse [generic source string][String] and construct [GenericType].

 * @param sourceString Source string.
 * *
 * @return Construct a [GenericType] from `generic source string`;
 */
fun fromSourceString(sourceString: String): GenericType {
    return fromSourceString(sourceString, { s ->
        try {
            TypeUtil.resolveClass<Any>(s).codeType
        } catch (e: Exception) {
            PlainCodeType(s, false)
        }
    })
}

/**
 * Parse [generic source string][String] and construct [GenericType].
 *
 * @param sourceString Source string.
 * @param typeResolver Resolves [CodeType] from [string type][String].
 * @return Construct a [GenericType] from `generic source string`;
 */
fun fromSourceString(sourceString: String, typeResolver: (String) -> CodeType): GenericType {
    return fromSourceString(sourceString, CodeTypeResolver.fromKtFunction(typeResolver))
}

/**
 * Parse [generic source string][String] and construct [GenericType].
 *
 * @param sourceString Source string.
 * @param typeResolver Resolves [CodeType] from [string type][String].
 * @return Construct a [GenericType] from `generic source string`;
 */
fun fromSourceString(sourceString: String, typeResolver: CodeTypeResolver): GenericType {
    if (sourceString.contains("<")) {
        Conditions.require(sourceString.endsWith(">"), "The input generic string: '$sourceString' MUST end with '>'.")

        val type = extractType(sourceString)
        val generic = extractGeneric(sourceString)

        val apply = typeResolver.invoke(type)

        val genericType = Generic.type(apply)

        return fromSourceString(genericType, generic, typeResolver)
    }

    return Generic.type(typeResolver.invoke(sourceString))
}

private fun fromSourceString(generic: Generic, sourceString: String, typeResolver: CodeTypeResolver): Generic {
    var generic = generic

    val types: Array<String>

    if (sourceString.containsBefore(",", "<"))
        types = sourceString.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    else
        types = arrayOf(sourceString)

    for (type_ in types) {
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

            val codeType = if (genericStr == null) typeResolver.invoke(type_) else fromSourceString("$type_<$genericStr>", typeResolver)

            if (isExtends) {
                generic = generic.of(base.`extends$`(codeType))
            } else
            /* if(isSuper) */ {
                generic = generic.of(base.`super$`(codeType))
            }

        } else {

            if (type_ == "?") {
                generic = generic.of(Generic.wildcard())
            } else {
                val codeType = if (genericStr == null) typeResolver.invoke(type_) else fromSourceString("$type_<$genericStr>", typeResolver)

                generic = generic.of(codeType)
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
