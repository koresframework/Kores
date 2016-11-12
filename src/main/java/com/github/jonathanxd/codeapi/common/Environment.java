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

import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.PlainCodeType;
import com.github.jonathanxd.codeapi.util.SimpleResolver;
import com.github.jonathanxd.codeapi.util.TypeResolver;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.HashMap;
import java.util.Map;

/**
 * Bytecode reading environment
 *
 * Helper class.
 */
public class Environment implements TypeResolver {

    private final TypeResolver typeResolver = new SimpleResolver(this::getType, false);

    private final MapData data = new MapData();
    private final Map<String, CodeType> types = new HashMap<>();

    public MapData getData() {
        return this.data;
    }

    public CodeType getType(String str) {
        return this.getType(str, false);
    }

    public CodeType getType(String str, boolean isInterface) {
        return this.getType0(str, isInterface);
    }

    private CodeType getType0(String str, boolean isInterface) {

        final CodeType type;

        Map<String, CodeType> types = this.getTypes();

        if (types.containsKey(str)) {
            type = types.get(str);
        } else {

            Class<?> aClass;

            if ((aClass = this.check(str)) != null) {
                type = Helper.getJavaType(aClass);
            } else {
                type = new BytecodeCodeType(str, isInterface);
            }

            types.put(str, type);
        }

        if (type instanceof BytecodeCodeType) {
            if (!type.isInterface() && isInterface) {
                ((BytecodeCodeType) type).setInterface(true);
            }
        }



        return type;
    }

    private Class<?> check(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public CodeType resolveUnknown(String name) {
        return this.getTypeResolver().resolveUnknown(name);
    }

    @Override
    public CodeType resolve(String name, boolean isInterface) {
        return this.getTypeResolver().resolve(name, isInterface);
    }

    @Override
    public CodeType resolveInterface(String type) {
        return this.getTypeResolver().resolveInterface(type);
    }

    @Override
    public CodeType resolveClass(String type) {
        return this.getTypeResolver().resolveClass(type);
    }

    public TypeResolver getTypeResolver() {
        return this.typeResolver;
    }

    protected Map<String, CodeType> getTypes() {
        return this.types;
    }

    static class BytecodeCodeType extends PlainCodeType {

        private boolean isInterface;

        public BytecodeCodeType(String canonicalName) {
            super(canonicalName);
            this.isInterface = false;
        }

        public BytecodeCodeType(String canonicalName, boolean isInterface) {
            super(canonicalName, isInterface);
            this.isInterface = isInterface;
        }

        @Override
        public boolean isInterface() {
            return this.isInterface;
        }

        public void setInterface(boolean anInterface) {
            this.isInterface = anInterface;
        }

        @Override
        public boolean equals(Object obj) {

            if(obj instanceof CodeType)
                return this.compareTo((CodeType) obj) == 0;

            return super.equals(obj);
        }
    }
}
