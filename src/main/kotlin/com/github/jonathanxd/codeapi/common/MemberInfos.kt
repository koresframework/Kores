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

import com.github.jonathanxd.codeapi.base.*
import com.github.jonathanxd.codeapi.util.element.ElementUtil
import java.util.*

/**
 * Cached member info for fast access.
 */
class MemberInfos(val declaration: TypeDeclaration) {
    private val memberInfoList = ArrayList<MemberInfo>()
    private val memberInfoList_ = Collections.unmodifiableList(this.memberInfoList)

    fun put(codeElement: MemberInfo): Boolean {
        return this.memberInfoList.add(codeElement)
    }

    fun find(memberInfoPredicate: (MemberInfo) -> Boolean): MemberInfo {
        return this.getMemberInfoList().stream().filter(memberInfoPredicate).findFirst().orElse(null)
    }

    fun find(methodSpecification: MethodSpecification): MemberInfo {
        return this.find { memberInfo -> memberInfo.memberInstance is MethodDeclaration && ElementUtil.equal(memberInfo.memberInstance, methodSpecification) }
    }

    fun find(access: VariableAccess): MemberInfo {
        return this.find { memberInfo -> memberInfo.memberInstance is FieldDeclaration && ElementUtil.equal(memberInfo.memberInstance, access) }
    }

    fun getMemberInfoList(): List<MemberInfo> {
        return this.memberInfoList_
    }
}
