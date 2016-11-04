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
package com.github.jonathanxd.codeapi.impl;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.common.SwitchType;
import com.github.jonathanxd.codeapi.interfaces.Case;
import com.github.jonathanxd.codeapi.interfaces.Switch;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @see Switch
 */
@GenerateTo(Switch.class)
public class SwitchImpl implements Switch {

    private final SwitchType switchType;
    private final Typed at;
    private final List<Case> cases;

    public SwitchImpl(SwitchType switchType, Typed at, List<Case> cases) {
        this.switchType = switchType;
        this.at = at;
        this.cases = cases == null ? Collections.emptyList() : Collections.unmodifiableList(cases);
    }

    @Override
    public SwitchType getSwitchType() {
        return this.switchType;
    }

    @Override
    public Switch setSwitchType(SwitchType switchType) {
        return new SwitchImpl(switchType, (Typed) this.getValue().orElse(null), this.getCases());
    }

    @Override
    public List<Case> getCases() {
        return this.cases;
    }

    @Override
    public Switch setCases(List<Case> caseList) {
        return new SwitchImpl(this.getSwitchType(), (Typed) this.getValue().orElse(null), caseList);
    }

    @Override
    public Optional<CodePart> getValue() {
        return Optional.ofNullable(this.at);
    }

    @Override
    public Switch setValue(CodePart value) {
        return new SwitchImpl(this.getSwitchType(), (Typed) value, this.getCases());
    }

    @Override
    public Optional<CodeType> getType() {
        return ((Typed) this.getValue().orElseThrow(NullPointerException::new)).getType();
    }

    @Override
    public Switch setType(CodeType codeType) {
        return this.setValue(((Typed) this.getValue().orElseThrow(NullPointerException::new)).setType(codeType));
    }

}
