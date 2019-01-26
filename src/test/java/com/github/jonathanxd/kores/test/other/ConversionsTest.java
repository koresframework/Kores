package com.github.jonathanxd.kores.test.other;

import com.github.jonathanxd.kores.base.MethodDeclaration;
import com.github.jonathanxd.kores.type.Generic;
import com.github.jonathanxd.kores.type.KoresTypes;
import com.github.jonathanxd.kores.util.conversion.ConversionsKt;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionsTest {

    @Test
    public void testGenericMethodConversion() throws Exception {
        Method test = ConversionsTest.class.getDeclaredMethod("test", List.class);
        MethodDeclaration methodDeclaration = ConversionsKt.toMethodDeclaration(test);

        Assert.assertEquals(Generic.type(List.class).of(Integer.class),
                KoresTypes.getKoresType(methodDeclaration.getReturnType()));

        Assert.assertEquals(1, methodDeclaration.getParameters().size());

        Assert.assertEquals(Generic.type(List.class).of(String.class),
                KoresTypes.getKoresType(methodDeclaration.getParameters().get(0).getType()));
    }


    public List<Integer> test(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
