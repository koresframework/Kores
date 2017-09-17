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
package com.github.jonathanxd.codeapi.util.conversion

import com.github.jonathanxd.codeapi.MutableCodeSource
import com.github.jonathanxd.codeapi.base.*
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.factory.parameter
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.type.TypeRef
import com.github.jonathanxd.codeapi.util.*
import com.github.jonathanxd.iutils.`object`.Try
import com.github.jonathanxd.iutils.array.ArrayUtils
import com.github.jonathanxd.iutils.function.checked.supplier.CSupplier
import com.github.jonathanxd.iutils.map.ListHashMap
import java.lang.annotation.RetentionPolicy
import java.lang.reflect.*
import java.lang.reflect.Modifier
import javax.lang.model.AnnotatedConstruct
import javax.lang.model.element.*
import javax.lang.model.type.ArrayType
import javax.lang.model.type.TypeMirror
import javax.lang.model.util.Elements

val Class<*>.typeDeclaration: TypeDeclaration
    get() {

        val innerTypes = this.declaredClasses.filter {
            it.enclosingMethod == null && it.enclosingConstructor == null
        }

        val builder: TypeDeclaration.Builder<TypeDeclaration, *> = when {
            this.isInterface -> InterfaceDeclaration.Builder.builder()
                    .implementations(this.genericInterfaces.toList())

            this.isAnnotation -> AnnotationDeclaration.Builder.builder()
                    .properties(this.declaredMethods.map {
                        AnnotationProperty(Comments.Absent, it.codeAnnotations, it.returnType.codeType, it.name, it.defaultValue)
                    })

            this.isEnum -> {
                val abstractMethods = this.methods.filter { Modifier.isAbstract(it.modifiers) }

                val enumEntries = this.declaredFields
                        .filter { it.isEnumConstant }
                        .map {
                            val either = Try.Try(CSupplier { it.get(null) })

                            val value = if (either.isRight) either.right else null

                            val type: Class<*>? = if (value is Enum<*>) value::class.java else null

                            if (type != null && !type.`is`(this)) {
                                val decl = type.typeDeclaration

                                val spec: TypeSpec? = (decl as? ConstructorsHolder)?.constructors?.singleOrNull()?.let {
                                    if (it.parameters.size > 2)
                                        TypeSpec(it.returnType, it.parameters.subList(2, it.parameters.size).map { it.type })
                                    else null
                                }

                                EnumEntry.Builder.builder()
                                        .annotations(it.codeAnnotations)
                                        .name(it.name)
                                        .constructorSpec(spec)
                                        .fields(decl.fields.toList())
                                        .methods(decl.methods.toList())
                                        .innerTypes(decl.innerTypes.toList())
                                        .build()
                            } else {

                                EnumEntry.Builder.builder().annotations(it.codeAnnotations).name(it.name).let {
                                    if (abstractMethods.isNotEmpty())
                                        it.methods(abstractMethods.map {
                                            val names = it.parameterNames
                                            MethodDeclaration.Builder.builder()
                                                    .modifiers(fromJavaModifiers(it.modifiers))
                                                    .name(it.name)
                                                    .returnType(it.genericReturnType.codeType)
                                                    .throwsClause(it.genericExceptionTypes.map { it.codeType })
                                                    .parameters(it.parameters.let {
                                                        it.mapIndexed { i, parameter ->
                                                            parameter.asCodeParameter(names[i])
                                                        }
                                                    })
                                                    .body(MutableCodeSource.create())
                                                    .build()
                                        })
                                    else it
                                }.build()
                            }

                        }

                EnumDeclaration.Builder.builder()
                        .implementations(this.genericInterfaces.map { it.codeType })
                        .entries(enumEntries)
                        .constructors(this.constructorDeclarations)
            }
            else -> ClassDeclaration.Builder.builder()
                    .superClass(this.genericSuperclass)
                    .implementations(this.genericInterfaces.toList())
                    .constructors(this.constructorDeclarations)
        }

        // Commons
        return builder
                .outerClass(this.asTypeRef.outerType)
                .genericSignature(this.genericSignature)
                .annotations(this.codeAnnotations)
                .modifiers(fromJavaModifiers(this.modifiers))
                .qualifiedName(this.canonicalName)
                .fields(this.fieldDeclarations)
                .methods(this.methodDeclarations)
                .innerTypes(innerTypes.map { it.typeDeclaration })
                .build()
    }


val Class<*>.asTypeRef: TypeRef
    get() =
        if (this.enclosingClass == null)
            TypeRef(null, this.concreteType.simpleName, this.isInterface)
        else
            TypeRef(this.enclosingClass.asTypeRef, this.concreteType.simpleName, this.isInterface)

val Class<*>.fieldDeclarations: List<FieldDeclaration>
    get() = this.declaredFields.map {
        FieldDeclaration.Builder.builder()
                .annotations(it.codeAnnotations)
                .modifiers(fromJavaModifiers(it.modifiers))
                .type(it.type.codeType)
                .name(it.name)
                .build()
    }

val Class<*>.methodDeclarations: List<MethodDeclaration>
    get() {
        val classesDeclaredByMethods = ListHashMap<Method, Class<*>>()

        this.declaredClasses.forEach { cl ->
            cl.enclosingMethod?.let {
                classesDeclaredByMethods.putToList(it, cl)
            }
        }

        return this.declaredMethods.map {
            val names = it.parameterNames
            MethodDeclaration.Builder.builder()
                    .annotations(it.codeAnnotations)
                    .modifiers(fromJavaModifiers(it.modifiers))
                    .genericSignature(it.genericSignature)
                    .name(it.name)
                    .returnType(it.genericReturnType.codeType)
                    .parameters(it.parameters.mapIndexed { i, parameter ->
                        parameter.asCodeParameter(names[i])
                    })
                    .throwsClause(it.genericExceptionTypes.map { it.codeType })
                    .innerTypes(classesDeclaredByMethods[it].orEmpty().map { it.typeDeclaration })
                    .body(MutableCodeSource.create())
                    .build()
        }
    }

val Class<*>.constructorDeclarations: List<ConstructorDeclaration>
    get() {
        val classesDeclaredByConstructors = ListHashMap<Constructor<*>, Class<*>>()

        this.declaredClasses.forEach { cl ->
            cl.enclosingConstructor?.let {
                classesDeclaredByConstructors.putToList(it, cl)
            }
        }

        return this.declaredConstructors.map {
            val names = it.parameterNames
            ConstructorDeclaration.Builder.builder()
                    .annotations(it.codeAnnotations)
                    .modifiers(fromJavaModifiers(it.modifiers))
                    .genericSignature(it.genericSignature)
                    .parameters(it.parameters.mapIndexed { i, parameter ->
                        parameter.asCodeParameter(names[i])
                    })
                    .throwsClause(it.genericExceptionTypes.map { it.codeType })
                    .innerTypes(classesDeclaredByConstructors[it].orEmpty().map { it.typeDeclaration })
                    .body(MutableCodeSource.create())
                    .build()
        }
    }

fun Parameter.asCodeParameter(alternativeName: String? = null) =
        CodeParameter.Builder.builder()
                .annotations(this.annotations.codeAnnotation)
                .modifiers(fromJavaModifiers(this.modifiers))
                .type(this.parameterizedType)
                .name(alternativeName ?: this.name)
                .build()

val <T : Annotation> Array<T>.codeAnnotation: List<CodeAnnotation> get() = this.map { it.codeAnnotation }
val <T : Annotation> List<T>.codeAnnotation: List<CodeAnnotation> get() = this.map { it.codeAnnotation }
val AnnotatedElement.codeAnnotations: List<CodeAnnotation> get() = this.annotations.map { it.codeAnnotation }

val <T : Annotation> T.codeAnnotation: CodeAnnotation
    get() {
        val type = this.annotationClass.java

        val visible = type.getAnnotation(java.lang.annotation.Retention::class.java)?.value == RetentionPolicy.RUNTIME

        val map = mutableMapOf<String, Any>()

        type.declaredMethods
                .filter {
                    Modifier.isPublic(it.modifiers)
                            && it.parameterCount == 0
                }
                .map {
                    map[it.name] = it.invoke(this).annotationValue(it.returnType)
                }

        return com.github.jonathanxd.codeapi.base.Annotation.Builder.builder()
                .type(type)
                .visible(visible)
                .values(map)
                .build()
    }

fun Any.annotationValue(rType: Class<*>): Any =
        when (this) {
            is Boolean, is Byte, is Char, is Short,
            is Int, is Float, is Long, is Double, is String -> this
            is Class<*> -> this.codeType // Not required
            is Enum<*> -> EnumValue(rType, this.name)
            is Annotation -> this.codeAnnotation
            else -> {
                if (this::class.java.isArray) {
                    val arr = ArrayUtils.toObjectArray(this)

                    val array = this::class.java
                    val componentType = array.componentType

                    arr.map { it.annotationValue(componentType) }
                } else throw IllegalArgumentException("Cannot convert $this to annotation value.")
            }
        }

fun TypeElement.getTypeDeclaration(elements: Elements): TypeDeclaration {

    val innerTypes = this.enclosedElements.filterIsInstance<TypeElement>()

    val builder: TypeDeclaration.Builder<TypeDeclaration, *> = when {
        this.kind == ElementKind.INTERFACE -> InterfaceDeclaration.Builder.builder()
                .implementations(this.interfaces.map { it.getCodeType(elements) })

        this.kind == ElementKind.ANNOTATION_TYPE -> AnnotationDeclaration.Builder.builder()
                .properties(this.enclosedElements.filterIsInstance<ExecutableElement>().map {
                    val rType = it.returnType.getCodeType(elements)
                    AnnotationProperty(Comments.Absent, it.getCodeAnnotations(elements),
                            rType,
                            it.simpleName.toString(),
                            it.defaultValue.annotationValue(it, it.returnType, elements)
                    )
                })

        this.kind == ElementKind.ENUM -> {
            val abstractMethods = this.enclosedElements.filterIsInstance<ExecutableElement>().filter {
                it.modifiers.contains(javax.lang.model.element.Modifier.ABSTRACT)
            }

            val enumEntries = this.enclosedElements
                    .filter { it is VariableElement && it.kind == ElementKind.ENUM_CONSTANT }
                    .map {
                        val enclosed = it.enclosedElements

                        if (enclosed.isNotEmpty()) {

                            val fields = enclosed.filterIsInstance<VariableElement>()
                                    .filter { it.kind == ElementKind.FIELD }
                                    .map { it.getFieldDeclaration(elements) }

                            val methods = enclosed.filterIsInstance<ExecutableElement>()
                                    .filter { it.kind == ElementKind.METHOD }
                                    .map { it.getMethodDeclaration(elements) }

                            val inner = enclosed.filterIsInstance<TypeElement>()
                                    .map { it.getTypeDeclaration(elements) }


                            EnumEntry.Builder.builder()
                                    .annotations(it.getCodeAnnotations(elements))
                                    .name(it.simpleName.toString())
                                    .fields(fields)
                                    .methods(methods)
                                    .innerTypes(inner)
                                    .build()
                        } else {
                            EnumEntry.Builder.builder().annotations(it.getCodeAnnotations(elements)).name(it.simpleName.toString()).let {
                                if (abstractMethods.isNotEmpty())
                                    it.methods(abstractMethods.map {
                                        MethodDeclaration.Builder.builder()
                                                .modifiers(fromJavaxModifiers(it.modifiers))
                                                .name(it.simpleName.toString())
                                                .returnType(it.returnType.getCodeType(elements))
                                                .parameters(it.parameters.map {
                                                    parameter(type = it.asType().getCodeType(elements), name = it.simpleName.toString())
                                                })
                                                .body(MutableCodeSource.create())
                                                .build()
                                    })
                                else it
                            }.build()
                        }

                    }

            EnumDeclaration.Builder.builder()
                    .implementations(this.interfaces.map { it.getCodeType(elements) })
                    .entries(enumEntries)
                    .constructors(this.getConstructorDeclarations(elements))
        }
        else -> ClassDeclaration.Builder.builder()
                .superClass(this.superclass.getCodeType(elements))
                .implementations(this.interfaces.map { it.getCodeType(elements) })
                .constructors(this.getConstructorDeclarations(elements))
    }

    // Commons
    return builder
            .outerClass(this.asTypeRef(elements).outerType)
            .annotations(this.getCodeAnnotations(elements))
            .modifiers(fromJavaxModifiers(this.modifiers))
            .qualifiedName(this.qualifiedName.toString())
            .fields(this.getFieldDeclarations(elements))
            .methods(this.getMethodDeclarations(elements))
            .innerTypes(innerTypes.map { it.getTypeDeclaration(elements) })
            .build()
}


fun TypeElement.asTypeRef(elements: Elements): TypeRef =
        if (this.enclosingElement.kind == ElementKind.PACKAGE)
            TypeRef(null, this.getCodeType(elements).concreteType.simpleName, this.kind == ElementKind.INTERFACE)
        else {
            val enclosingType = this.getEnclosingType()
            TypeRef(enclosingType.asTypeRef(elements), this.getCodeType(elements).concreteType.simpleName,
                    this.kind == ElementKind.INTERFACE)
        }

tailrec fun Element.getEnclosingType(): TypeElement =
        when {
            this.enclosingElement is TypeElement -> this.enclosingElement as TypeElement
            this.enclosingElement.kind == ElementKind.PACKAGE -> throw IllegalArgumentException("Package found before enclosing type")
            else -> this.enclosingElement.getEnclosingType()
        }

fun VariableElement.getFieldDeclaration(elements: Elements): FieldDeclaration =
        FieldDeclaration.Builder.builder()
                .annotations(this.getCodeAnnotations(elements))
                .modifiers(fromJavaxModifiers(this.modifiers))
                .type(this.asType().getCodeType(elements))
                .name(this.simpleName.toString())
                .build()

fun TypeElement.getFieldDeclarations(elements: Elements): List<FieldDeclaration> =
        this.enclosedElements.filterIsInstance<VariableElement>()
                .filter { it.kind == ElementKind.FIELD }
                .map { it.getFieldDeclaration(elements) }

fun ExecutableElement.getMethodDeclaration(elements: Elements): MethodDeclaration =
        MethodDeclaration.Builder.builder()
                .annotations(this.getCodeAnnotations(elements))
                .modifiers(fromJavaxModifiers(this.modifiers))
                .name(this.simpleName.toString())
                .returnType(this.returnType.getCodeType(elements))
                .parameters(this.parameters.map {
                    parameter(type = it.asType().getCodeType(elements), name = it.simpleName.toString())
                })
                .throwsClause(this.thrownTypes.map { it.getCodeType(elements) })
                .innerTypes(this.enclosedElements.filterIsInstance<TypeElement>().map { it.getTypeDeclaration(elements) })
                .body(MutableCodeSource.create())
                .build()

fun TypeElement.getMethodDeclarations(elements: Elements): List<MethodDeclaration> =
        this.enclosedElements
                .filterIsInstance<ExecutableElement>()
                .filter { it.kind == ElementKind.METHOD }
                .map { it.getMethodDeclaration(elements) }


fun ExecutableElement.getConstructorDeclaration(elements: Elements): ConstructorDeclaration =
        ConstructorDeclaration.Builder.builder()
                .annotations(this.getCodeAnnotations(elements))
                .modifiers(fromJavaxModifiers(this.modifiers))
                .parameters(this.parameters.map {
                    parameter(type = it.asType().getCodeType(elements), name = it.simpleName.toString())
                })
                .throwsClause(this.thrownTypes.map { it.getCodeType(elements) })
                .innerTypes(this.enclosedElements.filterIsInstance<TypeElement>().map { it.getTypeDeclaration(elements) })
                .build()


fun TypeElement.getConstructorDeclarations(elements: Elements): List<ConstructorDeclaration> =
        this.enclosedElements
                .filterIsInstance<ExecutableElement>()
                .filter { it.kind == ElementKind.CONSTRUCTOR }
                .map { it.getConstructorDeclaration(elements) }


fun List<AnnotationMirror>.getMirrorToCodeAnnotation(elements: Elements): List<CodeAnnotation> =
        this.map { it.toCodeAnnotation(elements) }

fun AnnotatedConstruct.getCodeAnnotations(elements: Elements): List<CodeAnnotation> =
        this.annotationMirrors.map { it.toCodeAnnotation(elements) }

fun AnnotationMirror.toCodeAnnotation(elements: Elements): CodeAnnotation {
    val type = this.annotationType.toCodeType(false, elements)

    val element = this.annotationType.asElement() as TypeElement

    val visible = element.annotationMirrors.any { it.isRetentionRuntime(elements) }

    require(element.kind == ElementKind.ANNOTATION_TYPE)

    val map = mutableMapOf<String, Any>()

    element.enclosedElements.forEach {
        if (it is ExecutableElement) {
            val name = it.simpleName.toString()

            val annotationValue = this.elementValues[it] ?: it.defaultValue

            map.put(name, annotationValue.annotationValue(it, it.returnType, elements))
        }
    }

    return com.github.jonathanxd.codeapi.base.Annotation.Builder.builder()
            .type(type)
            .visible(visible)
            .values(map)
            .build()
}

fun AnnotationMirror.isRetentionRuntime(elements: Elements): Boolean {
    val type = this.annotationType.getCodeType(elements)

    if (type.`is`(java.lang.annotation.Retention::class.java.codeType)) {
        this.elementValues.entries.forEach { (e, v) ->
            if (e.simpleName.contentEquals("value") && v != null) {
                (v.value as? VariableElement)?.let {
                    return it.simpleName.contentEquals("RUNTIME")
                }
            }
        }
    }

    return false
}

fun AnnotationValue.annotationValue(executableElement: ExecutableElement, rType: TypeMirror, elements: Elements): Any {
    val value = this.value ?: executableElement.defaultValue

    if (value is AnnotationMirror) {
        return value.toCodeAnnotation(elements)
    }

    if (value is TypeMirror)
        return value.toCodeType(false, elements)

    if (value is VariableElement)
        return EnumValue(
                enumType = value.asType().toCodeType(false, elements),
                enumEntry = value.simpleName.toString()
        )

    if (value is List<*>) {
        // Tries to convert to an reified array

        @Suppress("UNCHECKED_CAST")
        value as List<AnnotationValue>

        rType as ArrayType

        val component = rType.componentType

        return value.map { it.annotationValue(executableElement, component, elements) }
    }

    return value
}


fun TypeDeclaration.toRepresentation(): TypeDeclaration {
    val builder: TypeDeclaration.Builder<TypeDeclaration, *> = when {
        this.isInterface -> InterfaceDeclaration.Builder.builder()
                .implementations(this.interfaces.toList())

        this is AnnotationDeclaration -> AnnotationDeclaration.Builder.builder()
                .properties(this.properties.map {
                    AnnotationProperty(Comments.Absent, it.annotations.map { it.toRepresentation() }, it.returnType.codeType, it.name, it.defaultValue)
                })

        this is EnumDeclaration -> {
            EnumDeclaration.Builder.builder()
                    .implementations(this.interfaces.map { it.codeType })
                    .entries(this.entries.map { it.toRepresentation() })
                    .constructors(this.constructors.map { it.toRepresentation() })
        }

        this is ClassDeclaration -> ClassDeclaration.Builder.builder()
                .superClass(this.superType)
                .implementations(this.interfaces.toList())
                .constructors(this.constructors.map { it.toRepresentation() })

        else -> ClassDeclaration.Builder.builder()
                .superClass(this.superType)
                .implementations(this.interfaces.toList())
    }

    // Commons
    return builder
            .outerClass(this.outerClass)
            .annotations(this.annotations.map { it.toRepresentation() })
            .genericSignature(this.genericSignature)
            .modifiers(this.modifiers.toSet())
            .qualifiedName(this.canonicalName)
            .fields(this.fields.map { it.toRepresentation() })
            .methods(this.methods.map { it.toRepresentation() })
            .innerTypes(innerTypes.map { it.toRepresentation() })
            .build()
}

fun CodeAnnotation.toRepresentation(): CodeAnnotation =
        com.github.jonathanxd.codeapi.base.Annotation.Builder.builder()
                .type(this.type.codeType)
                .visible(this.visible)
                .values(this.values.toMap())
                .build()

fun EnumEntry.toRepresentation(): EnumEntry =
        EnumEntry.Builder.builder()
                .annotations(this.annotations.map { it.toRepresentation() })
                .methods(this.methods.map { it.toRepresentation() })
                .innerTypes(this.innerTypes.map { it.toRepresentation() })
                .fields(this.fields.map { it.toRepresentation() })
                .build()


fun FieldDeclaration.toRepresentation(): FieldDeclaration =
        FieldDeclaration.Builder.builder()
                .annotations(this.annotations.map { it.toRepresentation() })
                .modifiers(this.modifiers.toSet())
                .type(this.type.codeType)
                .name(this.name)
                .innerTypes(this.innerTypes.map { it.toRepresentation() })
                .build()

fun ConstructorDeclaration.toRepresentation(): ConstructorDeclaration =
        ConstructorDeclaration.Builder.builder()
                .annotations(this.annotations.map { it.toRepresentation() })
                .modifiers(this.modifiers.toSet())
                .parameters(this.parameters.map { it.toRepresentation() })
                .innerTypes(this.innerTypes.map { it.toRepresentation() })
                .throwsClause(this.throwsClause.map { it.codeType })
                .build()

fun MethodDeclaration.toRepresentation(): MethodDeclaration =
        MethodDeclaration.Builder.builder()
                .annotations(this.annotations.map { it.toRepresentation() })
                .modifiers(this.modifiers.toSet())
                .returnType(this.returnType.codeType)
                .name(this.name)
                .parameters(this.parameters.map { it.toRepresentation() })
                .innerTypes(this.innerTypes.map { it.toRepresentation() })
                .throwsClause(this.throwsClause.map { it.codeType })
                .build()

fun CodeParameter.toRepresentation(): CodeParameter =
        CodeParameter.Builder.builder()
                .annotations(this.annotations.map { it.toRepresentation() })
                .modifiers(this.modifiers.toSet())
                .type(this.type.codeType)
                .name(this.name)
                .build()

