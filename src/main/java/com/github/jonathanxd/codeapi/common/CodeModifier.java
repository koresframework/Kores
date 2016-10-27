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
import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_ANNOTATION;
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_ENUM;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_MANDATED;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ACC_STRICT;
import static org.objectweb.asm.Opcodes.ACC_SYNCHRONIZED;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;
import static org.objectweb.asm.Opcodes.ACC_TRANSIENT;
import static org.objectweb.asm.Opcodes.ACC_VARARGS;
import static org.objectweb.asm.Opcodes.ACC_VOLATILE;

/**
 * Modifiers Constants.
 */
public enum CodeModifier implements CodePart {

    PUBLIC(VISIBILITY), PROTECTED(VISIBILITY), PRIVATE(VISIBILITY), PACKAGE_PRIVATE("", VISIBILITY),
    ABSTRACT(ABSTRACTION), DEFAULT(ABSTRACTION),
    STATIC(OTHER), FINAL(OTHER),
    TRANSIENT(SERIALIZATION),
    VOLATILE(CONCURRENCY), SYNCHRONIZED(CONCURRENCY),
    NATIVE(OTHER), STRICTFP(OTHER),
    BRIDGE(OTHER), VARARGS(OTHER),
    SYNTHETIC(OTHER), ANNOTATION(OTHER),
    ENUM(OTHER), MANDATED(OTHER);

    /**
     * Name of the modifier (source code generation)
     */
    private final String expr;

    /**
     * Category of the modifier
     */
    private final ModifierType type;

    /**
     * Constructor
     *
     * @param type Category of the modifier
     */
    CodeModifier(ModifierType type) {
        this(null, type);
    }

    /**
     * Constructor
     *
     * @param expr Name of the modifier, or null to be the lower cased {@link Enum#name()}.
     * @param type Category of the enum.
     */
    CodeModifier(String expr, ModifierType type) {
        this.expr = expr;
        this.type = type;
    }

    /**
     * Extract modifiers from a {@link Member}
     *
     * @param member Member
     * @return Sorted Collection of modifiers
     */
    public static Collection<CodeModifier> extractModifiers(Member member) {

        int modifiers = member.getModifiers();

        Collection<CodeModifier> collection = extractModifiers(modifiers);

        if (member.getDeclaringClass().isInterface() && (Modifier.isPublic(modifiers) && !Modifier.isAbstract(modifiers) && !Modifier.isStatic(modifiers))) {
            collection.add(DEFAULT);
        }


        return collection;
    }

    /**
     * Extract modifiers from Java modifiers flags ({@link Modifier}).
     *
     * @param modifiers Modifiers flags.
     * @return Sorted Collection of modifiers.
     */
    public static Collection<CodeModifier> extractModifiers(int modifiers) {
        Collection<CodeModifier> collection = new TreeSet<>();

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

        if (Internal.isBridge(modifiers)) {
            collection.add(BRIDGE);
        }

        if (Internal.isVarArgs(modifiers)) {
            collection.add(VARARGS);
        }

        if (Internal.isSynthetic(modifiers)) {
            collection.add(SYNTHETIC);
        }

        if (Internal.isAnnotation(modifiers)) {
            collection.add(ANNOTATION);
        }

        if (Internal.isEnum(modifiers)) {
            collection.add(ENUM);
        }

        if (Internal.isMandated(modifiers)) {
            collection.add(MANDATED);
        }

        return collection;
    }

    /**
     * Modifiers to String
     *
     * @param collection Modifiers
     * @return String containing all modifiers name.
     */
    public static String toString(Collection<CodeModifier> collection) {
        return collection != null ? collection.stream().sorted().map(CodeModifier::getExpr).collect(Collectors.joining(" ")) : "";
    }

    /**
     * Convert {@link CodeModifier}s to Java Modifiers flags.
     *
     * @param modifiers Modifiers
     * @return Java modifiers flags ({@link Modifier})
     */
    public static int toJavaModifier(Collection<CodeModifier> modifiers) {
        int end = 0;

        for (CodeModifier modifier : modifiers) {
            int toJavaModifier = toJavaModifier(modifier);

            if (toJavaModifier != 0) {
                end |= toJavaModifier;
            }
        }

        return end;
    }

    /**
     * Convert a {@link CodeModifier} to Java Modifiers flags.
     *
     * @param codeModifier Modifier to convert
     * @return Java modifiers flags ({@link Modifier})
     */
    public static int toJavaModifier(CodeModifier codeModifier) {
        switch (codeModifier) {
            case ABSTRACT:
                return Modifier.ABSTRACT;
            case FINAL:
                return Modifier.FINAL;
            case NATIVE:
                return Modifier.NATIVE;
            case PRIVATE:
                return Modifier.PRIVATE;
            case PROTECTED:
                return Modifier.PROTECTED;
            case PUBLIC:
                return Modifier.PUBLIC;
            case STATIC:
                return Modifier.STATIC;
            case STRICTFP:
                return Modifier.STRICT;
            case SYNCHRONIZED:
                return Modifier.SYNCHRONIZED;
            case TRANSIENT:
                return Modifier.TRANSIENT;
            case VOLATILE:
                return Modifier.VOLATILE;
            case BRIDGE:
                return Internal.BRIDGE;
            case VARARGS:
                return Internal.VARARGS;
            case SYNTHETIC:
                return Internal.SYNTHETIC;
            case ANNOTATION:
                return Internal.ANNOTATION;
            case ENUM:
                return Internal.ENUM;
            case MANDATED:
                return Internal.MANDATED;
            default:
                return 0;
        }
    }

    /**
     * Convert {@link CodeModifier}s to asm modifiers
     *
     * @param modifiers Modifiers to convert
     * @return ASM modifiers flags
     */
    public static int toAsmAccess(Collection<CodeModifier> modifiers) {
        int end = 0;

        for (CodeModifier modifier : modifiers) {
            int toAsmAccess = toAsmAccess(modifier);

            if (toAsmAccess != 0) {
                end += toAsmAccess;
            }
        }

        return end;
    }

    /**
     * Convert a {@link CodeModifier} to asm modifiers
     *
     * @param codeModifier Modifier to convert
     * @return ASM modifiers flags
     */
    public static int toAsmAccess(CodeModifier codeModifier) {
        switch (codeModifier) {
            case ABSTRACT:
                return ACC_ABSTRACT;
            case FINAL:
                return ACC_FINAL;
            case NATIVE:
                return ACC_NATIVE;
            case PRIVATE:
                return ACC_PRIVATE;
            case PROTECTED:
                return ACC_PROTECTED;
            case PUBLIC:
                return ACC_PUBLIC;
            case STATIC:
                return ACC_STATIC;
            case STRICTFP:
                return ACC_STRICT;
            case SYNCHRONIZED:
                return ACC_SYNCHRONIZED;
            case TRANSIENT:
                return ACC_TRANSIENT;
            case VOLATILE:
                return ACC_VOLATILE;
            case BRIDGE:
                return ACC_BRIDGE;
            case VARARGS:
                return ACC_VARARGS;
            case SYNTHETIC:
                return ACC_SYNTHETIC;
            case ANNOTATION:
                return ACC_ANNOTATION;
            case ENUM:
                return ACC_ENUM;
            case MANDATED:
                return ACC_MANDATED;
            default:
                return 0;
        }
    }

    /**
     * Gets the Modifier category.
     *
     * @return Modifier category.
     */
    public ModifierType getType() {
        return this.type;
    }

    @Override
    public boolean isExpression() {
        return false;
    }

    public String getExpr() {
        return this.expr == null ? this.name().toLowerCase() : this.expr;
    }

    public static class Internal {
        public static final int BRIDGE = 0x00000040;
        public static final int VARARGS = 0x00000080;
        public static final int SYNTHETIC = 0x00001000;
        public static final int ANNOTATION = 0x00002000;
        public static final int ENUM = 0x00004000;
        public static final int MANDATED = 0x00008000;

        public static boolean isBridge(int modifiers) {
            return (modifiers & BRIDGE) != 0;
        }

        public static boolean isVarArgs(int modifiers) {
            return (modifiers & VARARGS) != 0;
        }

        public static boolean isSynthetic(int modifiers) {
            return (modifiers & SYNTHETIC) != 0;
        }

        public static boolean isAnnotation(int modifiers) {
            return (modifiers & ANNOTATION) != 0;
        }

        public static boolean isEnum(int modifiers) {
            return (modifiers & ENUM) != 0;
        }

        public static boolean isMandated(int modifiers) {
            return (modifiers & MANDATED) != 0;
        }
    }
}
