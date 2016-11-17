package com.github.jonathanxd.codeapi.builder

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.common.CodeArgument
import com.github.jonathanxd.codeapi.common.InvokeType
import com.github.jonathanxd.codeapi.common.MethodType
import com.github.jonathanxd.codeapi.common.TypeSpec
import com.github.jonathanxd.codeapi.helper.Helper
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation
import com.github.jonathanxd.codeapi.types.CodeType

class InvocationBuilder private constructor() {

    /**
     * Invocation type. **Required**
     */
    lateinit var invokeType: InvokeType

    /**
     * Localization of the type. If defined to null, CodeAPI will use enclosing class.
     */
    var localization: CodeType? = null

    /**
     * Target of method invocation. This value can only be defined to null if [invokeType] is
     * [InvokeType.INVOKE_STATIC] or [InvokeType.INVOKE_DYNAMIC].
     */
    var target: CodePart? = null

    /**
     * Method Signature Specification. **Required*
     */
    lateinit var spec: TypeSpec

    /**
     * Name of the method. **Required**
     */
    lateinit var methodName: String

    /**
     * Arguments to pass to method.
     */
    var arguments = mutableListOf<CodeArgument>()

    /**
     * Is the method a constructor of the super class. (Only works in constructors).
     */
    var isSuperConstructor: Boolean = false

    // Helper methods
    fun setLocalization(klass: Class<*>) {
        this.localization = CodeAPI.toCodeType(klass);
    }

    fun setArguments(vararg arguments: CodeArgument) {
        this.arguments = arguments.toMutableList()
    }

    fun build(): MethodInvocation {
        return Helper.invoke(this.invokeType, this.localization, this.target,
                MethodSpecImpl(
                        this.methodName,
                        this.spec,
                        this.arguments,
                        if (this.isSuperConstructor)
                            MethodType.SUPER_CONSTRUCTOR
                        else
                            null
                ))
    }

    companion object {
        @JvmStatic
        fun invocation(init: InvocationBuilder.() -> Unit): MethodInvocation {
            return InvocationBuilder().let {
                init(it)
                it.build()
            }
        }
    }
}