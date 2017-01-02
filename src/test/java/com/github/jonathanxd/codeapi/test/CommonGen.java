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

/**
 * Created by jonathan on 18/05/16.
 */
public class CommonGen {
/*
    public static final String name = CommonGen.class.getCanonicalName() + "_Generated";

    public static CodeSource gen() {
        CodeArgument[] values = {
                new CodeArgument(STRING("A"), PredefinedTypes.STRING), new CodeArgument(STRING("B"), PredefinedTypes.STRING),
                new CodeArgument(STRING("C"), PredefinedTypes.STRING), new CodeArgument(STRING("D"), PredefinedTypes.STRING),
                new CodeArgument(STRING("E"), PredefinedTypes.STRING)
        };

        CodeArgument[] values2 = {
                new CodeArgument(STRING("F"), PredefinedTypes.STRING), new CodeArgument(STRING("G"), PredefinedTypes.STRING),
                new CodeArgument(STRING("H"), PredefinedTypes.STRING), new CodeArgument(STRING("I"), PredefinedTypes.STRING),
                new CodeArgument(STRING("J"), PredefinedTypes.STRING)
        };

        CodeArgument[] values3 = {
                new CodeArgument(INT(1), PredefinedTypes.INT)
        };

        CodeClass codeClass = aClass(PUBLIC, name, source(
                constructor(PUBLIC, source(
                        new CodeField("array", PredefinedTypes.STRING.toArray(2),
                                Helper.invokeArrayConstructor(PredefinedTypes.STRING, new CodePart[]{INT(2), INT(5)}, new CodeArgument[]{
                                        argument(Helper.invokeArrayConstructor(PredefinedTypes.STRING, new CodePart[]{INT(5)}, values), PredefinedTypes.STRING.toArray(1)),
                                        argument(Helper.invokeArrayConstructor(PredefinedTypes.STRING, new CodePart[]{INT(5)}, values2), PredefinedTypes.STRING.toArray(1)),
                                })),
                        new CodeField("array2", PredefinedTypes.STRING.toArray(1), Helper.invokeArrayConstructor(PredefinedTypes.STRING.toArray(1), new CodePart[]{INT(0)}, new CodeArgument[]{})),
                        new CodeField("array3", PredefinedTypes.OBJECT.toArray(1), Helper.invokeArrayConstructor(PredefinedTypes.OBJECT, new CodePart[]{INT(1)}, values3)),

                        Predefined.invokePrintln(new CodeArgument(
                                Helper.accessArrayValue(PredefinedTypes.STRING.toArray(1),
                                Helper.accessArrayValue(PredefinedTypes.STRING.toArray(2),
                                        Helper.accessLocalVariable(
                                                "array",
                                                PredefinedTypes.STRING.toArray(2)
                                        ),
                                        INT(0),
                                        PredefinedTypes.STRING.toArray(1)
                                ),
                                INT(0),
                                PredefinedTypes.STRING),
                                PredefinedTypes.STRING))


                ))
        ));


        return sourceOfParts(codeClass);
    }
*/
}
