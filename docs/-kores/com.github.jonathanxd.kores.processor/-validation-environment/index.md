//[Kores](../../index.md)/[com.github.jonathanxd.kores.processor](../index.md)/[ValidationEnvironment](index.md)



# ValidationEnvironment  
 [jvm] interface [ValidationEnvironment](index.md)

Validation environment to index [ValidationMessages](../-validation-message/index.md).

   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl///PointingToDeclaration/"></a>[Impl](-impl/index.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Impl](-impl/index.md)(**data**: TypedData) : [ValidationEnvironment](index.md)  <br>More info  <br>Common implementation of [ValidationEnvironment](index.md)  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session///PointingToDeclaration/"></a>[Session](-session/index.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Session](-session/index.md)(**parent**: [ValidationEnvironment.Session](-session/index.md)?, **context**: Context)  <br>More info  <br>A session, used to keep track of a fragment of messages added by other validations.  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/addMessage/#com.github.jonathanxd.kores.processor.ValidationMessage/PointingToDeclaration/"></a>[addMessage](add-message.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/addMessage/#com.github.jonathanxd.kores.processor.ValidationMessage/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [addMessage](add-message.md)(message: [ValidationMessage](../-validation-message/index.md))  <br>More info  <br>Adds a [ValidationMessage](../-validation-message/index.md) to index.  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/enterInspectionOf/#kotlin.Any/PointingToDeclaration/"></a>[enterInspectionOf](enter-inspection-of.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/enterInspectionOf/#kotlin.Any/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [enterInspectionOf](enter-inspection-of.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))  <br>More info  <br>Adds part to inspection context  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/enterSession/#/PointingToDeclaration/"></a>[enterSession](enter-session.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/enterSession/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [enterSession](enter-session.md)(): [ValidationEnvironment.Session](-session/index.md)  <br>More info  <br>Enters a session, a session is used to keep track about all messages added after [enterSession](enter-session.md) invocation.  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/exitInspectionOf/#kotlin.Any/PointingToDeclaration/"></a>[exitInspectionOf](exit-inspection-of.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/exitInspectionOf/#kotlin.Any/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [exitInspectionOf](exit-inspection-of.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))  <br>More info  <br>Exits the inspection of part.  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/exitSession/#/PointingToDeclaration/"></a>[exitSession](exit-session.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/exitSession/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [exitSession](exit-session.md)(): [ValidationEnvironment.Session](-session/index.md)  <br>More info  <br>Exists current session.  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1211764316)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/context/#/PointingToDeclaration/"></a>[context](context.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/context/#/PointingToDeclaration/"></a> [jvm] abstract val [context](context.md): ContextCurrent context.   <br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/data/#/PointingToDeclaration/"></a>[data](data.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/data/#/PointingToDeclaration/"></a> [jvm] abstract val [data](data.md): TypedDataData   <br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/validationMessages/#/PointingToDeclaration/"></a>[validationMessages](validation-messages.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment/validationMessages/#/PointingToDeclaration/"></a> [jvm] abstract val [validationMessages](validation-messages.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ContextedValidationMessage](../-contexted-validation-message/index.md)>Immutable view list of indexed contexted validation messages.   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Impl///PointingToDeclaration/"></a>[ValidationEnvironment](-impl/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor//inspectionInContext/com.github.jonathanxd.kores.processor.ValidationEnvironment#TypeParam(bounds=[kotlin.Any?])#kotlin.Function1[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[inspectionInContext](../inspection-in-context.md)| <a name="com.github.jonathanxd.kores.processor//inspectionInContext/com.github.jonathanxd.kores.processor.ValidationEnvironment#TypeParam(bounds=[kotlin.Any?])#kotlin.Function1[TypeParam(bounds=[kotlin.Any?]),TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>inline fun <[P](../inspection-in-context.md), [R](../inspection-in-context.md)> [ValidationEnvironment](index.md).[inspectionInContext](../inspection-in-context.md)(part: [P](../inspection-in-context.md), context: ([P](../inspection-in-context.md)) -> [R](../inspection-in-context.md)): [R](../inspection-in-context.md)  <br>More info  <br>Immediately enters the inspection of part, calls context and then immediately exits the inspection of part.  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor//printMessages/com.github.jonathanxd.kores.processor.ValidationEnvironment#kotlin.Function1[kotlin.String,kotlin.Unit]#kotlin.Boolean/PointingToDeclaration/"></a>[printMessages](../print-messages.md)| <a name="com.github.jonathanxd.kores.processor//printMessages/com.github.jonathanxd.kores.processor.ValidationEnvironment#kotlin.Function1[kotlin.String,kotlin.Unit]#kotlin.Boolean/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [ValidationEnvironment](index.md).[printMessages](../print-messages.md)(printer: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), includeStack: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)  <br>More info  <br>Prints messages registered in [ValidationEnvironment](index.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor//sessionInContext/com.github.jonathanxd.kores.processor.ValidationEnvironment#kotlin.Function1[com.github.jonathanxd.kores.processor.ValidationEnvironment.Session,TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[sessionInContext](../session-in-context.md)| <a name="com.github.jonathanxd.kores.processor//sessionInContext/com.github.jonathanxd.kores.processor.ValidationEnvironment#kotlin.Function1[com.github.jonathanxd.kores.processor.ValidationEnvironment.Session,TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>inline fun <[R](../session-in-context.md)> [ValidationEnvironment](index.md).[sessionInContext](../session-in-context.md)(context: (session: [ValidationEnvironment.Session](-session/index.md)) -> [R](../session-in-context.md)): [R](../session-in-context.md)  <br>More info  <br>Creates session to be used only within context, this session is exited immediately after context invocation.  <br><br><br>

