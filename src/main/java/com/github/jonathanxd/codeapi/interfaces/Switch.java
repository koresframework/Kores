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
package com.github.jonathanxd.codeapi.interfaces;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.SwitchType;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.List;

/**
 * Java switch, this switch can switch numeric values and object values (like Enum, String or other
 * objects).
 *
 * If the {@link SwitchType#isUnique()} returns false, the CodeAPI will automatically generate a
 * {@link Object#equals(Object)} verification.
 *
 * For example, if you switch a String like that:
 *
 * <pre>
 *     {@code
 *
 *      switch(str) {
 *          case "A": println(": A");
 *          case "B": println(": B");
 *      }
 *
 *     }
 *
 * </pre>
 *
 * Will be converted into:
 *
 * <pre>
 *     {@code
 *
 *      switch(str) {
 *          case "A": if(str.equals("A")) println(": A");
 *          case "B": if(str.equals("B")) println(": B");
 *      }
 *
 *     }
 *
 * </pre>
 *
 * CodeAPI will not generate two "switches" like Javac do.
 *
 * You could also switch objects, but make sure that the object implements {@link Object#hashCode()}
 * and {@link Object#equals(Object)} methods.
 *
 * TODO: Generate bytecode
 */
public interface Switch extends Valuable, Typed, CodePart {

    /**
     * Gets the switch type.
     *
     * @return Switch type.
     */
    SwitchType getSwitchType();

    /**
     * Sets the switch type.
     *
     * @param switchType Switch type.
     * @return new instance.
     */
    Switch setSwitchType(SwitchType switchType);

    /**
     * Gets switch case list.
     *
     * @return Switch case list.
     */
    List<Case> getCases();

    /**
     * Sets the case list.
     *
     * @param caseList Case list.
     * @return New instance.
     */
    Switch setCases(List<Case> caseList);

    @Override
    Switch setValue(CodePart value);

    @Override
    Switch setType(CodeType codeType);

}
