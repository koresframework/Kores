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
package com.github.jonathanxd.codeapi.builder;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.util.BiMultiVal;

public class IfExpressionHelper {

    private BiMultiVal.Adder<CodePart, IfExpr, Operator> adder = CodeAPI.ifExprs();

    private IfExpressionHelper() {
    }

    public static IfExpressionHelper builder() {
        return new IfExpressionHelper();
    }

    public IfExpressionHelper check(CodePart part1, Operator operation, CodePart part2) {
        this.adder = this.adder.add1(CodeAPI.check(part1, operation, part2));
        return this;
    }

    public IfExpressionHelper checkRefEqual(CodePart part1, CodePart part2) {
        this.adder = this.adder.add1(CodeAPI.check(part1, Operators.EQUAL_TO, part2));
        return this;
    }

    public IfExpressionHelper checkObjectEqual(CodePart part1, CodePart part2) {
        return this.checkTrue(
                CodeAPI.invokeVirtual(Object.class, part1, "equals",
                        CodeAPI.typeSpec(PredefinedTypes.BOOLEAN, PredefinedTypes.OBJECT),
                        CodeAPI.argument(part2))
        );
    }

    public IfExpressionHelper checkNotNull(CodePart part1) {
        this.adder = this.adder.add1(CodeAPI.checkNotNull(part1));
        return this;
    }

    public IfExpressionHelper checkNull(CodePart part1) {
        this.adder = this.adder.add1(CodeAPI.checkNull(part1));
        return this;
    }

    public IfExpressionHelper checkTrue(CodePart part1) {
        this.adder = this.adder.add1(CodeAPI.checkTrue(part1));
        return this;
    }

    public IfExpressionHelper checkFalse(CodePart part1) {
        this.adder = this.adder.add1(CodeAPI.checkFalse(part1));
        return this;
    }

    // And
    public IfExpressionHelper and(CodePart part1, Operator operation, CodePart part2) {

        this.adder = this.adder.add2(Operators.AND);

        return this.check(part1, operation, part2);
    }

    public IfExpressionHelper andRefEqual(CodePart part1, CodePart part2) {

        this.adder = this.adder.add2(Operators.AND);

        return this.checkRefEqual(part1, part2);
    }

    public IfExpressionHelper andObjectEqual(CodePart part1, CodePart part2) {

        this.adder = this.adder.add2(Operators.AND);

        return this.checkObjectEqual(part1, part2);
    }

    public IfExpressionHelper andNotNull(CodePart part1) {

        this.adder = this.adder.add2(Operators.AND);

        return this.checkNotNull(part1);
    }

    public IfExpressionHelper andNull(CodePart part1) {

        this.adder = this.adder.add2(Operators.AND);

        return this.checkNull(part1);
    }

    public IfExpressionHelper andTrue(CodePart part1) {

        this.adder = this.adder.add2(Operators.AND);

        return this.checkTrue(part1);
    }

    public IfExpressionHelper andFalse(CodePart part1) {

        this.adder = this.adder.add2(Operators.AND);

        return this.checkFalse(part1);
    }

    // Or
    public IfExpressionHelper or(CodePart part1, Operator operation, CodePart part2) {

        this.adder = this.adder.add2(Operators.OR);

        return this.check(part1, operation, part2);
    }

    public IfExpressionHelper orRefEqual(CodePart part1, CodePart part2) {

        this.adder = this.adder.add2(Operators.OR);

        return this.checkRefEqual(part1, part2);
    }

    public IfExpressionHelper orObjectEqual(CodePart part1, CodePart part2) {

        this.adder = this.adder.add2(Operators.OR);

        return this.checkObjectEqual(part1, part2);
    }

    public IfExpressionHelper orNotNull(CodePart part1) {

        this.adder = this.adder.add2(Operators.OR);

        return this.checkNotNull(part1);
    }

    public IfExpressionHelper orNull(CodePart part1) {

        this.adder = this.adder.add2(Operators.OR);

        return this.checkNull(part1);
    }

    public IfExpressionHelper orTrue(CodePart part1) {

        this.adder = this.adder.add2(Operators.OR);

        return this.checkTrue(part1);
    }

    public IfExpressionHelper orFalse(CodePart part1) {

        this.adder = this.adder.add2(Operators.OR);

        return this.checkFalse(part1);
    }

    // Build
    public BiMultiVal<CodePart, IfExpr, Operator> build() {
        return this.adder.make();
    }
}
