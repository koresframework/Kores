[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [Generic](.)

# Generic

`class Generic : `[`GenericType`](../-generic-type/index.md)

A generic type.

Examples:

A generic type T that extends String:

`Generic.type("T").extends$(PredefinedTypes.STRING);`

A generic type T that extends V:

`Generic.type("T").extends$("V");`

A List of Type T:

`Generic.type(CodeAPI.getJavaType(List.class)).of("T")`

**Attention:All calls of the methods ofGenericclass creates a copy of the`bound`array(except the first call),if you mind performance use the[GenericTypeBuilder](../-generic-type-builder/index.md)**

### Properties

| Name | Summary |
|---|---|
| [bounds](bounds.md) | `val bounds: Array<`[`Bound`](../-generic-type/-bound/index.md)`>`<br>Generic bounds. |
| [canonicalName](canonical-name.md) | `val canonicalName: String`<br>Canonical name |
| [codeType](code-type.md) | `val codeType: `[`CodeType`](../-code-type/index.md)<br>Type. |
| [isArray](is-array.md) | `val isArray: Boolean`<br>True if this [CodeType](../-code-type/index.md) is an array type. |
| [isInterface](is-interface.md) | `val isInterface: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | `val isPrimitive: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a primitive type. |
| [isType](is-type.md) | `val isType: Boolean`<br>Returns true if this is a Type generic type, false if is a Type Variable generic type. |
| [isVirtual](is-virtual.md) | `val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](java-spec-name.md) | `val javaSpecName: String`<br>JVM Spec class name. |
| [name](name.md) | `val name: String`<br>Name of the generic type. |
| [packageName](package-name.md) | `val packageName: String`<br>Package name |
| [primitiveType](primitive-type.md) | `val primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Primitive type if: |
| [simpleName](simple-name.md) | `val simpleName: String`<br>Simple name. |
| [type](type.md) | `val type: String`<br>Type name, examples: |
| [wrapperType](wrapper-type.md) | `val wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Wrapper type if: |

### Inherited Properties

| Name | Summary |
|---|---|
| [identification](../-generic-type/identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
[CodeType](../-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../-code-type/index.md). |
| [isWildcard](../-generic-type/is-wildcard.md) | `open val isWildcard: Boolean`<br>Returns true if this is a wildcard generic type. |

### Functions

| Name | Summary |
|---|---|
| [compareTo](compare-to.md) | `fun compareTo(other: `[`CodeType`](../-code-type/index.md)`): Int` |
| [equals](equals.md) | `fun equals(other: Any?): Boolean` |
| [extends$](extends$.md) | `fun extends$(s: String): Generic`<br>Generic type that extends type variable `s`.`fun extends$(vararg ss: String): Generic`<br>Generic type that extends type variables `ss`.`fun extends$(type: `[`CodeType`](../-code-type/index.md)`): Generic`<br>`fun extends$(type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): Generic`<br>Generic type that extends type `type`.`fun extends$(vararg types: `[`CodeType`](../-code-type/index.md)`): Generic`<br>`fun extends$(vararg types: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): Generic`<br>Generic type that extends types `types`. |
| [hashCode](hash-code.md) | `fun hashCode(): Int` |
| [of](of.md) | `fun of(bound: `[`Bound`](../-generic-type/-bound/index.md)`): Generic`<br>Add a bound.`fun of(vararg bounds: `[`Bound`](../-generic-type/-bound/index.md)`): Generic`<br>Add all [bounds](of.md#com.github.jonathanxd.codeapi.type.Generic$of(kotlin.Array((com.github.jonathanxd.codeapi.type.GenericType.Bound)))/bounds).`fun of(s: String): Generic`<br>Add a name bound.`fun of(vararg ss: String): Generic`<br>Add name bounds.`fun of(type: `[`CodeType`](../-code-type/index.md)`): Generic`<br>`fun of(type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): Generic`<br>Add a type bound.`fun of(vararg types: `[`CodeType`](../-code-type/index.md)`): Generic`<br>`fun of(vararg types: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): Generic`<br>Add type bounds. |
| [super$](super$.md) | `fun super$(s: String): Generic`<br>Generic type that have a super type variable `s`.`fun super$(vararg ss: String): Generic`<br>Generic type that have a super type variables `ss`.`fun super$(type: `[`CodeType`](../-code-type/index.md)`): Generic`<br>`fun super$(type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): Generic`<br>Generic type that have a super type `type`.`fun super$(vararg types: `[`CodeType`](../-code-type/index.md)`): Generic`<br>`fun super$(vararg types: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): Generic`<br>Generic type that have a super types `types`. |
| [toArray](to-array.md) | `fun toArray(dimensions: Int): `[`GenericType`](../-generic-type/index.md)<br>Convert this [CodeType](../-code-type/index.md) to a [CodeTypeArray](#). |
| [toString](to-string.md) | `fun toString(): String` |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../-generic-type/builder.md) | `open fun builder(): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |
| [is](../-generic-type/is.md) | `open fun is(another: `[`CodeType`](../-code-type/index.md)`?): Boolean`<br>Returns true if this [CodeType](../-code-type/index.md) is equals to another [CodeType](../-code-type/index.md). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [type](type.md) | `fun type(s: String): Generic`<br>Create a generic type from a name (ex: T, E, R).`fun type(type: `[`CodeType`](../-code-type/index.md)`): Generic`<br>`fun type(type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): Generic`<br>Create a generic type from a type. |
| [wildcard](wildcard.md) | `fun wildcard(): Generic`<br>Create a generic wildcard (? in Java Language, * in JVM). |

### Extension Properties

| Name | Summary |
|---|---|
| [codeType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/code-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.codeType: `[`CodeType`](../-code-type/index.md) |
| [concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) | `val `[`CodeType`](../-code-type/index.md)`.concreteType: `[`CodeType`](../-code-type/index.md)<br>Gets the concrete type of [CodeType](../-code-type/index.md), if this is a [GenericType](../-generic-type/index.md), the property getter will try to
infer the concrete type looping the [GenericType Inferred type](../-generic-type/code-type.md). |
| [descName](../../com.github.jonathanxd.codeapi.util/desc-name.md) | `val `[`CodeType`](../-code-type/index.md)`.descName: String` |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../-code-type/index.md) |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean` |
| [toComponentString](../../com.github.jonathanxd.codeapi.util/to-component-string.md) | `fun `[`GenericType`](../-generic-type/index.md)`.toComponentString(): String`<br>Creates string representation of components of [GenericType](../-generic-type/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
