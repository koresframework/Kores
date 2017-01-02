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

import com.github.jonathanxd.codeapi.CodeElement;
import com.github.jonathanxd.codeapi.base.ModifiersHolder;

public class MemberInfo {
    private final CodeElement memberInstance;
    private boolean isAccessible;
    private CodeElement accessibleMember = null;

    MemberInfo(CodeElement memberInstance, boolean isAccessible) {
        this.memberInstance = memberInstance;
        this.isAccessible = isAccessible;
    }

    public static MemberInfo ofAccessible(CodeElement element) {
        return new MemberInfo(element, true);
    }

    public static MemberInfo ofInaccessible(CodeElement element) {
        return new MemberInfo(element, false);
    }

    public static MemberInfo of(CodeElement element, boolean isAccessible) {
        return new MemberInfo(element, isAccessible);
    }

    public static <T extends CodeElement & ModifiersHolder> MemberInfo of(T element) {
        return MemberInfo.of(element, !element.getModifiers().contains(CodeModifier.PRIVATE));
    }

    public CodeElement getMemberInstance() {
        return this.memberInstance;
    }

    public CodeElement getAccessibleMember() {
        return this.accessibleMember;
    }

    public void setAccessibleMember(CodeElement accessibleMember) {

        if (this.accessibleMember != null)
            throw new IllegalStateException("Accessible member already defined.");

        this.accessibleMember = accessibleMember;
    }

    public boolean isAccessible() {
        return this.isAccessible;
    }

    public boolean hasAccessibleMember() {
        return this.getAccessibleMember() != null;
    }
}
