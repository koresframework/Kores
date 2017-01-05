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
package com.github.jonathanxd.codeapi;

import com.github.jonathanxd.codeapi.builder.ConcatHelper;
import com.github.jonathanxd.codeapi.builder.OperateHelper;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.FullInvokeSpec;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.PlainCodeType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory class.
 *
 * Is highly recommended to use Builders instead of factory methods, because the documentation of
 * this class isn't complete.
 */
public final class CodeAPI {

    // =========================================================
    //          Parameters
    // =========================================================

    /**
     * Create a {@link CodeParameter parameter}.
     *
     * @param type Parameter value type.
     * @param name Name of the parameter.
     * @return {@link CodeParameter} instance.
     */
    public static CodeParameter parameter(CodeType type, String name) {
        return new CodeParameter(type, name);
    }

    /**
     * Create a {@link CodeParameter parameter}.
     *
     * @param type Parameter value type.
     * @param name Name of the parameter.
     * @return {@link CodeParameter} instance.
     */
    public static CodeParameter parameter(Class<?> type, String name) {
        return new CodeParameter(Helper.getJavaType(type), name);
    }

    // =========================================================
    //          Arguments
    // =========================================================

    /**
     * Create an {@link CodeArgument argument}.
     *
     * @param value Value of argument.
     * @return {@link CodeArgument} instance.
     */
    public static CodeArgument argument(CodePart value) {
        return new CodeArgument(value);
    }

    /**
     * Create an {@link CodeArgument argument}.
     *
     * @param value Value of argument.
     * @param type  Type of argument value.
     * @return {@link CodeArgument} instance.
     */
    public static CodeArgument argument(CodePart value, CodeType type) {
        return new CodeArgument(value, type);
    }

    /**
     * Create an {@link CodeArgument argument}.
     *
     * @param value Value of argument.
     * @param type  Type of argument value.
     * @return {@link CodeArgument} instance.
     */
    public static CodeArgument argument(CodePart value, Class<?> type) {
        return new CodeArgument(value, Helper.getJavaType(type));
    }

    // =========================================================
    //          Method Spec
    // =========================================================

    /**
     * Specification of a method.
     *
     * @param location       Localization of method.
     * @param returnType     Return type of the method.
     * @param methodName     Name of the method.
     * @param parameterTypes Parameter types of the method.
     * @return Specification of a method.
     */
    public static FullMethodSpec fullMethodSpec(CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return fullMethodSpec__factory(location, returnType, methodName, parameterTypes);
    }

    /**
     * Specification of a method.
     *
     * @param location       Localization of method.
     * @param returnType     Return type of the method.
     * @param methodName     Name of the method.
     * @param parameterTypes Parameter types of the method.
     * @return Specification of a method.
     */
    public static FullMethodSpec fullMethodSpec(Class<?> location, Class<?> returnType, String methodName, Class<?>... parameterTypes) {
        return fullMethodSpec__factory(toCodeType(location), toCodeType(returnType), methodName, toCodeType(parameterTypes));
    }

    // Factory
    private static FullMethodSpec fullMethodSpec__factory(CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return new FullMethodSpec(location, returnType, methodName, parameterTypes);
    }

    // =========================================================
    //          Invoke Spec
    // =========================================================

    /**
     * Specification of a method to invoke.
     *
     * @param invokeType     Invocation type.
     * @param location       Localization of method.
     * @param returnType     Return type of the method.
     * @param methodName     Name of the method.
     * @param parameterTypes Parameter types of the method.
     * @return Specification of a method.
     */
    public static FullInvokeSpec fullInvokeSpec(InvokeType invokeType, CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return fullInvokeSpec__factory(invokeType, location, returnType, methodName, parameterTypes);
    }

    /**
     * Specification of a method to invoke.
     *
     * @param invokeType     Invocation type.
     * @param location       Localization of method.
     * @param returnType     Return type of the method.
     * @param methodName     Name of the method.
     * @param parameterTypes Parameter types of the method.
     * @return Specification of a method.
     */
    public static FullInvokeSpec fullInvokeSpec(InvokeType invokeType, Class<?> location, Class<?> returnType, String methodName, Class<?>... parameterTypes) {
        return fullInvokeSpec__factory(invokeType, toCodeType(location), toCodeType(returnType), methodName, toCodeType(parameterTypes));
    }

    // Factory
    private static FullInvokeSpec fullInvokeSpec__factory(InvokeType invokeType, CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return new FullInvokeSpec(invokeType, location, returnType, methodName, parameterTypes);
    }

    /**
     * Plain code type.
     *
     * @param name        Name of the type.
     * @param isInterface Is the type an interface.
     * @return {@link PlainCodeType Plain Code Type} representation.
     */
    public static PlainCodeType plainType(String name, boolean isInterface) {
        return new PlainCodeType(name, isInterface);
    }

    /**
     * Plain interface code type.
     *
     * @param name Name of the type.
     * @return {@link PlainCodeType Plain Code Type} representation.
     */
    public static PlainCodeType plainInterfaceType(String name) {
        return new PlainCodeType(name, true);
    }

    /**
     * Plain class code type.
     *
     * @param name Name of the type.
     * @return {@link PlainCodeType Plain Code Type} representation.
     */
    public static PlainCodeType plainClassType(String name) {
        return new PlainCodeType(name, false);
    }

    /**
     * Convert Java {@link Class class} to CodeAPI {@link CodeType type}.
     *
     * @param aClass Class to convert.
     * @return Converted type.
     */
    public static CodeType toCodeType(Class<?> aClass) {
        return Helper.getJavaType(aClass);
    }

    /**
     * Convert Java {@link Class classes} to CodeAPI {@link CodeType types}.
     *
     * @param aClass Classes to convert.
     * @return Converted types.
     */
    public static CodeType[] toCodeType(Class<?>[] aClass) {
        return Arrays.stream(aClass).map(Helper::getJavaType).toArray(CodeType[]::new);
    }

    public static CodeArgument[] arguments(CodeArgument... arguments) {
        return arguments;
    }

    public static CodeParameter[] parameters(CodeParameter... parameters) {
        return parameters;
    }

    public static CodeType[] types(CodeType... types) {
        return types;
    }

    public static Class<?>[] types(Class<?>... types) {
        return types;
    }

    public static ConcatHelper concatHelper() {
        return ConcatHelper.builder();
    }

    public static ConcatHelper concatHelper(CodePart part) {
        return ConcatHelper.builder(part);
    }

    public static ConcatHelper concatHelper(String str) {
        return ConcatHelper.builder(str);
    }

    public static ConcatHelper concatHelper(CodePart... part) {
        if (part.length == 0)
            return ConcatHelper.builder();

        ConcatHelper helper = ConcatHelper.builder(part[0]);

        for (int i = 1; i < part.length; i++) {
            helper = helper.concat(part[i]);
        }

        return helper;
    }

    public static ConcatHelper concatHelper(String... strs) {
        if (strs.length == 0)
            return ConcatHelper.builder();

        ConcatHelper helper = ConcatHelper.builder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            helper = helper.concat(strs[i]);
        }

        return helper;
    }

    public static ConcatHelper concatHelperObj(Object... objs) {
        if (objs.length == 0)
            return ConcatHelper.builder();

        ConcatHelper helper;

        Object at0 = objs[0];

        if (at0 instanceof CodePart) {
            helper = ConcatHelper.builder((CodePart) at0);
        } else if (at0 instanceof String) {
            helper = ConcatHelper.builder((String) at0);
        } else {
            throw new IllegalArgumentException("Invalid element type at index 0 (" + at0 + ") in array: '" + Arrays.toString(objs) + "'! Acceptable types: String|CodePart");
        }

        for (int i = 1; i < objs.length; i++) {
            Object atI = objs[i];
            if (at0 instanceof CodePart) {
                helper = helper.concat((CodePart) atI);
            } else if (at0 instanceof String) {
                helper = helper.concat((String) atI);
            } else {
                throw new IllegalArgumentException("Invalid element type at index " + i + " (" + atI + ") in array: '" + Arrays.toString(objs) + "'! Acceptable types: String|CodePart");
            }

        }

        return helper;
    }

    public static OperateHelper operateHelper(CodePart part) {
        return OperateHelper.builder(part);
    }

    /**
     * Helper method to create maps.
     *
     * @param objects Objects (Key and values).
     * @return Map of keys and values.
     */
    public static Map<String, Object> values(Object... objects) {
        Map<String, Object> map = new HashMap<>();

        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("Input must be odd (Pair of String and Object)");
        }

        for (int i = 0; i < objects.length; i += 2) {
            map.put((String) objects[i], objects[i + 1]);
        }

        return map;
    }


}
