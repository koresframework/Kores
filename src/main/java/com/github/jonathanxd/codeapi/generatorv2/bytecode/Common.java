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
package com.github.jonathanxd.codeapi.generatorv2.bytecode;

import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.interfaces.PackageDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.CodeArgument;
import com.github.jonathanxd.codeapi.util.CodeModifier;
import com.github.jonathanxd.codeapi.util.CodeParameter;
import com.github.jonathanxd.codeapi.util.Data;

import org.objectweb.asm.Opcodes;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class Common {

    public static int modifierToAsm(Collection<CodeModifier> codeModifiers) {
        return CodeModifier.toAsmAccess(codeModifiers);
    }

    public static int modifierToAsm(CodeInterface codeInterface) {
        int asm = CodeModifier.toAsmAccess(codeInterface.getModifiers());

        if (!(codeInterface instanceof CodeClass)) {
            asm |= Opcodes.ACC_INTERFACE;
        }

        return asm;
    }

    public static String getClassName(CodeInterface class_, Data data) {
        return class_.getType().replace('.', '/');
    }
    /*
    public static String getClassName(CodeInterface class_, Data data) {
        String className = class_.getJavaSpecName();

        Optional<PackageDeclaration<?>> optional = data.getOptionalCasted(PackageVisitor.PACKAGE_REPRESENTATION);

        if (optional.isPresent()) {
            className = optional.get().getPackage().get().replace('.', '/') + '/' + className;
        }

        return className;
    }*/

    public static String getClassName(CodeInterface class_, String package_) {
        String className = class_.getJavaSpecName();

        if (package_ != null) {
            className = package_.replace('.', '/') + '/' + className;
        }

        return className;
    }

    public static String specToAsm(MethodSpec methodSpec) {
        String s = codeTypeToSimpleAsm(methodSpec.getReturnType());

        return "(" + argumentssToAsm(methodSpec.getArguments()) + ")" + s;
    }

    public static String codeTypeToSimpleAsm(CodeType type) {
        return type.isPrimitive()
                ? primitiveCodeTypeToAsm(type)
                : type.getType().replace('.', '/');
    }

    public static String codeTypeToFullAsm(CodeType type) {
        return type.isPrimitive()
                ? primitiveCodeTypeToAsm(type)
                : "L" + type.getType().replace('.', '/') + ";";
    }

    private static String primitiveCodeTypeToAsm(CodeType type) {
        return type.getJavaSpecName();
    }

    public static String codeTypesToSimpleAsm(CodeType[] type) {

        StringBuilder sb = new StringBuilder();

        for (CodeType codeType : type) {
            sb.append(codeTypeToSimpleAsm(codeType));
        }

        return sb.toString();
    }

    public static String codeTypesToFullAsm(CodeType[] type) {
        StringBuilder sb = new StringBuilder();

        for (CodeType codeType : type) {
            sb.append(codeTypeToFullAsm(codeType));
        }

        return sb.toString();
    }

    public static CodeType getSuperClass(CodeInterface<?> codeInterface) {

        if (codeInterface instanceof CodeClass<?>) {

            return ((CodeClass<?>) codeInterface)
                    .getSuperType()
                    .orElse(Helper.getJavaType(Object.class));
        }

        return Helper.getJavaType(Object.class);
    }

    public static String parametersToAsm(Collection<CodeParameter> codeParameters) {
        return codeTypesToFullAsm(codeParameters.stream().map(CodeParameter::getType).toArray(CodeType[]::new));
    }

    public static String argumentssToAsm(Collection<CodeArgument> codeArguments) {
        return codeTypesToFullAsm(codeArguments.stream().map(CodeArgument::getType).toArray(CodeType[]::new));
    }
}
