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
package com.github.jonathanxd.codeapi.gen.visit;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.exceptions.ProcessingException;
import com.github.jonathanxd.codeapi.gen.ArrayAppender;
import com.github.jonathanxd.codeapi.gen.CodeGenerator;
import com.github.jonathanxd.codeapi.sugar.SugarSyntax;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.type.TypeInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * A visit based generator.
 */
public abstract class VisitorGenerator<T> implements CodeGenerator<T[]> {

    public static final TypeInfo<ArrayAppender> APPENDER_REPRESENTATION =
            TypeInfo.of(ArrayAppender.class).setUnique(true).build();
    public static final TypeInfo<VisitorGenerator> VISITOR_REPRESENTATION =
            TypeInfo.a(VisitorGenerator.class).setUnique(true).build();

    private final Map<Class<?>, Visitor<?, T, ?>> visitors = new HashMap<>();

    /**
     * Add a visitor.
     *
     * @param cClass    Type of part.
     * @param ctVisitor Visitor.
     * @param <C>       Type of part.
     */
    public <C extends CodePart> void addVisitor(Class<C> cClass, Visitor<? extends C, T, ?> ctVisitor) {
        this.visitors.put(cClass, ctVisitor);
    }

    /**
     * Add a visitor.
     *
     * @param cClass    Type of part.
     * @param ctVisitor Visitor.
     * @param <C>       Type of part.
     */
    public <C extends CodePart> void addSuperVisitor(Class<C> cClass, Visitor<? super C, T, ?> ctVisitor) {
        this.visitors.put(cClass, ctVisitor);
    }

    /**
     * Added a unchecked visitor.
     *
     * @param cClass    Type of part.
     * @param ctVisitor Visitor.
     */
    public void addUncheckedVisitor(Class<?> cClass, Visitor<?, T, ?> ctVisitor) {
        this.visitors.put(cClass, ctVisitor);
    }

    /**
     * Create data.
     *
     * @return Data.
     */
    protected abstract MapData makeData();

    @Override
    public <V extends CodePart, R extends CodePart> SugarSyntax<?, ?> registerSugarSyntax(Class<V> type, SugarSyntax<V, R> sugarSyntax) {

        SugarSyntax<?, ?> syntax = null;

        if (this.visitors.containsKey(type)) {
            Visitor<?, T, ?> tVisitor = this.visitors.get(type);

            if (tVisitor instanceof SugarSyntaxVisitor<?, ?, ?>) {
                syntax = ((SugarSyntaxVisitor<?, ?, ?>) tVisitor).getSugarSyntax();
            }

        }

        this.addVisitor(type, new SugarSyntaxVisitor<>(sugarSyntax));

        return syntax;
    }

    @Override
    public T[] gen(CodeSource source) {

        MapData extraData = makeData();

        return this.gen(source, extraData, null);
    }

    public T[] gen(CodeSource source, MapData data, Object additional) {

        ArrayAppender<T> appender = createAppender();

        data.registerData(APPENDER_REPRESENTATION, appender);

        data.registerData(VISITOR_REPRESENTATION, this);

        this.generateTo(CodeSource.class, source, data, appender::add, additional);

        data.unregisterData(APPENDER_REPRESENTATION, appender);

        data.unregisterData(VISITOR_REPRESENTATION, this);


        return appender.get();
    }

    /**
     * Create appender.
     *
     * @return Appender.
     */
    public abstract ArrayAppender<T> createAppender();

    /**
     * Visit part.
     *
     * @param partClass  Type of visitor part.
     * @param codePart   Part.
     * @param extraData  Data.
     * @param additional Additional object.
     * @return Result objects.
     */
    public T[] generateTo(Class<? extends CodePart> partClass, CodePart codePart, MapData extraData, Object additional) {
        return this.generateTo(partClass, codePart, extraData, null, additional);
    }

    /**
     * Visit part.
     *
     * @param partClass  Type of visitor part.
     * @param codePart   Part.
     * @param extraData  Data.
     * @param consumer   Consumer
     * @param additional Additional object.
     * @return Result objects.
     */
    public T[] generateTo(Class<? extends CodePart> partClass, CodePart codePart, MapData extraData, Consumer<T[]> consumer, Object additional) {
        try {
            Visitor<?, T, ?> tVisitor = get(partClass);

            T[] visit = visit(tVisitor, codePart, extraData, additional);

            if (consumer != null)
                consumer.accept(visit);

            endVisit(tVisitor, visit, codePart, extraData, additional);

            return visit;
        } catch (Throwable t) {
            if (t instanceof ProcessingException)
                throw t;

            throw new ProcessingException("Error while processing type: '" + partClass + "', Part: '" + codePart + "'.", t);
        }
    }

    @SuppressWarnings("unchecked")
    private <L extends CodePart, D> T[] visit(Visitor<L, T, D> visitor, Object value, MapData extraData, Object additional) {
        return visitor.visit((L) value, extraData, this, (D) additional);
    }

    @SuppressWarnings("unchecked")
    private <L extends CodePart, D> void endVisit(Visitor<L, T, D> visitor, T[] results, Object value, MapData extraData, Object additional) {
        visitor.endVisit(results, (L) value, extraData, this, (D) additional);
    }

    @SuppressWarnings("unchecked")
    private Visitor<?, T, ?> get(Class<?> cl) {
        if (visitors.containsKey(cl)) {
            return visitors.get(cl);
        } else {
            GenerateTo generateTo = cl.getDeclaredAnnotation(GenerateTo.class);

            if (generateTo != null) {
                return Objects.requireNonNull(visitors.get(generateTo.value()), "Cannot get visitor for class: '" + generateTo.value().getCanonicalName() + "'");
            } else {
                if (cl.isSynthetic() || cl.isAnonymousClass() || cl.isLocalClass()) {
                    Class<?> i;
                    if (cl.getInterfaces().length == 0) {
                        i = cl.getSuperclass();
                    } else {
                        i = cl.getInterfaces()[0];
                    }
                    return Objects.requireNonNull(visitors.get(i), "Cannot get visitor for class: '" + i.getCanonicalName() + "' (Local/Synthetic/Anonymous class): '" + cl + "'");
                }

                throw new IllegalStateException("Cannot get visitor for class: '" + cl.getCanonicalName() + "'");
            }
        }
    }

}
