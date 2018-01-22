/*
 *      CodeAPI-DSL - Defines Kotlin DSL to create CodeAPI parts. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.dsl.test

import com.github.jonathanxd.codeapi.base.Access
import com.github.jonathanxd.codeapi.base.FieldAccess
import com.github.jonathanxd.codeapi.base.InvokeType
import com.github.jonathanxd.codeapi.base.MethodInvocation
import com.github.jonathanxd.codeapi.dsl.*
import org.junit.Assert
import org.junit.Test
import java.io.PrintStream

class DslTest {
    @Test
    fun test() {
        /*
        package com.mydomain.mypackage.MyClass;

        public class MyClass {
            public void hello() {
                System.out.println("Hello world");
            }
        }
         */

        val declaration = classDeclaration(
            name = "com.mydomain.mypackage.MyClass",
            methods = methods {
                +methodDeclaration(
                    name = "hello",
                    returnType = Void.TYPE,
                    body = codeSource {
                        +methodInvocation(
                            invokeType = InvokeType.INVOKE_VIRTUAL,
                            spec = methodTypeSpec(
                                localization = typeOf<PrintStream>(),
                                methodName = "println",
                                typeSpec = voidTypeSpec(typeOf<String>())
                            ),
                            target = fieldAccess(
                                target = Access.STATIC,
                                localization = typeOf<System>(),
                                type = typeOf<PrintStream>(),
                                name = "out"
                            ),
                            arguments = instructions { +"Hello world".toLiteral() }
                        )
                    }
                )
            }
        )

        Assert.assertEquals("com.mydomain.mypackage.MyClass", declaration.specifiedName)
        Assert.assertEquals(1, declaration.methods.size)
        Assert.assertEquals("hello", declaration.methods.first().name)
        Assert.assertEquals(Void.TYPE, declaration.methods.first().returnType)
        Assert.assertEquals(1, declaration.methods.first().body.size)
        Assert.assertTrue(declaration.methods.first().body.first() is MethodInvocation)

        val methodInvocation = declaration.methods.first().body.first() as MethodInvocation
        Assert.assertEquals(InvokeType.INVOKE_VIRTUAL, methodInvocation.invokeType)
        Assert.assertEquals(typeOf<PrintStream>(), methodInvocation.spec.localization)
        Assert.assertEquals("println", methodInvocation.spec.methodName)
        Assert.assertEquals(voidTypeSpec(typeOf<String>()), methodInvocation.spec.typeSpec)
        Assert.assertTrue(methodInvocation.target is FieldAccess)

        val access = methodInvocation.target as FieldAccess
        Assert.assertEquals(Access.STATIC, access.target)
        Assert.assertEquals(typeOf<System>(), access.localization)
        Assert.assertEquals(typeOf<PrintStream>(), access.type)
        Assert.assertEquals("out", access.name)

        Assert.assertEquals(1, methodInvocation.arguments.size)
        Assert.assertEquals("Hello world".toLiteral(), methodInvocation.arguments.first())
    }
}