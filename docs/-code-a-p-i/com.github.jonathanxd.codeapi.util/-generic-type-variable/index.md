[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [GenericTypeVariable](.)

# GenericTypeVariable

`class GenericTypeVariable : TypeVariable<GenericDeclaration>`

Wrapper of [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) to [TypeVariable](#). This class is a little complex and is not intended to be used by
external sources.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GenericTypeVariable(type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?, wrapped: TypeVariable<out GenericDeclaration>?, bounds: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<Type>)`<br>`GenericTypeVariable(type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?, wrapped: TypeVariable<out GenericDeclaration>?, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, bounds: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<Type>)`<br>`GenericTypeVariable(type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?, wrappedType: Type?, bounds: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<Type>)` |

### Properties

| Name | Summary |
|---|---|
| [type](type.md) | `val type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [getAnnotatedBounds](get-annotated-bounds.md) | `fun getAnnotatedBounds(): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<AnnotatedType>` |
| [getAnnotation](get-annotation.md) | `fun <T : `[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`> getAnnotation(annotationClass: Class<T>): T?` |
| [getAnnotations](get-annotations.md) | `fun getAnnotations(): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>` |
| [getBounds](get-bounds.md) | `fun getBounds(): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<Type>` |
| [getDeclaredAnnotations](get-declared-annotations.md) | `fun getDeclaredAnnotations(): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Annotation`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)`>` |
| [getGenericDeclaration](get-generic-declaration.md) | `fun getGenericDeclaration(): GenericDeclaration?` |
| [getName](get-name.md) | `fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Extension Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../java.lang.reflect.-type/array-base-component.md) | `val Type.arrayBaseComponent: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>See [CodeType.arrayBaseComponent](../../com.github.jonathanxd.codeapi.type/-code-type/array-base-component.md) |
| [arrayComponent](../java.lang.reflect.-type/array-component.md) | `val Type.arrayComponent: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>See [CodeType.arrayComponent](../../com.github.jonathanxd.codeapi.type/-code-type/array-component.md) |
| [arrayDimension](../java.lang.reflect.-type/array-dimension.md) | `val Type.arrayDimension: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>See [CodeType.arrayDimension](../../com.github.jonathanxd.codeapi.type/-code-type/array-dimension.md) |
| [asGeneric](../java.lang.reflect.-type/as-generic.md) | `val Type.asGeneric: `[`GenericType`](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md) |
| [binaryName](../java.lang.reflect.-type/binary-name.md) | `val Type.binaryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns binary name of [Type](#). See [CodeType.binaryName](../../com.github.jonathanxd.codeapi.type/-code-type/binary-name.md) |
| [canonicalName](../java.lang.reflect.-type/canonical-name.md) | `val Type.canonicalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.canonicalName](../../com.github.jonathanxd.codeapi.type/-code-type/canonical-name.md) |
| [codeAnnotations](../../com.github.jonathanxd.codeapi.util.conversion/java.lang.reflect.-annotated-element/code-annotations.md) | `val AnnotatedElement.codeAnnotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeAnnotation`](../../com.github.jonathanxd.codeapi.base/-code-annotation.md)`>` |
| [codeType](../java.lang.reflect.-type/code-type.md) | `val Type.codeType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [concreteType](../java.lang.reflect.-type/concrete-type.md) | `val Type.concreteType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>See [concreteType](../concrete-type.md) |
| [defaultResolver](../java.lang.reflect.-type/default-resolver.md) | `val Type.defaultResolver: `[`CodeTypeResolver`](../../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>`<br>See [CodeType.defaultResolver](../../com.github.jonathanxd.codeapi.type/-code-type/default-resolver.md) |
| [descriptor](../java.lang.reflect.-type/descriptor.md) | `val Type.descriptor: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Converts `this` type to type descriptor. |
| [identification](../java.lang.reflect.-type/identification.md) | `val Type.identification: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.identification](../../com.github.jonathanxd.codeapi.type/-code-type/identification.md) |
| [interfaces](../java.lang.reflect.-type/interfaces.md) | `val Type.interfaces: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>See [CodeType.interfaces](../../com.github.jonathanxd.codeapi.type/-code-type/interfaces.md) |
| [internalName](../java.lang.reflect.-type/internal-name.md) | `val Type.internalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns internal name of [Type](#). See [CodeType.binaryName](../../com.github.jonathanxd.codeapi.type/-code-type/binary-name.md) |
| [isArray](../java.lang.reflect.-type/is-array.md) | `val Type.isArray: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isArray](../../com.github.jonathanxd.codeapi.type/-code-type/is-array.md) |
| [isInterface](../java.lang.reflect.-type/is-interface.md) | `val Type.isInterface: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isInterface](../../com.github.jonathanxd.codeapi.type/-code-type/is-interface.md) |
| [isPrimitive](../java.lang.reflect.-type/is-primitive.md) | `val Type.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isPrimitive](../../com.github.jonathanxd.codeapi.type/-code-type/is-primitive.md) |
| [isVirtual](../java.lang.reflect.-type/is-virtual.md) | `val Type.isVirtual: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isVirtual](../../com.github.jonathanxd.codeapi.type/-code-type/is-virtual.md) |
| [javaSpecName](../java.lang.reflect.-type/java-spec-name.md) | `val Type.javaSpecName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns java spec name of [Type](#). See [CodeType.javaSpecName](../../com.github.jonathanxd.codeapi.type/-code-type/java-spec-name.md) |
| [packageName](../java.lang.reflect.-type/package-name.md) | `val Type.packageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.packageName](../../com.github.jonathanxd.codeapi.type/-code-type/package-name.md) |
| [primitiveType](../java.lang.reflect.-type/primitive-type.md) | `val Type.primitiveType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`<br>See [CodeType.primitiveType](../../com.github.jonathanxd.codeapi.type/-code-type/primitive-type.md) |
| [simpleName](../java.lang.reflect.-type/simple-name.md) | `val Type.simpleName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.simpleName](../../com.github.jonathanxd.codeapi.type/-code-type/simple-name.md) |
| [superType](../java.lang.reflect.-type/super-type.md) | `val Type.superType: Type?`<br>See [CodeType.superType](../../com.github.jonathanxd.codeapi.type/-code-type/super-type.md) |
| [type](../java.lang.reflect.-type/type.md) | `val Type.type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.type](../../com.github.jonathanxd.codeapi.type/-code-type/type.md) |
| [typeDesc](../java.lang.reflect.-type/type-desc.md) | `val Type.typeDesc: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [wrapperType](../java.lang.reflect.-type/wrapper-type.md) | `val Type.wrapperType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`<br>See [CodeType.wrapperType](../../com.github.jonathanxd.codeapi.type/-code-type/wrapper-type.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [compareTo](../java.lang.reflect.-type/compare-to.md) | `fun Type.compareTo(other: Type): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>See [CodeType.compareTo](../../com.github.jonathanxd.codeapi.type/-code-type/compare-to.md) |
| [eq](../java.lang.reflect.-type/eq.md) | `fun Type.eq(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.equals](../../com.github.jonathanxd.codeapi.type/-code-type/equals.md) |
| [getType](../java.lang.reflect.-type/get-type.md) | `fun Type.getType(isParameterized: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Gets the [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) from a [Type](#). This method only works for Java Reflection Types and [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). |
| [getTypeDesc](../java.lang.reflect.-type/get-type-desc.md) | `fun Type.getTypeDesc(typeStr: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = this.codeType.type): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert `this` [name](../java.lang.reflect.-type/get-type-desc.md#com.github.jonathanxd.codeapi.util$getTypeDesc(java.lang.reflect.Type, kotlin.String)/typeStr) to type description. |
| [hash](../java.lang.reflect.-type/hash.md) | `fun Type.hash(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>See [CodeType.hashCode](../../com.github.jonathanxd.codeapi.type/-code-type/hash-code.md) |
| [inferType](../java.lang.reflect.-type/infer-type.md) | `fun Type.inferType(variables: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>, classVariables: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>, generic: `[`Generic`](../../com.github.jonathanxd.codeapi.type/-generic/index.md)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Infers code type. |
| [invokeConstructor](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-constructor.md) | `fun Type.invokeConstructor(): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun Type.invokeConstructor(spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes constructor of [Type](#) |
| [invokeStatic](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md) | `fun Type.invokeStatic(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun Type.invokeStatic(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes static method [name](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md#com.github.jonathanxd.codeapi.factory$invokeStatic(java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.base.TypeSpec, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/name) of [Type](#) |
| [is](../java.lang.reflect.-type/is.md) | `fun Type.is(another: Type?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.is](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [isAssignableFrom](../java.lang.reflect.-type/is-assignable-from.md) | `fun Type.isAssignableFrom(type: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`fun Type.isAssignableFrom(type: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isAssignableFrom](../../com.github.jonathanxd.codeapi.type/-code-type/is-assignable-from.md) |
| [isConcreteIdEq](../java.lang.reflect.-type/is-concrete-id-eq.md) | `fun Type.isConcreteIdEq(another: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isConcreteIdEq](../../com.github.jonathanxd.codeapi.type/-code-type/is-concrete-id-eq.md) |
| [isNonReifiedType](../java.lang.reflect.-type/is-non-reified-type.md) | `fun Type.isNonReifiedType(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [toArray](../java.lang.reflect.-type/to-array.md) | `fun Type.toArray(dimensions: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>See [CodeType.toArray](../../com.github.jonathanxd.codeapi.type/-code-type/to-array.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
