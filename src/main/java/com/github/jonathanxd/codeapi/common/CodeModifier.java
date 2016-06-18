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
package com.github.jonathanxd.codeapi.common;

import com.github.jonathanxd.codeapi.CodePart;

import org.objectweb.asm.Opcodes;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static com.github.jonathanxd.codeapi.common.ModifierType.ABSTRACTION;
import static com.github.jonathanxd.codeapi.common.ModifierType.CONCURRENCY;
import static com.github.jonathanxd.codeapi.common.ModifierType.OTHER;
import static com.github.jonathanxd.codeapi.common.ModifierType.SERIALIZATION;
import static com.github.jonathanxd.codeapi.common.ModifierType.VISIBILITY;
import static org.objectweb.asm.Opcodes.*;

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

        Collection<CodeModifier> collection = extractModifiers(modifiers);

        if (member.getDeclaringClass().isInterface() && (Modifier.isPublic(modifiers) && !Modifier.isAbstract(modifiers) && !Modifier.isStatic(modifiers))) {
            collection.add(DEFAULT);
        }


        return collection;
    }

    public static Collection<CodeModifier> extractModifiers(int modifiers) {
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
        return collection != null ? collection.stream().sorted().map(CodeModifier::getExpr).collect(Collectors.joining(" ")) : "";
    }

    public static int toJavaModifier(Collection<CodeModifier> modifiers) {
        int end = 0;

        for (CodeModifier modifier : modifiers) {
            int toJavaModifier = toJavaModifier(modifier);

            if(toJavaModifier != 0) {
                end |= toJavaModifier;
            }
        }

        return end;
    }

    public static int toJavaModifier(CodeModifier codeModifier) {
        switch (codeModifier) {
            case ABSTRACT: return Modifier.ABSTRACT;
            case FINAL: return Modifier.FINAL;
            case NATIVE: return Modifier.NATIVE;
            case PRIVATE: return Modifier.PRIVATE;
            case PROTECTED: return Modifier.PROTECTED;
            case PUBLIC: return Modifier.PUBLIC;
            case STATIC: return Modifier.STATIC;
            case STRICTFP: return Modifier.STRICT;
            case SYNCHRONIZED: return Modifier.SYNCHRONIZED;
            case TRANSIENT: return Modifier.TRANSIENT;
            case VOLATILE: return Modifier.VOLATILE;
            default: return 0;
        }
    }

    public static int toAsmAccess(Collection<CodeModifier> modifiers) {
        int end = 0;

        for (CodeModifier modifier : modifiers) {
            int toAsmAccess = toAsmAccess(modifier);

            if(toAsmAccess != 0) {
                end |= toAsmAccess;
            }
        }

        return end;
    }

    public static int toAsmAccess(CodeModifier codeModifier) {
        switch (codeModifier) {
            case ABSTRACT: return ACC_ABSTRACT;
            case FINAL: return ACC_FINAL;
            case NATIVE: return ACC_NATIVE;
            case PRIVATE: return ACC_PRIVATE;
            case PROTECTED: return ACC_PROTECTED;
            case PUBLIC: return ACC_PUBLIC;
            case STATIC: return ACC_STATIC;
            case STRICTFP: return ACC_STRICT;
            case SYNCHRONIZED: return ACC_SYNCHRONIZED;
            case TRANSIENT: return ACC_TRANSIENT;
            case VOLATILE: return ACC_VOLATILE;
            default: return 0;
        }
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
