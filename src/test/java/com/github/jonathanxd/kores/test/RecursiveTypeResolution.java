package com.github.jonathanxd.kores.test;

import com.github.jonathanxd.iutils.object.Either;
import com.github.jonathanxd.kores.base.FieldDeclaration;
import com.github.jonathanxd.kores.type.KoresTypes;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class RecursiveTypeResolution {

    @Test
    public void comparableRecursion() {
        Class<?> map = Map.class;
        // Could cause StackOverflowError if not treated correctly.
        Either<Exception, List<FieldDeclaration>> fieldResolution =
                KoresTypes.getKoresType(map).getBindedDefaultResolver().resolveFields();
    }

}
