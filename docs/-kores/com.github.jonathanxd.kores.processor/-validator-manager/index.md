//[Kores](../../index.md)/[com.github.jonathanxd.kores.processor](../index.md)/[ValidatorManager](index.md)



# ValidatorManager  
 [jvm] interface [ValidatorManager](index.md)

Manages all [Validators](../-validator/index.md) used to validate [part](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html).

   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor/ValidatorManager/createData/#/PointingToDeclaration/"></a>[createData](create-data.md)| <a name="com.github.jonathanxd.kores.processor/ValidatorManager/createData/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [createData](create-data.md)(): TypedData  <br>More info  <br>Creates default TypedData instance.  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidatorManager/createEnvironment/#com.github.jonathanxd.iutils.data.TypedData/PointingToDeclaration/"></a>[createEnvironment](create-environment.md)| <a name="com.github.jonathanxd.kores.processor/ValidatorManager/createEnvironment/#com.github.jonathanxd.iutils.data.TypedData/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [createEnvironment](create-environment.md)(data: TypedData): [ValidationEnvironment](../-validation-environment/index.md)  <br>More info  <br>Creates default [ValidationEnvironment](../-validation-environment/index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidatorManager/registerValidator/#com.github.jonathanxd.kores.processor.Validator[TypeParam(bounds=[kotlin.Any?])]#java.lang.Class[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[registerValidator](register-validator.md)| <a name="com.github.jonathanxd.kores.processor/ValidatorManager/registerValidator/#com.github.jonathanxd.kores.processor.Validator[TypeParam(bounds=[kotlin.Any?])]#java.lang.Class[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun <[P](register-validator.md)> [registerValidator](register-validator.md)(validator: [Validator](../-validator/index.md)<[P](register-validator.md)>, type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[P](register-validator.md)>)  <br>More info  <br>Registers a custom validator of [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md) of type.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../com.github.jonathanxd.kores.util/-simple-resolver/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-427383591)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor/ValidatorManager/validate/#kotlin.Any#com.github.jonathanxd.iutils.data.TypedData#com.github.jonathanxd.kores.processor.ValidationEnvironment?/PointingToDeclaration/"></a>[validate](validate.md)| <a name="com.github.jonathanxd.kores.processor/ValidatorManager/validate/#kotlin.Any#com.github.jonathanxd.iutils.data.TypedData#com.github.jonathanxd.kores.processor.ValidationEnvironment?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [validate](validate.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), data: TypedData, environment: [ValidationEnvironment](../-validation-environment/index.md)? = null): [ValidationEnvironment](../-validation-environment/index.md)  <br>More info  <br>Validates part and return environment used to validate.  <br><br><br>[jvm]  <br>Content  <br>abstract fun <[P](validate.md)> [validate](validate.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [P](validate.md)>, part: [P](validate.md), data: TypedData, environment: [ValidationEnvironment](../-validation-environment/index.md)? = null): [ValidationEnvironment](../-validation-environment/index.md)  <br>More info  <br>Validates part of type type and return environment used to validate.  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="com.github.jonathanxd.kores.processor/VoidValidatorManager///PointingToDeclaration/"></a>[VoidValidatorManager](../-void-validator-manager/index.md)
| <a name="com.github.jonathanxd.kores.processor/AbstractValidatorManager///PointingToDeclaration/"></a>[AbstractValidatorManager](../-abstract-validator-manager/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.processor//registerValidator/com.github.jonathanxd.kores.processor.ValidatorManager#com.github.jonathanxd.kores.processor.Validator[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[registerValidator](../register-validator.md)| <a name="com.github.jonathanxd.kores.processor//registerValidator/com.github.jonathanxd.kores.processor.ValidatorManager#com.github.jonathanxd.kores.processor.Validator[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>inline fun <[P](../register-validator.md)> [ValidatorManager](index.md).[registerValidator](../register-validator.md)(validator: [Validator](../-validator/index.md)<[P](../register-validator.md)>)  <br>More info  <br>Registers a custom validator of [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md) of type [P](../register-validator.md).  <br><br><br>
| <a name="com.github.jonathanxd.kores.processor//validatePart/com.github.jonathanxd.kores.processor.ValidatorManager#TypeParam(bounds=[kotlin.Any?])#com.github.jonathanxd.iutils.data.TypedData/PointingToDeclaration/"></a>[validatePart](../validate-part.md)| <a name="com.github.jonathanxd.kores.processor//validatePart/com.github.jonathanxd.kores.processor.ValidatorManager#TypeParam(bounds=[kotlin.Any?])#com.github.jonathanxd.iutils.data.TypedData/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>inline fun <[P](../validate-part.md)> [ValidatorManager](index.md).[validatePart](../validate-part.md)(part: [P](../validate-part.md), data: TypedData): [ValidationEnvironment](../-validation-environment/index.md)  <br>More info  <br>Validates part of type [P](../validate-part.md).  <br><br><br>

