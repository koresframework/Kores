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
package com.github.jonathanxd.codeapi.util.gen;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.inspect.SourceInspect;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.EnumDeclaration;
import com.github.jonathanxd.codeapi.interfaces.EnumEntry;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.source.CodeArgumentUtil;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

public class EnumUtil {
    public static Collection<CodeModifier> getEnumModifiers(EnumDeclaration enumDeclaration) {
        Collection<CodeModifier> modifiers = new TreeSet<>(enumDeclaration.getModifiers());

        modifiers.add(CodeModifier.ENUM);

        if (enumDeclaration.getEntries().stream().anyMatch(Bodied::hasBody)) {
            modifiers.add(CodeModifier.ABSTRACT);
        } else {
            modifiers.add(CodeModifier.FINAL);
        }

        return modifiers;
    }

    public static CodeSource generateEnumClassSource(EnumDeclaration enumDeclaration) {
        List<FieldDeclaration> fields = new ArrayList<>();
        List<EnumEntry> entries = enumDeclaration.getEntries();
        List<TypeDeclaration> innerClasses = new ArrayList<>();

        MutableCodeSource codeSource = new MutableCodeSource();

        for (int i = 0; i < entries.size(); i++) {
            EnumEntry enumEntry = entries.get(i);
            CodePart value;

            if (enumEntry.hasBody()) {

                TypeDeclaration typeDeclaration = EnumUtil.genEnumInnerClass(enumDeclaration, enumEntry);

                innerClasses.add(typeDeclaration);

                value = EnumUtil.callConstructor(typeDeclaration, enumEntry, i);
            } else {
                value = EnumUtil.callConstructor(enumDeclaration, enumEntry, i);
            }

            fields.add(CodeAPI.field(Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL | CodeModifier.Internal.ENUM, enumDeclaration, enumEntry.getName(),
                    value));
        }

        codeSource.addAll(fields);

        String valuesFieldName = CodeSourceUtil.getNewFieldName("$VALUES", codeSource);

        int fieldSize = fields.size();

        CodeType arrayType = enumDeclaration.toArray(1);

        CodeArgument[] arrayArguments = fields.stream()
                .map(fieldDeclaration -> CodeAPI.argument(CodeAPI.accessStaticField(fieldDeclaration.getVariableType(), fieldDeclaration.getName()), fieldDeclaration.getVariableType()))
                .toArray(CodeArgument[]::new);

        CodeField valuesField = CodeAPI.field(Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL | CodeModifier.Internal.SYNTHETIC, arrayType, valuesFieldName,
                CodeAPI.arrayConstruct(enumDeclaration, new CodePart[]{Literals.INT(fieldSize)}, arrayArguments));

        codeSource.add(valuesField);

        MutableCodeSource source = enumDeclaration.getBody().map(MutableCodeSource::new).orElse(new MutableCodeSource());

        // Gen methods
        fixConstructor(enumDeclaration, source);

        codeSource.addAll(source);

        // Enum.values() method.
        codeSource.add(CodeAPI.methodBuilder()
                .withModifiers(Modifier.PUBLIC | Modifier.STATIC)
                .withName("values")
                .withReturnType(arrayType)
                .withBody(CodeAPI.sourceOfParts(
                        CodeAPI.returnValue(arrayType, CodeAPI.cast(PredefinedTypes.OBJECT, arrayType, CodeAPI.invokeVirtual(arrayType, CodeAPI.accessStaticField(valuesField.getVariableType(), valuesField.getName()),
                                "clone", CodeAPI.typeSpec(PredefinedTypes.OBJECT))))

                ))
                .build());

        // Enum.valueOf(String) method.
        codeSource.add(CodeAPI.methodBuilder()
                .withModifiers(Modifier.PUBLIC | Modifier.STATIC)
                .withName("valueOf")
                .withParameters(CodeAPI.parameter(PredefinedTypes.STRING, "name"))
                .withReturnType(enumDeclaration)
                .withBody(CodeAPI.sourceOfParts(
                        CodeAPI.returnValue(PredefinedTypes.ENUM, CodeAPI.cast(PredefinedTypes.ENUM, enumDeclaration,
                                CodeAPI.invokeStatic(PredefinedTypes.ENUM, "valueOf", CodeAPI.typeSpec(
                                        PredefinedTypes.ENUM,
                                        PredefinedTypes.CLASS,
                                        PredefinedTypes.STRING),
                                        CodeAPI.argument(Literals.CLASS(enumDeclaration)),
                                        CodeAPI.argument(CodeAPI.accessLocalVariable(PredefinedTypes.STRING, "name")))))

                ))
                .build());

        for (TypeDeclaration innerClass : innerClasses) {
            codeSource.add(innerClass);
        }

        return codeSource;
    }

    private static CodePart callConstructor(TypeDeclaration location, EnumEntry enumEntry, int ordinal) {
        Optional<TypeSpec> constructorSpecOpt = enumEntry.getConstructorSpec();

        List<CodeArgument> arguments = new ArrayList<>();

        arguments.add(CodeAPI.argument(Literals.STRING(enumEntry.getName())));
        arguments.add(CodeAPI.argument(Literals.INT(ordinal)));

        TypeSpec spec = new TypeSpec(PredefinedTypes.VOID, PredefinedTypes.STRING, PredefinedTypes.INT);

        if (constructorSpecOpt.isPresent()) {
            TypeSpec typeSpec = constructorSpecOpt.get();

            List<CodeType> parameterTypes = new ArrayList<>(spec.getParameterTypes());

            parameterTypes.addAll(typeSpec.getParameterTypes());

            spec = spec.setParameterTypes(parameterTypes);

            arguments.addAll(enumEntry.getArguments());
        }

        return CodeAPI.invokeConstructor(location, spec, arguments);
    }

    private static void fixConstructor(EnumDeclaration enumDeclaration, MutableCodeSource originalSource) {
        List<ConstructorDeclaration> inspect = SourceInspect.find(codePart -> codePart instanceof ConstructorDeclaration)
                .include(bodied -> bodied instanceof CodeSource)
                .includeSource(true)
                .mapTo(codePart -> (ConstructorDeclaration) codePart)
                .inspect(originalSource);

        if (inspect.isEmpty()) {
            originalSource.add(CodeAPI.constructor(Modifier.PROTECTED | CodeModifier.Internal.SYNTHETIC, CodeAPI.parameters(CodeAPI.parameter(PredefinedTypes.STRING, "name"),
                    CodeAPI.parameter(PredefinedTypes.INT, "ordinal")),
                    ctr -> CodeAPI.sourceOfParts(
                            CodeAPI.invokeSuperConstructor(CodeAPI.constructorTypeSpec(PredefinedTypes.STRING, PredefinedTypes.INT),
                                    CodeAPI.argument(CodeAPI.accessLocalVariable(PredefinedTypes.STRING, "name")),
                                    CodeAPI.argument(CodeAPI.accessLocalVariable(PredefinedTypes.INT, "ordinal")))
                    )));
            // generate
        } else {
            // modify
            for (ConstructorDeclaration constructorDeclaration : inspect) {
                List<CodeParameter> parameters = new ArrayList<>(constructorDeclaration.getParameters());

                String name = CodeSourceUtil.getNewName("$name", parameters);
                String ordinal = CodeSourceUtil.getNewName("$ordinal", parameters);

                parameters.addAll(0, Arrays.asList(
                        CodeAPI.parameter(PredefinedTypes.STRING, name),
                        CodeAPI.parameter(PredefinedTypes.INT, ordinal)));

                MutableCodeSource source = constructorDeclaration.getBody().map(MutableCodeSource::new).orElse(new MutableCodeSource());

                source.add(0, Helper.invokeSuperInit(PredefinedTypes.ENUM,
                        CodeAPI.argument(CodeAPI.accessLocalVariable(PredefinedTypes.STRING, name), PredefinedTypes.STRING),
                        CodeAPI.argument(CodeAPI.accessLocalVariable(PredefinedTypes.INT, ordinal), PredefinedTypes.INT)));

                originalSource.remove(constructorDeclaration);

                originalSource.add(constructorDeclaration.setBody(source).setParameters(parameters));
            }
        }
    }

    private static TypeDeclaration genEnumInnerClass(EnumDeclaration enumDeclaration, EnumEntry enumEntry) {
        Optional<TypeSpec> typeSpecOpt = enumEntry.getConstructorSpec();

        List<CodeParameter> baseParameters = EnumUtil.getEnumBaseParameters("$name", "$ordinal");
        CodeArgument[] arguments;

        if (typeSpecOpt.isPresent()) {
            TypeSpec typeSpec = typeSpecOpt.get();

            List<CodeType> parameterTypes = typeSpec.getParameterTypes();

            for (int i = 0; i < parameterTypes.size(); i++) {
                baseParameters.add(CodeAPI.parameter(parameterTypes.get(i), "$" + i));
            }
        }

        arguments = CodeArgumentUtil.argumentsFromParameters(baseParameters).stream().toArray(CodeArgument[]::new);
        TypeSpec constructorSpec = CodeAPI.constructorTypeSpec(
                baseParameters.stream()
                        .map(CodeParameter::getRequiredType)
                        .toArray(CodeType[]::new)
        );

        String enumEntryName = CodeSourceUtil.getNewInnerName(enumEntry.getName() + "$Inner", enumDeclaration);

        MutableCodeSource body = enumEntry.getBody().orElseThrow(NullPointerException::new).toMutable();

        body.add(CodeAPI.constructorBuilder()
                .withParameters(baseParameters)
                .withBody(CodeAPI.sourceOfParts(
                        CodeAPI.invokeSuperConstructor(constructorSpec, arguments)
                ))
                .build());

        return CodeAPI.aClassBuilder()
                .withOuterClass(enumDeclaration)
                .withModifiers(Modifier.STATIC | CodeModifier.Internal.ENUM)
                .withQualifiedName(enumEntryName)
                .withSuperClass(enumDeclaration)
                .withBody(body)
                .build();
    }

    private static List<CodeParameter> getEnumBaseParameters(String name, String ordinal) {
        return new ArrayList<>(Arrays.asList(
                CodeAPI.parameter(PredefinedTypes.STRING, name),
                CodeAPI.parameter(PredefinedTypes.INT, ordinal)));
    }
}
