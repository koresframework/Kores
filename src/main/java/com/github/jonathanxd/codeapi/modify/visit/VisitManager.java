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
package com.github.jonathanxd.codeapi.modify.visit;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.util.gento.GenToUtil;
import com.github.jonathanxd.iutils.data.MapData;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VisitManager<T extends CodePart> {

    private final Map<Class<?>, PartVisitor<?>> partVisitorMap = new HashMap<>();
    private final Map<Class<?>, PartVisitor<?>> partVisitorMap_ = Collections.unmodifiableMap(this.partVisitorMap);

    public <U extends CodePart> void register(Class<U> type, PartVisitor<U> visitor) {
        this.partVisitorMap.put(type, visitor);
    }

    public <U extends CodePart> void registerSuper(Class<U> type, PartVisitor<? super U> visitor) {
        this.partVisitorMap.put(type, visitor);
    }

    public void registerGeneric(Class<?> type, PartVisitor<?> visitor) {
        this.partVisitorMap.put(type, visitor);
    }

    @SuppressWarnings("unchecked")
    public <U extends CodePart> U visit(U part, MapData data) {
        return (U) this.getVisitor(part.getClass()).visit(part, data, this);
    }

    @SuppressWarnings("unchecked")
    public T visit(T part) {
        Class<? extends CodePart> aClass = part.getClass();

        MapData data = new MapData();

        PartVisitor<CodePart> visitor = this.getVisitor(aClass);

        return (T) visitor.visit(part, data, this);
    }

    public Map<Class<?>, PartVisitor<?>> getVisitors() {
        return this.partVisitorMap_;
    }

    @SuppressWarnings("unchecked")
    private <U extends CodePart> PartVisitor<U> getVisitor(Class<?> type) {
        return (PartVisitor<U>) GenToUtil.get(type, this.getVisitors());
    }
}
