/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2016 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.util;

import com.github.jonathanxd.codeapi.CodePart;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static com.github.jonathanxd.codeapi.util.ModifierType.ABSTRACTION;
import static com.github.jonathanxd.codeapi.util.ModifierType.CONCURRENCY;
import static com.github.jonathanxd.codeapi.util.ModifierType.OTHER;
import static com.github.jonathanxd.codeapi.util.ModifierType.SERIALIZATION;
import static com.github.jonathanxd.codeapi.util.ModifierType.VISIBILITY;

/**
 * Created by jonathan on 07/05/16.
 */
public enum CodeModifier implements CodePart {
    PUBLIC(VISIBILITY), PROTECTED(VISIBILITY), PRIVATE(VISIBILITY), PACKAGE_PRIVATE("", VISIBILITY),
    ABSTRACT(ABSTRACTION),  DEFAULT(ABSTRACTION),
    STATIC(OTHER), FINAL(OTHER),
    TRANSIENT(SERIALIZATION),
    VOLATILE(CONCURRENCY), SYNCHRONIZED(CONCURRENCY),
    NATIVE(OTHER), STRICTFP(OTHER);

    private final String expr;
    private final ModifierType type;

    CodeModifier(ModifierType type) {
        this(null, type);
    }

    CodeModifier(String expr, ModifierType type) {
        this.expr = expr;
        this.type = type;
    }

    public static Collection<CodeModifier> extractModifiers(Member member) {

        int modifiers = member.getModifiers();

        Collection<CodeModifier> collection = from(modifiers);

        if (member.getDeclaringClass().isInterface() && (Modifier.isPublic(modifiers) && !Modifier.isAbstract(modifiers) && !Modifier.isStatic(modifiers))) {
            collection.add(DEFAULT);
        }


        return collection;
    }

    private static Collection<CodeModifier> from(int modifiers) {
        Collection<CodeModifier> collection = new TreeSet<CodeModifier>();

        if (Modifier.isPublic(modifiers)) {
            collection.add(PUBLIC);
        } else if (Modifier.isPrivate(modifiers)) {
            collection.add(PRIVATE);
        } else if (Modifier.isProtected(modifiers)) {
            collection.add(PROTECTED);
        } else {
            collection.add(PACKAGE_PRIVATE);
        }


        if (Modifier.isAbstract(modifiers)) {
            collection.add(ABSTRACT);
        }


        if (Modifier.isStatic(modifiers)) {
            collection.add(STATIC);
        }


        if (Modifier.isFinal(modifiers)) {
            collection.add(FINAL);
        }


        if (Modifier.isTransient(modifiers)) {
            collection.add(TRANSIENT);
        }


        if (Modifier.isVolatile(modifiers)) {
            collection.add(VOLATILE);
        }


        if (Modifier.isSynchronized(modifiers)) {
            collection.add(SYNCHRONIZED);
        }


        if (Modifier.isNative(modifiers)) {
            collection.add(NATIVE);
        }


        if (Modifier.isStrict(modifiers)) {
            collection.add(STRICTFP);
        }


        return collection;
    }

    public static String toString(Collection<CodeModifier> collection) {
        return collection.stream().sorted().map(CodeModifier::getExpr).collect(Collectors.joining(" "));
    }

    public ModifierType getType() {
        return type;
    }

    @Override
    public boolean isExpression() {
        return false;
    }

    public String getExpr() {
        return expr == null ? name().toLowerCase() : expr;
    }
}
