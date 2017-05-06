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
package com.github.jonathanxd.codeapi.test;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.comment.Comments;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.common.MethodTypeSpec;
import com.github.jonathanxd.codeapi.factory.CommentsFactory;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.util.CodeTypes;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import org.junit.Test;

import java.io.PrintStream;
import java.util.EnumSet;

public class CommentClassTest_ {
    //

    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {

        MethodTypeSpec indexOfMethodSpec = new MethodTypeSpec(Types.STRING, "indexOf", Factories.typeSpec(Types.INT, Types.INT, Types.INT));

        /*
         * Comment test class. {@link String#indexOf(int, int) Test Method Link}
         */
        Comments comments = CommentsFactory.documentation(
                CommentsFactory.plain("Comment test class. "),
                CommentsFactory.linkMethod("Test Method Link", indexOfMethodSpec)
        );


        TypeDeclaration myCl = ClassDeclaration.Builder.Companion.builder()
                .withComments(comments)
                .withModifiers(EnumSet.of(CodeModifier.PUBLIC))
                .withQualifiedName("com.MyClass")
                .withSuperClass(Types.OBJECT)
                .withBody(CodeSource.fromVarArgs(
                        FieldDeclaration.Builder.Companion.builder()
                                .withComments(CommentsFactory.documentation(CommentsFactory.code(Predefined.invokePrintlnStr(Literals.STRING("Hello world")))))
                                .withModifiers(CodeModifier.PRIVATE, CodeModifier.FINAL)
                                .withName("fieldi")
                                .withType(Types.STRING)
                                .withValue(Literals.STRING("field"))
                                .build(),
                        MethodDeclaration.Builder.builder()
                                .withComments(
                                        CommentsFactory.documentation(
                                                CommentsFactory.plain("Print "),
                                                CommentsFactory.linkField("'fieldi' value", "com.MyClass", "fieldi", Types.STRING),
                                                CommentsFactory.plain(" to "),
                                                CommentsFactory.linkField("java.lang.System", "out", CodeTypes.getCodeType(PrintStream.class)),
                                                CommentsFactory.plain(".")
                                        )
                                )
                                .withModifiers(CodeModifier.PUBLIC)
                                .withReturnType(Types.VOID)
                                .withName("printFieldi")
                                .withBody(CodeSource.fromVarArgs(
                                        CommentsFactory.comments(CommentsFactory.plain("Prints 'fieldi' value")),
                                        Predefined.invokePrintlnStr(Factories.accessThisField(Types.STRING, "fieldi"))
                                ))
                                .build()
                ))
                .build();


        return Pair.of(myCl, CodeSource.fromVarArgs(myCl));
    }

    @Test
    public void test() {
        $();
    }

}
