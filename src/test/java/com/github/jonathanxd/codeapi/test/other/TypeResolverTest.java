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
package com.github.jonathanxd.codeapi.test.other;

import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.type.CodeTypeResolver;
import com.github.jonathanxd.codeapi.type.TypeRef;
import com.github.jonathanxd.codeapi.util.CodeTypes;
import com.github.jonathanxd.codeapi.util.ImplicitCodeType;
import com.github.jonathanxd.codeapi.util.conversion.TypeStructureKt;
import com.github.jonathanxd.iutils.collection.Collections3;
import com.github.jonathanxd.iutils.object.Either;
import com.github.jonathanxd.iutils.object.specialized.EitherObjBoolean;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

import kotlin.jvm.functions.Function1;

public class TypeResolverTest {

    @Test
    public void typeResolverTest() {
        TypeDeclaration basex = ClassDeclaration.Builder.Companion.builder()
                .modifiers(CodeModifier.PUBLIC)
                .qualifiedName("com.BaseX")
                .superClass(Types.OBJECT)
                .implementations(CodeTypes.getCodeType(BaseExt.class))
                .build();

        TypeDeclaration typeDeclaration = ClassDeclaration.Builder.Companion.builder()
                .modifiers(CodeModifier.PUBLIC)
                .qualifiedName("com.TypeResolverTest")
                .superClass(basex)
                .build();


        CodeTypeResolver<?> defaultResolver = typeDeclaration.getDefaultResolver();

        Assert.assertTrue(defaultResolver.isAssignableFrom(CodeTypes.getCodeType(Base.class), typeDeclaration).getRight());
        Assert.assertTrue(defaultResolver.isAssignableFrom(CodeTypes.getCodeType(BaseExt.class), typeDeclaration).getRight());
        Assert.assertTrue(defaultResolver.isAssignableFrom(CodeTypes.getCodeType(Base.class), CodeTypes.getCodeType(BaseExt.class)).getRight());
        Assert.assertTrue(defaultResolver.isAssignableFrom(basex, typeDeclaration).getRight());
    }

    @Test
    public void multiResolver() {

        TypeRef typeRef = new TypeRef("com.Worktable", false);

        CodeTypeResolver.Multi<Type> resolver = new CodeTypeResolver.Multi<>();

        CodeTypeResolver.Java java = new CodeTypeResolver.Java(ClassLoader.getSystemClassLoader());
        resolver.addResolver(java);
        resolver.addResolver(CodeTypeResolver.DefaultResolver.INSTANCE);
        resolver.addResolver(new CodeTypeResolver<Type>() {
            @NotNull
            @Override
            public Either<Exception, Type> resolve(@NotNull Type type) {
                return Either.right(null);
            }

            @NotNull
            @Override
            public Either<Exception, Type> getSuperclass(@NotNull Type type) {
                return Either.right(null);
            }

            @NotNull
            @Override
            public Either<Exception, List<Type>> getInterfaces(@NotNull Type type) {
                return Either.right(Collections3.listOf(String.class));
            }

            @NotNull
            @Override
            public EitherObjBoolean<Exception> isAssignableFrom(@NotNull Type type, @NotNull Type from) {
                return CodeTypeResolver.DefaultImpls.isAssignableFrom(this, type, from);
            }

            @NotNull
            @Override
            public EitherObjBoolean<Exception> isAssignableFrom(@NotNull Type type, @NotNull Type from, @NotNull Function1<? super Type, ? extends CodeTypeResolver<?>> resolverProvider) {
                return EitherObjBoolean.right(ImplicitCodeType.is(Boolean.TYPE, from));
            }

            @NotNull
            @Override
            public Either<Exception, List<ConstructorDeclaration>> resolveConstructors(@NotNull Type type) {
                return CodeTypeResolver.DefaultImpls.resolveConstructors(this, type);
            }

            @NotNull
            @Override
            public Either<Exception, List<FieldDeclaration>> resolveFields(@NotNull Type type) {
                return CodeTypeResolver.DefaultImpls.resolveFields(this, type);
            }

            @NotNull
            @Override
            public Either<Exception, List<MethodDeclaration>> resolveMethods(@NotNull Type type) {
                return CodeTypeResolver.DefaultImpls.resolveMethods(this, type);
            }

            @NotNull
            @Override
            public Either<Exception, TypeDeclaration> resolveTypeDeclaration(@NotNull Type type) {
                if (ImplicitCodeType.is(Boolean.TYPE, type)) {
                    return Either.right(TypeStructureKt.getTypeDeclaration(Boolean.class));
                }

                return Either.left(new IllegalArgumentException(type.toString()));
            }
        });

        Assert.assertTrue(resolver.isAssignableFrom(typeRef, Boolean.TYPE).getRight());
        Assert.assertTrue(ImplicitCodeType.is(typeRef, resolver.resolve(typeRef).getRight()));
        Assert.assertTrue(resolver.getInterfaces(typeRef).getRight().size() == 1);
        Assert.assertTrue(resolver.getSuperclass(typeRef).getRight() == null);


    }

    interface Base {

    }

    interface BaseExt extends Base {

    }
}
