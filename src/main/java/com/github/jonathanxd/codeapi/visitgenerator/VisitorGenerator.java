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
package com.github.jonathanxd.codeapi.visitgenerator;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.Result;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.exceptions.ProcessingException;
import com.github.jonathanxd.codeapi.interfaces.TagLine;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.iterator.Navigator;
import com.github.jonathanxd.iutils.object.AbstractTypeInfo;
import com.github.jonathanxd.iutils.object.TypeInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * A visit based generator.
 */
public abstract class VisitorGenerator<T> implements CodeGenerator<T> {

    public static final TypeInfo<Appender> APPENDER_REPRESENTATION =
            TypeInfo.of(Appender.class).setUnique(true).build();
    public static final TypeInfo<VisitorGenerator> VISITOR_REPRESENTATION =
            TypeInfo.a(VisitorGenerator.class).setUnique(true).build();
    public static final TypeInfo<TagLine<?, ?>> LINES_REPRESENTATION =
            new AbstractTypeInfo<TagLine<?, ?>>(true) {
            };

    private final Map<Class<?>, Visitor<?, T, ?>> visitors = new HashMap<>();

    /**
     * Add a visitor.
     *
     * @param cClass    Type of part.
     * @param ctVisitor Visitor.
     * @param <C>       Type of part.
     */
    public <C extends CodePart> void addVisitor(Class<C> cClass, Visitor<? extends C, T, ?> ctVisitor) {
        visitors.put(cClass, ctVisitor);
    }

    /**
     * Add a visitor.
     *
     * @param cClass    Type of part.
     * @param ctVisitor Visitor.
     * @param <C>       Type of part.
     */
    public <C extends CodePart> void addSuperVisitor(Class<C> cClass, Visitor<? super C, T, ?> ctVisitor) {
        visitors.put(cClass, ctVisitor);
    }

    /**
     * Added a unchecked visitor.
     *
     * @param cClass    Type of part.
     * @param ctVisitor Visitor.
     */
    public void addUncheckedVisitor(Class<?> cClass, Visitor<?, T, ?> ctVisitor) {
        visitors.put(cClass, ctVisitor);
    }

    /**
     * Create data.
     *
     * @return Data.
     */
    protected abstract MapData makeData();

    @Override
    public Result<T[]> gen(CodeSource source) {

        MapData extraData = makeData();

        Appender<T> appender = createAppender();

        extraData.registerData(APPENDER_REPRESENTATION, appender);

        extraData.registerData(VISITOR_REPRESENTATION, this);


        for (int i = 0; i < source.size(); i++) {
            CodePart codePart = source.get(i);

            Navigator<CodePart> nav = new Nav(source);

            nav.navigateTo(i);

            Class<? extends CodePart> aClass = codePart.getClass();


            generateTo(aClass, codePart, extraData, nav, appender::addAll, null);


        }


        return new Result<>(appender.get(), extraData);
    }

    /**
     * Create appender.
     *
     * @return Appender.
     */
    public abstract Appender<T> createAppender();

    /**
     * Visit part.
     *
     * @param partClass  Type of visitor part.
     * @param codePart   Part.
     * @param extraData  Data.
     * @param nav        Navigator.
     * @param additional Additional object.
     */
    public void generateTo(Class<? extends CodePart> partClass, CodePart codePart, MapData extraData, Navigator<CodePart> nav, Object additional) {
        this.generateTo(partClass, codePart, extraData, nav, null, additional);
    }

    /**
     * Visit part.
     *
     * @param partClass  Type of visitor part.
     * @param codePart   Part.
     * @param extraData  Data.
     * @param nav        Navigator.
     * @param consumer   Consumer
     * @param additional Additional object.
     */
    public void generateTo(Class<? extends CodePart> partClass, CodePart codePart, MapData extraData, Navigator<CodePart> nav, Consumer<T[]> consumer, Object additional) {
        try {
            Visitor<?, T, ?> tVisitor = get(partClass);

            T[] visit = visit(tVisitor, codePart, extraData, nav, additional);

            if (consumer != null)
                consumer.accept(visit);

            endVisit(tVisitor, visit, codePart, extraData, nav, additional);
        } catch (Throwable t) {
            if (t instanceof ProcessingException)
                throw t;

            new ProcessingException("Error while processing type: '" + partClass + "', Part: '" + codePart + "'.", t).printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private <L extends CodePart, D> T[] visit(Visitor<L, T, D> visitor, Object value, MapData extraData, Navigator<CodePart> tNavigator, Object additional) {
        return visitor.visit((L) value, extraData, tNavigator, this, (D) additional);
    }

    @SuppressWarnings("unchecked")
    private <L extends CodePart, D> void endVisit(Visitor<L, T, D> visitor, T[] results, Object value, MapData extraData, Navigator<CodePart> tNavigator, Object additional) {
        visitor.endVisit(results, (L) value, extraData, tNavigator, this, (D) additional);
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
                if (cl.isSynthetic()) {
                    Class<?> i = cl.getInterfaces()[0];
                    return Objects.requireNonNull(visitors.get(i), "Cannot get visitor for class: '" + i.getCanonicalName() + "'");
                }
                throw new IllegalStateException("Cannot get visitor for class: '" + cl.getCanonicalName() + "'");
            }
        }
    }

    public static final class Nav implements Navigator<CodePart> {

        final CodeSource source;
        int pos = 0;

        public Nav(CodeSource source) {
            this.source = source;
        }

        @Override
        public boolean has(int i) {
            return i < source.size();
        }

        @Override
        public CodePart navigateTo(int i) {
            pos = i;
            return currentValue();
        }

        @Override
        public CodePart currentValue() {
            return source.get(pos);
        }

        @Override
        public void goNextWhen(Predicate<CodePart> predicate) {
            while (has(pos) && predicate.test(currentValue())) {
                ++pos;
            }
        }

        @Override
        public int currentIndex() {
            return pos;
        }

        @Override
        public List<CodePart> collect(int to) {

            int currentIndex = pos;

            List<CodePart> list = new ArrayList<>();

            to += currentIndex;

            do {
                list.add(source.get(currentIndex));
                ++currentIndex;
            } while (this.has(currentIndex) && currentIndex < to);

            return list;
        }
    }
}
