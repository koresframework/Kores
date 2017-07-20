[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [JavaType](.)

# JavaType

`open class JavaType<T> : `[`LoadedCodeType`](../-loaded-code-type/index.md)`<T>`

Java class [CodeType](../-code-type/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `JavaType(loadedType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>)`<br>Java class [CodeType](../-code-type/index.md). |

### Properties

| Name | Summary |
|---|---|
| [loadedType](loaded-type.md) | `open val loadedType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>`<br>Loaded class. |

### Inherited Properties

| Name | Summary |
|---|---|
| [canonicalName](../-loaded-code-type/canonical-name.md) | `open val canonicalName: String`<br>Canonical name |
| [defaultResolver](../-loaded-code-type/default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<`[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`<br>Default resolver. |
| [isArray](../-loaded-code-type/is-array.md) | `open val isArray: Boolean`<br>True if this [CodeType](../-code-type/index.md) is an array type. |
| [isInterface](../-loaded-code-type/is-interface.md) | `open val isInterface: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a interface type. |
| [isPrimitive](../-loaded-code-type/is-primitive.md) | `open val isPrimitive: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a primitive type. |
| [isVirtual](../-loaded-code-type/is-virtual.md) | `open val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [primitiveType](../-loaded-code-type/primitive-type.md) | `open val primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>Primitive type. |
| [type](../-loaded-code-type/type.md) | `open val type: String`<br>Type name, examples: |
| [wrapperType](../-loaded-code-type/wrapper-type.md) | `open val wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>Wrapper type. |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `open fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `open fun hashCode(): Int` |
| [toString](to-string.md) | `open fun toString(): String` |

### Extension Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-base-component.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>See [CodeType.arrayBaseComponent](../-code-type/array-base-component.md) |
| [arrayComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-component.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayComponent: `[`CodeType`](../-code-type/index.md)<br>See [CodeType.arrayComponent](../-code-type/array-component.md) |
| [arrayDimension](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-dimension.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayDimension: Int`<br>See [CodeType.arrayDimension](../-code-type/array-dimension.md) |
| [asGeneric](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/as-generic.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.asGeneric: `[`GenericType`](../-generic-type/index.md) |
| [binaryName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/binary-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.binaryName: String`<br>Returns binary name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.binaryName](../-code-type/binary-name.md) |
| [canonicalName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/canonical-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.canonicalName: String`<br>See [CodeType.canonicalName](../-code-type/canonical-name.md) |
| [codeType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/code-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.codeType: `[`CodeType`](../-code-type/index.md) |
| [defaultResolver](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/default-resolver.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>See [CodeType.defaultResolver](../-code-type/default-resolver.md) |
| [descName](../../com.github.jonathanxd.codeapi.util/desc-name.md) | `val `[`CodeType`](../-code-type/index.md)`.descName: String` |
| [descriptor](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/descriptor.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.descriptor: String`<br>Converts `this` type to type descriptor. |
| [identification](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/identification.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.identification: String`<br>See [CodeType.identification](../-code-type/identification.md) |
| [interfaces](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/interfaces.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.interfaces: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>See [CodeType.interfaces](../-code-type/interfaces.md) |
| [internalName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/internal-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.internalName: String`<br>Returns internal name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.binaryName](../-code-type/binary-name.md) |
| [isArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-array.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isArray: Boolean`<br>See [CodeType.isArray](../-code-type/is-array.md) |
| [isInterface](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-interface.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isInterface: Boolean`<br>See [CodeType.isInterface](../-code-type/is-interface.md) |
| [isVirtual](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-virtual.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isVirtual: Boolean`<br>See [CodeType.isVirtual](../-code-type/is-virtual.md) |
| [javaSpecName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/java-spec-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.javaSpecName: String`<br>Returns java spec name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.javaSpecName](../-code-type/java-spec-name.md) |
| [packageName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/package-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.packageName: String`<br>See [CodeType.packageName](../-code-type/package-name.md) |
| [primitiveType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/primitive-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>See [CodeType.primitiveType](../-code-type/primitive-type.md) |
| [simpleName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/simple-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.simpleName: String`<br>See [CodeType.simpleName](../-code-type/simple-name.md) |
| [superType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/super-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.superType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>See [CodeType.superType](../-code-type/super-type.md) |
| [typeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/type-desc.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.typeDesc: String` |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |
| [wrapperType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/wrapper-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>See [CodeType.wrapperType](../-code-type/wrapper-type.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [applyType](../../com.github.jonathanxd.codeapi.util/apply-type.md) | `fun `[`CodeType`](../-code-type/index.md)`.applyType(typeName: String, type: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [compareTo](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/compare-to.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.compareTo(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Int`<br>See [CodeType.compareTo](../-code-type/compare-to.md) |
| [createCodeTypeDescriptor](../../com.github.jonathanxd.codeapi.util/create-code-type-descriptor.md) | `fun `[`CodeType`](../-code-type/index.md)`.createCodeTypeDescriptor(): String`<br>Creates [CodeType](../-code-type/index.md) type descriptor |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../-code-type/index.md)<br>Gets the [CodeType](../-code-type/index.md) from a [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). This method only works for Java Reflection Types and [CodeType](../-code-type/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun `[`CodeType`](../-code-type/index.md)`.getType(name: String): `[`CodeType`](../-code-type/index.md)`?`<br>`fun `[`CodeType`](../-code-type/index.md)`.getType(name: String, inside: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md)`?` |
| [getTypeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getTypeDesc(typeStr: String = this.codeType.type): String`<br>Convert `this` [name](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md#com.github.jonathanxd.codeapi.util$getTypeDesc(java.lang.reflect.Type, kotlin.String)/typeStr) to type description. |
| [inferType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/infer-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.inferType(variables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, classVariables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, generic: `[`Generic`](../-generic/index.md)`): `[`CodeType`](../-code-type/index.md)<br>Infers code type. |
| [invokeConstructor](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-constructor.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeConstructor(): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeConstructor(spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes constructor of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [invokeStatic](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeStatic(name: String, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeStatic(name: String): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes static method [name](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md#com.github.jonathanxd.codeapi.factory$invokeStatic(java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.base.TypeSpec, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/name) of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Boolean`<br>See [CodeType.is](../-code-type/index.md) |
| [isAssignableFrom](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-assignable-from.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): Boolean`<br>See [CodeType.isAssignableFrom](../-code-type/is-assignable-from.md) |
| [isConcreteIdEq](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-concrete-id-eq.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isConcreteIdEq(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>See [CodeType.isConcreteIdEq](../-code-type/is-concrete-id-eq.md) |
| [isNonReifiedType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-non-reified-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isNonReifiedType(): <ERROR CLASS>` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun `[`CodeType`](../-code-type/index.md)`.nonStrictEq(other: `[`CodeType`](../-code-type/index.md)`): Boolean`<br>Non-strict generic equality check, only works for generic types. |
| [toArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/to-array.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.toArray(dimensions: Int): `[`CodeType`](../-code-type/index.md)<br>See [CodeType.toArray](../-code-type/to-array.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun `[`CodeType`](../-code-type/index.md)`.toStr(): String`<br>Default to string conversion for [CodeType](../-code-type/index.md). |
