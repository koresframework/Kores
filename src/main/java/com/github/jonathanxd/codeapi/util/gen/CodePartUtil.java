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
import com.github.jonathanxd.codeapi.builder.OperateHelper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.OperateImpl;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;

import org.objectweb.asm.Opcodes;

public class CodePartUtil {
    public static boolean isPrimitive(CodePart codePart) {
        if (codePart instanceof Literal) {
            return Literals.isPrimitive((Literal) codePart);
        } else if (codePart instanceof Typed) {
            Typed typed = (Typed) codePart;

            return typed.getType().orElseThrow(() -> new RuntimeException("Cannot determine type of '" + codePart + "'")).isPrimitive();
        } else {
            throw new RuntimeException("Cannot determine type of part '" + codePart + "'!");
        }

    }

    public static CodeType getTypeOrNull(CodePart codePart) {
        if (codePart instanceof Literal) {
            return ((Literal) codePart).getType().orElseThrow(NullPointerException::new);
        } else if (codePart instanceof Typed) {
            Typed typed = (Typed) codePart;

            return typed.getType().orElseThrow(() -> new RuntimeException("Cannot determine type of '" + codePart + "'"));
        } else {
            return null;
        }
    }

    public static CodeType getType(CodePart codePart) {
        CodeType type = CodePartUtil.getTypeOrNull(codePart);

        if (type == null)
            throw new RuntimeException("Cannot determine type of part '" + codePart + "'!");

        return type;
    }

    public static boolean isBoolean(CodePart part) {
        return part instanceof Literals.BoolLiteral;
    }

    public static boolean getBooleanValue(CodePart part) {
        return ((Literals.BoolLiteral) part).getValue();
    }

    public static final class Conversion implements Opcodes {

        private Conversion() {
            throw new IllegalStateException();
        }

        public static boolean isLiteral(Object o) {
            return o instanceof Byte
                    || o instanceof Short
                    || o instanceof Integer
                    || o instanceof Double
                    || o instanceof Float
                    || o instanceof Long
                    || o instanceof String;
        }

        public static Literal toLiteral(Object o) {
            if (o instanceof Byte) {
                return Literals.BYTE((byte) o);
            } else if (o instanceof Short) {
                return Literals.SHORT((short) o);
            } else if (o instanceof Integer) {
                return Literals.INT((int) o);
            } else if (o instanceof Double) {
                return Literals.DOUBLE((double) o);
            } else if (o instanceof Float) {
                return Literals.FLOAT((float) o);
            } else if (o instanceof Long) {
                return Literals.LONG((long) o);
            } else if (o instanceof String) {
                return Literals.STRING((String) o);
            } else {
                throw new IllegalArgumentException("Cannot convert '" + o + "' to Literal.");
            }
        }

        public static CodePart handleReturn(int opcode, CodePart input) {

            if (opcode == RETURN) // No computation is needed for void return.
                return CodeAPI.returnValue(PredefinedTypes.VOID, null);

            // Note that Java bytecode cover a limited set of types, is better to CodeAPI infer the types
            // Example, types like Boolean, Character, Short, etc... is covered by IRETURN
            // and CodeAPI works better with the original types (CodeAPI don't like if you
            // return a boolean value using INT type like: CodeAPI.returnValue(PredefinedTypes.INT, Literals.FALSE)).
            CodeType type = input != null ? CodePartUtil.getTypeOrNull(input) : null;

            if (type == null) {
                switch (opcode) {
                    case IRETURN: {
                        type = PredefinedTypes.INT;
                        break;
                    }

                    case LRETURN: {
                        type = PredefinedTypes.LONG;
                        break;
                    }

                    case FRETURN: {
                        type = PredefinedTypes.FLOAT;
                        break;
                    }

                    case DRETURN: {
                        type = PredefinedTypes.DOUBLE;
                        break;
                    }

                    case ARETURN: {
                        type = PredefinedTypes.OBJECT;
                        break;
                    }

                    default: {
                        throw new IllegalArgumentException("Cannot handle return opcode: '" + opcode + "'");
                    }
                }
            }

            return CodeAPI.returnValue(type, input);
        }

        public static CodePart handleMathAndBitwise(int opcode, CodePart input1, CodePart input2) {
            Operator operation;

            if (opcode >= IADD && opcode <= DADD) {
                operation = Operators.ADD;
            } else if (opcode >= ISUB && opcode <= DSUB) {
                operation = Operators.SUBTRACT;
            } else if (opcode >= IMUL && opcode <= DMUL) {
                operation = Operators.MULTIPLY;
            } else if (opcode >= IDIV && opcode <= DDIV) {
                operation = Operators.DIVISION;
            } else if (opcode >= IREM && opcode <= DREM) {
                operation = Operators.REMAINDER;
            } else if (opcode >= ISHL && opcode <= LSHL) {
                operation = Operators.SIGNED_LEFT_SHIFT;
            } else if (opcode >= ISHR && opcode <= LSHR) {
                operation = Operators.SIGNED_RIGHT_SHIFT;
            } else if (opcode >= IUSHR && opcode <= LUSHR) {
                operation = Operators.UNSIGNED_RIGHT_SHIFT;
            } else if (opcode >= IAND && opcode <= LAND) {
                operation = Operators.BITWISE_AND;
            } else if (opcode >= IOR && opcode <= LOR) {
                operation = Operators.BITWISE_INCLUSIVE_OR;
            } else if (opcode >= IXOR && opcode <= LXOR) {
                operation = Operators.BITWISE_EXCLUSIVE_OR;
            } else {
                throw new IllegalArgumentException("Cannot handle math or bitwise opcode: '" + opcode + "'");
            }

            return new OperateImpl(input1, operation, input2);
        }

        public static CodePart handleNegation(int opcode, CodePart input) {
            return OperateHelper.builder(input)
                    .neg()
                    .build();
        }

        public static CodePart handleConversion(int opcode, CodePart input) {
            CodeType from;
            CodeType to;

            switch (opcode) {
                case I2L: {
                    from = PredefinedTypes.INT;
                    to = PredefinedTypes.LONG;
                    break;// TODO START
                }
                case I2F: {
                    from = PredefinedTypes.INT;
                    to = PredefinedTypes.FLOAT;
                    break;
                }
                case I2D: {
                    from = PredefinedTypes.INT;
                    to = PredefinedTypes.DOUBLE;
                    break;
                }
                case L2I: {
                    from = PredefinedTypes.LONG;
                    to = PredefinedTypes.INT;
                    break;
                }
                case L2F: {
                    from = PredefinedTypes.LONG;
                    to = PredefinedTypes.FLOAT;
                    break;
                }
                case L2D: {
                    from = PredefinedTypes.LONG;
                    to = PredefinedTypes.DOUBLE;
                    break;
                }
                case F2I: {
                    from = PredefinedTypes.FLOAT;
                    to = PredefinedTypes.INT;
                    break;
                }
                case F2L: {
                    from = PredefinedTypes.FLOAT;
                    to = PredefinedTypes.LONG;
                    break;
                }
                case F2D: {
                    from = PredefinedTypes.FLOAT;
                    to = PredefinedTypes.DOUBLE;
                    break;
                }
                case D2I: {
                    from = PredefinedTypes.DOUBLE;
                    to = PredefinedTypes.INT;
                    break;
                }
                case D2L: {
                    from = PredefinedTypes.DOUBLE;
                    to = PredefinedTypes.LONG;
                    break;
                }
                case D2F: {
                    from = PredefinedTypes.DOUBLE;
                    to = PredefinedTypes.FLOAT;
                    break;
                }
                case I2B: {
                    from = PredefinedTypes.INT;
                    to = PredefinedTypes.BOOLEAN;
                    break;
                }
                case I2C: {
                    from = PredefinedTypes.INT;
                    to = PredefinedTypes.CHAR;
                    break;
                }
                case I2S: {
                    from = PredefinedTypes.INT;
                    to = PredefinedTypes.SHORT;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Cannot handle conversion opcode: '" + opcode + "'!");
                }
            }

            return CodeAPI.cast(from, to, input);
        }
    }
}
