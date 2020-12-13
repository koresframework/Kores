//[Kores](../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[MethodInvocation](index.md)



# MethodInvocation  
 [jvm] data class [MethodInvocation](index.md)(**invokeType**: [InvokeType](../-invoke-type/index.md), **target**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **spec**: [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md), **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>) : [Accessor](../-accessor/index.md), [ArgumentsHolder](../-arguments-holder/index.md), [Typed](../-typed/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Invokes a method.

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/MethodInvocation/#com.github.jonathanxd.kores.base.InvokeType#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.common.MethodTypeSpec#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>[MethodInvocation](-method-invocation.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/MethodInvocation/#com.github.jonathanxd.kores.base.InvokeType#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.common.MethodTypeSpec#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a> [jvm] fun [MethodInvocation](-method-invocation.md)(invokeType: [InvokeType](../-invoke-type/index.md), target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), spec: [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>)   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/MethodInvocation.Builder///PointingToDeclaration/"></a>[Builder](-builder/index.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation.Builder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Builder](-builder/index.md) : [Accessor.Builder](../-accessor/-builder/index.md)<[MethodInvocation](index.md), [MethodInvocation.Builder](-builder/index.md)> , [ArgumentsHolder.Builder](../-arguments-holder/-builder/index.md)<[MethodInvocation](index.md), [MethodInvocation.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[MethodInvocation](index.md), [MethodInvocation.Builder](-builder/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/builder/#/PointingToDeclaration/"></a>[builder](builder.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/builder/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [builder](builder.md)(): [MethodInvocation.Builder](-builder/index.md)  <br>More info  <br>This builder may or may not accept null values, it depends on implementation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [InvokeType](../-invoke-type/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/component3/#/PointingToDeclaration/"></a>[component3](component3.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/component3/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component3](component3.md)(): [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/component4/#/PointingToDeclaration/"></a>[component4](component4.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/component4/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component4](component4.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>  <br><br><br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/copy/#com.github.jonathanxd.kores.base.InvokeType#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.common.MethodTypeSpec#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>[copy](copy.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/copy/#com.github.jonathanxd.kores.base.InvokeType#com.github.jonathanxd.kores.Instruction#com.github.jonathanxd.kores.common.MethodTypeSpec#kotlin.collections.List[com.github.jonathanxd.kores.Instruction]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(invokeType: [InvokeType](../-invoke-type/index.md), target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), spec: [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/arguments/#/PointingToDeclaration/"></a>[arguments](arguments.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/arguments/#/PointingToDeclaration/"></a> [jvm] open override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>Argument list   <br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/array/#/PointingToDeclaration/"></a>[array](array.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/array/#/PointingToDeclaration/"></a> [jvm] open override val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)Array arguments   <br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/invokeType/#/PointingToDeclaration/"></a>[invokeType](invoke-type.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/invokeType/#/PointingToDeclaration/"></a> [jvm] val [invokeType](invoke-type.md): [InvokeType](../-invoke-type/index.md)   <br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/localization/#/PointingToDeclaration/"></a>[localization](localization.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/localization/#/PointingToDeclaration/"></a> [jvm] open override val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Method localization   <br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/spec/#/PointingToDeclaration/"></a>[spec](spec.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/spec/#/PointingToDeclaration/"></a> [jvm] val [spec](spec.md): [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)   <br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/target/#/PointingToDeclaration/"></a>[target](target.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/target/#/PointingToDeclaration/"></a> [jvm] open override val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)Target of the invocation (Access to static context for static methods), for instance constructors, you must to pass a [New](../-new/index.md) instance, for super constructor or this constructors you must to pass either an [Alias](../-alias/index.md) or an [Access](../-access/index.md) to this context.   <br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/type/#/PointingToDeclaration/"></a>[type](type.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/type/#/PointingToDeclaration/"></a> [jvm] open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)Method return type   <br>
| <a name="com.github.jonathanxd.kores.base/MethodInvocation/types/#/PointingToDeclaration/"></a>[types](types.md)| <a name="com.github.jonathanxd.kores.base/MethodInvocation/types/#/PointingToDeclaration/"></a> [jvm] open override val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>Expected types of each argument   <br>


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base//isSuperConstructorInvocation/com.github.jonathanxd.kores.base.MethodInvocation#/PointingToDeclaration/"></a>[isSuperConstructorInvocation](../is-super-constructor-invocation.md)| <a name="com.github.jonathanxd.kores.base//isSuperConstructorInvocation/com.github.jonathanxd.kores.base.MethodInvocation#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>val [MethodInvocation](index.md).[isSuperConstructorInvocation](../is-super-constructor-invocation.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br>More info  <br>Returns true if a [MethodInvocation](index.md) is a invocation of super constructor  <br><br><br>

