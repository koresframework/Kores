/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.common

import com.github.jonathanxd.codeapi.CodeElement
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.base.FieldDeclaration
import com.github.jonathanxd.codeapi.base.MethodDeclaration
import com.github.jonathanxd.codeapi.base.ModifiersHolder
import com.github.jonathanxd.codeapi.base.TypeDeclaration
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.iutils.description.Description
import com.github.jonathanxd.iutils.description.ElementType

class MemberInfo private constructor(val memberInstance: CodeElement, val isAccessible: Boolean, val description: Description) {

    var accessibleMember: CodeElement? = null
        set(accessibleMember) {

            if (this.accessibleMember != null)
                throw IllegalStateException("Accessible member already defined.")

            field = accessibleMember
        }

    fun hasAccessibleMember(): Boolean {
        return this.accessibleMember != null
    }

    companion object {

        fun ofAccessible(root: TypeDeclaration?, element: CodeElement): MemberInfo {
            return MemberInfo(element, true, this.getDescription(root, element))
        }

        fun ofInaccessible(root: TypeDeclaration?, element: CodeElement): MemberInfo {
            return MemberInfo(element, false, this.getDescription(root, element))
        }

        fun of(root: TypeDeclaration?, element: CodeElement, isAccessible: Boolean): MemberInfo {
            return MemberInfo(element, isAccessible, this.getDescription(root, element))
        }

        fun <T> of(root: TypeDeclaration?, element: T): MemberInfo where T : CodeElement, T : ModifiersHolder {
            return MemberInfo.of(root, element, !element.modifiers.contains(CodeModifier.PRIVATE))
        }

        fun getDescription(root: TypeDeclaration?, element: CodePart): Description {

            return when(element) {
                is FieldDeclaration -> Description(root!!.getDescName(), element.name, emptyArray(), element.type.getDescName(), ElementType.FIELD)
                is MethodDeclaration -> Description(root!!.getDescName(), element.name, element.parameters.getDescName(), element.type.getDescName(), ElementType.METHOD)
                is TypeDeclaration -> Description(element.getDescName(), "", emptyArray(), "", ElementType.CLASS)
                else -> throw IllegalArgumentException("Element must be a Field, Method or Type Declaration. Provided element: $element")
            }
        }

        @Suppress("NOTHING_TO_INLINE")
        private inline fun CodeType.getDescName() = "L${this.canonicalName};"

        @Suppress("NOTHING_TO_INLINE")
        private inline fun List<CodeParameter>.getDescName() = this.map { it.type.getDescName() }.toTypedArray()
    }
}
