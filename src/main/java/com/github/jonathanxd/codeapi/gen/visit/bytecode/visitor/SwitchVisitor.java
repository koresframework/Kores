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
package com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.common.Flow;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.common.SwitchType;
import com.github.jonathanxd.codeapi.common.SwitchTypes;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.gen.visit.VoidVisitor;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CaseImpl;
import com.github.jonathanxd.codeapi.impl.IfBlockImpl;
import com.github.jonathanxd.codeapi.interfaces.Case;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.Switch;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.BiMultiVal;
import com.github.jonathanxd.codeapi.util.gen.CodePartUtil;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SwitchVisitor implements VoidVisitor<Switch, BytecodeClass, MVData>, Opcodes {
    @Override
    public void voidVisit(Switch aSwitch, MapData extraData, VisitorGenerator<BytecodeClass> visitorGenerator, MVData mvData) {

        SwitchType switchType = aSwitch.getSwitchType();

        if (switchType != SwitchTypes.NUMERIC) {
            if (!switchType.isUnique()) {
                aSwitch = this.insertEqualityCheck(aSwitch);
            }

            Switch generate = aSwitch.getSwitchType().getGenerator().generate(aSwitch);

            visitorGenerator.generateTo(Switch.class, generate, extraData, mvData);
        } else {
            MethodVisitor mv = mvData.getMethodVisitor();

            CodePart value = aSwitch.getValue().orElseThrow(NullPointerException::new);

            visitorGenerator.generateTo(value.getClass(), value, extraData, mvData);

            List<Case> originCaseList = aSwitch.getCases();
            List<Case> filteredCaseList = originCaseList.stream()
                    .filter(Case::isNotDefault)
                    .sorted((o1, o2) -> this.getInt(o1) - this.getInt(o2)) // or Integer.compare(this.getInt(o1), this.getInt(o2))
                    .collect(Collectors.toList());

            boolean useLookupSwitch = this.useLookupSwitch(filteredCaseList);

            Label outsideStart = new Label();
            Label insideStart = new Label();
            Label outsideEnd = new Label();


            Label defaultLabel = new Label();


            Flow flow = new Flow(outsideStart, insideStart, defaultLabel, outsideEnd);

            extraData.registerData(ConstantDatas.FLOW_TYPE_INFO, flow);

            mv.visitLabel(outsideStart);

            Label[] labels;

            if (!useLookupSwitch) {
                int min = this.getMin(filteredCaseList);
                int max = this.getMax(filteredCaseList);

                filteredCaseList = this.fill(min, max, filteredCaseList);

                labels = this.toLabel(filteredCaseList, defaultLabel);

                min = this.getMin(filteredCaseList);
                max = this.getMax(filteredCaseList);

                mv.visitTableSwitchInsn(min, max, defaultLabel, labels);

            } else {
                labels = this.toLabel(filteredCaseList, defaultLabel);

                int[] keys = filteredCaseList.stream().mapToInt(this::getInt).toArray();

                mv.visitLookupSwitchInsn(defaultLabel, keys, labels);
            }

            mv.visitLabel(insideStart);
            // Generate Case code

            for (int i = 0; i < labels.length; i++) {
                Label label = labels[i];
                Case aCase = filteredCaseList.get(i);

                if (aCase instanceof EmptyCase)
                    continue;

                mv.visitLabel(label);

                visitorGenerator.generateTo(CodeSource.class, aCase.getBody().orElseThrow(NullPointerException::new), extraData, mvData);
            }

            // /Generate Case code
            mv.visitLabel(defaultLabel);

            extraData.unregisterData(ConstantDatas.FLOW_TYPE_INFO, flow);

            Case aDefault = this.getDefault(originCaseList);

            CodeSource codeSource = aDefault.getBody().orElse(CodeSource.empty());

            visitorGenerator.generateTo(CodeSource.class, codeSource, extraData, mvData);


            mv.visitLabel(outsideEnd);
        }
    }

    public Label[] toLabel(List<Case> caseList, Label defaultLabel) {
        return caseList.stream().map($ -> $ instanceof EmptyCase ? defaultLabel : new Label()).toArray(Label[]::new);
    }

    public Case getDefault(List<Case> caseList) {
        return caseList.stream().filter(Case::isDefault).findFirst().orElse(CodeAPI.caseDefault(CodeAPI.sourceOfParts()));
    }

    /**
     * Fill the case list.
     */
    private List<Case> fill(int min, int max, List<Case> caseList) {

        List<Case> filledCases = new ArrayList<>();

        for (int i = min; i < max + 1; i++) {
            Case aCase = this.getCase(caseList, i);

            if (aCase != null) {
                filledCases.add(aCase);
            } else {
                filledCases.add(new EmptyCase(Literals.INT(i), null));
            }
        }

        return filledCases;
    }

    private Case getCase(List<Case> caseList, int i) {
        for (Case aCase : caseList) {
            if (this.getInt(aCase) == i)
                return aCase;
        }

        return null;
    }

    private int getMin(List<Case> caseList) {
        int last = Integer.MAX_VALUE;

        for (Case aCase : caseList) {
            if (!aCase.isDefault()) {
                Literals.IntLiteral intLiteral = aCase.getValue().map(codePart -> (Literals.IntLiteral) codePart).orElseThrow(NullPointerException::new);
                int i = Integer.parseInt(intLiteral.getName());

                if (i < last)
                    last = i;
            }
        }

        return last;
    }

    private int getMax(List<Case> caseList) {
        int last = 0;

        for (Case aCase : caseList) {
            if (!aCase.isDefault()) {
                Literals.IntLiteral intLiteral = aCase.getValue().map(codePart -> (Literals.IntLiteral) codePart).orElseThrow(NullPointerException::new);
                int i = Integer.parseInt(intLiteral.getName());

                if (i > last)
                    last = i;
            }
        }

        return last;
    }

    private int getCasesToFill(List<Case> caseList) {
        int min = this.getMin(caseList);
        int max = this.getMax(caseList);

        int size = caseList.size() - 1;

        return (max - (min + size));
    }

    /**
     * Based on java sources.
     */
    private boolean useLookupSwitch(List<Case> caseList) {

        int casesToFill = this.getCasesToFill(caseList);
        int labels = caseList.size();

        long tableSpaceCost = 4 * casesToFill;
        int tableTimeCost = 3;
        long lookupSpaceCost = 3 + 2 * labels;

        // If lookup cost < table cost.
        return lookupSpaceCost + 3 * labels < tableSpaceCost + 3 * tableTimeCost;
    }

    private int getInt(Case aCase) {
        if (aCase.isDefault())
            return -1;

        return Integer.parseInt(aCase.getValue().map(codePart -> (Literals.IntLiteral) codePart).orElseThrow(NullPointerException::new).getName());
    }

    private Switch insertEqualityCheck(Switch aSwitch) {
        CodePart switchValue = aSwitch.getValue().orElseThrow(NullPointerException::new);

        if (((Typed) switchValue).getType().orElseThrow(NullPointerException::new).is(PredefinedTypes.INT))
            return aSwitch;

        return aSwitch.setCases(aSwitch.getCases().stream().map(aCase -> {

            if (aCase.isDefault())
                return aCase;

            CodeSource codeSource = aCase.getBody().orElse(null);

            if (codeSource != null) {
                CodePart caseValue = aCase.getValue().orElseThrow(NullPointerException::new);

                CodeType type = CodePartUtil.getType(caseValue);

                if (type.is(PredefinedTypes.INT))
                    return aCase;

                return aCase.setBody(CodeAPI.sourceOfParts(
                        new SwitchIfBlock(codeSource,
                                Collections.singletonList(CodeAPI.checkTrue(
                                        CodeAPI.invokeVirtual(Object.class, switchValue, "equals",
                                                CodeAPI.typeSpec(PredefinedTypes.BOOLEAN, PredefinedTypes.OBJECT),
                                                CodeAPI.argument(caseValue)
                                        )
                                )))
                ));
            }

            return aCase;
        }).collect(Collectors.toList()));
    }

    @GenerateTo(IfBlock.class)
    static class SwitchIfBlock extends IfBlockImpl {

        public SwitchIfBlock(CodeSource body, List<CodePart> ifExprs) {
            super(body, ifExprs, null);
        }

        public SwitchIfBlock(CodeSource body, BiMultiVal<CodePart, IfExpr, Operator> ifExpressions) {
            super(body, ifExpressions, null);
        }
    }

    private static class EmptyCase extends CaseImpl {

        public EmptyCase(Typed value, CodeSource body) {
            super(value, body);
        }
    }
}
