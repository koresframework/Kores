//[Kores](../../../index.md)/[com.github.jonathanxd.kores.processor](../../index.md)/[ValidationEnvironment](../index.md)/[Impl](index.md)



# Impl  
 [jvm] class [Impl](index.md)(**data**: TypedData) : [ValidationEnvironment](../index.md)

Common implementation of [ValidationEnvironment](../index.md)

   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/Impl/#com.github.jonathanxd.iutils.data.TypedData/PointingToDeclaration/"></a>[Impl](-impl.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/Impl/#com.github.jonathanxd.iutils.data.TypedData/PointingToDeclaration/"></a> [jvm] fun [Impl](-impl.md)(data: TypedData)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/addMessage/#com.github.jonathanxd.kores.processor.ValidationMessage/PointingToDeclaration/"></a>[addMessage](add-message.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/addMessage/#com.github.jonathanxd.kores.processor.ValidationMessage/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [addMessage](add-message.md)(message: [ValidationMessage](../../-validation-message/index.md))  <br>More info  <br>Adds a [ValidationMessage](../../-validation-message/index.md) to index.  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/enterInspectionOf/#kotlin.Any/PointingToDeclaration/"></a>[enterInspectionOf](enter-inspection-of.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/enterInspectionOf/#kotlin.Any/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [enterInspectionOf](enter-inspection-of.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))  <br>More info  <br>Adds part to inspection context  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/enterSession/#/PointingToDeclaration/"></a>[enterSession](enter-session.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/enterSession/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [enterSession](enter-session.md)(): [ValidationEnvironment.Session](../-session/index.md)  <br>More info  <br>Enters a session, a session is used to keep track about all messages added after [enterSession](enter-session.md) invocation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/exitInspectionOf/#kotlin.Any/PointingToDeclaration/"></a>[exitInspectionOf](exit-inspection-of.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/exitInspectionOf/#kotlin.Any/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [exitInspectionOf](exit-inspection-of.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))  <br>More info  <br>Exits the inspection of part.  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/exitSession/#/PointingToDeclaration/"></a>[exitSession](exit-session.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/exitSession/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [exitSession](exit-session.md)(): [ValidationEnvironment.Session](../-session/index.md)  <br>More info  <br>Exists current session.  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/toString/#/PointingToDeclaration/"></a>[toString](to-string.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/context/#/PointingToDeclaration/"></a>[context](context.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/context/#/PointingToDeclaration/"></a> [jvm] open override val [context](context.md): ContextCurrent context.   <br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/data/#/PointingToDeclaration/"></a>[data](data.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/data/#/PointingToDeclaration/"></a> [jvm] open override val [data](data.md): TypedDataData   <br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/validationMessages/#/PointingToDeclaration/"></a>[validationMessages](validation-messages.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl/validationMessages/#/PointingToDeclaration/"></a> [jvm] open override val [validationMessages](validation-messages.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ContextedValidationMessage](../../-contexted-validation-message/index.md)>Immutable view list of indexed contexted validation messages.   <br>

