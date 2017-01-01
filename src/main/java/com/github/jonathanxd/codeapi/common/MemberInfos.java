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
package com.github.jonathanxd.codeapi.common;

import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.util.element.ElementUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Cached member info for fast access.
 */
public class MemberInfos {

    private final TypeDeclaration declaration;
    private final List<MemberInfo> memberInfoList = new ArrayList<>();
    private final List<MemberInfo> memberInfoList_ = Collections.unmodifiableList(this.memberInfoList);

    public MemberInfos(TypeDeclaration declaration) {
        this.declaration = declaration;
    }

    public boolean put(MemberInfo codeElement) {
        return this.memberInfoList.add(codeElement);
    }

    public MemberInfo find(Predicate<MemberInfo> memberInfoPredicate) {
        return this.getMemberInfoList().stream().filter(memberInfoPredicate).findFirst().orElse(null);
    }

    public MemberInfo find(MethodSpecification methodSpecification) {
        return this.find(memberInfo ->
                memberInfo.getMemberInstance() instanceof MethodDeclaration
                        && ElementUtil.equal((MethodDeclaration) memberInfo.getMemberInstance(), methodSpecification));
    }

    public MemberInfo find(VariableAccess access) {
        return this.find(memberInfo ->
                memberInfo.getMemberInstance() instanceof FieldDeclaration
                        && ElementUtil.equal((FieldDeclaration) memberInfo.getMemberInstance(), access));
    }

    public List<MemberInfo> getMemberInfoList() {
        return this.memberInfoList_;
    }

    public TypeDeclaration getDeclaration() {
        return this.declaration;
    }
}
