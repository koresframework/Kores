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

import com.github.jonathanxd.kores.MutableInstructions
import com.github.jonathanxd.kores.base.*
import com.github.jonathanxd.kores.base.comment.Comments
import com.github.jonathanxd.kores.base.Retention
import com.github.jonathanxd.kores.factory.parameter
import com.github.jonathanxd.kores.type.*
import com.github.jonathanxd.kores.util.genericSignature
import com.github.jonathanxd.iutils.`object`.Try
import com.github.jonathanxd.iutils.array.ArrayUtils
import com.github.jonathanxd.iutils.function.checked.supplier.CSupplier
import com.github.jonathanxd.iutils.map.ListHashMap
import java.lang.reflect.*
import java.lang.reflect.Modifier
import javax.lang.model.AnnotatedConstruct
import javax.lang.model.element.*
import javax.lang.model.type.ArrayType
import javax.lang.model.type.TypeKind
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
                    AnnotationProperty(
                        Comments.Absent,
                        it.koresAnnotations,
                        it.returnType.koresType,
                        it.name,
                        it.defaultValue
                    )
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

                            val spec: TypeSpec? =
                                (decl as? ConstructorsHolder)?.constructors?.singleOrNull()?.let {
                                    if (it.parameters.size > 2)
                                        TypeSpec(
                                            it.returnType,
                                            it.parameters.subList(
                                                2,
                                                it.parameters.size
                                            ).map { it.type })
                                    else null
                                }

                            EnumEntry.Builder.builder()
                                .annotations(it.koresAnnotations)
                                .name(it.name)
                                .constructorSpec(spec)
                                .fields(decl.fields.toList())
                                .methods(decl.methods.toList())
                                .innerTypes(decl.innerTypes.toList())
                                .build()
                        } else {

                            EnumEntry.Builder.builder().annotations(it.koresAnnotations)
                                .name(it.name).let {
                                if (abstractMethods.isNotEmpty())
                                    it.methods(abstractMethods.map {
                                        val names = it.parameterNames
                                        MethodDeclaration.Builder.builder()
                                            .modifiers(KoresModifier.fromJavaModifiers(it.modifiers))
                                            .name(it.name)
                                            .returnType(it.genericReturnType.koresType)
                                            .throwsClause(it.genericExceptionTypes.map { it.koresType })
                                            .parameters(it.parameters.let {
                                                it.mapIndexed { i, parameter ->
                                                    parameter.toKoresParameter(names[i])
                                                }
                                            })
                                            .body(MutableInstructions.create())
                                            .build()
                                    })
                                else it
                            }.build()
                        }

                    }

                EnumDeclaration.Builder.builder()
                    .implementations(this.genericInterfaces.map { it.koresType })
                    .entries(enumEntries)
                    .constructors(this.constructorDeclarations)
            }
            else -> ClassDeclaration.Builder.builder()
                .superClass(this.genericSuperclass)
                .implementations(this.genericInterfaces.toList())
                .constructors(this.constructorDeclarations)
        }

        val typeRef = this.asTypeRef

        // Commons
        return builder
            .outerType(typeRef.outerType)
            .genericSignature(this.genericSignature)
            .annotations(this.koresAnnotations)
            .modifiers(KoresModifier.fromJavaModifiers(this.modifiers))
            .specifiedName(typeRef.specifiedName)
            .fields(this.fieldDeclarations)
            .methods(this.methodDeclarations)
            .innerTypes(innerTypes.map { it.typeDeclaration })
            .build()
    }


val Class<*>.asTypeRef: TypeRef
    get() =
        if (this.enclosingClass == null)
            TypeRef(null, this.concreteType.canonicalName, this.isInterface)
        else
            TypeRef(this.enclosingClass.asTypeRef, this.concreteType.simpleName, this.isInterface)

val Class<*>.fieldDeclarations: List<FieldDeclaration>
    get() = this.declaredFields.map {
        FieldDeclaration.Builder.builder()
            .annotations(it.koresAnnotations)
            .modifiers(KoresModifier.fromJavaModifiers(it.modifiers))
            .type(it.type.koresType)
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
                .annotations(it.koresAnnotations)
                .modifiers(KoresModifier.fromJavaModifiers(it.modifiers))
                .genericSignature(it.genericSignature)
                .name(it.name)
                .returnType(it.genericReturnType.koresType)
                .parameters(it.parameters.mapIndexed { i, parameter ->
                    parameter.toKoresParameter(names[i])
                })
                .throwsClause(it.genericExceptionTypes.map { it.koresType })
                .innerTypes(classesDeclaredByMethods[it].orEmpty().map { it.typeDeclaration })
                .body(MutableInstructions.create())
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
                .annotations(it.koresAnnotations)
                .modifiers(KoresModifier.fromJavaModifiers(it.modifiers))
                .genericSignature(it.genericSignature)
                .parameters(it.parameters.mapIndexed { i, parameter ->
                    parameter.toKoresParameter(names[i])
                })
                .throwsClause(it.genericExceptionTypes.map { it.koresType })
                .innerTypes(classesDeclaredByConstructors[it].orEmpty().map { it.typeDeclaration })
                .body(MutableInstructions.create())
                .build()
        }
    }

fun Parameter.toKoresParameter(alternativeName: String? = null) =
    KoresParameter.Builder.builder()
        .annotations(this.annotations.koresAnnotation)
        .modifiers(KoresModifier.fromJavaModifiers(this.modifiers))
        .type(this.parameterizedType)
        .name(alternativeName ?: this.name)
        .build()

val <T : Annotation> Array<T>.koresAnnotation: List<KoresAnnotation> get() = this.map { it.koresAnnotation }
val <T : Annotation> List<T>.koresAnnotation: List<KoresAnnotation> get() = this.map { it.koresAnnotation }
val AnnotatedElement.koresAnnotations: List<KoresAnnotation> get() = this.annotations.map { it.koresAnnotation }

val <T : Annotation> T.koresAnnotation: KoresAnnotation
    get() {
        val type = this.annotationClass.java

        val retention =
            type.getAnnotation(java.lang.annotation.Retention::class.java)

        val map = mutableMapOf<String, Any>()

        type.declaredMethods
            .filter {
                Modifier.isPublic(it.modifiers)
                        && it.parameterCount == 0
            }
            .map {
                map[it.name] = it.invoke(this).annotationValue(it.returnType)
            }

        return com.github.jonathanxd.kores.base.Annotation.Builder.builder()
            .type(type)
            .retention(retention?.let { Retention.fromPolicy(it.value) } ?: Retention.CLASS)
            .values(map)
            .build()
    }

fun Any.annotationValue(rType: Class<*>): Any =
    when (this) {
        is Boolean, is Byte, is Char, is Short,
        is Int, is Float, is Long, is Double, is String -> this
        is Class<*> -> this.koresType // Not required
        is Enum<*> -> EnumValue(rType, this.name)
        is Annotation -> this.koresAnnotation
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
            .implementations(this.interfaces.filterNotNone().map { it.getKoresType(elements) })

        this.kind == ElementKind.ANNOTATION_TYPE -> AnnotationDeclaration.Builder.builder()
            .properties(this.enclosedElements.filterIsInstance<ExecutableElement>().map {
                val rType = it.returnType.getKoresType(elements)
                AnnotationProperty(
                    Comments.Absent, it.getKoresAnnotations(elements),
                    rType,
                    it.simpleName.toString(),
                    it.defaultValue.annotationValue(it, it.returnType, elements)
                )
            })

        this.kind == ElementKind.ENUM -> {
            val abstractMethods =
                this.enclosedElements.filterIsInstance<ExecutableElement>().filter {
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
                            .annotations(it.getKoresAnnotations(elements))
                            .name(it.simpleName.toString())
                            .fields(fields)
                            .methods(methods)
                            .innerTypes(inner)
                            .build()
                    } else {
                        EnumEntry.Builder.builder().annotations(it.getKoresAnnotations(elements))
                            .name(it.simpleName.toString()).let {
                            if (abstractMethods.isNotEmpty())
                                it.methods(abstractMethods.map {
                                    MethodDeclaration.Builder.builder()
                                        .modifiers(KoresModifier.fromJavaxModifiers(it.modifiers))
                                        .name(it.simpleName.toString())
                                        .returnType(it.returnType.getKoresType(elements))
                                        .parameters(it.parameters.map {
                                            parameter(
                                                type = it.asType().getKoresType(elements),
                                                name = it.simpleName.toString()
                                            )
                                        })
                                        .body(MutableInstructions.create())
                                        .build()
                                })
                            else it
                        }.build()
                    }

                }

            EnumDeclaration.Builder.builder()
                .implementations(this.interfaces.filterNotNone().map { it.getKoresType(elements) })
                .entries(enumEntries)
                .constructors(this.getConstructorDeclarations(elements))
        }
        else -> ClassDeclaration.Builder.builder()
            .also {
                if (this.superclass.kind != TypeKind.NONE)
                    it.superClass(this.superclass.getKoresType(elements))
            }
            .implementations(this.interfaces.filterNotNone().map { it.getKoresType(elements) })
            .constructors(this.getConstructorDeclarations(elements))
    }

    val asTypeRef = this.asTypeRef(elements)

    // Commons
    return builder
        .outerType(asTypeRef.outerType)
        .annotations(this.getKoresAnnotations(elements))
        .modifiers(KoresModifier.fromJavaxModifiers(this.modifiers))
        .genericSignature(this.getGenericSignature(false, elements))
        .specifiedName(asTypeRef.specifiedName)
        .fields(this.getFieldDeclarations(elements))
        .methods(this.getMethodDeclarations(elements))
        .innerTypes(innerTypes.map { it.getTypeDeclaration(elements) })
        .build()
}

private fun List<TypeMirror>.filterNotNone() = this.filter { it.kind != TypeKind.NONE }

fun TypeElement.asTypeRef(elements: Elements): TypeRef =
    if (this.enclosingElement.kind == ElementKind.PACKAGE)
        TypeRef(
            null,
            this.getKoresType(elements).concreteType.canonicalName,
            this.kind == ElementKind.INTERFACE
        )
    else {
        val enclosingType = this.getEnclosingType()
        TypeRef(
            enclosingType.asTypeRef(elements),
            this.getKoresType(elements).concreteType.simpleName,
            this.kind == ElementKind.INTERFACE
        )
    }

tailrec fun Element.getEnclosingType(): TypeElement =
    when {
        this.enclosingElement is TypeElement -> this.enclosingElement as TypeElement
        this.enclosingElement.kind == ElementKind.PACKAGE -> throw IllegalArgumentException("Package found before enclosing type")
        else -> this.enclosingElement.getEnclosingType()
    }

fun VariableElement.getFieldDeclaration(elements: Elements): FieldDeclaration =
    FieldDeclaration.Builder.builder()
        .annotations(this.getKoresAnnotations(elements))
        .modifiers(KoresModifier.fromJavaxModifiers(this.modifiers))
        .type(this.asType().getKoresType(elements))
        .name(this.simpleName.toString())
        .build()

fun TypeElement.getFieldDeclarations(elements: Elements): List<FieldDeclaration> =
    this.enclosedElements.filterIsInstance<VariableElement>()
        .filter { it.kind == ElementKind.FIELD }
        .map { it.getFieldDeclaration(elements) }

fun ExecutableElement.getMethodDeclaration(elements: Elements): MethodDeclaration =
    MethodDeclaration.Builder.builder()
        .annotations(this.getKoresAnnotations(elements))
        .modifiers(KoresModifier.fromJavaxModifiers(this.modifiers))
        .name(this.simpleName.toString())
        .returnType(this.returnType.getKoresType(elements))
        .genericSignature(this.getGenericSignature(false, elements))
        .parameters(this.parameters.map {
            parameter(type = it.asType().getKoresType(elements), name = it.simpleName.toString())
        })
        .throwsClause(this.thrownTypes.filterNotNone().map { it.getKoresType(elements) })
        .innerTypes(this.enclosedElements.filterIsInstance<TypeElement>().map {
            it.getTypeDeclaration(
                elements
            )
        })
        .body(MutableInstructions.create())
        .build()

fun TypeElement.getMethodDeclarations(elements: Elements): List<MethodDeclaration> =
    this.enclosedElements
        .filterIsInstance<ExecutableElement>()
        .filter { it.kind == ElementKind.METHOD }
        .map { it.getMethodDeclaration(elements) }


fun ExecutableElement.getConstructorDeclaration(elements: Elements): ConstructorDeclaration =
    ConstructorDeclaration.Builder.builder()
        .annotations(this.getKoresAnnotations(elements))
        .modifiers(KoresModifier.fromJavaxModifiers(this.modifiers))
        .parameters(this.parameters.map {
            parameter(type = it.asType().getKoresType(elements), name = it.simpleName.toString())
        })
        .throwsClause(this.thrownTypes.filterNotNone().map { it.getKoresType(elements) })
        .innerTypes(this.enclosedElements.filterIsInstance<TypeElement>().map {
            it.getTypeDeclaration(
                elements
            )
        })
        .build()


fun TypeElement.getConstructorDeclarations(elements: Elements): List<ConstructorDeclaration> =
    this.enclosedElements
        .filterIsInstance<ExecutableElement>()
        .filter { it.kind == ElementKind.CONSTRUCTOR }
        .map { it.getConstructorDeclaration(elements) }


fun List<AnnotationMirror>.annotationMirrorsToKoresAnnotations(elements: Elements): List<KoresAnnotation> =
    this.map { it.toKoresAnnotation(elements) }

fun AnnotatedConstruct.getKoresAnnotations(elements: Elements): List<KoresAnnotation> =
    this.annotationMirrors.map { it.toKoresAnnotation(elements) }

fun AnnotationMirror.toKoresAnnotation(elements: Elements): KoresAnnotation {
    val type = this.annotationType.toKoresType(false, elements)

    val element = this.annotationType.asElement() as TypeElement

    val retention = element.annotationMirrors
        .map { it.getRetentionName(elements)?.let { enumValueOf<com.github.jonathanxd.kores.base.Retention>(it) } }
        .filterNotNull()
        .firstOrNull() ?: Retention.CLASS

    require(element.kind == ElementKind.ANNOTATION_TYPE)

    val map = mutableMapOf<String, Any>()

    element.enclosedElements.forEach {
        if (it is ExecutableElement) {
            val name = it.simpleName.toString()

            val annotationValue = this.elementValues[it] ?: it.defaultValue

            map[name] = annotationValue.annotationValue(it, it.returnType, elements)
        }
    }

    return com.github.jonathanxd.kores.base.Annotation.Builder.builder()
        .type(type)
        .retention(retention)
        .values(map)
        .build()
}

fun AnnotationMirror.getRetentionName(elements: Elements): String? {
    val type = this.annotationType.getKoresType(elements)

    if (type.`is`(java.lang.annotation.Retention::class.java.koresType)) {
        this.elementValues.entries.forEach { (e, v) ->
            if (e.simpleName.contentEquals("value") && v != null) {
                (v.value as? VariableElement)?.let {
                    return it.simpleName.toString()
                }
            }
        }
    }

    return null
}

fun AnnotationValue.annotationValue(
    executableElement: ExecutableElement,
    rType: TypeMirror,
    elements: Elements
): Any {
    val value = this.value ?: executableElement.defaultValue

    if (value is AnnotationMirror) {
        return value.toKoresAnnotation(elements)
    }

    if (value is TypeMirror)
        return value.toKoresType(false, elements)

    if (value is VariableElement)
        return EnumValue(
            enumType = value.asType().toKoresType(false, elements),
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
                AnnotationProperty(
                    Comments.Absent,
                    it.annotations.map { it.toRepresentation() },
                    it.returnType.koresType,
                    it.name,
                    it.defaultValue
                )
            })

        this is EnumDeclaration -> {
            EnumDeclaration.Builder.builder()
                .implementations(this.interfaces.map { it.koresType })
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
        .outerType(this.outerType)
        .annotations(this.annotations.map { it.toRepresentation() })
        .genericSignature(this.genericSignature)
        .modifiers(this.modifiers.toSet())
        .specifiedName(this.specifiedName)
        .fields(this.fields.map { it.toRepresentation() })
        .methods(this.methods.map { it.toRepresentation() })
        .innerTypes(innerTypes.map { it.toRepresentation() })
        .build()
}

fun KoresAnnotation.toRepresentation(): KoresAnnotation =
    com.github.jonathanxd.kores.base.Annotation.Builder.builder()
        .type(this.type.koresType)
        .retention(this.retention)
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
        .type(this.type.koresType)
        .name(this.name)
        .innerTypes(this.innerTypes.map { it.toRepresentation() })
        .build()

fun ConstructorDeclaration.toRepresentation(): ConstructorDeclaration =
    ConstructorDeclaration.Builder.builder()
        .annotations(this.annotations.map { it.toRepresentation() })
        .modifiers(this.modifiers.toSet())
        .parameters(this.parameters.map { it.toRepresentation() })
        .innerTypes(this.innerTypes.map { it.toRepresentation() })
        .throwsClause(this.throwsClause.map { it.koresType })
        .build()

fun MethodDeclaration.toRepresentation(): MethodDeclaration =
    MethodDeclaration.Builder.builder()
        .annotations(this.annotations.map { it.toRepresentation() })
        .genericSignature(this.genericSignature)
        .modifiers(this.modifiers.toSet())
        .returnType(this.returnType.koresType)
        .name(this.name)
        .parameters(this.parameters.map { it.toRepresentation() })
        .innerTypes(this.innerTypes.map { it.toRepresentation() })
        .throwsClause(this.throwsClause.map { it.koresType })
        .build()

fun KoresParameter.toRepresentation(): KoresParameter =
    KoresParameter.Builder.builder()
        .annotations(this.annotations.map { it.toRepresentation() })
        .modifiers(this.modifiers.toSet())
        .type(this.type.koresType)
        .name(this.name)
        .build()

