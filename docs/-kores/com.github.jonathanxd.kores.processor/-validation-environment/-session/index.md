//[Kores](../../../index.md)/[com.github.jonathanxd.kores.processor](../../index.md)/[ValidationEnvironment](../index.md)/[Session](index.md)



# Session  
 [jvm] class [Session](index.md)(**parent**: [ValidationEnvironment.Session](index.md)?, **context**: Context)

A session, used to keep track of a fragment of messages added by other validations.

   


## See also  
  
jvm  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session///PointingToDeclaration/"></a>[com.github.jonathanxd.kores.processor.ValidationEnvironment](../enter-session.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session///PointingToDeclaration/"></a>
  


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session/Session/#com.github.jonathanxd.kores.processor.ValidationEnvironment.Session?#com.github.jonathanxd.iutils.processing.Context/PointingToDeclaration/"></a>[Session](-session.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session/Session/#com.github.jonathanxd.kores.processor.ValidationEnvironment.Session?#com.github.jonathanxd.iutils.processing.Context/PointingToDeclaration/"></a> [jvm] fun [Session](-session.md)(parent: [ValidationEnvironment.Session](index.md)?, context: Context)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session/addMessage/#com.github.jonathanxd.kores.processor.ContextedValidationMessage/PointingToDeclaration/"></a>[addMessage](add-message.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session/addMessage/#com.github.jonathanxd.kores.processor.ContextedValidationMessage/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [addMessage](add-message.md)(message: [ContextedValidationMessage](../../-contexted-validation-message/index.md))  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session/anyError/#/PointingToDeclaration/"></a>[anyError](any-error.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session/anyError/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [anyError](any-error.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session/context/#/PointingToDeclaration/"></a>[context](context.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session/context/#/PointingToDeclaration/"></a> [jvm] val [context](context.md): Context   <br>
| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session/messages/#/PointingToDeclaration/"></a>[messages](messages.md)| <a name="com.github.jonathanxd.kores.processor/ValidationEnvironment.Session/messages/#/PointingToDeclaration/"></a> [jvm] val [messages](messages.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ContextedValidationMessage](../../-contexted-validation-message/index.md)>   <br>

